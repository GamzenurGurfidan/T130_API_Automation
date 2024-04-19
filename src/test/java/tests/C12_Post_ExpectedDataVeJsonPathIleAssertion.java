package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {
    /*
       https://restful-booker.herokuapp.com/booking url'ine
       asagidaki body'ye sahip bir POST request gonderdigimizde
       donen response'un bookingid haric asagidaki gibi oldugunu test edin.

       Request body
       {
       "firstname" : "Hasan",
       "lastname" : "Yagmur",
       "totalprice" : 500,
       "depositpaid" : false,
       "bookingdates" : {
           "checkin" : "2021-06-01",
           "checkout" : "2021-06-10"
           },
       "additionalneeds" : "wi-fi"
       }

       Response Body
       {
       "bookingid":24,
       "booking":{
           "firstname":"Hasan",
           "lastname":"Yagmur",
           "totalprice":500,
           "depositpaid":false,
           "bookingdates":{
               "checkin":"2021-06-01",
               "checkout":"2021-06-10"
               },
       "additionalneeds":"wi-fi"
       }
       }
    */

    @Test
    public void expectedPostBodtTesti() {

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject innerDates = new JSONObject();
        innerDates.put("checkin", "2021-06-01");
        innerDates.put("checkout", "2021-06-10");

        JSONObject reqBody = new JSONObject();

        reqBody.put("firstname", "Hasan");
        reqBody.put("lastname", "Yagmur");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", innerDates);
        reqBody.put("additionalneeds", "wi-fi");

        JSONObject expData = new JSONObject();

        expData.put("bookingid", 24);
        expData.put("booking", reqBody);
        expData.put("additionalneeds", "wi-fi");

        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        JsonPath respJP = response.jsonPath();
        Assert.assertEquals(expData.getJSONObject("booking").get("firstname"),respJP.get("booking.firstname"));
        Assert.assertEquals(expData.getJSONObject("booking").get("lastname"),respJP.get("booking.lastname"));
        Assert.assertEquals(expData.getJSONObject("booking").get("totalprice"),respJP.get("booking.totalprice"));
        Assert.assertEquals(expData.getJSONObject("booking").get("depositpaid"),respJP.get("booking.depositpaid"));
        Assert.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),respJP.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),respJP.get("booking.bookingdates.checkout"));
        Assert.assertEquals(expData.getJSONObject("booking").get("additionalneeds"),respJP.get("booking.additionalneeds"));

    }
}
