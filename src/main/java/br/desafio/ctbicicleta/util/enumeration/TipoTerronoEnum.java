package br.desafio.ctbicicleta.util.enumeration;

import java.util.Arrays;

public enum TipoTerronoEnum {

	MONTANHA(1, "Montanha"),
	ASFALTO(2, "Asfalto"),
	CIDADE(3, "Cidade");

	private Integer codigo;
	private String descricao;

	private TipoTerronoEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoTerronoEnum getTipoSorteioByCodigo(Integer codigo) {
		return Arrays.stream(TipoTerronoEnum.values())
				.filter(item -> item.getCodigo().equals(codigo)).findAny()
				.orElse(null);
	}

	public static TipoTerronoEnum getTipoSorteioByDescricao(String descricao) {
		return Arrays.stream(TipoTerronoEnum.values())
				.filter(item -> item.getDescricao().equalsIgnoreCase(descricao)).findAny()
				.orElse(null);
	}

}
