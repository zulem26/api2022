package get_requests;


import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.*;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

import static io.restassured.RestAssured.given;

public class Get08 extends JsonPlaceHolderBaseUrl {


        // De-Serialization : JSON formatindan Java objesine cevirme
        // Serialization : Java objesini JSON formatina cevirme
            // De-Serialization ve Seralization iki turlu yapilir :
            // Gson : Google tarafindan uretilmistir
            // Object Mapper : Daha populer ***


/*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

    @Test
    public void get01(){

        // 1. Step : Set the Url

        spec.pathParams("first", "todos", "second", 2);

        // 2. Step : Set the expected data
        //  "id": 2, sistem tarafindan ataniyor

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 1);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);
        expectedData.put("StatusCode", 200);
        expectedData.put("Via", "1.1 vegur");
        expectedData.put("Server", "cloudflare");

        // 3. Step : Send the request and get the response

        Response response = given().spec(spec).when().get("/{first}/{second}");
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);


        // 4. Step : Do Assertion
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("StatusCode"), response.getStatusCode()); //response dan cagrildi Map in icinde yok
        assertEquals(expectedData.get("Via"), response.getHeader("Via"));  // Header icindeki Via
        assertEquals(expectedData.get("Server"), response.getHeader("Server")); // Header icindeki Server

    }

    @Test
    public void get02(){
        // 1. Step : Set the Url

        spec.pathParams("first", "todos", "second", 2);

        // 2. Step : Set the expected data
        JsonPlaceHolderTestData expectedData = new JsonPlaceHolderTestData();
        Map<String, Object> expectedDataMap = expectedData.expectedDataWithAllKeys(1, "quis ut nam facilis et officia qui", false);
        // Map<Object, Object> yapmadik cunku islem yapilmaz,cast sorunu olur, buyuk sinif oldugu icin yavas calisir

        expectedDataMap.put("StatusCode", 200);
        expectedDataMap.put("Via", "1.1 vegur");
        expectedDataMap.put("Server", "cloudflare");

        // 3. Step : Send the request and get the response

        Response response = given().spec(spec).when().get("/{first}/{second}");
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);

        // 4. Step : Do Assertion
        assertEquals(expectedDataMap.get("userId"), actualData.get("userId"));
        assertEquals(expectedDataMap.get("title"), actualData.get("title"));
        assertEquals(expectedDataMap.get("completed"), actualData.get("completed"));
        assertEquals(expectedDataMap.get("StatusCode"), response.getStatusCode());
        assertEquals(expectedDataMap.get("Via"), response.getHeader("Via"));
        assertEquals(expectedDataMap.get("Server"), response.getHeader("Server"));

    }
}