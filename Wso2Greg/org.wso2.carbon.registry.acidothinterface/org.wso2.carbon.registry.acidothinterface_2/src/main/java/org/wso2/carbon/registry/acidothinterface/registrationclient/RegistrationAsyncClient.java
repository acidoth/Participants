package org.wso2.carbon.registry.acidothinterface.registrationclient;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;
import org.wso2.carbon.registry.acidothinterface.AcidothDataHolder;
import org.wso2.carbon.registry.acidothinterface.thriftgen.registration.CoordinationContext;
import org.wso2.carbon.registry.acidothinterface.thriftgen.registration.EndPointReference;
import org.wso2.carbon.registry.acidothinterface.thriftgen.registration.RegistrationService;

import java.io.IOException;

public class RegistrationAsyncClient {
    private String serverUrl;
    private int port;
    private boolean result = false;
    private String wait = new String();

    TAsyncClientManager tAsyncClientManager = null;

    public RegistrationAsyncClient(String serverUrl, int port){
        this.serverUrl = serverUrl;
        this.port = port;
        this.tAsyncClientManager= AcidothDataHolder.tAsyncClientManager;


    }


    public boolean Register(CoordinationContext coorcontext, String protocolIdentifier, EndPointReference protocolServiceEPR){

        TNonblockingTransport tNonblockingTransport=null;
        TProtocolFactory tProtocolFactory = null;

        try {
            tNonblockingTransport=new TNonblockingSocket(serverUrl,port);
            tProtocolFactory = new TBinaryProtocol.Factory();

            //tNonblockingTransport.open();
            RegistrationService.AsyncClient client = new RegistrationService.AsyncClient(tProtocolFactory, tAsyncClientManager, tNonblockingTransport);
            client.registerParticipant(coorcontext, protocolIdentifier, protocolServiceEPR, new RegisterCallback());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (TException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        synchronized (wait){
            try {
                wait.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        tNonblockingTransport.close();
        return result;
    }

    class RegisterCallback implements AsyncMethodCallback<RegistrationService.AsyncClient.registerParticipant_call> {

        @Override
        public void onComplete(RegistrationService.AsyncClient.registerParticipant_call registerParticipant_call) {
            //To change body of implemented methods use File | Settings | File Templates.
            try {
                result = registerParticipant_call.getResult();

                synchronized (wait){
                    wait.notifyAll();
                }
            } catch (TException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        @Override
        public void onError(Exception e) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
