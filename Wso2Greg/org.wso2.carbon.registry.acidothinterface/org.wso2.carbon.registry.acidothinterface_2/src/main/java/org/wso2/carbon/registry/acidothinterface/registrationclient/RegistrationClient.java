package org.wso2.carbon.registry.acidothinterface.registrationclient;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.wso2.carbon.registry.acidothinterface.thriftgen.registration.CoordinationContext;
import org.wso2.carbon.registry.acidothinterface.thriftgen.registration.EndPointReference;
import org.wso2.carbon.registry.acidothinterface.thriftgen.registration.RegistrationService;


public class RegistrationClient {
	
	private String serverUrl;
    private int port;
	
	public RegistrationClient(String serverUrl, int port){
		this.serverUrl = serverUrl;
        this.port = port;
	}
	
	public boolean Register(CoordinationContext coorcontext, String protocolIdentifier, EndPointReference protocolServiceEPR){
		
		TTransport transport;
		RegistrationService.Client registrationClient;
		boolean result = false;
		
		transport = new TSocket(serverUrl, port);
		try {
			
			transport.open();
			TProtocol protocol = new TBinaryProtocol(transport);
			registrationClient = new RegistrationService.Client(protocol);
			
			result = registrationClient.registerParticipant(coorcontext, protocolIdentifier, protocolServiceEPR);
			
			transport.close();
			
			}catch (TException e) {
				e.printStackTrace();			
		}
		
		return result;
	}

}
