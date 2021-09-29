package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.data.VideoClipRepository;
import com.example.demo.domain.Videoclip;
import com.example.demo.services.VideoClipPresentation;
import com.example.demo.services.VideoClipPresentationImpl;

@SpringBootApplication
public class PatronCapasArquitecturaApplication implements CommandLineRunner{

	@Autowired 
	VideoClipPresentationImpl videoClipPresentationImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(PatronCapasArquitecturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		System.out.println(videoClipPresentationImpl.contarNumeroPalabras(1L));
		
		
		
		
		
		
		
		for (int i = 0; i < videoClipPresentationImpl.filtrarVideosMenosTresPalabras().size(); i++) {
			
			
			System.out.println(videoClipPresentationImpl.filtrarVideosMenosTresPalabras().get(i).getSubtitulos());
			
		}
		
		
	}

}
