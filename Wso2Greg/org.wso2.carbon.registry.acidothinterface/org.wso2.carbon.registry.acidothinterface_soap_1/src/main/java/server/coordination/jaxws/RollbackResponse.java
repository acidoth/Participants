
package server.coordination.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "rollbackResponse", namespace = "http://coordination.server/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "rollbackResponse")
public class RollbackResponse {

    @XmlElement(name = "return", namespace = "")
    private org.wso2.carbon.registry.acidothinterface.soap2pcserver.util.ServiceResponse.serviceResponse _return;

    /**
     * 
     * @return
     *     returns serviceResponse
     */
    public org.wso2.carbon.registry.acidothinterface.soap2pcserver.util.ServiceResponse.serviceResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(org.wso2.carbon.registry.acidothinterface.soap2pcserver.util.ServiceResponse.serviceResponse _return) {
        this._return = _return;
    }

}
