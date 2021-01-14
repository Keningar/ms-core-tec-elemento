package ec.telconet.elemento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.telconet.microservicio.dependencia.util.dto.PageDTO;
import ec.telconet.microservicio.dependencia.util.exception.GenericException;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.DetalleElementoReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.InfoDetalleElemento;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.service.InfoDetalleElementoService;

/**
 * Clase utilizada donde se encuentran los servicios de los detalles del elemento
 *
 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
 * @version 1.0
 * @since 02/03/2020
 */
@Service
public class DetalleElementoService {
	@Autowired
	InfoDetalleElementoService infoDetalleElementoService;
	
	/**
	 * Método que guarda un detalle del elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request InfoDetalleElemento
	 * @return InfoDetalleElemento
	 * @throws Exception Exception
	 */
	@Transactional(rollbackFor = { Exception.class, GenericException.class }, value = "telconetTransactionManager")
	public InfoDetalleElemento guardarDetalleElemento(InfoDetalleElemento request) throws Exception {
		return infoDetalleElementoService.guardar(request);
	}
	
	/**
	 * Método que actualiza un detalle del elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request InfoDetalleElemento
	 * @return InfoDetalleElemento
	 * @throws Exception Exception
	 */
	@Transactional(rollbackFor = { Exception.class, GenericException.class }, value = "telconetTransactionManager")
	public InfoDetalleElemento actualizarDetalleElemento(InfoDetalleElemento request) throws Exception {
		return infoDetalleElementoService.actualizar(request);
	}
	
	/**
	 * Método que elimina un detalle del elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request InfoDetalleElemento
	 * @return Boolean
	 * @throws Exception Exception
	 */
	@Transactional(rollbackFor = { Exception.class, GenericException.class }, value = "telconetTransactionManager")
	public Boolean eliminarDetalleElemento(InfoDetalleElemento request) throws Exception {
		return infoDetalleElementoService.eliminar(request);
	}
	
	/**
	 * Método que retorna la lista de detalle del elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @return List<InfoDetalleElemento>
	 * @throws Exception Exception
	 */
	@Transactional(readOnly = true)
	public List<InfoDetalleElemento> listaDetalleElemento() throws Exception {
		return infoDetalleElementoService.lista();
	}
	
	/**
	 * Método que retorna la lista de detalle del elemento con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request InfoDetalleElemento
	 * @return List<InfoDetalleElemento>
	 * @throws Exception Exception
	 */
	@Transactional(readOnly = true)
	public List<InfoDetalleElemento> listaDetalleElementoPor(InfoDetalleElemento request) throws Exception {
		return infoDetalleElementoService.listaPor(request);
	}
	
	/**
	 * Método que retorna la paginación de una lista de detalle del elemento con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request PageDTO<InfoDetalleElemento>
	 * @return Page<InfoDetalleElemento>
	 * @throws Exception Exception
	 */
	@Transactional(readOnly = true)
	public Page<InfoDetalleElemento> paginaListaDetalleElementoPor(PageDTO<InfoDetalleElemento> request) throws Exception {
		return infoDetalleElementoService.paginaListaPor(request);
	}
	
	/**
	 * Método que retorna la lista de detalles de un elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request DetalleElementoReqDTO
	 * @return List<InfoDetalleElemento>
	 * @throws Exception Exception
	 */
	@Transactional(readOnly = true)
	public List<InfoDetalleElemento> listaDetalleElementoPorElemento(DetalleElementoReqDTO request) throws Exception {
		return infoDetalleElementoService.detalleElementoPorElemento(request);
	}
}
