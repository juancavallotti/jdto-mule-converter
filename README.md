jDTO Binder Transformer for Mule ESB
====================================

This is a transformer which takes advantage of the jDTO Binder Object-to-Object mapping capabilities. 
For more information and documentation of jDTO Binder please visit http://www.jdto.org.

Building The Project
--------------------

Please check out the instructions for configuring maven in the MuleSource website:  http://www.mulesoft.org/documentation/display/MULECDEV/Using+Maven

This project depends on a yet unreleased version of jDTO Binder so, in order to test this, please check out the latest source and build it.

You can find the source for jDTO Binder here: https://github.com/jDTOBinder/jDTO-Binder

Basic Usage
-----------

This Mule module should fine work with Mule ESB 3.3.0, previous versions are not supported.

The following is a sample flow to demonstrate how to incorporate the component into your Mule Flows:

```xml

<?xml version="1.0" encoding="UTF-8"?>
<mule xmlns:doc="http://www.mulesoft.org/schema/mule/documentation" xmlns="http://www.mulesoft.org/schema/mule/core"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:spring="http://www.springframework.org/schema/beans"
      xmlns:http="http://www.mulesoft.org/schema/mule/http"
      xmlns:mule-xml="http://www.mulesoft.org/schema/mule/xml"
      xmlns:jdto="http://www.mulesoft.org/schema/mule/jdto"
    xsi:schemaLocation="
    http://www.mulesoft.org/schema/mule/http http://www.mulesoft.org/schema/mule/http/current/mule-http.xsd 
    http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd 
    http://www.mulesoft.org/schema/mule/core http://www.mulesoft.org/schema/mule/core/current/mule.xsd 
    http://www.mulesoft.org/schema/mule/xml http://www.mulesoft.org/schema/mule/xml/3.3/mule-xml.xsd 
    http://www.mulesoft.org/schema/mule/jdto http://www.mulesoft.org/schema/mule/jdto/current/mule-jdto.xsd"
    >
    
    <!-- define the global DTO binder -->
    <spring:bean id="dtoBinder" class="org.jdto.spring.SpringDTOBinder"></spring:bean>
    
    <flow name="main" doc:name="main">
    	<!-- http inbound -->
        <http:inbound-endpoint exchange-pattern="request-response" host="localhost" port="8081" doc:name="HTTP" mimeType="text/plain"/>
        <!-- Convert the query string into a map -->
        <http:body-to-parameter-map-transformer doc:name="Body to Parameter Map"/>
        <!-- build the object -->
        <jdto:bind dtoBinder-ref="dtoBinder" targetClass="org.jdto.mule.Person" />
        <!-- print the string version -->
        <object-to-string-transformer doc:name="Object to String"/>
    </flow>
</mule>

```

And the Person class looks like:

```java
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    @Source("last")
    private String lastName;

    private int age;

    ... //getters and setters

    @Override
    public String toString() {
            return "Person [name=" + name + ", lastName=" + lastName + ", age="
                            + age + "]";
    }
}
```

To test it, open a browser with the following url:

    http://localhost:8081?name=Keith&last=Richards&age=79

And should print out the following:


    Person [name=Keith, lastName=Richards, age=79]


Please note that this artifact is under development and currently cannot be used on production environments.