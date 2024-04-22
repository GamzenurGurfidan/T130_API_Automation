package testDatas;

import io.restassured.path.json.JsonPath;
import org.json.JSONObject;

public class HerOkuAppData {
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
           Expected response body
                    {
                     "bookingid":24,
                     "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
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

    public static JSONObject reqBodyOlustur(){

        JSONObject innerData = new JSONObject();
            innerData.put("checkin", "2021-06-01");
            innerData.put("checkout", "2021-06-10");


        JSONObject reqData = new JSONObject();
            reqData.put("firstname", "Ahmet");
            reqData.put("lastname", "Bulut");
            reqData.put("totalprice", 500);
            reqData.put("depositpaid", false);
            reqData.put("bookingdates", innerData);
            reqData.put("additionalneeds", "wi-fi");


        return reqData;
    }
    public static JSONObject expBodyOlustur(){

        JSONObject booking = reqBodyOlustur();

        JSONObject expData = new JSONObject();
            expData.put("bookingid", 24);
            expData.put("booking", booking);

        return expData;
    }
}
