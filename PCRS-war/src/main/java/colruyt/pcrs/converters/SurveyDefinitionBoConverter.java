package colruyt.pcrs.converters;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionImplBo;

@FacesConverter("SurveyDefinitionBoConverter")
public class SurveyDefinitionBoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println(value);
		SurveyDefinitionBo bo = new SurveyDefinitionBo();
		List<SurveySectionDefinitionImplBo> surveySections = new ArrayList<>();
		
		String[] parts = value.split(";");
		bo.setId(Integer.valueOf(parts[0]));
		bo.setFunction(parts[1]);
		bo.setOperatingUnit(parts[2]);
		bo.setCountry(parts[3]);
		bo.setSurveySections(surveySections);
		
		return bo;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		SurveyDefinitionBo bo = (SurveyDefinitionBo) value;
		
		String returning = "";
		returning = returning + bo.getId() + ";";
		
		returning = returning + bo.getFunction() + ";";
		returning = returning + bo.getOperatingUnit() + ";";
		returning = returning + bo.getCountry() + ";";
		System.out.println(returning);
		return returning;
	}
		
	
	

}
