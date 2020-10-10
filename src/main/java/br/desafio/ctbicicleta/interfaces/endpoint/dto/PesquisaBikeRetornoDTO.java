package br.desafio.ctbicicleta.interfaces.endpoint.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PesquisaBikeRetornoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6122986674313866991L;

	
	
	@ApiModelProperty(required = true, notes = "Tipo de terreno")
	@NotNull(message = "text.required")
	private String tipoTerreno;
	
	@ApiModelProperty(required = true, notes = "Quantidade de Km pretendido por mes")
	@NotNull(message = "text.required")
	private Integer kmMes;

	
	List<BikeRetornoDTO> bikes = new ArrayList<BikeRetornoDTO>();
	
	List<AcessoriosDTO> acessorios = new ArrayList<>();
	
	
}
