package colruyt.pcrsejb.bo.surveys.survey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import colruyt.pcrsejb.bo.AbstractBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionImplBo;
import colruyt.pcrsejb.bo.surveys.rating.RatingBo;

public class SurveySectionBo extends AbstractBo implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private SurveySectionDefinitionImplBo surveySectionDefinition;
	private List<RatingBo> ratings = new ArrayList<>();
    /*
     * CONSTRUCTORS
     */
	public SurveySectionBo() {
		super();
	}
	public SurveySectionBo(SurveySectionDefinitionImplBo surveySectionDefinition, List<RatingBo> ratings) {
		super();
		this.surveySectionDefinition = surveySectionDefinition;
		this.ratings = ratings;
	}
	public SurveySectionBo(Integer id, SurveySectionDefinitionImplBo surveySectionDefinition, List<RatingBo> ratings) {
		super();
		this.id = id;
		this.surveySectionDefinition = surveySectionDefinition;
		this.ratings = ratings;
	}
	/*
	 * GETTERS AND SETTERS
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public SurveySectionDefinitionImplBo getSurveySectionDefinition() {
		return surveySectionDefinition;
	}
	public void setSurveySectionDefinition(SurveySectionDefinitionImplBo surveySectionDefinition) {
		this.surveySectionDefinition = surveySectionDefinition;
	}
	public List<RatingBo> getRatings() {
		return ratings;
	}
	public void setRatings(List<RatingBo> ratings) {
		this.ratings = ratings;
	}
}
