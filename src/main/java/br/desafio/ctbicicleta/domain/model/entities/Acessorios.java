package br.desafio.ctbicicleta.domain.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TB_ACESSORIOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class Acessorios   implements Serializable{


	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8520199888687758762L;


	@Id
	private Long id;
	

	

	@Column(name="NOME")
	private String nome;
	
	
	@Column(name="LINK")
	private String link;
			
	
}
