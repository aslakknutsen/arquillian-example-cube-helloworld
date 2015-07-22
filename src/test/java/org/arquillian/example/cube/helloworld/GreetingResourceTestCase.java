package org.arquillian.example.cube.helloworld;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.jayway.restassured.http.ContentType;

@RunWith(Arquillian.class)
public class GreetingResourceTestCase {

	@Deployment(testable = false)
	public static WebArchive deploy() {
		return ShrinkWrap.create(WebArchive.class)
				.addClasses(GreetingResource.class,
						    GreetingService.class,
						    GreetingApplication.class);
	}
	
	@ArquillianResource
	private URL baseURL;
	
	@Test
	public void shouldGreetTheWorld() throws Exception {
      	    given().
				pathParam("name","World").
				accept(ContentType.JSON).
			when().
				get(new URL(baseURL, "api/greet/{name}")).
			then().
			    log().all().
			    contentType(ContentType.JSON).
			    body("name", equalTo("World")).
			    body("greeting", equalTo("Hello, World!"));
	}
}
