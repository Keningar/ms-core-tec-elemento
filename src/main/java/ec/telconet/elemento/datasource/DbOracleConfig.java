package ec.telconet.elemento.datasource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import ec.telconet.microservicio.dependencia.datasource.Configdb;

/**
 * Clase utilizada para configurar los datasources Oracle
 * 
 * @author Marlon Plúas <mailto:mpluas@telconet.ec>
 * @version 1.0
 * @since 02/03/2020
 */
@Configuration
public class DbOracleConfig {
	@Autowired
	private Configdb configdb;
	
	@Value("${ruta.parameterslocal}")
	private String rutaParametersLocal;
	
	@Value("${host.parameter}")
	private String hostParameters;
	
	@Value("${spring.datasource.hikari.idle-timeout}")
	private int idleTimeout;
	
	@Value("${spring.datasource.hikari.connection-timeout}")
	private int connectionTimeout;
	
	@Value("${spring.datasource.hikari.maximum-pool-size}")
	private int maxPoolSize;
	
	@Value("${spring.datasource.hikari.minimum-idle}")
	private int minPoolSize;
	
	@Value("${spring.datasource.hikari.max-lifetime}")
	private int maxLifetime;
	
	private Map<String, Object> hibernateProperties() {
		Map<String, Object> hibernateProperties = new LinkedHashMap<>();
		hibernateProperties.put("hibernate.connection.release_mode", "auto");
		return hibernateProperties;
	}
	
	// INICIO CONFIGURACIÓN INFRAESTRUCTURA
	@Primary
	@Bean(name = "dsInfraestructura")
	public HikariDataSource dsInfraestructura(@Qualifier("dsInfraestructuraProperties") HikariConfig dataSourceConfig) {
		return new HikariDataSource(dataSourceConfig);
	}
	
	@Primary
	@Bean(name = "dsInfraestructuraProperties")
	public HikariConfig dsInfraestructuraConfig() throws Exception {
		ArrayList<String> listaConexiones = new ArrayList<>();
		listaConexiones.add("infraestructura");
		HikariConfig dataSourceConfig = configdb.getConfig(listaConexiones, hostParameters, rutaParametersLocal);
		dataSourceConfig.setPoolName("dsInfraestructura");
		dataSourceConfig.setConnectionTimeout(connectionTimeout);
		dataSourceConfig.setIdleTimeout(idleTimeout);
		dataSourceConfig.setMaximumPoolSize(maxPoolSize);
		dataSourceConfig.setMinimumIdle(minPoolSize);
		dataSourceConfig.setMaxLifetime(maxLifetime);
		dataSourceConfig.setValidationTimeout(10000);
		dataSourceConfig.setConnectionTestQuery("SELECT 1 FROM DUAL");
		dataSourceConfig.setConnectionInitSql("SELECT 1 FROM DUAL");
		dataSourceConfig.addDataSourceProperty("oracle.jdbc.timezoneAsRegion", "false");
		return dataSourceConfig;
	}
	
	@Primary
	@Bean(name = "jdbcInfraestructura")
	@Autowired
	public JdbcTemplate jdbcInfraestructuraTemplate(@Qualifier("dsInfraestructura") DataSource dsInfraestructura) {
		return new JdbcTemplate(dsInfraestructura);
	}
	
	@Primary
	@Bean(name = "InfraestructuraEMFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryInfraestructura(EntityManagerFactoryBuilder builder,
			@Qualifier("dsInfraestructura") DataSource dsInfraestructura) {
		return builder.dataSource(dsInfraestructura).properties(hibernateProperties())
				.packages("ec.telconet.microservicios.dependencias.esquema.infraestructura.entity").persistenceUnit("dbInfraestructura").build();
	}
	
	@Primary
	@Bean(name = "InfraestructuraTM")
	public PlatformTransactionManager transactionManagerInfraestructura(
			@Qualifier("InfraestructuraEMFactory") EntityManagerFactory InfraestructuraEMFactory) {
		return new JpaTransactionManager(InfraestructuraEMFactory);
	}
	// FIN CONFIGURACIÓN INFRAESTRUCTURA
}
