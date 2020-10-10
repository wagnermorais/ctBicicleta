package br.desafio.ctbicicleta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.desafio.ctbicicleta.domain.model.entities.KmAcessorios;



@Repository
public interface KmAcessoriosRepository extends JpaRepository<KmAcessorios, Integer> {
	
}
