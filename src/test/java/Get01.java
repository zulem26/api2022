import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {

    /*
        1) Postman manuel API testi icin kullanilir
        2) API otomasyon testi icin Rest-Assured Library kullaniyoruz
        3) Otomasyon kodlarinin yazimi icin su adimlari izliyoruz:
            a) Gereksinimleri anlama
            b) Test case i yazma
                i) Test case yazimi icin 'Gherkin Language' kullaniyoruz
                    'Gherkin' bazi keywordlere sahip, bunlar:
                    x) Given: On kosullar --> sayfaya git
                    y) When : Aksiyonlar -->Get, Put ...
                    z) Then : Ciktilar - Donutler, Assert, Dogrulama, response, ...
                    t) And : Coklu islemler icin kullanilir

             c) Testing kodunun yazimi
                    i) Set the URL (URl'yi kurmak)
                    ii) Set the expected data (beklenen datanın oluşturulması) (POT-PUT-PATCH)
                    iii) Type code to send request (talep göndermek için kod yazma)
                    iv) Do Assertion (doğrulama yapma)
     */


    /*
    Given
    https://restful-booker.herokuapp.com/booking/3
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK

    */
    @Test
    public void get01(){

        // i) Set the URL (URl'yi kurmak)
        String url = "https://restful-booker.herokuapp.com/booking/55";

        // ii) Set the expected data (beklenen datanın oluşturulması) (POT-PUT-PATCH)

        // iii) Type code to send request (talep göndermek için kod yazma)
        Response response = given().when().get(url);

        // response.prettyPrint();
        // iv) Do Assertion (doğrulama yapma)

        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        // Status Code nasil yazdirilir
        System.out.println("status Code : " + response.statusCode());

        // Content Type nasil yazdirilir
        System.out.println("Content Type : " + response.contentType());

        // Status Line nasil yazdirilir
        System.out.println("Status Line : " + response.statusLine());

        // Header nasil yazdirilir
        System.out.println(response.header("User-Agent"));

        // Headers nasil yazdirilir
        System.out.println("Headers :\n" + response.headers());

        // Time nasil yazdirilir
        System.out.println("Time :" + response.getTime());
    }
}
