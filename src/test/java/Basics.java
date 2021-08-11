import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import java.awt.*;

public class Basics {
    public static void main(String[] args) {

        /**
         * USECASE: Validate if Add place API is working as expected
         *
         * Rest assured works on given, when and there principle
         * given: all the input details e.g request parameters
         * when: submit the API - resource and HTTP Method
         * then: validate the response
         */

        // Rest assured BaseURI

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        // it will also log all the process of sending request and response
        given().log().all().queryParam("key", "qaclick123")
                .header("content-Type", "application/json")
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Frontline house\",\n" +
                        "  \"phone_number\": \"(+92) 300 1234567\",\n" +
                        "  \"address\": \"Some where on planet Earth\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://gofadi.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}")
                .when().post("/maps/api/place/add/json") // submitting the API request with POST HTTP method to the resource
                .then().log().all().assertThat().statusCode(200); // then validating the response code 200 from method I don't know
        // I don't know the anatomy of then object and how and from where assertion is asserting (validating the response)




    }
}
