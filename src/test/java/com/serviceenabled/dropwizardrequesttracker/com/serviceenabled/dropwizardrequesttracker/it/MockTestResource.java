package com.serviceenabled.dropwizardrequesttracker.com.serviceenabled.dropwizardrequesttracker.it;

import com.serviceenabled.dropwizardrequesttracker.RequestTrackerConstants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import java.net.URI;

import static org.mockito.Mockito.mock;

/**
 * Created by rmuhic on 11/11/2014.
 */
@Path("/mock-test")
public class MockTestResource {
    private String logId;

    public void setLogId(String id){
        this.logId = id;
    }

    public String getLogId(){
        return logId;
    }

    @POST
    public void test(@Context HttpHeaders headers){
        logId = headers.getRequestHeader(RequestTrackerConstants.LOG_ID_HEADER).get(0);
    }
}
