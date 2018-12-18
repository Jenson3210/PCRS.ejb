package colruyt.pcrs.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;

/**
 * ENROLMENT BO CONVERTER
 * @author jda1mbw
 */
@FacesConverter("enrolmentBoConverter")
public class EnrolmentBoConverter implements Converter {

	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		EnrolmentBo enrolment = (EnrolmentBo) obj;
		UserPrivilegeBo privilege = (UserPrivilegeBo) enrolment.getUserPrivilege();
		String returning = "";
		returning = returning + enrolment.getId() + ";";
		
		returning = returning + privilege.getId() + ";";
		returning = returning + privilege.getPrivilegeType().getFullName() + ";";
		return returning;
	}

	@Override
	public EnrolmentBo getAsObject(FacesContext context, UIComponent component, String value) {
		
		EnrolmentBo enrolment = new EnrolmentBo();
		UserPrivilegeBo privilege = new UserPrivilegeBo();
		String[] parts = value.split(";");
		
		enrolment.setId(Integer.valueOf(parts[0]));
		
		privilege.setId(Integer.valueOf(parts[8]));
		if(parts[9] == "TEAMMEMBER") {
			privilege.setPrivilegeType(PrivilegeTypeBo.TEAMMEMBER);
		}else if(parts[9] == "TEAMMANAGER") {
			privilege.setPrivilegeType(PrivilegeTypeBo.TEAMMANAGER);
		}else if(parts[9] == "ADMINISTRATOR") {
			privilege.setPrivilegeType(PrivilegeTypeBo.ADMINISTRATOR);
		}
		
		enrolment.setUserPrivilege(privilege);
		
		return enrolment;
	}	
}