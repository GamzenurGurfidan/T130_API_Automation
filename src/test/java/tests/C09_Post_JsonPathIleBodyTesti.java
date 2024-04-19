package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Post_JsonPathIleBodyTesti {
    /*
        https://restful-booker.herokuapp.com/booking url'ine asagidaki body'ye sahip
         bir POST request gonderdigimizde
         {
            "firstname" : "Ahmet",
            "lastname" : "Bulut",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" :{
                        "checkin" : "2021-06-01",
                        "checkout" : "2021-06-10"
                            },
            "additionalneeds" : "wi-fi"
         }
         donen Response'un,
         status code'unun 200,
         ve content type'inin application/json,
         ve response body'sindeki
         "firstname"in,"Ahmet",
         ve "lastname"in, "Bulut",
         ve "totalprice"in,500,
         ve "depositpaid"in,false,
         ve "checkin" tarihinin 2021-06-01 ve "checkout" tarihinin 2021-06-10
         ve "additionalneeds"in,"wi-fi"
         oldugunu test edin

   */
    @Test
    public void postBodyTesti(){

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject innerData = new JSONObject();
        innerData.put("checkin", "2021-06-01");
        innerData.put("checkout", "2021-06-10");

        JSONObject reqbody = new JSONObject();
        reqbody.put("firstname", "Ahmet");
        reqbody.put("lastname", "Bulut");
        reqbody.put("totalprice", 500);
        reqbody.put("depositpaid", false);
        reqbody.put("bookingdates",innerData);
        reqbody.put("additionalneeds", "wi-fi");

        Response response = given().contentType(ContentType.JSON).when().body(reqbody.toString()).post(url);

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("booking.firstname", equalTo("Ahmet"))
                .body("booking.lastname", equalTo("Bulut"))
                .body("booking.totalprice",equalTo(500))
                .body("booking.depositpaid",equalTo(false))
                .body("booking.bookingdates.checkin",equalTo("2021-06-01"))
                .body("booking.bookingdates.checkout",equalTo("2021-06-10"))
                .body("booking.additionalneeds",equalTo("wi-fi"));


    }
}
