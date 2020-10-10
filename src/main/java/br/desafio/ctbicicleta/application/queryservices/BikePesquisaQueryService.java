package br.desafio.ctbicicleta.application.queryservices;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.desafio.ctbicicleta.domain.model.aggregates.BikePesquisa;
import br.desafio.ctbicicleta.repositories.BikePesquisaRepository;
import br.desafio.ctbicicleta.util.enumeration.TipoEnum;

@Service
public class BikePesquisaQueryService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5003380932998445371L;

	@Autowired
	private BikePesquisaRepository bikePesquisaRepository;

	public Optional<BikePesquisa> findById(long id) {
		return bikePesquisaRepository.findById(id);
	}

	public List<BikePesquisa> findAll() {
		List<BikePesquisa> listRet = new ArrayList<>();
	

		return listRet;
	}

	public List<BikePesquisa> findFirst10(TipoEnum tipo){
		return bikePesquisaRepository.findFirst10ByTipoOrderByPrecoDesc(tipo);
	 }
	

	public  List<BikePesquisa> findByTipo(TipoEnum tipo){
		return bikePesquisaRepository.findByTipoOrderByPrecoDesc(tipo);
	}
}
