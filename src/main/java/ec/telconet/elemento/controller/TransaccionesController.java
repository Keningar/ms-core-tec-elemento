package ec.telconet.elemento.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.telconet.elemento.service.TransaccionesService;
import ec.telconet.microservicio.dependencia.util.response.GenericBasicResponse;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.UbicacionElementoReqDTO;

/**
 * Clase utilizada para publicar microservicios técnicos con información referente a las transacciones DTO
 * 
 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
 * @version 1.0
 * @since 04/08/2020
 */
@RestController
@RequestMapping
public class TransaccionesController {
	Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired
	TransaccionesService transaccionesService;
	
	/**
	 * Método que asigna una ubicación a un elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 04/08/2020
	 * 
	 * @param request {@linkplain UbicacionElementoReqDTO}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "asignarUbicacionElemento", consumes = "application/json")
	public GenericBasicResponse<String> asignarUbicacionElemento(@RequestBody UbicacionElementoReqDTO request) throws Exception {
		log.info("Petición recibida: asignarUbicacionElemento");
		GenericBasicResponse<String> response = new GenericBasicResponse<String>();
		response.setData(transaccionesService.asignarUbicacionElemento(request));
		return response;
	}
	
	/**
	 * Método que modifica una ubicación a un elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 04/08/2020
	 * 
	 * @param request {@linkplain UbicacionElementoReqDTO}
	 * @return {@linkplain GenericBasicResponse}
	 * @throws Exception
	 */
	@PostMapping(path = "modificarUbicacionElemento", consumes = "application/json")
	public GenericBasicResponse<String> modificarUbicacionElemento(@RequestBody UbicacionElementoReqDTO request) throws Exception {
		log.info("Petición recibida: modificarUbicacionElemento");
		GenericBasicResponse<String> response = new GenericBasicResponse<String>();
		response.setData(transaccionesService.modificarUbicacionElemento(request));
		return response;
	}
}
