package commons.database.requests;

import commons.database.config.DatabaseConnectConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AcsFetchNumber {
    public static DatabaseConnectConfig databaseConnectConfig = ConfigFactory.create(DatabaseConnectConfig.class,
            System.getProperties());

    private static final String SELECT_LAST_REGISTERED_PHONE_NUMBER_QUERY = "select * from person where person.accountname like ? and length(accountname)=12 " +
            "order by accountname desc limit 1",
            SELECT_LAST_UNIQUE_NUMBER = "SELECT o.account, o.project_name, o.created_at, o.process_status " +
                    "FROM onboarding o JOIN " +
                    "(SELECT account FROM onboarding GROUP BY account HAVING COUNT(*) = 1) " +
                    "subquery ON o.account = subquery.account WHERE o.project_name=? and o.process_status='SUCCESS' ORDER BY o.created_at DESC limit 1;",
            SELECT_LAST_AUTOAPPROVE_NUMBER = "SELECT o.account, o.modified_at, o.process_status, o.broker, c.username, c.score" +
                    "FROM onboarding o join card_name_matching c on o.account = c.username" +
                    "WHERE process_status='SUCCESS' and broker not like '0001%' and c.score>0.8 and account like '+7%' ORDER BY created_at DESC;",
        SELECT_IPO_APPROVED_NUMBER =  "SELECT distinct account, modified_at, process_status, broker " +
                "FROM onboarding WHERE process_status='SUCCESS' and project_name not in ('CSDC') and broker='D06' and account like '+7%' and LENGTH(account)=12 " +
                "ORDER BY modified_at DESC",
            SELECT_TABYS_APPROVED_NUMBER = "SELECT o.account, o.modified_at, o.process_status, c.username, c.score " +
                    "FROM onboarding o join card_name_matching c on o.account = c.username " +
                    "WHERE process_status='SUCCESS' and broker='000193644' and c.score>0.8 and account like '+7%' " +
                    "ORDER BY created_at DESC limit 1;",

    // select only the last approved_at_broker record for each owner_username with "actual"="true" that would satisfy the requirements: "broker"="D0". Exclude the columns that contain the value: card_type="KASPI"
    SELECT_ALL_NUMBERS_WITH_CNP_CARD = "WITH RankedRecords AS ( " +
            "    SELECT " +
            "        owner_username, " +
            "        approved_at_broker, " +
            "        broker, " +
            "        actual, " +
            "        card_type, " +
            "        ROW_NUMBER() OVER (PARTITION BY owner_username ORDER BY approved_at_broker DESC) AS rn " +
            "    FROM " +
            "        card " +
            "    WHERE " +
            "            broker = 'D06' " +
            "      AND approved_at_broker is not null " +
            ") " +
            "SELECT " +
            "    owner_username, " +
            "    approved_at_broker, " +
            "    broker, " +
            "    actual " +
            "    card_type " +
            "FROM " +
            "    RankedRecords " +
            "WHERE " +
            "        rn = 1 " +
            "  AND actual = true " +
            "  AND card_type <> 'KASPI' " +
            "ORDER BY approved_at_broker desc;";

    @Step("Fetch the last registered phone number")
    public static String lastRegisteredPhoneNumber(String phoneNumberTemplate) {
        String accountname = null;
        System.out.println(phoneNumberTemplate);
        try (Connection connection = DriverManager.getConnection(
                databaseConnectConfig.acsTestUrl(), databaseConnectConfig.user(), databaseConnectConfig.password());
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAST_REGISTERED_PHONE_NUMBER_QUERY)) {
            preparedStatement.setString(1, phoneNumberTemplate+"%"); // first ? mark value = phoneNumberTemplate
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object
            while (rs.next()) {
                accountname = rs.getString("accountname");
                String application = rs.getString("application");
                String createddate = rs.getString("createddate");
                System.out.println(accountname + "," + application + "," + createddate);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return accountname;
    }

    @Step("Fetch the unique phone number of the given project")
    public static String lastUniquePhoneNumber(String projectName) {
        String account = null;
        try (Connection connection = DriverManager.getConnection(
                databaseConnectConfig.onboardingTestUrl(), databaseConnectConfig.user(), databaseConnectConfig.password());
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAST_UNIQUE_NUMBER)) {
            preparedStatement.setString(1, projectName); // first ? mark value = phoneNumberTemplate
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object
            while (rs.next()) {
                account = rs.getString("account");
                String projectname = rs.getString("project_name");
                String createdAt = rs.getString("created_at");
                System.out.println(account + "," + projectname + "," + createdAt);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return account;
    }

//    @Step("Fetch the unique phone number of the given project")
//    public static String lastCsdAutoApprovedPhoneNumber(String projectName) {
//        String account = null;
//        try (Connection connection = DriverManager.getConnection(onboardingTestUrl, user, password);
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAST_AUTOAPPROVE_NUMBER)) {
////            preparedStatement.setString(1, projectName); // first ? mark value = phoneNumberTemplate
//            System.out.println(preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Process the ResultSet object
//            while (rs.next()) {
//                account = rs.getString("account");
//                String modifiedAt = rs.getString("modified_at");
//                String score = rs.getString("score");
//                System.out.println(account + "," + modifiedAt + ","+ score);
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return account;
//    }

    @Step("Fetch the unique phone number of the given project")
    public static String lastTabysApprovedPhoneNumber() {
        String account = null;
        try (Connection connection = DriverManager.getConnection(
                databaseConnectConfig.onboardingTestUrl(), databaseConnectConfig.user(), databaseConnectConfig.password());
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TABYS_APPROVED_NUMBER)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object
            while (rs.next()) {
                account = rs.getString("account");
                String modifiedAt = rs.getString("modified_at");
                String score = rs.getString("score");
                System.out.println(account + "," + modifiedAt + ","+ score);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return account;
    }

    @Step("Fetch the unique phone number IPO without outstanding orders (IPO and withdrawal)")
    public static String lastCsdPhoneNumberWithoutOrders(List<String> numbersWithCsdOrders, String projectName) {
        String account = null;
        try (Connection connection = DriverManager.getConnection(
                databaseConnectConfig.onboardingTestUrl(), databaseConnectConfig.user(), databaseConnectConfig.password());
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAST_AUTOAPPROVE_NUMBER)) {
//            preparedStatement.setString(1, projectName); // first ? mark value = phoneNumberTemplate
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object
            while (rs.next()) {
                account = rs.getString("account"); // Replace "number_column" with your actual column name
                if (!numbersWithCsdOrders.contains(account)) {
                    return account;
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }

    @Step("Fetch the unique phone number IPO without outstanding orders (IPO and withdrawal)")
    public static String lastIpoPhoneNumberWithoutOrders(List<String> numbersWithCsdOrders, List<String> numbersWithActiveCnpCard, String projectName) {
        String account = null;
        try (Connection connection = DriverManager.getConnection(
                databaseConnectConfig.onboardingTestUrl(), databaseConnectConfig.user(), databaseConnectConfig.password());
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_IPO_APPROVED_NUMBER)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object
            while (rs.next()) {
                account = rs.getString("account");
                String process_status = rs.getString("process_status");
                // If the number fetched from ACS is not in the list of non-eligible numbers, return it immediately
                if ((!numbersWithCsdOrders.contains(account))&&(numbersWithActiveCnpCard.contains(account))) {
                    System.out.println(account + "," + process_status);
                    return account;
                }
                else if ((numbersWithCsdOrders.contains(account))&&(numbersWithActiveCnpCard.contains(account))){
                    System.out.println(account+" rejected, because it has orders");
                } else if (!(numbersWithCsdOrders.contains(account))&&!(numbersWithActiveCnpCard.contains(account))){
                    System.out.println(account+" rejected, because it has no active card");
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }

    @Step("Fetch all the numbers with an approved CNP card")
    public static List<String> allNumbersWithCnpCard() {
        List<String> numbersWithActiveCnpCard = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(
                databaseConnectConfig.acsTestUrl(), databaseConnectConfig.user(), databaseConnectConfig.password());
             // preparing the SQL statement
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NUMBERS_WITH_CNP_CARD)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                // Our result set consists of 2 columns: users with PIPO orders and users with withdrawal orders
                String owner_username = rs.getString("owner_username");
                if (owner_username != null) {
                    // If 1st column value (users with PIPO orders) is not null, then adding it to the list of users with orders
                    numbersWithActiveCnpCard.add(owner_username);
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        System.out.println(numbersWithActiveCnpCard);
        return numbersWithActiveCnpCard;
    }



    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
