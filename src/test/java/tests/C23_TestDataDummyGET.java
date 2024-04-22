package tests;

import baseURL.BaseURLDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.DummyData;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C23_TestDataDummyGET extends BaseURLDummy {
    /*
       http://dummy.restapiexample.com/api/v1/employee/3 url'ine
       bir GET request gonderdigimizde
       donen response'un status code'unun 200,
       content Type'inin application/json
       ve body'sinin asagidaki gibi oldugunu test edin.

       Response Body
       {
           "status":"success",
           "data":{
                  "id":3,
                  "employee_name":"Ashton Cox",
                  "employee_salary":86000,
                  "employee_age":66,
                  "profile_image":""
                   },
           "message":"Successfully! Record has been fetched."
        }
    */

    @Test
    public void dummyGetTest() {

        specDummy.pathParams("pp1","employee","pp2","3");

        JSONObject expBody = DummyData.expDataOlustur(3,"Ashton Cox",86000,66,"");

        Response response = given().when().spec(specDummy).get("/{pp1}/{pp2}");

        JsonPath respJP = response.jsonPath();

        assertEquals(DummyData.basariliSC,response.getStatusCode());
        assertEquals(DummyData.contentType,response.getContentType());

        assertEquals(expBody.get("status"),respJP.get("status"));
        assertEquals(expBody.get("message"),respJP.get("message"));

        assertEquals(expBody.getJSONObject("data").get("id"),respJP.get("data.id"));
        assertEquals(expBody.getJSONObject("data").get("employee_name"),respJP.get("data.employee_name"));
        assertEquals(expBody.getJSONObject("data").get("employee_salary"),respJP.get("data.employee_salary"));
        assertEquals(expBody.getJSONObject("data").get("employee_age"),respJP.get("data.employee_age"));
        assertEquals(expBody.getJSONObject("data").get("profile_image"),respJP.get("data.profile_image"));



    }
}
