package com.mattiz.axis.request;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;

public class MattizWebServiceConsumer {

	public static void main(String[] args) {
		try {
			String endpoint = "http://localhost:8080/mattiz/services/MattizAxisTest";

			MattizAxisServerImplServiceLocator srvLoc = new MattizAxisServerImplServiceLocator();
			srvLoc.setEndpointAddress(new javax.xml.namespace.QName(
					"urn:mattiz", "MattizAxisTest"), endpoint);
			MattizAxisServerImpl serviceimpl = srvLoc.getMattizAxisTest();

			((javax.xml.rpc.Stub) serviceimpl)._setProperty(
					"javax.xml.rpc.session.maintain", Boolean.TRUE);
			String person = "Matty";

			String ret = serviceimpl.returnMessage(person);
			System.out.println("Message " + ret);

		} catch (ServiceException e) {
			// TODO Auto-generated catch blockS
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}