package com.sparrowland.sparrow.controller;

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
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("/createBird")
	public void createNewBird(@RequestBody Bird bird){
		this.birdService.createBird(bird);
		
	}
	
	@PostMapping("/updateBird")
	public void updateNewBird(@RequestBody Bird bird) {
		int BirdId = bird.getId();
		Bird singleBird = this.birdService.singleBird(BirdId);
		singleBird.setTitle(bird.getTitle());
		singleBird.setAbout(bird.getAbout());
		singleBird.setSubTitle(bird.getSubTitle());
		this.birdService.updateBird(singleBird);
	}
	
	@PostMapping("/deleteBird")
	public void removeNewBird(@RequestBody Bird bird) {
		this.birdService.removeBird(bird);
	}
	
	
	
	
	

}
