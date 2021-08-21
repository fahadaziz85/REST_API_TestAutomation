import files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

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
        // First basic example
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        // it will also log all the process of sending request and response
        given().log().all().queryParam("key", "qaclick123")
                .header("content-Type", "application/json")
                .body(PayLoad.addPlace())
                .when().post("/maps/api/place/add/json") // submitting the API request with POST HTTP method to the resource
                .then().log().all().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.18 (Ubuntu)");

        // then validating the response code 200 from method I don't know
        // I don't know the anatomy of then object and how and from where assertion is asserting (validating the response)

        // End to End Usecase / Testcase.

        // Add Place -> Update Place with New Address -> Get Place to validate if New address is present in response

        // STEP1: Add Place
        String response = given().log().all().queryParam("key", "qaclick123")
                .header("content-Type", "application/json")
                .body(PayLoad.addPlace())
                .when().post("/maps/api/place/add/json") // submitting the API request with POST HTTP method to the resource
                .then().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

        System.out.println("Response: " + response);

        JsonPath jsonPath = new JsonPath(response); // for parsing Json as String. So it takes Json as String argument.


        String placeID = jsonPath.getString("place_id"); // Grab the place Id so that it can be used to update the place
        System.out.println("Here is the required Place Id: " + placeID);

        // STEP2: Update the place address
        given().log().all().queryParam("key", "qaclick123")
                .header("content-Type", "application/json")
                .body("{\n" +
                        "\n" +
                        "\"place_id\" : \"" + placeID + "\" ,\n" +
                        "\"address\" : \"17 Loxford lane, Ilford London\",\n" +
                        "\"key\" : \"qaclick123\"\n" +
                        "\n" +
                        "}").when().put("/maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

        // STEP3: Get the Address

        response = given().log().all().queryParam("key", "qaclick123")

                .queryParam("place_id", placeID)
                .when().get("/maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();

        JsonPath jsonPath1 = new JsonPath(response); // for parsing Json as String. So it takes Json as String argument.
        String address = jsonPath1.getString("address");
        System.out.println("Here is the required Address: " + address);

        // TestNG assertion
        Assert.assertEquals(address, "17 Loxford lane, Ilford London");

    }
}
