package com.example.consumer.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerApplication {

	private static RestTemplate httpClient = null;

	private static String baseURL = "http://localhost:8080/";

	private static String defaultGreetingURL = "greeting";
	private static String namedGreetingURL = "greeting/name?name=<Sahan Sandeepa>";

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
		makeCalls();
	}

	private static RestTemplate getHttpClient(){
		if(httpClient == null){
			httpClient = new RestTemplate();
		}

		return httpClient;
	}

	private static Greeting getGreeting(String url){
		RestTemplate restmp = getHttpClient();
		Greeting response = restmp.getForObject(baseURL + "/" + url, Greeting.class);

		return response;
	}

	private static Greeting getGreetingByName(String url){
		RestTemplate restmp = getHttpClient();
		Greeting response = restmp.getForObject(baseURL + "/" + url, Greeting.class);

		return response;
	}

	private static void makeCalls() {
		Greeting recievedGreeting1 = ConsumerApplication.getGreeting(defaultGreetingURL);
		Greeting recievedGreeting2 = ConsumerApplication.getGreeting(namedGreetingURL);
		
		String content1 = recievedGreeting1.content();
		System.out.println(content1);

		String content2 = recievedGreeting2.content();
		System.out.println(content2);


	}
		
}
