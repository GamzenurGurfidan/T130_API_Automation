package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {
    /*
       http://dummy.restapiexample.com/api/v1/employee/3 url'ine
       bir GET request gonderdigimizde
       donen response'un asagidaki gibi oldugunu test edin.

           Response Body (expectedBody)
           {
               "status":"success",
               "data":{
                        "id": 12,
                        "employee_name": "Quinn Flynn",
                        "employee_salary": 342000,
                        "employee_age": 22,
                        "profile_image": ""
                       },
               "message":"Successfully! Record has been fetched."
           }
    */

    @Test
    public void softAssertTesti(){

     // 1- endpoint hazirlama (RequestBody verilirse o da burada hazirlanir)

        String url = "http://dummy.restapiexample.com/api/v1/employee/12";

     // 2- ExpectedBody hazirlanir.

        JSONObject data = new JSONObject();
            data.put("id", 12);
            data.put("employee_name", "Quinn Flynn");
            data.put("employee_salary", 342000);
            data.put("employee_age", 22);
            data.put("profile_image", "");

        JSONObject expBody = new JSONObject();
            expBody.put("status", "success");
            expBody.put("data", data);
            expBody.put("message", "Successfully! Record has been fetched.");

     // 3- Dönen response kaydedilir

        Response response = given().when().get(url);

     // 4- Assertion yapilir

        JsonPath respJP = response.jsonPath(); // gelen cevap jasonPath turune cevrilir

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(respJP.get("status"),expBody.get("status"));
        softAssert.assertEquals(respJP.get("data.id"),expBody.getJSONObject("data").get("id"));
        softAssert.assertEquals(respJP.get("data.employee_name"),expBody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(respJP.get("data.employee_salary"),expBody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(respJP.get("data.employee_age"),expBody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(respJP.get("data.profile_image"),expBody.getJSONObject("data").get("profile_image"));
        softAssert.assertEquals(respJP.get("message"),expBody.get("message"));

        softAssert.assertAll();


    }
}
