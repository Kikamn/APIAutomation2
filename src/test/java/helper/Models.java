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
                .header("Authorization", "Bearer 76faab1ff917d8d72e6a538fc435ab8a5a718198b4dc431ee8e8d3726702876e");
    }

    public static Response getListUsers(String endpoint){
        //System.out.println(endpoint);
        setupHeader();
        return request.when().get(endpoint);
    }
}
