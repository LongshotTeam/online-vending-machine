package com.vendingmachine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//@SpringBootTest(classes = SpringBootHelloWorldApplication.class, 
//webEnvironment = WebEnvironment.RANDOM_PORT)
public class VendingmachineTests {

	private String HEALTH_ENDPOINT="/";
	
	@Test
	public void check_the_server_status() {
		response = getResponse(HEALTH_ENDPOINT);
		assertEquals(response.getStatusCode(),HttpStatus.OK);
	}
	
	private ResponseEntity<String> response;

	private final RestTemplate restTemplate = new RestTemplate();
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + 5000 + uri;
	}

	public ResponseEntity<String> getResponse(String uri) {
		HttpEntity<String> requestEntity = new HttpEntity<>(null, null);
		
		response =restTemplate.exchange(createURLWithPort(uri), HttpMethod.GET,
				requestEntity, String.class);
		
		return response;
	}
}
