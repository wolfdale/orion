package com.explore.customer;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringDemoApplicationTests {
	@LocalServerPort private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test public void testCreateStudent() throws Exception {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> entity = new HttpEntity<String>(
				"{\n" + "  \"firstName\": \"Stefanie\",\n" + "  \"lastName\": \"Van den Broek\",\n"
						+ "  \"email\": \"svandenbroek0@cargocollective.com\",\n" + "  \"gender\": \"Female\",\n"
						+ "  \"creditCard\": \"6706748377570641\",\n" + "  \"creditCardType\": \"laser\"\n" + "}",
				headers);

		ResponseEntity<String> response = restTemplate
				.exchange(createURLWithPort("/api/customer"), HttpMethod.POST, entity, String.class);

		assertEquals(200, response.getStatusCode().value());
	}
}
