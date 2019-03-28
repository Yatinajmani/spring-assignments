package ttn.spring.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/posts")
public class PostController {
    @GetMapping("/{id}")
    public String getPost(@PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response.getStatusCode().toString());
        System.out.println(response.getHeaders().toString());
        return response.getBody();
    }

    @PostMapping("/")
    public ResponseEntity<Object> createPost(@RequestBody Object object) {
        String url = "https://jsonplaceholder.typicode.com/posts";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-type", "application/json; charset=UTF-8");
        HttpEntity<Object> request = new HttpEntity<>(object, httpHeaders);
        Object post = restTemplate.postForObject(url, request, Object.class);
        System.out.println(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public void updatePost(@RequestBody Object object) {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-type", "application/json; charset=UTF-8");
        HttpEntity<Object> request = new HttpEntity<>(object, httpHeaders);
        restTemplate.put(url, object);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-type", "application/json; charset=UTF-8");
        HttpEntity<Object> request = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(url, HttpMethod.DELETE, request, Object.class);
    }

}
