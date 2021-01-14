package ec.telconet.elemento.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.telconet.elemento.service.TipoElementoService;
import ec.telconet.microservicio.dependencia.util.dto.PageDTO;
import ec.telconet.microservicio.dependencia.util.response.GenericBasicResponse;
import ec.telconet.microservicio.dependencia.util.response.GenericListResponse;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.AdmiTipoElemento;

/**
 * Clase utilizada para publicar microservicios técnicos con información referente al tipo de elementos
 *
 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
 * @version 1.0
 * @since 02/03/2020
 */
@RestController
@RequestMapping
public class TipoElementoController {
	Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired
	TipoElementoService tipoElementoService;
	
	/**
	 * Método que guarda un tipo de elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain AdmiTipoElemento}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "guardarTipoElemento", consumes = "application/json")
	public GenericBasicResponse<AdmiTipoElemento> guardarTipoElemento(@RequestBody AdmiTipoElemento request) throws Exception {
		log.info("Petición recibida: guardarTipoElemento");
		GenericBasicResponse<AdmiTipoElemento> response = new GenericBasicResponse<>();
		response.setData(tipoElementoService.guardarTipoElemento(request));
		return response;
	}
	
	/**
	 * Método que actualiza un tipo de elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain AdmiTipoElemento}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "actualizarTipoElemento", consumes = "application/json")
	public GenericBasicResponse<AdmiTipoElemento> actualizarTipoElemento(@RequestBody AdmiTipoElemento request) throws Exception {
		log.info("Petición recibida: actualizarTipoElemento");
		GenericBasicResponse<AdmiTipoElemento> response = new GenericBasicResponse<>();
		response.setData(tipoElementoService.actualizarTipoElemento(request));
		return response;
	}
	
	/**
	 * Método que elimina un tipo de elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain AdmiTipoElemento}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "eliminarTipoElemento", consumes = "application/json")
	public GenericBasicResponse<Boolean> eliminarTipoElemento(@RequestBody AdmiTipoElemento request) throws Exception {
		log.info("Petición recibida: eliminarTipoElemento");
		GenericBasicResponse<Boolean> response = new GenericBasicResponse<>();
		response.setData(tipoElementoService.eliminarTipoElemento(request));
		return response;
	}
	
	/**
	 * Método que retorna la lista de tipos de elementos
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@GetMapping("listaTipoElemento")
	public GenericListResponse<AdmiTipoElemento> listaTipoElemento() throws Exception {
		log.info("Petición recibida: listaTipoElemento");
		GenericListResponse<AdmiTipoElemento> response = new GenericListResponse<>();
		response.setData(tipoElementoService.listaTipoElemento());
		return response;
	}
	
	/**
	 * Método que retorna la lista de tipos de elementos con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain AdmiTipoElemento}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "listaTipoElementoPor", consumes = "application/json")
	public GenericListResponse<AdmiTipoElemento> listaTipoElementoPor(@RequestBody AdmiTipoElemento request) throws Exception {
		log.info("Petición recibida: listaTipoElementoPor");
		GenericListResponse<AdmiTipoElemento> response = new GenericListResponse<>();
		response.setData(tipoElementoService.listaTipoElementoPor(request));
		return response;
	}
	
	/**
	 * Método que retorna la paginación de una lista de tipos de elementos con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain PageDTO}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "paginaListaTipoElementoPor", consumes = "application/json")
	public GenericBasicResponse<Page<AdmiTipoElemento>> paginaListaTipoElementoPor(@RequestBody PageDTO<AdmiTipoElemento> request) throws Exception {
		log.info("Petición recibida: paginaListaTipoElementoPor");
		GenericBasicResponse<Page<AdmiTipoElemento>> response = new GenericBasicResponse<>();
		response.setData(tipoElementoService.paginaListaTipoElementoPor(request));
		return response;
	}
}
