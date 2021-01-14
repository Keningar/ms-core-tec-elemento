package ec.telconet.elemento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.telconet.microservicio.dependencia.util.dto.PageDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.AdmiMarcaElemento;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.service.AdmiMarcaElementoService;

/**
 * Clase utilizada donde se encuentran los servicios de las marcas de elementos
 *
 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
 * @version 1.0
 * @since 02/03/2020
 */
@Service
public class MarcaElementoService {
	@Autowired
	AdmiMarcaElementoService admiMarcaElementoService;
	
	/**
	 * Método que retorna la lista de marcas de elemetos
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @return List<AdmiMarcaElemento>
	 * @throws Exception Exception
	 */
	@Transactional(readOnly = true)
	public List<AdmiMarcaElemento> listaMarcaElemento() throws Exception {
		return admiMarcaElementoService.lista();
	}
	
	/**
	 * Método que retorna la lista de marcas de elementos con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request AdmiMarcaElemento
	 * @return List<AdmiMarcaElemento>
	 * @throws Exception Exception
	 */
	@Transactional(readOnly = true)
	public List<AdmiMarcaElemento> listaMarcaElementoPor(AdmiMarcaElemento request) throws Exception {
		return admiMarcaElementoService.listaPor(request);
	}
	
	/**
	 * Método que retorna la paginación de una lista de marcas de elementos con filtros
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param request PageDTO<AdmiMarcaElemento>
	 * @return Page<AdmiMarcaElemento>
	 * @throws Exception Exception
	 */
	@Transactional(readOnly = true)
	public Page<AdmiMarcaElemento> paginaListaMarcaElementoPor(PageDTO<AdmiMarcaElemento> request) throws Exception {
		return admiMarcaElementoService.paginaListaPor(request);
	}
}
