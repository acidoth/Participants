package server.coordination;

import org.wso2.carbon.registry.acidothinterface.soap2pcserver.util.ServiceResponse;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created with IntelliJ IDEA.
 * User: pirinthapan
 * Date: 8/14/13
 * Time: 9:25 PM
 * To change this template use File | Settings | File Templates.
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL )
public interface CoordinationService {

    @WebMethod
    ServiceResponse.serviceResponse commit(String txIdentifier);

    @WebMethod
    ServiceResponse.serviceResponse rollback(String txIdentifier);

    @WebMethod
    ServiceResponse.serviceResponse prepare(String txIdentfier);

    @WebMethod
    ServiceResponse.serviceResponse abort(String txIdentifier);


}
