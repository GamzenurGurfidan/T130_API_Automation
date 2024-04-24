package tests;

import baseURL.BaseURLDummy;
import baseURL.BaseURLHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDatas.HerOkuAppData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C26_DeSerializationPOST extends BaseURLHerOkuApp {
    /*
    https://restful-booker.herokuapp.com/booking url'ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response'un bookingid haric asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : "Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body // expected data
                    {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10",
                        "additionalneeds":"wi-fi"
                    }
     */
    @Test
    public void mapPostdSTest(){

        specHerOkuApp.pathParam("pp1","booking");

        Map<String,Object> reqBody = HerOkuAppData.mapReqBodyOlustur();
        Map<String,Object> expBody = HerOkuAppData.mapExpBoyOlustur();

        Response response = given().contentType(ContentType.JSON)
                            .when().spec(specHerOkuApp)
                            .body(reqBody)
                            .post("/{pp1}");

        Map<String,Object> respMap = response.as(HashMap.class);
/*
        assertEquals(expBody.get("booking.firstname"),respMap.get("booking.firstname"));
        assertEquals(expBody.get("booking.lastname"),respMap.get("booking.lastname"));
        assertEquals(expBody.get("booking.totalprice"),respMap.get("booking.totalprice"));
        assertEquals(expBody.get("booking.depositpaid"),respMap.get("booking.depositpaid"));
        assertEquals(expBody.get("booking.bookingdates.checkin"),respMap.get("booking.bookingdates.checkin"));
        assertEquals(expBody.get("booking.bookingdates.checkout"),respMap.get("booking.bookingdates.checkout"));
        assertEquals(expBody.get("booking.additionalneeds"),respMap.get("booking.additionalneeds"));
 */
        // assertEquals(expBody.get("bookingid"),respMap.get("bookingid"));
        assertEquals(((Map)expBody.get("booking")).get("firstname"),((Map)respMap.get("booking")).get("firstname"));
        assertEquals(((Map)expBody.get("booking")).get("lastname"),((Map)respMap.get("booking")).get("lastname"));
        assertEquals(((Map)expBody.get("booking")).get("totalprice"),((Map)respMap.get("booking")).get("totalprice"));
        assertEquals(((Map)expBody.get("booking")).get("depositpaid"),((Map)respMap.get("booking")).get("depositpaid"));
        assertEquals(((Map)expBody.get("booking")).get("additionalneeds"),((Map)respMap.get("booking")).get("additionalneeds"));

        assertEquals(((Map)((Map)expBody.get("booking")).get("bookingdates")).get("checkin"),
                (((Map)((Map)respMap.get("booking")).get("bookingdates")).get("checkin")));

        assertEquals(((Map)((Map)expBody.get("booking")).get("bookingdates")).get("checkout"),
                (((Map)((Map)respMap.get("booking")).get("bookingdates")).get("checkout")));

    }
}
