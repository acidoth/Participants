Participants
============
Contains Python and Java Participants used in the performance test.

WSO2 GREG:
Contains WSO2 Greg modules needed to run the performance test. 

Directories:
1. org.wso2.carbon.registry.acidothinterface
Contains 4 osgi bundles which functions as interface for 2pc calls. 
org.wso2.carbon.registry.acidothinterface, org.wso2.carbon.registry.acidothinterface_2 : Respcetively, Thrift interface for first and second participants. 
org.wso2.carbon.registry.acidothinterface_soap, org.wso2.carbon.registry.acidothinterface_soap_1 : Respectively, SOAP interface for first and second particiapnts.

2. org.wso2.carbon.registry.ws.api
Contains ws-api bundles for both particiapnts for put calls. 
4.0.4, 4.0.4_1 : Respcetively, ws-api interfaces for first and second participants. 
4.0.4_soap, 4.0.4_1_soap : Respectively, SOAP interface for first and second particiapnts.

3. org.wso2.carbon.registry.ws.client
Contains ws-client for travel application part.
4.0.2 : Contains ws-client bundle for travel application side.

4. org.wso2.carbon.registry.core
Contains registry core for all wso2 registry instances. 
4.0.5 : Contains updated registry core. 

Guidelines to use the components :
1. Download wso2 greg. (  http://dist2.wso2.org/products/governance-registry/4.5.3/wso2greg-4.5.3.zip )
2. Extract it into 4 separate folders. ( 2 for thrift and 2 for soap participants)
3. Using WSO2 greg documentation, configure backend database. 
4. Open acidothinterface bundles and configure the constants with ip addresses. 
5. Build the bundles in the same order given in the above descriptions. ( resolve necessary dependencies, you may need to configure system path of org.wso2.carbon.registry.acidothinterface bundles when building org.wso2.carbon.registry.ws.api bundles)
6. Rename org....somename-0.0.0.jar to org....somename_0.0.0.jar for built results for ws-api, ws-client, core bundles and copy them and paste into relavent greg folder's GREG_HOME/repository/components/plugins. ( you may need to replace existing bundles with same name). 
6. Copy acidothinterface into relavent greg folder's GREG_HOME/repository/components/dropins.


Now you may be able to use wso2greg participants.
