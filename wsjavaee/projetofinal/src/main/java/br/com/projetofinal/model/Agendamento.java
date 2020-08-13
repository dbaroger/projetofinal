package br.com.projetofinal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="itmn032_agendamento")
public class Agendamento {
	
	@Column(name="num_seq")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numSeq;
	
	@Column(name="nome_cli", length=100)
	private String nomeCli;
	
	@Column(name="email_cli", length=100)
	private String email;
	
	@Column(name="celular_cli", length=20)
	private String celular;
	
	@Column(name="data_agendamento")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date dataAgendamento;
	
	@Column(name="hora_agendamento", length=5)
	private String horaAgendamento;
	
	@Column(name="observacao", length=255)
	private String observacao;
	
	@JsonIgnoreProperties("agendamentos")
	@ManyToOne
	private Agencia agencia;

	public int getNumSeq() {
		return numSeq;
	}

	public void setNumSeq(int numSeq) {
		this.numSeq = numSeq;
	}

	public String getNomeCli() {
		return nomeCli;
	}

	public void setNomeCli(String nomeCli) {
		this.nomeCli = nomeCli;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getHoraAgendamento() {
		return horaAgendamento;
	}

	public void setHoraAgendamento(String horaAgendamento) {
		this.horaAgendamento = horaAgendamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Agendamento(int numSeq, String nomeCli, String email, String celular, Date dataAgendamento,
			String horaAgendamento, String observacao, Agencia agencia) {
		super();
		this.numSeq = numSeq;
		this.nomeCli = nomeCli;
		this.email = email;
		this.celular = celular;
		this.dataAgendamento = dataAgendamento;
		this.horaAgendamento = horaAgendamento;
		this.observacao = observacao;
		this.agencia = agencia;
	}

	public Agendamento() {
		super();
	}
	
	
	

}
