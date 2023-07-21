package ec.telconet.elemento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.telconet.microservicio.dependencia.util.exception.GenericException;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoKardexReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoKardexResDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorPlacaReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ListaKardexReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ListaKardexResDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ListaPlacaDiscoResDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.TareasKardexReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.TareasKardexResDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.TotalRegistrosKardexResDTo;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.InfoDetalleKardex;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.InfoElemento;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.InfoKardex;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.InfoKardexTarea;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.InfoTipoMantenimiento;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.service.InfoDetalleKardexService;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.service.InfoKardexService;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.service.InfoKardexTareaService;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.service.InfoTipoMantenimientoService;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.service.InkgElementoConsultaService;

/**
 * Clase utilizada donde se encuentran los servicios del kardex
 *
 * @author José Castillo <mailto:jmcastillo@telconet.ec>
 * @version 1.0
 * @since 03/05/2023
 */
@Service
public class KardexService {
	@Autowired
	InkgElementoConsultaService inkgElementoConsultaService;
	
	@Autowired
	InfoKardexService infoKardexService;
	
	@Autowired
	InfoDetalleKardexService infoDetalleKardexService;

	@Autowired
	InfoKardexTareaService infoKardexTareaService;
	
	@Autowired
	InfoTipoMantenimientoService infoTipoMantenimientoService;

	
	/**
	 * Método que guarda los detalles de un registro de un kardex
	 * 
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @version 1.0
	 * @since 23/05/2023
	 * 
	 * @param request InfoDetalleKardex
	 * @return InfoDetalleKardex
	 * @throws Exception Exception
	 */
	@Transactional(rollbackFor = { Exception.class, GenericException.class }, value = "telconetTransactionManager")
	public InfoDetalleKardex guardarDetalleKardex(InfoDetalleKardex request) throws Exception {
		return infoDetalleKardexService.guardarDetalleKardex(request);
	}
	
	/**
	 * Método que guarda la cabecera de un kardex
	 * 
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @version 1.0
	 * @since 03/05/2023
	 * 
	 * @param request InfoKardex
	 * @return InfoKardex
	 * @throws Exception Exception
	 */
	@Transactional(rollbackFor = { Exception.class, GenericException.class }, value = "telconetTransactionManager")
	public InfoKardex guardarKardex(InfoKardex request) throws Exception {
		return infoKardexService.guardar(request);
	}
	
	/**
	 * Método que guarda una nueva categoria
	 * 
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @version 1.0
	 * @since 08/05/2023
	 * 
	 * @param request InfoKardexTarea
	 * @return InfoKardexTarea
	 * @throws Exception Exception
	 */
	@Transactional(rollbackFor = { Exception.class, GenericException.class }, value = "telconetTransactionManager")
	public InfoKardexTarea gurdarKardexTarea(InfoKardexTarea request) throws Exception {
		return infoKardexTareaService.guardarTarea(request);
	}
	
	/**
	 * Método que retorna los tipos de mantenimientos del kardex
	 *
	 * @param request InfoTipoMantenimiento
	 *
	 * @return List<InfoTipoMantenimiento>
	 *
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @version 1.0
	 * @since 19/05/2023
	 */
	@Transactional(readOnly = true)
	public List<InfoTipoMantenimiento> listaTipoMantenimientos(InfoTipoMantenimiento request) throws Exception {
		return infoTipoMantenimientoService.listaTipoMantenimientos(request);
	}
	
	/**
	 * Método que retorna los registros del kardex
	 *
	 * @param request ListaKardexReqDTO
	 *
	 * @return List<ListaKardexResDTO>
	 *
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @version 1.0
	 * @since 11/05/2023
	 */
	public List<ListaKardexResDTO> listaKardex(ListaKardexReqDTO request) throws Exception {
		return inkgElementoConsultaService.listaKardex(request);
	}
	
	/**
	 * Método que retorna los resultados del vehiculo que recibira los ingresos de mantenimeinto en kardex
	 *
	 * @param request ElementoKardexReqDTO
	 *
	 * @return List<ElementoKardexResDTO>
	 *
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @version 1.0
	 * @since 11/05/2023
	 */
	public List<ElementoKardexResDTO> elementoKardex(ElementoKardexReqDTO request) throws Exception {
		return inkgElementoConsultaService.elementoKardex(request);
	}
	
	/**
	 * Método que retorna el total de los registros del kardex
	 *
	 * @param request ListaKardexReqDTO
	 *
	 * @return List<ListaKardexResDTO>
	 *
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @version 1.0
	 * @since 11/05/2023
	 */
	public List<TotalRegistrosKardexResDTo> totalRegistrosKardex(ListaKardexReqDTO request) throws Exception {
		return inkgElementoConsultaService.totalRegistrosKardex(request);
	}
	
	/**
	 * Método que retorna las placas con coincidencia ingresada
	 *
	 * @param request ListaKardexReqDTO
	 *
	 * @return List<ListaKardexResDTO>
	 *
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @version 1.0
	 * @since 11/05/2023
	 */
	public List<ListaPlacaDiscoResDTO> placasVehiculo(ElementoPorPlacaReqDTO request) throws Exception {
		return inkgElementoConsultaService.placasVehiculo(request);
	}
	
	/**
	 * Método que retorna las tareas que se seleccionaran en los registros del kardex
	 *
	 * @param request TareasKardexReqDTO
	 *
	 * @return List<TareasKardexResDTO>
	 *
	 * @author José Castillo <mailto:jmcastillo@telconet.ec>
	 * @version 1.0
	 * @since 19/05/2023
	 */
	public List<TareasKardexResDTO> kardexTarea(TareasKardexReqDTO request) throws Exception {
		return inkgElementoConsultaService.kardexTarea(request);
	}
}
