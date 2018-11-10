package com.fileanalyzer.api;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

@RunWith(SpringRunner.class)
@SqlGroup({@Sql("classpath:test-clean.sql"), @Sql})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseTest {
	protected Headers headers;
	@LocalServerPort
	protected Integer port;

	@PostConstruct
	public void prepare() {
		RestAssured.port = port;
		headers = new Headers();
	}
}
