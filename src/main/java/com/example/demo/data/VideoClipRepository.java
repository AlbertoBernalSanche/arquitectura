package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Videoclip;

@Repository
public interface VideoClipRepository extends JpaRepository<Videoclip, Long>{

	
	
	
}
