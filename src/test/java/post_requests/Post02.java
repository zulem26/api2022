package post_requests;
import base_urls.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.*;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

import static io.restassured.RestAssured.given;

public class Post02 extends HerokuAppBaseUrl {
    /*
    Given
            1) https://restful-booker.herokuapp.com/booking
            2) {
                 "firstname": "John",
                 "lastname": "Doe",
                 "totalprice": 11111,
                 "depositpaid": true,
                 "bookingdates": {
                     "checkin": "2021-09-09",
                     "checkout": "2021-09-21"
                  }
               }
        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "bookingid": 5315,
                                                "booking": {
                                                    "firstname": "John",
                                                    "lastname": "Doe",
                                                    "totalprice": 11111,
                                                    "depositpaid": true,
                                                    "bookingdates": {
                                                        "checkin": "2021-09-09",
                                                        "checkout": "2021-09-21"
                                                    }
                                                }
                                             }
     */

    @Test
    public void post01(){

        // 1. Step : Set the Url

        spec.pathParam("first", "booking");

        // 2. Step : Set the expected Data
        HerOkuAppTestData herOkuapp = new HerOkuAppTestData();
        Map<String, String> bookingDatesMap = herOkuapp.bookingdatesSetUp("2021-09-09", "2021-09-21");

        Map<String, Object> expectedDataMap = herOkuapp.expectedDataSetUp("John", "Doe",11111, true, bookingDatesMap);

        // 3. Step : Send the Post Request get the Response

        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().post("/{first}");
        response.prettyPrint();

        // 4. Step : Do Assertion
        Map<String, Object> actualDataMap = response.as(HashMap.class);
        assertEquals(200, response.statusCode());

        assertEquals(expectedDataMap.get("firstname"),((Map)actualDataMap.get("booking")).get("firstname"));
        assertEquals(expectedDataMap.get("lastname"),((Map)actualDataMap.get("booking")).get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"),((Map)actualDataMap.get("booking")).get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"),((Map)actualDataMap.get("booking")).get("depositpaid"));

        assertEquals(bookingDatesMap.get("checkin"), ((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(bookingDatesMap.get("checkout"), ((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkout"));

    }

}
