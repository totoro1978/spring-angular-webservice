package com.totoro3.webservice.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.totoro3.webservice.dto.posts.PostsSaveRequestDto;
import com.totoro3.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

	private PostsService postsService;

	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}

	@PostMapping("/posts")
	@CrossOrigin(origins="*", maxAge=3600)
	public long savePosts(@RequestBody PostsSaveRequestDto dto) {
		return postsService.save(dto);
	}

	@GetMapping("/posts")
	@CrossOrigin(origins="*", maxAge=3600)
	public ResponseEntity<List> main(Model model) {
		return new ResponseEntity<List> (postsService.findAllDesc(), HttpStatus.OK);
	}
}
