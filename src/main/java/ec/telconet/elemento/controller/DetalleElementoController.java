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

import ec.telconet.elemento.service.DetalleElementoService;
import ec.telconet.microservicio.dependencia.util.dto.PageDTO;
import ec.telconet.microservicio.dependencia.util.response.GenericBasicResponse;
import ec.telconet.microservicio.dependencia.util.response.GenericListResponse;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.DetalleElementoReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.InfoDetalleElemento;

/**
 * Clase utilizada para publicar microservicios técnicos con información referente al detalle de los elementos
 *
 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
 * @version 1.0
 * @since 02/03/2020
 */
@RestController
@RequestMapping
public class DetalleElementoController {
	Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired
	DetalleElementoService detalleElementoService;
	
	/**
	 * Método que guarda un detalle del elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain InfoDetalleElemento}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "guardarDetalleElemento", consumes = "application/json")
	public GenericBasicResponse<InfoDetalleElemento> guardarDetalleElemento(@RequestBody InfoDetalleElemento request) throws Exception {
		log.info("Petición recibida: guardarDetalleElemento");
		GenericBasicResponse<InfoDetalleElemento> response = new GenericBasicResponse<>();
		response.setData(detalleElementoService.guardarDetalleElemento(request));
		return response;
	}
	
	/**
	 * Método que actualiza un detalle del elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain InfoDetalleElemento}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "actualizarDetalleElemento", consumes = "application/json")
	public GenericBasicResponse<InfoDetalleElemento> actualizarDetalleElemento(@RequestBody InfoDetalleElemento request) throws Exception {
		log.info("Petición recibida: actualizarDetalleElemento");
		GenericBasicResponse<InfoDetalleElemento> response = new GenericBasicResponse<>();
		response.setData(detalleElementoService.actualizarDetalleElemento(request));
		return response;
	}
	
	/**
	 * Método que elimina un detalle del elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain InfoDetalleElemento}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "eliminarDetalleElemento", consumes = "application/json")
	public GenericBasicResponse<Boolean> eliminarDetalleElemento(@RequestBody InfoDetalleElemento request) throws Exception {
		log.info("Petición recibida: eliminarDetalleElemento");
		GenericBasicResponse<Boolean> response = new GenericBasicResponse<>();
		response.setData(detalleElementoService.eliminarDetalleElemento(request));
		return response;
	}
	
	/**
	 * Método que retorna la lista de detalle del elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@GetMapping("listaDetalleElemento")
	public GenericListResponse<InfoDetalleElemento> listaDetalleElemento() throws Exception {
		log.info("Petición recibida: listaDetalleElemento");
		GenericListResponse<InfoDetalleElemento> response = new GenericListResponse<>();
		response.setData(detalleElementoService.listaDetalleElemento());
		return response;
	}
	
	/**
	 * Método que retorna la lista de detalle del elemento con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain InfoDetalleElemento}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "listaDetalleElementoPor", consumes = "application/json")
	public GenericListResponse<InfoDetalleElemento> listaDetalleElementoPor(@RequestBody InfoDetalleElemento request) throws Exception {
		log.info("Petición recibida: listaDetalleElementoPor");
		GenericListResponse<InfoDetalleElemento> response = new GenericListResponse<>();
		response.setData(detalleElementoService.listaDetalleElementoPor(request));
		return response;
	}
	
	/**
	 * Método que retorna la paginación de una lista de detalle del elemento con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain PageDTO}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "paginaListaDetalleElementoPor", consumes = "application/json")
	public GenericBasicResponse<Page<InfoDetalleElemento>> paginaListaDetalleElementoPor(@RequestBody PageDTO<InfoDetalleElemento> request)
			throws Exception {
		log.info("Petición recibida: paginaListaDetalleElementoPor");
		GenericBasicResponse<Page<InfoDetalleElemento>> response = new GenericBasicResponse<>();
		response.setData(detalleElementoService.paginaListaDetalleElementoPor(request));
		return response;
	}
	
	/**
	 * Método que retorna la lista de detalles de un elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain DetalleElementoReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "listaDetalleElementoPorElemento", consumes = "application/json")
	public GenericListResponse<InfoDetalleElemento> listaDetalleElementoPorElemento(@RequestBody DetalleElementoReqDTO request) throws Exception {
		log.info("Petición recibida: listaDetalleElementoPorElemento");
		GenericListResponse<InfoDetalleElemento> response = new GenericListResponse<>();
		response.setData(detalleElementoService.listaDetalleElementoPorElemento(request));
		return response;
	}
}
