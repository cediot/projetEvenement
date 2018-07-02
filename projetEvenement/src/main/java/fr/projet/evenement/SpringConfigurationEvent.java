// package fr.projet.evenement;
// import javax.sql.DataSource;
// import org.apache.commons.dbcp2.BasicDataSource;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.PropertySource;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.datasource.DataSourceTransactionManager;
// import
// org.springframework.transaction.annotation.EnableTransactionManagement;
//
/// **
// * Configuration sous la forme d'une classe Java. <br/>
// */
// @Configuration
// @EnableTransactionManagement
// @PropertySource("classpath:spring/database.properties")
// @ComponentScan({ "com.banque.dao", "com.banque.service" })
// public class SpringConfigurationEvent {
//
// @Bean(destroyMethod = "close")
// public DataSource dataSource(@Value("${db.driver}") String driver,
// @Value("${db.url}") String url,
// @Value("${db.login}") String login, @Value("${db.password}") String pwd) {
// BasicDataSource resu = new org.apache.commons.dbcp2.BasicDataSource();
// resu.setDriverClassName(driver);
// resu.setUrl(url);
// resu.setUsername(login);
// resu.setPassword(pwd);
// return resu;
// }
//
// @Bean
// public JdbcTemplate jdbcTemplate(DataSource dataSource) {
// return new JdbcTemplate(dataSource);
// }
//
// @Bean
// public DataSourceTransactionManager transactionManager(DataSource dataSource)
// {
// return new DataSourceTransactionManager(dataSource);
// }
//
//
// }
//
