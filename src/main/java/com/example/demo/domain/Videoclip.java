package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="videoclip")
public class Videoclip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String subtitulos;
	private String url;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubtitulos() {
		return subtitulos;
	}
	public void setSubtitulos(String subtitulos) {
		this.subtitulos = subtitulos;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

	
	public Videoclip() {

	}
	
	public Videoclip(Long id, String subtitulos, String url) {
		super();
		this.id = id;
		this.subtitulos = subtitulos;
		this.url = url;
	}

	
	
	
	
	
	
}
