package colruyt.pcrs.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import colruyt.pcrsejb.bo.surveyDefinition.strategy.SurveySectionStrategyBo;

/**
 * SURVEY SECTION STRATEGY CONVERTER
 * @author jda1mbw
 */
@FacesConverter("SurveySectionStrategyConverter")
public class SurveySectionStrategyConverter implements Converter {

	@Override
	public SurveySectionStrategyBo getAsObject(FacesContext context, UIComponent component, String value) {
		SurveySectionStrategyBo sssb = new SurveySectionStrategyBo();
		String[] parts = value.split(";");
		sssb.setId(Integer.valueOf(parts[0]));
		sssb.setName(parts[1]);
		sssb.setAmountOfLevels(Integer.valueOf(parts[2]));
		sssb.setDescriptionRequired(Boolean.valueOf(parts[3]));
		sssb.setEnergyRated(Boolean.valueOf(parts[4]));
		sssb.setFlexibleDescription(Boolean.valueOf(parts[5]));
		sssb.setHasMinimumLevel(Boolean.valueOf(parts[6]));
		sssb.setInterestRated(Boolean.valueOf(parts[7]));
		return sssb;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		SurveySectionStrategyBo sssb = (SurveySectionStrategyBo) value;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(sssb.getId()).append(";")
					.append(sssb.getName()).append(";")
					.append(sssb.getAmountOfLevels()).append(";")
					.append(sssb.getDescriptionRequired()).append(";")
					.append(sssb.getEnergyRated()).append(";")
					.append(sssb.getFlexibleDescription()).append(";")
					.append(sssb.getHasMinimumLevel()).append(";")
					.append(sssb.getInterestRated()).append(";");
		
		return stringBuilder.toString();
	}
}
