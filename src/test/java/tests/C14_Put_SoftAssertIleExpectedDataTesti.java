package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti {
    /*
        https://dummy.restapiexample.com/api/v1/update/21 url'ine
        asagidaki body'ye sahip bir PUT request gonderdigimizde donen response'un
        asagidaki gibi oldugunu test edin.

        Request Body                        Response Body
        {                                   {
        "status": "success",                  "status": "success",
        "data": {                             "data": {
            "name": "Ahmet",                           "name": "Ahmet",
            "salary": "1230",                          "salary": "1230",
            "age": "44",                               "age": "44",
            "id": 40                                   "id": 40
            }                                          }
        }                                     "message": "Successfully! Record has been updated."
                                             }

 */

    @Test
    public void softAssertPostRequestTesti(){

        // 1- Endpoint ve RequestBody hazirlama

        String url = "https://dummy.restapiexample.com/api/v1/update/21";

        JSONObject reqData = new JSONObject();
            reqData.put("name", "Ahmet");
            reqData.put("salary", "1230");
            reqData.put("age", "44");
            reqData.put("id", 40);

        JSONObject request = new JSONObject();
            request.put("status", "success");
            request.put("data", reqData);


        // 2- ExpectedBody hazirlama

        JSONObject resp= new JSONObject();
            resp.put("status", "success");
            resp.put("data",reqData);
            resp.put("message","Successfully! Record has been updated.");

        // 3- Dönen response kaydedilir

        Response response = given().contentType(ContentType.JSON).when().body(request.toString()).put(url);

        // 4- Assertion işlemi

        JsonPath respJP = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(respJP.get("status"),resp.get("status"));
        softAssert.assertEquals(respJP.get("data.name"),resp.getJSONObject("data").get("name"));
        softAssert.assertEquals(respJP.get("data.salary"),resp.getJSONObject("data").get("salary"));
        softAssert.assertEquals(respJP.get("data.age"),resp.getJSONObject("data").get("age"));
        softAssert.assertEquals(respJP.get("data.id"),resp.getJSONObject("data").get("id"));
        softAssert.assertEquals(respJP.get("message"),resp.get("message"));


    }
}
