package org.wso2.carbon.registry.acidothinterface.main;

import org.wso2.carbon.registry.acidothinterface.Util.Constants;
import org.wso2.carbon.registry.acidothinterface.coordinationserver.CoordinationServer;

public class ParticipantServer {

    public  void runParticipantServer()  {

        final CoordinationServer server2PC = new CoordinationServer();


        new Thread(new Runnable() {
            @Override
            public void run() {
                server2PC.startServer(Constants.coordinationPort);
            }
        }).start();

    }
}
