package tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class C03_JsonObjesiOlusturma {

    /*
        Asagidaki JSON Objesini olusturup konsolda yazdirin.
              {
              "title":"Ahmet",
              "body":"Merhaba",
              "userId":1
              }
     */

    @Test
    public void jsonDataOlustur01(){

        JSONObject jsonData = new JSONObject();

        jsonData.put("title","Ahmet");
        jsonData.put("body","Merhaba");
        jsonData.put("userId",1);

        System.out.println("JSON Data bilgileri " + jsonData);


    }

    @Test
    public void jsonDataOlustur02(){

        /*
            Asagidaki JSON Objesini olusturup konsolda yazdirin.
            {
                "firstname":"Jim",
                "lastname":"Brown",
                "bookingdates": {
                        "checkin":"2018-01-01",
                        "checkout":"2019-01-01"
                                 },
                 "totalprice":111,
                "depositpaid":true,
                "additionalneeds":"Breakfast"
             }
        */

        JSONObject innerData = new JSONObject();
                   innerData.put("checkin","2018-01-01");
                   innerData.put("checkout","2019-01-01");

        JSONObject jsonData = new JSONObject();
                jsonData.put("firstname","Jim");
                jsonData.put("lastname","Brown");
                jsonData.put("bookingdates",innerData);
                jsonData.put("totalprice",111);
                jsonData.put("depositpaid",true);
                jsonData.put("additionalneeds","Breakfast");


        System.out.println("JSON Data bilgileri 2: " + jsonData);






    }
}
