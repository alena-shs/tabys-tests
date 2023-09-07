package commons.api.specs;


import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static commons.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.STATUS;
import static mobileapp.data.MobileTestData.ggTokenMobile;
import static mobileapp.data.MobileTestData.sessionIdMobile;
import static web.kazpost.data.KazpostData.ggToken;
import static web.kazpost.data.KazpostData.sessionId;
public class Specs {
//    Theыe specifications are created to send images via API
    public static RequestSpecification kazpostRequestSpec = with()
        // CHANGE HERE IF YOU WANT TO SWITCH THE STAND
            .baseUri("https://public-ipo-test.aixkz.com/api")
            .filter(withCustomTemplates())
            .header("Gg_token", ggToken)
            .header("Session_id", sessionId)
            .log().uri()
            .log().headers()
//            .log().body()
            .contentType(ContentType.JSON);


    public static RequestSpecification tabysRequestSpec = with()
            .baseUri("https://mobile-test.aixkz.com/api")
//            .filter(withCustomTemplates())
            .header("Gg_token", ggTokenMobile)
            .header("Session_id", sessionIdMobile)
            .log().uri()
            .log().headers()
//            .log().body()
            .contentType(ContentType.JSON);

    public static ResponseSpecification successResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
//            .log(BODY)
            .expectStatusCode(200)
            .build();
}
