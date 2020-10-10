package br.desafio.ctbicicleta.interfaces.endpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BikeRetornoDTO  {


	
	private Double preco;


	private String descricao;
	
	
	private String nome;
	
	
	private String tipo;
	

	private String categoria;
	
	
	
}
