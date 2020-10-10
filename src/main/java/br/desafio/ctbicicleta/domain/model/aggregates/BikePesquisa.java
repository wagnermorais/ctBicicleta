package br.desafio.ctbicicleta.domain.model.aggregates;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.AbstractAggregateRoot;

import br.desafio.ctbicicleta.domain.model.converter.CategoriaConverter;
import br.desafio.ctbicicleta.domain.model.converter.TipoConverter;
import br.desafio.ctbicicleta.util.enumeration.CategoriaEnum;
import br.desafio.ctbicicleta.util.enumeration.TipoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TBBIKE_PESQUISA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class BikePesquisa  extends AbstractAggregateRoot<BikePesquisa> implements Serializable{


	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8520199888687758762L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	

	@Column(name="PRECO")
	private Double preco;


	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="NOME")
	private String nome;
	
	@NotNull
	@Column(name = "TIPO")
	@Convert(converter = TipoConverter.class)
	private TipoEnum tipo;
	
	@NotNull
	@Column(name = "CATEGORIA")
	@Convert(converter = CategoriaConverter.class)
	private CategoriaEnum categoria;
	
			
	
}
