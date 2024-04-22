package tests;

import baseURL.BaseURLHerOkuApp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C18_baseUrlHerOkuAppQuery2 extends BaseURLHerOkuApp {

    /*
       https://restful-booker.herokuapp.com/booking endpointine
       gerekli Query parametrelerini yazarak
           "firstname" degeri "Jim"
           ve "lastname" degeri "Jackson" olan
       rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
       donen response'un
           status code'unun 200 oldugunu
           ve "Jim Jackson" ismine sahip en az bir booking oldugunu test edin
    */
    @Test
    public void queryTest(){

        specHerOkuApp.pathParam("pp1","booking").queryParams("firstname","John","lastname","Smith");

        Response response = given().when().spec(specHerOkuApp).get("/{pp1}");

        response.then().assertThat().statusCode(200).body("size()", Matchers.greaterThan(0));

    }
}
