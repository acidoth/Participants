package org.wso2.carbon.registry.acidothinterface;


import org.apache.commons.logging.LogFactory;
import org.apache.thrift.async.TAsyncClientManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.wso2.carbon.registry.acidothinterface.main.ParticipantServer;


public class AcidothActivator implements BundleActivator {

    private static final org.apache.commons.logging.Log log = LogFactory.getLog(AcidothActivator.class);

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public void start( BundleContext bundleContext) throws Exception {
        //log.warn("test");

        Thread thread=new Thread(thriftserver);
        thread.start();

        AcidothDataHolder.bundleContext=bundleContext;

        AcidothDataHolder.tAsyncClientManager=new TAsyncClientManager();
    }
    Runnable thriftserver=new Runnable() {
        @Override
        public void run() {
            ParticipantServer participantXAServer=new ParticipantServer();
            participantXAServer.runParticipantServer();
        }
    };
}


