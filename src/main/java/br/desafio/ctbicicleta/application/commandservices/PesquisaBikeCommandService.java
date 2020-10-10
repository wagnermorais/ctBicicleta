package br.desafio.ctbicicleta.application.commandservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.desafio.ctbicicleta.application.queryservices.BikePesquisaQueryService;
import br.desafio.ctbicicleta.domain.model.aggregates.BikePesquisa;
import br.desafio.ctbicicleta.domain.model.entities.KmAcessorios;
import br.desafio.ctbicicleta.interfaces.endpoint.dto.AcessoriosDTO;
import br.desafio.ctbicicleta.interfaces.endpoint.dto.BikeRetornoDTO;
import br.desafio.ctbicicleta.interfaces.endpoint.dto.PesquisaBikeCommand;
import br.desafio.ctbicicleta.interfaces.endpoint.dto.PesquisaBikeDTO;
import br.desafio.ctbicicleta.interfaces.endpoint.dto.PesquisaBikeRetornoDTO;
import br.desafio.ctbicicleta.interfaces.endpoint.transform.DTOMapper;
import br.desafio.ctbicicleta.repositories.AcessoriosRepository;
import br.desafio.ctbicicleta.repositories.KmAcessoriosRepository;
import br.desafio.ctbicicleta.util.enumeration.CategoriaEnum;
import br.desafio.ctbicicleta.util.enumeration.TipoEnum;
import br.desafio.ctbicicleta.util.enumeration.TipoTerronoEnum;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Api(value = "Pesquisa Bike Command", description = "Serviços que atendem a todos comandos relacionados a pesquisa de melhor Bike", tags = "Bike Command")
public class PesquisaBikeCommandService {
	
	private static final int KM_100 = 100;
	private static final int KM_200 = 200;
	
	@Autowired
	private BikePesquisaQueryService  bikePesquisaQueryService;
	
	@Autowired
	private KmAcessoriosRepository kmAcessoriosRepository;
	
	public PesquisaBikeRetornoDTO find(PesquisaBikeCommand command) {
		List<BikePesquisa> list = new ArrayList<BikePesquisa>();
		List<BikePesquisa> listRet = new ArrayList<BikePesquisa>();
		Optional<KmAcessorios> acessorios ;
		
		if (command.getTipoTerreno().getCodigo().equals(TipoTerronoEnum.ASFALTO.getCodigo())) {
			list = bikePesquisaQueryService.findByTipo(TipoEnum.SPEED);
		}else if (command.getTipoTerreno().getCodigo().equals(TipoTerronoEnum.CIDADE.getCodigo())) {
			list = bikePesquisaQueryService.findByTipo(TipoEnum.URBANA);
		}else if (command.getTipoTerreno().getCodigo().equals(TipoTerronoEnum.MONTANHA.getCodigo())) {
			list = bikePesquisaQueryService.findByTipo(TipoEnum.MOUTAIN);
		}
		
		if (command.getKmMes() < KM_100) {
			listRet = list.stream().filter(s -> s.getCategoria().getCodigo().equals(CategoriaEnum.SIMPLES.getCodigo())).limit(10).collect(Collectors.toList());
			acessorios = kmAcessoriosRepository.findById(20);
		}else if (command.getKmMes() >= KM_100 && command.getKmMes() < KM_200) {
			listRet = list.stream().filter(s -> s.getCategoria().getCodigo().equals(CategoriaEnum.INTERMEDIARIA.getCodigo())).limit(10).collect(Collectors.toList());
			acessorios = kmAcessoriosRepository.findById(80);
		}else {
			listRet = list.stream().filter(s -> s.getCategoria().getCodigo().equals(CategoriaEnum.PROFISSIONAL.getCodigo())).limit(10).collect(Collectors.toList());
			acessorios = kmAcessoriosRepository.findById(130);
		}
		
		PesquisaBikeRetornoDTO dtoRetorno = new PesquisaBikeRetornoDTO();
		dtoRetorno.setKmMes(command.getKmMes());
		dtoRetorno.setTipoTerreno(command.getTipoTerreno().getDescricao());
		
		if (acessorios.isPresent()) {
			dtoRetorno.getAcessorios().addAll(DTOMapper.convertList(acessorios.get().getAcessorios(), AcessoriosDTO.class));
		}
		
		dtoRetorno.getBikes().addAll(DTOMapper.convertList(listRet, BikeRetornoDTO.class));
		
		
		return dtoRetorno;
	}
	

}
