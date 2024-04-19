package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C1_Get_APISorgulama {
    /*
        tests.C1_Get_ApiSorgulama
        https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request
        gonderdigimizde donen Response'un,
        status code'unun 200,
        ve content type'inin application/json; charset=utf-8, ve
        Server isimli Header'in degerinin Cowboy,
        ve status Line'in HTTP/1.1 200 OK
        ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
     */

    // API Testlerinde 4 işlem ile test yapilir
    /*
        1- Endpoint belirlenir
        2- Gerekli ise Expected Data hazirlanir
        3- Actual Data kaydedilir
        4- Assertion işlemi gerçeklestirilir
     */


    @Test
    public void get01() {
        // 1- Endpointi belirlenir
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Gerekli ise Expected Data hazirlanir

        // 3- Actual Data kaydedilir

        Response response = given().when().get(url);

        // 4- Assertion işlemi gerçeklestirilir (Bu test için manuel yapılmasi istenmiş)

        System.out.println("Status Code: " + response.getStatusCode());

        System.out.println("Content Type: " + response.getContentType());

        System.out.println("Server: " + response.getHeader("Server"));

        System.out.println("Status Line: " + response.getStatusLine());

        System.out.println("Response time: " + response.getTime() + "ms");


    }


}
