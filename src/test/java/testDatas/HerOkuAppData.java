package testDatas;

import io.restassured.path.json.JsonPath;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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

    /*
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

    public static Map<String,Object> mapReqBodyOlustur(){
        Map<String,Object> reqData = new HashMap<>();
        Map<String,Object> bookingDates = new HashMap<>();

        bookingDates.put("checkin", "2021-06-01");
        bookingDates.put("checkout", "2021-06-10");

        reqData.put("firstname","Ahmet");
        reqData.put("lastname","Buloot");
        reqData.put("totalprice",500.0);
        reqData.put("depositpaid",false);
        reqData.put("bookingdates", bookingDates);
        reqData.put("additionalneeds","wi-fi");

        return reqData;
    }

    public static Map<String,Object> mapExpBoyOlustur(){

        Map<String,Object> expBodyMap = new HashMap<>();

        expBodyMap.put("bookingid",24);
        expBodyMap.put("booking",mapReqBodyOlustur());

    return  expBodyMap;
    }

}
