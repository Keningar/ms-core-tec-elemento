package ec.telconet.elemento.kafka;

import java.util.Arrays;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import ec.telconet.elemento.service.ConsultasService;
import ec.telconet.elemento.service.DetalleElementoService;
import ec.telconet.elemento.service.ElementoService;
import ec.telconet.elemento.service.HistorialElementoService;
import ec.telconet.elemento.service.MarcaElementoService;
import ec.telconet.elemento.service.ModeloElementoService;
import ec.telconet.elemento.service.TipoElementoService;
import ec.telconet.microservicio.core.tecnico.kafka.cons.CoreTecnicoConstants;
import ec.telconet.microservicio.core.tecnico.kafka.request.DatosVehiculoKafkaReq;
import ec.telconet.microservicio.core.tecnico.kafka.request.DetalleElementoKafkaReq;
import ec.telconet.microservicio.core.tecnico.kafka.request.ElementoKafkaReq;
import ec.telconet.microservicio.core.tecnico.kafka.request.ElementoPorGrupoKafkaReq;
import ec.telconet.microservicio.core.tecnico.kafka.request.HistorialElementoKafkaReq;
import ec.telconet.microservicio.core.tecnico.kafka.request.MarcaElementoKafkaReq;
import ec.telconet.microservicio.core.tecnico.kafka.request.ModeloElementoKafkaReq;
import ec.telconet.microservicio.core.tecnico.kafka.request.TipoElementoKafkaReq;
import ec.telconet.microservicio.dependencia.util.exception.GenericException;
import ec.telconet.microservicio.dependencia.util.general.Formato;
import ec.telconet.microservicio.dependencia.util.kafka.KafkaRequest;
import ec.telconet.microservicio.dependencia.util.kafka.KafkaResponse;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.DatosVehiculoReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.DatosVehiculoResDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.DetalleElementoReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorCantonParamsReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorFilialParamsReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorGrupoReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorGrupoResDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorMonitorizadoReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorParroquiaParamsReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorProvinciaParamsReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorRegionParamsReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.ElementoPorTipoReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.HistorialElementoPorFechaReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.dto.HistorialElementoReqDTO;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.AdmiMarcaElemento;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.AdmiModeloElemento;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.AdmiTipoElemento;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.InfoDetalleElemento;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.InfoElemento;
import ec.telconet.microservicios.dependencias.esquema.infraestructura.entity.InfoHistorialElemento;

/**
 * Clase utilizada para consumir OP sincrónico o asincrónico en kafka
 * 
 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
 * @version 1.0
 * @since 02/03/2020
 */
@Component
public class ElementoConsumer {
	Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired
	ElementoService elementoService;
	
	@Autowired
	DetalleElementoService detalleElementoService;
	
	@Autowired
	HistorialElementoService historialElementoService;
	
	@Autowired
	MarcaElementoService marcaElementoService;
	
	@Autowired
	ModeloElementoService modeloElementoService;
	
	@Autowired
	TipoElementoService tipoElementoService;
	
	@Autowired
	ConsultasService consultasService;
	
	/**
	 * Listener asincrónico kafka
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param kafkaRequest
	 * @throws GenericException
	 */
	@KafkaListener(topics = CoreTecnicoConstants.TOPIC_ELEMENTO_ASYN, groupId = CoreTecnicoConstants.GROUP_ELEMENTO, containerFactory = "kafkaListenerContainerFactory")
	public void elementoAsynchrotListener(KafkaRequest<?> kafkaRequest) throws GenericException {
		log.info("Petición kafka asincrónico recibida: " + kafkaRequest.getOp());
		// EJECUCIONES ASINCRONICAS
	}
	
	/**
	 * Listener sincrónico kafka
	 * 
	 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
	 * @version 1.0
	 * @since 02/03/2020
	 * 
	 * @param <T>          Objeto de respuesta
	 * @param kafkaRequest
	 * @return KafkaResponse
	 * @throws GenericException
	 */
	@SuppressWarnings("unchecked")
	@KafkaListener(topics = CoreTecnicoConstants.TOPIC_ELEMENTO_SYNC, groupId = CoreTecnicoConstants.GROUP_ELEMENTO, containerFactory = "requestReplyListenerContainerFactory")
	@SendTo()
	public <T> KafkaResponse<T> elementoSynchroListener(KafkaRequest<?> kafkaRequest, Acknowledgment commitKafka) throws GenericException {
		String idTransKafka = UUID.randomUUID().toString();
		log.info("Petición kafka sincrónico recibida: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
		KafkaResponse<String> kafkaResponse = new KafkaResponse<String>();
		try {
			if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_GUARDAR_DETALLE_ELEMENTO)) {
				DetalleElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), DetalleElementoKafkaReq.class);
				// Inicio Proceso logico
				InfoDetalleElemento requestService = Formato.mapearObjDeserializado(data, InfoDetalleElemento.class);
				// Fin Proceso logico
				KafkaResponse<InfoDetalleElemento> response = new KafkaResponse<InfoDetalleElemento>();
				response.setData(Arrays.asList(detalleElementoService.guardarDetalleElemento(requestService)));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_ACTUALIZAR_DETALLE_ELEMENTO)) {
				DetalleElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), DetalleElementoKafkaReq.class);
				// Inicio Proceso logico
				InfoDetalleElemento requestService = Formato.mapearObjDeserializado(data, InfoDetalleElemento.class);
				// Fin Proceso logico
				KafkaResponse<InfoDetalleElemento> response = new KafkaResponse<InfoDetalleElemento>();
				response.setData(Arrays.asList(detalleElementoService.actualizarDetalleElemento(requestService)));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_ELIMINAR_DETALLE_ELEMENTO)) {
				DetalleElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), DetalleElementoKafkaReq.class);
				// Inicio Proceso logico
				InfoDetalleElemento requestService = Formato.mapearObjDeserializado(data, InfoDetalleElemento.class);
				// Fin Proceso logico
				KafkaResponse<Boolean> response = new KafkaResponse<Boolean>();
				response.setData(Arrays.asList(detalleElementoService.eliminarDetalleElemento(requestService)));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_DETALLE_ELEMENTO)) {
				KafkaResponse<InfoDetalleElemento> response = new KafkaResponse<InfoDetalleElemento>();
				response.setData(detalleElementoService.listaDetalleElemento());
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_DETALLE_ELEMENTO_POR)) {
				DetalleElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), DetalleElementoKafkaReq.class);
				// Inicio Proceso logico
				InfoDetalleElemento requestService = Formato.mapearObjDeserializado(data, InfoDetalleElemento.class);
				// Fin Proceso logico
				KafkaResponse<InfoDetalleElemento> response = new KafkaResponse<InfoDetalleElemento>();
				response.setData(detalleElementoService.listaDetalleElementoPor(requestService));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_DETALLE_ELEMENTO_POR_ELEMENTO)) {
				DetalleElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), DetalleElementoKafkaReq.class);
				// Inicio Proceso logico
				DetalleElementoReqDTO requestService = Formato.mapearObjDeserializado(data, DetalleElementoReqDTO.class);
				// Fin Proceso logico
				KafkaResponse<InfoDetalleElemento> response = new KafkaResponse<InfoDetalleElemento>();
				response.setData(detalleElementoService.listaDetalleElementoPorElemento(requestService));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_GUARDAR_ELEMENTO)) {
				ElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), ElementoKafkaReq.class);
				// Inicio Proceso logico
				InfoElemento requestService = Formato.mapearObjDeserializado(data, InfoElemento.class);
				// Fin Proceso logico
				KafkaResponse<InfoElemento> response = new KafkaResponse<InfoElemento>();
				response.setData(Arrays.asList(elementoService.guardarElemento(requestService)));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_ACTUALIZAR_ELEMENTO)) {
				ElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), ElementoKafkaReq.class);
				// Inicio Proceso logico
				InfoElemento requestService = Formato.mapearObjDeserializado(data, InfoElemento.class);
				// Fin Proceso logico
				KafkaResponse<InfoElemento> response = new KafkaResponse<InfoElemento>();
				response.setData(Arrays.asList(elementoService.actualizarElemento(requestService)));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_ELIMINAR_ELEMENTO)) {
				ElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), ElementoKafkaReq.class);
				// Inicio Proceso logico
				InfoElemento requestService = Formato.mapearObjDeserializado(data, InfoElemento.class);
				// Fin Proceso logico
				KafkaResponse<Boolean> response = new KafkaResponse<Boolean>();
				response.setData(Arrays.asList(elementoService.eliminarElemento(requestService)));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_ELEMENTO)) {
				KafkaResponse<InfoElemento> response = new KafkaResponse<InfoElemento>();
				response.setData(elementoService.listaElemento());
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_ELEMENTO_POR)) {
				ElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), ElementoKafkaReq.class);
				// Inicio Proceso logico
				InfoElemento requestService = Formato.mapearObjDeserializado(data, InfoElemento.class);
				// Fin Proceso logico
				KafkaResponse<InfoElemento> response = new KafkaResponse<InfoElemento>();
				response.setData(elementoService.listaElementoPor(requestService));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_ELEMENTO_POR_TIPO)) {
				ElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), ElementoKafkaReq.class);
				// Inicio Proceso logico
				ElementoPorTipoReqDTO requestService = Formato.mapearObjDeserializado(data, ElementoPorTipoReqDTO.class);
				// Fin Proceso logico
				KafkaResponse<InfoElemento> response = new KafkaResponse<InfoElemento>();
				response.setData(elementoService.listaElementoPorTipo(requestService));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_ELEMENTO_POR_ES_MONITORIZADO)) {
				ElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), ElementoKafkaReq.class);
				// Inicio Proceso logico
				ElementoPorMonitorizadoReqDTO requestService = Formato.mapearObjDeserializado(data, ElementoPorMonitorizadoReqDTO.class);
				// Fin Proceso logico
				KafkaResponse<InfoElemento> response = new KafkaResponse<InfoElemento>();
				response.setData(elementoService.listaElementoPorEsMonitorizado(requestService));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_ELEMENTO_POR_REGION_PARAMS)) {
				ElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), ElementoKafkaReq.class);
				// Inicio Proceso logico
				ElementoPorRegionParamsReqDTO requestService = Formato.mapearObjDeserializado(data, ElementoPorRegionParamsReqDTO.class);
				// Fin Proceso logico
				KafkaResponse<InfoElemento> response = new KafkaResponse<InfoElemento>();
				response.setData(elementoService.listaElementoPorRegionParams(requestService));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_ELEMENTO_POR_PROVINCIA_PARAMS)) {
				ElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), ElementoKafkaReq.class);
				// Inicio Proceso logico
				ElementoPorProvinciaParamsReqDTO requestService = Formato.mapearObjDeserializado(data, ElementoPorProvinciaParamsReqDTO.class);
				// Fin Proceso logico
				KafkaResponse<InfoElemento> response = new KafkaResponse<InfoElemento>();
				response.setData(elementoService.listaElementoPorProvinciaParams(requestService));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_ELEMENTO_POR_PARROQUIA_PARAMS)) {
				ElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), ElementoKafkaReq.class);
				// Inicio Proceso logico
				ElementoPorParroquiaParamsReqDTO requestService = Formato.mapearObjDeserializado(data, ElementoPorParroquiaParamsReqDTO.class);
				// Fin Proceso logico
				KafkaResponse<InfoElemento> response = new KafkaResponse<InfoElemento>();
				response.setData(elementoService.listaElementoPorParroquiaParams(requestService));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_ELEMENTO_POR_CANTON_PARAMS)) {
				ElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), ElementoKafkaReq.class);
				// Inicio Proceso logico
				ElementoPorCantonParamsReqDTO requestService = Formato.mapearObjDeserializado(data, ElementoPorCantonParamsReqDTO.class);
				// Fin Proceso logico
				KafkaResponse<InfoElemento> response = new KafkaResponse<InfoElemento>();
				response.setData(elementoService.listaElementoPorCantonParams(requestService));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_ELEMENTO_POR_FILIAL_PARAMS)) {
				ElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), ElementoKafkaReq.class);
				// Inicio Proceso logico
				ElementoPorFilialParamsReqDTO requestService = Formato.mapearObjDeserializado(data, ElementoPorFilialParamsReqDTO.class);
				// Fin Proceso logico
				KafkaResponse<InfoElemento> response = new KafkaResponse<InfoElemento>();
				response.setData(elementoService.listaElementoPorFilialParams(requestService));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_GUARDAR_HISTORIAL_ELEMENTO)) {
				HistorialElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), HistorialElementoKafkaReq.class);
				// Inicio Proceso logico
				InfoHistorialElemento requestService = Formato.mapearObjDeserializado(data, InfoHistorialElemento.class);
				// Fin Proceso logico
				KafkaResponse<InfoHistorialElemento> response = new KafkaResponse<InfoHistorialElemento>();
				response.setData(Arrays.asList(historialElementoService.guardarHistorialElemento(requestService)));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_HISTORIAL_ELEMENTO_POR_ELEMENTO)) {
				HistorialElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), HistorialElementoKafkaReq.class);
				// Inicio Proceso logico
				HistorialElementoReqDTO requestService = Formato.mapearObjDeserializado(data, HistorialElementoReqDTO.class);
				// Fin Proceso logico
				KafkaResponse<InfoHistorialElemento> response = new KafkaResponse<InfoHistorialElemento>();
				response.setData(historialElementoService.listaHistorialElementoPorElemento(requestService));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_HISTORIAL_ELEMENTO_POR_FECHA)) {
				HistorialElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), HistorialElementoKafkaReq.class);
				// Inicio Proceso logico
				HistorialElementoPorFechaReqDTO requestService = Formato.mapearObjDeserializado(data, HistorialElementoPorFechaReqDTO.class);
				// Fin Proceso logico
				KafkaResponse<InfoHistorialElemento> response = new KafkaResponse<InfoHistorialElemento>();
				response.setData(historialElementoService.listaHistorialElementoPorFecha(requestService));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_MARCA_ELEMENTO)) {
				KafkaResponse<AdmiMarcaElemento> response = new KafkaResponse<AdmiMarcaElemento>();
				response.setData(marcaElementoService.listaMarcaElemento());
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_MARCA_ELEMENTO_POR)) {
				MarcaElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), MarcaElementoKafkaReq.class);
				// Inicio Proceso logico
				AdmiMarcaElemento requestService = Formato.mapearObjDeserializado(data, AdmiMarcaElemento.class);
				// Fin Proceso logico
				KafkaResponse<AdmiMarcaElemento> response = new KafkaResponse<AdmiMarcaElemento>();
				response.setData(marcaElementoService.listaMarcaElementoPor(requestService));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_GUARDAR_MODELO_ELEMENTO)) {
				ModeloElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), ModeloElementoKafkaReq.class);
				// Inicio Proceso logico
				AdmiModeloElemento requestService = Formato.mapearObjDeserializado(data, AdmiModeloElemento.class);
				// Fin Proceso logico
				KafkaResponse<AdmiModeloElemento> response = new KafkaResponse<AdmiModeloElemento>();
				response.setData(Arrays.asList(modeloElementoService.guardarModeloElemento(requestService)));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_MODELO_ELEMENTO)) {
				KafkaResponse<AdmiModeloElemento> response = new KafkaResponse<AdmiModeloElemento>();
				response.setData(modeloElementoService.listaModeloElemento());
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_MODELO_ELEMENTO_POR)) {
				ModeloElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), ModeloElementoKafkaReq.class);
				// Inicio Proceso logico
				AdmiModeloElemento requestService = Formato.mapearObjDeserializado(data, AdmiModeloElemento.class);
				// Fin Proceso logico
				KafkaResponse<AdmiModeloElemento> response = new KafkaResponse<AdmiModeloElemento>();
				response.setData(modeloElementoService.listaModeloElementoPor(requestService));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_GUARDAR_TIPO_ELEMENTO)) {
				TipoElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), TipoElementoKafkaReq.class);
				// Inicio Proceso logico
				AdmiTipoElemento requestService = Formato.mapearObjDeserializado(data, AdmiTipoElemento.class);
				// Fin Proceso logico
				KafkaResponse<AdmiTipoElemento> response = new KafkaResponse<AdmiTipoElemento>();
				response.setData(Arrays.asList(tipoElementoService.guardarTipoElemento(requestService)));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_ACTUALIZAR_TIPO_ELEMENTO)) {
				TipoElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), TipoElementoKafkaReq.class);
				// Inicio Proceso logico
				AdmiTipoElemento requestService = Formato.mapearObjDeserializado(data, AdmiTipoElemento.class);
				// Fin Proceso logico
				KafkaResponse<AdmiTipoElemento> response = new KafkaResponse<AdmiTipoElemento>();
				response.setData(Arrays.asList(tipoElementoService.actualizarTipoElemento(requestService)));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_ELIMINAR_TIPO_ELEMENTO)) {
				TipoElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), TipoElementoKafkaReq.class);
				// Inicio Proceso logico
				AdmiTipoElemento requestService = Formato.mapearObjDeserializado(data, AdmiTipoElemento.class);
				// Fin Proceso logico
				KafkaResponse<Boolean> response = new KafkaResponse<Boolean>();
				response.setData(Arrays.asList(tipoElementoService.eliminarTipoElemento(requestService)));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_TIPO_ELEMENTO)) {
				KafkaResponse<AdmiTipoElemento> response = new KafkaResponse<AdmiTipoElemento>();
				response.setData(tipoElementoService.listaTipoElemento());
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_TIPO_ELEMENTO_POR)) {
				TipoElementoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), TipoElementoKafkaReq.class);
				// Inicio Proceso logico
				AdmiTipoElemento requestService = Formato.mapearObjDeserializado(data, AdmiTipoElemento.class);
				// Fin Proceso logico
				KafkaResponse<AdmiTipoElemento> response = new KafkaResponse<AdmiTipoElemento>();
				response.setData(tipoElementoService.listaTipoElementoPor(requestService));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_DATOS_VEHICULO)) {
				DatosVehiculoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), DatosVehiculoKafkaReq.class);
				// Inicio Proceso logico
				DatosVehiculoReqDTO requestService = Formato.mapearObjDeserializado(data, DatosVehiculoReqDTO.class);
				// Fin Proceso logico
				KafkaResponse<DatosVehiculoResDTO> response = new KafkaResponse<DatosVehiculoResDTO>();
				response.setData(consultasService.datosVehiculo(requestService));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else if (kafkaRequest.getOp().equalsIgnoreCase(CoreTecnicoConstants.OP_LISTA_ELEMENTO_POR_GRUPO)) {
				ElementoPorGrupoKafkaReq data = Formato.mapearObjDeserializado(kafkaRequest.getData(), ElementoPorGrupoKafkaReq.class);
				// Inicio Proceso logico
				ElementoPorGrupoReqDTO requestService = Formato.mapearObjDeserializado(data, ElementoPorGrupoReqDTO.class);
				// Fin Proceso logico
				KafkaResponse<ElementoPorGrupoResDTO> response = new KafkaResponse<ElementoPorGrupoResDTO>();
				response.setData(consultasService.elementoPorGrupo(requestService));
				commitKafka.acknowledge();
				log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka);
				return (KafkaResponse<T>) response;
			} else {
				kafkaResponse.setCode(500);
				kafkaResponse.setStatus("ERROR");
				kafkaResponse.setMessage(
						"No se encuentra configurado el OP " + kafkaRequest.getOp() + " en el grupo " + CoreTecnicoConstants.GROUP_ELEMENTO);
			}
		} catch (GenericException e) {
			kafkaResponse.setCode(e.getCodeError());
			kafkaResponse.setStatus(e.getStatusError());
			kafkaResponse.setMessage(e.getMessageError());
		} catch (Exception e) {
			kafkaResponse.setCode(100);
			kafkaResponse.setStatus("ERROR");
			kafkaResponse.setMessage(e.getMessage());
		}
		commitKafka.acknowledge();
		log.info("Petición kafka sincrónico enviada: " + kafkaRequest.getOp() + ", Transacción: " + idTransKafka + ", Estado: Fallida");
		return (KafkaResponse<T>) kafkaResponse;
	}
}
