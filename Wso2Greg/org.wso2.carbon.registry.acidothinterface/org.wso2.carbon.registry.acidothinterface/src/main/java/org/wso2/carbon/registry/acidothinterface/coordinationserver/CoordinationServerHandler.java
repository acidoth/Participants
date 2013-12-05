package org.wso2.carbon.registry.acidothinterface.coordinationserver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.thrift.TException;
import org.wso2.carbon.registry.acidothinterface.Acidoth2PCHandler;
import org.wso2.carbon.registry.acidothinterface.thriftgen.coordination.CoordinationService;
import org.wso2.carbon.registry.acidothinterface.thriftgen.coordination.ServiceResponse;

public class CoordinationServerHandler implements CoordinationService.Iface{
    private static int count = 0;
    private Log log= LogFactory.getLog(CoordinationServerHandler.class);

    @Override
    public ServiceResponse commit(String identifier, boolean isOnePhase) throws TException {
        log.info("Commit calling ..................." +identifier);
        boolean result=false;
        Acidoth2PCHandler acidoth2PCHandler=Acidoth2PCHandler.getInstance();
        if(isOnePhase){
            this.prepare(identifier);
        }
        result=acidoth2PCHandler.commit(identifier);

        if(result==true){

            log.info("Transaction " + identifier + " Successfully Commited");
            return ServiceResponse.commited;  //To change body of implemented methods use File | Settings | File Templates.
        }

        else return ServiceResponse.aborted;


    }

    @Override
    public ServiceResponse abort(String identifier) throws TException {

        Acidoth2PCHandler acidoth2PCHandler=Acidoth2PCHandler.getInstance();
        log.info("Transaction " + identifier + " Successfully Aborted");
        return ServiceResponse.aborted;
    }

    @Override
    public ServiceResponse rollback(String identifier) throws TException {

        Acidoth2PCHandler acidoth2PCHandler=Acidoth2PCHandler.getInstance();
        log.info("Transaction " + identifier + " Successfully Rolled back");
        boolean result=acidoth2PCHandler.rollback(identifier);
        if(result==true){
            return ServiceResponse.aborted;
        }
        else return ServiceResponse.aborted;
    }

    @Override
    public ServiceResponse prepare(String identifier) throws TException {
        log.info("Prepare caling..........................."+identifier);
        Acidoth2PCHandler acidoth2PCHandler=Acidoth2PCHandler.getInstance();
        boolean result=acidoth2PCHandler.prepare(identifier);
        if(result==true){
            log.info("Transaction " + identifier + " Successfully Prepared");
            return ServiceResponse.prepared;
        }
        else
            return ServiceResponse.aborted;

    }
}
