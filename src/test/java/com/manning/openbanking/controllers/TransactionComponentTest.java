package com.manning.openbanking.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.manning.openbanking.OpenbankingApplication;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;



@SpringBootTest(classes = {OpenbankingApplication.class}, webEnvironment = RANDOM_PORT)
public class TransactionComponentTest {

    @Autowired
    private TransactionalController transactionalController;

    @LocalServerPort
    private int port;

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://localhost";
    }


    // @Test
    // void testTransactionEndToEnd() {

    //     String accountNumber = "123456789";

    //     given()
    //         .port(port)
    //         .when()
    //         .get("/api/transactions/{accountNumber}", accountNumber)
    //         .then()
    //             .statusCode(200);

    // }

}
