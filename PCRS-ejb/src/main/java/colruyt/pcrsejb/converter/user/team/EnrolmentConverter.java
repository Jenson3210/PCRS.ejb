package colruyt.pcrsejb.converter.user.team;

import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.converter.user.privilege.UserPrivilegeConverter;
import colruyt.pcrsejb.entity.user.team.Enrolment;

public class EnrolmentConverter implements GenericConverter<Enrolment, EnrolmentBo> {

	private UserPrivilegeConverter userPrivilegeConverter = new UserPrivilegeConverter();
	private UserConverter userConverter = new UserConverter();
	
	@Override
	public Enrolment convertToEntity(EnrolmentBo bo) {
		Enrolment entity = null;
		if (bo != null) {
			entity = new Enrolment();
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			ConverterUtils.setIfNotNull(bo::isActive, entity::setActive);
			entity.setUser(userConverter.convertToEntity(bo.getUser()));
			entity.setUserPrivilege(userPrivilegeConverter.convertToEntity(bo.getUserPrivilege()));
			
		} 
		return entity;
	}

	@Override
	public EnrolmentBo convertToBo(Enrolment entity) {
		EnrolmentBo bo = null;
		if (entity != null) {
			bo = new EnrolmentBo();
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			ConverterUtils.setIfNotNull(entity::isActive, bo::setActive);
			bo.setUser(userConverter.convertToBo(entity.getUser()));
			bo.setUserPrivilege(userPrivilegeConverter.convertToBo(entity.getUserPrivilege()));
			
		} 
		return bo;
	}
    
}
