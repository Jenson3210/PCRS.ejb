package colruyt.pcrsejb.service.bl.user.privilege;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.entity.user.privilege.SurveyUserPrivilege;
import colruyt.pcrsejb.entity.user.privilege.TeamMemberUserPrivilege;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.service.bl.user.IUserServiceBl;
import colruyt.pcrsejb.service.dl.user.privilege.IUserPrivilegeServiceDl;
import colruyt.pcrsejb.util.exceptions.MemberAlreadyHasATeamException;

@Stateless
public class UserPrivilegeServiceBl implements Serializable, IUserPrivilegeServiceBl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	IUserPrivilegeServiceDl userPrivilegeServiceDl;
	@EJB
	IUserServiceBl userServiceBl;

	@Override
	public UserPrivilege save(UserPrivilege element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPrivilege get(UserPrivilege element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserPrivilege> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UserPrivilege element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User grantUserPrivilegeToUser(User user, UserPrivilege userPrivilege) {
		user.getPrivileges().add(userPrivilege);
		user = userServiceBl.save(user);
		return user;
	}

	@Override
	public void revokeUserPrivilegeToUser(User user, UserPrivilege userPrivilege) {
		for(UserPrivilege up : user.getPrivileges()) {
			if(up.getId().equals(userPrivilege.getId())) {
				up.setActive(false);
			}
		}
		userServiceBl.save(user);
	}

	@Override
	public UserPrivilege setUserPrivilege(User user, String userPrivilege) throws MemberAlreadyHasATeamException {
		UserPrivilege privilege = null;
		SurveyDefinition surveyDefinition = null;
		user = userServiceBl.get(user);
		
		if(PrivilegeType.TEAMMEMBER.getShortName().equals(userPrivilege)) {
    		List<TeamMemberUserPrivilege> memberPrivs = new ArrayList<>();
    			for (UserPrivilege p : user.getPrivileges()) {
        			if (p.getPrivilegeType().equals(PrivilegeType.TEAMMEMBER)) {
        				if (p.isActive()) {
        					//TODO FACESMESSAGE TOEVOEGEN
        					throw new MemberAlreadyHasATeamException();
        				}else {
        					privilege = p;
        				}
        				//TODO
        				//memberPrivs.add((TeamMemberUserPrivilege) p);
        			}
        		}
    			for (TeamMemberUserPrivilege p : memberPrivs) {
    				if (p.getSurveyDefinition().getFunction().equalsIgnoreCase(surveyDefinition.getFunction())
    						&& p.getSurveyDefinition().getOperatingUnit().equals(surveyDefinition.getOperatingUnit())
    						&& p.getSurveyDefinition().getCountry().equals(surveyDefinition.getCountry())) {
    					privilege = p;
    				}
    			}	
    			if (privilege == null) {
    				privilege = new TeamMemberUserPrivilege();
    	    		privilege.setPrivilegeType(PrivilegeType.TEAMMEMBER);
    	    		//((TeamMemberUserPrivilegeBo) privilege).setStartDateCurrentSurveyDefinition(LocalDate.now());
    	    		((TeamMemberUserPrivilege) privilege).setSurveyDefinition(surveyDefinition);
    			}   	    		
        	}else {    		
    			for (UserPrivilege p : user.getPrivileges()) {
        			if (p.getPrivilegeType().equals(PrivilegeType.TEAMMANAGER)) {
        				privilege = p;
        			}
        		}
        		if (privilege == null) {
        			privilege = new UserPrivilege();
        			privilege.setPrivilegeType(PrivilegeType.TEAMMANAGER);
        		}
        	}
		privilege.setActive(true);
    	user.getPrivileges().add(privilege);
    	
		User newUser = userServiceBl.save(user);
		
		for(UserPrivilege p: newUser.getPrivileges()) {
			if(p.getPrivilegeType().equals(privilege.getPrivilegeType())) {
				privilege = p;
			}
		}
		return privilege;
	}

	@Override
	public void revokeUserPrivilegeTypeToUser(User user, PrivilegeType privilegeType, SurveyDefinition surveyDefinition) {
		for (Iterator<UserPrivilege> privileges = user.getPrivileges().iterator(); privileges.hasNext(); ) {
			UserPrivilege up = privileges.next();
			if((up.getPrivilegeType().equals(privilegeType))) {
				if ((surveyDefinition == null || surveyDefinition.getId() == ((SurveyUserPrivilege)up).getSurveyDefinition().getId())) {
					privileges.remove();
					this.revokeUserPrivilegeToUser(user, up);
				}
			}
		}
	}
	
}
