package colruyt.pcrs.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionImplBo;

@FacesConverter("DefinitionImplBoConverter")
public class SurveySectionDefinitionImplBoConverter implements Converter {

	@Override
	public SurveySectionDefinitionImplBo getAsObject(FacesContext context, UIComponent component, String value) {
		SurveySectionDefinitionImplBo bo = new SurveySectionDefinitionImplBo();
		String[] parts = value.split(";");
		bo.setId(Integer.valueOf(parts[0]));
		return bo;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		SurveySectionDefinitionImplBo bo = (SurveySectionDefinitionImplBo) value;
		
		StringBuilder sb = new StringBuilder();
		sb.append(bo.getId()).append(";").append(bo.getSurveySectionDefinitionBo().getSurveySectionTitle().getTitle());
		return sb.toString();
	}

}
