package colruyt.pcrs.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.facade.user.IUserFacade;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/user")
public class UserService {
	
	@EJB
	private IUserFacade userFacade;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Find all users", notes = "Retrieve all users", response = User[].class, responseContainer = "List")
	@ApiResponses({ 
			@ApiResponse(code = 200, message = "Users found", response = User[].class),
			@ApiResponse(code = 404, message = "Users not found") })
	public Response allUsersGet() {
		
		List<UserBo> users = userFacade.getAll();
		
		return Response.ok().entity(users).build();
	}

	

}
