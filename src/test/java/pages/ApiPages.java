package pages;

import helper.Endpoint;
import io.restassured.response.Response;

import static helper.Models.getListUsers;
import static org.assertj.core.api.Assertions.assertThat;

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
       // System.out.println("Endpoint siap pakai adalah: " + setURL);
    }
    public void hitAPIGetListData(){
        res = getListUsers(setURL);
        System.out.println(res.getBody().asString());
    }
    public void validationStatusCodeIsEquals(int status_code){
        assertThat(res.statusCode()).isEqualTo(status_code);
    }
    public void validationResponseBodyGetListUser (){
        System.out.println("Step dari page 4");
    }
    public void validationResponseJsonWhitJSONSchema(){
        System.out.println("step dari page 5");
    }



}
