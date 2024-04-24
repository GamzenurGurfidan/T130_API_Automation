package tests;

import baseURL.BaseURLJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDatas.JsonPlaceData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class C24_DeSerializationPUT extends BaseURLJsonPlaceHolder {
/*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body'e sahip bir PUT request yolladigimizda
        donen response'in
            ve response body'sinin asagida verilen ile ayni oldugunu test ediniz

         Request Body
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }

        Response body (Expected Data) :
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
    */
    @Test
    public void deSerializationTest(){

        // 1- endpoint ve request hazirlama

        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70"); // endpoint

        Map<String,Object> reqMapBody = JsonPlaceData.mapBodyOlustur(); // requestBody
        Map<String,Object> expMapBody = JsonPlaceData.mapBodyOlustur(); // 2- expected Data

        // 3 - Dönen Response kaydedildi (Json)
        Response response = given().contentType(ContentType.JSON)
                            .when().spec(specJsonPlaceHolder)
                            .body(reqMapBody)
                            .put("/{pp1}/{pp2}");

        // expBody --- ResponseBody karşılatırılıyor
        //   Map          jSON

        // Assertion islemini yapabilmek icin dönen response map türüne cevrilir
        // iste bu olaya deSerialization denir

        Map<String,Object> resMap = response.as(HashMap.class); // deSerialization islemi yapildi

        assertEquals(expMapBody.get("title"),resMap.get("title"));
        assertEquals(expMapBody.get("body"),resMap.get("body"));
        assertEquals(expMapBody.get("id"),resMap.get("id"));
        assertEquals(expMapBody.get("userId"),resMap.get("userId"));
        assertEquals(expMapBody.get("title"),resMap.get("title"));

    }
}
