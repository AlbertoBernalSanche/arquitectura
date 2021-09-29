package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.data.VideoClipRepository;
import com.example.demo.domain.Videoclip;

@Component
@Scope("singleton")
public class VideoClipPresentationImpl implements VideoClipPresentation{

	@Autowired
	VideoClipRepository videoClipRepository;
	
	
	@Override
	public int contarNumeroPalabras(Long id) {

		Optional<Videoclip> videoClipOPT = videoClipRepository.findById(id);
		
		Videoclip videoClip = videoClipOPT.get();
		
		String subtitulos = videoClip.getSubtitulos();
		
		String[] palabras = subtitulos.split(" ");
		
		int tamanoPalabras = palabras.length;
		
		return tamanoPalabras;
	}

	@Override
	public List<Videoclip> filtrarVideosMenosTresPalabras() {
		
		List<Videoclip> videos = findAll();
		
		List<Videoclip> filtrados = new ArrayList<>();
		
		for (int i = 0; i < videos.size(); i++) {
			
			Long idVideo = videos.get(i).getId();
			
			if(contarNumeroPalabras(idVideo)<3) {
				filtrados.add(videos.get(i));
			}
			
		}
		
		return filtrados;
	}

	@Override
	public List<Videoclip> filtrarVideosConIgualOMasDeDiezPalabras() {

		List<Videoclip> videos = findAll();
		
		List<Videoclip> filtrados = new ArrayList<>();
		
		for (int i = 0; i < videos.size(); i++) {
			
			Long idVideo = videos.get(i).getId();
			
			if(contarNumeroPalabras(idVideo)>=10) {
				filtrados.add(videos.get(i));
			}
			
		}
		
		return filtrados;	
		
	}

	@Override
	public void borrarVideosConMenosDeTresPalabras() {

		List<Videoclip> videos = findAll();
		
		
		for (int i = 0; i < videos.size(); i++) {
			
			Long idVideo = videos.get(i).getId();
			
			if(contarNumeroPalabras(idVideo)<3) {

				videoClipRepository.delete(videos.get(i));
				
			}
			
		}
		
		
	}

	@Override
	public void guardarVideosConMasDeDiezPalabras(Videoclip videoclip) {
		
		
		videoClipRepository.save(videoclip);
		
		
	}

	@Override
	public List<Videoclip> borrarVideosConPalabrasGroseras() {
	
		String[] palabrasGroseras = {"MIERDA", "HIJUEPUTA"};
		
		List<Videoclip> videos = findAll();
			
		
		for (int i = 0; i < videos.size(); i++) {
			
			for (int j = 0; j < palabrasGroseras.length; j++) {
				
				if(videos.get(i).getSubtitulos().toUpperCase().contains(palabrasGroseras[j])) {
					
					
					videoClipRepository.delete(videos.get(i));
					
					
				}
				
			}
			
		}
		
		return videos;
		
		
	}


	@Override
	public List<Videoclip> findAll() {
		
		return videoClipRepository.findAll();
	}


}
