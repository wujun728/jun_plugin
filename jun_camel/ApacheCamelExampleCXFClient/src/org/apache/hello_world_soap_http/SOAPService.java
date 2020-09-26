package org.apache.hello_world_soap_http;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2018-01-03T09:40:01.259+08:00
 * Generated source version: 3.1.7
 * 
 */
@WebServiceClient(name = "SOAPService", 
                  wsdlLocation = "http://localhost:9001/SoapContext/SoapPort?wsdl",
                  targetNamespace = "http://apache.org/hello_world_soap_http") 
public class SOAPService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://apache.org/hello_world_soap_http", "SOAPService");
    public final static QName SoapOverHttp = new QName("http://apache.org/hello_world_soap_http", "SoapOverHttp");
    public final static QName SoapOverHttpRouter = new QName("http://apache.org/hello_world_soap_http", "SoapOverHttpRouter");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:9001/SoapContext/SoapPort?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(SOAPService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:9001/SoapContext/SoapPort?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public SOAPService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SOAPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SOAPService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public SOAPService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public SOAPService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public SOAPService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns Greeter
     */
    @WebEndpoint(name = "SoapOverHttp")
    public Greeter getSoapOverHttp() {
        return super.getPort(SoapOverHttp, Greeter.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Greeter
     */
    @WebEndpoint(name = "SoapOverHttp")
    public Greeter getSoapOverHttp(WebServiceFeature... features) {
        return super.getPort(SoapOverHttp, Greeter.class, features);
    }


    /**
     *
     * @return
     *     returns Greeter
     */
    @WebEndpoint(name = "SoapOverHttpRouter")
    public Greeter getSoapOverHttpRouter() {
        return super.getPort(SoapOverHttpRouter, Greeter.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Greeter
     */
    @WebEndpoint(name = "SoapOverHttpRouter")
    public Greeter getSoapOverHttpRouter(WebServiceFeature... features) {
        return super.getPort(SoapOverHttpRouter, Greeter.class, features);
    }

}
