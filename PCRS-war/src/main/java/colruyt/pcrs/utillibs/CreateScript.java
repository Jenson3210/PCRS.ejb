package colruyt.pcrs.utillibs;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.inject.Named;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.competence.CompetenceLevelBo;
import colruyt.pcrsejb.bo.surveyDefinition.strategy.SurveySectionStrategyBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.facade.competence.ICompetenceFacade;
import colruyt.pcrsejb.facade.surveyDefinition.strategy.ISurveySectionStrategyFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionTitleFacade;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.team.ITeamFacade;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

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
			HashSet<CompetenceLevelBo> competenceLevels_SE_15 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_15.add (new CompetenceLevelBo(" ik begrijp waarvoor de PCLC staat, maar het blijft ver van mijn bed-show. Ik gebruik die niet als gids.", 1));
		competenceLevels_SE_15.add (new CompetenceLevelBo(" ik begrijp waarvoor de PCLC staat, maar gebruik die eerder zelden", 2));
		competenceLevels_SE_15.add (new CompetenceLevelBo(" ik gebruik de PCLC echt als mijn leidraad en pas dus de activiteiten en deliverables toe waar ik die nodig acht in een project", 3));
		competenceLevels_SE_15.add (new CompetenceLevelBo(" ik spreek ook anderen aan over het gebruik van de PCLC binnen het projectteam", 4));


		CompetenceBo competenceBo_SE_15 = new CompetenceBo ("PCLC as a Guide", "Uitleg: De PCLC of Project Content Life Cycle is een soort 'proces', een stappenplan waarin staat wat een team te doen staat, willen ze een solution realizeren. Afhankelijk van het type solution (procesoptimalisatie, IT solution, machine, ...) ga je andere activiteiten uitvoeren.  ", competenceLevels_SE_15 );
		try {
		        compFacade.save(competenceBo_SE_15);
		    } catch (ValidationException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		HashSet<CompetenceLevelBo> competenceLevels_SE_16 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_16.add (new CompetenceLevelBo(" ik geraak nog steeds niet goed wijs uit het verschil tussen functies en rollen", 1));
		competenceLevels_SE_16.add (new CompetenceLevelBo("  ik weet in grove lijnen wat de verantwoordelijkheid is van een aantal rollen in de PCLC", 2));
		competenceLevels_SE_16.add (new CompetenceLevelBo(" ik ken de meest gebruikte rollen in de PCLC, en van de rol(len) die ik opneem weet ik wat te doen, of vind ik mijn weg om het te weten te komen", 3));
		competenceLevels_SE_16.add (new CompetenceLevelBo(" ik weet zowel van de rollen die ik opneem als van de meeste andere wat hen te doen staat", 4));


		CompetenceBo competenceBo_SE_16 = new CompetenceBo ("Roles in the PCLC", "Uitleg: Rollen in de PCLC zijn o.a: project manager, business advisor, project business architect, solution IT architect, process designer, system requirements analyst, lead developer, developer, test manager, asset owner, ...  ", competenceLevels_SE_16 );
		try {
		        compFacade.save(competenceBo_SE_16);
		    } catch (ValidationException e) {

		        e.printStackTrace();
		    }
		HashSet<CompetenceLevelBo> competenceLevels_SE_17 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_17.add (new CompetenceLevelBo(" ik doe wat ik denk dat nodig is. Ik gebruik daarvoor geen referentiemateriaal of templates.", 1));
		competenceLevels_SE_17.add (new CompetenceLevelBo(" ik gebruik in projecten bijna steeds dezelde templates of deliverables, als die al nodig zijn. Ik weet waar ik die kan vinden, en zoek verder nooit naar iets extra.", 2));
		competenceLevels_SE_17.add (new CompetenceLevelBo(" ik weet wat ik als basis op te leveren heb in een project, maar ik ga toch nu en dan eens zoeken op de PCLC site (of andere site). Ik weet graag of er een update is, of een mogelijk andere techniek die me beter kan helpen", 3));
		competenceLevels_SE_17.add (new CompetenceLevelBo(" ik neem steevast de PCLC-lijst met deliverables erbij, zodat ik ten alle tijde weet welke types deliverables en templates ik kan gebruiken. Want afhankelijk van de solution, kunnen andere templates of methodieken me zeker beter helpen.", 4));


		CompetenceBo competenceBo_SE_17 = new CompetenceBo ("Activities and Deliverables", "Uitleg: Rollen voeren specifieke activiteiten uit. En heel vaak wordt er ook informatie verzameld of aangevuld, en daarvoor is er vaak een template ter beschikking. Alle uitleg over die activiteiten en die deliverables vind je op de PCLC-site.  ", competenceLevels_SE_17 );
		try {
		        compFacade.save(competenceBo_SE_17);
		    } catch (ValidationException e) {

		        e.printStackTrace();
		    }
		HashSet<CompetenceLevelBo> competenceLevels_SE_18 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_18.add (new CompetenceLevelBo(" Ik heb nog nooit of zeer zelden een MAW meegemaakt. Ik zie ook de meerwaarde niet goed.", 1));
		competenceLevels_SE_18.add (new CompetenceLevelBo(" Ik begrijp en zie de meerwaarde van een MAW, maar er worden er te weinig georganiseerd op project(en) waar ik deel van uitmaak", 2));
		competenceLevels_SE_18.add (new CompetenceLevelBo(" MAW's worden geregeld ingepland, maar de kwaliteit ervan kan zeker nog beter", 3));
		competenceLevels_SE_18.add (new CompetenceLevelBo(" MAW's worden geregeld ingepland, en ook de meerwaarde ervan is meteen duidelijk. Kwaliteit is voldoende.", 4));
		competenceLevels_SE_18.add (new CompetenceLevelBo(" ik zorg er zelf voor dat MAW's ingepland raken, zelfs al ben ik de PM niet, want ze zijn onotbeerlijk voor het goede verloop van elk project. ", 5));


		CompetenceBo competenceBo_SE_18 = new CompetenceBo ("MAW's", "Uitleg: Een Method Adoption Workshop dient om voor elke projectstap of elk workpackage af te spreken wat er nodig is binnen deze projectopdracht, wie die rol zal opnemen en welke deliverables die zal opleveren. Zo weet iedereen wat die van wie mag verwachten.   ", competenceLevels_SE_18 );
		try {
		        compFacade.save(competenceBo_SE_18);
		    } catch (ValidationException e) {

		        e.printStackTrace();
		    }
		HashSet<CompetenceLevelBo> competenceLevels_SE_19 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_19.add (new CompetenceLevelBo(" ik heb geen idee waar ik terecht kan als ik vragen heb, tenzij bij mijn chef dan. Ik trek mijn plan op mijn eentje.", 1));
		competenceLevels_SE_19.add (new CompetenceLevelBo(" als ik hulp zou nodig hebben, dan ga ik te rade bij collega's (die dezelfde rol opnemen) die me kunnen helpen", 2));
		competenceLevels_SE_19.add (new CompetenceLevelBo(" ik weet waar ik terecht kan voor hulp, en ik schakel die in of zou die inschakelen wanneer ik dat nodig vind", 3));
		competenceLevels_SE_19.add (new CompetenceLevelBo(" ik ben een referentie voor collega's en stuur hen door naar de site of naar key user(s), of maak er toch reclame voor, als zij met vragen komen. Kwestie dat ook zij de hulpbronnen leren kennen.", 4));


		CompetenceBo competenceBo_SE_19 = new CompetenceBo ("Supporting material and support", "Uitleg: Er is een PCLC site waarop alle info rond de 'Realize a solution'-stappen, rollen, activiteiten, deliverables en templates gecentraliseerd staat. Daarnaast zijn er nog CoE coördinatoren en key users die per discipline ondersteuning en coaching kunnen geven bij het uitoefenen van je rol.  ", competenceLevels_SE_19 );
		try {
		        compFacade.save(competenceBo_SE_19);
		    } catch (ValidationException e) {

		        e.printStackTrace();
		    }
		}
	}

	public void fillDb() {
		Set<CompetenceLevelBo> cLevels = new HashSet<>();
		cLevels.add(new CompetenceLevelBo("testLevel1", 1));
		cLevels.add(new CompetenceLevelBo("testLevel2", 2));
		try {
			compFacade.save(new CompetenceBo("test", "", cLevels));


		//SurveyDefinitionBo sDevBo = new SurveyDefinitionBo("SE BPS BE", new ArrayList<>());
		//sDevBo = surveyDefinitionFacade.save(sDevBo);

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
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
