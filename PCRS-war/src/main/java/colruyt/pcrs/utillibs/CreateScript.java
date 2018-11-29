package colruyt.pcrs.utillibs;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.ejb.EJB;
import javax.inject.Named;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.competence.CompetenceLevelBo;
import colruyt.pcrsejb.bo.surveyDefinition.strategy.SurveySectionStrategyBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.SurveyDefinitionResponsibleUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.privilege.TeamMemberUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.facade.competence.ICompetenceFacade;
import colruyt.pcrsejb.facade.surveyDefinition.strategy.ISurveySectionStrategyFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionTitleFacade;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.team.ITeamFacade;

@Named
public class CreateScript implements Serializable {
	@EJB
	private ICompetenceFacade compFacade;
	@EJB
	private ITeamFacade teamFacade;
	@EJB
	private ISurveyDefinitionFacade surveyDefinitionFacade;
	@EJB
	private ISurveySectionStrategyFacade surveySectionStrategyFacade;
	@EJB
	private ISurveySectionTitleFacade surveySectionTitleFacade;
	@EJB
	private IUserFacade userFacade;

	private static final long serialVersionUID = 1L;

	public void fillCompetencesDb(Boolean createCompetences) {
		if (createCompetences) {
			//KURT ZIJN CODE HIER
		}
	}

	public void fillDb() {
		Set<CompetenceLevelBo> cLevels = new HashSet<>();
		cLevels.add(new CompetenceLevelBo("testLevel1", 1));
		cLevels.add(new CompetenceLevelBo("testLevel2", 2));
		compFacade.save(new CompetenceBo("test", "", cLevels));

		SurveyDefinitionBo sDevBo = new SurveyDefinitionBo("SE BPS BE", new ArrayList<>());
		sDevBo = surveyDefinitionFacade.save(sDevBo);

		surveySectionStrategyFacade
				.save(new SurveySectionStrategyBo(5, false, false, "Behavioral", false, true, false));
		surveySectionStrategyFacade.save(new SurveySectionStrategyBo(4, true, true, "", true, true, false));
		
		surveySectionTitleFacade.save(new SurveySectionTitleBo("developer"));
		surveySectionTitleFacade.save(new SurveySectionTitleBo("tester"));

		Set<UserPrivilegeBo> privs1 = new HashSet<>();
		privs1.add(new UserPrivilegeBo(PrivilegeTypeBo.ADMINISTRATOR, true));
		userFacade.save(new UserBo("Root", "Woot", "Root.Woot@gmail.com", "RootWoot", "BE", "RoWoo", privs1));
		
		Set<UserPrivilegeBo> privs2 = new HashSet<>();
		UserPrivilegeBo thomasPriv = new UserPrivilegeBo(PrivilegeTypeBo.TEAMMANAGER, true);
		privs2.add(thomasPriv);
		UserBo thomas = new UserBo("Thomas", "Billet", "thomasgod2@gmail.com", "ThomasBillet", "BE", "thbil", privs2);
		userFacade.save(thomas);

		teamFacade.save(new TeamBo("Java Trainees", new HashSet<>()));
		System.out.println("Ok 10");
	}
	
	private void additionalSetup() {
//		Set<UserPrivilegeBo> privs3 = new HashSet<>();
//		UserPrivilegeBo boniPriv = new TeamMemberUserPrivilegeBo(PrivilegeTypeBo.TEAMMEMBER, true, sDevBo,
//				LocalDate.now(), new TreeSet<>());
//		privs3.add(boniPriv);
//		UserBo boni = new UserBo("Bo", "Ni", "boni@gmail.com", "BoNi", "BE", "BoNi", privs3);
//		userFacade.save(boni);
//		System.out.println("Ok 7");
//
//		Set<UserPrivilegeBo> privs4 = new HashSet<>();
//		privs4.add(new SurveyDefinitionResponsibleUserPrivilegeBo(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE, true,
//				sDevBo));
//		userFacade.save(
//				new UserBo("Maarten", "Spooren", "Maarten.Spooren@gmail.com", "MaartenSporen", "BE", "MaSpo", privs4));
//		System.out.println("Ok 8");
//		
//		Set<EnrolmentBo> en = new HashSet<>();
//		en.add(new EnrolmentBo(thomas, thomasPriv, true));
//		en.add(new EnrolmentBo(boni, boniPriv, true));
//		teamFacade.save(new TeamBo("Boni Boys", en));
//		System.out.println("Ok 9");
	}
}
