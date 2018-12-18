package colruyt.pcrs.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;

/**
 * SURVEY SECTION DEFINITION BO CONVERTER
 * @author jda1mbw
 */
@FacesConverter("SurveySectionDefinitionBoConverter")
public class SurveySectionDefinitionBoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		SurveySectionDefinitionBo bo = new SurveySectionDefinitionBo();
		String[] parts = value.split(";");
		bo.setId(Integer.valueOf(parts[0]));
		return bo;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		StringBuilder sb = new StringBuilder();
		SurveySectionDefinitionBo bo = (SurveySectionDefinitionBo) value;
	
		sb.append(bo.getId());
		
		return sb.toString();
	}

}
