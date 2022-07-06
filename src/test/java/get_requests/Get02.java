package get_requests;

import io.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import static io.restassured.RestAssured.given;

public class Get02 {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/1001
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void get01(){
        //1. Step : Set the Url
        String url = "https://restful-booker.herokuapp.com/booking/1005";

        // 2.Step : Set the expected data (Post-Put-Patch)

        // 3.Step ; Type code to send request

        Response response = given().when().get(url);
        response.prettyPrint();

        // 4. Do Assertion

        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        //Response body de bulunan spesifik bir veri nasil assert edilir

        // Responce body de bulunan spesifik bir veri bulunmadigini nasil assert edilir
        // assertTrue() methodu parantezin icindeki deger true ise testi gecirir
        assertTrue(response.asString().contains("Not Found"));


        // Responce body de bulunan spesifik bir veri bulunmadigini nasil assert edilir
        // assertTrue() methodu parantezin icindeki deger false ise testi gecirir
        assertFalse(response.asString().contains("TechProEd"));


        // assertEquals() methodu parantez icindeki iki deger esit ise testi gecirir
        assertEquals("Cowboy", response.header("Server"));


    }

}
