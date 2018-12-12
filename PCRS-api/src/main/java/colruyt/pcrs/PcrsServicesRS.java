package colruyt.pcrs;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

import colruyt.pcrs.services.SurveyService;
import colruyt.pcrs.services.UserService;

public class PcrsServicesRS extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		
		Set<Class<?>> resources = new HashSet<>();
		
		resources.add(UserService.class);
		resources.add(SurveyService.class);
		
		return resources;
	}

}
