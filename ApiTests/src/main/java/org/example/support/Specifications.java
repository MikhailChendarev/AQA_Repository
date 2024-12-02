package org.example.support;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class Specifications {

    private static RequestSpecification requestSpec;

    public static void installSpecification(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }

    public static RequestSpecification getRequestSpecJson() {
        return new RequestSpecBuilder()
                .setBaseUri("https://aqa-api.javacode.ru")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecOk200(File jsonSchema) {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody(matchesJsonSchema(jsonSchema))
                .build();
    }


}
