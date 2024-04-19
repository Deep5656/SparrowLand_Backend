package com.sparrowland.sparrow.controller;

import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparrowland.sparrow.entity.Bird;
import com.sparrowland.sparrow.service.BirdService;
//import com.sun.tools.javac.util.Log;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/bird/rest/v1/us")
@CrossOrigin("*")
@Slf4j
public class BirdController {
	
	@Autowired
	private BirdService birdService;
	
	@GetMapping("/getAllBirds")
	public ResponseEntity<Collection<Bird>> getAllBirds(){
		Collection<Bird> allBirds = this.birdService.allBirds();
		return ResponseEntity.status(HttpStatus.OK).body(allBirds);
	}
	
//	@PostMapping("/createBird")
//	public void createNewBird(@RequestBody Bird bird,@RequestPart("file")MultipartFile file) throws IOException {
////		Bird bird = new Bird();
//		bird.setImage(file.getBytes());
//		this.birdService.createBird(bird);
//	}
	
//	@PostMapping("/createBird")
//	public void createNewBird(@RequestPart("bird") String birdJson, @RequestPart("file") MultipartFile file) throws IOException {
//	    ObjectMapper objectMapper = new ObjectMapper();
//	    Bird bird = objectMapper.readValue(birdJson, Bird.class);
//	    bird.setImage(file.getBytes());
//	    this.birdService.createBird(bird);
//	}
//	
	@PostMapping("/createBird")
	public void createNewBird(@RequestParam String title,@RequestParam String subTitle, @RequestParam String about, @RequestPart("file") MultipartFile file) throws IOException {
	    Bird bird = new Bird();
	    bird.setTitle(title);
	    bird.setSubTitle(subTitle);
	    bird.setAbout(about);
	    bird.setImage(file.getBytes());
	    this.birdService.createBird(bird);
	}

	
	@PostMapping("/updateBird")
	public void updateNewBird(@RequestParam int id,@RequestParam String title,@RequestParam String subTitle, @RequestParam String about, @RequestPart("file") MultipartFile file) throws IOException {
//		int BirdId = bird.getId();
		Bird singleBird = this.birdService.singleBird(id);
//		singleBird.setTitle(bird.getTitle());
//		singleBird.setAbout(bird.getAbout());
//		singleBird.setSubTitle(bird.getSubTitle());
		singleBird.setTitle(title);
		singleBird.setSubTitle(subTitle);
		singleBird.setAbout(about);
		singleBird.setImage(file.getBytes());
		this.birdService.updateBird(singleBird);
	}
	
	@PostMapping("/deleteBird")
	public void removeNewBird(@RequestBody Bird bird) {
		this.birdService.removeBird(bird);
	}
	
	
	
	
	

}
