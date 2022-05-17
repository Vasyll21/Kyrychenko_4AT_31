package test_aqa.api.task_16;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class CustomTrelloTest {

    String key = "bbaf4a5698357a6513845b00c3bfefe1";
    String token = "695f413a3165b17b7143875dd51e7086ea6dd6b63f8ea7059765180687a1c411";
    String board = "Board_1";
    String list1 = "ToDo";
    String list2 = "Done";
    String cart = "Task";

    @Test
    public void customTest() throws URISyntaxException, IOException, InterruptedException {
        //Step 1
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/boards/?name=" + board +
                        "&key=" + key + "&token=" + token))
                .POST(HttpRequest.BodyPublishers.ofString("{\"idOrganization\":\"6280f6da3eb5cf83ed278586\"}", StandardCharsets.UTF_8))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response.statusCode(), 200, "Invalid status code");

        JSONObject jsonBody = new JSONObject(response.body());
        String boardId = jsonBody.getString("id");

        //Step2
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/boards/" + boardId + "?key=" + key + "&token=" + token))
                .GET()
                .build();

        HttpClient client2 = HttpClient.newHttpClient();

        HttpResponse<String> response2 = client2.send(request2, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response2.statusCode(), 200, "Invalid status code");

        //Step3
        HttpRequest request3 = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/lists?name=" + list1 + "&idBoard=" + boardId + "&key=" + key + "&token=" + token))
                .POST(HttpRequest.BodyPublishers.ofString("{\"idOrganization\":\"6280f6da3eb5cf83ed278586\"}", StandardCharsets.UTF_8))
                .build();

        HttpClient client3 = HttpClient.newHttpClient();

        HttpResponse<String> response3 = client3.send(request3, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response3.statusCode(), 200, "Invalid status code");

        JSONObject jsonBody3 = new JSONObject(response3.body());
        String list1Id = jsonBody3.getString("id");

        HttpRequest request4 = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/lists?name=" + list2 + "&idBoard=" + boardId + "&key=" + key + "&token=" + token))
                .POST(HttpRequest.BodyPublishers.ofString("{\"idOrganization\":\"6280f6da3eb5cf83ed278586\"}", StandardCharsets.UTF_8))
                .build();

        HttpClient client4 = HttpClient.newHttpClient();

        HttpResponse<String> response4 = client4.send(request4, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response4.statusCode(), 200, "Invalid status code");

        JSONObject jsonBody4 = new JSONObject(response4.body());
        String list2Id = jsonBody4.getString("id");

        //Step4
        HttpRequest request5 = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/cards?token=" + token + "&key=" + key + "&idList=" + list1Id + "&name=" + cart))
                .POST(HttpRequest.BodyPublishers.ofString("{\"idOrganization\":\"6280f6da3eb5cf83ed278586\"}", StandardCharsets.UTF_8))
                .build();

        HttpClient client5 = HttpClient.newHttpClient();

        HttpResponse<String> response5 = client5.send(request5, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response5.statusCode(), 200, "Invalid status code");

        JSONObject jsonBody5 = new JSONObject(response5.body());
        String cartId = jsonBody5.getString("id");

        //Step5
        HttpRequest request6 = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/cards/" + cartId + "/?idList=" + list2Id + "&token=" + token + "&key=" + key))
                .PUT(HttpRequest.BodyPublishers.ofString("{\"idOrganization\":\"6280f6da3eb5cf83ed278586\"}", StandardCharsets.UTF_8))
                .build();

        HttpClient client6 = HttpClient.newHttpClient();

        HttpResponse<String> response6 = client6.send(request6, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response6.statusCode(), 200, "Invalid status code");

        //Step6
        HttpRequest request7 = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/boards/" + boardId + "?key=" + key + "&token=" + token))
                .DELETE()
                .build();

        HttpClient client7 = HttpClient.newHttpClient();

        HttpResponse<String> response7 = client7.send(request7, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response7.statusCode(), 200, "Invalid status code");

    }
}
