package com.sparrowland.sparrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparrowland.sparrow.entity.Bird;

public interface BirdRepository extends JpaRepository<Bird, Integer> {

}
