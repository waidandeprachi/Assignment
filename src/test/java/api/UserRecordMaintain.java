package api;

import api.objects.LocationAddApi;
import api.objects.location;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserRecordMaintain {

    @Test
    public void postTest()
    {
        List<String> types= new ArrayList<>();
        types.add("shoe park");
        types.add("shop");
        location location =new location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        LocationAddApi locationAddApi=new LocationAddApi();
        locationAddApi.setAccuracy("50");
        locationAddApi.setName("Frontline house");
        locationAddApi.setPhone_number("(+91) 983 893 3937");
        locationAddApi.setAddress("29, side layout, cohen 09");
        locationAddApi.setWebsite("http://google.com");
        locationAddApi.setLanguage("French-IN");
        locationAddApi.setTypes(types);

        locationAddApi.setLocation(location);

       Response res= given().log().all().baseUri("https://rahulshettyacademy.com/")
                .queryParam("key","qaclick123")
                .body(locationAddApi)
                .when().log().all()
                .post("maps/api/place/add/json")
                .then()
                .log().all().extract().response();


        Assert.assertEquals(res.statusCode(),200);
        JsonPath jsonPath = new JsonPath(res.asString());
        System.out.println("Place_id "+ jsonPath.get("place_id").toString());

//        System.out.println("res:"+res);

    }

    @Test
    public void putTest(){

        LocationAddApi locationAddApi=new LocationAddApi();
        locationAddApi.setAccuracy("74");
        locationAddApi.setName("Irani house");
        locationAddApi.setPhone_number("(+91) 983 893 3937");
        locationAddApi.setAddress("70 Summer walk, USA");
        locationAddApi.setWebsite("http://google.com");

        Response res= given().log().all().baseUri("https://rahulshettyacademy.com/")
                .queryParam("key","qaclick123")
                .queryParam("place_id","18aa5954310e1f8a54366982d5c05ca3")
                .body(locationAddApi)
                .when().log().all()
                .put("maps/api/place/update/json")
                .then()
                .log().all().extract().response();

        Assert.assertEquals(res.statusCode(),200);
        System.out.println("res:"+res.asPrettyString());
    }

    @Test
    public void getTest(){
        Response res = given().log().all().baseUri("https://rahulshettyacademy.com/")
                .queryParam("key","qaclick123")
                .queryParam("place_id","18aa5954310e1f8a54366982d5c05ca3")
                .when().get("/maps/api/place/get/json")
                .then().log().all().extract().response();
        Assert.assertEquals(res.statusCode(),200);
        System.out.println("res:"+res.asPrettyString());
    }

    @Test
    public void deleteTest(){
        //TODO  -
        given().baseUri("https://rahulshettyacademy.com/")
                .queryParam("key","qaclick123")
                .queryParam("place_id","18aa5954310e1f8a54366982d5c05ca3")
                .when().delete("/maps/api/place/delete/json")
                .then().log().all();
    }


}
