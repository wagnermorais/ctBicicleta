package br.desafio.ctbicicleta.domain.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.desafio.ctbicicleta.util.enumeration.TipoEnum;

@Converter(autoApply = false)
public class TipoConverter implements AttributeConverter<TipoEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TipoEnum tipoSorteioEnum) {
		return tipoSorteioEnum.getCodigo();
	}

	@Override
	public TipoEnum convertToEntityAttribute(Integer codigo) {
		return TipoEnum.getTipoSorteioByCodigo(codigo);
	}

}
