package newsapi;

import services.NewsAPIService;

//This class is used to initialize NewsAPIService
public class NewsAPI {
	public static NewsAPIService getNewsAPIService() {
		//type your apiKey as second parameter
		return new NewsAPIService ("https://newsapi.org/", "apiKey");
	}
}
