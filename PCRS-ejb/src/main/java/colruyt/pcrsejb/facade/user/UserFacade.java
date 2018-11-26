package colruyt.pcrsejb.facade.user;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.converter.user.privilege.PrivilegeTypeTranslator;
import colruyt.pcrsejb.service.bl.user.IUserServiceBl;

@Stateless
public class UserFacade implements Serializable, IUserFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private IUserServiceBl userServiceBl;
	private UserConverter userConverter = new UserConverter();
	private PrivilegeTypeTranslator privilegeTypeTranslator = new PrivilegeTypeTranslator();

	public UserBo getUserByEmail(String email) {
		return userConverter.convertToBo(userServiceBl.getUserByEmail(email));
	}

	public List<UserBo> getAll() {
		return userConverter.convertToBos(userServiceBl.getAll());
	}

	@Override
	public UserBo save(UserBo user) {
		return userConverter.convertToBo(userServiceBl.save(userConverter.convertToEntity(user)));
	}

	@Override
	public UserBo get(UserBo user) {
		return userConverter.convertToBo(userServiceBl.get(userConverter.convertToEntity(user)));
	}

	@Override
	public void delete(UserBo user) {
		userServiceBl.delete(userConverter.convertToEntity(user));
	}

	@Override
	public Boolean hasPrivilege(UserBo user, PrivilegeTypeBo privilege, Boolean active) {
		return userServiceBl.hasPrivilege(userConverter.convertToEntity(user),
				privilegeTypeTranslator.convertToEntity(privilege), active);
	}

}
