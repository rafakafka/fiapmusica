package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.MusicaDTO;

@RestController
@RequestMapping("musicas")
public class MusicaController {

	@GetMapping
	public List<String> getMusicas(){
		
		MusicaDTO musicaDTO1 = new MusicaDTO();
		musicaDTO1.setId(1);
		musicaDTO1.setTitulo("Sozinho");
		musicaDTO1.setDuracao(300);
		musicaDTO1.setAutor("Caetano Veloso");
		
		MusicaDTO musicaDTO2 = new MusicaDTO();
		musicaDTO2.setId(1);
		musicaDTO2.setTitulo("Voce");
		musicaDTO2.setDuracao(250);
		musicaDTO2.setAutor("Tim Maia");
		
		List<MusicaDTO> musicaDTOList = new ArrayList<>();
		musicaDTOList.add(musicaDTO1);
		musicaDTOList.add(musicaDTO2);
		
		return new ArrayList<>();
		}
}