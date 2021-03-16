package br.com.fiap.fiapmusica.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.fiapmusica.dto.MusicaDTO;
import br.com.fiap.fiapmusica.dto.SimpleMusicaDTO;

@RestController
@RequestMapping("musicas")
public class MusicaController {
	
	private List<MusicaDTO> musicaMOCKList = new ArrayList<>();
	
	public MusicaController() {
		MusicaDTO musicaDTO1 = new MusicaDTO();
		musicaDTO1.setId(1);
		musicaDTO1.setTitulo("Sozinho");
		musicaDTO1.setDuracao(300);
		musicaDTO1.setAutor("Caetano Veloso");
		
		MusicaDTO musicaDTO2 = new MusicaDTO();
		musicaDTO2.setId(2);
		musicaDTO2.setTitulo("Voce");
		musicaDTO2.setDuracao(250);
		musicaDTO2.setAutor("Tim Maia");
		

		musicaMOCKList.add(musicaDTO1); 
		musicaMOCKList.add(musicaDTO2);
	}
	
	@GetMapping
	public List<SimpleMusicaDTO> getMusicas(@RequestParam(required = false) String titulo){
		
		return musicaMOCKList.stream()
				.filter(musicaDto -> titulo == null || musicaDto.getTitulo().contains(titulo))
				.map(musicaDTO -> new SimpleMusicaDTO(musicaDTO))
				.collect(Collectors.toList());
	}
	
	@GetMapping("{id}")
	public MusicaDTO getMusicaById(
			@PathVariable int id
	){		
		return musicaMOCKList.stream()
				.filter(musicaDTO -> musicaDTO.getId() == id)
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MusicaDTO criarMusica(
			@RequestBody MusicaDTO novaMusica
			) {
		MusicaDTO musicaDTO = new MusicaDTO();
		musicaDTO.setId(musicaMOCKList.size()+1);
		musicaDTO.setTitulo(novaMusica.getTitulo());
		musicaDTO.setDuracao(novaMusica.getDuracao());
		musicaDTO.setAutor(novaMusica.getAutor());
		
		musicaMOCKList.add(musicaDTO);
		return novaMusica;
		
	}
	
}