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
import javax.ws.rs.core.Response.StatusType;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.facade.user.IUserFacade;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("users")
public class UserService {

	@EJB
	private IUserFacade userFacade;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Find all users", notes = "Retrieve all users", response = User[].class, responseContainer = "List")
	@ApiResponses({ 
			@ApiResponse(code = 200, message = "Users found", response = User[].class),
			@ApiResponse(code = 404, message = "Users not found"),
			@ApiResponse(code = 403, message = "Provided password incorrect")})
	public Response allUsersGet(
			@ApiParam(value = "Email of the user", required = false) @QueryParam("email") String email, 
			@ApiParam(value = "Password of the user", required = false) @QueryParam("password") String password) {
		
		List<UserBo> users = new ArrayList<>();
		
		if (email != null && password != null) {
			//TODO MOVE TO BL
			try {				
				UserBo userbo = this.userFacade.login(email, password);
				return Response.status(Response.Status.OK).entity(userbo).build();
			}
			catch(Exception e) {
				return Response.status(Response.Status.FORBIDDEN)
						.entity("Wrong password!")
						.build();
			}

		}
		return Response.status(Response.Status.FORBIDDEN).build();
	}

} 
