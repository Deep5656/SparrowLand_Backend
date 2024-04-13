package com.sparrowland.sparrow.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparrowland.sparrow.entity.Bird;
import com.sparrowland.sparrow.repository.BirdRepository;
import com.sparrowland.sparrow.service.BirdService;

@Service
public class BirdServiceImpl implements BirdService {

	@Autowired
	private BirdRepository birdRepository;

	@Override
	public Collection<Bird> allBirds() {
		List<Bird> allBirds = this.birdRepository.findAll();
		return allBirds;
	}

	@Override
	public void createBird(Bird bird) {
		this.birdRepository.save(bird);
	}

	@Override
	public void updateBird(Bird bird) {
        this.birdRepository.save(bird);
	}

	@Override
	public void removeBird(Bird bird) {
		int birdId = bird.getId();
		this.birdRepository.deleteById(birdId);
	}

	@Override
	public Bird singleBird(int id) {
		Bird exactBird = this.birdRepository.findById(id).get();
		return exactBird;
		
	}

}
