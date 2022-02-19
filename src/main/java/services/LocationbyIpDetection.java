//this class helps me create the method LocationbyIPDetections which is required (by the exercise) for my library

package services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.fasterxml.jackson.databind.ObjectMapper;

import exception.NewsAPIException;
import model.thenewsdb.ErrorResponse;
import model.thenewsdb.LocationResult;

public class LocationbyIpDetection{
//I create three variables and their constructor	
	private final String API_URL;
	private final String IPV6;
	private final String API_KEY;
	
//I create constructors for the aforewritten variables. User has to type values for these variables. To do that, user has to go to class "LocationAPI" and follow the instructions there.
	public LocationbyIpDetection(String aPI_URL, String aPI_KEY, String iPV6) {
		API_URL = aPI_URL;
		IPV6 = iPV6;
		API_KEY = aPI_KEY;
	
}
//this method is used to return top-headlines for user's country by detecting automatically user's country via IP Address
//https://ip-geolocation.whoisxmlapi.com/api/v1?apiKey=(apiKey)&ipAddress=(ipAddress)
	public LocationResult searchUserLocation() throws NewsAPIException {
		LocationResult result = getAPIData(API_URL, API_KEY, IPV6); 
		return result;
	} 

//Class getAPIData helps me get all required Data needed such as parameters,url,apiKey etc.
private LocationResult getAPIData(String API_URL, String API_KEY, String IPV6) throws NewsAPIException {
	
	try {
	//I begin building URI by defining its Path Segments and the needed parameters
	final URIBuilder uriBuilder= new URIBuilder(API_URL).setPathSegments("api", "v1").addParameter("apiKey", API_KEY).addParameter("ipAddress", IPV6);
	//I am ready to finalise the URI build
	final URI uri = uriBuilder.build();
	//in next step, I insert uri to Http method
	final HttpGet getRequest = new HttpGet(uri);
	//I create an HttpClient object
	final CloseableHttpClient httpclient = HttpClients.createDefault();
	//I create the execution needed in order to have the Responses (results). That is something like clicking "Send" in postman and get the Responses
	try (CloseableHttpResponse response = httpclient.execute(getRequest)) {
		//get response in json form
		final HttpEntity entity = response.getEntity();
		final ObjectMapper mapper = new ObjectMapper();

		//check if response status is ok
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
		//if it's not ok, it uses class ErrorResponse and creates a new errorResponse object for having an error on API call
		ErrorResponse errorResponse = mapper.readValue(entity.getContent(), ErrorResponse.class);
		if (errorResponse.getStatus() != null)
				throw new NewsAPIException("Error occurred on API call: " + errorResponse.getStatus());
		}
		//if it's ok, it returns the content
		return mapper.readValue(entity.getContent(), LocationResult.class);
		//I do Exception handling
	} catch (IOException e) {
		throw new NewsAPIException("Error requesting data from the NewsAPI.", e);
	}
	
} catch (URISyntaxException e) {
	throw new NewsAPIException("Unable to create request URI.", e);
	
}
}

}