package colruyt.pcrsejb.service.bl.surveys.surveySet;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.surveys.surveySet.SurveySet;
import colruyt.pcrsejb.service.dl.surveys.surveySet.ISurveySetServiceDl;

@Stateless
public class SurveySetServiceBl implements Serializable, ISurveySetServiceBl{

	private static final long serialVersionUID = 1L;
	@EJB
	private ISurveySetServiceDl surveySetServiceDb;
	
	@Override
	public SurveySet save(SurveySet element) {
		return surveySetServiceDb.save(element);
	}

	@Override
	public SurveySet get(SurveySet element) {
		return surveySetServiceDb.get(element);
	}

	@Override
	public List<SurveySet> getAll() {
		return surveySetServiceDb.getAll();
	}

	@Override
	public void delete(SurveySet element) {
		surveySetServiceDb.delete(element);
	}

}
