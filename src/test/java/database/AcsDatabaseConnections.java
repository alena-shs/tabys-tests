package database;
import io.qameta.allure.Step;
import tests.TestBase;

import java.sql.*;

import static database.DatabaseData.*;

public class AcsDatabaseConnections extends TestBase {

    private static final String SELECT_PHONE_NUMBER_CONFIRMATION_QUERY = "select * from phone_number_confirmation where phone_number=? order by expired_date desc limit 1",
            SELECT_LAST_REGISTERED_PHONE_NUMBER_QUERY = "select * from phone_number_confirmation where phone_number like ? and length(phone_number)=12 order by phone_number desc limit 1",
            SELECT_KAZPOST_LOGIN_CODE_QUERY = "select * from second_factor_confirmation where phone_number=? order by expired_date desc limit 1",
            SELECT_KAZPOST_SESSION_IDS_QUERY = "select * from g_session where username=? order by created_at desc limit 1";

    @Step ("Fetch the last registered phone number")
    public static String lastRegisteredPhoneNumber(String phoneNumberTemplate) {
        String phone_number = null;
        try (Connection connection = DriverManager.getConnection(acsTestUrl, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAST_REGISTERED_PHONE_NUMBER_QUERY);) {
            preparedStatement.setString(1, phoneNumberTemplate+"%"); // first ? mark value = phoneNumberTemplate
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object
            while (rs.next()) {
                phone_number = rs.getString("phone_number");
                String code = rs.getString("code");
                boolean is_confirm = rs.getBoolean("is_confirm");
                String expired_date = rs.getString("expired_date");
                System.out.println(phone_number + "," + code + "," + is_confirm + "," + expired_date);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return phone_number;
    }

    @Step("Fetch phone number confirmation code (for registration)")
    public String phoneNumberConfirmationCode(String phoneNumber) {
        // Establishing a connection
        String code = null;
        try (Connection connection = DriverManager.getConnection(acsTestUrl, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PHONE_NUMBER_CONFIRMATION_QUERY);) {
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
    public String kazpostLoginCode(String phoneNumber) {
        // Establishing a connection
        String code = null;
        try (Connection connection = DriverManager.getConnection(acsTestUrl, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_KAZPOST_LOGIN_CODE_QUERY);) {
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
    public static String[] kazpostSessionIds(String phoneNumber) {
        // Establishing a connection
        String Gg_token = null;
        String Session_id = null;
        try (Connection connection = DriverManager.getConnection(acsTestUrl, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_KAZPOST_SESSION_IDS_QUERY);) {
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
