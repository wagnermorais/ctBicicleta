package br.desafio.ctbicicleta.domain.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TBKM_ACESSORIOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "km", callSuper = false)
public class KmAcessorios {





	@Id
	@Column(name="KM")
	private Integer km;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "KM_ACESSORIOS",
		joinColumns = @JoinColumn(name = "km_id"),
		inverseJoinColumns = @JoinColumn(name = "acessorios_id")
	)
	private List<Acessorios> acessorios = new ArrayList<>();
	
	
			
	
}
