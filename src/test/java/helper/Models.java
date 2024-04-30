package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Models {
    private static RequestSpecification request; // ini variable kosong

    public static void setupHeader(){
        request = RestAssured.given() // disini dimasukin deh yang di butuhkan variabale
                .header("Content-type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer d361ff35b18930da63c2461abe6b56e66d4bbfb616d840e2c4d99cd7bbe75c73");
    }

    public static Response getListUsers(String endpoint){
        //System.out.println(endpoint);
        setupHeader();
        return request.when().get(endpoint);
    }
}
