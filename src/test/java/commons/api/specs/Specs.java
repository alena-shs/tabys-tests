package commons.api.specs;


import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.STATUS;
import static web.kazpost.data.KazpostData.*;
import static mobileapp.data.MobileTestData.*;
public class Specs {
//    Thece specifications are created to send images via API
//    public static RequestSpecification kazpostRequestSpec = with()
//            .baseUri("https://public-ipo-test.aixkz.com/api")
//            .filter(withCustomTemplates())
//            .header("Gg_token", ggToken)
//            .header("Session_id", sessionId)
//            .log().uri()
//            .log().headers()
////            .log().body()
//            .contentType(ContentType.JSON);


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
