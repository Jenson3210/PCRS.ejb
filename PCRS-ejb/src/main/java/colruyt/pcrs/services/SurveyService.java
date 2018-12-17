package colruyt.pcrs.services;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import colruyt.pcrsejb.bo.surveys.survey.SurveyBo;
import colruyt.pcrsejb.bo.surveys.survey.SurveyKindBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.facade.surveys.survey.ISurveyFacade;
import colruyt.pcrsejb.facade.surveys.surveySet.ISurveySetFacade;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.util.exceptions.NoSurveySetException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("usersurveys")
public class SurveyService {

	@EJB
	private ISurveySetFacade surveySetFacade;
	@EJB
	private IUserFacade userFacade;
	@EJB
	private ISurveyFacade surveyFacade;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Find active survey for user", notes = "Retrieve survey for user.", response = SurveyBo.class, responseContainer = "List")
	@ApiResponses({ @ApiResponse(code = 200, message = "Surveys found", response = SurveyBo.class),
			@ApiResponse(code = 404, message = "Surveys not found") })
	@Path("{userId}")
	public Response userActiveSurveyGet(
			@ApiParam(value = "For which user do you want the survey?", required = true) @PathParam("userId") Integer userId,
			@ApiParam(value = "What survey kind do you want?", required = true) @QueryParam("surveyKind") String surveyKind) {

		SurveyBo survey;
		try {
			UserBo user = new UserBo();
			user.setId(userId);
			user = userFacade.get(user);
			SurveyKindBo kind = SurveyKindBo.valueOf(surveyKind);
			survey = surveySetFacade.getSurveyForUser(user, kind);
			return Response.ok().entity(survey).build();
		} catch (NoSurveySetException e) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity("No survey found!")
					.build();
		} catch (ValidationException e) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity("No user found!")
					.build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveSurvey(SurveyBo survey) {
		try {
			surveyFacade.save(survey);
		} catch (ValidationException e) {
			System.out.println("Could not save!");
		}
	}
}
