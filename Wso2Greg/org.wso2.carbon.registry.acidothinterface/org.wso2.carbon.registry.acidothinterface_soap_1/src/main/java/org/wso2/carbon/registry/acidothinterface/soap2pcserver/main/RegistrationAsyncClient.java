package org.wso2.carbon.registry.acidothinterface.soap2pcserver.main;

import org.wso2.carbon.registry.acidothinterface.registrationservie_wsdl.RegistrationService;
import registerparticipantresponse.RegisterParticipantResponse;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class RegistrationAsyncClient {

    RegistrationService registrationService;

    public RegistrationAsyncClient(RegistrationService registrationService){
        this.registrationService=registrationService;
    }

    class RegistrationCallback implements AsyncHandler<RegisterParticipantResponse> {

        private RegisterParticipantResponse output;
        public void handleResponse(Response<RegisterParticipantResponse> response) {
            try {
                output = response.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        RegisterParticipantResponse getResponse() {
            return output;
        }
    }


    public boolean register(String identifier,String serveraddr,int serverport, String protocolType) throws Exception {

        RegistrationCallback callbackHandler =
                new RegistrationCallback();
        Future<?> resp = registrationService.registerParticipantAsync(identifier, protocolType, serveraddr,serverport,callbackHandler);
        // For the purposes of a test, block until the async call completes
//        resp.get(5L, TimeUnit.MINUTES);
        while(!resp.isDone()){}

        return callbackHandler.getResponse().isReturn();
    }
}
