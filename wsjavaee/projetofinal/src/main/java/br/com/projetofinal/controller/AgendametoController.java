package br.com.projetofinal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.dao.AgendamentoDAO;
import br.com.projetofinal.model.Agendamento;

@RestController
@CrossOrigin("*")
public class AgendametoController {
	
	@Autowired
	private AgendamentoDAO adao;
	
	@PostMapping("/novoagendamento")
	public ResponseEntity<Agendamento> novo(@RequestBody Agendamento agendamento){
		try {
			adao.save(agendamento);
			return ResponseEntity.ok(agendamento);
		}catch(Exception e){
			return ResponseEntity.status(403).build();
		}
	}
	
	@PostMapping("/relatorioporagencia")
	public ResponseEntity<List<Agendamento>> agendamentoAgencia(@RequestBody Agendamento agendamento){
		ArrayList<Agendamento> lista =
				(ArrayList<Agendamento>) adao.findByAgenciaId(agendamento.getAgencia().getId());
				if(lista.size()==0) {
					return ResponseEntity.status(403).build();
				}
				return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/relatoriopornomecli")
	public ResponseEntity<List<Agendamento>> agendamentoCliente(@RequestBody Agendamento agendamento){
		ArrayList<Agendamento> lista =
				(ArrayList<Agendamento>) adao.findByNomeCli((agendamento.getNomeCli()));
				if(lista.size()==0) {
					return ResponseEntity.status(403).build();
				}
				return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/relatoriopordata")
	public ResponseEntity<List<Agendamento>> agendamentoData(@RequestBody Agendamento agendamento){
		ArrayList<Agendamento> lista =
				(ArrayList<Agendamento>) adao.findByDataAgendamento((agendamento.getDataAgendamento()));
				if(lista.size()==0) {
					return ResponseEntity.status(403).build();
				}
				return ResponseEntity.ok(lista);
	}
		
	@PostMapping("/relatoriopoclientedata")
	public ResponseEntity<List<Agendamento>> agendamentoClienteData(@RequestBody Agendamento agendamento){
		ArrayList<Agendamento> lista =
				(ArrayList<Agendamento>) adao.findByNomeCliAndDataAgendamento(agendamento.getNomeCli(),agendamento.getDataAgendamento());
				if(lista.size()==0) {
					return ResponseEntity.status(403).build();
				}
				return ResponseEntity.ok(lista);
	}

	@PostMapping("/relatorioporagenciacliente")
	public ResponseEntity<List<Agendamento>> agendamentoAgenciaClinte(@RequestBody Agendamento agendamento){
		ArrayList<Agendamento> lista =
				(ArrayList<Agendamento>) adao.findByAgenciaIdAndNomeCli(agendamento.getAgencia().getId(), agendamento.getNomeCli());
				if(lista.size()==0) {
					return ResponseEntity.status(403).build();
				}
				return ResponseEntity.ok(lista);
	}
		
	
	@PostMapping("/relatorioporagenciadata")
	public ResponseEntity<List<Agendamento>> agendamentoAgenciaData(@RequestBody Agendamento agendamento){
		ArrayList<Agendamento> lista =
				(ArrayList<Agendamento>) adao.findByAgenciaIdAndDataAgendamento(agendamento.getAgencia().getId(), agendamento.getDataAgendamento());
				if(lista.size()==0) {
					return ResponseEntity.status(403).build();
				}
				return ResponseEntity.ok(lista);
	}
		
	@PostMapping("/relatorioporagenciadatacliente")
	public ResponseEntity<List<Agendamento>> agendamentoAgenciaDataCliente(@RequestBody Agendamento agendamento){
		ArrayList<Agendamento> lista =
				(ArrayList<Agendamento>) adao.findByAgenciaIdAndDataAgendamentoAndNomeCli(agendamento.getAgencia().getId(), agendamento.getDataAgendamento(), agendamento.getNomeCli());
				if(lista.size()==0) {
					return ResponseEntity.status(403).build();
				}
				return ResponseEntity.ok(lista);
	}	 
		

}
