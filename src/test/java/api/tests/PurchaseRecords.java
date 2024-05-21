package api.tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseRecords {

    @Test
    public void getRecords(){
        RestAssured.baseURI = "https://api.restful-api.dev";
        RequestSpecification  httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/objects");
        String responseBody = response.getBody().asPrettyString();
        System.out.println(responseBody);
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println(response.getStatusLine());
    }

    @Test
    public void addRecord(){
        RestAssured.baseURI = "https://api.restful-api.dev";
        RequestSpecification  httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.POST,"/objects");
        String responseBody = response.getBody().asPrettyString();
        System.out.println(responseBody);
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println(response.getStatusLine());

    }
}
