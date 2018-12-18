package colruyt.pcrs.utillibs;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;


@Named
@SessionScoped
public class WebUser implements Serializable{
	
	
	 
	
	private static final long serialVersionUID = 1L;

	public WebUser() {
		
	
	}

	public UserBo getUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		return ((UserBo) context.getExternalContext().getSessionMap().get("user")); 
	}
	
	public boolean hasUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getExternalContext().getSessionMap().containsKey("user");
	}
	
	public boolean hasPrivilege(String privilegeType) {
		boolean hasPrivilege = false;
		for (UserPrivilegeBo privilege : getUser().getPrivileges()) {
			if (privilege.isActive() && privilege.getPrivilegeType().getFullName().equalsIgnoreCase(privilegeType)) {
				hasPrivilege = true;
			}
		}
		return hasPrivilege;
	}
}
