package colruyt.pcrs.services;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.KeyGenerator;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import colruyt.pcrs.security.JWTTokenNeeded;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.security.ITokenFacade;
import colruyt.pcrsejb.util.exceptions.NoExistingEmailException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("users")
public class UserService {

	@EJB
	private IUserFacade userFacade;
	
	@EJB
	private ITokenFacade tokenFacade;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Find all users", notes = "Retrieve all users", response = User[].class, responseContainer = "List")
	@ApiResponses({ 
			@ApiResponse(code = 200, message = "Users found", response = User[].class),
			@ApiResponse(code = 404, message = "Users not found"),
			@ApiResponse(code = 403, message = "Provided password incorrect")})
	
	public Response allUsersGet(
			@ApiParam(value = "id of the user", required = false) @QueryParam("id") Integer userId,
			@ApiParam(value = "Email of the user", required = false) @QueryParam("email") String email, 
			@ApiParam(value = "Password of the user", required = false) @QueryParam("password") String password) {
		
		List<UserBo> users = new ArrayList<>();
		
		Response resp = Response.status(Response.Status.FORBIDDEN).entity("Password & E-mail is must be filled in!").build();
		
		if (userId == null && email != null && password != null) {
			try {
				UserBo userbo = this.userFacade.login(email, password);
				users.add(userbo);
				resp = Response.status(Response.Status.OK).entity(users).build();
			}
			catch(Exception e) {
				resp = Response.status(Response.Status.FORBIDDEN)
						.entity("Wrong password!")
						.build();
			}
		}
		else {
			if(userId != null) {
				UserBo userBo = new UserBo();
				
				userBo.setId(Integer.valueOf(userId));
				try {
					userBo = this.userFacade.get(userBo);
					users.add(userBo);
					resp = Response.status(Response.Status.OK).header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenFacade.issueToken(users.get(0),this.generateToken(users.get(0).getEmail())).getToken()).entity(users).build();
					
				} catch (ValidationException e) {
					System.out.println(e.getMessage());
					resp = Response.status(Response.Status.FORBIDDEN)
							.entity(e.getMessage())
							.build();
				}
				
				
			}
			
		}
		return resp;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("token")
	public Response getTokenTest(@QueryParam("email") String email, @QueryParam("password") String password){
		
		UserBo bo = null;
		
		try {
			bo = this.userFacade.getUserByEmail(email);
		} catch (NoExistingEmailException e) {
	
			e.printStackTrace(); 
		}
		return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenFacade.issueToken(bo,this.generateToken(bo.getEmail())).getToken()).build();
		
		
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("me")
	@JWTTokenNeeded
	public Response getTokenTest(@Context HttpHeaders request){
		
		List<String> authHeaders = request.getRequestHeader(HttpHeaders.AUTHORIZATION);
		String token = authHeaders.get(0).substring("Bearer".length()).trim();
		
		return Response.ok().entity(this.tokenFacade.getUserByToken(token)).build();
		
	}
	
	
	private String generateToken(String user) {
		KeyGenerator keyGenerator = null;
		
	
		try {
			keyGenerator = KeyGenerator.getInstance("HmacSHA256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  Key key = keyGenerator.generateKey();
	  String jwtToken = Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date((LocalDateTime.now().plusMinutes(60).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli())))
                .signWith(key)
                .compact();
	  
       return jwtToken; 

} 
	
}
