package ec.telconet.elemento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.telconet.microservicio.dependencia.util.exception.GenericException;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.HistorialElementoPorFechaReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.HistorialElementoReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.InfoHistorialElemento;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.service.InfoHistorialElementoService;

/**
 * Clase utilizada donde se encuentran los servicios del historial de los elementos
 *
 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
 * @version 1.0
 * @since 02/03/2020
 */
@Service
public class HistorialElementoService {
	@Autowired
	InfoHistorialElementoService infoHistorialElementoService;
	
	/**
	 * Método que guarda un historial de elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request InfoHistorialElemento
	 * @return InfoHistorialElemento
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class, GenericException.class }, value = "telconetTransactionManager")
	public InfoHistorialElemento guardarHistorialElemento(InfoHistorialElemento request) throws Exception {
		return infoHistorialElementoService.guardar(request);
	}
	
	/**
	 * Método que retorna la lista de historial de un elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request HistorialElementoReqDTO
	 * @return List<InfoHistorialElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<InfoHistorialElemento> listaHistorialElementoPorElemento(HistorialElementoReqDTO request) throws Exception {
		return infoHistorialElementoService.historialElementoPorElemento(request);
	}
	
	/**
	 * Método que retorna la lista de historial de un elemento con un rango de fecha
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request HistorialElementoPorFechaReqDTO
	 * @return List<InfoHistorialElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<InfoHistorialElemento> listaHistorialElementoPorFecha(HistorialElementoPorFechaReqDTO request) throws Exception {
		return infoHistorialElementoService.historialElementoPorFecha(request);
	}
}
