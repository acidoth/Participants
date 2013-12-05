
package registration;

import registerparticipant.RegisterParticipant;
import registerparticipantresponse.RegisterParticipantResponse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the server.registration package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RegisterParticipantResponse_QNAME = new QName("http://registration.server/", "registerParticipantResponse");
    private final static QName _RegisterParticipant_QNAME = new QName("http://registration.server/", "registerParticipant");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: server.registration
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link RegisterParticipantResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://registration.server/", name = "registerParticipantResponse")
    public JAXBElement<RegisterParticipantResponse> createRegisterParticipantResponse(RegisterParticipantResponse value) {
        return new JAXBElement<RegisterParticipantResponse>(_RegisterParticipantResponse_QNAME, RegisterParticipantResponse.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link RegisterParticipant }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://registration.server/", name = "registerParticipant")
    public JAXBElement<RegisterParticipant> createRegisterParticipant(RegisterParticipant value) {
        return new JAXBElement<RegisterParticipant>(_RegisterParticipant_QNAME, RegisterParticipant.class, null, value);
    }

}
