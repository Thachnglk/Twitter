package com.iuh.thachnglk.coderschool.TWITTER_CLIENT;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.TwitterApi;

import android.content.Context;

import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/*
 * 
 * This is the object responsible for communicating with a REST API. 
 * Specify the constants below to change the API being communicated with.
 * See a full list of supported API classes: 
 *   https://github.com/fernandezpablo85/scribe-java/tree/master/src/main/java/org/scribe/builder/api
 * Key and Secret are provided by the developer site for the given API i.e dev.twitter.com
 * Add methods for each relevant endpoint in the API.
 * 
 * NOTE: You may want to rename this object based on the service i.e TwitterClient or FlickrClient
 * 
 */
public class TwitterClient extends OAuthBaseClient {
	public static final Class<? extends Api> REST_API_CLASS = TwitterApi.class; // Change this
	public static final String REST_URL = "https://api.twitter.com/1.1"; // Change this, base API URL
	public static final String REST_CONSUMER_KEY = "6wL8jNjUYismmBbOxdsnh0XGQ";       // Change this
	public static final String REST_CONSUMER_SECRET = "Vi3oAPfyRlJHpRi23jvhlioURaeTOrCKk2Y5re3fPk9DnmIeJv"; // Change this
	public static final String REST_CALLBACK_URL = "oauth://thachtwitter"; // Change this (here and in manifest)

	public TwitterClient(Context context) {
		super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
	}

	// CHANGE THIS
	// DEFINE METHODS for different API endpoints here
	/*public void getInterestingnessList(AsyncHttpResponseHandler handler) {
		String apiUrl = getApiUrl("?nojsoncallback=1&method=flickr.interestingness.getList");
		// Can specify query string params directly or through RequestParams.
		RequestParams params = new RequestParams();
		params.put("format", "json");
		client.get(apiUrl, params, handler);
	}*/
	public void getTimeline(Long sinceId,AsyncHttpResponseHandler handler)
	{
		String apiURL = getApiUrl("statuses/home_timeline.json");
		RequestParams params = new RequestParams();
		params.put("count",25);
		params.put("since_id",sinceId);
		getClient().get(apiURL, params, handler);
	}
	public void getTimelineWithMaxId(Long maxId,AsyncHttpResponseHandler handler)
	{
		String apiURL = getApiUrl("statuses/home_timeline.json");
		RequestParams params = new RequestParams();
		params.put("count",25);
		params.put("max_id",maxId);
		getClient().get(apiURL,params,handler);
	}



	public void getCurrentUser(AsyncHttpResponseHandler handler)
	{
		String apiURL = getApiUrl("account/verify_credentials.json");
		RequestParams params = new RequestParams();
		params.put("include_entities",true);
		getClient().get(apiURL,params,handler);
	}

	public void getCurrentUserTimeLine(String id,AsyncHttpResponseHandler handler)
	{
		String apiURL = getApiUrl("statuses/user_timeline.json");
		RequestParams params = new RequestParams();
		params.put("user_id",id);
		params.put("count",1);
		params.put("since_id",1);
		getClient().get(apiURL,params,handler);
	}

	public void postNewTweet(String status,AsyncHttpResponseHandler handler)
	{
		String apiURL = getApiUrl("statuses/update.json");
		RequestParams params = new RequestParams();
		params.put("status",status);
		getClient().post(apiURL, params, handler);
	}

	public void postRetweet(String tweetId,AsyncHttpResponseHandler handler)
	{
		String apiURL = getApiUrl("statuses/retweet/"+tweetId+".json");
		getClient().post(apiURL,handler);
	}

	public void postUnRetweet(String tweetId,AsyncHttpResponseHandler handler)
	{
		String apiURL = getApiUrl("statuses/unretweet/"+tweetId+".json");
		getClient().post(apiURL,handler);
	}

	public void postFavorite(String tweetId,AsyncHttpResponseHandler handler)
	{
		String apiURL = getApiUrl("favorites/create.json");
		RequestParams params = new RequestParams();
		params.put("id",tweetId);
		params.put("include_entities",false);
		getClient().post(apiURL, params, handler);
	}

	public void postUnFavorite(String tweetId,AsyncHttpResponseHandler handler)
	{
		String apiURL = getApiUrl("favorites/destroy.json");
		RequestParams params = new RequestParams();
		params.put("id",tweetId);
		params.put("include_entities",false);
		getClient().post(apiURL, params, handler);
	}

	public void postComment(String tweetId,String status,AsyncHttpResponseHandler handler)
	{
		String apiURL = getApiUrl("statuses/update.json");
		RequestParams params = new RequestParams();
		params.put("status",status);
		params.put("in_reply_to_status_id",tweetId);
		getClient().post(apiURL, params, handler);
	}





	/* 1. Define the endpoint URL with getApiUrl and pass a relative path to the endpoint
	 * 	  i.e getApiUrl("statuses/home_timeline.json");
	 * 2. Define the parameters to pass to the request (query or body)
	 *    i.e RequestParams params = new RequestParams("foo", "bar");
	 * 3. Define the request method and make a call to the client
	 *    i.e client.get(apiUrl, params, handler);
	 *    i.e client.post(apiUrl, params, handler);
	 */
}