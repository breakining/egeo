/**
 * ProdutionInterfaceServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.evun.ime.ws.service.impl;

public class ProdutionInterfaceServiceImplServiceLocator extends org.apache.axis.client.Service implements cn.evun.ime.ws.service.impl.ProdutionInterfaceServiceImplService {

    public ProdutionInterfaceServiceImplServiceLocator() {
    }


    public ProdutionInterfaceServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProdutionInterfaceServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ProdutionInterfaceServiceImplPort
    private java.lang.String ProdutionInterfaceServiceImplPort_address = "http://127.0.0.1:8080/ws/service/pdInterface";

    public java.lang.String getProdutionInterfaceServiceImplPortAddress() {
        return ProdutionInterfaceServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ProdutionInterfaceServiceImplPortWSDDServiceName = "ProdutionInterfaceServiceImplPort";

    public java.lang.String getProdutionInterfaceServiceImplPortWSDDServiceName() {
        return ProdutionInterfaceServiceImplPortWSDDServiceName;
    }

    public void setProdutionInterfaceServiceImplPortWSDDServiceName(java.lang.String name) {
        ProdutionInterfaceServiceImplPortWSDDServiceName = name;
    }

    public cn.evun.ime.ws.service.ProdutionInterfaceService getProdutionInterfaceServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ProdutionInterfaceServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getProdutionInterfaceServiceImplPort(endpoint);
    }

    public cn.evun.ime.ws.service.ProdutionInterfaceService getProdutionInterfaceServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.evun.ime.ws.service.impl.ProdutionInterfaceServiceImplServiceSoapBindingStub _stub = new cn.evun.ime.ws.service.impl.ProdutionInterfaceServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getProdutionInterfaceServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setProdutionInterfaceServiceImplPortEndpointAddress(java.lang.String address) {
        ProdutionInterfaceServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.evun.ime.ws.service.ProdutionInterfaceService.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.evun.ime.ws.service.impl.ProdutionInterfaceServiceImplServiceSoapBindingStub _stub = new cn.evun.ime.ws.service.impl.ProdutionInterfaceServiceImplServiceSoapBindingStub(new java.net.URL(ProdutionInterfaceServiceImplPort_address), this);
                _stub.setPortName(getProdutionInterfaceServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ProdutionInterfaceServiceImplPort".equals(inputPortName)) {
            return getProdutionInterfaceServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.service.ws.ime.evun.cn/", "ProdutionInterfaceServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.service.ws.ime.evun.cn/", "ProdutionInterfaceServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ProdutionInterfaceServiceImplPort".equals(portName)) {
            setProdutionInterfaceServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
