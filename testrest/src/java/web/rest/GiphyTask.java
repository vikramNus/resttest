/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.rest;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class GiphyTask implements Runnable {

	private String q;	
	private AsyncResponse asyncResp;

	public GiphyTask (String q, AsyncResponse asyncResp) {
		this.q = q;
		this.asyncResp = asyncResp;
	}

	@Override
	public void run() {

		System.out.println(">>> running in async");

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target("https://api.giphy.com/v1/gifs/search")
				.queryParam("q", q)
				.queryParam("api_key", "bmuQVChiYxEFEDdQ7r0RRcRdNDCKK9Qm&q");

		Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
		JsonObject result = invocation.get(JsonObject.class);

		System.out.println(">>>result = " + result);

		JsonArray data = result.getJsonArray("data");
		JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
		for (JsonObject o: data.getValuesAs(JsonObject.class)) 
			arrBuilder.add(
					o.getJsonObject("images").getJsonObject("original").getString("url"));

		Response response = Response.ok(arrBuilder.build()).build();

		System.out.println(">> resuming request");
		asyncResp.resume(response);
	}

}

