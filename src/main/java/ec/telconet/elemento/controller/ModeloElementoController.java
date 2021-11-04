package ec.telconet.elemento.controller;

import ec.telconet.microservicio.dependencia.util.general.Formato;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.telconet.elemento.service.ModeloElementoService;
import ec.telconet.microservicio.dependencia.util.dto.PageDTO;
import ec.telconet.microservicio.dependencia.util.response.GenericBasicResponse;
import ec.telconet.microservicio.dependencia.util.response.GenericListResponse;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.AdmiModeloElemento;

import java.util.Arrays;

/**
 * Clase utilizada para publicar microservicios técnicos con información referente al modelo de los elementos
 *
 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
 * @version 1.0
 * @since 02/03/2020
 */
@RestController
@RequestMapping
public class ModeloElementoController {
	Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired
	ModeloElementoService modeloElementoService;
	
	/**
	 * Método que guarda un modelo de elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain AdmiModeloElemento}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "guardarModeloElemento", consumes = "application/json")
	public GenericBasicResponse<Object> guardarModeloElemento(@RequestBody Object request) throws Exception {
		log.info("Petición recibida: guardarModeloElemento");
		GenericBasicResponse<Object> response = new GenericBasicResponse<>();
		response.setData(modeloElementoService.guardarModeloElemento(Formato.mapearObjDeserializado(request, AdmiModeloElemento.class)));
		return response;
	}
	
	/**
	 * Método que retorna la lista de modelos de elementos
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@GetMapping("listaModeloElemento")
	public GenericListResponse<Object> listaModeloElemento() throws Exception {
		log.info("Petición recibida: listaModeloElemento");
		GenericListResponse<Object> response = new GenericListResponse<>();
		response.setData(Arrays.asList(modeloElementoService.listaModeloElemento().toArray()));
		return response;
	}
	
	/**
	 * Método que retorna la lista de modelos de elementos con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain AdmiModeloElemento}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "listaModeloElementoPor", consumes = "application/json")
	public GenericListResponse<Object> listaModeloElementoPor(@RequestBody Object request) throws Exception {
		log.info("Petición recibida: listaModeloElementoPor");
		GenericListResponse<Object> response = new GenericListResponse<>();
		response.setData(Arrays.asList(modeloElementoService.listaModeloElementoPor(Formato.mapearObjDeserializado(request, AdmiModeloElemento.class)).toArray()));
		return response;
	}
	
	/**
	 * Método que retorna la paginación de una lista de modelos de elementos con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain PageDTO}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "paginaListaModeloElementoPor", consumes = "application/json")
	public GenericBasicResponse<Page<AdmiModeloElemento>> paginaListaModeloElementoPor(@RequestBody Object request)
			throws Exception {
		log.info("Petición recibida: paginaListaModeloElementoPor");
		GenericBasicResponse<Page<AdmiModeloElemento>> response = new GenericBasicResponse<>();
		response.setData(modeloElementoService.paginaListaModeloElementoPor(Formato.mapearPageObjDeserializado(request, AdmiModeloElemento.class)));
		return response;
	}
}
