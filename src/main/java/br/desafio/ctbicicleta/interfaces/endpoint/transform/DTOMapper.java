package br.desafio.ctbicicleta.interfaces.endpoint.transform;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;

public class DTOMapper {

	private static ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		return modelMapper;
	}

	public static <T, O> T convert(O obj, Class<T> objClass) {
		return getModelMapper().map(obj, objClass);
	}

	public static <T, O> List<T> convertList(List<O> objList, Class<T> objClass) {
        return objList.stream().map(objectEntity -> getModelMapper().map(objectEntity, objClass)).collect(Collectors.toList());
	}

	public static <T, O> Page<T> convertPage(Page<O> objPage, Class<T> objClass) {
		return objPage.map(objectEntity -> getModelMapper().map(objectEntity, objClass));
	}

}
