import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import exception.NewsAPIException;
import model.newsinfo;
import model.thenewsdb.Location;
import model.thenewsdb.LocationResult;
import newsapi.LocationAPI;
import newsapi.NewsAPI;
import services.LocationbyIpDetection;
import services.NewsAPIService;



public class NewsAPITest {
	
//There are some tests that have already done for my classes.
//If user wants to test something else, they have just to change the parameters given or transfer to project NewsAPP (in the Application class) and follow the instructions given in there.
	
//endpoint top-headlines
	 
//Finds automatically top-headlines news from the user's country according to IP address 
//According to documentation in https://newsapi.org/docs/endpoints/top-headlines, 
//possible countries for endpoint (top-headlines) 
//are these: ae-ar-at-au-be-bg-br-ca-ch-cn-co-cu-cz-de-eg-fr-gb-gr-hk-hu-id-ie-il-in-it-jp-kr-lt-lv-ma-mx-my-ng-nl-no-nz-ph-pl-pt-ro-rs-ru-sa-se-sg-si-sk-th-tr-tw-ua-us-ve and za
//So there is a possibility for user not to see top-headlines news for their country, if user does not live in one of the aforementioned countries
	 @Test
public void testSearchAPI() throws NewsAPIException {
	 final LocationbyIpDetection newsSearchService1= LocationAPI.getLocationbyIPDetection();
	 final LocationResult results2 = newsSearchService1.searchUserLocation();
	 String country = Location.getCountry();
	 System.out.println("Your country is: " + country);
     final NewsAPIService newsSearchService= NewsAPI.getNewsAPIService();
	 final List<newsinfo> results= newsSearchService.getTopHeadlinesForCountry(country);
	 Assert.assertFalse(results.isEmpty());
	 results.forEach(System.out::println);
	} 
	 
//Finds top-headlines news from Greece 
//According to documentation in https://newsapi.org/docs/endpoints/top-headlines, 
//possible countries for endpoint (top-headlines) 
//are these: ae-ar-at-au-be-bg-br-ca-ch-cn-co-cu-cz-de-eg-fr-gb-gr-hk-hu-id-ie-il-in-it-jp-kr-lt-lv-ma-mx-my-ng-nl-no-nz-ph-pl-pt-ro-rs-ru-sa-se-sg-si-sk-th-tr-tw-ua-us-ve and za
  @Test
public void testSearch1API() throws NewsAPIException {
	final NewsAPIService newsSearchService= NewsAPI.getNewsAPIService();
	final List<newsinfo> results= newsSearchService.getTopHeadlinesForCountry("gr");
	Assert.assertFalse(results.isEmpty());
	results.forEach(System.out::println);
} 
  
//Finds top-headlines news from Greece with category business
//According to documentation in https://newsapi.org/docs/endpoints/top-headlines,
//possible countries for endpoint (top-headlines) 
//are these: ae-ar-at-au-be-bg-br-ca-ch-cn-co-cu-cz-de-eg-fr-gb-gr-hk-hu-id-ie-il-in-it-jp-kr-lt-lv-ma-mx-my-ng-nl-no-nz-ph-pl-pt-ro-rs-ru-sa-se-sg-si-sk-th-tr-tw-ua-us-ve and za
//and possible categories for endpoint (top-headlines) are these: business, entertainment, general, health, science, sports and technology
 @Test
public void testSearch2API() throws NewsAPIException {
	final NewsAPIService newsSearchService= NewsAPI.getNewsAPIService();
	final List<newsinfo> results= newsSearchService.getTopHeadlinesForCategory("gr", "business");
	Assert.assertFalse(results.isEmpty());
	results.forEach(System.out::println);
}  
 
//endpoint everything
//It has to be referred that according to documentation in https://newsapi.org/docs/endpoints/everything, category as a parameter is not supported. So, category is not included for news about this endpoint
 
//Finds everything news about query "Apple"
//User can type whatever query wants
 @Test
public void testSearch3API() throws NewsAPIException {
	final NewsAPIService newsSearchService= NewsAPI.getNewsAPIService();
	final List<newsinfo> results= newsSearchService.searchEverythingNewsForQuery("Apple");
	Assert.assertFalse(results.isEmpty());
	results.forEach(System.out::println);
} 
 
//Finds everything news about query "Apple" in english language and sources "bbc-news"
//User can type whatever query wants
//According to documentation in https://newsapi.org/docs/endpoints/everything,
//possible languages for endpoint (everything) 
//are these: ar-de-en-es-fr-he-it-nl-no-pt-ru-se-ud and zh
//That means, greek language is not supported 
//User can type whatever sources wants
  @Test
public void testSearch4API() throws NewsAPIException {
	final NewsAPIService newsSearchService= NewsAPI.getNewsAPIService();
	final List<newsinfo> results= newsSearchService.searchEverythingNewsForSources("Apple", "en", "bbc-news");
	Assert.assertFalse(results.isEmpty());
	results.forEach(System.out::println);
} 
  
//Finds everything news about query "Apple" in english language
//User can type whatever query wants
//According to documentation in https://newsapi.org/docs/endpoints/everything,
//possible languages for endpoint (everything) 
//are these: ar-de-en-es-fr-he-it-nl-no-pt-ru-se-ud and zh
//That means, greek language is not supported 
 @Test
public void testSearch5API() throws NewsAPIException {
	final NewsAPIService newsSearchService= NewsAPI.getNewsAPIService();
	final List<newsinfo> results= newsSearchService.getSearchEverythingNewsForLanguage("Apple", "en");
	Assert.assertFalse(results.isEmpty());
	results.forEach(System.out::println);
} 
 
//Finds everything news about query "Apple" in english language and sources "bbc-news" from 25/01/2022 to 31/01/2022
//User can type whatever query wants
//According to documentation in https://newsapi.org/docs/endpoints/everything,
//possible languages for endpoint (everything) 
//are these: ar-de-en-es-fr-he-it-nl-no-pt-ru-se-ud and zh
//That means, greek language is not supported 
//User can type whatever sources wants
//User can also type whatever dates (from&to) wants.
  @Test
 public void testSearch6API() throws NewsAPIException {
	final NewsAPIService newsSearchService= NewsAPI.getNewsAPIService();
	final List<newsinfo> results= newsSearchService.searchEverythingNewsForDateOfPublication("Apple", "en", "bbc-news", "2022-01-25", "2022-01-31");
	Assert.assertFalse(results.isEmpty());
	results.forEach(System.out::println);
}    
  

} 
