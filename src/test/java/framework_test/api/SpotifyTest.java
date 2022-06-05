package framework_test.api;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class SpotifyTest {
    String token = "BQAeo-zDW60zQw1iOvK6vWGaggISemeib54xgqpC0xDNMH03oWEKHvxF8VgBVH8YLZEyaIg1r9DnTAFP_6MQyBYBHxLVD8nOBq3k8DykuGlfoBCitDInbQ9cT0-nPWeNEGJVDNIShkiTTMTfYsf9WlruSPx6E0T11U03Mf84e1eIHLgahooSaf-Q-ej0gyZ_37Hrq7BeZPC1veSsA7E8nPGIEk5tO1H5YRVJVOiirmE";
    String id = "31i4nk57hyuwhz2dwzmqpg4l6jua";
    String playlist_id;

    @Test
    public void startTest() {

        //Create playlist
        Response post = given().body("{\n" +
                        "  \"name\": \"New Playlist\",\n" +
                        "  \"description\": \"New playlist description\",\n" +
                        "  \"public\": false\n" +
                        "}")
                .when().contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .post("\thttps://api.spotify.com/v1/users/" + id + "/playlists");

        post
                .then()
                .assertThat()
                .statusCode(201);

        ResponseBody body1 = post.getBody();
        playlist_id = body1.jsonPath().get("id");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //Get playlist
        given().when()
                .header("Authorization", "Bearer " + token)
                .get("\thttps://api.spotify.com/v1/playlists/" + playlist_id)
                .then()
                .assertThat()
                .statusCode(200);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Update playlist
        Response update = given().body("{\n" +
                        "  \"name\": \"Updated Playlist Name\",\n" +
                        "  \"description\": \"Updated playlist description\",\n" +
                        "  \"public\": false\n" +
                        "}")
                .when().contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .put("\thttps://api.spotify.com/v1/playlists/" + playlist_id);

        update
                .then()
                .assertThat()
                .statusCode(200);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Get Artist Top Tracks
        given()
                .when()
                .header("Authorization", "Bearer " + token)
                .get("https://api.spotify.com/v1/artists/0oHyOQzDKjW5JVf347hue4/top-tracks?market=UA")
                .then()
                .assertThat()
                .statusCode(200);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Get Album
        given()
                .when().contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .get("https://api.spotify.com/v1/albums/23cRZVIOTVoEBkog5wjR2D?market=UA")
                .then()
                .assertThat()
                .statusCode(200);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
