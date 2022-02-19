//this class helps me create all methods for my library

package services;

import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.fasterxml.jackson.databind.ObjectMapper;

import exception.NewsAPIException;
import model.thenewsdb.Article;
import model.thenewsdb.ErrorResponse;
import model.thenewsdb.NewsResult;
import model.newsinfo;

public class NewsAPIService {
//I create two variables and their constructor	
	private final String API_URL;
	private final String API_KEY;

//I create constructors for the aforewritten variables. User has to type values for these variables. To do that, user has to go to class "NewsAPI" and follow the instructions there.
	public NewsAPIService(String aPI_URL, String aPI_KEY) {
		API_URL = aPI_URL;
		API_KEY = aPI_KEY;
	}

//All the above methods return results in a list form. Each method is created taking into account what is required from the exercise	
	
	//endpoint top-headlines
	
	
	//This method is to get top-headlines news for country
	//According to documentation in https://newsapi.org/docs/endpoints/top-headlines, 
	//possible countries for endpoint (top-headlines) 
	//are these: ae-ar-at-au-be-bg-br-ca-ch-cn-co-cu-cz-de-eg-fr-gb-gr-hk-hu-id-ie-il-in-it-jp-kr-lt-lv-ma-mx-my-ng-nl-no-nz-ph-pl-pt-ro-rs-ru-sa-se-sg-si-sk-th-tr-tw-ua-us-ve and za
	//https://newsapi.org/v2/top-headlines?country=gr
	
	public List<newsinfo> getTopHeadlinesForCountry(String parameter) throws NewsAPIException {
		NewsResult result = getAPIData("top-headlines", parameter,null,null,null,null, API_URL, API_KEY); 
		List<newsinfo> NewsInfoList = new ArrayList<>(result.getArticles().size());
		for (Article theResult : result.getArticles()) {
			NewsInfoList.add(new newsinfo(theResult));
		}
		return NewsInfoList;
	} 
	
	//This method is used get top-headlines news by category
	//According to documentation in https://newsapi.org/docs/endpoints/top-headlines,
	//possible countries for endpoint (top-headlines) 
	//are these: ae-ar-at-au-be-bg-br-ca-ch-cn-co-cu-cz-de-eg-fr-gb-gr-hk-hu-id-ie-il-in-it-jp-kr-lt-lv-ma-mx-my-ng-nl-no-nz-ph-pl-pt-ro-rs-ru-sa-se-sg-si-sk-th-tr-tw-ua-us-ve and za
	//and possible categories for endpoint (top-headlines) are these: business, entertainment, general, health, science, sports and technology
	//https://newsapi.org/v2/top-headlines?country=gr&category=business
	//https://newsapi.org/v2/top-headlines?country=gr&category=entertainment
	
	 public List<newsinfo> getTopHeadlinesForCategory(String parameter, String parameter2) throws NewsAPIException {
		NewsResult result = getAPIData("top-headlines",parameter, parameter2,null,null,null, API_URL, API_KEY); 
		List<newsinfo> NewsInfoList = new ArrayList<>(result.getArticles().size());
		for (Article theResult : result.getArticles()) {
			NewsInfoList.add(new newsinfo(theResult)); 
		}
		return NewsInfoList; 
	
	} 
	 
		//endpoint everything
	    //It has to be referred that according to documentation in https://newsapi.org/docs/endpoints/everything, category as a parameter is not supported. So, category is not included for news about this endpoint
	 
	 
	    //This method is used to search everything news about a specific query
	    //User can type whatever query wants
		//https://newsapi.org/v2/everything?q=Apple
		
		public List<newsinfo> searchEverythingNewsForQuery(String parameter) throws NewsAPIException {
			NewsResult result = getAPIData("everything",parameter,null,null,null,null, API_URL, API_KEY); 
			List<newsinfo> NewsInfoList = new ArrayList<>(result.getArticles().size());
			for (Article theResult : result.getArticles()) {
				NewsInfoList.add(new newsinfo(theResult));
			}
			return NewsInfoList;	
		} 
		
        //This method is used to search everything news about a specific source
		//User can type whatever query wants
		//According to documentation in https://newsapi.org/docs/endpoints/everything,
		//possible languages for endpoint (everything) 
		//are these: ar-de-en-es-fr-he-it-nl-no-pt-ru-se-ud and zh
		//That means, greek language is not supported 
		//User can type whatever sources wants
		//https://newsapi.org/v2/everything?q=Apple&language=en&sources=bbc-news
		
		public List<newsinfo> searchEverythingNewsForSources(String parameter,String parameter2,String parameter3) throws NewsAPIException {
			NewsResult result = getAPIData("everything",parameter,parameter2,parameter3,null,null, API_URL, API_KEY); 
			List<newsinfo> NewsInfoList = new ArrayList<>(result.getArticles().size());
			for (Article theResult : result.getArticles()) {
				NewsInfoList.add(new newsinfo(theResult));
			}
			return NewsInfoList;	
		}
		
	    //This method is used to search everything news about a specific language
		//User can type whatever query wants
		//According to documentation in https://newsapi.org/docs/endpoints/everything,
		//possible languages for endpoint (everything) 
		//are these: ar-de-en-es-fr-he-it-nl-no-pt-ru-se-ud and zh
		//That means, greek language is not supported 
		//https://newsapi.org/v2/everything?q=Apple&language=en
		
		 public List<newsinfo> getSearchEverythingNewsForLanguage(String parameter,String parameter2) throws NewsAPIException {
		NewsResult result = getAPIData("everything",parameter,parameter2,null,null,null, API_URL, API_KEY); 
		List<newsinfo> NewsInfoList = new ArrayList<>(result.getArticles().size());
		for (Article theResult : result.getArticles()) {
			NewsInfoList.add(new newsinfo(theResult));
		}
		return NewsInfoList;	
	} 
	
		 //This method is used to search everything news betwwen specific dates
		 //User can type whatever query wants
		 //According to documentation in https://newsapi.org/docs/endpoints/everything,
		 //possible languages for endpoint (everything) 
		 //are these: ar-de-en-es-fr-he-it-nl-no-pt-ru-se-ud and zh
		 //That means, greek language is not supported 
		 //User can type whatever sources wants
		 //User can also type whatever dates (from&to) wants.
		 //https://newsapi.org/v2/everything?q=Apple&language=en&sources=bbc-news&from=2022-01-25&to=2022-01-31
	
	public List<newsinfo> searchEverythingNewsForDateOfPublication(String parameter,String parameter2,String parameter3,String parameter4,String parameter5) throws NewsAPIException {
		NewsResult result = getAPIData("everything",parameter,parameter2,parameter3,parameter4,parameter5, API_URL, API_KEY); 
		List<newsinfo> NewsInfoList = new ArrayList<>(result.getArticles().size());
		for (Article theResult : result.getArticles()) {
			NewsInfoList.add(new newsinfo(theResult));
		}
		return NewsInfoList;	
	} 
	
	//getAPIData
	
	//Class getAPIData helps me get all required Data needed such as parameters,url,apiKey etc.
	
     private NewsResult getAPIData(String apiFunction, String parameter, String parameter2, String parameter3,String parameter4,String parameter5, String API_URL, String API_KEY) throws NewsAPIException {
    	try {
    		//I begin building URI by defining its Path Segments and the needed parameters
			final URIBuilder uriBuilder= new URIBuilder(API_URL).setPathSegments("v2", apiFunction).addParameter("apiKey", API_KEY);
			//apiFunction is used in order not to repeat parameters top-headlines and everything. To do so, i use thw switch function
			//if is used to define what parameters are needed to be typed from the user when the programm is executed.
			if (parameter!=null && !parameter.isEmpty()) {
			   switch (apiFunction) {
			  case "top-headlines" :
				  if(parameter!=null){
				  uriBuilder.addParameter("country", parameter);	
				  }
				  if(parameter2!=null){
					  uriBuilder.addParameter("category", parameter2);	
				  }
				
			  break;
			  case "everything" :
				  if(parameter!=null){
					  uriBuilder.addParameter("q", parameter);	
					  }
				  if(parameter2!=null){
					  uriBuilder.addParameter("language", parameter2);	
					  }
				  if(parameter3!=null){
					  uriBuilder.addParameter("sources", parameter3);	
		      }
					  if(parameter4!=null){
						  uriBuilder.addParameter("from", parameter4);	
			      }
					  if(parameter5!=null){
						  uriBuilder.addParameter("to", parameter5);	
			      }
					  break;
				   
			   }
				   
			}
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
				return mapper.readValue(entity.getContent(), NewsResult.class);
				//I do Exception handling
			} catch (IOException e) {
				throw new NewsAPIException("Error requesting data from the NewsAPI.", e);
			}
			
		} catch (URISyntaxException e) {
			throw new NewsAPIException("Unable to create request URI.", e);
			
		}
    	
    	
    }
}