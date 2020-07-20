package ec.telconet.elemento.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.telconet.elemento.service.ElementoService;
import ec.telconet.microservicio.dependencia.util.dto.PageDTO;
import ec.telconet.microservicio.dependencia.util.response.GenericBasicResponse;
import ec.telconet.microservicio.dependencia.util.response.GenericListResponse;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorCantonParamsReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorDepartamentoParamsReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorFilialParamsReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorMonitorizadoReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorParroquiaParamsReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorProvinciaParamsReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorRegionParamsReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorTipoReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.InfoElemento;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * Clase utilizada para publicar microservicios técnicos con información referente a los elementos
 * 
 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
 * @version 1.0
 * @since 02/03/2020
 */
@RestController
@RequestMapping
public class ElementoController {
	Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired
	ElementoService elementoService;
	
	/**
	 * Método que guarda un elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain InfoElemento}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "guardarElemento", consumes = "application/json")
	public GenericBasicResponse<InfoElemento> guardarElemento(@RequestBody InfoElemento request) throws Exception {
		log.info("Petición recibida: guardarElemento");
		GenericBasicResponse<InfoElemento> response = new GenericBasicResponse<InfoElemento>();
		response.setData(elementoService.guardarElemento(request));
		return response;
	}
	
	/**
	 * Método que actualiza un elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain InfoElemento}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "actualizarElemento", consumes = "application/json")
	public GenericBasicResponse<InfoElemento> actualizarElemento(@RequestBody InfoElemento request) throws Exception {
		log.info("Petición recibida: actualizarElemento");
		GenericBasicResponse<InfoElemento> response = new GenericBasicResponse<InfoElemento>();
		response.setData(elementoService.actualizarElemento(request));
		return response;
	}
	
	/**
	 * Método que elimina un elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain InfoElemento}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "eliminarElemento", consumes = "application/json")
	public GenericBasicResponse<Boolean> eliminarElemento(@RequestBody InfoElemento request) throws Exception {
		log.info("Petición recibida: eliminarElemento");
		GenericBasicResponse<Boolean> response = new GenericBasicResponse<Boolean>();
		response.setData(elementoService.eliminarElemento(request));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception
	 */
	@GetMapping("listaElemento")
	public GenericListResponse<InfoElemento> listaElemento() throws Exception {
		log.info("Petición recibida: listaElemento");
		GenericListResponse<InfoElemento> response = new GenericListResponse<InfoElemento>();
		response.setData(elementoService.listaElemento());
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain InfoElemento}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "listaElementoPor", consumes = "application/json")
	public GenericListResponse<InfoElemento> listaElementoPor(@RequestBody InfoElemento request) throws Exception {
		log.info("Petición recibida: listaElementoPor");
		GenericListResponse<InfoElemento> response = new GenericListResponse<InfoElemento>();
		response.setData(elementoService.listaElementoPor(request));
		return response;
	}
	
	/**
	 * Método que retorna la paginación de una lista de elementos con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain PageDTO}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "paginaListaElementoPor", consumes = "application/json")
	public GenericBasicResponse<Page<InfoElemento>> paginaListaElementoPor(@RequestBody PageDTO<InfoElemento> request) throws Exception {
		log.info("Petición recibida: paginaListaElementoPor");
		GenericBasicResponse<Page<InfoElemento>> response = new GenericBasicResponse<Page<InfoElemento>>();
		response.setData(elementoService.paginaListaElementoPor(request));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos de un tipo de elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain ElementoPorTipoReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "listaElementoPorTipo", consumes = "application/json")
	public GenericListResponse<InfoElemento> listaElementoPorTipo(@RequestBody ElementoPorTipoReqDTO request) throws Exception {
		log.info("Petición recibida: listaElementoPorTipo");
		GenericListResponse<InfoElemento> response = new GenericListResponse<InfoElemento>();
		response.setData(elementoService.listaElementoPorTipo(request));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos que tiene como característica ES_MONITORIZADO
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain ElementoPorMonitorizadoReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "listaElementoPorEsMonitorizado", consumes = "application/json")
	public GenericListResponse<InfoElemento> listaElementoPorEsMonitorizado(@RequestBody ElementoPorMonitorizadoReqDTO request) throws Exception {
		log.info("Petición recibida: listaElementoPorEsMonitorizado");
		GenericListResponse<InfoElemento> response = new GenericListResponse<InfoElemento>();
		response.setData(elementoService.listaElementoPorEsMonitorizado(request));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos por region y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain ElementoPorRegionParamsReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "listaElementoPorRegionParams", consumes = "application/json")
	public GenericListResponse<InfoElemento> listaElementoPorRegionParams(@RequestBody ElementoPorRegionParamsReqDTO request) throws Exception {
		log.info("Petición recibida: listaElementoPorRegionParams");
		GenericListResponse<InfoElemento> response = new GenericListResponse<InfoElemento>();
		response.setData(elementoService.listaElementoPorRegionParams(request));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos por provincia y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain ElementoPorProvinciaParamsReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "listaElementoPorProvinciaParams", consumes = "application/json")
	public GenericListResponse<InfoElemento> listaElementoPorProvinciaParams(@RequestBody ElementoPorProvinciaParamsReqDTO request) throws Exception {
		log.info("Petición recibida: listaElementoPorProvinciaParams");
		GenericListResponse<InfoElemento> response = new GenericListResponse<InfoElemento>();
		response.setData(elementoService.listaElementoPorProvinciaParams(request));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos por parroquia y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain ElementoPorParroquiaParamsReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "listaElementoPorParroquiaParams", consumes = "application/json")
	public GenericListResponse<InfoElemento> listaElementoPorParroquiaParams(@RequestBody ElementoPorParroquiaParamsReqDTO request) throws Exception {
		log.info("Petición recibida: listaElementoPorParroquiaParams");
		GenericListResponse<InfoElemento> response = new GenericListResponse<InfoElemento>();
		response.setData(elementoService.listaElementoPorParroquiaParams(request));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos por canton y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain ElementoPorCantonParamsReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "listaElementoPorCantonParams", consumes = "application/json")
	public GenericListResponse<InfoElemento> listaElementoPorCantonParams(@RequestBody ElementoPorCantonParamsReqDTO request) throws Exception {
		log.info("Petición recibida: listaElementoPorCantonParams");
		GenericListResponse<InfoElemento> response = new GenericListResponse<InfoElemento>();
		response.setData(elementoService.listaElementoPorCantonParams(request));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos por filial y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain ElementoPorFilialParamsReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "listaElementoPorFilialParams", consumes = "application/json")
	public GenericListResponse<InfoElemento> listaElementoPorFilialParams(@RequestBody ElementoPorFilialParamsReqDTO request) throws Exception {
		log.info("Petición recibida: listaElementoPorFilialParams");
		GenericListResponse<InfoElemento> response = new GenericListResponse<InfoElemento>();
		response.setData(elementoService.listaElementoPorFilialParams(request));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos por departamento y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain ElementoPorDepartamentoParamsReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "listaElementoPorDepartamentoParams", consumes = "application/json")
	public GenericListResponse<InfoElemento> listaElementoPorDepartamentoParams(@RequestBody ElementoPorDepartamentoParamsReqDTO request) throws Exception {
		log.info("Petición recibida: listaElementoPorDepartamentoParams");
		GenericListResponse<InfoElemento> response = new GenericListResponse<InfoElemento>();
		response.setData(elementoService.listaElementoPorDepartamentoParams(request));
		return response;
	}
}
