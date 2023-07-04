package api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.STATUS;
import static testdata.KazpostData.sessionIds;

public class Specs {
    public static RequestSpecification kazpostRequestSpec = with()
            .baseUri("https://public-ipo-test.aixkz.com/api")
            .filter(withCustomTemplates())
            .header("Gg_token", sessionIds[0])
            .header("Session_id", sessionIds[1])
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
