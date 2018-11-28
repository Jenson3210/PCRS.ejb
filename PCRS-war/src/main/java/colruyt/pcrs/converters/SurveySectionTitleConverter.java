package colruyt.pcrs.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;

@FacesConverter("SurveySectionTitleConverter")
public class SurveySectionTitleConverter implements Converter{

	@Override
	public SurveySectionTitleBo getAsObject(FacesContext context, UIComponent component, String value) {
		SurveySectionTitleBo sst = new SurveySectionTitleBo();
		String[] parts = value.split(";");
		sst.setId(Integer.valueOf(parts[0]));
		sst.setTitle(parts[1]);
		return sst;
	}

	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		SurveySectionTitleBo sst = (SurveySectionTitleBo) value;
		StringBuilder returnString = new StringBuilder();
		returnString.append(sst.getId())
					.append(";")
					.append(sst.getTitle());
		return returnString.toString();
	}

}
