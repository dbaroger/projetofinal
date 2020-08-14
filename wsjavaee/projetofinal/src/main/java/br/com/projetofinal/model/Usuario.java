package br.com.projetofinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itmn032_usuario")
public class Usuario {
		
		@Column(name="racf", length=7)
		@Id
		private String racf;
		
		@Column(name="email", length=100)
		private String email;
		
		@Column(name="senha", length=20)
		private String senha;
		
		@Column(name="nome", length=100)
		private String nome;
		
		@Column(name="foto", length=100)
		private String foto;

		public String getRacf() {
			return racf;
		}

		public void setRacf(String racf) {
			this.racf = racf;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public Usuario(String racf, String email, String senha, String nome, String foto) {
			super();
			this.racf = racf;
			this.email = email;
			this.senha = senha;
			this.nome = nome;
			this.foto = foto;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getFoto() {
			return foto;
		}

		public void setFoto(String foto) {
			this.foto = foto;
		}

		public Usuario() {
			super();
		}
				
}

