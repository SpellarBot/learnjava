**Stereo Type Annotations:**

@Component - POJO
@Service - Business Logic Layer
@Repository - Data Layer

**Autowiring**

_Using Java_

Create AppConfig class, and annotate with
@Configuration
@ComponentScan({"com.purihim"})

In the main class, create context as follows :
```java
ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
```

_Using XML_

Create applicationContext.xml and then add code:
```xml
    <context:annotation-config/>
    <context:component-scan base-package="com.purihim"/>
```

In the main class, create context as follows :
```java
ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
```

**Scopes**

All Java:

1. Singleton - Default - one instance per spring container. ( multi spring container possible per jvm )
2. Prototype

Web Scopes:

3. Request
4. Session
5. Global

**Property Files**\

Define a property in app.properties
```
dbUsername=sa
```

To use:

_Using xml_

```xml
<context:property-placeholder location="app.properties"/>    <!-- to use any variable, use like this - ${dbUsername}-->

<bean name="somebean" class="com.purihim.SomeBean">
    <property name="fieldVar" value="${dbUsername}"/>
</bean>
```

_Using Annotations_

In the AppConfig.java, add another annotation to tell where properties are:

```java
@Configuration
@ComponentScan({"com.purihim"})
@PropertySource("app.properties")
public class AppConfig {
}
```

in class, @Value annotation:
```java
@Value("${dbUsername}")
private String user;
```


