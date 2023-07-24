package mobileapp.helpers;

import mobileapp.config.AuthBrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static commons.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class BrowserstackHelpers {
    public static AuthBrowserstackConfig authConfig = ConfigFactory.create(AuthBrowserstackConfig.class,
            System.getProperties());

    public static String getVideoUrlMobile(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .log().all()
                .filter(withCustomTemplates())
                .auth().basic(authConfig.getUser(), authConfig.getPassword())
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }

}
