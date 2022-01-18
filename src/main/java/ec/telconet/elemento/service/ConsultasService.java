package ec.telconet.elemento.service;

import java.util.List;

import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.telconet.microservicios.dependencias.esquema.infraestructura.service.InkgElementoConsultaService;

/**
 * Clase utilizada donde se encuentran los servicios de consultas DTO
 *
 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
 * @version 1.0
 * @since 05/05/2020
 */
@Service
public class ConsultasService {
	@Autowired
	InkgElementoConsultaService inkgElementoConsultaService;
	
	/**
	 * Método que retorna los datos de un vehículo
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 05/05/2020
	 * 
	 * @param request DatosVehiculoReqDTO
	 * @return List<DatosVehiculoResDTO>
	 * @throws Exception Exception
	 */
	@Transactional(readOnly = true)
	public List<DatosVehiculoResDTO> datosVehiculo(DatosVehiculoReqDTO request) throws Exception {
		return inkgElementoConsultaService.datosVehiculo(request);
	}
	
	/**
	 * Método que retorna los elementos de un grupo de monitorización
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 23/06/2020
	 * 
	 * @param request ElementoPorGrupoReqDTO
	 * @return List<ElementoPorGrupoResDTO>
	 * @throws Exception Exception
	 */
	@Transactional(readOnly = true)
	public List<ElementoPorGrupoResDTO> elementoPorGrupo(ElementoPorGrupoReqDTO request) throws Exception {
		return inkgElementoConsultaService.elementoPorGrupo(request);
	}

	/**
	 * Método que retorna los modelos de los elementos monitorizados
	 *
	 * @param request ElementoPorGrupoReqDTO
	 *
	 * @return List<ElementoPorGrupoResDTO>
	 *
	 * @throws Exception Exception
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @since 23/06/2020
	 */
	public List<ModelosElemMonitorizadosResDTO> modelosElemMonitorizados(ModelosElemMonitorizadosReqDTO request) throws Exception {
		return inkgElementoConsultaService.modelosElementoMonitorizado(request);
	}
}
