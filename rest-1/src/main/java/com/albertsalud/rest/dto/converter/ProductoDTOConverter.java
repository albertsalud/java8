package com.albertsalud.rest.dto.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.albertsalud.rest.modelo.Producto;

@Component
public class ProductoDTOConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Object convertToDTO(Producto p, Class<?> dtoClass) {
		return modelMapper.map(p, dtoClass);
	}
	
	public Producto convertToObject(Object dto) {
		return modelMapper.map(dto, Producto.class);
	}

}
