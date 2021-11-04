package ec.telconet.elemento.controller;

import ec.telconet.microservicio.dependencia.util.general.Formato;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.telconet.elemento.service.HistorialElementoService;
import ec.telconet.microservicio.dependencia.util.response.GenericBasicResponse;
import ec.telconet.microservicio.dependencia.util.response.GenericListResponse;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.HistorialElementoPorFechaReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.HistorialElementoReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.InfoHistorialElemento;

import java.util.Arrays;

/**
 * Clase utilizada para publicar microservicios técnicos con información referente al historial de los elementos
 *
 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
 * @version 1.0
 * @since 02/03/2020
 */
@RestController
@RequestMapping
public class HistorialElementoController {
	Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired
	HistorialElementoService historialElementoService;
	
	/**
	 * Método que guarda un historial de elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain InfoHistorialElemento}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "guardarHistorialElemento", consumes = "application/json")
	public GenericBasicResponse<Object> guardarHistorialElemento(@RequestBody Object request) throws Exception {
		log.info("Petición recibida: guardarHistorialElemento");
		GenericBasicResponse<Object> response = new GenericBasicResponse<>();
		response.setData(historialElementoService.guardarHistorialElemento(Formato.mapearObjDeserializado(request, InfoHistorialElemento.class)));
		return response;
	}
	
	/**
	 * Método que retorna la lista de historial de un elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain HistorialElementoReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "listaHistorialElementoPorElemento", consumes = "application/json")
	public GenericListResponse<Object> listaHistorialElementoPorElemento(@RequestBody HistorialElementoReqDTO request)
			throws Exception {
		log.info("Petición recibida: listaHistorialElementoPorElemento");
		GenericListResponse<Object> response = new GenericListResponse<>();
		response.setData(Arrays.asList(historialElementoService.listaHistorialElementoPorElemento(request).toArray()));
		return response;
	}
	
	/**
	 * Método que retorna la lista de historial de un elemento con un rango de fecha
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain HistorialElementoPorFechaReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "listaHistorialElementoPorFecha", consumes = "application/json")
	public GenericListResponse<Object> listaHistorialElementoPorFecha(@RequestBody HistorialElementoPorFechaReqDTO request)
			throws Exception {
		log.info("Petición recibida: listaHistorialElementoPorFecha");
		GenericListResponse<Object> response = new GenericListResponse<>();
		response.setData(Arrays.asList(historialElementoService.listaHistorialElementoPorFecha(request).toArray()));
		return response;
	}
}
