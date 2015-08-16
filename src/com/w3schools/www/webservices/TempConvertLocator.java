/**
 * TempConvertLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.w3schools.www.webservices;

public class TempConvertLocator extends org.apache.axis.client.Service implements com.w3schools.www.webservices.TempConvert {

    public TempConvertLocator() {
    }


    public TempConvertLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TempConvertLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TempConvertSoap
    private java.lang.String TempConvertSoap_address = "http://www.w3schools.com/webservices/tempconvert.asmx";

    public java.lang.String getTempConvertSoapAddress() {
        return TempConvertSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TempConvertSoapWSDDServiceName = "TempConvertSoap";

    public java.lang.String getTempConvertSoapWSDDServiceName() {
        return TempConvertSoapWSDDServiceName;
    }

    public void setTempConvertSoapWSDDServiceName(java.lang.String name) {
        TempConvertSoapWSDDServiceName = name;
    }

    public com.w3schools.www.webservices.TempConvertSoap getTempConvertSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TempConvertSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTempConvertSoap(endpoint);
    }

    public com.w3schools.www.webservices.TempConvertSoap getTempConvertSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.w3schools.www.webservices.TempConvertSoapStub _stub = new com.w3schools.www.webservices.TempConvertSoapStub(portAddress, this);
            _stub.setPortName(getTempConvertSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTempConvertSoapEndpointAddress(java.lang.String address) {
        TempConvertSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.w3schools.www.webservices.TempConvertSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.w3schools.www.webservices.TempConvertSoapStub _stub = new com.w3schools.www.webservices.TempConvertSoapStub(new java.net.URL(TempConvertSoap_address), this);
                _stub.setPortName(getTempConvertSoapWSDDServiceName());
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
        if ("TempConvertSoap".equals(inputPortName)) {
            return getTempConvertSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.w3schools.com/webservices/", "TempConvert");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.w3schools.com/webservices/", "TempConvertSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TempConvertSoap".equals(portName)) {
            setTempConvertSoapEndpointAddress(address);
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
