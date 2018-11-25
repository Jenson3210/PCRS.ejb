package colruyt.pcrsejb.converter.user;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.user.privilege.UserPrivilegeConverter;
import colruyt.pcrsejb.entity.user.User;

public class UserConverter implements GenericConverter<User, UserBo>{

	private UserPrivilegeConverter userPrivilegeConverter = new UserPrivilegeConverter();
	
	@Override
	public User convertToEntity(UserBo bo) {
		User entity = null;
		if (bo != null) {
			entity = new User();
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			ConverterUtils.setIfNotNull(bo::getCountry, entity::setCountry);
			ConverterUtils.setIfNotNull(bo::getEmail, entity::setEmail);
			ConverterUtils.setIfNotNull(bo::getFirstName, entity::setFirstName);
			ConverterUtils.setIfNotNull(bo::getLastName, entity::setLastName);
			ConverterUtils.setIfNotNull(bo::getPassword, entity::setPassword);
			entity.setPrivileges(userPrivilegeConverter.convertToEntities(bo.getPrivileges()));
		} 
		return entity;
	}

	@Override
	public UserBo convertToBo(User entity) {
		UserBo bo = null;
		if (entity != null) {
			bo = new UserBo();
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			ConverterUtils.setIfNotNull(entity::getCountry, bo::setCountry);
			ConverterUtils.setIfNotNull(entity::getEmail, bo::setEmail);
			ConverterUtils.setIfNotNull(entity::getFirstName, bo::setFirstName);
			ConverterUtils.setIfNotNull(entity::getLastName, bo::setLastName);
			ConverterUtils.setIfNotNull(entity::getPassword, bo::setPassword);
			bo.setPrivileges(userPrivilegeConverter.convertToBos(entity.getPrivileges()));
			
		} 
		return bo;
	}
    
}
