package get_requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.*;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerokuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Aaron" and last name is "Chen"
     */

    @Test
    public void get01(){
        // 1. Step: set the Url
        spec.pathParams("first", "booking").queryParams("firstname", "Aaron",
                "lastname", "Chen");

        // 2. Step : set the expected data

        // 3. Step : Send the request and get the response

        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        // 4. Step : Do Assertion
        response.then().assertThat().statusCode(200);
        assertTrue(response.asString().contains("bookingid"));
    }

}
