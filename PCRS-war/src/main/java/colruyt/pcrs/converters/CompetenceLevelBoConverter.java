package colruyt.pcrs.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import colruyt.pcrsejb.bo.competence.CompetenceLevelBo;

@FacesConverter("CompetenceLevelBoConverter")
public class CompetenceLevelBoConverter implements Converter {

	@Override
	public CompetenceLevelBo getAsObject(FacesContext context, UIComponent component, String value) {
		CompetenceLevelBo bo = new CompetenceLevelBo();
		String[] parts = value.split(";");
		bo.setId(Integer.valueOf(parts[0]));
		bo.setDescription(parts[1]);
		bo.setOrderLevel(Integer.valueOf(parts[2]));
		return bo;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		StringBuilder sb = new StringBuilder();
		CompetenceLevelBo bo = (CompetenceLevelBo) value;
		sb.append(bo.getId()).append(";")
			.append(bo.getDescription()).append(";")
			.append(bo.getOrderLevel()).append(";");
		return sb.toString();
	}

}
