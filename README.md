The project is seperated in two parts. So, there are two repositories (NewsAPI and NewsAPP). The first part is about building the library NewsAPI and the second one is about building application named NewsAPP which is about getting top-headlines news or everything news according to specific criterias.

The library «NewsAPI» can be found in this repository.

In order to get news, user has to get firstly their apiKey from https://newsapi.org/ and https://ip-geolocation.whoisxmlapi.com/. Then, they have to write them as second parameter in class getNewsAPIService (which is inside class NewsAPI) and class getLocationbyIPDetection (which is inside class LocationAPI). Additionally, user has to type also his/her ipv6 address in class getLocationbyIPDetection as third parameter.

For the convenience of the user, there are already some ready tests in class NewsAPITest for getting news. If user wants to test something else, they have just to change the given parameters to other parameters they want.
