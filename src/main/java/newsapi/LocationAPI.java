package newsapi;

import services.LocationbyIpDetection;

//This class is used to initialize LocationbyIPDetection
public class LocationAPI {
	public static LocationbyIpDetection getLocationbyIPDetection() {
		//Type your apiKey and your ipv6 address as second and third parameter
		return new LocationbyIpDetection ("https://ip-geolocation.whoisxmlapi.com/", "apiKey, "ipv6"); 
		
}
}
