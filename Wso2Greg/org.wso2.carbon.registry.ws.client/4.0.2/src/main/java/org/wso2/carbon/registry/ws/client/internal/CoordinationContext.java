package org.wso2.carbon.registry.ws.client.internal;

/**
 * Coordination Context object to hold values of Coordination Context created from Coordinator
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
