package br.desafio.ctbicicleta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.desafio.ctbicicleta.domain.model.entities.Acessorios;



@Repository
public interface AcessoriosRepository extends JpaRepository<Acessorios, Long> {
	
}
