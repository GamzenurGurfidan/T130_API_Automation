package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class C8_JsonPathKullanimi {
     /*
        {
        "firstName": "John",
        "lastName": "doe",
        "age": 26,
        "address": {
            "streetAddress": "naist street",
            "city": "Nara",
            "postalCode": "630-0192"
                    },
         "phoneNumbers": [
                         {
                            "type": "iPhone",
                            "number": "0123-4567-8888"
                         },
                         {
                            "type": "home",
                            "number": "0123-4567-8910"
                         }
                         ]
        }
     */

    @Test
    public void jsonPathKullanimi() {

        JSONObject iphoneTel = new JSONObject();
        iphoneTel.put("type", "iPhone");
        iphoneTel.put("number", "0123-4567-8888");

        JSONObject homeTel = new JSONObject();
        homeTel.put("type", "home");
        homeTel.put("number", "0123-4567-8888");

        JSONObject address = new JSONObject();
        address.put("streetAddress", "naist street");
        address.put("city", "Nara");
        address.put("postalCode", "630-0192");

        JSONArray phoneNumbers = new JSONArray();
        phoneNumbers.put(0, iphoneTel);
        phoneNumbers.put(1, homeTel);

        JSONObject informations = new JSONObject();
        informations.put("firstName", "John");
        informations.put("lastName", "doe");
        informations.put("age", 26);
        informations.put("address", address);
        informations.put("phoneNumbers", phoneNumbers);

        System.out.println("İsim: " + informations.get("firstName"));
        System.out.println("Soyisim: " + informations.get("lastName"));
        System.out.println("Age: " + informations.get("age"));

        System.out.println("Phone Numbers: " + "\n" + informations.getJSONArray("phoneNumbers").getJSONObject(0).get("type") + "\n"
                                                    + informations.getJSONArray("phoneNumbers").getJSONObject(0).get("number") + "\n"
                                                    + informations.getJSONArray("phoneNumbers").getJSONObject(1).get("type") + "\n"
                                                    + informations.getJSONArray("phoneNumbers").getJSONObject(1).get("number") + "\n");

        System.out.println("Address: " + "\n" + informations.getJSONObject("address").get("streetAddress") + "\n"
                                              + informations.getJSONObject("address").get("city") + "\n"
                                              + informations.getJSONObject("address").get("postalCode"));


    }
}
