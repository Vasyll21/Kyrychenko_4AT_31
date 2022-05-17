package test_aqa.api.task_16;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TrelloTest {

    String key = "bbaf4a5698357a6513845b00c3bfefe1";
    String token = "695f413a3165b17b7143875dd51e7086ea6dd6b63f8ea7059765180687a1c411";
    String board = "Board_1";
    String list1 = "ToDo";
    String list2 = "Done";
    String cart = "Task";

    @Test
    void createTest() throws InterruptedException {

        //""
        //step1 Create board
        Response response1 = given()
                .when().contentType("application/json")
                .body("{\"idOrganization\":\"6280f6da3eb5cf83ed278586\"}")
                .post("https://api.trello.com/1/boards/?name=" + board +
                        "&key=" + key + "&token=" + token);

        response1
                .then()
                .assertThat()
                .statusCode(200);

        ResponseBody body1 = response1.getBody();
        String board_id = body1.jsonPath().get("id");

        //step2 Get board
        given()
                .when()
                .get("https://api.trello.com/1/boards/" + board_id + "?key=" + key + "&token=" + token)
                .then()
                .assertThat()
                .statusCode(200);

        //step3 Create lists
        Response response2 = given()
                .when().contentType("application/json")
                .post("https://api.trello.com/1/lists?name=" + list1 + "&idBoard=" + board_id + "&key=" + key + "&token=" + token);

        response2
                .then()
                .assertThat()
                .statusCode(200);

        ResponseBody body2 = response2.getBody();
        String list1_id = body2.jsonPath().get("id");

        Response response3 = given()
                .when().contentType("application/json")
                .post("https://api.trello.com/1/lists?name=" + list2 + "&idBoard=" + board_id + "&key=" + key + "&token=" + token);

        response3
                .then()
                .assertThat()
                .statusCode(200);

        ResponseBody body3 = response3.getBody();
        String list2_id = body3.jsonPath().get("id");

        //step4 Create task
        Response response4 = given()
                .when().contentType("application/json")
                .post("https://api.trello.com/1/cards?token=" + token + "&key=" + key + "&idList=" + list1_id + "&name=" + cart);

        response4
                .then()
                .assertThat()
                .statusCode(200);

        ResponseBody body4 = response4.getBody();
        String cart_id = body4.jsonPath().get("id");

        //step5 Update task
        given()
                .when().contentType("application/json")
                .put("https://api.trello.com/1/cards/" + cart_id + "/?idList=" + list2_id + "&token=" + token + "&key=" + key)
                .then()
                .assertThat()
                .statusCode(200);

        //step6 Delete board
        given()
                .when().contentType("application/json")
                .delete("https://api.trello.com/1/boards/" + board_id + "?key=" + key + "&token=" + token)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
