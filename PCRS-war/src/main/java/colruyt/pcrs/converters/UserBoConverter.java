package colruyt.pcrs.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import colruyt.pcrsejb.bo.user.UserBo;

/**
 * USER BO CONVERTER
 * @author jda1mbw
 */
@FacesConverter("userBoConverter")
public class UserBoConverter implements Converter {

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		UserBo user = (UserBo) obj;
		String returning = "";
		returning = returning + user.getId() + ";";
		returning = returning + user.getFirstName() + ";";
		returning = returning + user.getLastName() + ";";
		returning = returning + user.getEmail() + ";";
		returning = returning + user.getCountry() + ";";
		returning = returning + user.getPassword() + ";";
		returning = returning + user.getShortName() + ";";
		return returning;
	}

	@Override
	public UserBo getAsObject(FacesContext context, UIComponent component, String value) {
		UserBo user = new UserBo();
		String[] parts = value.split(";");
		user.setId(Integer.valueOf(parts[0]));
		user.setFirstName(parts[1]);
		user.setLastName(parts[2]);
		user.setEmail(parts[3]);
		user.setCountry(parts[4]);
		user.setPassword(parts[5]);
		user.setShortName(parts[6]);
		return user;
	}	
}