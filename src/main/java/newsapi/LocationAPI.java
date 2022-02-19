package newsapi;

import services.LocationbyIpDetection;

//This class is used to initialize LocationbyIPDetection
public class LocationAPI {
	public static LocationbyIpDetection getLocationbyIPDetection() {
		//Type your apiKey and your ipv6 address as second and third parameter
		return new LocationbyIpDetection ("https://ip-geolocation.whoisxmlapi.com/", "at_wSkv8q3YOk6PgE0z9D3Rv5BYO3hrb", "2a02:587:1e04:e0ec:d478:cbdb:3e48:1789"); 
		
}
}
