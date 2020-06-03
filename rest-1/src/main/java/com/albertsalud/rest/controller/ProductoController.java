package com.albertsalud.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.albertsalud.rest.dto.CrearProductoDTO;
import com.albertsalud.rest.dto.ProductoDTO;
import com.albertsalud.rest.dto.converter.ProductoDTOConverter;
import com.albertsalud.rest.error.ProductoNotFoundException;
import com.albertsalud.rest.modelo.Categoria;
import com.albertsalud.rest.modelo.CategoriaRepositorio;
import com.albertsalud.rest.modelo.Producto;
import com.albertsalud.rest.modelo.ProductoRepositorio;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:8080", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT},
		maxAge = 3600)	// (Spring) habilita los encabezados cors.  Se puede aplicar a nivel de método también
@RestController
@RequiredArgsConstructor	// (Lombok) Autoinyecta las dependencias (sin necesidad de autowired)
public class ProductoController {

	private final ProductoRepositorio productoRepositorio;
	private final ProductoDTOConverter productoConverter;
	private final CategoriaRepositorio categoriaRepositorio;

	/**
	 * Obtenemos todos los productos
	 * 
	 * @return
	 */
	@GetMapping("/producto")
	public ResponseEntity<?> obtenerTodos() {
		List<Producto> result = productoRepositorio.findAll();
		
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			List<ProductoDTO> resultDTO = result
					.stream()
					.map(p -> {
						return (ProductoDTO) productoConverter.convertToDTO(p, ProductoDTO.class);
					})
					.collect(Collectors.toList());
			
			return ResponseEntity.ok(resultDTO);
		}
	}

	/**
	 * Obtenemos un producto en base a su ID
	 * 
	 * Si el producto no se encuentra, lanza una excepción personalizada. Esta excepción devolvería siempre un error 500, si no 
	 * fuese porque la propia clase está anotada con @ResponseStatus. Esta es la forma más básica de Spring para gestionar las
	 * excepciones
	 * 
	 * @param id
	 * @return Null si no encuentra el producto
	 */
	@GetMapping("/producto/{id}")
	public Producto obtenerUno(@PathVariable Long id) {
		return productoRepositorio.findById(id).orElseThrow(() -> new ProductoNotFoundException(id));
		
	}

	/**
	 * Insertamos un nuevo producto
	 * 
	 * Se podría devolver directamente el objeto almacenado, pero, dado que nos interesa modificar el 
	 * código Http devuelto (en vez de un 200 OK, un 201 CREATED) debemos devolver un ResponseEntity, que 
	 * nos permite gestionar este retorno
	 * 
	 * @param nuevo
	 * @return producto insertado
	 */
	@PostMapping("/producto")
	public ResponseEntity<?> nuevoProducto(@RequestBody CrearProductoDTO nuevo) {
		Producto p = productoConverter.convertToObject(nuevo);
		Categoria c = categoriaRepositorio.findById(nuevo.getCategoriaId()).orElse(null);
		
		p.setCategoria(c);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(
				productoConverter.convertToDTO(productoRepositorio.save(p), ProductoDTO.class)
				);

	}

	/**
	 * 
	 * Edita el producto facilitado
	 * 
	 * Si el producto no se encuentra, lanza una excepción personalizada. Esta excepción devolvería siempre un error 500, si no 
	 * fuese porque la propia clase está anotada con @ResponseStatus. Esta es la forma más básica de Spring para gestionar las
	 * excepciones
	 * 
	 * @param editar
	 * @param id
	 * @return
	 */
	@PutMapping("/producto/{id}")
	public Producto editarProducto(@RequestBody Producto editar, @PathVariable Long id) {
		
		productoRepositorio.findById(id).orElseThrow(() -> new ProductoNotFoundException(id));
		
		editar.setId(id);
		return productoRepositorio.save(editar);
			
	}

	/**
	 * Borra un producto del catálogo en base a su id
	 * 
	 * Si el producto no se encuentra, lanza una excepción personalizada. Esta excepción devolvería siempre un error 500, si no 
	 * fuese porque la propia clase está anotada con @ResponseStatus. Esta es la forma más básica de Spring para gestionar las
	 * excepciones
	 * 
	 * 
	 * Se podría devolver directamente el objeto almacenado, pero, dado que nos interesa modificar el 
	 * código Http devuelto (en vez de un 200 OK, un 201 CREATED) debemos devolver un ResponseEntity, que 
	 * nos permite gestionar este retorno
	 * 
	 * @param id
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:9000")	// (Spring) Se puede especificar configuraciones concretas a nivel de método
	@DeleteMapping("/producto/{id}")
	public ResponseEntity<?> borrarProducto(@PathVariable Long id) {
		Producto p = productoRepositorio.findById(id).orElseThrow(() -> new ProductoNotFoundException(id));
			
		productoRepositorio.delete(p);
		return ResponseEntity.noContent().build();
	}
	
}
