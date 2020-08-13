package br.com.projetofinal.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.projetofinal.model.Agencia;

public interface AgenciaDAO  extends CrudRepository<Agencia,Integer> {

}
