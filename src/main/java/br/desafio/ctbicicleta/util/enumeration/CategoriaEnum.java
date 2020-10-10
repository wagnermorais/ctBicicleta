package br.desafio.ctbicicleta.util.enumeration;

import java.util.Arrays;

public enum CategoriaEnum {

	SIMPLES(1, "Simples"),
	INTERMEDIARIA(2, "Intermediaria"),
	PROFISSIONAL(3, "Profissional");

	private Integer codigo;
	private String descricao;

	private CategoriaEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static CategoriaEnum getTipoSorteioByCodigo(Integer codigo) {
		return Arrays.stream(CategoriaEnum.values())
				.filter(item -> item.getCodigo().equals(codigo)).findAny()
				.orElse(null);
	}

	public static CategoriaEnum getTipoSorteioByDescricao(String descricao) {
		return Arrays.stream(CategoriaEnum.values())
				.filter(item -> item.getDescricao().equals(descricao)).findAny()
				.orElse(null);
	}

}
