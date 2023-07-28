package commons.database.requests;

import io.qameta.allure.Step;

import java.sql.*;

import static commons.database.data.DatabaseData.*;

public class AcsFetchNumber {
    private static final String SELECT_LAST_REGISTERED_PHONE_NUMBER_QUERY = "select * from person where person.accountname like ? and length(accountname)=12 order by accountname desc limit 1",
            SELECT_LAST_UNIQUE_NUMBER = "SELECT o.account, o.project_name, o.created_at, o.process_status " +
                    "FROM onboarding o JOIN " +
                    "(SELECT account FROM onboarding GROUP BY account HAVING COUNT(*) = 1) " +
                    "subquery ON o.account = subquery.account WHERE o.project_name=? and o.process_status='SUCCESS' ORDER BY o.created_at DESC limit 1;",
            SELECT_LAST_AUTOAPPROVE_NUMBER = "SELECT account, project_name, created_at, process_status FROM onboarding o WHERE project_name=? and process_status='SUCCESS' and modified_by='SYS_SCHEDULE_EXECUTOR' ORDER BY created_at DESC limit 1;";
    @Step("Fetch the last registered phone number")
    public static String lastRegisteredPhoneNumber(String phoneNumberTemplate) {
        String accountname = null;
        System.out.println(phoneNumberTemplate);
        try (Connection connection = DriverManager.getConnection(acsTestUrl, user, password);
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
        try (Connection connection = DriverManager.getConnection(onboardingTestUrl, user, password);
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

    @Step("Fetch the unique phone number of the given project")
    public static String lastAutoApprovedPhoneNumber(String projectName) {
        String account = null;
        try (Connection connection = DriverManager.getConnection(onboardingTestUrl, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAST_AUTOAPPROVE_NUMBER)) {
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
