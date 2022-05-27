package test_aqa.api.task_17;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import task_17.models.CreateBoardResponse;
import task_17.models.CreateListResponse;
import task_17.models.CreateTaskResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class CustomWrapperTrelloTest {

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

        ObjectMapper objectMapper = new ObjectMapper();
        CreateBoardResponse createBoardResponse = null;
        try {
            createBoardResponse = objectMapper.readValue(response.body(), CreateBoardResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(createBoardResponse);
        String boardId = createBoardResponse.getId();
        CreateBoardResponse expected = new CreateBoardResponse();
        expected.setId(boardId);
        expected.setName(board);
        expected.setIdOrganization("6280f6da3eb5cf83ed278586");
        expected.setClosed(false);
        expected.setPinned(false);
        expected.setUrl(createBoardResponse.getUrl());
        expected.setPrefs(createBoardResponse.getPrefs());
        expected.setLabelNames(createBoardResponse.getLabelNames());
        expected.setLimits(createBoardResponse.getLimits());
        expected.setDesc("");

        Assert.assertEquals(createBoardResponse, expected);

        //Step2
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/boards/" + boardId + "?key=" + key + "&token=" + token))
                .GET()
                .build();

        HttpClient client2 = HttpClient.newHttpClient();

        HttpResponse<String> response2 = client2.send(request2, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response2.statusCode(), 200, "Invalid status code");

        ObjectMapper get_objectMapper = new ObjectMapper();
        CreateBoardResponse createGetBoardResponse = null;
        try {
            createGetBoardResponse = get_objectMapper.readValue(response2.body(), CreateBoardResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(response2.body());
        System.out.println(createGetBoardResponse);
        CreateBoardResponse expected_get = new CreateBoardResponse();
        expected_get.setId(boardId);
        expected_get.setName(board);
        expected_get.setIdOrganization("6280f6da3eb5cf83ed278586");
        expected_get.setClosed(false);
        expected_get.setPinned(false);
        expected_get.setUrl(createGetBoardResponse.getUrl());
        expected_get.setPrefs(createGetBoardResponse.getPrefs());
        expected_get.setLabelNames(createGetBoardResponse.getLabelNames());
        expected_get.setLimits(createGetBoardResponse.getLimits());
        expected_get.setDesc("");

        Assert.assertEquals(createGetBoardResponse, expected_get);

        //Step3.1
        HttpRequest request3 = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/lists?name=" + list1 + "&idBoard=" + boardId + "&key=" + key + "&token=" + token))
                .POST(HttpRequest.BodyPublishers.ofString("{\"idOrganization\":\"6280f6da3eb5cf83ed278586\"}", StandardCharsets.UTF_8))
                .build();

        HttpClient client3 = HttpClient.newHttpClient();

        HttpResponse<String> response3 = client3.send(request3, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response3.statusCode(), 200, "Invalid status code");

        ObjectMapper list_objectMapper = new ObjectMapper();
        CreateListResponse createList1Response = null;
        try {
            createList1Response = list_objectMapper.readValue(response3.body(), CreateListResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String list1Id = createList1Response.getId();
        CreateListResponse expectedList1 = new CreateListResponse();

        expectedList1.setId(list1Id);
        expectedList1.setIdBoard(boardId);
        expectedList1.setClosed(false);
        expectedList1.setName(list1);
        expectedList1.setPos(createList1Response.getPos());
        expectedList1.setLimits(createList1Response.getLimits());

        Assert.assertEquals(createList1Response, expectedList1);

        //Step3.2
        HttpRequest request4 = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/lists?name=" + list2 + "&idBoard=" + boardId + "&key=" + key + "&token=" + token))
                .POST(HttpRequest.BodyPublishers.ofString("{\"idOrganization\":\"6280f6da3eb5cf83ed278586\"}", StandardCharsets.UTF_8))
                .build();

        HttpClient client4 = HttpClient.newHttpClient();

        HttpResponse<String> response4 = client4.send(request4, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response4.statusCode(), 200, "Invalid status code");

        ObjectMapper list2_objectMapper = new ObjectMapper();
        CreateListResponse createList2Response = null;
        try {
            createList2Response = list2_objectMapper.readValue(response4.body(), CreateListResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String list2Id = createList2Response.getId();
        CreateListResponse expectedList2 = new CreateListResponse();

        expectedList2.setId(list2Id);
        expectedList2.setIdBoard(boardId);
        expectedList2.setClosed(false);
        expectedList2.setName(list2);
        expectedList2.setPos(createList2Response.getPos());
        expectedList2.setLimits(createList2Response.getLimits());

        Assert.assertEquals(createList2Response, expectedList2);

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

        /*ObjectMapper taskObjectMapper = new ObjectMapper();
        CreateTaskResponse createTaskResponse = null;
        try {
            createTaskResponse = taskObjectMapper.readValue(response5.body(), CreateTaskResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CreateTaskResponse expectedTask = new CreateTaskResponse();
        String cartId = createTaskResponse.getId();

        expectedTask.setId(cartId);
        expectedTask.setBadges(createTaskResponse.getBadges());
        expectedTask.setClosed(false);
        expectedTask.setDueComplete(false);
        expectedTask.setDateLastActivity(createTaskResponse.getDateLastActivity());
        expectedTask.setDesc("");
        expectedTask.setDescData(createTaskResponse.getDescData());
        expectedTask.setDue(null);
        expectedTask.setDueReminder(null);
        expectedTask.setEmail(null);
        expectedTask.setIdBoard(boardId);
        expectedTask.setIdList(list1Id);
        expectedTask.setIdShort(1);
        expectedTask.setIdAttachmentCover(null);
        expectedTask.setManualCoverAttachment(false);
        expectedTask.setName(cart);
        expectedTask.setPos(createTaskResponse.getPos());
        expectedTask.setShortLink(createTaskResponse.getShortLink());
        expectedTask.setShortUrl(createTaskResponse.getShortUrl());
        expectedTask.setStart(null);
        expectedTask.setSubscribed(false);
        expectedTask.setUrl(createTaskResponse.getUrl());
        expectedTask.setCover(createTaskResponse.getCover());
        expectedTask.setTemplate(false);
        expectedTask.setCardRole(null);
        expectedTask.setLimits(createTaskResponse.getLimits());

        Assert.assertEquals(createTaskResponse, expectedTask);*/

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
