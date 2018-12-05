package colruyt.pcrs.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;

@FacesConverter("surveySectionTitleConverter")
public class SurveySectionTitleConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		SurveySectionTitleBo sst = new SurveySectionTitleBo();
		String[] parts = value.split(";");
		sst.setId(Integer.valueOf(parts[0]));
		sst.setTitle(parts[1]);
		System.out.println(sst);
		return sst;
	}

	 
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		SurveySectionTitleBo sst = (SurveySectionTitleBo) value;
		String s = sst.getId() + ";" + sst.getTitle() + ";";
		System.out.println(sst);
		return s;
	}

}
