package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.*;

public class ApiPages {
    String setURL;
    Response res;

    /*public void validateURL(){
        System.out.println("prepare URL");
    }*/
    public void prepareURLValidFor(String url){
        switch (url){
            case "GET_LIST_USERS":
                 setURL = Endpoint.GET_LIST_USERS;
                break;
            case "CREATE_NEW_USER":
                setURL = Endpoint.CREATE_NEW_USER;
                break;
            case "DELETE_USERS":
                setURL = Endpoint.DELETE_USERS;
                break;
            default:
                System.out.println("Input Right URL");
        }
        //System.out.println("Endpoint siap pakai adalah: " + setURL);
    }
    public void hitAPIGetListData(){
        res = getListUsers(setURL);
       //System.out.println(res.getBody().asString());
    }
    public void validationStatusCodeIsEquals(int status_code){
       assertThat(res.statusCode()).isEqualTo(status_code); // ngambil status code yang di terima di api
    }
    public void validationResponseBodyGetListUser (){
        //System.out.println("Step dari page 4");
        // ngambil variable sesuai dengan api
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");


        //ngambil data /validasi sesuai dengan api
        assertThat(id.get(0)).isNotNull(); //ngambil data id dari indeks 0 tidak boleh kosong
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");
    }
    public void validationResponseJsonWhitJSONSchema(String filename) {
        //System.out.println("step dari page 5");
        File JSONFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }
}
