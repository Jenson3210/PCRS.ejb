package colruyt.pcrsejb.converter.user.privilege;

import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;

public class PrivilegeTypeTranslator {

	public PrivilegeType convertToEntity(PrivilegeTypeBo bo) {
		PrivilegeType entity = null;
		switch(bo) {
		case ADMINISTRATOR:
			entity = PrivilegeType.ADMINISTRATOR;
			break;
		case SURVEYDEFINITIONRESPONSIBLE:
			entity = PrivilegeType.ADMINISTRATOR;
			break;
		case TEAMMANAGER:
			entity = PrivilegeType.TEAMMANAGER;
			break;
		case TEAMMEMBER:
			entity = PrivilegeType.TEAMMEMBER;
			break;
		}
		return entity;
	}

	public PrivilegeTypeBo convertToBo(PrivilegeType entity) {
		PrivilegeTypeBo bo = null;
		switch(entity) {
		case ADMINISTRATOR:
			bo = PrivilegeTypeBo.ADMINISTRATOR;
			break;
		case SURVEYDEFINITIONRESPONSIBLE:
			bo = PrivilegeTypeBo.ADMINISTRATOR;
			break;
		case TEAMMANAGER:
			bo = PrivilegeTypeBo.TEAMMANAGER;
			break;
		case TEAMMEMBER:
			bo = PrivilegeTypeBo.TEAMMEMBER;
			break;
		}
		return bo;
	}

}
