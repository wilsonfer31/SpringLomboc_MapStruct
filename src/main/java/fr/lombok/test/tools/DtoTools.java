package fr.lombok.test.tools;

import org.modelmapper.ModelMapper;

public class DtoTools {

	private static ModelMapper myMapper = new ModelMapper();
	
	public static <TSource,TDestination> TDestination convert(TSource obj, Class<TDestination> clazz) {

		
		return myMapper.map(obj, clazz);
	}
}
