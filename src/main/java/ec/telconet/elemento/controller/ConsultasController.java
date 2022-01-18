package ec.telconet.elemento.controller;

import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.telconet.elemento.service.ConsultasService;
import ec.telconet.microservicio.dependencia.util.response.GenericListResponse;

/**
 * Clase utilizada para publicar microservicios técnicos con información
 * referente a las consultas DTO
 * 
 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
 * @version 1.0
 * @since 05/05/2020
 * 
 */
@RestController
@RequestMapping
public class ConsultasController {
	Logger log = LogManager.getLogger(this.getClass());

	@Autowired
	ConsultasService consultasService;

	/**
	 * Método que retorna los datos de un vehículo
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 05/05/2020
	 * 
	 * @param request {@linkplain DatosVehiculoReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "datosVehiculo", consumes = "application/json")
	public GenericListResponse<DatosVehiculoResDTO> datosVehiculo(@RequestBody DatosVehiculoReqDTO request)
			throws Exception {
		log.info("Petición recibida: datosVehiculo");
		GenericListResponse<DatosVehiculoResDTO> response = new GenericListResponse<>();
		response.setData(consultasService.datosVehiculo(request));
		return response;
	}

	/**
	 * Método que retorna los elementos de un grupo de monitorización
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 23/06/2020
	 * 
	 * @param request {@linkplain ElementoPorGrupoReqDTO}
	 * @return {@linkplain GenericListResponse}
	 * @throws Exception Excepcion
	 */
	@PostMapping(path = "elementoPorGrupo", consumes = "application/json")
	public GenericListResponse<ElementoPorGrupoResDTO> elementoPorGrupo(@RequestBody ElementoPorGrupoReqDTO request)
			throws Exception {
		log.info("Petición recibida: elementoPorGrupo");
		GenericListResponse<ElementoPorGrupoResDTO> response = new GenericListResponse<>();
		response.setData(consultasService.elementoPorGrupo(request));
		return response;
	}

	/**
	 * Método que retorna los modelos de los elementos monitorizados
	 *
	 * @param request {@linkplain ModelosElemMonitorizadosReqDTO}
	 *
	 * @return {@linkplain GenericListResponse}
	 *
	 * @throws Exception Excepcion
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 23/06/2020
	 */
	@PostMapping(path = "modelosElemMonitorizados", consumes = "application/json")
	public GenericListResponse<ModelosElemMonitorizadosResDTO> modelosElemMonitorizados(@RequestBody ModelosElemMonitorizadosReqDTO request)
	throws Exception {
		log.info("Petición recibida: modelosElemMonitorizados");
		GenericListResponse<ModelosElemMonitorizadosResDTO> response = new GenericListResponse<>();
		response.setData(consultasService.modelosElemMonitorizados(request));
		return response;
	}
}
