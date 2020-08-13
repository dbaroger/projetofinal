package br.com.projetofinal.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class MusicaController {
	/*
	@Autowired
	private MusicaDAO mdao;
	
	@PostMapping("/novamusica")
	public ResponseEntity<Musica> nova(@RequestBody Musica musica){
		try {
			mdao.save(musica);
			return ResponseEntity.ok(musica);
		}catch(Exception e){
			return ResponseEntity.status(403).build();
		}
	}
*/
}
