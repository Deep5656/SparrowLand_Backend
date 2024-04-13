package com.sparrowland.sparrow.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sparrowland.sparrow.entity.Bird;

@Service
public interface BirdService {

	public Collection<Bird>allBirds();
	
	public Bird singleBird(int id);
	
	public void createBird(Bird bird);
	
	public void updateBird(Bird bird);
	
	public void removeBird(Bird bird);
}
