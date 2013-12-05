package org.wso2.carbon.registry.acidothinterface.coordinationserver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.wso2.carbon.registry.acidothinterface.thriftgen.coordination.CoordinationService;


public class CoordinationServer {
    private Log log= LogFactory.getLog(CoordinationServer.class);
    public void startServer(int port){

        CoordinationService.Processor<CoordinationServerHandler> processor = new CoordinationService.Processor<CoordinationServerHandler>(new CoordinationServerHandler());

        try {
            TNonblockingServerTransport tNonblockingServerTransport = new TNonblockingServerSocket(port);
            TServer server = new TNonblockingServer(new TNonblockingServer.Args(tNonblockingServerTransport).processor(processor));

            log.info("Starting Thrift Completion Server");
            server.serve();

        } catch (TTransportException e) {
            log.info("Could not create Thrift Server");
        }
    }
}
