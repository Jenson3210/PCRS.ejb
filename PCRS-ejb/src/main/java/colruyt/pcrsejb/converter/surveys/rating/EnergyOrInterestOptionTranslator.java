package colruyt.pcrsejb.converter.surveys.rating;

import colruyt.pcrsejb.bo.surveys.rating.EnergyOrInterestOptionBo;
import colruyt.pcrsejb.entity.surveys.rating.EnergyOrInterestOption;

public class EnergyOrInterestOptionTranslator {
	public EnergyOrInterestOption convertToEntity(EnergyOrInterestOptionBo bo) {
		EnergyOrInterestOption entity = null;
		if (bo != null) {
			switch (bo) {
			case NOIDEA:
				entity = EnergyOrInterestOption.NOIDEA;
				break;
			case NO:
				entity = EnergyOrInterestOption.NO;
				break;
			case YES:
				entity = EnergyOrInterestOption.YES;
				break;
			}
		}
		return entity;
	}

	public EnergyOrInterestOptionBo convertToBo(EnergyOrInterestOption entity) {
		EnergyOrInterestOptionBo bo = null;
		if (entity != null) {
			switch (entity) {
			case NOIDEA:
				bo = EnergyOrInterestOptionBo.NOIDEA;
				break;
			case NO:
				bo = EnergyOrInterestOptionBo.NO;
				break;
			case YES:
				bo = EnergyOrInterestOptionBo.YES;
				break;
			}
		}
		return bo;
	}
}
