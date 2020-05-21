package ec.telconet.elemento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.telconet.microservicio.dependencia.util.dto.PageDTO;
import ec.telconet.microservicio.dependencia.util.exception.GenericException;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.AdmiModeloElemento;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.service.AdmiModeloElementoService;

/**
 * Clase utilizada donde se encuentran los servicios de los modelos de elementos
 *
 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
 * @version 1.0
 * @since 02/03/2020
 */
@Service
public class ModeloElementoService {
	@Autowired
	AdmiModeloElementoService admiModeloElementoService;
	
	/**
	 * Método que guarda un modelo de elemento
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request AdmiModeloElemento
	 * @return AdmiModeloElemento
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class, GenericException.class }, value = "telconetTransactionManager")
	public AdmiModeloElemento guardarModeloElemento(AdmiModeloElemento request) throws Exception {
		return admiModeloElementoService.guardar(request);
	}
	
	/**
	 * Método que retorna la lista de modelos de elementos
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @return List<AdmiModeloElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<AdmiModeloElemento> listaModeloElemento() throws Exception {
		return admiModeloElementoService.lista();
	}
	
	/**
	 * Método que retorna la lista de modelos de elementos con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request AdmiModeloElemento
	 * @return List<AdmiModeloElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<AdmiModeloElemento> listaModeloElementoPor(AdmiModeloElemento request) throws Exception {
		return admiModeloElementoService.listaPor(request);
	}
	
	/**
	 * Método que retorna la paginación de una lista de modelos de elementos con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request PageDTO<AdmiModeloElemento>
	 * @return Page<AdmiModeloElemento>
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public Page<AdmiModeloElemento> paginaListaModeloElementoPor(PageDTO<AdmiModeloElemento> request) throws Exception {
		return admiModeloElementoService.paginaListaPor(request);
	}
}
