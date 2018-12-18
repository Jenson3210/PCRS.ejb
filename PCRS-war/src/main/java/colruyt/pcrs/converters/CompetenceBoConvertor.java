package colruyt.pcrs.converters;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * COMPETENCE BO CONVERTER
 * @author jda1mbw
 */
@FacesConverter("competenceBoConverter")
public class CompetenceBoConvertor implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        CompetenceBo bo = new CompetenceBo();
        String[] parts = value.split(";");
        bo.setId(Integer.valueOf(parts[0]));
        return bo;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        StringBuilder sb = new StringBuilder();
        CompetenceBo bo = (CompetenceBo) value;

        sb.append(bo.getId());

        return sb.toString();
    }
}
