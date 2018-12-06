package colruyt.pcrsejb.service.dl.surveys.surveySet;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.surveys.surveySet.SurveySet;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.IDbService;
import colruyt.pcrsejb.util.exceptions.NoSurveySetException;

@Local
public interface ISurveySetServiceDl extends IDbService<SurveySet>{


	public SurveySet getLatestSetFor(User user) throws NoSurveySetException;
		
		
	
	
}
