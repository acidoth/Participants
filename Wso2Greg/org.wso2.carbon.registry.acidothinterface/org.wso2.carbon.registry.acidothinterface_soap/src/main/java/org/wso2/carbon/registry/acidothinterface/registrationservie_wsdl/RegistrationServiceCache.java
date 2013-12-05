package org.wso2.carbon.registry.acidothinterface.registrationservie_wsdl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;


public class RegistrationServiceCache {

    private static final int CACHE_MAX_SIZE = 100;
    private static LinkedHashMap<String, RegistrationService> registrationServiceCache;

    public RegistrationServiceCache(){

        registrationServiceCache = new LinkedHashMap<String, RegistrationService>(CACHE_MAX_SIZE, 0.75f, true){
            protected boolean removeEldestEntry(
                    Map.Entry<String, RegistrationService> eldest) {
                // Remove the eldest entry if the size of the cache exceeds the
                // maximum size
                return size() > CACHE_MAX_SIZE;
            }
        };
    }

    public RegistrationService getRegistrationServicePort(String address){

        RegistrationService registrationService = registrationServiceCache.get(address);

        if(registrationService != null){
            return registrationService;
        }
        else {
            registrationService = createRegistrationServicePort(address);
            registrationServiceCache.put(address, registrationService);
            return registrationService;
        }
    }

    private RegistrationService createRegistrationServicePort(String address){

        RegistrationServiceImplService service = null;
        try {
            service = new RegistrationServiceImplService(new URL(address));
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        RegistrationService registrationService = service.getRegistrationServiceImplPort();

        return registrationService;
    }
}
