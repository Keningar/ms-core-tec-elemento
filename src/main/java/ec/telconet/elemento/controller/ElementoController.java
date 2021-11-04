package ec.telconet.elemento.controller;

import ec.telconet.microservicio.dependencia.util.general.Formato;
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
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorCuadrillaParamsReqDTO;
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

import java.util.Arrays;

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
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain InfoElemento}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "guardarElemento", consumes = "application/json")
	public GenericBasicResponse<Object> guardarElemento(@RequestBody Object request) throws Exception {
		log.info("Petición recibida: guardarElemento");
		GenericBasicResponse<Object> response = new GenericBasicResponse<>();
		response.setData(elementoService.guardarElemento(Formato.mapearObjDeserializado(request, InfoElemento.class)));
		return response;
	}
	
	/**
	 * Método que actualiza un elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain InfoElemento}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "actualizarElemento", consumes = "application/json")
	public GenericBasicResponse<Object> actualizarElemento(@RequestBody Object request) throws Exception {
		log.info("Petición recibida: actualizarElemento");
		GenericBasicResponse<Object> response = new GenericBasicResponse<>();
		response.setData(elementoService.actualizarElemento(Formato.mapearObjDeserializado(request, InfoElemento.class)));
		return response;
	}
	
	/**
	 * Método que elimina un elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain InfoElemento}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "eliminarElemento", consumes = "application/json")
	public GenericBasicResponse<Boolean> eliminarElemento(@RequestBody Object request) throws Exception {
		log.info("Petición recibida: eliminarElemento");
		GenericBasicResponse<Boolean> response = new GenericBasicResponse<>();
		response.setData(elementoService.eliminarElemento(Formato.mapearObjDeserializado(request, InfoElemento.class)));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@GetMapping("listaElemento")
	public GenericListResponse<Object> listaElemento() throws Exception {
		log.info("Petición recibida: listaElemento");
		GenericListResponse<Object> response = new GenericListResponse<>();
		response.setData(Arrays.asList(elementoService.listaElemento().toArray()));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain InfoElemento}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "listaElementoPor", consumes = "application/json")
	public GenericListResponse<Object> listaElementoPor(@RequestBody Object request) throws Exception {
		log.info("Petición recibida: listaElementoPor");
		GenericListResponse<Object> response = new GenericListResponse<>();
		response.setData(Arrays.asList(elementoService.listaElementoPor(Formato.mapearObjDeserializado(request, InfoElemento.class)).toArray()));
		return response;
	}
	
	/**
	 * Método que retorna la paginación de una lista de elementos con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain PageDTO}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "paginaListaElementoPor", consumes = "application/json")
	public GenericBasicResponse<Page<InfoElemento>> paginaListaElementoPor(@RequestBody Object request) throws Exception {
		log.info("Petición recibida: paginaListaElementoPor");
		GenericBasicResponse<Page<InfoElemento>> response = new GenericBasicResponse<>();
		response.setData(elementoService.paginaListaElementoPor(Formato.mapearPageObjDeserializado(request, InfoElemento.class)));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos de un tipo de elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain ElementoPorTipoReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "listaElementoPorTipo", consumes = "application/json")
	public GenericListResponse<Object> listaElementoPorTipo(@RequestBody ElementoPorTipoReqDTO request) throws Exception {
		log.info("Petición recibida: listaElementoPorTipo");
		GenericListResponse<Object> response = new GenericListResponse<>();
		response.setData(Arrays.asList(elementoService.listaElementoPorTipo(request).toArray()));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos que tiene como característica ES_MONITORIZADO
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain ElementoPorMonitorizadoReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "listaElementoPorEsMonitorizado", consumes = "application/json")
	public GenericListResponse<Object> listaElementoPorEsMonitorizado(@RequestBody ElementoPorMonitorizadoReqDTO request) throws Exception {
		log.info("Petición recibida: listaElementoPorEsMonitorizado");
		GenericListResponse<Object> response = new GenericListResponse<>();
		response.setData(Arrays.asList(elementoService.listaElementoPorEsMonitorizado(request).toArray()));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos por region y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain ElementoPorRegionParamsReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "listaElementoPorRegionParams", consumes = "application/json")
	public GenericListResponse<Object> listaElementoPorRegionParams(@RequestBody ElementoPorRegionParamsReqDTO request) throws Exception {
		log.info("Petición recibida: listaElementoPorRegionParams");
		GenericListResponse<Object> response = new GenericListResponse<>();
		response.setData(Arrays.asList(elementoService.listaElementoPorRegionParams(request).toArray()));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos por provincia y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain ElementoPorProvinciaParamsReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "listaElementoPorProvinciaParams", consumes = "application/json")
	public GenericListResponse<Object> listaElementoPorProvinciaParams(@RequestBody ElementoPorProvinciaParamsReqDTO request) throws Exception {
		log.info("Petición recibida: listaElementoPorProvinciaParams");
		GenericListResponse<Object> response = new GenericListResponse<>();
		response.setData(Arrays.asList(elementoService.listaElementoPorProvinciaParams(request).toArray()));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos por parroquia y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain ElementoPorParroquiaParamsReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "listaElementoPorParroquiaParams", consumes = "application/json")
	public GenericListResponse<Object> listaElementoPorParroquiaParams(@RequestBody ElementoPorParroquiaParamsReqDTO request) throws Exception {
		log.info("Petición recibida: listaElementoPorParroquiaParams");
		GenericListResponse<Object> response = new GenericListResponse<>();
		response.setData(Arrays.asList(elementoService.listaElementoPorParroquiaParams(request).toArray()));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos por canton y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain ElementoPorCantonParamsReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "listaElementoPorCantonParams", consumes = "application/json")
	public GenericListResponse<Object> listaElementoPorCantonParams(@RequestBody ElementoPorCantonParamsReqDTO request) throws Exception {
		log.info("Petición recibida: listaElementoPorCantonParams");
		GenericListResponse<Object> response = new GenericListResponse<>();
		response.setData(Arrays.asList(elementoService.listaElementoPorCantonParams(request).toArray()));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos por filial y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain ElementoPorFilialParamsReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "listaElementoPorFilialParams", consumes = "application/json")
	public GenericListResponse<Object> listaElementoPorFilialParams(@RequestBody ElementoPorFilialParamsReqDTO request) throws Exception {
		log.info("Petición recibida: listaElementoPorFilialParams");
		GenericListResponse<Object> response = new GenericListResponse<>();
		response.setData(Arrays.asList(elementoService.listaElementoPorFilialParams(request).toArray()));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos por departamento y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 02/03/2020
	 * 
	 * @param request {@linkplain ElementoPorDepartamentoParamsReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "listaElementoPorDepartamentoParams", consumes = "application/json")
	public GenericListResponse<Object> listaElementoPorDepartamentoParams(@RequestBody ElementoPorDepartamentoParamsReqDTO request)
			throws Exception {
		log.info("Petición recibida: listaElementoPorDepartamentoParams");
		GenericListResponse<Object> response = new GenericListResponse<>();
		response.setData(Arrays.asList(elementoService.listaElementoPorDepartamentoParams(request).toArray()));
		return response;
	}
	
	/**
	 * Método que retorna la lista de elementos por cuadrilla y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 21/08/2020
	 * 
	 * @param request {@linkplain ElementoPorCuadrillaParamsReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "listaElementoPorCuadrillaParams", consumes = "application/json")
	public GenericListResponse<Object> listaElementoPorCuadrillaParams(@RequestBody ElementoPorCuadrillaParamsReqDTO request) throws Exception {
		log.info("Petición recibida: listaElementoPorCuadrillaParams");
		GenericListResponse<Object> response = new GenericListResponse<>();
		response.setData(Arrays.asList(elementoService.listaElementoPorCuadrillaParams(request).toArray()));
		return response;
	}
}
