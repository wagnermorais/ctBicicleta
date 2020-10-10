package br.desafio.ctbicicleta.domain.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.desafio.ctbicicleta.util.enumeration.CategoriaEnum;

@Converter(autoApply = false)
public class CategoriaConverter implements AttributeConverter<CategoriaEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(CategoriaEnum categoriaEnum) {
		return categoriaEnum.getCodigo();
	}

	@Override
	public CategoriaEnum convertToEntityAttribute(Integer codigo) {
		return CategoriaEnum.getTipoSorteioByCodigo(codigo);
	}

}
