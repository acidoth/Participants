package server.coordination;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.registry.acidothinterface.Acidoth2PCHandler;
import org.wso2.carbon.registry.acidothinterface.soap2pcserver.util.ServiceResponse;

import javax.jws.WebService;


@WebService(endpointInterface = "server.coordination.CoordinationService")
public class CoordinationServiceImpl implements CoordinationService {
    private Log log= LogFactory.getLog(CoordinationServiceImpl.class);
    @Override
    public ServiceResponse.serviceResponse commit(String txIdentifier) {

        log.info("commit called "+txIdentifier);
        Acidoth2PCHandler acidoth2PCHandler=Acidoth2PCHandler.getInstance();
        boolean result=acidoth2PCHandler.commit(txIdentifier);
        if(result==true){
            log.info("Transaction " + txIdentifier + " Successfully Commited");
            return ServiceResponse.serviceResponse.committed;  //To change body of implemented methods use File | Settings | File Templates.
        }

        else return ServiceResponse.serviceResponse.aborted;
    }

    @Override
    public ServiceResponse.serviceResponse rollback(String txIdentifier) {

        Acidoth2PCHandler acidoth2PCHandler=Acidoth2PCHandler.getInstance();
        log.info("Rollback Called "+txIdentifier);
        boolean result=acidoth2PCHandler.rollback(txIdentifier);
        if(result==true){

            log.info("Transaction " + txIdentifier + " Successfully Rolled back");
            return ServiceResponse.serviceResponse.aborted;
        }
        else return ServiceResponse.serviceResponse.aborted;

    }

    @Override
    public ServiceResponse.serviceResponse prepare(String txIdentfier) {

        log.info("prepare called "+txIdentfier);
        Acidoth2PCHandler acidoth2PCHandler=Acidoth2PCHandler.getInstance();
        boolean result=acidoth2PCHandler.prepare(txIdentfier);
        if(result==true){
            log.info("Transaction " + txIdentfier + " Successfully Prepared");
            return ServiceResponse.serviceResponse.prepared;
        }
        return ServiceResponse.serviceResponse.aborted;
    }

    @Override
    public ServiceResponse.serviceResponse abort(String txIdentifier) {
        Acidoth2PCHandler acidoth2PCHandler=Acidoth2PCHandler.getInstance();
        log.info("Transaction " + txIdentifier + " Successfully Aborted");
        return ServiceResponse.serviceResponse.aborted;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
