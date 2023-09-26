package commons.database.requests;

import commons.database.config.DatabaseConnectConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CashCheckNumber {
    public static DatabaseConnectConfig databaseConnectConfig = ConfigFactory.create(DatabaseConnectConfig.class,
            System.getProperties());
    private static final String SELECT_ALL_NUMBERS_WITH_WITHDRAWAL_ORDERS = "select distinct username from withdraw_request_data where trn_status!='SUCCESS_WDW';",
            SELECT_ALL_NUMBERS_WITH_IPO_ORDERS = "select distinct username from pipo_order_data where status not in ('COMPLETED', 'REJECTED', 'CANCELLED', 'COMPLETED_WITHOUT_KAZPOST_REFUND', 'ERROR');",

    // Selecting all orders that have either IPO or withdrawal orders with not completed statuses (not eligible for update)
            SELECT_ALL_NUMBERS_WITH_CSD_ORDERS = "select distinct pipo.username, withdraw.username from pipo_order_data pipo full join withdraw_request_data withdraw on pipo.username = withdraw.username where pipo.status not in ('COMPLETED', 'REJECTED', 'CANCELLED', 'COMPLETED_WITHOUT_KAZPOST_REFUND', 'ERROR') or withdraw.trn_status !='SUCCESS_WDW';";

    @Step("Fetch the last registered phone number")
    public static List<String> allNumbersWithWithdrawalOrders() {
        List<String> numbersWithWithdrawal = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(
                databaseConnectConfig.cashTestUrl(), databaseConnectConfig.user(), databaseConnectConfig.password());
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NUMBERS_WITH_WITHDRAWAL_ORDERS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object
            while (rs.next()) {
                String username = rs.getString("username");
                System.out.println(username);
                numbersWithWithdrawal.add(username);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        System.out.println(numbersWithWithdrawal);
        return numbersWithWithdrawal;
    }

    @Step("Fetch the last registered phone number")
    public static List<String> allNumbersWithIpoOrders() {
        List<String> numbersWithIpoOrders = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(
                databaseConnectConfig.cashTestUrl(), databaseConnectConfig.user(), databaseConnectConfig.password());
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NUMBERS_WITH_IPO_ORDERS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object
            while (rs.next()) {
                String username = rs.getString("username");
                numbersWithIpoOrders.add(username);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        System.out.println(numbersWithIpoOrders);
        return numbersWithIpoOrders;
    }

    @Step("Fetch all the numbers with CSD orders (withdrawal and purchase)")
    public static List<String> allNumbersWithCsdOrders() {
        List<String> numbersWithCsdOrders = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(
                databaseConnectConfig.cashTestUrl(), databaseConnectConfig.user(), databaseConnectConfig.password());
             // preparing the SQL statement
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NUMBERS_WITH_CSD_ORDERS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                // Our result set consists of 2 columns: users with PIPO orders and users with withdrawal orders
                String pipoUsername = rs.getString(1);
                if (pipoUsername != null) {
                    // If 1st column value (users with PIPO orders) is not null, then adding it to the list of users with orders
                    numbersWithCsdOrders.add(pipoUsername);
                }
                String withdrawUsername = rs.getString(2);
                if (withdrawUsername != null) {
                    // If 2nd column value (users with withdrawal orders) is not null, then adding it to the list of users with orders
                    numbersWithCsdOrders.add(withdrawUsername);
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return numbersWithCsdOrders;
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
