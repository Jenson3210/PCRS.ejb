package colruyt.pcrsejb.converter.user.team;

import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.user.team.Team;

public class TeamConverter implements GenericConverter<Team, TeamBo> {

	private EnrolmentConverter enrolmentConverter = new EnrolmentConverter();
	
	@Override
	public Team convertToEntity(TeamBo bo) {
		Team entity = null;
		if (bo != null) {
			entity = new Team();
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			ConverterUtils.setIfNotNull(bo::getName, entity::setName);
			entity.setEnrolments(enrolmentConverter.convertToEntities(bo.getEnrolments()));
		} 
		return entity;
	}

	@Override
	public TeamBo convertToBo(Team entity) {
		TeamBo bo = null;
		if (entity != null) {
			bo = new TeamBo();
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			ConverterUtils.setIfNotNull(entity::getName, bo::setName);
			bo.setEnrolments(enrolmentConverter.convertToBos(entity.getEnrolments()));
		} 
		return bo;
	}

}
