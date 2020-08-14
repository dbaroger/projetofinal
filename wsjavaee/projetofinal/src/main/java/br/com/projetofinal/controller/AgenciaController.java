package br.com.projetofinal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.dao.AgenciaDAO;
import br.com.projetofinal.model.Agencia;

@RestController
@CrossOrigin("*")
public class AgenciaController {
	
	@Autowired
	private AgenciaDAO adao;

	
	@PostMapping("/agencias")
	public ResponseEntity<List<Agencia>> agencias(){
		ArrayList<Agencia> lista =
				(ArrayList<Agencia>) adao.findAll();
				if(lista.size()==0) {
					return ResponseEntity.status(403).build();
				}
				return ResponseEntity.ok(lista);
	}	 
}


