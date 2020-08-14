package br.com.projetofinal.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.projetofinal.model.Agendamento;

public interface AgendamentoDAO  extends CrudRepository<Agendamento,Integer> {
	
	public List<Agendamento> findByDataAgendamento(Date data);
	public List<Agendamento> findByNomeCli(String cliente);
	public List<Agendamento> findByAgenciaId(int id);
	public List<Agendamento> findByNomeCliAndDataAgendamento(String cliente, Date data);
	public List<Agendamento> findByAgenciaIdAndNomeCli(int id, String cliente);
	public List<Agendamento> findByAgenciaIdAndDataAgendamento(int id, Date data);
	public List<Agendamento> findByAgenciaIdAndDataAgendamentoAndNomeCli(int id, Date data, String nome);
	

}
