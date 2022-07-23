package get_requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.*;
import org.testng.asserts.SoftAssert;
import pojos.BookingPojo;
import utils.JsonUtil;
import static org.junit.Assert.assertEquals;

import static io.restassured.RestAssured.given;

public class Get15ObjectMapper extends HerokuAppBaseUrl {

    /*
    Given
	            https://restful-booker.herokuapp.com/booking/2
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
                {
                     "firstname": "Oliver",
                     "lastname": "Smith",
                     "totalprice": 100,
                     "depositpaid": true,
                     "bookingdates": {
                         "checkin": "2022-07-18",
                         "checkout": "2022-07-19"
                     },
                     "additionalneeds": "Breakfast"
               }
     */

    @Test
    public void get01(){
        // 1. Step : Set the Url
        spec.pathParams("first", "booking", "second", 22);

        // 2.Step : Set the expected Data
        String expectedData = "{\n" +
                "                     \"firstname\": \"Oliver\",\n" +
                "                     \"lastname\": \"Smith\",\n" +
                "                     \"totalprice\": 100,\n" +
                "                     \"depositpaid\": true,\n" +
                "                     \"bookingdates\": {\n" +
                "                         \"checkin\": \"2022-07-18\",\n" +
                "                         \"checkout\": \"2022-07-19\"\n" +
                "                     },\n" +
                "                     \"additionalneeds\": \"Breakfast\"\n" +
                "               }";

        BookingPojo expectedDataPojo = JsonUtil.convertJsonToJavaObject(expectedData, BookingPojo.class);

        //3. Step : Send the Get Request get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4. Step : Do Assertion
        BookingPojo actualDataPojo = JsonUtil.convertJsonToJavaObject(response.asString(), BookingPojo.class);

    //    assertEquals(200, response.getStatusCode());
    //    assertEquals(expectedDataPojo.getFirstname(),actualDataPojo.getFirstname());
    //    assertEquals(expectedDataPojo.getLastname(),actualDataPojo.getLastname());
    //    assertEquals(expectedDataPojo.getTotalprice(),actualDataPojo.getTotalprice());
    //    assertEquals(expectedDataPojo.getDepositpaid(),actualDataPojo.getDepositpaid());
    //    assertEquals(expectedDataPojo.getAdditinalneeds(),actualDataPojo.getAdditinalneeds());
    //    assertEquals(expectedDataPojo.getBookingdates().getCheckin(),actualDataPojo.getBookingdates().getCheckin());
    //    assertEquals(expectedDataPojo.getBookingdates().getCheckout(),actualDataPojo.getBookingdates().getCheckout());

        //Soft Assertion
        // 1. Adim : softAssert objesi olustur
        SoftAssert softAssert = new SoftAssert();


        // 2.Adim : Assertion Yap
        softAssert.assertEquals(actualDataPojo.getFirstname(), expectedDataPojo.getFirstname(), "Firstname uyusmadi");
        softAssert.assertEquals(actualDataPojo.getLastname(), expectedDataPojo.getLastname(), "Lastname uyusmadi");
        softAssert.assertEquals(actualDataPojo.getTotalprice(), expectedDataPojo.getTotalprice(), "Totalprice uyusmadi");
        softAssert.assertEquals(actualDataPojo.getDepositpaid(), expectedDataPojo.getDepositpaid(), "Depositpaid uyusmadi");
        softAssert.assertEquals(actualDataPojo.getBookingdates().getCheckin(), expectedDataPojo.getBookingdates().getCheckin(), "Checkin uyusmadi");
        softAssert.assertEquals(actualDataPojo.getBookingdates().getCheckout(), expectedDataPojo.getBookingdates().getCheckout(), "Checkout uyusmadi");


        // 3. Adim : assertAll() methodunu calistir
        softAssert.assertAll();
    }

}
