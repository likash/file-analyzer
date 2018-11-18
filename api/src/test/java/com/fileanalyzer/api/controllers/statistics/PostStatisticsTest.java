package com.fileanalyzer.api.controllers.statistics;

import com.fileanalyzer.api.BaseTest;
import com.fileanalyzer.api.dtos.ContentDto;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class PostStatisticsTest extends BaseTest {
    @Test
    public void shouldReturnStatistics() {
        ContentDto content = new ContentDto("a bc d");

        String json = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(content)
                .when()
                .post("/api/analyze-text")
                .then()
                .extract().response().prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("longestWord", equalTo("bc"))
                .body("shortestWord", equalTo("a"))
                .body("length", equalTo(6))
                .body("averageWordLength", equalTo(1))
                .body("lines[0].content", equalTo("a bc d"))
                .body("lines[0].longestWord", equalTo("bc"))
                .body("lines[0].shortestWord", equalTo("a"))
                .body("lines[0].length", equalTo(6))
                .body("lines[0].averageWordLength", equalTo(1))
                .extract().response().body().asString();
    }
}
