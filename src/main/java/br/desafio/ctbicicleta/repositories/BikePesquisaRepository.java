package br.desafio.ctbicicleta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.desafio.ctbicicleta.domain.model.aggregates.BikePesquisa;
import br.desafio.ctbicicleta.util.enumeration.TipoEnum;




@Repository
public interface BikePesquisaRepository extends JpaRepository<BikePesquisa, Long> {
	 
	 public List<BikePesquisa> findFirst10ByTipoOrderByPrecoDesc(TipoEnum tipo);
	 
	 public List<BikePesquisa> findByTipoOrderByPrecoDesc(TipoEnum tipo);
}
