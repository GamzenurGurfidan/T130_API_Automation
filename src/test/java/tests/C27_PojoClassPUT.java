package tests;

import baseURL.BaseURLJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoJsonPlaceHolder;
import testDatas.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C27_PojoClassPUT extends BaseURLJsonPlaceHolder {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body'e sahip bir PUT request yolladigimizda
    donen response'in
    status kodunun 200,
    content type'inin "application/json; charset=utf-8",
    Connection header degerinin "keep-alive"
    ve response body'sinin asagida verilen ile ayni oldugunu test ediniz

    Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Response body : // expected data
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    */

    @Test
    public void test01(){

        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");

        PojoJsonPlaceHolder reqBodyPojo = new PojoJsonPlaceHolder("Ahmet","Merhaba",10,70);

        PojoJsonPlaceHolder expBodyPojo = new PojoJsonPlaceHolder("Ahmet","Merhaba",10,70);

        Response response = given().spec(specJsonPlaceHolder)
                            .contentType(ContentType.JSON)
                            .when().body(reqBodyPojo)
                            .put("/{pp1}/{pp2}");

        PojoJsonPlaceHolder resPOJO = response.as(PojoJsonPlaceHolder.class);

        assertEquals(expBodyPojo.getTitle(),resPOJO.getTitle());
        assertEquals(expBodyPojo.getBody(),resPOJO.getBody());
        assertEquals(expBodyPojo.getUserId(),resPOJO.getUserId());
        assertEquals(expBodyPojo.getId(),resPOJO.getId());
        assertEquals(JsonPlaceData.basariliSC,response.getStatusCode());
        assertEquals(JsonPlaceData.contentType,response.getContentType());
        assertEquals(JsonPlaceData.header,response.getHeader("Connection"));




    }
}
