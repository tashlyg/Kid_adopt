package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

public class ApiTester{
    public static void main(String[] args){
        try{
            HttpClient client = HttpClient.newHttpClient();
            String url = "http://localhost:4567/kids";
            String jsonPayload = "{\"name\":\"Alex Maximus\",\"age\":5,\"gender\":\"Male\",\"disease\":\"none\"}";
            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(BodyPublishers.ofString(jsonPayload))
                    .build();
            HttpResponse<String> postResponse = client.send(postRequest, BodyHandlers.ofString());
            System.out.println("POST: " + postResponse.body());
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> getResponse = client.send(getRequest, BodyHandlers.ofString());
            System.out.println("GET: " + getResponse.body());
            HttpRequest putRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url + "/2?disease=test1234"))
                    .PUT(BodyPublishers.noBody())
                    .build();
            HttpResponse<String> putResponse = client.send(putRequest, BodyHandlers.ofString());
            System.out.println("PUT: " + putResponse.body());
            HttpRequest deleteRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url + "/999"))
                    .DELETE()
                    .build();
            HttpResponse<String> deleteResponse = client.send(deleteRequest, BodyHandlers.ofString());
            System.out.println("DELETE: " + deleteResponse.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}