package test;

import com.rightkarma.learnjava.webservices.jaxws.services.SampleService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    // LearningNote - The JaxWsProxyFactoryBean object is created and configured by the following method:
    // LearningNote - The factory’s serviceClass property denotes the web service interface,
    // LearningNote - while the address property indicates the URL address for the proxy to make remote invocations.

    /**
     * LearningNote - below factory bean is equivalent to this xml
     <bean id="client" factory-bean="clientFactory" factory-method="create" />
     <bean id="clientFactory" class="org.apache.cxf.jaxws.JaxWsProxyFactoryBean">
     <property name="serviceClass" value="com.rightkarma.learnjava.webservices.jaxws.services.SampleService" />
     <property name="address" value="http://localhost:8080/services/sampleservice" />
     </bean>
     */
    @Bean
    public JaxWsProxyFactoryBean proxyFactoryBean() {
        JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
        proxyFactory.setServiceClass(SampleService.class);
        proxyFactory.setAddress("http://localhost:8097/services/sampleservice");
        return proxyFactory;
    }

    // LearningNote - The client bean represents a proxy for the SampleService web service.
    // It is created by an invocation to the create method on a JaxWsProxyFactoryBean bean, a factory for the creation of JAX-WS proxies.
    @Bean(name = "client")
    public Object generateProxy() {
        return proxyFactoryBean().create();
    }
}