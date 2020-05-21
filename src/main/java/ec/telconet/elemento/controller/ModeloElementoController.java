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

import ec.telconet.elemento.service.ModeloElementoService;
import ec.telconet.microservicio.dependencia.util.dto.PageDTO;
import ec.telconet.microservicio.dependencia.util.response.GenericBasicResponse;
import ec.telconet.microservicio.dependencia.util.response.GenericListResponse;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.AdmiModeloElemento;

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
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain AdmiModeloElemento}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "guardarModeloElemento", consumes = "application/json")
	public GenericBasicResponse<AdmiModeloElemento> guardarModeloElemento(@RequestBody AdmiModeloElemento request) throws Exception {
		log.info("Petición recibida: guardarModeloElemento");
		GenericBasicResponse<AdmiModeloElemento> response = new GenericBasicResponse<AdmiModeloElemento>();
		response.setData(modeloElementoService.guardarModeloElemento(request));
		return response;
	}
	
	/**
	 * Método que retorna la lista de modelos de elementos
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception
	 */
	@GetMapping("listaModeloElemento")
	public GenericListResponse<AdmiModeloElemento> listaModeloElemento() throws Exception {
		log.info("Petición recibida: listaModeloElemento");
		GenericListResponse<AdmiModeloElemento> response = new GenericListResponse<AdmiModeloElemento>();
		response.setData(modeloElementoService.listaModeloElemento());
		return response;
	}
	
	/**
	 * Método que retorna la lista de modelos de elementos con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain AdmiModeloElemento}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "listaModeloElementoPor", consumes = "application/json")
	public GenericListResponse<AdmiModeloElemento> listaModeloElementoPor(@RequestBody AdmiModeloElemento request) throws Exception {
		log.info("Petición recibida: listaModeloElementoPor");
		GenericListResponse<AdmiModeloElemento> response = new GenericListResponse<AdmiModeloElemento>();
		response.setData(modeloElementoService.listaModeloElementoPor(request));
		return response;
	}
	
	/**
	 * Método que retorna la paginación de una lista de modelos de elementos con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain PageDTO}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "paginaListaModeloElementoPor", consumes = "application/json")
	public GenericBasicResponse<Page<AdmiModeloElemento>> paginaListaModeloElementoPor(@RequestBody PageDTO<AdmiModeloElemento> request)
			throws Exception {
		log.info("Petición recibida: paginaListaModeloElementoPor");
		GenericBasicResponse<Page<AdmiModeloElemento>> response = new GenericBasicResponse<Page<AdmiModeloElemento>>();
		response.setData(modeloElementoService.paginaListaModeloElementoPor(request));
		return response;
	}
}
