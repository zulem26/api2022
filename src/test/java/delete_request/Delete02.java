package delete_request;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.*;
import utils.JsonUtil;
import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.given;

public class Delete02 {

    /*
    URL: https://dummy.restapiexample.com/api/v1/delete/2
   HTTP Request Method: DELETE Request
   Test Case: Type by using Gherkin Language
   Assert:     i) Status code is 200
           ii) "status" is "success"
          iii) "data" is "2"
           iv) "message" is "Successfully! Record has been deleted"
 */

/*
    @Test
    public void delete01() {

        spec.pathParams("first","delete","second","2");

        DummyRestDeletePojo ecpectedData=new DummyRestDeletePojo("success","2","Successfully! Record has been deleted");

        Response response=given().spec(spec).accept(ContentType.JSON).when().delete("/{first}/{second}");

        DummyRestDeletePojo actualData= JsonUtil.convertJsonToJavaObject(response.asString(), DummyRestDeletePojo.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(ecpectedData.getStatus(),actualData.getStatus());
        assertEquals(ecpectedData.getData(),actualData.getData());
        assertEquals(ecpectedData.getMessage(),actualData.getMessage());



    }
    */

}
