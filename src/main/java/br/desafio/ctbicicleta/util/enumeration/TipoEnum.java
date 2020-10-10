package br.desafio.ctbicicleta.util.enumeration;

import java.util.Arrays;

public enum TipoEnum {

	MOUTAIN(1, "Mountain"),
	SPEED(2, "Speed"),
	URBANA(3, "Urbana");

	private Integer codigo;
	private String descricao;

	private TipoEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoEnum getTipoSorteioByCodigo(Integer codigo) {
		return Arrays.stream(TipoEnum.values())
				.filter(item -> item.getCodigo().equals(codigo)).findAny()
				.orElse(null);
	}

	public static TipoEnum getTipoSorteioByDescricao(String descricao) {
		return Arrays.stream(TipoEnum.values())
				.filter(item -> item.getDescricao().equals(descricao)).findAny()
				.orElse(null);
	}

}
