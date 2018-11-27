package colruyt.pcrsejb.service.bl.surveyDefinition.survey;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;
import colruyt.pcrsejb.service.dl.surveyDefinition.survey.ISurveySectionTitleServiceDl;

@Stateless
public class SurveySectionTitleServiceBl implements ISurveySectionTitleServiceBl, Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private ISurveySectionTitleServiceDl surveySectionTitleDb;

	
	@Override
	public SurveySectionTitle save(SurveySectionTitle element) {
		return surveySectionTitleDb.save(element);
	}

	@Override
	public SurveySectionTitle get(SurveySectionTitle element) {
		return surveySectionTitleDb.get(element);
	}

	@Override
	public List<SurveySectionTitle> getAll() {
		System.out.println("the size is " + surveySectionTitleDb.getAll().size());
		return surveySectionTitleDb.getAll();
	}

	@Override
	public void delete(SurveySectionTitle element) {
		surveySectionTitleDb.delete(element);
	}
}
