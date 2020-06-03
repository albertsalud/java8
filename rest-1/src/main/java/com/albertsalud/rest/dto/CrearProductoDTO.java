package com.albertsalud.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CrearProductoDTO {
	
	private String nombre;
	private float precio;
	private long categoriaId;

}
