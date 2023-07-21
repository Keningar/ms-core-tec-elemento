package ec.telconet.elemento.controller;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.telconet.elemento.service.KardexService;
import ec.telconet.microservicio.dependencia.util.general.Formato;
import ec.telconet.microservicio.dependencia.util.response.GenericBasicResponse;
import ec.telconet.microservicio.dependencia.util.response.GenericListResponse;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoKardexReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoKardexResDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorPlacaReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ListaKardexReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ListaKardexResDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ListaPlacaDiscoResDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.TareasKardexReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.TareasKardexResDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.TotalRegistrosKardexResDTo;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.InfoKardex;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.InfoTipoMantenimiento;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.InfoDetalleKardex;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.InfoKardexTarea;

/**
 * Clase utilizada para publicar microservicios técnicos con información referente al kardex
 *
 * @author José Castillo <mailto:jmcastillo@telconet.ec>
 * @version 1.0
 * @since 03/05/2023
 */
@RestController
@RequestMapping
public class KardexController {
	Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired
	KardexService kardexService;
	
	/**
	 * Método que guarda una cabecera general de un kardex
	 * 
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @since 03/05/2023
	 * 
	 * @param request {@linkplain InfoKardex}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "guardarKardex", consumes = "application/json")
	public GenericBasicResponse<Object> guardarKardex(@RequestBody Object request) throws Exception {
		log.info("Petición recibida: guardarKardex");
		GenericBasicResponse<Object> response = new GenericBasicResponse<>();
		response.setData(kardexService.guardarKardex(Formato.mapearObjDeserializado(request, InfoKardex.class)));
		return response;
	}
	
	/**
	 * Método que guarda una nueva categoría de trabajo
	 * 
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @since 08/05/2023
	 * 
	 * @param request {@linkplain InfoKardexTarea}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "guardarKardexTarea", consumes = "application/json")
	public GenericBasicResponse<Object> gurdarKardexTarea(@RequestBody Object request) throws Exception {
		log.info("Petición recibida: guardarKardexTarea");
		GenericBasicResponse<Object> response = new GenericBasicResponse<>();
		response.setData(kardexService.gurdarKardexTarea(Formato.mapearObjDeserializado(request, InfoKardexTarea.class)));
		return response;
	}
	
	/**
	 * Método que guarda los detalles de un registro del kardex
	 * 
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @since 23/05/2023
	 * 
	 * @param request {@linkplain InfoDetalleKardex}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "guardarDetalleKardex", consumes = "application/json")
	public GenericBasicResponse<Object> guardarDetalleKardex(@RequestBody Object request) throws Exception {
		log.info("Petición recibida: guardarKardex");
		GenericBasicResponse<Object> response = new GenericBasicResponse<>();
		response.setData(kardexService.guardarDetalleKardex(Formato.mapearObjDeserializado(request, InfoDetalleKardex.class)));
		return response;
	}

	/**
	 * Método que retorna los registros del Kardex
	 *
	 * @param request {@linkplain ListaKardexReqDTO}
	 *
	 * @return {@linkplain GenericListResponse}
	 *
	 * @throws Exception Excepcion
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @since 11/05/2023
	 */
	@PostMapping(path = "listaKardex", consumes = "application/json")
	public GenericListResponse<ListaKardexResDTO> listaKardex(@RequestBody ListaKardexReqDTO request)
	throws Exception {
		log.info("Petición recibida: listaKardex");
		GenericListResponse<ListaKardexResDTO> response = new GenericListResponse<>();
		response.setData(kardexService.listaKardex(request));
		return response;
	}
	
	/**
	 * Método que retorna el total de los registros del Kardex
	 *
	 * @param request {@linkplain ListaKardexReqDTO}
	 *
	 * @return {@linkplain GenericListResponse}
	 *
	 * @throws Exception Excepcion
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @since 12/05/2023
	 */
	@PostMapping(path = "totalRegistrosKardex", consumes = "application/json")
	public GenericListResponse<TotalRegistrosKardexResDTo> totalRegistrosKardex(@RequestBody ListaKardexReqDTO request)throws Exception {
		log.info("Petición recibida: listaKardex");
		GenericListResponse<TotalRegistrosKardexResDTo> response = new GenericListResponse<>();
		response.setData(kardexService.totalRegistrosKardex(request));
		return response;
	}
	
	/**
	 * Método que retorna el vehiculo solicitado para posteriormente hacerle ingresos de kardex
	 *
	 * @param request {@linkplain ListaKardexReqDTO}
	 *
	 * @return {@linkplain GenericListResponse}
	 *
	 * @throws Exception Excepcion
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @since 17/05/2023
	 */
	@PostMapping(path = "elementoParaKardex", consumes = "application/json")
	public GenericListResponse<ElementoKardexResDTO> totalRegistrosKardex(@RequestBody ElementoKardexReqDTO request)throws Exception {
		log.info("Petición recibida: listaKardex");
		GenericListResponse<ElementoKardexResDTO> response = new GenericListResponse<>();
		response.setData(kardexService.elementoKardex(request));
		return response;
	}
	
	/**
	 * Método que retorna las placas con similitud a la solicitada por el ususario
	 *
	 * @param request {@linkplain ListaKardexReqDTO}
	 *
	 * @return {@linkplain GenericListResponse}
	 *
	 * @throws Exception Excepcion
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @since 12/05/2023
	 */
	@PostMapping(path = "listaElementoPorTipoPlaca", consumes = "application/json")
	public GenericListResponse<ListaPlacaDiscoResDTO> listaElementoPorTipo(@RequestBody ElementoPorPlacaReqDTO request) throws Exception {
		log.info("Petición recibida: listaElementoPorTipo");
		GenericListResponse<ListaPlacaDiscoResDTO> response = new GenericListResponse<>();
		response.setData(kardexService.placasVehiculo(request));
		return response;
	}
	
	/**
	 * Método que retorna las tareas disponibles para los registros del kardex
	 *
	 * @param request {@linkplain TareasKardexReqDTO}
	 *
	 * @return {@linkplain GenericListResponse}
	 *
	 * @throws Exception Excepcion
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @since 19/05/2023
	 */
	@PostMapping(path = "kardexTarea", consumes = "application/json")
	public GenericListResponse<TareasKardexResDTO> kardexTarea(@RequestBody TareasKardexReqDTO request)throws Exception {
		log.info("Petición recibida: kardexTarea");
		GenericListResponse<TareasKardexResDTO> response = new GenericListResponse<>();
		response.setData(kardexService.kardexTarea(request));
		return response;
	}
	
	/**
	 * Método que retorna los tipos de mantenimeintos disponibles para los registros del kardex
	 *
	 * @param request {@linkplain TareasKardexReqDTO}
	 *
	 * @return {@linkplain GenericListResponse}
	 *
	 * @throws Exception Excepcion
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @since 19/05/2023
	 */
	@PostMapping(path = "listaTipoMantenimientos", consumes = "application/json")
	public GenericListResponse<Object> listaTipoMantenimientos(@RequestBody Object request) throws Exception {
		log.info("Petición recibida: listaTipoMantenimientos");
		GenericListResponse<Object> response = new GenericListResponse<>();
		response.setData(Arrays.asList(kardexService.listaTipoMantenimientos(Formato.mapearObjDeserializado(request, InfoTipoMantenimiento.class)).toArray()));
		return response;
	}
}
