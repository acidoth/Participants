package org.wso2.carbon.registry.acidothinterface;

import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.wso2.carbon.registry.core.RegistryConstants;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.config.RegistryContext;
import org.wso2.carbon.registry.core.jdbc.EmbeddedRegistryService;
import org.wso2.carbon.registry.core.session.UserRegistry;
import org.wso2.carbon.user.core.service.RealmService;

import java.io.FileInputStream;
import java.io.InputStream;


public class Test {
    private static final org.apache.commons.logging.Log log = LogFactory.getLog(Test.class);

    public static BundleContext bundleContext;
    private Object realmServiceObj;
    private RealmService realmService;
    private ServiceReference serviceReference;

    public void setBundleContext(BundleContext bundleContext){
        this.bundleContext=bundleContext;
    }


    public void test() throws Exception {
        log.warn("test started ...........................................................................");

       // realmService=new DefaultRealmService(bundleContext);


       ServiceTracker tracker =new ServiceTracker(bundleContext,RealmService.class.getName(), null);
       tracker.open();
       realmService=(RealmService)tracker.getService();
       tracker.close();

        //realmService=(DefaultRealmService)bundleContext.getService(serviceReference);
        InputStream configStream = new FileInputStream("/Users/admin/Hareesh/fyp/wso2greg-4.5.3/repository/conf/registry.xml");
        RegistryContext registryContext = RegistryContext.getBaseInstance(configStream,realmService);
        registryContext.setSetup(System.getProperty(RegistryConstants.SETUP_PROPERTY) != null);
        EmbeddedRegistryService acidothRegistryService = new EmbeddedRegistryService(registryContext);
        EmbeddedRegistryService acidothRegistryService1 = new EmbeddedRegistryService(registryContext);
        UserRegistry acidothRegistry=acidothRegistryService.getSystemRegistry();
        UserRegistry acidothRegistry1=acidothRegistryService1.getSystemRegistry();


        log.warn("Testing..................................................................................");

        try {



            Resource resource=acidothRegistry.newResource();
            resource.setContent("Hareesh1");
            resource.setMediaType("File");
            resource.setProperty("Hareesh1", "hareesh1");

            acidothRegistry.put("/Users/admin/Documents/hari-mac.pem", resource, "test1");
            //boolean a1=acidothRegistry.prepare("test1");




            log.warn("test1 done ...........................................................................");

            Resource resource1=acidothRegistry1.newResource();
            resource1.setContent("Hareesh2");
            resource1.setMediaType("File2");
            resource1.setProperty("Hareesh2", "hareesh2");
            acidothRegistry1.put("/Users/admin/Documents/090171E_cv.docx", resource1, "test2");

            boolean a3=acidothRegistry1.prepare("test2");

            boolean a4=acidothRegistry1.commit("test2");


            //boolean a2=acidothRegistry.commit("test1");
            //boolean a2=acidothRegistry.rollback("test1");
            log.warn("test2 done"+a3+" "+a4+" "+""+" "+""+" ............................................................................");

            //log.warn(a1+" "+" "+a3);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        log.warn("test DONE :D");
    }

}
