package org.wso2.carbon.registry.ws.api.utils;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 11/19/2013
 * Time: 8:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class CoordinationContext {
    private String identifier;
    private String endpointreference;
    private String coordinationType;
    private int port;
    private int expires;

    public CoordinationContext(String identifier,String endpointreference,String coordinationType,int port,int expires){
        this.coordinationType=coordinationType;
        this.identifier=identifier;
        this.endpointreference=endpointreference;
        this.port=port;
        this.expires=expires;
    }
    public String getIdentifier(){
        return this.identifier;
    }
    public String getEndpointreference(){
        return this.endpointreference;
    }
    public String getCoordinationType(){
        return this.coordinationType;
    }
    public int getPort(){
        return this.port;
    }
    public int getExpires(){
        return this.expires;
    }

}
