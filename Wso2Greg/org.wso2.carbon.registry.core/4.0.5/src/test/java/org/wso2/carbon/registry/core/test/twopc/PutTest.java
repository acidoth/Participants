package org.wso2.carbon.registry.core.test.twopc;

import org.wso2.carbon.registry.core.Registry;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.jdbc.EmbeddedRegistryService;
import org.wso2.carbon.registry.core.test.utils.BaseTestCase;
import org.wso2.carbon.user.api.RealmConfiguration;


public class PutTest extends BaseTestCase {
    protected static EmbeddedRegistryService embeddedRegistryService = null;
    protected static Registry registry = null;


    public void setUp() {
        super.setUp();
        if (embeddedRegistryService != null) {
            return;
        }
        try {
            embeddedRegistryService = ctx.getEmbeddedRegistryService();
            RealmUnawareRegistryCoreServiceComponent comp =
                    new RealmUnawareRegistryCoreServiceComponent();
            comp.setRealmService(ctx.getRealmService());
            comp.registerBuiltInHandlers(embeddedRegistryService);

            // get the realm config to retrieve admin username, password
            RealmConfiguration realmConfig = ctx.getRealmService().getBootstrapRealmConfiguration();
            registry = embeddedRegistryService.getUserRegistry(
                    realmConfig.getAdminUserName(), realmConfig.getAdminPassword());
        } catch (RegistryException e) {
            fail("Failed to initialize the registry. Caused by: " + e.getMessage());
        }
    }



    public void testPrepareAndCommitTest() throws RegistryException {
        Resource r2=registry.newResource();
        r2.setContent("x");
        registry.put("/prepareandcommit",r2,"prepareandcommit1");
        registry.prepare("prepareandcommit1");
        registry.commit("prepareandcommit1");
        boolean failed = false;
        try {
            registry.get("/prepareandcommit");
        } catch (RegistryException e) {
            failed = true;
        }
        assertFalse("Resource is sucessfully commited to database.", failed);
    }

    public void testPrepareFailureTest() throws RegistryException{
        boolean failed = false;
        try {
            registry.prepare("preparefailure");
        } catch (NullPointerException e) {
            failed = true;
        }
        assertFalse("Prepare failed because of no put operation done", failed);
    }

    public void testCommitFailure() throws RegistryException{
        boolean failed = false;
        try {
            registry.commit("commitfailure");
        } catch (NullPointerException e) {
            failed = true;
        }
        assertTrue("Commit failed because of no put operation done", failed);
    }


    public void testTwoPcPutTest() throws RegistryException {
        Resource r1=registry.newResource();
        r1.setProperty("test", "2pcput");
        r1.setContent("x");
        String result=registry.put("/test/test/2pcput",r1,"2pcputid");
        assertEquals("/beep/test/test/2pcput",result);

        //assertTrue("Put failed",failed);   /////
    }


}
