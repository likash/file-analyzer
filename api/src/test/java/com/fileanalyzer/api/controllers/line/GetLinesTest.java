package com.fileanalyzer.api.controllers.line;

import com.fileanalyzer.api.BaseTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@SqlGroup({@Sql("classpath:test-clean.sql"), @Sql})
public class GetLinesTest extends BaseTest {
    @Test
    public void shouldGetLines() {
        given()
                .accept(ContentType.JSON)
                .headers(headers)
                .when()
                .get("/api/files/1/lines")
                .then()
                .extract().response().prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("lines", hasSize(2))
                .body("[0].id", equalTo(1))
                .body("[0].content", equalTo("example"))
                .body("[0].fileId", equalTo(1))
                .body("[0].longestWord", equalTo("longword"))
                .body("[0].shortestWord", equalTo("ok"))
                .body("[0].length", equalTo(20))
                .body("[0].averageWordLength", equalTo(7))
                .body("[1].id", equalTo(2))
                .body("[1].content", equalTo("example2"))
                .body("[1].fileId", equalTo(1))
                .body("[1].longestWord", equalTo("longword2"))
                .body("[1].shortestWord", equalTo("ok2"))
                .body("[1].length", equalTo(22))
                .body("[1].averageWordLength", equalTo(5));
    }
}
