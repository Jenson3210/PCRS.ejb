package colruyt.pcrs.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;

@FacesConverter("SurveyDefinitionBoConverter")
public class SurveyDefinitionBoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		SurveyDefinitionBo bo = new SurveyDefinitionBo();
		String[] parts = value.split(";");
		bo.setId(Integer.valueOf(parts[0]));
		bo.setFunction(parts[1]);
		bo.setOperatingUnit(parts[2]);
		bo.setCountry(parts[3]);
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
		return returning;
	}
		
	
	

}
