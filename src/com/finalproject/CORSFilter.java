package com.finalproject;

import java.io.IOException;
import javax.ws.rs.container.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class CORSFilter implements ContainerRequestFilter, ContainerResponseFilter {

	@Override
    public void filter(ContainerRequestContext request) throws IOException {

        // If it's a preflight request, we abort the request with
        // a 200 status, and the CORS headers are added in the
        // response filter method below.
        if (isPreflightRequest(request)) {
            request.abortWith(Response.ok().build());
            return;
        }
    }

    /**
     * A preflight request is an OPTIONS request
     * with an Origin header.
     */
    private static boolean isPreflightRequest(ContainerRequestContext request) {
        return request.getHeaderString("Origin") != null
                && request.getMethod().equalsIgnoreCase("OPTIONS");
    }
    
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		if(requestContext.getHeaderString("Origin") == null) {
			return;
		}
		
		if(isPreflightRequest(requestContext)) {
			responseContext.getHeaders().add("Access-Control-Allow-Headers", "*");
			responseContext.getHeaders().add("Access-Control-Allow-Methods", "*");
		}
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
	}
	
}	