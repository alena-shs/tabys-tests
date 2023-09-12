package commons.database.requests;

import commons.database.config.DatabaseConnectConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import web.kazpost.tests.TestBaseWeb;

import java.sql.*;

public class AcsFetchOtp extends TestBaseWeb {
    public static DatabaseConnectConfig databaseConnectConfig = ConfigFactory.create(DatabaseConnectConfig.class,
            System.getProperties());

    private static final String SELECT_PHONE_NUMBER_CONFIRMATION_QUERY = "select * from phone_number_confirmation where phone_number=? order by expired_date desc limit 1",
            SELECT_RESTORE_PASSWORD_QUERY = "select * from user_restore_password where receiver_number=? order by created_at desc limit 1",
            SELECT_KAZPOST_LOGIN_CODE_QUERY = "select * from second_factor_confirmation where phone_number=? order by expired_date desc limit 1",
            SELECT_KAZPOST_SESSION_IDS_QUERY = "select * from g_session where username=? order by created_at desc limit 1";



    @Step("Fetch phone number confirmation code (for registration)")
    public String phoneNumberConfirmationCode(String phoneNumber) {
        // Establishing a connection
        String code = null;
        try (Connection connection = DriverManager.getConnection(
                databaseConnectConfig.acsTestUrl(), databaseConnectConfig.user(), databaseConnectConfig.password());
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PHONE_NUMBER_CONFIRMATION_QUERY)) {
            preparedStatement.setString(1, phoneNumber); // first ? mark value = phoneNumber
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object
            while (rs.next()) {
                String phone_number = rs.getString("phone_number");
                code = rs.getString("code");
                boolean is_confirm = rs.getBoolean("is_confirm");
                String expired_date = rs.getString("expired_date");
                System.out.println(phone_number + "," + code + "," + is_confirm + "," + expired_date);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return code;
    }

    @Step("Fetch phone number confirmation code (for login in kazpost)")
    public String kazpostLoginCode(String phoneNumber) {
        // Establishing a connection
        String code = null;
        try (Connection connection = DriverManager.getConnection(
                databaseConnectConfig.acsTestUrl(), databaseConnectConfig.user(), databaseConnectConfig.password());
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_KAZPOST_LOGIN_CODE_QUERY)) {
            preparedStatement.setString(1, phoneNumber); // first ? mark value = phoneNumber
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object
            while (rs.next()) {
                String phone_number = rs.getString("phone_number");
                code = rs.getString("code");
                boolean is_confirm = rs.getBoolean("is_confirm");
                String expired_date = rs.getString("expired_date");
                System.out.println(phone_number + "," + code + "," + is_confirm + "," + expired_date);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return code;
    }

    @Step("Fetch phone number confirmation code (for registration)")
    public static String[] userSessionIds(String phoneNumber) {
        // Establishing a connection
        String Gg_token = null;
        String Session_id = null;
        try (Connection connection = DriverManager.getConnection(
                databaseConnectConfig.acsTestUrl(), databaseConnectConfig.user(), databaseConnectConfig.password());
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_KAZPOST_SESSION_IDS_QUERY)) {
            preparedStatement.setString(1, phoneNumber); // first ? mark value = phoneNumber
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object
            while (rs.next()) {
                Gg_token = rs.getString("token");
                Session_id = rs.getString("id");
                System.out.println(Gg_token + "," + Session_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return new String[] {Gg_token, Session_id};
    }

    @Step("Fetch phone number confirmation code (for registration)")
    public static String userRestorePasswordCode(String phoneNumber) {
        // Establishing a connection
        String randomCode = null;
        try (Connection connection = DriverManager.getConnection(
                databaseConnectConfig.acsTestUrl(), databaseConnectConfig.user(), databaseConnectConfig.password());
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RESTORE_PASSWORD_QUERY)) {
            preparedStatement.setString(1, phoneNumber); // first ? mark value = phoneNumber
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object
            while (rs.next()) {
                String receiverNumber = rs.getString("receiver_number");
                randomCode = rs.getString("random_code");
                System.out.println(receiverNumber + "," + randomCode);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return randomCode;
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