package org.wso2.carbon.registry.acidothinterface.soap2pcserver.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.registry.acidothinterface.soap2pcserver.util.Constants;
import server.coordination.CoordinationServiceImpl;

import javax.xml.ws.Endpoint;

public class SoapMain {
    private Log log= LogFactory.getLog(SoapMain.class);
    public void main(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                Endpoint.publish(Constants.coordinationServiceAddress, new CoordinationServiceImpl());
                log.info("SOAP 2PC Service Started");
            }
        }).start();

    }
}
