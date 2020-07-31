/**
 * MattizAxisTestSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mattiz.axis.request;

import com.mattiz.ws.axis.server.impl.MattizAxisServerImpl;

public class MattizAxisTestSoapBindingImpl implements com.mattiz.axis.request.MattizAxisServerImpl{
    public java.lang.String returnMessage(java.lang.String person) throws java.rmi.RemoteException {
        return new MattizAxisServerImpl().returnMessage(person);
    }

}
