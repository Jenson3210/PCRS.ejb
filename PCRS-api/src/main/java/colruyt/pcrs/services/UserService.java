package colruyt.pcrs.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import colruyt.pcrs.security.TokenFacade;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("users")
public class UserService {

	@EJB
	private IUserFacade userFacade;
	
	@EJB
	private TokenFacade tokenFacade;

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
			if(userId == null) {
				UserBo userbo = new UserBo();
				
				userbo.setId(userId);
				try {
					userbo = this.userFacade.get(userbo);
					users.add(userbo);
					resp = Response.status(Response.Status.OK).entity(users).build();
					
				} catch (ValidationException e) {
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
		
		UserBo bo = new UserBo();
		bo.setEmail(email);
		bo.setPassword(password);
		
		return Response.ok().header("AUTHORIZATION", "Bearer " + tokenFacade.issueToken(bo)).build();
		
	}

} 
