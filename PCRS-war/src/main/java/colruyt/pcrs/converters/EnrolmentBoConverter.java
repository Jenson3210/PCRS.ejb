package colruyt.pcrs.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;

@FacesConverter("enrolmentBoConverter")
public class EnrolmentBoConverter implements Converter {

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		EnrolmentBo enrolment = (EnrolmentBo) obj;
		UserBo user = (UserBo) enrolment.getUser();
		UserPrivilegeBo privilege = (UserPrivilegeBo) enrolment.getUserPrivilege();
		String returning = "";
		returning = returning + enrolment.getId() + ";";
		
		returning = returning + user.getId() + ";";
		returning = returning + user.getFirstName() + ";";
		returning = returning + user.getLastName() + ";";
		returning = returning + user.getEmail() + ";";
		returning = returning + user.getCountry() + ";";
		returning = returning + user.getPassword() + ";";
		returning = returning + user.getShortName() + ";";
		
		returning = returning + privilege.getId() + ";";
		returning = returning + privilege.getPrivilegeType().getFullName() + ";";
		return returning;
	}

	@Override
	public EnrolmentBo getAsObject(FacesContext context, UIComponent component, String value) {
		
		EnrolmentBo enrolment = new EnrolmentBo();
		UserBo user = new UserBo();
		UserPrivilegeBo privilege = new UserPrivilegeBo();
		String[] parts = value.split(";");
		
		enrolment.setId(Integer.valueOf(parts[0]));
		
		user.setId(Integer.valueOf(parts[1]));
		user.setFirstName(parts[2]);
		user.setLastName(parts[3]);
		user.setEmail(parts[4]);
		user.setCountry(parts[5]);
		user.setPassword(parts[6]);
		user.setShortName(parts[7]);
		
		enrolment.setUser(user);
		
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