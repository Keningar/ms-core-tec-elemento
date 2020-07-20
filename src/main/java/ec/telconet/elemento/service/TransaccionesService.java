package ec.telconet.elemento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.UbicacionElementoReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.service.InkgElementoTransaccionService;

/**
 * Clase utilizada donde se encuentran los servicios de transacciones DTO
 *
 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
 * @version 1.0
 * @since 04/08/2020
 */
@Service
public class TransaccionesService {
	@Autowired
	InkgElementoTransaccionService inkgElementoTransaccionService;
	
	/**
	 * Método que asigna una ubicación a un elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 04/08/2020
	 * 
	 * @param request UbicacionElementoReqDTO
	 * @return String
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public String asignarUbicacionElemento(UbicacionElementoReqDTO request) throws Exception {
		return inkgElementoTransaccionService.asignarUbicacionElemento(request);
	}
	
	/**
	 * Método que modifica una ubicación a un elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 04/08/2020
	 * 
	 * @param request UbicacionElementoReqDTO
	 * @return String
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public String modificarUbicacionElemento(UbicacionElementoReqDTO request) throws Exception {
		return inkgElementoTransaccionService.modificarUbicacionElemento(request);
	}
}
