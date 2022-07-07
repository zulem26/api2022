package get_requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static org.junit.Assert.assertEquals;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get06 extends HerokuAppBaseUrl {

    /*
    Given
            https://restful-booker.herokuapp.com/booking/555
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
          {
            "firstname": "GGS",
            "lastname": "FINCH",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
            },
        }
     */

    @Test
    public void get01(){

        // 1. Step : Set the Url
        spec.pathParams("first", "booking", "second", 101);

        // 2. Step : Set the expected data

        // 3. Step : Send the request and get the response

         Response response = given().spec(spec).when().get("/{first}/{second}");
         //response.prettyPrint();

         // 4. Step : Do Assertion
        // 1. Yol
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("GGS"),
                        "lastname", equalTo("FINCH"),
                        "totalprice", equalTo(111),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin", equalTo("2018-01-01"),
                        "bookingdates.checkout", equalTo("2019-01-01"));

        // 2. Yol : JsonPath Class kullanilir

        JsonPath json = response.jsonPath();
        assertEquals("GGS", json.getString("firstname"));
        assertEquals("FINCH", json.getString("lastname"));
        assertEquals(111, json.getInt("totalprice"));
        assertEquals(true, json.getBoolean("depositpaid"));
        assertEquals("2018-01-01", json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01", json.getString("bookingdates.checkout"));


        // 3.Yol: Soft Assertion
        // Soft Assertion icin 3 adim izlenir.

            // 1) SoftAssert Objesi olusturulur.
            SoftAssert softAssert = new SoftAssert();

            // 2) Obje araciligi ile assert yapilir.
            softAssert.assertEquals(json.getString("firstname"), "GGS", "firstname uyusmadi");
            softAssert.assertEquals(json.getString("lastname"), "FINCH", "lastname uyusmadi");
            softAssert.assertEquals(json.getInt("totalprice"), 111, "totalprice uyusmadi");
            softAssert.assertEquals(json.getBoolean("depositpaid"), true, "depositpaid uyusmadi");
            softAssert.assertEquals(json.getString("bookingdates.checkin"), "2018-01-01", "checkin uyusmadi");
            softAssert.assertEquals(json.getString("bookingdates.checkout"), "2019-01-01", "checkout uyusmadi");

            // 3) assertAll() kullanilir. kullanilmazsa kod her zaman pass olur
            softAssert.assertAll();


    }
}
