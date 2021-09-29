package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.Videoclip;

public interface VideoClipPresentation {

	public List<Videoclip> findAll();
	
	public int contarNumeroPalabras(Long idVideoClip);
	
	public List<Videoclip> filtrarVideosMenosTresPalabras();
	
	public List<Videoclip> filtrarVideosConIgualOMasDeDiezPalabras();
	
	public void borrarVideosConMenosDeTresPalabras();
	
	public void guardarVideosConMasDeDiezPalabras(Videoclip videoclip);
	
	public List<Videoclip> borrarVideosConPalabrasGroseras();
	
	
	
	
}
