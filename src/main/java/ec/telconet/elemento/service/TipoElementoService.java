package ec.telconet.elemento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.telconet.microservicio.dependencia.util.dto.PageDTO;
import ec.telconet.microservicio.dependencia.util.exception.GenericException;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.AdmiTipoElemento;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.service.AdmiTipoElementoService;

/**
 * Clase utilizada donde se encuentran los servicios de los tipos de elementos
 *
 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
 * @version 1.0
 * @since 02/03/2020
 */
@Service
public class TipoElementoService {
	@Autowired
	AdmiTipoElementoService admiTipoElementoService;
	
	/**
	 * Método que guarda un tipo de elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request AdmiTipoElemento
	 * @return AdmiTipoElemento
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class, GenericException.class }, value = "telconetTransactionManager")
	public AdmiTipoElemento guardarTipoElemento(AdmiTipoElemento request) throws Exception {
		return admiTipoElementoService.guardar(request);
	}
	
	/**
	 * Método que actualiza un tipo de elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request AdmiTipoElemento
	 * @return AdmiTipoElemento
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class, GenericException.class }, value = "telconetTransactionManager")
	public AdmiTipoElemento actualizarTipoElemento(AdmiTipoElemento request) throws Exception {
		return admiTipoElementoService.actualizar(request);
	}
	
	/**
	 * Método que elimina un tipo de elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request AdmiTipoElemento
	 * @return Boolean
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class, GenericException.class }, value = "telconetTransactionManager")
	public Boolean eliminarTipoElemento(AdmiTipoElemento request) throws Exception {
		return admiTipoElementoService.eliminar(request);
	}
	
	/**
	 * Método que retorna la lista de tipo de elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @return List<AdmiTipoElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<AdmiTipoElemento> listaTipoElemento() throws Exception {
		return admiTipoElementoService.lista();
	}
	
	/**
	 * Método que retorna la lista de tipo de elemento con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request AdmiTipoElemento
	 * @return List<AdmiTipoElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<AdmiTipoElemento> listaTipoElementoPor(AdmiTipoElemento request) throws Exception {
		return admiTipoElementoService.listaPor(request);
	}
	
	/**
	 * Método que retorna la paginación de una lista de tipo de elemento con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request PageDTO<AdmiTipoElemento>
	 * @return Page<AdmiTipoElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public Page<AdmiTipoElemento> paginaListaTipoElementoPor(PageDTO<AdmiTipoElemento> request) throws Exception {
		return admiTipoElementoService.paginaListaPor(request);
	}
}
