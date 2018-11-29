package colruyt.pcrsejb.service.bl.user.privilege;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.TeamMemberUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
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
	public UserPrivilege grantUserPrivilegeToUser(User user, UserPrivilege userPrivilege) {
		UserPrivilege newUserPrivilege = null;
		user.getPrivileges().add(userPrivilege);
		User newUser = userServiceBl.save(user);
		for(UserPrivilege up : newUser.getPrivileges()) {
			if(up.getPrivilegeType().equals(userPrivilege.getPrivilegeType())) {
				newUserPrivilege = up;
			}
		}
		return newUserPrivilege;
	}

	@Override
	public void revokeUserPrivilegeToUser(User user, UserPrivilege userPrivilege) {
		for(UserPrivilege up : user.getPrivileges()) {
			if(up.equals(userPrivilege)) {
				up.setActive(false);
			}
		}
	}

	@Override
	public UserPrivilege setUserPrivilege(User user, String userPrivilege) throws MemberAlreadyHasATeamException {
		UserPrivilege privilege = null;
		SurveyDefinition surveyDefinition = null;
		
		if(PrivilegeType.TEAMMEMBER.getShortName().equals(userPrivilege)) {
    		List<TeamMemberUserPrivilege> memberPrivs = new ArrayList<>();
    			for (UserPrivilege p : user.getPrivileges()) {
        			if (p.getPrivilegeType().equals(PrivilegeType.TEAMMEMBER)) {
        				if (p.isActive()) {
        					//TODO FACESMESSAGE TOEVOEGEN
        					throw new MemberAlreadyHasATeamException();
        				}
        				memberPrivs.add((TeamMemberUserPrivilege) p);
        			}
        		}
    			for (TeamMemberUserPrivilege p : memberPrivs) {
    				if (p.getSurveyDefinition().getName().equalsIgnoreCase(surveyDefinition.getName())) {
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
        			if (p.getPrivilegeType().equals(PrivilegeTypeBo.TEAMMANAGER)) {
        				privilege = p;
        			}
        		}
        		if (privilege == null) {
        			privilege = new UserPrivilege();
        			privilege.setPrivilegeType(PrivilegeType.TEAMMANAGER);
        		}
        	}
		privilege.setActive(true);
		return grantUserPrivilegeToUser(user, privilege);
	}
	
}
