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


<mule xmlns="http://www.mulesoft.org/schema/mule/core"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:spring="http://www.springframework.org/schema/beans"
      xmlns:jdto="http://www.mulesoft.org/schema/mule/jdto"
      xmlns:vm="http://www.mulesoft.org/schema/mule/vm"
      xsi:schemaLocation="
        http://www.mulesoft.org/schema/mule/vm http://www.mulesoft.org/schema/mule/vm/current/mule-vm.xsd
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
        http://www.mulesoft.org/schema/mule/core http://www.mulesoft.org/schema/mule/core/current/mule.xsd
        http://www.mulesoft.org/schema/mule/jdto http://www.mulesoft.org/schema/mule/jdto/current/mule-jdto.xsd">
        
    <spring:bean id="dtobinder" class="org.jdto.spring.SpringDTOBinder" />
    
    <flow name="testFlow">
        <vm:inbound-endpoint exchange-pattern="request-response" path="MainFlow"/>
        <jdto:bind dtoBinder-ref="dtobinder" targetClass="org.jdto.mule.SampleDTO" />
    </flow>

</mule>

```

Please note that this artifact is under development and currently cannot be used on production environments.