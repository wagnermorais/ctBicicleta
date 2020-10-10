package br.desafio.ctbicicleta.interfaces.endpoint.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import br.desafio.ctbicicleta.util.enumeration.TipoTerronoEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PesquisaBikeCommand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6122986674313866991L;

	
	

	private TipoTerronoEnum tipoTerreno;
	
	
	private Integer kmMes;

	
	
	
}
