package com.finalproject.Auth;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

import com.finalproject.Auth.Auth;
import com.finalproject.Message.Message;
import com.finalproject.User.User;

@Path("auth")
public class AuthService {
	private Auth auth = new Auth();
	@POST
	@Path("login")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.MULTIPART_FORM_DATA, MediaType.APPLICATION_JSON})
	public Response login(User user){
		User u = auth.login(user.getUsername(), user.getPassword());
		Message<User> m;
		if(u != null) {
			m = new Message<User>("Login success", u);
			return Response.status(Status.OK.getStatusCode()).entity(m).build();
		}
		m = new Message<User>("Username or password doesn\'t exist", u);
		return Response.status(Status.UNAUTHORIZED.getStatusCode()).entity(m).build();
	}
}
