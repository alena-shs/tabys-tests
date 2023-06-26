package database;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.sql.*;

import static database.DatabaseData.*;

public class AcsDatabaseConnections extends TestBase {

    private static final String SELECT_PHONE_NUMBER_CONFIRMATION_QUERY = "select * from phone_number_confirmation where phone_number=? order by expired_date desc limit 1";

    @Step("Fetch phone number confirmation code (for registration)")
    public String PhoneNumberConfirmationCode(String phoneNumber) {
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
