package br.com.projetofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.dao.UsuarioDAO;
import br.com.projetofinal.model.Usuario;

@RestController     // para que a classe responda aos protocolos HTTP
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioDAO udao;
	
	@PostMapping("/loginbyracf")
    public ResponseEntity<Usuario> logarRacf(@RequestBody Usuario usuario){
        Usuario objeto = udao.findByRacfAndSenha(usuario.getRacf(), usuario.getSenha());
        if (objeto==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(objeto);
    }
	
	@PostMapping("/loginbyemail")
    public ResponseEntity<Usuario> logarEmail(@RequestBody Usuario usuario){
        Usuario objeto = udao.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
        if (objeto==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(objeto);
    }
	
}
