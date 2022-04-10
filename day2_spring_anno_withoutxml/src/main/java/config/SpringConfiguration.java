package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;


/**
 * 该类是一个配置类，它的作用和xml文件一致
 * spring中的新注解
 * Configuration
 *      作用：指定当前类是一个配置类
 *      细节：当配置类作为AnnotationConfigurationContext对象创建参数时，该注解可以不写。
 * ComponentScan
 *      作用：用于通过注解指定spring在创建容器时要扫描的包
 *      属性：value：它和basePackages是一样的，都是用于指定创建容器时要扫描的包。
 *
 * Bean
 *      作用：用于把当前方法的返回值作为bean对象存入spring的IOC容器中
 *      属性：name：用于指定bean的id，默认值是当前方法名称
 *      细节：当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。
 *           查找方式和Autowired注解的作用是一样的
 * PropertySource
 *      作用：用来扫描properties文件的位置
 *      属性：value：指定文件的名称和路径
 *              关键字：classpath，表示类路径下
 *
 */
@Configuration
@ComponentScan(basePackages = "com.spring")
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /**
     * 用于创建一个QueryRunner对象
     * @param dataSource
     * @return
     */
    @Bean(name = "runner")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源对象
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource cs = new ComboPooledDataSource();
            cs.setDriverClass(driver);
            cs.setJdbcUrl(url);
            cs.setUser(username);
            cs.setPassword(password);
            return cs;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
