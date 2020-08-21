package ec.telconet.elemento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.telconet.microservicio.dependencia.util.dto.PageDTO;
import ec.telconet.microservicio.dependencia.util.exception.GenericException;
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
import ec.telconet.microservicios.dependencias.esquema.infraestructura.service.InfoElementoService;

/**
 * Clase utilizada donde se encuentran los servicios de los elementos
 *
 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
 * @version 1.0
 * @since 02/03/2020
 */
@Service
public class ElementoService {
	@Autowired
	InfoElementoService infoElementoService;
	
	/**
	 * Método que guarda un elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request InfoElemento
	 * @return InfoElemento
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class, GenericException.class }, value = "telconetTransactionManager")
	public InfoElemento guardarElemento(InfoElemento request) throws Exception {
		return infoElementoService.guardar(request);
	}
	
	/**
	 * Método que actualiza un elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request InfoElemento
	 * @return InfoElemento
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class, GenericException.class }, value = "telconetTransactionManager")
	public InfoElemento actualizarElemento(InfoElemento request) throws Exception {
		return infoElementoService.actualizar(request);
	}
	
	/**
	 * Método que retorna la lista de elementos de un tipo de elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request ElementoPorTipoReqDTO
	 * @return List<InfoElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<InfoElemento> listaElementoPorTipo(ElementoPorTipoReqDTO request) throws Exception {
		return infoElementoService.elementoPorTipo(request);
	}
	
	/**
	 * Método que retorna la lista de elementos
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @return List<InfoElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<InfoElemento> listaElemento() throws Exception {
		return infoElementoService.lista();
	}
	
	/**
	 * Método que retorna la lista de elementos con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request InfoElemento
	 * @return List<InfoElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<InfoElemento> listaElementoPor(InfoElemento request) throws Exception {
		return infoElementoService.listaPor(request);
	}
	
	/**
	 * Método que retorna la paginación de una lista de elementos con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request PageDTO<InfoElemento>
	 * @return Page<InfoElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public Page<InfoElemento> paginaListaElementoPor(PageDTO<InfoElemento> request) throws Exception {
		return infoElementoService.paginaListaPor(request);
	}
	
	/**
	 * Método que elimina un elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request InfoElemento
	 * @return Boolean
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class, GenericException.class }, value = "telconetTransactionManager")
	public Boolean eliminarElemento(InfoElemento request) throws Exception {
		return infoElementoService.eliminar(request);
	}
	
	/**
	 * Método que retorna la lista de elementos que tiene como característica ES_MONITORIZADO
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request ElementoPorMonitorizadoReqDTO
	 * @return List<InfoElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<InfoElemento> listaElementoPorEsMonitorizado(ElementoPorMonitorizadoReqDTO request) throws Exception {
		return infoElementoService.elementoPorEsMonitorizado(request);
	}
	
	/**
	 * Método que retorna la lista de elementos por region y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request ElementoPorRegionParamsReqDTO
	 * @return List<InfoElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<InfoElemento> listaElementoPorRegionParams(ElementoPorRegionParamsReqDTO request) throws Exception {
		return infoElementoService.elementoPorRegionParams(request);
	}
	
	/**
	 * Método que retorna la lista de elementos por provincia y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request ElementoPorProvinciaParamsReqDTO
	 * @return List<InfoElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<InfoElemento> listaElementoPorProvinciaParams(ElementoPorProvinciaParamsReqDTO request) throws Exception {
		return infoElementoService.elementoPorProvinciaParams(request);
	}
	
	/**
	 * Método que retorna la lista de elementos por parroquia y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request ElementoPorParroquiaParamsReqDTO
	 * @return List<InfoElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<InfoElemento> listaElementoPorParroquiaParams(ElementoPorParroquiaParamsReqDTO request) throws Exception {
		return infoElementoService.elementoPorParroquiaParams(request);
	}
	
	/**
	 * Método que retorna la lista de elementos por canton y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request ElementoPorCantonParamsReqDTO
	 * @return List<InfoElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<InfoElemento> listaElementoPorCantonParams(ElementoPorCantonParamsReqDTO request) throws Exception {
		return infoElementoService.elementoPorCantonParams(request);
	}
	
	/**
	 * Método que retorna la lista de elementos por filial y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request ElementoPorFilialParamsReqDTO
	 * @return List<InfoElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<InfoElemento> listaElementoPorFilialParams(ElementoPorFilialParamsReqDTO request) throws Exception {
		return infoElementoService.elementoPorFilialParams(request);
	}
	
	/**
	 * Método que retorna la lista de elementos por departamento y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request ElementoPorDepartamentoParamsReqDTO
	 * @return List<InfoElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<InfoElemento> listaElementoPorDepartamentoParams(ElementoPorDepartamentoParamsReqDTO request) throws Exception {
		return infoElementoService.elementoPorDepartamentoParams(request);
	}
	
	/**
	 * Método que retorna la lista de elementos por cuadrilla y params
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 21/08/2020
	 * 
	 * @param request ElementoPorCuadrillaParamsReqDTO
	 * @return List<InfoElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<InfoElemento> listaElementoPorCuadrillaParams(ElementoPorCuadrillaParamsReqDTO request) throws Exception {
		return infoElementoService.elementoPorCuadrillaParams(request);
	}
}
