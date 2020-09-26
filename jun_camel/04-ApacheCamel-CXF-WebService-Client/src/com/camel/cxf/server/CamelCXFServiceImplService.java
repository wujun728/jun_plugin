package com.camel.cxf.server;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2018-01-02T10:41:25.357+08:00
 * Generated source version: 3.1.7
 * 
 */
@WebServiceClient(name = "CamelCXFServiceImplService", 
                  wsdlLocation = "http://localhost:8088/CamelCXFService/queryService?wsdl",
                  targetNamespace = "http://server.cxf.camel.com/")// 为何这里不用改为http://server.webservice.camel.com/ ？随便写都可以的饿吗
public class CamelCXFServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://server.webservice.camel.com/", "CamelCXFServiceImplService");// 为何不是 http://server.cxf.camel.com/   javax.xml.ws.WebServiceException: {http://server.cxf.camel.com/}CamelCXFServiceImplService不是有效服务。有效服务为: {http://server.webservice.camel.com/}CamelCXFServiceImplService
    public final static QName CamelCXFServiceImplPort = new QName("http://server.webservice.camel.com/", "CamelCXFServiceImplPort");// 为何不是 http://server.cxf.camel.com/  javax.xml.ws.WebServiceException: {http://server.cxf.camel.com/}CamelCXFServiceImplPort 不是有效端口。有效端口为: {http://server.webservice.camel.com/}CamelCXFServiceImplPort
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8088/CamelCXFService/queryService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CamelCXFServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8088/CamelCXFService/queryService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CamelCXFServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CamelCXFServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CamelCXFServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public CamelCXFServiceImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CamelCXFServiceImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CamelCXFServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns CamelCXFServiceInter
     */
    @WebEndpoint(name = "CamelCXFServiceImplPort")
    public CamelCXFServiceInter getCamelCXFServiceImplPort() {
        return super.getPort(CamelCXFServiceImplPort, CamelCXFServiceInter.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CamelCXFServiceInter
     */
    @WebEndpoint(name = "CamelCXFServiceImplPort")
    public CamelCXFServiceInter getCamelCXFServiceImplPort(WebServiceFeature... features) {
        return super.getPort(CamelCXFServiceImplPort, CamelCXFServiceInter.class, features);
    }

}
