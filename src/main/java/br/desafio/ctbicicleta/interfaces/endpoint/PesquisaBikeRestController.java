package br.desafio.ctbicicleta.interfaces.endpoint;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.desafio.ctbicicleta.application.commandservices.PesquisaBikeCommandService;
import br.desafio.ctbicicleta.interfaces.endpoint.dto.PesquisaBikeCommand;
import br.desafio.ctbicicleta.interfaces.endpoint.dto.PesquisaBikeRetornoDTO;
import br.desafio.ctbicicleta.resources.exception.RegraDeNegocioException;
import br.desafio.ctbicicleta.util.enumeration.TipoTerronoEnum;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("pesquisabike")
@Api(value = "Pesquisa Bike", description = "Endpoints para manipular busca de bike", tags = "Pesquisa Bike")
public class PesquisaBikeRestController  {

	

	

	
	@Autowired
	private PesquisaBikeCommandService pesquisaBikeCommandService;

	
	@GetMapping(path = "/{km}/{tipoTerreno}}")
	public ResponseEntity<PesquisaBikeRetornoDTO> find(@NotNull(message = "text.required") @PathVariable("km") Integer km
			,@NotNull(message = "text.required") @PathVariable("tipoTerreno") String tipoTerreno) throws RegraDeNegocioException {
		
		log.debug("InvokeService: /pesquisabike/, Action: GET ");

		PesquisaBikeCommand command = new PesquisaBikeCommand();
		command.setKmMes(km);
		command.setTipoTerreno(TipoTerronoEnum.getTipoSorteioByDescricao(tipoTerreno));
		
		if (Objects.isNull(command.getTipoTerreno())){
			throw new RegraDeNegocioException("Tipo do terreno inválido!");
		}
		
		PesquisaBikeRetornoDTO dtoRet = pesquisaBikeCommandService.find(command);
		return new ResponseEntity<>(dtoRet, HttpStatus.OK);
	
	}
	

}
