package br.com.projetofinal.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")   // libera o acesso externo para a Controller   
public class ArtistaController {
/*
	@Autowired
	private ArtistaDAO adao;
	
	@GetMapping("/artistas")   // como o frontend vai chamar na url
	public ResponseEntity<List<Artista>> retornarArtistas(){
		ArrayList<Artista> lista = (ArrayList<Artista>) adao.findAll();
		if (lista.size()==0) {
			return ResponseEntity.notFound().build();
			//return ResponseEntity.status(404).build();  posso usar o metodo status para jogar um codigo de erro desejado. O 404 tem o proprio .notFound()
			//return ResponseEntity.status(403).build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/artista/{id}")
	public ResponseEntity<Artista> pesquisarPorCodigo(@PathVariable int id){
		Artista objeto = adao.findById(id).orElse(null);
		if(objeto==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(objeto);
	}
	
	@PostMapping("/nacionalidade")
	public ResponseEntity<List<Artista>> pesquisarPorNacionalidade(@RequestBody Artista artista){
		ArrayList<Artista> lista = (ArrayList<Artista>) adao.findByNacionalidade(artista.getNacionalidade());
		if (lista.size()==0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/nacionalidade2/{nac}")
	public ResponseEntity<List<Artista>> pesquisarNac(@PathVariable String nac){
		ArrayList<Artista> resposta = (ArrayList<Artista>) adao.findByNacionalidade(nac);
		if (resposta.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resposta);
	}
	
	@GetMapping("/nacionalidade3/{nac}")
	public ResponseEntity<List<Artista>> pesquisaTeste(@PathVariable String nac){
		ArrayList<Artista> lista = (ArrayList<Artista>) adao.findByNacionalidade(nac);
		List<Artista> resultado = new ArrayList<Artista>();
		for (Artista a : lista) {
			char ultimo = a.getNomeArtistico().toUpperCase().charAt(a.getNomeArtistico().length()-1);
			if (ultimo=='O') {
				resultado.add(a);
			}
		}
		
		if (resultado.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resultado);
	}
	
		
	@PostMapping("/gravar")
	public ResponseEntity<Artista> gravarArtista(@RequestBody Artista artista){
		try {
			adao.save(artista);
			return ResponseEntity.ok(artista);
		}catch(Exception e){
			return ResponseEntity.status(403).build();	
		}
	}
*/
}



