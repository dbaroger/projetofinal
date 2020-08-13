package br.com.projetofinal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="itmn032_agencia")
public class Agencia {

	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome_agencia", length=100)
	private String nomeAgencia;
	
	@Column(name="hora_inicio")
	private int horaInicio;
	
	@Column(name="hora_fim")
	private int horaFim;
	
	@JsonIgnoreProperties("agencia")
	@OneToMany(cascade=CascadeType.ALL, mappedBy="agencia")
	private List<Agendamento> agendamentos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeAgencia() {
		return nomeAgencia;
	}
	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}
	public int getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}
	public int getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(int horaFim) {
		this.horaFim = horaFim;
	}


	public Agencia(int id, String nomeAgencia, int horaInicio, int horaFim, List<Agendamento> agendamentos) {
		super();
		this.id = id;
		this.nomeAgencia = nomeAgencia;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.agendamentos = agendamentos;
	}
	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}
	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
	public Agencia() {
		super();
	}
	

	
}

