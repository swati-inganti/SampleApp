package com.ToDo.ToDo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo.todo.data.ToDo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToDoRestControllerTest {
	
	@Autowired
	public TestRestTemplate restTemplate;
	
	public String getRootUrl() {
		return "http://localhost:8081/myapp" ;
	}
	
	//Junit for positive response
	@Test
    public void testSaveTodo() throws URISyntaxException {
		ToDo rec = new ToDo(100, "Grocery", "get groceries", new Date(1L), new Date(1L));
		final String baseUrl = getRootUrl() + "/save-todo";
        URI uri = new URI(baseUrl);
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");  
        HttpEntity<ToDo> request = new HttpEntity<>(rec, headers);
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
         
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
    }
	
	//Junit for error response/ incorrect URL
	@Test
    public void testSaveTodoNeg() throws URISyntaxException {
		ToDo rec = new ToDo(100, "Grocery", "get groceries", new Date(1L), new Date(1L));
		final String baseUrl = getRootUrl(); //+ "/save-todo";
        URI uri = new URI(baseUrl);
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");  
        HttpEntity<ToDo> request = new HttpEntity<>(rec, headers);
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
         
        //Verify request succeed
        assertEquals(404, result.getStatusCodeValue());
    }
	
	@Test
    public void testGetTodo() throws URISyntaxException {
		final String baseUrl = getRootUrl() + "/get-todo-by-id/100";
        URI uri = new URI(baseUrl);
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");  
        ResponseEntity<String> result = this.restTemplate.getForEntity(uri,  String.class);
         System.out.println("result is " +result.getBody());
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(true, result.hasBody());
    }
	
	@Test
    public void testGetTodoList() throws URISyntaxException {
		final String baseUrl = getRootUrl() + "/get-todo-listing";
        URI uri = new URI(baseUrl);
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");  
        ResponseEntity<String> result = this.restTemplate.getForEntity(uri,  String.class);
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(true, result.hasBody());
    }

}
