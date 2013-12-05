package org.wso2.carbon.registry.acidothinterface;

import org.apache.thrift.async.TAsyncClientManager;
import org.osgi.framework.BundleContext;
import org.wso2.carbon.user.core.service.RealmService;

public class AcidothDataHolder {
    public static BundleContext bundleContext;
    public static RealmService realmService;
    public static TAsyncClientManager tAsyncClientManager;
}
