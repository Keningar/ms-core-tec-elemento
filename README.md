# ms-core-tec-elemento

Microservicio core encargado de obtener toda la data relacionada con los elementos.

## Configuración

1. Tener conexión a kafka.
2. Tener conexión con la base oracle.

## Documentación

1. Carpeta doc

## Request y Response

1. [Swagger](http://test-apps4.telconet.ec/swagger/swagger-ui.html?urls.primaryName=elemento%40docker)
2. [Documento de contratos](doc/Contratos-MSA-ELEMENTO.pdf)

## Parámetros

**Nota**: El parámetro **application.properties.dist** debera ser copiado en la carpeta src/resources como **application.properties**

| Clave                                         | Observación                                                                                                   |
|-----------------------------------------------|---------------------------------------------------------------------------------------------------------------|
| aplicacion.nombre                             | Nombre de la aplicación.                                                                                      |
| server.port                                   | Puerto del ms.                                                                                                |
| spring.kafka.bootstrap-servers                | Definir los servidores de kafka.                                                                              |
| kafka.request-reply.timeout-ms                | Tiempo en minutos de un petición kafka.                                                                       |
| ruta.parameterslocal                          | Ruta de parameters.yml.                                                                                       |
| host.parameter                                | Host o ambiente de parameters.yml.                                                                            |
| spring.datasource.hikari.idle-timeout         | Idle timeout hikari.                                                                                          |
| spring.datasource.hikari.connection-timeout   | Conexión timeout hikari.                                                                                      |
| spring.datasource.hikari.maximum-pool-size    | Máximo de pool de conexiones hikari.                                                                          |
| spring.datasource.hikari.minimum-idle         | Mínimo de pool de conexiones hikari.                                                                          |
| spring.datasource.hikari.max-lifetime         | Maximo de tiempo de vida de un pool.                                                                          |
| logging.config                                | Mínimo de pool de conexiones hikari.                                                                          |
| jaeger.tracer.host                            | Definir el servidor jaeger.                                                                                   |
| jaeger.tracer.port                            | Definir el puerto jaeger.                                                                                     |
| kafka.ms.topic-sync-sufijo                    | Sufijo topic sync.                                                                                            |
| kafka.ms.topic-asyn-sufijo                    | Sufijo topic async.                                                                                           |

Nota: Parámetros nuevos se debe versionar en **application.properties.dist**.