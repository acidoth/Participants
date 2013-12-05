package org.wso2.carbon.registry.acidothinterface;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.config.RegistryContext;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.jdbc.EmbeddedRegistryService;
import org.wso2.carbon.registry.core.service.RegistryService;
import org.wso2.carbon.registry.core.session.UserRegistry;

import java.io.InputStream;

public class Acidoth2PCHandler {
    private BundleContext bundleContext;
    private RegistryService registryService;
    private RegistryContext registryContext;
    private EmbeddedRegistryService acidothRegistryService;
    private UserRegistry acidothRegistry;
    private static Acidoth2PCHandler instance=new Acidoth2PCHandler();
    private static int count=0;

    private Acidoth2PCHandler(){

    }

    public void init()  {
        bundleContext=AcidothDataHolder.bundleContext;
        ServiceTracker tracker =new ServiceTracker(bundleContext,RegistryService.class.getName(), null);
        tracker.open();
        registryService=(RegistryService)tracker.getService();
        tracker.close();

        InputStream configStream = null;
        try {
/*

           // configStream = new FileInputStream("/home/wso2test/acidoth/wso2greg-4.5.3/repository/conf/registry.xml");
            configStream = new FileInputStream("/Users/admin/Hareesh/fyp/wso2greg-4.5.3/repository/conf/registry.xml");

            //configStream = new FileInputStream("/home/wso2test/acidoth/wso2greg-4.5.3/repository/conf/registry.xml");
            registryContext= RegistryContext.getBaseInstance(configStream,realmService);
            registryContext.setSetup(System.getProperty(RegistryConstants.SETUP_PROPERTY) != null);
            acidothRegistryService=new EmbeddedRegistryService(registryContext);
*/

            acidothRegistry=registryService.getSystemRegistry();
        }  catch (RegistryException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public String put( Resource resource,String path,String transactionId) throws RegistryException {
        return  acidothRegistry.put(path,resource,transactionId);
    }
    public boolean prepare(String transactionId) {
        boolean result=false;
        try {
            result= acidothRegistry.prepare(transactionId);
        } catch (RegistryException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return result;
    }


    public boolean commit(String transactionId){
        return acidothRegistry.commit(transactionId);
    }


    public boolean rollback(String transactionId){
        return acidothRegistry.rollback(transactionId);
    }

    public static Acidoth2PCHandler getInstance() {
        if(count<1){
            instance.init();
        }
        count++;
        return instance;
    }

    public UserRegistry getUserRegistry(){
        return acidothRegistry;
    }
}
