package com.alex.vis.soapwebsocket.api.endpoint;

import com.alex.vis.soapwebsocket.api.greeting.GetGreetingRequest;
import com.alex.vis.soapwebsocket.api.greeting.GetGreetingResponse;
import com.alex.vis.soapwebsocket.api.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;

@Endpoint
public class GreetingEndpoint {
    private static final String NAMESPACE_URI = "http://com/alex/vis/soapwebsocket/api/greeting";

    private GreetingService greetingService;

    @Autowired
    public GreetingEndpoint(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    //This is like alternative for controller in REST. Our request will be coming here? couse this is @endpoint
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGreetingRequest")
    @ResponsePayload
    public GetGreetingResponse getGreeting(@RequestPayload GetGreetingRequest request) throws DatatypeConfigurationException {
        GetGreetingResponse response = new GetGreetingResponse();
        response.setGreeting(greetingService.generateGreeting(request.getName()));
        return response;
    }
}
