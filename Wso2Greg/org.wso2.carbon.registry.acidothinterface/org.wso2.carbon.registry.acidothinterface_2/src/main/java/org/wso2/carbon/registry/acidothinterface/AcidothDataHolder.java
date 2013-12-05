package org.wso2.carbon.registry.acidothinterface;

import org.apache.thrift.async.TAsyncClientManager;
import org.osgi.framework.BundleContext;


public class AcidothDataHolder {
    public static BundleContext bundleContext;
    public static TAsyncClientManager tAsyncClientManager;
}
