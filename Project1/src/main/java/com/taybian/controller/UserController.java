package com.taybian.controller;
import java.lang.ProcessBuilder.Redirect;
import java.net.URI;
import java.net.URISyntaxException;

import javax.print.DocFlavor.URL;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


import com.revature.tay.Customer;
import com.revature.tay.Employee;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.revature.menu.Account;

@Path("/c")
public class UserController {
@Path("/create")
@POST
@Produces("text/html")
 public String createUser(@FormParam("name")String name,@FormParam("lastname")String lastname,
		 @FormParam("username")String username,@FormParam("password")String password,@FormParam("email")String email){
	 Customer c = new Customer();
	 c.setFirstname(name);
	 c.setLastname(lastname);
	 c.setUsername(username);
	 c.setPassword(password);
	 c.setPin(email);
	 System.out.println("Your name is: "+c.getFirstname()+" Your Username is: "+c.getUsername());
	 System.out.println("Created User Succesful");
	
	return "<html>" + "<head>" +"<title>" + "User Created Successful" + "</title>" + 
	  "</head>" +"<body><div><h5>" + "User Created Successful " +" please click the link below to login" + "</h5></div><div><a href=\"http://localhost:8080/Project1/HTML/login.html\">Login Here:</a></div></body>" + "</html>";
}
@Path("/login")
@POST
@Produces("text/html")
public String login(@FormParam("username")String username,@FormParam("password")String password) throws URISyntaxException {

	 Customer c = new Customer();
	  if(c.getUsername().equals(username)&&c.getPassword().equals(password))
	  {  System.out.println("Creditials Match!");
	  return  "<html>" + "<head>" +"<title>" + "Login Successful" + "</title>" + 
	  "</head>" +"<body><div><h5>" + "Login Successful " +"Welcome " + username + " please click the link below to continue" + "</h5></div><a href=\"http://localhost:8080/Project1/HTML/Accoun.html\">View Account Here:</a><div></div></body>" + "</html>";
	  }
	  else {
		  System.out.println("Login incorrect! Please try again");
		 return "<html>" + "<head>" +"<title>" + "Login Successful" + "</title>" + 
		  "</head>" +"<body><div><h5>" + "Login Username and Password Incorrect " +" please click the link below to try again" + "</h5></div><div><a href=\"http://localhost:8080/Project1/HTML/login.html\">Try Again:</a></div></body>" + "</html>";
	  }
}
@Path("/d")
@POST
@Produces(MediaType.APPLICATION_JSON)
public Response Accountupdate(){
	Account a = new Account();
	//a.setAccountbalance(500);
	//a.setAccountid(12321);
	System.out.println("Account Updated!");
	return Response.status(200).entity(a.getAccountbalance()).build();
	   
}
@Path("/deposit")
@POST
@Produces(MediaType.TEXT_PLAIN)
 public double  Deposit(@FormParam("Amount")double deposit) {
 
	Account a = new Account();
	System.out.println(deposit);
	a.setAccountbalance(a.getAccountbalance()+deposit);
	System.out.println(a.getAccountbalance());
	System.out.println("This works but gotta get back to main page");
	return a.getAccountbalance();
	
}
@Path("/withdraw")
@POST
@Produces(MediaType.TEXT_PLAIN)
 public double  Withdraw(@FormParam("Amount")double withdraw) {
 
	Account a = new Account();
	System.out.println(withdraw);
	a.setAccountbalance(a.getAccountbalance()-withdraw);
	System.out.println(a.getAccountbalance());
	System.out.println("This works but gotta get back to main page");
	return a.getAccountbalance();
}
@Path("/alogin")
@POST
@Produces("text/html")
  public String Alogin(@FormParam("username")String username,@FormParam("password")String password) {
	Employee e = new Employee();
	if(Employee.getUsername().equals(username)&&e.getPassword().equals(password)) {
		 return  "<html>" + "<head>" +"<title>" + "Login Successful" + "</title>" + 
				  "</head>" +"<body><div><h5>" + "Login Successful " +"Welcome " + username + " please click the link below to continue" + "</h5></div><a href=\"http://localhost:8080/Project1/HTML/AdminPage.html\">View Account Here:</a><div></div></body>" + "</html>";
	}else {
		return "<html>" + "<head>" +"<title>" + "Login Successful" + "</title>" + 
				  "</head>" +"<body><div><h5>" + "Login Username and Password Incorrect " +" please click the link below to try again" + "</h5></div><div><a href=\"http://localhost:8080/Project1/HTML/Adminlogin.html\">Try Again:</a></div></body>" + "</html>";
			  }
	}
@Path("/info")
@POST
@Produces(MediaType.APPLICATION_JSON)
public Response Accountupdate2(){
	Account a = new Account();
	Customer c = new Customer();
	//a.setAccountbalance(500);
	//a.setAccountid(12321);
	System.out.println("Account Displayed!");
	return Response.status(200).entity(c.toString()+" and "+a.toString()).build();
	   
}


}

	
		

