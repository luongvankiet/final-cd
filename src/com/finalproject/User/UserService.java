package com.finalproject.User;

import java.util.*;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

import com.finalproject.Auth.PasswordEncryptor;
import com.finalproject.Role.Role;
import com.finalproject.Role.RoleDAO;

@Path("secured")
public class UserService {
	private UserDAO uDao = new UserDAO();
	private RoleDAO rDao = new RoleDAO();
	
	@GET
	@Path("/users")
	@RolesAllowed({"staff", "admin"})
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getAllUsers() {
		List<User> uList = uDao.getAllUser();
		if(uList.size() > 0)
			return Response.status(Status.OK.getStatusCode()).entity(uList).build();
		return Response.status(Status.NOT_FOUND.getStatusCode()).entity("User list is empty").build();
	}
	
	@GET
	@RolesAllowed({"admin"})
	@Path("/users/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Role> getRoleByUserID(@PathParam("id") int id) {
		return rDao.getRoleByUserId(id);
	}
	
	@RolesAllowed({"staff", "admin"})
	@GET
	@Path("/test")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<String> test() throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		String admin = "admin";
		String user = "user";
		String encode = PasswordEncryptor.encrypt(admin);
		String decode = PasswordEncryptor.decrypt(encode);

		String encodeUser = PasswordEncryptor.encrypt(user);
		String decodeUSer = PasswordEncryptor.decrypt(encode);
		
		list.add(admin);
		list.add(encode);
		list.add(decode);
		
		list.add(user);
		list.add(encodeUser);
		list.add(decodeUSer);
		return list;
	}
}
