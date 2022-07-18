package delete_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Delete01 extends JsonPlaceHolderBaseUrl {

    /*
    Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete01(){
        // 1. Step : Set the Url

        spec.pathParams("first", "todos", "second", 198);

        // 2. Step : Set the expected data

        Map<String ,Object> expectedDataMap =  new HashMap<>();

        // 3. Step : Send DELETE request and get the response

        Response response = given().spec(spec).when().delete("/{first}/{second}");

        response.prettyPrint();

        // 4. Step : Do Assertion
        // 1. Yol
        Map<String, Object> actualMap = response.as(HashMap.class);
        response.then().assertThat().statusCode(200);
        assertEquals(expectedDataMap, actualMap);

        //2.Yol
        assertTrue(actualMap.size()==0);
        assertTrue(actualMap.isEmpty());  // Tavsiye edilen

        // Delete request yapmadan once "Post Request" yapip bu datayi silmeliyiz.


    }


}
