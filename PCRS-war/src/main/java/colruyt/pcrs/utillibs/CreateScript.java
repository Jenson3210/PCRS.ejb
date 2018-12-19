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
	private ICompetenceFacade competenceFacade;
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
		/** Filling the Solution Analists **/
		if(createCompetences) {
		HashSet<CompetenceLevelBo> competenceLevels_SA_15 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_15.add (new CompetenceLevelBo(" ik begrijp waarvoor de PCLC staat, maar het blijft ver van mijn bed-show. Ik gebruik die niet als gids.", 1));
		competenceLevels_SA_15.add (new CompetenceLevelBo(" ik begrijp waarvoor de PCLC staat, maar gebruik die eerder zelden", 2));
		competenceLevels_SA_15.add (new CompetenceLevelBo(" ik gebruik de PCLC echt als mijn leidraad en pas dus de activiteiten en deliverables toe waar ik die nodig acht in een project", 3));
		competenceLevels_SA_15.add (new CompetenceLevelBo(" ik spreek ook anderen aan over het gebruik van de PCLC binnen het projectteam", 4));


		CompetenceBo competenceBo_SA_15 = new CompetenceBo ("De PCLC als gids ", "Uitleg: De PCLC of Project Content Life Cycle is een soort 'proces', een stappenplan waarin staat wat een team te doen staat, willen ze een solution realizeren. Afhankelijk van het type solution (procesoptimalisatie, IT solution, machine, ...) ga je andere activiteiten uitvoeren.  ", competenceLevels_SA_15 );
		try {
			competenceFacade.save(competenceBo_SA_15);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_16 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_16.add (new CompetenceLevelBo(" ik geraak nog steeds niet goed wijs uit het verschil tussen functies en rollen", 1));
		competenceLevels_SA_16.add (new CompetenceLevelBo("  ik weet in grove lijnen wat de verantwoordelijkheid is van een aantal rollen in de PCLC", 2));
		competenceLevels_SA_16.add (new CompetenceLevelBo(" ik ken de meest gebruikte rollen in de PCLC, en van de rol(len) die ik opneem weet ik wat te doen, of vind ik mijn weg om het te weten te komen", 3));
		competenceLevels_SA_16.add (new CompetenceLevelBo(" ik weet zowel van de rollen die ik opneem als van de meeste andere wat hen te doen staat", 4));


		CompetenceBo competenceBo_SA_16 = new CompetenceBo ("Rollen in de PCLC", "Uitleg: Rollen in de PCLC zijn o.a: project manager, business advisor, project business architect, solution IT architect, process designer, system requirements analyst, lead developer, developer, test manager, asset owner, ...  ", competenceLevels_SA_16 );
		try {
			competenceFacade.save(competenceBo_SA_16);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_17 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_17.add (new CompetenceLevelBo(" ik doe wat ik denk dat nodig is. Ik gebruik daarvoor geen referentiemateriaal of templates.", 1));
		competenceLevels_SA_17.add (new CompetenceLevelBo(" ik gebruik in projecten bijna steeds dezelde templates of deliverables, als die al nodig zijn. Ik weet waar ik die kan vinden, en zoek verder nooit naar iets extra.", 2));
		competenceLevels_SA_17.add (new CompetenceLevelBo(" ik weet wat ik als basis op te leveren heb in een project, maar ik ga toch nu en dan eens zoeken op de PCLC site (of andere site). Ik weet graag of er een update is, of een mogelijk andere techniek die me beter kan helpen", 3));
		competenceLevels_SA_17.add (new CompetenceLevelBo(" ik neem steevast de PCLC-lijst met deliverables erbij, zodat ik ten alle tijde weet welke types deliverables en templates ik kan gebruiken. Want afhankelijk van de solution, kunnen andere templates of methodieken me zeker beter helpen.", 4));


		CompetenceBo competenceBo_SA_17 = new CompetenceBo ("Activiteiten en deliverables", "Uitleg: Rollen voeren specifieke activiteiten uit. En heel vaak wordt er ook informatie verzameld of aangevuld, en daarvoor is er vaak een template ter beschikking. Alle uitleg over die activiteiten en die deliverables vind je op de PCLC-site.  ", competenceLevels_SA_17 );
		try {
			competenceFacade.save(competenceBo_SA_17);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_18 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_18.add (new CompetenceLevelBo(" Ik heb nog nooit of zeer zelden een MAW meegemaakt. Ik zie ook de meerwaarde niet goed.", 1));
		competenceLevels_SA_18.add (new CompetenceLevelBo(" Ik begrijp en zie de meerwaarde van een MAW, maar er worden er te weinig georganiseerd op project(en) waar ik deel van uitmaak", 2));
		competenceLevels_SA_18.add (new CompetenceLevelBo(" MAW's worden geregeld ingepland, maar de kwaliteit ervan kan zeker nog beter", 3));
		competenceLevels_SA_18.add (new CompetenceLevelBo(" MAW's worden geregeld ingepland, en ook de meerwaarde ervan is meteen duidelijk. Kwaliteit is voldoende.", 4));
		competenceLevels_SA_18.add (new CompetenceLevelBo(" ik zorg er zelf voor dat MAW's ingepland raken, zelfs al ben ik de PM niet, want ze zijn onotbeerlijk voor het goede verloop van elk project. ", 5));


		CompetenceBo competenceBo_SA_18 = new CompetenceBo ("MAW's", "Uitleg: Een Method Adoption Workshop dient om voor elke projectstap of elk workpackage af te spreken wat er nodig is binnen deze projectopdracht, wie die rol zal opnemen en welke deliverables die zal opleveren. Zo weet iedereen wat die van wie mag verwachten.   ", competenceLevels_SA_18 );
		try {
			competenceFacade.save(competenceBo_SA_18);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_19 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_19.add (new CompetenceLevelBo(" ik heb geen idee waar ik terecht kan als ik vragen heb, tenzij bij mijn chef dan. Ik trek mijn plan op mijn eentje.", 1));
		competenceLevels_SA_19.add (new CompetenceLevelBo(" als ik hulp zou nodig hebben, dan ga ik te rade bij collega's (die dezelfde rol opnemen) die me kunnen helpen", 2));
		competenceLevels_SA_19.add (new CompetenceLevelBo(" ik weet waar ik terecht kan voor hulp, en ik schakel die in of zou die inschakelen wanneer ik dat nodig vind", 3));
		competenceLevels_SA_19.add (new CompetenceLevelBo(" ik ben een referentie voor collega's en stuur hen door naar de site of naar key user(s), of maak er toch reclame voor, als zij met vragen komen. Kwestie dat ook zij de hulpbronnen leren kennen.", 4));


		CompetenceBo competenceBo_SA_19 = new CompetenceBo ("Ondersteunend materiaal & support", "Uitleg: Er is een PCLC site waarop alle info rond de 'Realize a solution'-stappen, rollen, activiteiten, deliverables en templates gecentraliseerd staat. Daarnaast zijn er nog CoE coördinatoren en key users die per discipline ondersteuning en coaching kunnen geven bij het uitoefenen van je rol.  ", competenceLevels_SA_19 );
		try {
			competenceFacade.save(competenceBo_SA_19);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_SA_22 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_22.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_22.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_22.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_22.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_22 = new CompetenceBo ("Skilled level", "", competenceLevels_SA_22 );
		try {
			competenceFacade.save(competenceBo_SA_22);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_23 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_23.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_23.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_23.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_23.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_23 = new CompetenceBo ("Business process design (skilled)", "ik kan het ... ...  ASIS proces in kaart brengen en beschrijven op het niveau van een werkproces en -methode … geoptimaliseerd proces designen en in BPMN beschrijven, op het niveau van een werkproces en -methode … security business rollen in het AS IS en  TO BE proces identificeren en beschrijven  ", competenceLevels_SA_23 );
		try {
			competenceFacade.save(competenceBo_SA_23);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_24 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_24.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_24.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_24.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_24.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_24 = new CompetenceBo ("Knelpuntanalyse (skilled) ", "ik kan … … verschillende technieken hanteren om een knelpuntanalyse uit te voeren op het proces, en zo de mogelijke optimaliisaties te identificeren … op een effectieve manier middelen inzetten om de relevante informatie te kwantificeren ", competenceLevels_SA_24 );
		try {
			competenceFacade.save(competenceBo_SA_24);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_25 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_25.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_25.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_25.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_25.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_25 = new CompetenceBo ("User Requirements capteren", "ik ... ... kan user requirements capteren en hanteer hiervoor verschillende technieken afgestemd op mijn betrokken stakeholders ... stel hierin de user (oa. eindgebruiker, klant, ...) centraal  ", competenceLevels_SA_25 );
		try {
			competenceFacade.save(competenceBo_SA_25);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_26 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_26.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_26.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_26.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_26.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_26 = new CompetenceBo ("User Requirements lifecycle management", "ik kan user requirements en selectiecriteria beheren (als een continu proces), uitlijsten, prioriteren en laten valideren ", competenceLevels_SA_26 );
		try {
			competenceFacade.save(competenceBo_SA_26);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_27 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_27.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_27.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_27.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_27.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_27 = new CompetenceBo ("Informatieanalyse ", "Ik kan ... ... de informatie objecten die gebruikt worden binnen de organisatie, hun relaties en regels beschrijven en specifieren voor zowel de AS IS als TO BE situatie ... op basis van deze informatie objecten een informatiemodel (incl. atrributen) en logisch datamodel opstellen (voor zowel AS IS als TO BE situatie) in UML notatie ", competenceLevels_SA_27 );
		try {
			competenceFacade.save(competenceBo_SA_27);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_28 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_28.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_28.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_28.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_28.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_28 = new CompetenceBo ("Identificatie & specificatie functionaliteiten", "ik kan … … functionaliteiten van een systeem (oa. IT oplossing, machine, materiaal,...) identificeren en specifieren voor zowel de AS IS als TO BE situatie in UML notatie ... de IT rollen identificeren en specifieren ", competenceLevels_SA_28 );
		try {
			competenceFacade.save(competenceBo_SA_28);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_29 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_29.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_29.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_29.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_29.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_29 = new CompetenceBo ("Identificatie & specificatie Non-Functional Requirements (NFR)", "ik kan … … niet-functionele requirements identificeren en beschrijven op niveau van de solution (= proces + systeem) ", competenceLevels_SA_29 );
		try {
			competenceFacade.save(competenceBo_SA_29);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_30 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_30.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_30.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_30.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_30.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_30 = new CompetenceBo ("Identificeren alternatieve oplossingsmogelijkheden", "ik kan … … vertrekkende uit het probleem meerdere oplossingen identifieren binnen de gekozen solution … deze ten opzichte van elkaar afwegen en hierrond een advies uitspreken ", competenceLevels_SA_30 );
		try {
			competenceFacade.save(competenceBo_SA_30);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_31 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_31.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_31.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_31.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_31.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_31 = new CompetenceBo ("Implementeren solution", "ik kan … … ondersteuning bieden aan business om de uitgewerkte solution in gebruik te nemen ", competenceLevels_SA_31 );
		try {
			competenceFacade.save(competenceBo_SA_31);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_32 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_32.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_32.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_32.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_32.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_32 = new CompetenceBo ("Opstellen permanente documentatie voor support & contin.doeleinden", "ik kan … … permanente documentatie opleveren en borgen om operationele support en continuiteit te garanderen", competenceLevels_SA_32 );
		try {
			competenceFacade.save(competenceBo_SA_32);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_33 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_33.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_33.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_33.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_33.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_33 = new CompetenceBo ("Opstellen permanente documentatie voor business users", "ik kan … … permanente documentatie opleveren dat kan overgedragen worden naar business, ifv hun behoeften (bv. ifv end user training, etc).", competenceLevels_SA_33 );
		try {
			competenceFacade.save(competenceBo_SA_33);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_34 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_34.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_34.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_34.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_34.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_34 = new CompetenceBo ("Advanced/niche level", "", competenceLevels_SA_34 );
		try {
			competenceFacade.save(competenceBo_SA_34);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_35 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_35.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_35.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_35.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_35.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_35 = new CompetenceBo ("Specifieren van applicatie services (SOA) ", "ik kan … ...de requirements opstellen voor integraties tussen twee systemen ... de interface die afgenomen zal worden specifiëren aan de hand van een Logical Message Model, functionele operations & non functional requirements alsook het functionele design uitschrijven van de applicatie service zelf", competenceLevels_SA_35 );
		try {
			competenceFacade.save(competenceBo_SA_35);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_36 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_36.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_36.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_36.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_36.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_36 = new CompetenceBo ("Aankoopproces externe solution toepassen ", "Ik ken het aankoopproces voor een externe solution  Ik kan mijn rol hierin opnemen (oa. kennis RFI, RFP, RFQ, rol aankoper, etc)", competenceLevels_SA_36 );
		try {
			competenceFacade.save(competenceBo_SA_36);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_37 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_37.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_37.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_37.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_37.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_37 = new CompetenceBo ("Samenwerkingsmodel T&I - BP&S toepassen ", "Ik ken het samenwerkingsmodel T&I-BP&S, alsook de verschillende rollen in dit procesen   Ik kan kan mijn rol(len) hierin opnemen ", competenceLevels_SA_37 );
		try {
			competenceFacade.save(competenceBo_SA_37);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_38 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_38.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_38.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_38.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_38.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_38 = new CompetenceBo ("SRA ifv softwarepaketten ", "Ik kan... ... een functionele analyse uitvoeren in de context van een pakket implementatie  ...op basis hiervan scoring criteria definieren en scores toekennen  ", competenceLevels_SA_38 );
		try {
			competenceFacade.save(competenceBo_SA_38);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_39 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_39.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_39.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_39.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_39.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_39 = new CompetenceBo ("Layoutstudies", "Ik kan… … fysische processen uitwerken en beschrijven … deze fysische processen vertalen naar een optimale layouttekening in autocad … obv deze layouttekening een PVE (Plan Van Eisen) opstellen waarmee het bouwteam de layout kan realiseren. ", competenceLevels_SA_39 );
		try {
			competenceFacade.save(competenceBo_SA_39);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_40 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_40.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_40.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_40.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_40.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_40 = new CompetenceBo ("werkpoststudie", "Ik kan… … een werkpostanalyse uitvoeren … obv deze analyse een ergonomische en optimale werkpost uitwerken en implementeren", competenceLevels_SA_40 );
		try {
			competenceFacade.save(competenceBo_SA_40);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_41 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_41.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_41.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_41.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_41.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_41 = new CompetenceBo ("tijdsmeting", "Ik kan… … de juiste techniek bepalen om een tijdsmeting uit te voeren … deze techniek uitvoeren … de resultaten van de tijdsmeting analyseren en aan de hand hiervan normtijden bepalen en verliezen detecteren ", competenceLevels_SA_41 );
		try {
			competenceFacade.save(competenceBo_SA_41);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_42 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_42.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_42.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_42.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_42.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_42 = new CompetenceBo ("3 groene lichten rond risicobeheersing", "Ik kan de procedure '3 groene lichten' voor machineveiligheid toepassen", competenceLevels_SA_42 );
		try {
			competenceFacade.save(competenceBo_SA_42);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_43 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_43.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_43.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_43.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_43.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_43 = new CompetenceBo ("Investeringsberekeningen / DCF   ", "Ik ken  … de begrippen die een rol spelen bij investeringsberkeningen en kan deze toelichten … ken de governance en goedkeuringsprincipes voor het budgetberekeningsproces  Ik kan … de opdrachtgever van een project ondersteunen en adviseren in het opstellen van een realistische en betrouwbare inversteringsberekening", competenceLevels_SA_43 );
		try {
			competenceFacade.save(competenceBo_SA_43);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_SA_46 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_46.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_46.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_46.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_46.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_46 = new CompetenceBo ("Drivers & Goals", "Ik kan de WHY van business solutions scherpstellen aan de hand van drivers & goals die oplossingsonafhankelijk zijn.", competenceLevels_SA_46 );
		try {
			competenceFacade.save(competenceBo_SA_46);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_47 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_47.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_47.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_47.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_47.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_47 = new CompetenceBo ("Business requirements", "Ik kan de high level business requirements die relevant zijn tijdens de uitwerking van de Goal Tree capteren en identificeren.", competenceLevels_SA_47 );
		try {
			competenceFacade.save(competenceBo_SA_47);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_48 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_48.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_48.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_48.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_48.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_48 = new CompetenceBo ("Impacted business", "Ik kan, op basis van de bestaande referentie- of landschapsmodellen die aangereikt worden binnen Colruyt Group en de eigen domeinkennis, de scope en impact van business solutions scherpstellen.", competenceLevels_SA_48 );
		try {
			competenceFacade.save(competenceBo_SA_48);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_49 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_49.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_49.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_49.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_49.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_49 = new CompetenceBo ("Budgetten", "Ik kan mijn Business Partner(S) ondersteunen in het verscherpen van de mogelijke opbrengsten die door het realiseren van business solutions zullen verzilverd worden. ", competenceLevels_SA_49 );
		try {
			competenceFacade.save(competenceBo_SA_49);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_50 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_50.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_50.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_50.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_50.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_50 = new CompetenceBo ("Strategisch kader & Missie", "Ik ken en begrijp het strategisch kader en de missie van de Business Partner(S) zodat ik hen, bij het realiseren van hun strategie, kan ondersteunen in het kiezen van de juiste business solutions.  ", competenceLevels_SA_50 );
		try {
			competenceFacade.save(competenceBo_SA_50);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_51 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_51.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_51.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_51.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_51.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_51 = new CompetenceBo ("Organisatiemodel", "Ik ken en begrijp het organisatiemodel van de Business Partner(S) zodat ik hen, bij het realiseren van hun strategie, kan ondersteunen in het kiezen van de juiste business solutions.  ", competenceLevels_SA_51 );
		try {
			competenceFacade.save(competenceBo_SA_51);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_52 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_52.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_52.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_52.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_52.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_52 = new CompetenceBo ("Referentie- en landschapsmodellen", "Ik ken en begrijp de bestaande referentie- en landschapsmodellen van de Colruyt Group en de Business Partner(S), zodat ik de Business Partner(S), bij het realiseren van hun strategie, kan ondersteunen in het kiezen van de juiste business solutions. ", competenceLevels_SA_52 );
		try {
			competenceFacade.save(competenceBo_SA_52);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_53 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_53.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_53.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_53.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_53.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_53 = new CompetenceBo ("Colruyt Group Glossary", "Ik ken en begrijp de Colruyt Group glossary zodat ik deze kan gebruiken bij het definieren van business objecten en de glossary up to date kan houden in samenwerking met het VAKcentrum Informatie. ", competenceLevels_SA_53 );
		try {
			competenceFacade.save(competenceBo_SA_53);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_54 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_54.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_54.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_54.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_54.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_54 = new CompetenceBo ("Processen", "Ik ken en begrijp de ketenprocessen, bedrijfsprocessen, werkprocessen zodat ik de Business Partner(S), bij het realiseren van hun strategie, kan ondersteunen in het kiezen van de juiste business solutions.  ", competenceLevels_SA_54 );
		try {
			competenceFacade.save(competenceBo_SA_54);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_55 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_55.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_55.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_55.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_55.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_55 = new CompetenceBo ("Business services", "Ik ken en begrijp de business services van de Business Partner(S) zodat ik hen, bij het realiseren van hun strategie, kan ondersteunen in het kiezen van de juiste business solutions.  ", competenceLevels_SA_55 );
		try {
			competenceFacade.save(competenceBo_SA_55);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_SA_58 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_58.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_58.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_58.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_58.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_58 = new CompetenceBo ("Scope definitie", "Ik kan de scope van een project bepalen", competenceLevels_SA_58 );
		try {
			competenceFacade.save(competenceBo_SA_58);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_59 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_59.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_59.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_59.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_59.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_59 = new CompetenceBo ("Scope control", "Ik kan de scope van een project opvolgen en waar nodig change requests (laten) bepalen", competenceLevels_SA_59 );
		try {
			competenceFacade.save(competenceBo_SA_59);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_60 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_60.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_60.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_60.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_60.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_60 = new CompetenceBo ("Tijd", "Ik kan ervoor zorgen dat een project realististische tijdschattingen heeft", competenceLevels_SA_60 );
		try {
			competenceFacade.save(competenceBo_SA_60);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_61 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_61.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_61.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_61.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_61.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_61 = new CompetenceBo ("Kost", "Ik kan ervoor zorgen dat een project een realistische kosteninschatting heeft", competenceLevels_SA_61 );
		try {
			competenceFacade.save(competenceBo_SA_61);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_62 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_62.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_62.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_62.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_62.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_62 = new CompetenceBo ("Risico", "Ik kan risico management toepassen op maat van het project", competenceLevels_SA_62 );
		try {
			competenceFacade.save(competenceBo_SA_62);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_63 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_63.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_63.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_63.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_63.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_63 = new CompetenceBo ("Projectblad", "Ik kan een projectblad opstellen en up to date houden", competenceLevels_SA_63 );
		try {
			competenceFacade.save(competenceBo_SA_63);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_64 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_64.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_64.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_64.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_64.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_64 = new CompetenceBo ("Change control", "Ik kan wijzigingen tov de baseline bepalen en ook de impact van wijzigingen op de baseline, inclusief het verrichten van een re-baseline ", competenceLevels_SA_64 );
		try {
			competenceFacade.save(competenceBo_SA_64);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_SA_67 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_67.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_67.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_67.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_67.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_67 = new CompetenceBo ("Incident Handling Ombuds", "I can handle/process any incident for which I become 'owner' during its lifecycle in a correct way, in line with the applicable SLA/SLE and priority, in cooperation with other support lines (1st line, expert teams), using the Incident-tool. If needed I can launch an candidate problem.", competenceLevels_SA_67 );
		try {
			competenceFacade.save(competenceBo_SA_67);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_68 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_68.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_68.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_68.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_68.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_68 = new CompetenceBo ("Incident Handling OnCall", "I can handle/process any incident for which I become 'owner' in an OnCall situation in a correct way, in line with the applicable SLA/SLE and priorities, in cooperation with other support lines (1st line, experts), by making sure there is a temporary fix.", competenceLevels_SA_68 );
		try {
			competenceFacade.save(competenceBo_SA_68);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_69 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_69.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_69.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_69.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_69.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_69 = new CompetenceBo ("Disaster Handling", "I can play my role when involved in a disaster situation in a correct way (process), in line with the applicable SLA/SLE and priority, in cooperation with the disaster coördinator/team and other support lines (1st line, expert teams), using the default disaster tools (73111, AdobeConnect,...) ", competenceLevels_SA_69 );
		try {
			competenceFacade.save(competenceBo_SA_69);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_70 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_70.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_70.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_70.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_70.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_70 = new CompetenceBo ("Emergency Fixes", "I can define, validate and implement a workaround or quick (temporary)  solution (data manipulation, source code adaptation,…) directly in production for an incident that needs a solution, in order to make sure that our PartnerS's processes can run further, using the extra means provided (super userids, emergency paths,...). That means I can also assess the impact of my actions/intervention for my PartnerS' processes and systems. ", competenceLevels_SA_70 );
		try {
			competenceFacade.save(competenceBo_SA_70);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_71 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_71.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_71.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_71.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_71.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_71 = new CompetenceBo ("Knowledge Management", "I can use the supporting documentation available in different sources (Solution, Archives,…) and I can strengthen them and keep them up-to-date. ", competenceLevels_SA_71 );
		try {
			competenceFacade.save(competenceBo_SA_71);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_SA_74 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_74.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_SA_74.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_SA_74.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_SA_74.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_SA_74 = new CompetenceBo ("Test Specialist", "", competenceLevels_SA_74 );
		try {
			competenceFacade.save(competenceBo_SA_74);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}











		HashSet<CompetenceLevelBo> competenceLevels_SA_86 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_86 = new CompetenceBo ("BPMN", "", competenceLevels_SA_86 );
		try {
			competenceFacade.save(competenceBo_SA_86);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_87 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_87 = new CompetenceBo ("UML", "", competenceLevels_SA_87 );
		try {
			competenceFacade.save(competenceBo_SA_87);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_88 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_88 = new CompetenceBo ("Autocad", "", competenceLevels_SA_88 );
		try {
			competenceFacade.save(competenceBo_SA_88);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_89 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_89 = new CompetenceBo ("Mega", "", competenceLevels_SA_89 );
		try {
			competenceFacade.save(competenceBo_SA_89);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_SA_92 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_92.add (new CompetenceLevelBo(" kent de waarden en missie.", 1));
		competenceLevels_SA_92.add (new CompetenceLevelBo(" werkt conform de waarden en missie.", 2));
		competenceLevels_SA_92.add (new CompetenceLevelBo(" volgt gedrag van anderen op dat niet overeenstemt met waarden en missie.", 3));
		competenceLevels_SA_92.add (new CompetenceLevelBo(" bewaakt en verduidelijkt de toepassing van de waarden en missie.", 4));
		competenceLevels_SA_92.add (new CompetenceLevelBo(" koppelt de bedrijfswaarden en missie aan elke boodschap en beslissing.", 5));


		CompetenceBo competenceBo_SA_92 = new CompetenceBo ("Ondernemingsbetrokkenheid", "Definitie:  Zich verbonden tonen met de missie en waarden van de onderneming, hierover verbinding creëren bij anderen en ervoor zorgen dat gedrag hiermee overeenstemt.  ", competenceLevels_SA_92 );
		try {
			competenceFacade.save(competenceBo_SA_92);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_93 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_93.add (new CompetenceLevelBo(" verwerkt een beperkte hoeveelheid eenvoudige gegevens.", 1));
		competenceLevels_SA_93.add (new CompetenceLevelBo(" onderscheidt in een hoeveelheid gegevens verschillende deelaspecten.", 2));
		competenceLevels_SA_93.add (new CompetenceLevelBo(" legt eenvoudige verbanden tussen verschillende gegevens.", 3));
		competenceLevels_SA_93.add (new CompetenceLevelBo(" analyseert de verbanden tussen de verschillende onderdelen van een complex gegeven.", 4));
		competenceLevels_SA_93.add (new CompetenceLevelBo(" komt vanuit een complex gegeven tot duidelijke criteria voor het maken van een synthese.", 5));


		CompetenceBo competenceBo_SA_93 = new CompetenceBo ("Analytisch vermogen", "Definitie:  De capaciteit om (complexe) problemen, processen en projecten op te splitsen in samenstellende delen, de onderliggende verbanden op een systematische manier te analyseren en duidelijke criteria te ontwikkelen voor het vormen van een beeld.  ", competenceLevels_SA_93 );
		try {
			competenceFacade.save(competenceBo_SA_93);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_94 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_94.add (new CompetenceLevelBo(" reageert op vragen van klanten volgens bestaande dienstverlening en service.", 1));
		competenceLevels_SA_94.add (new CompetenceLevelBo(" luistert naar klantennoden en behandelt deze.", 2));
		competenceLevels_SA_94.add (new CompetenceLevelBo(" overlegt en stemt af met de klant over de gewenste diensten/producten.", 3));
		competenceLevels_SA_94.add (new CompetenceLevelBo(" gaat actief op zoek bij anderen om dienstverlening en producten te optimaliseren.", 4));
		competenceLevels_SA_94.add (new CompetenceLevelBo(" speelt proactief in op noden en verwachtingen en bouwt aan een duurzame klantenrelatie.", 5));


		CompetenceBo competenceBo_SA_94 = new CompetenceBo ("Klantgerichtheid", "Defintie: Het vermogen om actief op zoek te gaan naar en in te spelen op diensten en producten die een toegevoegde waarde hebben voor anderen (interne en externe klanten, collega's, partners,…).  ", competenceLevels_SA_94 );
		try {
			competenceFacade.save(competenceBo_SA_94);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_95 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_95.add (new CompetenceLevelBo(" brengt eenvoudige boodschappen op een gestructureerde manier.", 1));
		competenceLevels_SA_95.add (new CompetenceLevelBo(" luistert naar zijn/haar publiek en beantwoordt vragen.", 2));
		competenceLevels_SA_95.add (new CompetenceLevelBo(" brengt een complexe boodschap op een rechtstreekse, aangepaste manier naar het doelpubliek.", 3));
		competenceLevels_SA_95.add (new CompetenceLevelBo(" toetst actief af of de boodschap door iedereen begrepen is en herformuleert.", 4));
		competenceLevels_SA_95.add (new CompetenceLevelBo(" beargumenteert zijn/haar boodschap beheerst en brengt de verschillende meningen terug tot de kern.", 5));


		CompetenceBo competenceBo_SA_95 = new CompetenceBo ("Communicatief vermogen", "Defintiie:  Het vermogen om op een directe, rechtstreeks en interactieve manier een boodschap (over) te brengen.  ", competenceLevels_SA_95 );
		try {
			competenceFacade.save(competenceBo_SA_95);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_96 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_96.add (new CompetenceLevelBo(" benadert situaties vanuit opportuniteit.", 1));
		competenceLevels_SA_96.add (new CompetenceLevelBo(" brengt een boodschap op authentieke, enthousiaste manier en beantwoordt vragen vanuit opportuniteit.", 2));
		competenceLevels_SA_96.add (new CompetenceLevelBo(" luistert actief naar vragen, zorgen en noden en zorgt voor een werkbare context.", 3));
		competenceLevels_SA_96.add (new CompetenceLevelBo(" hanteert gepaste overtuigingstechnieken en vraagstelling zodat iedereen de toegevoegde waarde voor zichzelf ontdekt.", 4));
		competenceLevels_SA_96.add (new CompetenceLevelBo(" blijft actief peilen naar enthousiasme en engagement bij anderen en anticipeert hierop.", 5));


		CompetenceBo competenceBo_SA_96 = new CompetenceBo ("Energie mobiliseren", "Definitie:  Op een authentieken manier enthousiasme en engagement rond een doel of project verkrijgen door zelf enthousiasme uit te stralen, iedereen de toegevoegde waarde te laten ontdekken en een werkbare context te creëren.  ", competenceLevels_SA_96 );
		try {
			competenceFacade.save(competenceBo_SA_96);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_97 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_97.add (new CompetenceLevelBo(" staat open voor feedback.", 1));
		competenceLevels_SA_97.add (new CompetenceLevelBo(" staat stil bij het eigen gedrag en functioneren.", 2));
		competenceLevels_SA_97.add (new CompetenceLevelBo(" onderneemt stappen om zich verder te ontwikkelen op het vlak van kennis en vaardigheden.", 3));
		competenceLevels_SA_97.add (new CompetenceLevelBo(" gaat actief op zoek naar mogelijkheden om de eigen overtuigingen, patronen en persoonlijkheid verder te ontwikkelen.", 4));
		competenceLevels_SA_97.add (new CompetenceLevelBo(" integreert het geleerde en het opgedane vakmanschap in zijn/haar gehele functioneren.", 5));


		CompetenceBo competenceBo_SA_97 = new CompetenceBo ("Zelfontplooiing", "Definitie:  Inzicht verwerven in zichzelf en op basis hiervan bewust stappen ondernemen om verder te ontwikkelen.  ", competenceLevels_SA_97 );
		try {
			competenceFacade.save(competenceBo_SA_97);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_98 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_98.add (new CompetenceLevelBo(" neemt niet controversiële beslissingen.", 1));
		competenceLevels_SA_98.add (new CompetenceLevelBo(" durft beslissingen nemen die een beperkt risico inhouden over eenvoudige materie.", 2));
		competenceLevels_SA_98.add (new CompetenceLevelBo(" neemt beslissingen met impact op anderen.", 3));
		competenceLevels_SA_98.add (new CompetenceLevelBo(" neemt beslissingen over complexe materie.", 4));
		competenceLevels_SA_98.add (new CompetenceLevelBo(" neemt beslissingen over complexe materie met brede impact.", 5));


		CompetenceBo competenceBo_SA_98 = new CompetenceBo ("Beslissen", "Definitie:  De capaciteit en bereidheid om je handen te durven vuilmaken door het uitspreken van een bepaald standpunt of beslissing, ondanks onvolledige kennis van het gegeven of van de risico's.  ", competenceLevels_SA_98 );
		try {
			competenceFacade.save(competenceBo_SA_98);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_99 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_99.add (new CompetenceLevelBo(" doet wat van hem/haar gevraagd wordt.", 1));
		competenceLevels_SA_99.add (new CompetenceLevelBo(" zet door en grijpt in wanneer niet alles naar wens verloopt.", 2));
		competenceLevels_SA_99.add (new CompetenceLevelBo(" definieert eigen prestatieniveaus en stuurt anderen bij.", 3));
		competenceLevels_SA_99.add (new CompetenceLevelBo(" formuleert naar anderen duidelijke criteria waarbinnen gewerkt moet worden.", 4));
		competenceLevels_SA_99.add (new CompetenceLevelBo(" definieert uitdagende doelstellingen.", 5));


		CompetenceBo competenceBo_SA_99 = new CompetenceBo ("Doelgerichtheid", "Definitie: Het doorzettingsvermogen om goed werk af te leveren en doelstellingen te behalen.  ", competenceLevels_SA_99 );
		try {
			competenceFacade.save(competenceBo_SA_99);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_100 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_100 = new CompetenceBo ("Aanpassingsvermogen", "", competenceLevels_SA_100 );
		try {
			competenceFacade.save(competenceBo_SA_100);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_101 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_101 = new CompetenceBo ("Probleemoplossend vermogen", "", competenceLevels_SA_101 );
		try {
			competenceFacade.save(competenceBo_SA_101);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_102 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SA_102.add (new CompetenceLevelBo(" observeert een gegeven uit zijn/haar omgeving naar aanleiding van een concrete vraag, probleem.", 1));
		competenceLevels_SA_102.add (new CompetenceLevelBo(" voorziet tijd om te observeren en te evalueren wat er in zijn/haar eigen leefwereld, werkomgeving gebeurt.", 2));
		competenceLevels_SA_102.add (new CompetenceLevelBo(" onderzoekt continu de eigen leefwereld vanuit verschillende perspectieven.", 3));
		competenceLevels_SA_102.add (new CompetenceLevelBo(" denkt 'out of the box' en durft te experimenteren met vernieuwende ideeën of concepten.", 4));
		competenceLevels_SA_102.add (new CompetenceLevelBo(" daagt anderen uit om buiten de klassieke wegen en patronen te denken.", 5));


		CompetenceBo competenceBo_SA_102 = new CompetenceBo ("Vernieuwingsgerichtheid", "Definitie:  Met een onderzoekende en nieuwsgierige geest op zoek gaan naar en openstaan voor impulsen, ideeën of gegevens uit de interne en externe wereld.  ", competenceLevels_SA_102 );
		try {
			competenceFacade.save(competenceBo_SA_102);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_SA_105 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_105 = new CompetenceBo ("Strategy & Change: Strategy Definition & Governance", "", competenceLevels_SA_105 );
		try {
			competenceFacade.save(competenceBo_SA_105);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_106 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_106 = new CompetenceBo ("Strategy & Change: Business Change Mgmt", "", competenceLevels_SA_106 );
		try {
			competenceFacade.save(competenceBo_SA_106);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_107 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_107 = new CompetenceBo ("Resource Planning: Strategic Resource Planning", "", competenceLevels_SA_107 );
		try {
			competenceFacade.save(competenceBo_SA_107);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_108 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_108 = new CompetenceBo ("Risk & Compliance: Risk & Compliance Mgmt", "", competenceLevels_SA_108 );
		try {
			competenceFacade.save(competenceBo_SA_108);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_109 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_109 = new CompetenceBo ("Market Watch", "", competenceLevels_SA_109 );
		try {
			competenceFacade.save(competenceBo_SA_109);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_110 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_110 = new CompetenceBo ("Performance Watch", "", competenceLevels_SA_110 );
		try {
			competenceFacade.save(competenceBo_SA_110);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_111 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_111 = new CompetenceBo ("Sustainability Mgmt", "", competenceLevels_SA_111 );
		try {
			competenceFacade.save(competenceBo_SA_111);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_112 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_112 = new CompetenceBo ("Innovation: R&D & Innovation", "", competenceLevels_SA_112 );
		try {
			competenceFacade.save(competenceBo_SA_112);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_113 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_113 = new CompetenceBo ("Stakeholder Relations & Reputation: Stakeholder Relations & Reputation Mgmt", "", competenceLevels_SA_113 );
		try {
			competenceFacade.save(competenceBo_SA_113);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_114 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_114 = new CompetenceBo ("Stakeholder Relations & Reputation: Public Relations Mgmt", "", competenceLevels_SA_114 );
		try {
			competenceFacade.save(competenceBo_SA_114);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_115 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_115 = new CompetenceBo ("Stakeholder Relations & Reputation: Party Mgmt", "", competenceLevels_SA_115 );
		try {
			competenceFacade.save(competenceBo_SA_115);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_116 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_116 = new CompetenceBo ("Communication & Collaboration: Commication & Collaboration", "", competenceLevels_SA_116 );
		try {
			competenceFacade.save(competenceBo_SA_116);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_117 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_117 = new CompetenceBo ("Communication & Collaboration: Workplace Mgmt", "", competenceLevels_SA_117 );
		try {
			competenceFacade.save(competenceBo_SA_117);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_118 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_118 = new CompetenceBo ("Digital: Digitalisation Mgmt", "", competenceLevels_SA_118 );
		try {
			competenceFacade.save(competenceBo_SA_118);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_119 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_119 = new CompetenceBo ("Service, Process & Organisation: Organisation Mgmt", "", competenceLevels_SA_119 );
		try {
			competenceFacade.save(competenceBo_SA_119);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_120 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_120 = new CompetenceBo ("Service, Process & Organisation: Process & Service Design", "", competenceLevels_SA_120 );
		try {
			competenceFacade.save(competenceBo_SA_120);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_121 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_121 = new CompetenceBo ("Service, Process & Organisation: Enterprise Service Mgmt", "", competenceLevels_SA_121 );
		try {
			competenceFacade.save(competenceBo_SA_121);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_122 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_122 = new CompetenceBo ("Information: Information Mgmt", "", competenceLevels_SA_122 );
		try {
			competenceFacade.save(competenceBo_SA_122);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_123 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_123 = new CompetenceBo ("Information: Content & Document Mgmt", "", competenceLevels_SA_123 );
		try {
			competenceFacade.save(competenceBo_SA_123);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_124 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_124 = new CompetenceBo ("Coworker: Co-worker Mgmt", "", competenceLevels_SA_124 );
		try {
			competenceFacade.save(competenceBo_SA_124);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_125 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_125 = new CompetenceBo ("Coworker: Training Mgmt", "", competenceLevels_SA_125 );
		try {
			competenceFacade.save(competenceBo_SA_125);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_126 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_126 = new CompetenceBo ("Infrastructure: Real Estate Mgmt", "", competenceLevels_SA_126 );
		try {
			competenceFacade.save(competenceBo_SA_126);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_127 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_127 = new CompetenceBo ("Infrastructure: Tanglible Asset Lifecycle Mgmt", "", competenceLevels_SA_127 );
		try {
			competenceFacade.save(competenceBo_SA_127);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_128 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_128 = new CompetenceBo ("Infrastructure: Facility & Field Service Mgmt", "", competenceLevels_SA_128 );
		try {
			competenceFacade.save(competenceBo_SA_128);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_129 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_129 = new CompetenceBo ("IT Infrasturcture & Solutions: ICT Mgmt", "", competenceLevels_SA_129 );
		try {
			competenceFacade.save(competenceBo_SA_129);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_130 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_130 = new CompetenceBo ("Brand, Customer, Marketingpromotion: (B2C) Marketing Promotion (BE)", "", competenceLevels_SA_130 );
		try {
			competenceFacade.save(competenceBo_SA_130);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_131 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_131 = new CompetenceBo ("Brand, Customer, Marketingpromotion: Brand Mgmt", "", competenceLevels_SA_131 );
		try {
			competenceFacade.save(competenceBo_SA_131);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_132 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_132 = new CompetenceBo ("Brand, Customer, Marketingpromotion: Customer Mgmt", "", competenceLevels_SA_132 );
		try {
			competenceFacade.save(competenceBo_SA_132);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_133 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_133 = new CompetenceBo ("Product: Product Mgmt", "", competenceLevels_SA_133 );
		try {
			competenceFacade.save(competenceBo_SA_133);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_134 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_134 = new CompetenceBo ("Procuct: Product Group Mgmt", "", competenceLevels_SA_134 );
		try {
			competenceFacade.save(competenceBo_SA_134);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_135 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_135 = new CompetenceBo ("Procuct: Product Information Mgmt", "", competenceLevels_SA_135 );
		try {
			competenceFacade.save(competenceBo_SA_135);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_136 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_136 = new CompetenceBo ("Purchasing Direct Goods: Direct Purchase Mgmt", "", competenceLevels_SA_136 );
		try {
			competenceFacade.save(competenceBo_SA_136);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_137 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_137 = new CompetenceBo ("Purchasing Direct Goods: Retail Product Costing", "", competenceLevels_SA_137 );
		try {
			competenceFacade.save(competenceBo_SA_137);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_138 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_138 = new CompetenceBo ("Purchasing Direct Goods: Purchase Operations Food", "", competenceLevels_SA_138 );
		try {
			competenceFacade.save(competenceBo_SA_138);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_139 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_139 = new CompetenceBo ("Purchasing Indirect Goods & Services: Indirect Purchasing", "", competenceLevels_SA_139 );
		try {
			competenceFacade.save(competenceBo_SA_139);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_140 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_140 = new CompetenceBo ("Purchasing Indirect Goods & Services: Indirect Product Information Mgmt", "", competenceLevels_SA_140 );
		try {
			competenceFacade.save(competenceBo_SA_140);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_141 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_141 = new CompetenceBo ("Purchasing Indirect Goods & Services: Internal Wholesale of Indirect Goods", "", competenceLevels_SA_141 );
		try {
			competenceFacade.save(competenceBo_SA_141);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_142 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_142 = new CompetenceBo ("Supplier: Supplier Mgmt", "", competenceLevels_SA_142 );
		try {
			competenceFacade.save(competenceBo_SA_142);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_143 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_143 = new CompetenceBo ("Supply Chain Food: Supply Chain Food", "", competenceLevels_SA_143 );
		try {
			competenceFacade.save(competenceBo_SA_143);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_144 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_144 = new CompetenceBo ("Supply Chain Food: Logistic Workforce Mgmt", "", competenceLevels_SA_144 );
		try {
			competenceFacade.save(competenceBo_SA_144);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_145 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_145 = new CompetenceBo ("Supply Chain Food: Sales Forecasting Food", "", competenceLevels_SA_145 );
		try {
			competenceFacade.save(competenceBo_SA_145);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_146 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_146 = new CompetenceBo ("E-Commerce Food: E-commerce B2C Food", "", competenceLevels_SA_146 );
		try {
			competenceFacade.save(competenceBo_SA_146);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_147 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_147 = new CompetenceBo ("E-Commerce Food: nonFood", "", competenceLevels_SA_147 );
		try {
			competenceFacade.save(competenceBo_SA_147);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_148 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_148 = new CompetenceBo ("Store Sales: Food Retail Store Sales", "", competenceLevels_SA_148 );
		try {
			competenceFacade.save(competenceBo_SA_148);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_149 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_149 = new CompetenceBo ("Store Sales: Store Workforce Mgmt", "", competenceLevels_SA_149 );
		try {
			competenceFacade.save(competenceBo_SA_149);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_150 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_150 = new CompetenceBo ("Price: B2C Price Mgmt", "", competenceLevels_SA_150 );
		try {
			competenceFacade.save(competenceBo_SA_150);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_SA_153 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_153 = new CompetenceBo ("Colruyt Laagste Prijs", "", competenceLevels_SA_153 );
		try {
			competenceFacade.save(competenceBo_SA_153);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_154 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_154 = new CompetenceBo ("OKay", "", competenceLevels_SA_154 );
		try {
			competenceFacade.save(competenceBo_SA_154);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_155 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_155 = new CompetenceBo ("Bio-Planet", "", competenceLevels_SA_155 );
		try {
			competenceFacade.save(competenceBo_SA_155);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_156 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_156 = new CompetenceBo ("CRU", "", competenceLevels_SA_156 );
		try {
			competenceFacade.save(competenceBo_SA_156);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_157 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_157 = new CompetenceBo ("Dreamland", "", competenceLevels_SA_157 );
		try {
			competenceFacade.save(competenceBo_SA_157);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_158 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_158 = new CompetenceBo ("Dreambaby", "", competenceLevels_SA_158 );
		try {
			competenceFacade.save(competenceBo_SA_158);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_159 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_159 = new CompetenceBo ("Collishop", "", competenceLevels_SA_159 );
		try {
			competenceFacade.save(competenceBo_SA_159);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_160 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_160 = new CompetenceBo ("Retail Partners Colruyt Group", "", competenceLevels_SA_160 );
		try {
			competenceFacade.save(competenceBo_SA_160);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_161 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_161 = new CompetenceBo ("Solucious", "", competenceLevels_SA_161 );
		try {
			competenceFacade.save(competenceBo_SA_161);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_162 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_162 = new CompetenceBo ("Colex", "", competenceLevels_SA_162 );
		try {
			competenceFacade.save(competenceBo_SA_162);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_163 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_163 = new CompetenceBo ("Dats 24", "", competenceLevels_SA_163 );
		try {
			competenceFacade.save(competenceBo_SA_163);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_164 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_164 = new CompetenceBo ("Collect & Go", "", competenceLevels_SA_164 );
		try {
			competenceFacade.save(competenceBo_SA_164);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_165 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_165 = new CompetenceBo ("Transport", "", competenceLevels_SA_165 );
		try {
			competenceFacade.save(competenceBo_SA_165);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_166 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_166 = new CompetenceBo ("Retail Service Center", "", competenceLevels_SA_166 );
		try {
			competenceFacade.save(competenceBo_SA_166);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_167 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_167 = new CompetenceBo ("Fine Food", "", competenceLevels_SA_167 );
		try {
			competenceFacade.save(competenceBo_SA_167);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_168 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_168 = new CompetenceBo ("In Cont@ct", "", competenceLevels_SA_168 );
		try {
			competenceFacade.save(competenceBo_SA_168);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_169 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_169 = new CompetenceBo ("BP&S", "", competenceLevels_SA_169 );
		try {
			competenceFacade.save(competenceBo_SA_169);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_170 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_170 = new CompetenceBo ("Finance", "", competenceLevels_SA_170 );
		try {
			competenceFacade.save(competenceBo_SA_170);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_171 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_171 = new CompetenceBo ("M&O", "", competenceLevels_SA_171 );
		try {
			competenceFacade.save(competenceBo_SA_171);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_172 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_172 = new CompetenceBo ("T&I", "", competenceLevels_SA_172 );
		try {
			competenceFacade.save(competenceBo_SA_172);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_173 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_173 = new CompetenceBo ("Colruyt Group Energy", "", competenceLevels_SA_173 );
		try {
			competenceFacade.save(competenceBo_SA_173);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_174 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_174 = new CompetenceBo ("CCX & Corporate Marketing", "° Symeta ° Premedia ° Corporate marketing", competenceLevels_SA_174 );
		try {
			competenceFacade.save(competenceBo_SA_174);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SA_175 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SA_175 = new CompetenceBo ("Corporate operating unit", "", competenceLevels_SA_175 );
		try {
			competenceFacade.save(competenceBo_SA_175);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


/** Filling the Business Architect **/

		HashSet<CompetenceLevelBo> competenceLevels_BA_34 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_34.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_34.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_34.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_34.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_34 = new CompetenceBo ("Drivers & Goals", "Ik kan de WHY van het project scherpstellen aan de hand van drivers en goals die oplossingsonafhankelijk zijn.", competenceLevels_BA_34 );
		try {
			competenceFacade.save(competenceBo_BA_34);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_35 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_35.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_35.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_35.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_35.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_35 = new CompetenceBo ("Business requirements", "Ik kan de business requirements duidelijk, volledig en ondubbelzinnig beschrijven en prioriteren, zodat de gewenste business solution past binnen de doelstellingen van het project en onduidelijkheden en/of tegenstrijdigheden in de business requirements uitgeklaard zijn.", competenceLevels_BA_35 );
		try {
			competenceFacade.save(competenceBo_BA_35);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_36 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_36.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_36.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_36.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_36.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_36 = new CompetenceBo ("Impacted business", "Ik kan business impact van de gekozen oplossing voor het project structureren en definiëren obv de bestaande programma business impact of de bestaande referentie- of landschapsmodellen die binnen Colruyt Group aangereikt worden.", competenceLevels_BA_36 );
		try {
			competenceFacade.save(competenceBo_BA_36);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_37 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_37.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_37.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_37.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_37.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_37 = new CompetenceBo ("Informatie", "Ik kan de informatie entiteiten die gebruikt (zullen) worden binnen de organisatie, hun relaties en de meest cruciale regels beschrijven (in de mega tool, gebruikmakende van de archimate notatie). ", competenceLevels_BA_37 );
		try {
			competenceFacade.save(competenceBo_BA_37);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_38 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_38.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_38.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_38.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_38.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_38 = new CompetenceBo ("Business Process", "Ik kan de ketenprocessen, bedrijfsprocessen en/of werkprocessen in scope van mijn project identificeren, modelleren (in de mega tool, gebruikmakende van de archimate notatie) en beschrijven. ", competenceLevels_BA_38 );
		try {
			competenceFacade.save(competenceBo_BA_38);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_39 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_39.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_39.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_39.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_39.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_39 = new CompetenceBo ("Business Services", "Ik kan de business service identificeren, duidelijk positioneren (in de mega tool, gebruikmakende van de archimate notatie) en beschrijven.  ", competenceLevels_BA_39 );
		try {
			competenceFacade.save(competenceBo_BA_39);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_40 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_40.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_40.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_40.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_40.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_40 = new CompetenceBo ("Business organisation", "Ik kan de organisatorische impact van het project identificeren, duidelijk positioneren en beschrijven. Dit doe ik in de archimate notatie wijze in de mega tool.", competenceLevels_BA_40 );
		try {
			competenceFacade.save(competenceBo_BA_40);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_41 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_41.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_41.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_41.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_41.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_41 = new CompetenceBo ("ICT services", "Ik kan de ICT Services die de business solution ondersteunen, expliciteren en ervoor zorgen dat er tijdens de definitiefase duidelijke afspraken gemaakt worden met ICT Service Management zodat het operationaliseren van de business & ICT solution in het verdere verloop van het project succesvol kan gebeuren. ", competenceLevels_BA_41 );
		try {
			competenceFacade.save(competenceBo_BA_41);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_42 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_42.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_42.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_42.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_42.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_42 = new CompetenceBo ("Solution assessment", "Ik kan verschillende mogelijke alternatieve oplossingen identificeren en deze op een objectieve manier beoordelen en beargumenteren bij mijn Business Partner(S). ", competenceLevels_BA_42 );
		try {
			competenceFacade.save(competenceBo_BA_42);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_43 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_43.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_43.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_43.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_43.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_43 = new CompetenceBo ("High level introduction plan", "Ik kan, in overleg met mijn Business Partner(S),een plan uitwerken om de oplossing te introduceren bij mijn Partner(S). ", competenceLevels_BA_43 );
		try {
			competenceFacade.save(competenceBo_BA_43);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_44 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_44.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_44.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_44.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_44.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_44 = new CompetenceBo ("Work packages ", "Ik kan, op basis van de 8 dimensies, mijn oplossing opsplitsen in project increments en hun onderlinge afhankelijkheden bepalen.  8 dimenties: ° uitrol strategie ° focus van de trajecten binnen je project aligneren ° aantal betrokken partijen / teams binnen het project ° externe afhankelijkheden en mijlpalen (area of concern) ° interne afhankelijkheden en mijlpalen (area of control) ° architectuur (business & IT) ° business meerwaarde ° complexiteit (functioneel en technisch)", competenceLevels_BA_44 );
		try {
			competenceFacade.save(competenceBo_BA_44);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_45 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_45.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_45.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_45.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_45.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_45 = new CompetenceBo ("Strategisch kader & Missie", "Ik ken en begrijp het strategisch kader en de missie van de Business Partner(S) zodat ik hen, bij het realiseren van hun strategie, kan ondersteunen in het kiezen van de juiste business solutions.  ", competenceLevels_BA_45 );
		try {
			competenceFacade.save(competenceBo_BA_45);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_46 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_46.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_46.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_46.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_46.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_46 = new CompetenceBo ("Organisatiemodel", "Ik ken en begrijp het organisatiemodel van de Business Partner(S) zodat ik hen, bij het realiseren van hun strategie, kan ondersteunen in het kiezen van de juiste business solutions.  ", competenceLevels_BA_46 );
		try {
			competenceFacade.save(competenceBo_BA_46);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_47 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_47.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_47.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_47.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_47.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_47 = new CompetenceBo ("Referentie- en landschapsmodellen", "Ik ken en begrijp de bestaande referentie- en landschapsmodellen van de Colruyt Group en de Business Partner(S), zodat ik de Business Partner(S), bij het realiseren van hun strategie, kan ondersteunen in het kiezen van de juiste business solutions. ", competenceLevels_BA_47 );
		try {
			competenceFacade.save(competenceBo_BA_47);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_48 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_48.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_48.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_48.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_48.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_48 = new CompetenceBo ("Colruyt Group Glossary", "Ik ken en begrijp de Colruyt Group glossary zodat ik deze kan gebruiken bij het definieren van business objecten en de glossary up to date kan houden in samenwerking met het VAKcentrum Informatie. ", competenceLevels_BA_48 );
		try {
			competenceFacade.save(competenceBo_BA_48);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_49 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_49.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_49.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_49.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_49.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_49 = new CompetenceBo ("Processen", "Ik ken en begrijp de ketenprocessen, bedrijfsprocessen, werkprocessen zodat ik de Business Partner(S), bij het realiseren van hun strategie, kan ondersteunen in het kiezen van de juiste business solutions.  ", competenceLevels_BA_49 );
		try {
			competenceFacade.save(competenceBo_BA_49);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_50 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_50.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_50.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_50.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_50.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_50 = new CompetenceBo ("Business services", "Ik ken en begrijp de business services van de Business Partner(S) zodat ik hen, bij het realiseren van hun strategie, kan ondersteunen in het kiezen van de juiste business solutions.  ", competenceLevels_BA_50 );
		try {
			competenceFacade.save(competenceBo_BA_50);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_BA_53 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_53.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_53.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_53.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_53.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_53 = new CompetenceBo ("Scope definitie", "Ik kan de scope van een project bepalen", competenceLevels_BA_53 );
		try {
			competenceFacade.save(competenceBo_BA_53);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_54 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_54.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_54.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_54.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_54.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_54 = new CompetenceBo ("Tijd", "Ik kan ervoor zorgen dat een project realististische tijdschattingen heeft", competenceLevels_BA_54 );
		try {
			competenceFacade.save(competenceBo_BA_54);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_55 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_55.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_55.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_55.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_55.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_55 = new CompetenceBo ("Kost", "Ik kan ervoor zorgen dat een project realistische kosteninschatting heeft", competenceLevels_BA_55 );
		try {
			competenceFacade.save(competenceBo_BA_55);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_56 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_56.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_56.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_56.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_56.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_56 = new CompetenceBo ("Risico", "Ik kan een initiële risico analyse verrichten op een project", competenceLevels_BA_56 );
		try {
			competenceFacade.save(competenceBo_BA_56);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_57 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_57.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_57.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_57.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_57.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_57 = new CompetenceBo ("Projectblad", "Ik kan een goed projectblad opstellen ", competenceLevels_BA_57 );
		try {
			competenceFacade.save(competenceBo_BA_57);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_BA_60 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_60.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_60.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_60.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_60.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_60 = new CompetenceBo ("Training ", "Ik kan op een (inter)actieve  manier  kennis en vaardigheden naar deelnemers in een training overbrengen (klassikaal, via webinar…).   Dit betekent ook dat ik de aandacht van de deelnemers doorheen de training vlot kan vasthouden, dat ik kan triggeren op de nodige interactie en ik me flexibel kan opstellen in functie van de noden van de deelnemers zonder het leerdoel uit het oog te verliezen.   Bovenstaande maakt ook dat ik aandacht heb voor de voorbereiding van de training.  Ik ben me bewust van de opbouw in een training (inleiding,  kennismaking, zingeving, inhoud, outro…) en de nood aan afwisseling qua leervormen doorheen de training (cfr. KOLB).  Op basis van de ervaring en feedback breng ik ook (kleine) aanpassingen aan aan het trainingsmateriaal en de aanpak om de training nog sterker te maken. ", competenceLevels_BA_60 );
		try {
			competenceFacade.save(competenceBo_BA_60);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_61 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_61.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_61.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_61.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_61.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_61 = new CompetenceBo ("Coaching", "Ik kan via één op één gesprekken de kennis en vaardigheden van de coachee vergroten.   Dit maakt ook dat ik kan inschatten wat de maturiteit is van de coachee en in functie daarvan mijn stijl aanpas.  Dit kan gaan van eerder sturen/dicteren wat de persoon te doen heeft tot, via triggerende vragen, de persoon aanzetten tot zelfreflectie zodat hij/zij zelf tot de oplossing komt.    Ik kan me flexibel opstellen maar richt tegelijk de coaching naar het behalen van de gestelde coachingdoelen.   Ik durf de coachingsdoelen te challengen indien ze (gaandeweg) niet haalbaar lijken.  Ik ben instaat de coachingsdoelen aan het einde van het traject te evalueren en kan deze in alle openheid met de coachee en diens chef bespreken.", competenceLevels_BA_61 );
		try {
			competenceFacade.save(competenceBo_BA_61);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_62 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_62.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_62.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_62.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_62.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_62 = new CompetenceBo ("Kennis delen", "Ik kan vlot mijn eigen kennis, ervaringen, voorbeelden delen met collega's….   Ik doe dit zowel op vraag (klankborden) als spontaan in functie van de noden.   Het gaat daarbij zowel over kennis, ervaringen, voorbeelden… die ik in mijn rol als key-user hebt verkregen als degene die ik heb opgebouwd vanuit mijn eigen prakijkt ervaring.  Daarnaast ga ik ook zelf op zoek naar extra informatie, ervaringen en voorbeelden bij collega’s om zo nog meer bagage te hebben die ik kan delen.  Dit betekent echter niet dat ik steeds zelf het antwoord kan geven, maar kan doorverwijzen waar nodig.   (gelinkt aan gedragscompetentie: “Expertise uitwisselen” en “netwerken”).    ", competenceLevels_BA_62 );
		try {
			competenceFacade.save(competenceBo_BA_62);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_63 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_63.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_63.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_63.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_63.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_63 = new CompetenceBo ("Noden capteren", "Ik luister actief bij collega’s hoe zij het werken in de subject matter, waarvoor ik key-user ben, ervaren.   Waar relevant bevraag ik hen ook gericht naar ideeën/noden voor verbeteringen.  Door mijn vraagstelling ben ik ook in staat deze ideeën/noden voldoende scherp te maken.    Natuurlijk laat ik me hierbij ook inspireren door wat ikzelf vanuit de praktijk ervaar.   Dit luisteren en bevragen kan zowel in directe interactie als via digitaal.   Ik deel deze ideeën en noden ook met mijn collega key-users en coe-coordinator om te bekijken wat hiermee kan gedaan worden. (gelinkt aan gedragscompetentie: “Expertise uitwisselen” en “netwerken”).    ", competenceLevels_BA_63 );
		try {
			competenceFacade.save(competenceBo_BA_63);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_64 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_64.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_64.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_64.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_64.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_64 = new CompetenceBo ("Organiseren en faciliteren van ervaringsuitwisseling", "Ik kan (mee) een event, dag, vergadering, maar ook online forum of platform… organiseren dat medewerkers uitnodigt om met elkaar in dialoog te gaan en ervaringen  uit te wisselen.    Ik hou ook rekening met de keuze van de werkvormen en middelen.  Daarbij probeer ik zo veel als mogelijk de interactie tussen de deelnemers te stimuleren.   Ik ben in staat om tijdens het event, dag, vergadering, maar ook op een online forum of platform… de nodige interacties te doen om de ervaringsuitwisseling op een open en veilige manier te stimuleren.", competenceLevels_BA_64 );
		try {
			competenceFacade.save(competenceBo_BA_64);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_65 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_65.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_65.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_65.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_65.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_65 = new CompetenceBo ("Opvolgen en ontwikkelen van methodes en technieken", "Ik denk na en ga in interactie met collega’s (key-user) over de methodes en technieken die we met het CoE uitdragen.  Daarbij ben ik niet enkel gefocused op de methodes en technieken binnen de subject matter waarvoor ik key-user ben, maar ook hoe deze aansluiten in het groter geheel.   Zowel intern als extern hou ik een oog op de evoluties op vlak van methodes en technieken of de nood daaraan.    In het kader van projecten werk ik ook mee aan het bijsturen van bestaande of ontwikkelen van nieuwe methodes en technieken.  Ik ben daarbij voldoende pragmatisch om (gebaseerd op theorie) een in de prakijkt toepasbare methode/techniek uit te werken.", competenceLevels_BA_65 );
		try {
			competenceFacade.save(competenceBo_BA_65);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_66 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_66.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_66.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_66.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_66.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_66 = new CompetenceBo ("Advies geven bij ontwikkel/leerplannen", "Ik heb een goed beeld op het leeraanbod dat we met het CoE, waarvoor ik key-user ben, aanleveren.   Vanuit die ervaring kan ik collega’s en hun chefs ook ondersteunen bij het bepalen van de juiste training, coaching… voor de leernood.", competenceLevels_BA_66 );
		try {
			competenceFacade.save(competenceBo_BA_66);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_67 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_67.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_BA_67.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_BA_67.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_BA_67.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_BA_67 = new CompetenceBo ("Kennis hebben van de BP&S processen en services", "Ik kan de verschillende aspecten (informatie, tools, werkprocessen, methodes, technieken, best practices…) van de subject matter waarvoor ik key-user ben plaatsen in services die we met BP&S leveren en hun achterliggende processen.  In het kader van coachings, klankborden, trainingen… ben ik ook in staat om dit in mijn eigen woorden toe te lichten waar nodig.  ", competenceLevels_BA_67 );
		try {
			competenceFacade.save(competenceBo_BA_67);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_BA_70 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_70.add (new CompetenceLevelBo(" bepaalt in een eenvoudig gegeven de verschillende stappen.", 1));
		competenceLevels_BA_70.add (new CompetenceLevelBo(" faseert binnen een gegeven de mijlpalen in een realistisch tijdsschema.", 2));
		competenceLevels_BA_70.add (new CompetenceLevelBo(" optimaliseert eigen stappenplan door ze af te stemmen op aanverwante projecten.", 3));
		competenceLevels_BA_70.add (new CompetenceLevelBo(" maakt in een complex gegeven een efficiënt en effectief stappenplan.", 4));
		competenceLevels_BA_70.add (new CompetenceLevelBo(" integreert de verschillende doelstellingen in één strategisch plan.", 5));


		CompetenceBo competenceBo_BA_70 = new CompetenceBo ("Strategisch organiseren", "Definitie: De capaciteit om op een effectieve en efficiënte manier tot een globaal stappenplan te komen, dit verder aan/bij te sturen opdat de beoogde doelstelling gerealiseerd kan worden.  ", competenceLevels_BA_70 );
		try {
			competenceFacade.save(competenceBo_BA_70);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_71 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_71.add (new CompetenceLevelBo(" benadert situaties vanuit opportuniteit.", 1));
		competenceLevels_BA_71.add (new CompetenceLevelBo(" brengt een boodschap op authentieke, enthousiaste manier en beantwoordt vragen vanuit opportuniteit.", 2));
		competenceLevels_BA_71.add (new CompetenceLevelBo(" luistert actief naar vragen, zorgen en noden en zorgt voor een werkbare context.", 3));
		competenceLevels_BA_71.add (new CompetenceLevelBo(" hanteert gepaste overtuigingstechnieken en vraagstelling zodat iedereen de toegevoegde waarde voor zichzelf ontdekt.", 4));
		competenceLevels_BA_71.add (new CompetenceLevelBo(" blijft actief peilen naar enthousiasme en engagement bij anderen en anticipeert hierop.", 5));


		CompetenceBo competenceBo_BA_71 = new CompetenceBo ("Energie mobiliseren", "Definitie:  Op een authentieken manier enthousiasme en engagement rond een doel of project verkrijgen door zelf enthousiasme uit te stralen, iedereen de toegevoegde waarde te laten ontdekken en een werkbare context te creëren.  ", competenceLevels_BA_71 );
		try {
			competenceFacade.save(competenceBo_BA_71);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_72 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_72.add (new CompetenceLevelBo(" vormt zich een standpunt vanuit concrete kennis en ervaring..", 1));
		competenceLevels_BA_72.add (new CompetenceLevelBo(" vormt een standpunt door abstractie te maken van gegevens, ideeën en situaties.", 2));
		competenceLevels_BA_72.add (new CompetenceLevelBo(" vormt een standpunt door abstractie te maken vanuit een complexe situatie en gegevens.", 3));
		competenceLevels_BA_72.add (new CompetenceLevelBo(" vormt zich een geïntegreerd beeld en geeft richting.", 4));
		competenceLevels_BA_72.add (new CompetenceLevelBo(" beargumenteert beheerst zijn/haar boodschap en brengt de verschillende meningen terug tot de kern.", 5));


		CompetenceBo competenceBo_BA_72 = new CompetenceBo ("Conceptueel vermogen", "Definitie:  Het vermogen om de zaken in een breder perspectief te plaatsen en een visie te vormen met betrekking tot ideeën of situaties die op het eerste gezicht niets met elkaar te maken hebben.  ", competenceLevels_BA_72 );
		try {
			competenceFacade.save(competenceBo_BA_72);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_73 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_73.add (new CompetenceLevelBo(" verwerkt een beperkte hoeveelheid eenvoudige gegevens.", 1));
		competenceLevels_BA_73.add (new CompetenceLevelBo(" onderscheidt in een hoeveelheid gegevens verschillende deelaspecten.", 2));
		competenceLevels_BA_73.add (new CompetenceLevelBo(" legt eenvoudige verbanden tussen verschillende gegevens.", 3));
		competenceLevels_BA_73.add (new CompetenceLevelBo(" analyseert de verbanden tussen de verschillende onderdelen van een complex gegeven.", 4));
		competenceLevels_BA_73.add (new CompetenceLevelBo(" komt vanuit een complex gegeven tot duidelijke criteria voor het maken van een synthese.", 5));


		CompetenceBo competenceBo_BA_73 = new CompetenceBo ("Analytisch vermogen", "Definitie:  De capaciteit om (complexe) problemen, processen en projecten op te splitsen in samenstellende delen, de onderliggende verbanden op een systematische manier te analyseren en duidelijke criteria te ontwikkelen voor het vormen van een beeld.  ", competenceLevels_BA_73 );
		try {
			competenceFacade.save(competenceBo_BA_73);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_74 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_74.add (new CompetenceLevelBo(" brengt eenvoudige boodschappen op een gestructureerde manier.", 1));
		competenceLevels_BA_74.add (new CompetenceLevelBo(" luistert naar zijn/haar publiek en beantwoordt vragen.", 2));
		competenceLevels_BA_74.add (new CompetenceLevelBo(" brengt een complexe boodschap op een rechtstreekse, aangepaste manier naar het doelpubliek.", 3));
		competenceLevels_BA_74.add (new CompetenceLevelBo(" toetst actief af of de boodschap door iedereen begrepen is en herformuleert.", 4));
		competenceLevels_BA_74.add (new CompetenceLevelBo(" beargumenteert zijn/haar boodschap beheerst en brengt de verschillende meningen terug tot de kern.", 5));


		CompetenceBo competenceBo_BA_74 = new CompetenceBo ("Communicatief vermogen", "Defintiie:  Het vermogen om op een directe, rechtstreeks en interactieve manier een boodschap (over) te brengen.  ", competenceLevels_BA_74 );
		try {
			competenceFacade.save(competenceBo_BA_74);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_75 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_75.add (new CompetenceLevelBo(" staat open voor feedback.", 1));
		competenceLevels_BA_75.add (new CompetenceLevelBo(" staat stil bij het eigen gedrag en functioneren.", 2));
		competenceLevels_BA_75.add (new CompetenceLevelBo(" onderneemt stappen om zich verder te ontwikkelen op het vlak van kennis en vaardigheden.", 3));
		competenceLevels_BA_75.add (new CompetenceLevelBo(" gaat actief op zoek naar mogelijkheden om de eigen overtuigingen, patronen en persoonlijkheid verder te ontwikkelen.", 4));
		competenceLevels_BA_75.add (new CompetenceLevelBo(" integreert het geleerde en het opgedane vakmanschap in zijn/haar gehele functioneren.", 5));


		CompetenceBo competenceBo_BA_75 = new CompetenceBo ("Zelfontplooiing", "Definitie:  Inzicht verwerven in zichzelf en op basis hiervan bewust stappen ondernemen om verder te ontwikkelen.  ", competenceLevels_BA_75 );
		try {
			competenceFacade.save(competenceBo_BA_75);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_76 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_76.add (new CompetenceLevelBo(" neemt niet controversiële beslissingen.", 1));
		competenceLevels_BA_76.add (new CompetenceLevelBo(" durft beslissingen nemen die een beperkt risico inhouden over eenvoudige materie.", 2));
		competenceLevels_BA_76.add (new CompetenceLevelBo(" neemt beslissingen met impact op anderen.", 3));
		competenceLevels_BA_76.add (new CompetenceLevelBo(" neemt beslissingen over complexe materie.", 4));
		competenceLevels_BA_76.add (new CompetenceLevelBo(" neemt beslissingen over complexe materie met brede impact.", 5));


		CompetenceBo competenceBo_BA_76 = new CompetenceBo ("Beslissen", "Definitie:  De capaciteit en bereidheid om je handen te durven vuilmaken door het uitspreken van een bepaald standpunt of beslissing, ondanks onvolledige kennis van het gegeven of van de risico's.  ", competenceLevels_BA_76 );
		try {
			competenceFacade.save(competenceBo_BA_76);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_77 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_77.add (new CompetenceLevelBo(" kent de formele structuur.", 1));
		competenceLevels_BA_77.add (new CompetenceLevelBo(" maakt gebruik van de bestaande formele contacten.", 2));
		competenceLevels_BA_77.add (new CompetenceLevelBo(" kent en gebruikt formele en informele contacten.", 3));
		competenceLevels_BA_77.add (new CompetenceLevelBo(" kent en gebruikt de cultuur van een organisatie. ", 4));
		competenceLevels_BA_77.add (new CompetenceLevelBo(" bouwt doelgericht en proactief een professioneel netwerk uit.", 5));


		CompetenceBo competenceBo_BA_77 = new CompetenceBo ("Netwerken", "Definitie:  Het vermogen om formele en informele relaties binnen en buiten de onderneming op te bouwen en in te zetten zodat steun en medewerking verkregen wordt.  ", competenceLevels_BA_77 );
		try {
			competenceFacade.save(competenceBo_BA_77);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_78 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_78.add (new CompetenceLevelBo(" observeert een gegeven uit zijn/haar omgeving naar aanleiding van een concrete vraag, probleem.", 1));
		competenceLevels_BA_78.add (new CompetenceLevelBo(" voorziet tijd om te observeren en te evalueren wat er in zijn/haar eigen leefwereld, werkomgeving gebeurt.", 2));
		competenceLevels_BA_78.add (new CompetenceLevelBo(" onderzoekt continu de eigen leefwereld vanuit verschillende perspectieven.", 3));
		competenceLevels_BA_78.add (new CompetenceLevelBo(" denkt 'out of the box' en durft te experimenteren met vernieuwende ideeën of concepten.", 4));
		competenceLevels_BA_78.add (new CompetenceLevelBo(" daagt anderen uit om buiten de klassieke wegen en patronen te denken.", 5));


		CompetenceBo competenceBo_BA_78 = new CompetenceBo ("Vernieuwingsgerichtheid", "Definitie:  Met een onderzoekende en nieuwsgierige geest op zoek gaan naar en openstaan voor impulsen, ideeën of gegevens uit de interne en externe wereld.  ", competenceLevels_BA_78 );
		try {
			competenceFacade.save(competenceBo_BA_78);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_79 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_79.add (new CompetenceLevelBo(" kent de waarden en missie.", 1));
		competenceLevels_BA_79.add (new CompetenceLevelBo(" werkt conform de waarden en missie.", 2));
		competenceLevels_BA_79.add (new CompetenceLevelBo(" volgt gedrag van anderen op dat niet overeenstemt met waarden en missie.", 3));
		competenceLevels_BA_79.add (new CompetenceLevelBo(" bewaakt en verduidelijkt de toepassing van de waarden en missie.", 4));
		competenceLevels_BA_79.add (new CompetenceLevelBo(" koppelt de bedrijfswaarden en missie aan elke boodschap en beslissing.", 5));


		CompetenceBo competenceBo_BA_79 = new CompetenceBo ("Ondernemingsbetrokkenheid", "Definitie:  Zich verbonden tonen met de missie en waarden van de onderneming, hierover verbinding creëren bij anderen en ervoor zorgen dat gedrag hiermee overeenstemt.  ", competenceLevels_BA_79 );
		try {
			competenceFacade.save(competenceBo_BA_79);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_80 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_80.add (new CompetenceLevelBo(" doet wat van hem/haar gevraagd wordt.", 1));
		competenceLevels_BA_80.add (new CompetenceLevelBo(" zet door en grijpt in wanneer niet alles naar wens verloopt.", 2));
		competenceLevels_BA_80.add (new CompetenceLevelBo(" definieert eigen prestatieniveaus en stuurt anderen bij.", 3));
		competenceLevels_BA_80.add (new CompetenceLevelBo(" formuleert naar anderen duidelijke criteria waarbinnen gewerkt moet worden.", 4));
		competenceLevels_BA_80.add (new CompetenceLevelBo(" definieert uitdagende doelstellingen.", 5));


		CompetenceBo competenceBo_BA_80 = new CompetenceBo ("Doelgerichtheid", "Definitie: Het doorzettingsvermogen om goed werk af te leveren en doelstellingen te behalen.  ", competenceLevels_BA_80 );
		try {
			competenceFacade.save(competenceBo_BA_80);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_81 = new HashSet<CompetenceLevelBo>();
		competenceLevels_BA_81.add (new CompetenceLevelBo(" reageert op vragen van klanten volgens bestaande dienstverlening en service.", 1));
		competenceLevels_BA_81.add (new CompetenceLevelBo(" luistert naar klantennoden en behandelt deze.", 2));
		competenceLevels_BA_81.add (new CompetenceLevelBo(" overlegt en stemt af met de klant over de gewenste diensten/producten.", 3));
		competenceLevels_BA_81.add (new CompetenceLevelBo(" gaat actief op zoek bij anderen om dienstverlening en producten te optimaliseren.", 4));
		competenceLevels_BA_81.add (new CompetenceLevelBo(" speelt proactief in op noden en verwachtingen en bouwt aan een duurzame klantenrelatie.", 5));


		CompetenceBo competenceBo_BA_81 = new CompetenceBo ("Klantgerichtheid", "Defintie: Het vermogen om actief op zoek te gaan naar en in te spelen op diensten en producten die een toegevoegde waarde hebben voor anderen (interne en externe klanten, collega's, partners,…).  ", competenceLevels_BA_81 );
		try {
			competenceFacade.save(competenceBo_BA_81);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_BA_84 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_84 = new CompetenceBo ("Strategy & Change: Strategy Definition & Governance", "", competenceLevels_BA_84 );
		try {
			competenceFacade.save(competenceBo_BA_84);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_85 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_85 = new CompetenceBo ("Strategy & Change: Business Change Mgmt", "", competenceLevels_BA_85 );
		try {
			competenceFacade.save(competenceBo_BA_85);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_86 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_86 = new CompetenceBo ("Resource Planning: Strategic Resource Planning", "", competenceLevels_BA_86 );
		try {
			competenceFacade.save(competenceBo_BA_86);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_87 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_87 = new CompetenceBo ("Risk & Compliance: Risk & Compliance Mgmt", "", competenceLevels_BA_87 );
		try {
			competenceFacade.save(competenceBo_BA_87);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_88 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_88 = new CompetenceBo ("Market Watch", "", competenceLevels_BA_88 );
		try {
			competenceFacade.save(competenceBo_BA_88);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_89 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_89 = new CompetenceBo ("Performance Watch", "", competenceLevels_BA_89 );
		try {
			competenceFacade.save(competenceBo_BA_89);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_90 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_90 = new CompetenceBo ("Sustainability Mgmt", "", competenceLevels_BA_90 );
		try {
			competenceFacade.save(competenceBo_BA_90);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_91 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_91 = new CompetenceBo ("Innovation: R&D & Innovation", "", competenceLevels_BA_91 );
		try {
			competenceFacade.save(competenceBo_BA_91);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_92 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_92 = new CompetenceBo ("Stakeholder Relations & Reputation: Stakeholder Relations & Reputation Mgmt", "", competenceLevels_BA_92 );
		try {
			competenceFacade.save(competenceBo_BA_92);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_93 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_93 = new CompetenceBo ("Stakeholder Relations & Reputation: Public Relations Mgmt", "", competenceLevels_BA_93 );
		try {
			competenceFacade.save(competenceBo_BA_93);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_94 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_94 = new CompetenceBo ("Stakeholder Relations & Reputation: Party Mgmt", "", competenceLevels_BA_94 );
		try {
			competenceFacade.save(competenceBo_BA_94);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_95 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_95 = new CompetenceBo ("Communication & Collaboration: Commication & Collaboration", "", competenceLevels_BA_95 );
		try {
			competenceFacade.save(competenceBo_BA_95);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_96 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_96 = new CompetenceBo ("Communication & Collaboration: Workplace Mgmt", "", competenceLevels_BA_96 );
		try {
			competenceFacade.save(competenceBo_BA_96);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_97 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_97 = new CompetenceBo ("Digital: Digitalisation Mgmt", "", competenceLevels_BA_97 );
		try {
			competenceFacade.save(competenceBo_BA_97);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_98 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_98 = new CompetenceBo ("Service, Process & Organisation: Organisation Mgmt", "", competenceLevels_BA_98 );
		try {
			competenceFacade.save(competenceBo_BA_98);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_99 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_99 = new CompetenceBo ("Service, Process & Organisation: Process & Service Design", "", competenceLevels_BA_99 );
		try {
			competenceFacade.save(competenceBo_BA_99);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_100 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_100 = new CompetenceBo ("Service, Process & Organisation: Enterprise Service Mgmt", "", competenceLevels_BA_100 );
		try {
			competenceFacade.save(competenceBo_BA_100);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_101 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_101 = new CompetenceBo ("Information: Information Mgmt", "", competenceLevels_BA_101 );
		try {
			competenceFacade.save(competenceBo_BA_101);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_102 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_102 = new CompetenceBo ("Information: Content & Document Mgmt", "", competenceLevels_BA_102 );
		try {
			competenceFacade.save(competenceBo_BA_102);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_103 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_103 = new CompetenceBo ("Coworker: Co-worker Mgmt", "", competenceLevels_BA_103 );
		try {
			competenceFacade.save(competenceBo_BA_103);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_104 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_104 = new CompetenceBo ("Coworker: Training Mgmt", "", competenceLevels_BA_104 );
		try {
			competenceFacade.save(competenceBo_BA_104);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_105 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_105 = new CompetenceBo ("Infrastructure: Real Estate Mgmt", "", competenceLevels_BA_105 );
		try {
			competenceFacade.save(competenceBo_BA_105);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_106 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_106 = new CompetenceBo ("Infrastructure: Tanglible Asset Lifecycle Mgmt", "", competenceLevels_BA_106 );
		try {
			competenceFacade.save(competenceBo_BA_106);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_107 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_107 = new CompetenceBo ("Infrastructure: Facility & Field Service Mgmt", "", competenceLevels_BA_107 );
		try {
			competenceFacade.save(competenceBo_BA_107);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_108 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_108 = new CompetenceBo ("IT Infrasturcture & Solutions: ICT Mgmt", "", competenceLevels_BA_108 );
		try {
			competenceFacade.save(competenceBo_BA_108);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_109 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_109 = new CompetenceBo ("Brand, Customer, Marketingpromotion: (B2C) Marketing Promotion (BE)", "", competenceLevels_BA_109 );
		try {
			competenceFacade.save(competenceBo_BA_109);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_110 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_110 = new CompetenceBo ("Brand, Customer, Marketingpromotion: Brand Mgmt", "", competenceLevels_BA_110 );
		try {
			competenceFacade.save(competenceBo_BA_110);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_111 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_111 = new CompetenceBo ("Brand, Customer, Marketingpromotion: Customer Mgmt", "", competenceLevels_BA_111 );
		try {
			competenceFacade.save(competenceBo_BA_111);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_112 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_112 = new CompetenceBo ("Product: Product Mgmt", "", competenceLevels_BA_112 );
		try {
			competenceFacade.save(competenceBo_BA_112);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_113 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_113 = new CompetenceBo ("Procuct: Product Group Mgmt", "", competenceLevels_BA_113 );
		try {
			competenceFacade.save(competenceBo_BA_113);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_114 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_114 = new CompetenceBo ("Procuct: Product Information Mgmt", "", competenceLevels_BA_114 );
		try {
			competenceFacade.save(competenceBo_BA_114);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_115 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_115 = new CompetenceBo ("Purchasing Direct Goods: Direct Purchase Mgmt", "", competenceLevels_BA_115 );
		try {
			competenceFacade.save(competenceBo_BA_115);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_116 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_116 = new CompetenceBo ("Purchasing Direct Goods: Retail Product Costing", "", competenceLevels_BA_116 );
		try {
			competenceFacade.save(competenceBo_BA_116);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_117 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_117 = new CompetenceBo ("Purchasing Direct Goods: Purchase Operations Food", "", competenceLevels_BA_117 );
		try {
			competenceFacade.save(competenceBo_BA_117);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_118 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_118 = new CompetenceBo ("Purchasing Indirect Goods & Services: Indirect Purchasing", "", competenceLevels_BA_118 );
		try {
			competenceFacade.save(competenceBo_BA_118);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_119 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_119 = new CompetenceBo ("Purchasing Indirect Goods & Services: Indirect Product Information Mgmt", "", competenceLevels_BA_119 );
		try {
			competenceFacade.save(competenceBo_BA_119);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_120 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_120 = new CompetenceBo ("Purchasing Indirect Goods & Services: Internal Wholesale of Indirect Goods", "", competenceLevels_BA_120 );
		try {
			competenceFacade.save(competenceBo_BA_120);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_121 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_121 = new CompetenceBo ("Supplier: Supplier Mgmt", "", competenceLevels_BA_121 );
		try {
			competenceFacade.save(competenceBo_BA_121);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_122 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_122 = new CompetenceBo ("Supply Chain Food: Supply Chain Food", "", competenceLevels_BA_122 );
		try {
			competenceFacade.save(competenceBo_BA_122);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_123 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_123 = new CompetenceBo ("Supply Chain Food: Logistic Workforce Mgmt", "", competenceLevels_BA_123 );
		try {
			competenceFacade.save(competenceBo_BA_123);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_124 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_124 = new CompetenceBo ("Supply Chain Food: Sales Forecasting Food", "", competenceLevels_BA_124 );
		try {
			competenceFacade.save(competenceBo_BA_124);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_125 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_125 = new CompetenceBo ("E-Commerce Food: E-commerce B2C Food", "", competenceLevels_BA_125 );
		try {
			competenceFacade.save(competenceBo_BA_125);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_126 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_126 = new CompetenceBo ("E-Commerce Food: nonFood", "", competenceLevels_BA_126 );
		try {
			competenceFacade.save(competenceBo_BA_126);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_127 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_127 = new CompetenceBo ("Store Sales: Food Retail Store Sales", "", competenceLevels_BA_127 );
		try {
			competenceFacade.save(competenceBo_BA_127);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_128 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_128 = new CompetenceBo ("Store Sales: Store Workforce Mgmt", "", competenceLevels_BA_128 );
		try {
			competenceFacade.save(competenceBo_BA_128);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_129 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_129 = new CompetenceBo ("Price: B2C Price Mgmt", "", competenceLevels_BA_129 );
		try {
			competenceFacade.save(competenceBo_BA_129);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_BA_132 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_132 = new CompetenceBo ("Colruyt Laagste Prijs", "", competenceLevels_BA_132 );
		try {
			competenceFacade.save(competenceBo_BA_132);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_133 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_133 = new CompetenceBo ("OKay", "", competenceLevels_BA_133 );
		try {
			competenceFacade.save(competenceBo_BA_133);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_134 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_134 = new CompetenceBo ("Bio-Planet", "", competenceLevels_BA_134 );
		try {
			competenceFacade.save(competenceBo_BA_134);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_135 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_135 = new CompetenceBo ("CRU", "", competenceLevels_BA_135 );
		try {
			competenceFacade.save(competenceBo_BA_135);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_136 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_136 = new CompetenceBo ("Dreamland", "", competenceLevels_BA_136 );
		try {
			competenceFacade.save(competenceBo_BA_136);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_137 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_137 = new CompetenceBo ("Dreambaby", "", competenceLevels_BA_137 );
		try {
			competenceFacade.save(competenceBo_BA_137);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_138 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_138 = new CompetenceBo ("Collishop", "", competenceLevels_BA_138 );
		try {
			competenceFacade.save(competenceBo_BA_138);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_139 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_139 = new CompetenceBo ("Retail Partners Colruyt Group", "", competenceLevels_BA_139 );
		try {
			competenceFacade.save(competenceBo_BA_139);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_140 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_140 = new CompetenceBo ("Solucious", "", competenceLevels_BA_140 );
		try {
			competenceFacade.save(competenceBo_BA_140);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_141 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_141 = new CompetenceBo ("Colex", "", competenceLevels_BA_141 );
		try {
			competenceFacade.save(competenceBo_BA_141);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_142 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_142 = new CompetenceBo ("Dats 24", "", competenceLevels_BA_142 );
		try {
			competenceFacade.save(competenceBo_BA_142);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_143 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_143 = new CompetenceBo ("Collect & Go", "", competenceLevels_BA_143 );
		try {
			competenceFacade.save(competenceBo_BA_143);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_144 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_144 = new CompetenceBo ("Transport", "", competenceLevels_BA_144 );
		try {
			competenceFacade.save(competenceBo_BA_144);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_145 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_145 = new CompetenceBo ("Retail Service Center", "", competenceLevels_BA_145 );
		try {
			competenceFacade.save(competenceBo_BA_145);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_146 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_146 = new CompetenceBo ("Fine Food", "", competenceLevels_BA_146 );
		try {
			competenceFacade.save(competenceBo_BA_146);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_147 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_147 = new CompetenceBo ("In Cont@ct", "", competenceLevels_BA_147 );
		try {
			competenceFacade.save(competenceBo_BA_147);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_148 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_148 = new CompetenceBo ("BP&S", "", competenceLevels_BA_148 );
		try {
			competenceFacade.save(competenceBo_BA_148);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_149 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_149 = new CompetenceBo ("Finance", "", competenceLevels_BA_149 );
		try {
			competenceFacade.save(competenceBo_BA_149);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_150 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_150 = new CompetenceBo ("M&O", "", competenceLevels_BA_150 );
		try {
			competenceFacade.save(competenceBo_BA_150);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_151 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_151 = new CompetenceBo ("T&I", "", competenceLevels_BA_151 );
		try {
			competenceFacade.save(competenceBo_BA_151);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_152 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_152 = new CompetenceBo ("Colruyt Group Energy", "", competenceLevels_BA_152 );
		try {
			competenceFacade.save(competenceBo_BA_152);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_153 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_153 = new CompetenceBo ("CCX & Corporate Marketing", "° Symeta ° Premedia ° Corporate marketing", competenceLevels_BA_153 );
		try {
			competenceFacade.save(competenceBo_BA_153);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_BA_154 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_BA_154 = new CompetenceBo ("Corporate operating unit", "", competenceLevels_BA_154 );
		try {
			competenceFacade.save(competenceBo_BA_154);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

/** Filling the Project Managers **/

		HashSet<CompetenceLevelBo> competenceLevels_PM_15 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_15.add (new CompetenceLevelBo(" ik begrijp waarvoor de PCLC staat, maar het blijft ver van mijn bed-show. Ik gebruik die niet als gids.", 1));
		competenceLevels_PM_15.add (new CompetenceLevelBo(" ik begrijp waarvoor de PCLC staat, maar gebruik die eerder zelden", 2));
		competenceLevels_PM_15.add (new CompetenceLevelBo(" ik gebruik de PCLC echt als mijn leidraad en pas dus de activiteiten en deliverables toe waar ik die nodig acht in een project", 3));
		competenceLevels_PM_15.add (new CompetenceLevelBo(" ik spreek ook anderen aan over het gebruik van de PCLC binnen het projectteam", 4));


		CompetenceBo competenceBo_PM_15 = new CompetenceBo ("De PCLC als gids ", "Uitleg: De PCLC of Project Content Life Cycle is een soort 'proces', een stappenplan waarin staat wat een team te doen staat, willen ze een solution realizeren. Afhankelijk van het type solution (procesoptimalisatie, IT solution, machine, ...) ga je andere activiteiten uitvoeren.  ", competenceLevels_PM_15 );
		try {
			competenceFacade.save(competenceBo_PM_15);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_16 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_16.add (new CompetenceLevelBo(" ik geraak nog steeds niet goed wijs uit het verschil tussen functies en rollen", 1));
		competenceLevels_PM_16.add (new CompetenceLevelBo("  ik weet in grove lijnen wat de verantwoordelijkheid is van een aantal rollen in de PCLC", 2));
		competenceLevels_PM_16.add (new CompetenceLevelBo(" ik ken de meest gebruikte rollen in de PCLC, en van de rol(len) die ik opneem weet ik wat te doen, of vind ik mijn weg om het te weten te komen", 3));
		competenceLevels_PM_16.add (new CompetenceLevelBo(" ik weet zowel van de rollen die ik opneem als van de meeste andere wat hen te doen staat", 4));


		CompetenceBo competenceBo_PM_16 = new CompetenceBo ("Rollen in de PCLC", "Uitleg: Rollen in de PCLC zijn o.a: project manager, business advisor, project business architect, solution IT architect, process designer, system requirements analyst, lead developer, developer, test manager, asset owner, ...  ", competenceLevels_PM_16 );
		try {
			competenceFacade.save(competenceBo_PM_16);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_17 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_17.add (new CompetenceLevelBo(" ik doe wat ik denk dat nodig is. Ik gebruik daarvoor geen referentiemateriaal of templates.", 1));
		competenceLevels_PM_17.add (new CompetenceLevelBo(" ik gebruik in projecten bijna steeds dezelde templates of deliverables, als die al nodig zijn. Ik weet waar ik die kan vinden, en zoek verder nooit naar iets extra.", 2));
		competenceLevels_PM_17.add (new CompetenceLevelBo(" ik weet wat ik als basis op te leveren heb in een project, maar ik ga toch nu en dan eens zoeken op de PCLC site (of andere site). Ik weet graag of er een update is, of een mogelijk andere techniek die me beter kan helpen", 3));
		competenceLevels_PM_17.add (new CompetenceLevelBo(" ik neem steevast de PCLC-lijst met deliverables erbij, zodat ik ten alle tijde weet welke types deliverables en templates ik kan gebruiken. Want afhankelijk van de solution, kunnen andere templates of methodieken me zeker beter helpen.", 4));


		CompetenceBo competenceBo_PM_17 = new CompetenceBo ("Activiteiten en deliverables", "Uitleg: Rollen voeren specifieke activiteiten uit. En heel vaak wordt er ook informatie verzameld of aangevuld, en daarvoor is er vaak een template ter beschikking. Alle uitleg over die activiteiten en die deliverables vind je op de PCLC-site.  ", competenceLevels_PM_17 );
		try {
			competenceFacade.save(competenceBo_PM_17);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_18 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_18.add (new CompetenceLevelBo(" Ik heb nog nooit of zeer zelden een MAW meegemaakt. Ik zie ook de meerwaarde niet goed.", 1));
		competenceLevels_PM_18.add (new CompetenceLevelBo(" Ik begrijp en zie de meerwaarde van een MAW, maar er worden er te weinig georganiseerd op project(en) waar ik deel van uitmaak", 2));
		competenceLevels_PM_18.add (new CompetenceLevelBo(" MAW's worden geregeld ingepland, maar de kwaliteit ervan kan zeker nog beter", 3));
		competenceLevels_PM_18.add (new CompetenceLevelBo(" MAW's worden geregeld ingepland, en ook de meerwaarde ervan is meteen duidelijk. Kwaliteit is voldoende.", 4));
		competenceLevels_PM_18.add (new CompetenceLevelBo(" ik zorg er zelf voor dat MAW's ingepland raken, zelfs al ben ik de PM niet, want ze zijn onotbeerlijk voor het goede verloop van elk project. ", 5));


		CompetenceBo competenceBo_PM_18 = new CompetenceBo ("MAW's", "Uitleg: Een Method Adoption Workshop dient om voor elke projectstap of elk workpackage af te spreken wat er nodig is binnen deze projectopdracht, wie die rol zal opnemen en welke deliverables die zal opleveren. Zo weet iedereen wat die van wie mag verwachten.   ", competenceLevels_PM_18 );
		try {
			competenceFacade.save(competenceBo_PM_18);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_19 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_19.add (new CompetenceLevelBo(" ik heb geen idee waar ik terecht kan als ik vragen heb, tenzij bij mijn chef dan. Ik trek mijn plan op mijn eentje.", 1));
		competenceLevels_PM_19.add (new CompetenceLevelBo(" als ik hulp zou nodig hebben, dan ga ik te rade bij collega's (die dezelfde rol opnemen) die me kunnen helpen", 2));
		competenceLevels_PM_19.add (new CompetenceLevelBo(" ik weet waar ik terecht kan voor hulp, en ik schakel die in of zou die inschakelen wanneer ik dat nodig vind", 3));
		competenceLevels_PM_19.add (new CompetenceLevelBo(" ik ben een referentie voor collega's en stuur hen door naar de site of naar key user(s), of maak er toch reclame voor, als zij met vragen komen. Kwestie dat ook zij de hulpbronnen leren kennen.", 4));


		CompetenceBo competenceBo_PM_19 = new CompetenceBo ("Ondersteunend materiaal & support", "Uitleg: Er is een PCLC site waarop alle info rond de 'Realize a solution'-stappen, rollen, activiteiten, deliverables en templates gecentraliseerd staat. Daarnaast zijn er nog CoE coördinatoren en key users die per discipline ondersteuning en coaching kunnen geven bij het uitoefenen van je rol.  ", competenceLevels_PM_19 );
		try {
			competenceFacade.save(competenceBo_PM_19);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_PM_22 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_22.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_22.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_22.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_22.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_22 = new CompetenceBo ("Scope - Scope definitie", "Ik kan de scope van een project bepalen", competenceLevels_PM_22 );
		try {
			competenceFacade.save(competenceBo_PM_22);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_23 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_23.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_23.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_23.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_23.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_23 = new CompetenceBo ("Scope - Scope control", "Ik kan de scope van een project opvolgen en waar nodig change requests (laten) bepalen", competenceLevels_PM_23 );
		try {
			competenceFacade.save(competenceBo_PM_23);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_24 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_24.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_24.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_24.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_24.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_24 = new CompetenceBo ("Tijd", "Ik kan ervoor zorgen dat een project realististische tijdschattingen heeft", competenceLevels_PM_24 );
		try {
			competenceFacade.save(competenceBo_PM_24);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_25 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_25.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_25.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_25.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_25.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_25 = new CompetenceBo ("Kost", "Ik kan ervoor zorgen dat een project realistische kosteninschatting heeft", competenceLevels_PM_25 );
		try {
			competenceFacade.save(competenceBo_PM_25);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_26 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_26.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_26.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_26.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_26.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_26 = new CompetenceBo ("Kwaliteit", "Ik kan ervoor zorgen dat de nodige maatregelen worden genomen opdat het team kwaliteit zal opleveren en dit op maat van de noden van het project", competenceLevels_PM_26 );
		try {
			competenceFacade.save(competenceBo_PM_26);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_27 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_27.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_27.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_27.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_27.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_27 = new CompetenceBo ("Team", "Ik kan ervoor zorgen dat het team goed draait, vb. door duidelijke rollen en verantwoordelijkheden en goede afspraken", competenceLevels_PM_27 );
		try {
			competenceFacade.save(competenceBo_PM_27);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_28 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_28.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_28.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_28.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_28.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_28 = new CompetenceBo ("Communicatie", "Ik kan een communicatieplan op maat van het project opstellen en uitvoeren ", competenceLevels_PM_28 );
		try {
			competenceFacade.save(competenceBo_PM_28);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_29 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_29.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_29.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_29.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_29.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_29 = new CompetenceBo ("Risico", "Ik kan risico management toepassen op maat van het project", competenceLevels_PM_29 );
		try {
			competenceFacade.save(competenceBo_PM_29);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_30 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_30.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_30.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_30.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_30.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_30 = new CompetenceBo ("Aankoop", "Ik weet hoe het aankoop proces verloopt en kan dit toepassen binnen een project", competenceLevels_PM_30 );
		try {
			competenceFacade.save(competenceBo_PM_30);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_31 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_31.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_31.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_31.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_31.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_31 = new CompetenceBo ("Stakeholder", "Ik kan stakeholder management toepassen voor een project", competenceLevels_PM_31 );
		try {
			competenceFacade.save(competenceBo_PM_31);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_32 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_32.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_32.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_32.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_32.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_32 = new CompetenceBo ("Integratie - Business case development", "Ik kan een business case voor een project opstellen en/of challengen", competenceLevels_PM_32 );
		try {
			competenceFacade.save(competenceBo_PM_32);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_33 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_33.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_33.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_33.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_33.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_33 = new CompetenceBo ("Integratie - Projectblad", "Ik kan een projectblad opstellen en up to date houden", competenceLevels_PM_33 );
		try {
			competenceFacade.save(competenceBo_PM_33);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_34 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_34.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_34.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_34.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_34.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_34 = new CompetenceBo ("Integratie - PMP", "Ik kan een PMP opstellen op maat van een project", competenceLevels_PM_34 );
		try {
			competenceFacade.save(competenceBo_PM_34);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_35 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_35.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_35.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_35.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_35.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_35 = new CompetenceBo ("Integratie - Change control", "Ik kan wijzigingen tov de baseline bepalen en ook de impact van wijzigingen op de baseline, inclusief het verrichten van een re-baseline", competenceLevels_PM_35 );
		try {
			competenceFacade.save(competenceBo_PM_35);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_36 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_36.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_36.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_36.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_36.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_36 = new CompetenceBo ("Integratie - PSR", "Ik kan rapporteren over de status van een project via PSR's", competenceLevels_PM_36 );
		try {
			competenceFacade.save(competenceBo_PM_36);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_37 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_37.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_37.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_37.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_37.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_37 = new CompetenceBo ("Change mgmt (VIE)", "Ik kan ervoor zorgen dat de organisationele change goed wordt beheerd", competenceLevels_PM_37 );
		try {
			competenceFacade.save(competenceBo_PM_37);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_PM_40 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_40.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_40.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_40.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_40.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_40 = new CompetenceBo ("Business strategie bepalingen", "Ik kan een project managen waarbij de business strategie vb. voor een BOU wordt bepaald", competenceLevels_PM_40 );
		try {
			competenceFacade.save(competenceBo_PM_40);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_41 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_41.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_41.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_41.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_41.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_41 = new CompetenceBo ("Operationele business projecten ", "Ik kan een project managen waarbij de business processen worden bepaald of geoptimaliseerd en/of de business organisatie wordt opgezet of verbeterd ", competenceLevels_PM_41 );
		try {
			competenceFacade.save(competenceBo_PM_41);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_42 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_42.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_42.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_42.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_42.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_42 = new CompetenceBo ("Maatsoftware projecten", "Ik kan een project managen waarbij er maatsoftware wordt ontwikkeld ", competenceLevels_PM_42 );
		try {
			competenceFacade.save(competenceBo_PM_42);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_43 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_43.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_43.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_43.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_43.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_43 = new CompetenceBo ("Pakket implementaties", "Ik kan een project managen waarbij er een pakket selectie en implementatie betrokken is", competenceLevels_PM_43 );
		try {
			competenceFacade.save(competenceBo_PM_43);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_44 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_44.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_44.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_44.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_44.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_44 = new CompetenceBo ("Projecten met significante hardware rollout", "Ik kan een project managen waarbij er een hardware rollout noodzakelijk is", competenceLevels_PM_44 );
		try {
			competenceFacade.save(competenceBo_PM_44);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_45 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_45.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_45.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_45.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_45.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_45 = new CompetenceBo ("Infrastructuur projecten", "Ik kan een project managen waarbij er een nieuwe IT infrastructuur (vb. servers, netwerken, firewalls, routers) nodig is of waarbij er grote wijzigingen nodig zijn in de bestaande IT infrastructuur", competenceLevels_PM_45 );
		try {
			competenceFacade.save(competenceBo_PM_45);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_46 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_46.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_46.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_46.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_46.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_46 = new CompetenceBo ("Innovatie, R&D projecten", "Ik kan een R&D project managen   ", competenceLevels_PM_46 );
		try {
			competenceFacade.save(competenceBo_PM_46);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_47 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_47.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_47.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_47.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_47.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_47 = new CompetenceBo ("Projecten met 'waterval' aanpak", "Ik kan een project managen met een 'waterval' aanpak   ", competenceLevels_PM_47 );
		try {
			competenceFacade.save(competenceBo_PM_47);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_48 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_48.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_48.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_48.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_48.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_48 = new CompetenceBo ("Projecten met 'incrementele' aanpak", "Ik kan een project managen met een 'incrementele' aanpak   ", competenceLevels_PM_48 );
		try {
			competenceFacade.save(competenceBo_PM_48);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_49 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_49.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_49.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_49.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_49.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_49 = new CompetenceBo ("Projecten met 'hybrid agile' aanpak", "Ik kan een project managen met een 'hybrid Agile' aanpak  ", competenceLevels_PM_49 );
		try {
			competenceFacade.save(competenceBo_PM_49);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_50 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_50.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_50.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_50.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_50.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_50 = new CompetenceBo ("Projecten met 'agile'  aanpak", "Ik kan een project managen met een 'agile' aanpak  ", competenceLevels_PM_50 );
		try {
			competenceFacade.save(competenceBo_PM_50);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_51 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_51.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_51.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_51.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_51.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_51 = new CompetenceBo ("Kleine of eenvoudige projecten", "Ik kan een project managen van een kost <100.000 euro of een team < 3 FTE", competenceLevels_PM_51 );
		try {
			competenceFacade.save(competenceBo_PM_51);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_52 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_52.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_52.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_52.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_52.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_52 = new CompetenceBo ("Middelgrote projecten", "Ik kan een project managen met een kost: 100.000 euro < kost < 500.000 euro of een team: 3 FTE < team < 7 FTE", competenceLevels_PM_52 );
		try {
			competenceFacade.save(competenceBo_PM_52);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_53 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_53.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_53.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_53.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_53.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_53 = new CompetenceBo ("Grote of moeilijke projecten", "Ik kan een project managen van een kost > 500.000 euro of een team >= 7 FTE", competenceLevels_PM_53 );
		try {
			competenceFacade.save(competenceBo_PM_53);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_54 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_54.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_54.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_54.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_54.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_54 = new CompetenceBo ("Crisis projecten", "Ik kan een project rechttrekken dat in grote moeilijkheden en in crisissfeer verkeert  Junior PM: 1 Professional PM: 2", competenceLevels_PM_54 );
		try {
			competenceFacade.save(competenceBo_PM_54);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_55 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_55.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_55.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_55.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_55.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_55 = new CompetenceBo ("Samenwerken met externe partner(s)", "Ik weet hoe samen te werken met externe partners  Junior PM: 1 Professional PM: 3", competenceLevels_PM_55 );
		try {
			competenceFacade.save(competenceBo_PM_55);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_PM_58 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_58.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_58.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_58.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_58.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_58 = new CompetenceBo ("Training ", "Ik kan op een (inter)actieve  manier  kennis en vaardigheden naar deelnemers in een training overbrengen (klassikaal, via webinar…).   Dit betekent ook dat ik de aandacht van de deelnemers doorheen de training vlot kan vasthouden, dat ik kan triggeren op de nodige interactie en ik me flexibel kan opstellen in functie van de noden van de deelnemers zonder het leerdoel uit het oog te verliezen.   Bovenstaande maakt ook dat ik aandacht heb voor de voorbereiding van de training.  Ik ben me bewust van de opbouw in een training (inleiding,  kennismaking, zingeving, inhoud, outro…) en de nood aan afwisseling qua leervormen doorheen de training (cfr. KOLB).  Op basis van de ervaring en feedback breng ik ook (kleine) aanpassingen aan aan het trainingsmateriaal en de aanpak om de training nog sterker te maken. ", competenceLevels_PM_58 );
		try {
			competenceFacade.save(competenceBo_PM_58);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_59 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_59.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_59.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_59.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_59.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_59 = new CompetenceBo ("Coaching", "Ik kan via één op één gesprekken de kennis en vaardigheden van de coachee vergroten.   Dit maakt ook dat ik kan inschatten wat de maturiteit is van de coachee en in functie daarvan mijn stijl aanpas.  Dit kan gaan van eerder sturen/dicteren wat de persoon te doen heeft tot, via triggerende vragen, de persoon aanzetten tot zelfreflectie zodat hij/zij zelf tot de oplossing komt.    Ik kan me flexibel opstellen maar richt tegelijk de coaching naar het behalen van de gestelde coachingdoelen.   Ik durf de coachingsdoelen te challengen indien ze (gaandeweg) niet haalbaar lijken.", competenceLevels_PM_59 );
		try {
			competenceFacade.save(competenceBo_PM_59);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_60 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_60.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_60.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_60.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_60.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_60 = new CompetenceBo ("kennis delen", "Ik kan vlot mijn eigen kennis, ervaringen, voorbeelden delen met collega's….   Ik doe dit zowel op vraag (klankborden) als spontaan in functie van de noden.   Het gaat daarbij zowel over kennis, ervaringen, voorbeelden… die ik in mijn rol als key-user hebt verkregen als degene die ik heb opgebouwd vanuit mijn eigen prakijkt ervaring.  Daarnaast ga ik ook zelf op zoek naar extra informatie, ervaringen en voorbeelden bij collega’s om zo nog meer bagage te hebben die ik kan delen.  Dit betekent echter niet dat ik steeds zelf het antwoord kan geven, maar kan doorverwijzen waar nodig.   (gelinkt aan gedragscompetentie: “Expertise uitwisselen” en “netwerken”).    ", competenceLevels_PM_60 );
		try {
			competenceFacade.save(competenceBo_PM_60);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_61 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_61.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_61.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_61.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_61.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_61 = new CompetenceBo ("noden capteren", "Ik luister actief bij collega’s hoe zij het werken in de subject matter, waarvoor ik key-user ben, ervaren.   Waar relevant bevraag ik hen ook gericht naar ideeën/noden voor verbeteringen.  Door mijn vraagstelling ben ik ook in staat deze ideeën/noden voldoende scherp te maken.    Natuurlijk laat ik me hierbij ook inspireren door wat ikzelf vanuit de praktijk ervaar.   Dit luisteren en bevragen kan zowel in directe interactie als via digitaal.   Ik deel deze ideeën en noden ook met mijn collega key-users en coe-coordinator om te bekijken wat hiermee kan gedaan worden. (gelinkt aan gedragscompetentie: “Expertise uitwisselen” en “netwerken”).    ", competenceLevels_PM_61 );
		try {
			competenceFacade.save(competenceBo_PM_61);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_62 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_62.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_62.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_62.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_62.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_62 = new CompetenceBo ("Organiseren en faciliteren van ervaringsuitwisseling", "Ik kan (mee) een event, dag, vergadering, maar ook online forum of platform… organiseren dat medewerkers uitnodigt om met elkaar in dialoog te gaan en ervaringen  uit te wisselen.    Ik hou ook rekening met de keuze van de werkvormen en middelen.  Daarbij probeer ik zo veel als mogelijk de interactie tussen de deelnemers te stimuleren.   Ik ben in staat om tijdens het event, dag, vergadering, maar ook op een online forum of platform… de nodige interacties te doen om de ervaringsuitwisseling op een open en veilige manier te stimuleren.", competenceLevels_PM_62 );
		try {
			competenceFacade.save(competenceBo_PM_62);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_63 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_63.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_63.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_63.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_63.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_63 = new CompetenceBo ("Opvolgen en ontwikkelen van methodes en technieken", "Ik denk na en ga in interactie met collega’s (key-user) over de methodes en technieken die we met het CoE uitdragen.  Daarbij ben ik niet enkel gefocused op de methodes en technieken binnen de subject matter waarvoor ik key-user ben, maar ook hoe deze aansluiten in het groter geheel.   Zowel intern als extern hou ik een oog op de evoluties op vlak van methodes en technieken of de nood daaraan.    In het kader van projecten werk ik ook mee aan het bijsturen van bestaande of ontwikkelen van nieuwe methodes en technieken.  Ik ben daarbij voldoende pragmatisch om (gebaseerd op theorie) een in de prakijkt toepasbare methode/techniek uit te werken.", competenceLevels_PM_63 );
		try {
			competenceFacade.save(competenceBo_PM_63);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_64 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_64.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_64.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_64.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_64.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_64 = new CompetenceBo ("Advies geven bij ontwikkel/leerplannen", "Ik heb een goed beeld op het leeraanbod dat we met het CoE, waarvoor ik key-user ben, aanleveren.   Vanuit die ervaring kan ik collega’s en hun chefs ook ondersteunen bij het bepalen van de juiste training, coaching… voor de leernood.", competenceLevels_PM_64 );
		try {
			competenceFacade.save(competenceBo_PM_64);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_65 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_65.add (new CompetenceLevelBo("geen ervaring", 1));
		competenceLevels_PM_65.add (new CompetenceLevelBo("enige ervaring", 2));
		competenceLevels_PM_65.add (new CompetenceLevelBo("voldoende ervaring, autonoom werken", 3));
		competenceLevels_PM_65.add (new CompetenceLevelBo("ruime expertise, als expert aanzien ook buiten dienst", 4));


		CompetenceBo competenceBo_PM_65 = new CompetenceBo ("Kennis hebben van de BP&S processen en services", "Ik kan de verschillende aspecten (informatie, tools, werkprocessen, methodes, technieken, best practices…) van de subject matter waarvoor ik key-user ben plaatsen in services die we met BP&S leveren en hun achterliggende processen.  In het kader van coachings, klankborden, trainingen… ben ik ook in staat om dit in mijn eigen woorden toe te lichten waar nodig.  ", competenceLevels_PM_65 );
		try {
			competenceFacade.save(competenceBo_PM_65);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_PM_68 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_68.add (new CompetenceLevelBo(" maakt doelen, rollen, werkwijze duidelijk voor een team", 1));
		competenceLevels_PM_68.add (new CompetenceLevelBo(" verkrijgt instemming in een team over doelen, rollen, spelregels en werkwijze", 2));
		competenceLevels_PM_68.add (new CompetenceLevelBo("- Junior PM:  benoemt groepsdynamische processen in het team", 3));
		competenceLevels_PM_68.add (new CompetenceLevelBo("- Professional PM:  geeft via open dialoog betekenis aan het groepsdynamisch proces en komt samen met de groep tot duidelijke afspraken", 4));
		competenceLevels_PM_68.add (new CompetenceLevelBo(" faciliteert groepsdynamische processen bij groepen met ingewikkelde en tegenstrijdigde belangen", 5));


		CompetenceBo competenceBo_PM_68 = new CompetenceBo ("Teamleiderschap", "Definitie:  Betrokkenheid rond een doel creëren, stimuleren en faciliteren, en de groepsdynamiek bewaken.  ", competenceLevels_PM_68 );
		try {
			competenceFacade.save(competenceBo_PM_68);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_69 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_69.add (new CompetenceLevelBo(" doet wat van hem/haar gevraagd wordt", 1));
		competenceLevels_PM_69.add (new CompetenceLevelBo(" zet door en grijpt in wanneer niet alles naar wens verloopt", 2));
		competenceLevels_PM_69.add (new CompetenceLevelBo(" definieert eigen prestatieniveaus en stuurt anderen bij", 3));
		competenceLevels_PM_69.add (new CompetenceLevelBo(" formuleert naar anderen duidelijke criteria waarbinnen gewerkt moet worden", 4));
		competenceLevels_PM_69.add (new CompetenceLevelBo(" defnieert uitdagende doelstellingen", 5));


		CompetenceBo competenceBo_PM_69 = new CompetenceBo ("Doelgerichtheid", "Definitie: Het doorzettingsvermogen om goed werk af te leveren en doelstellingen te behalen.  ", competenceLevels_PM_69 );
		try {
			competenceFacade.save(competenceBo_PM_69);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_70 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_70.add (new CompetenceLevelBo(" brengt eenvoudige boodschappen op een gestructureerde manier", 1));
		competenceLevels_PM_70.add (new CompetenceLevelBo(" luistert naar zijn/haar publiek en beantwoordt vragen", 2));
		competenceLevels_PM_70.add (new CompetenceLevelBo("- Junior PM:  brengt een complexe boodschap op een rechtstreekse, aangepaste manier naar het doelpubliek", 3));
		competenceLevels_PM_70.add (new CompetenceLevelBo("- Professional PM:  toetst actief af of de boodschap door iedereen begrepen is en herformuleert", 4));
		competenceLevels_PM_70.add (new CompetenceLevelBo(" beargumenteert zijn/haar boodschap beheerst en brengt de verschillende meningen terug tot de kern", 5));


		CompetenceBo competenceBo_PM_70 = new CompetenceBo ("Communicatief vermogen", "Defintiie:  Het vermogen om op een directe, rechtstreeks en interactieve manier een boodschap (over) te brengen.  ", competenceLevels_PM_70 );
		try {
			competenceFacade.save(competenceBo_PM_70);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_71 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_71.add (new CompetenceLevelBo(" beheert eigen dagdagelijkse activiteiten", 1));
		competenceLevels_PM_71.add (new CompetenceLevelBo(" zet de eigne activiteiten uit in een realistisch tijdschema", 2));
		competenceLevels_PM_71.add (new CompetenceLevelBo(" maakt een realistische en concrete planning voor zijn/haar rechtstreekse medewerkers/opdrachtgevers", 3));
		competenceLevels_PM_71.add (new CompetenceLevelBo(" toetst de haalbaarheid van de planning af, volgt die op en stuurt bij in functie van onvoorziene omstandigheden", 4));
		competenceLevels_PM_71.add (new CompetenceLevelBo(" zet de activiteiten voor breed doelpubliek uit, rekening houdend met prioriteiten en te behalen doelstellingen", 5));


		CompetenceBo competenceBo_PM_71 = new CompetenceBo ("Operationeel plannen", "Definitie: De capaciteit om een concrete planning voor zichzefl en/of eventuele medewerkers te maken zodat de doelstellingen binnen de vooropgestelde termijn worden behaald.  Toevoeging specifiek voor PM's: proactief handelen  ", competenceLevels_PM_71 );
		try {
			competenceFacade.save(competenceBo_PM_71);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_72 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_72.add (new CompetenceLevelBo(" reageert op vragen van klanten volgens bestaande dienstverlening en service", 1));
		competenceLevels_PM_72.add (new CompetenceLevelBo(" luistert naar klantennoden en behandelt deze", 2));
		competenceLevels_PM_72.add (new CompetenceLevelBo(" overlegt en stemt af met de klant over de gewenste diensten/producten", 3));
		competenceLevels_PM_72.add (new CompetenceLevelBo(" gaat actief op zoek bij anderen om dienstverlening en producten te optimaliseren", 4));
		competenceLevels_PM_72.add (new CompetenceLevelBo(" speelt proactief in op noden en verwachtingen en bouwt aan een duurzame klantenrelatie", 5));


		CompetenceBo competenceBo_PM_72 = new CompetenceBo ("Klantgerichtheid", "Defintie: Het vermogen om actief op zoek te gaan naar en in te spelen op diensten en producten die een toegevoegde waarde hebben voor anderen (interne en externe klanten, collega's, partners,…).  Specifieke toevoeging voor PM's: business accumen (in staat zijn mee te denken met de business)  ", competenceLevels_PM_72 );
		try {
			competenceFacade.save(competenceBo_PM_72);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_73 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_73.add (new CompetenceLevelBo(" bepaalt in een eenvoudig gegeven de verschillende stappen", 1));
		competenceLevels_PM_73.add (new CompetenceLevelBo(" faseert binnen een gegeven de mijlpalen in een realistisch tijdsschema", 2));
		competenceLevels_PM_73.add (new CompetenceLevelBo(" optimaliseert eigen stappenplan door ze af te stemmen op aanverwante projecten", 3));
		competenceLevels_PM_73.add (new CompetenceLevelBo(" maakt in een complex gegeven een efficiënt en effectief stappenplan", 4));
		competenceLevels_PM_73.add (new CompetenceLevelBo(" integreert de verschillende doelstellingen in één strategisch plan", 5));


		CompetenceBo competenceBo_PM_73 = new CompetenceBo ("Strategisch organiseren", "Definitie: De capaciteit om op een effectieve en efficiënte manier tot een globaal stappenplan te komen, dit verder aan/bij te sturen opdate de beoogde doelstelling gerealiseerd kan worden.  ", competenceLevels_PM_73 );
		try {
			competenceFacade.save(competenceBo_PM_73);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_74 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_74.add (new CompetenceLevelBo(" bepaalt de vereiste competenties in een team voglens de uit te voeren taken/opdrachten", 1));
		competenceLevels_PM_74.add (new CompetenceLevelBo("- Junior PM:  zet de talenten van elk teamlid in", 2));
		competenceLevels_PM_74.add (new CompetenceLevelBo("- Professional PM:  besteedt aandacht aan complementariteit en diversiteit in een team", 3));
		competenceLevels_PM_74.add (new CompetenceLevelBo(" stelt doelgericht teams samen opdat strategische doelstellingen gerealiseerd kunnen worden", 4));
		competenceLevels_PM_74.add (new CompetenceLevelBo(" promoot doelgerichte uitwisseling van teamleden en creëert zelfsturende teams", 5));


		CompetenceBo competenceBo_PM_74 = new CompetenceBo ("Ontwikkelen van teams", "Definitie: Het creëren van een sterk team, door bewust vaardigheden, attitudes en kennis in te zetten.  ", competenceLevels_PM_74 );
		try {
			competenceFacade.save(competenceBo_PM_74);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_75 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_75.add (new CompetenceLevelBo(" benadert situaties vanuit opportuniteit.", 1));
		competenceLevels_PM_75.add (new CompetenceLevelBo("- Junior PM:  brent een boodschap op authentieke, enthousiaste manier en beantwoordt vragen vanuit opportuniteit.", 2));
		competenceLevels_PM_75.add (new CompetenceLevelBo("- Professional PM:  luistert actief naar vragen, zorgen en noden en zorgt voor een werkbare context", 3));
		competenceLevels_PM_75.add (new CompetenceLevelBo(" hanteert gepaste overtuigingstechnieken en vraagstelling zodat iedereen de toegevoegde waarde voor zichzelf ontdekt", 4));
		competenceLevels_PM_75.add (new CompetenceLevelBo(" blijft actief peilen naar enthousiasme en engagement bij anderen en anticipeert hierop", 5));


		CompetenceBo competenceBo_PM_75 = new CompetenceBo ("Energie mobiliseren", "Definitie:  Op een authentieken manier enthousiasme en engagement rond een doel of project verkrijgen door zelf enthousiasme uit te stralen, iedereen de toegevoegde waarde te laten ontdekken en een werkbare context te creëren.  Toevoeging specifiek voor PM's: empoweren van teams in project context  ", competenceLevels_PM_75 );
		try {
			competenceFacade.save(competenceBo_PM_75);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_76 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_76.add (new CompetenceLevelBo(" is in staat mits input van anderen zelf tot een oplossing te komen", 1));
		competenceLevels_PM_76.add (new CompetenceLevelBo(" denkt snel in termen van oplossing en past opgedane ervaringen toe", 2));
		competenceLevels_PM_76.add (new CompetenceLevelBo("- Junior PM:  formuleert verschillende alternatieve oplossingen voor een probleem", 3));
		competenceLevels_PM_76.add (new CompetenceLevelBo("- Professional PM:  komt met creatieve, originele oplossingen voor een complex probleem", 4));
		competenceLevels_PM_76.add (new CompetenceLevelBo(" komt in een complexe situatie tot een effectieven en snelle probleemaanpak", 5));


		CompetenceBo competenceBo_PM_76 = new CompetenceBo ("Probleemoplossend vermogen", "Definitie: Het vermogen om situaties en problemen op een snelle en doeltreffende manier op te lossen.  Toevoeging specifiek voor PM's: KISS (het vermogen om het eenvoudig te houden, niet moeilijker dan nodig) en persoonlijke efficiëntie & effectiviteit.  ", competenceLevels_PM_76 );
		try {
			competenceFacade.save(competenceBo_PM_76);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_77 = new HashSet<CompetenceLevelBo>();
		competenceLevels_PM_77.add (new CompetenceLevelBo(" werkt bij wisselende, onvoorziene omstandigheden op dezelfde manier verder en toont hierbij emotionele reactie", 1));
		competenceLevels_PM_77.add (new CompetenceLevelBo(" past het gedrag ad hoc aan bij wisselende, onvoorziene omstandigheden", 2));
		competenceLevels_PM_77.add (new CompetenceLevelBo("- Junior PM:  blijft nuchter bij wisselende, onvoorziene omstandigheden en past zijn/haar aanpak doelgericht aan", 3));
		competenceLevels_PM_77.add (new CompetenceLevelBo("- Professional PM:  stuurt in een complexe situatie, doelgericht de initiële aanpak bij in functie van de wisselende omstandigheden", 4));
		competenceLevels_PM_77.add (new CompetenceLevelBo(" kiest bij wisselende, onvoorziene omstandigheden voor de meest efficiënte aanpak", 5));


		CompetenceBo competenceBo_PM_77 = new CompetenceBo ("Aanpassingsvermogen", "Definitie: De capaciteit om, met het oog op het bereiken van een bepaald doel, de werkwijze op een efficiënte manier bij te sturen en aan te passen.  ", competenceLevels_PM_77 );
		try {
			competenceFacade.save(competenceBo_PM_77);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_PM_80 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_80 = new CompetenceBo ("Strategy & Change: Strategy Definition & Governance", "", competenceLevels_PM_80 );
		try {
			competenceFacade.save(competenceBo_PM_80);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_81 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_81 = new CompetenceBo ("Strategy & Change: Business Change Mgmt", "", competenceLevels_PM_81 );
		try {
			competenceFacade.save(competenceBo_PM_81);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_82 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_82 = new CompetenceBo ("Resource Planning: Strategic Resource Planning", "", competenceLevels_PM_82 );
		try {
			competenceFacade.save(competenceBo_PM_82);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_83 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_83 = new CompetenceBo ("Risk & Compliance: Risk & Compliance Mgmt", "", competenceLevels_PM_83 );
		try {
			competenceFacade.save(competenceBo_PM_83);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_84 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_84 = new CompetenceBo ("Market Watch", "", competenceLevels_PM_84 );
		try {
			competenceFacade.save(competenceBo_PM_84);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_85 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_85 = new CompetenceBo ("Performance Watch", "", competenceLevels_PM_85 );
		try {
			competenceFacade.save(competenceBo_PM_85);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_86 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_86 = new CompetenceBo ("Sustainability Mgmt", "", competenceLevels_PM_86 );
		try {
			competenceFacade.save(competenceBo_PM_86);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_87 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_87 = new CompetenceBo ("Innovation: R&D & Innovation", "", competenceLevels_PM_87 );
		try {
			competenceFacade.save(competenceBo_PM_87);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_88 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_88 = new CompetenceBo ("Stakeholder Relations & Reputation: Stakeholder Relations & Reputation Mgmt", "", competenceLevels_PM_88 );
		try {
			competenceFacade.save(competenceBo_PM_88);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_89 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_89 = new CompetenceBo ("Stakeholder Relations & Reputation: Public Relations Mgmt", "", competenceLevels_PM_89 );
		try {
			competenceFacade.save(competenceBo_PM_89);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_90 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_90 = new CompetenceBo ("Stakeholder Relations & Reputation: Party Mgmt", "", competenceLevels_PM_90 );
		try {
			competenceFacade.save(competenceBo_PM_90);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_91 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_91 = new CompetenceBo ("Communication & Collaboration: Commication & Collaboration", "", competenceLevels_PM_91 );
		try {
			competenceFacade.save(competenceBo_PM_91);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_92 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_92 = new CompetenceBo ("Communication & Collaboration: Workplace Mgmt", "", competenceLevels_PM_92 );
		try {
			competenceFacade.save(competenceBo_PM_92);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_93 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_93 = new CompetenceBo ("Digital: Digitalisation Mgmt", "", competenceLevels_PM_93 );
		try {
			competenceFacade.save(competenceBo_PM_93);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_94 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_94 = new CompetenceBo ("Service, Process & Organisation: Organisation Mgmt", "", competenceLevels_PM_94 );
		try {
			competenceFacade.save(competenceBo_PM_94);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_95 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_95 = new CompetenceBo ("Service, Process & Organisation: Process & Service Design", "", competenceLevels_PM_95 );
		try {
			competenceFacade.save(competenceBo_PM_95);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_96 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_96 = new CompetenceBo ("Service, Process & Organisation: Enterprise Service Mgmt", "", competenceLevels_PM_96 );
		try {
			competenceFacade.save(competenceBo_PM_96);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_97 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_97 = new CompetenceBo ("Information: Information Mgmt", "", competenceLevels_PM_97 );
		try {
			competenceFacade.save(competenceBo_PM_97);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_98 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_98 = new CompetenceBo ("Information: Content & Document Mgmt", "", competenceLevels_PM_98 );
		try {
			competenceFacade.save(competenceBo_PM_98);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_99 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_99 = new CompetenceBo ("Coworker: Co-worker Mgmt", "", competenceLevels_PM_99 );
		try {
			competenceFacade.save(competenceBo_PM_99);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_100 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_100 = new CompetenceBo ("Coworker: Training Mgmt", "", competenceLevels_PM_100 );
		try {
			competenceFacade.save(competenceBo_PM_100);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_101 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_101 = new CompetenceBo ("Infrastructure: Real Estate Mgmt", "", competenceLevels_PM_101 );
		try {
			competenceFacade.save(competenceBo_PM_101);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_102 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_102 = new CompetenceBo ("Infrastructure: Tanglible Asset Lifecycle Mgmt", "", competenceLevels_PM_102 );
		try {
			competenceFacade.save(competenceBo_PM_102);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_103 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_103 = new CompetenceBo ("Infrastructure: Facility & Field Service Mgmt", "", competenceLevels_PM_103 );
		try {
			competenceFacade.save(competenceBo_PM_103);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_104 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_104 = new CompetenceBo ("IT Infrasturcture & Solutions: ICT Mgmt", "", competenceLevels_PM_104 );
		try {
			competenceFacade.save(competenceBo_PM_104);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_105 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_105 = new CompetenceBo ("Brand, Customer, Marketingpromotion: (B2C) Marketing Promotion (BE)", "", competenceLevels_PM_105 );
		try {
			competenceFacade.save(competenceBo_PM_105);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_106 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_106 = new CompetenceBo ("Brand, Customer, Marketingpromotion: Brand Mgmt", "", competenceLevels_PM_106 );
		try {
			competenceFacade.save(competenceBo_PM_106);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_107 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_107 = new CompetenceBo ("Brand, Customer, Marketingpromotion: Customer Mgmt", "", competenceLevels_PM_107 );
		try {
			competenceFacade.save(competenceBo_PM_107);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_108 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_108 = new CompetenceBo ("Product: Product Mgmt", "", competenceLevels_PM_108 );
		try {
			competenceFacade.save(competenceBo_PM_108);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_109 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_109 = new CompetenceBo ("Procuct: Product Group Mgmt", "", competenceLevels_PM_109 );
		try {
			competenceFacade.save(competenceBo_PM_109);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_110 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_110 = new CompetenceBo ("Procuct: Product Information Mgmt", "", competenceLevels_PM_110 );
		try {
			competenceFacade.save(competenceBo_PM_110);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_111 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_111 = new CompetenceBo ("Purchasing Direct Goods: Direct Purchase Mgmt", "", competenceLevels_PM_111 );
		try {
			competenceFacade.save(competenceBo_PM_111);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_112 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_112 = new CompetenceBo ("Purchasing Direct Goods: Retail Product Costing", "", competenceLevels_PM_112 );
		try {
			competenceFacade.save(competenceBo_PM_112);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_113 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_113 = new CompetenceBo ("Purchasing Direct Goods: Purchase Operations Food", "", competenceLevels_PM_113 );
		try {
			competenceFacade.save(competenceBo_PM_113);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_114 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_114 = new CompetenceBo ("Purchasing Indirect Goods & Services: Indirect Purchasing", "", competenceLevels_PM_114 );
		try {
			competenceFacade.save(competenceBo_PM_114);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_115 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_115 = new CompetenceBo ("Purchasing Indirect Goods & Services: Indirect Product Information Mgmt", "", competenceLevels_PM_115 );
		try {
			competenceFacade.save(competenceBo_PM_115);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_116 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_116 = new CompetenceBo ("Purchasing Indirect Goods & Services: Internal Wholesale of Indirect Goods", "", competenceLevels_PM_116 );
		try {
			competenceFacade.save(competenceBo_PM_116);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_117 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_117 = new CompetenceBo ("Supplier: Supplier Mgmt", "", competenceLevels_PM_117 );
		try {
			competenceFacade.save(competenceBo_PM_117);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_118 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_118 = new CompetenceBo ("Supply Chain Food: Supply Chain Food", "", competenceLevels_PM_118 );
		try {
			competenceFacade.save(competenceBo_PM_118);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_119 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_119 = new CompetenceBo ("Supply Chain Food: Logistic Workforce Mgmt", "", competenceLevels_PM_119 );
		try {
			competenceFacade.save(competenceBo_PM_119);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_120 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_120 = new CompetenceBo ("Supply Chain Food: Sales Forecasting Food", "", competenceLevels_PM_120 );
		try {
			competenceFacade.save(competenceBo_PM_120);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_121 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_121 = new CompetenceBo ("E-Commerce Food: E-commerce B2C Food", "", competenceLevels_PM_121 );
		try {
			competenceFacade.save(competenceBo_PM_121);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_122 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_122 = new CompetenceBo ("E-Commerce Food: nonFood", "", competenceLevels_PM_122 );
		try {
			competenceFacade.save(competenceBo_PM_122);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_123 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_123 = new CompetenceBo ("Store Sales: Food Retail Store Sales", "", competenceLevels_PM_123 );
		try {
			competenceFacade.save(competenceBo_PM_123);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_124 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_124 = new CompetenceBo ("Store Sales: Store Workforce Mgmt", "", competenceLevels_PM_124 );
		try {
			competenceFacade.save(competenceBo_PM_124);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_125 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_125 = new CompetenceBo ("Price: B2C Price Mgmt", "", competenceLevels_PM_125 );
		try {
			competenceFacade.save(competenceBo_PM_125);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_PM_128 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_128 = new CompetenceBo ("Colruyt Laagste Prijs", "", competenceLevels_PM_128 );
		try {
			competenceFacade.save(competenceBo_PM_128);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_129 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_129 = new CompetenceBo ("OKay", "", competenceLevels_PM_129 );
		try {
			competenceFacade.save(competenceBo_PM_129);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_130 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_130 = new CompetenceBo ("Bio-Planet", "", competenceLevels_PM_130 );
		try {
			competenceFacade.save(competenceBo_PM_130);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_131 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_131 = new CompetenceBo ("CRU", "", competenceLevels_PM_131 );
		try {
			competenceFacade.save(competenceBo_PM_131);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_132 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_132 = new CompetenceBo ("Dreamland", "", competenceLevels_PM_132 );
		try {
			competenceFacade.save(competenceBo_PM_132);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_133 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_133 = new CompetenceBo ("Dreambaby", "", competenceLevels_PM_133 );
		try {
			competenceFacade.save(competenceBo_PM_133);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_134 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_134 = new CompetenceBo ("Collishop", "", competenceLevels_PM_134 );
		try {
			competenceFacade.save(competenceBo_PM_134);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_135 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_135 = new CompetenceBo ("Retail Partners Colruyt Group", "", competenceLevels_PM_135 );
		try {
			competenceFacade.save(competenceBo_PM_135);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_136 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_136 = new CompetenceBo ("Solucious", "", competenceLevels_PM_136 );
		try {
			competenceFacade.save(competenceBo_PM_136);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_137 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_137 = new CompetenceBo ("Colex", "", competenceLevels_PM_137 );
		try {
			competenceFacade.save(competenceBo_PM_137);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_138 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_138 = new CompetenceBo ("Dats 24", "", competenceLevels_PM_138 );
		try {
			competenceFacade.save(competenceBo_PM_138);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_139 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_139 = new CompetenceBo ("Collect & Go", "", competenceLevels_PM_139 );
		try {
			competenceFacade.save(competenceBo_PM_139);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_140 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_140 = new CompetenceBo ("Transport", "", competenceLevels_PM_140 );
		try {
			competenceFacade.save(competenceBo_PM_140);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_141 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_141 = new CompetenceBo ("Retail Service Center", "", competenceLevels_PM_141 );
		try {
			competenceFacade.save(competenceBo_PM_141);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_142 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_142 = new CompetenceBo ("Fine Food", "", competenceLevels_PM_142 );
		try {
			competenceFacade.save(competenceBo_PM_142);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_143 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_143 = new CompetenceBo ("In Cont@ct", "", competenceLevels_PM_143 );
		try {
			competenceFacade.save(competenceBo_PM_143);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_144 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_144 = new CompetenceBo ("BP&S", "", competenceLevels_PM_144 );
		try {
			competenceFacade.save(competenceBo_PM_144);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_145 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_145 = new CompetenceBo ("Finance", "", competenceLevels_PM_145 );
		try {
			competenceFacade.save(competenceBo_PM_145);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_146 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_146 = new CompetenceBo ("M&O", "", competenceLevels_PM_146 );
		try {
			competenceFacade.save(competenceBo_PM_146);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_147 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_147 = new CompetenceBo ("T&I", "", competenceLevels_PM_147 );
		try {
			competenceFacade.save(competenceBo_PM_147);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_148 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_148 = new CompetenceBo ("Colruyt Group Energy", "", competenceLevels_PM_148 );
		try {
			competenceFacade.save(competenceBo_PM_148);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_149 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_149 = new CompetenceBo ("CCX & Corporate Marketing", "° Symeta ° Premedia ° Corporate marketing", competenceLevels_PM_149 );
		try {
			competenceFacade.save(competenceBo_PM_149);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_PM_150 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_PM_150 = new CompetenceBo ("Corporate operating unit", "", competenceLevels_PM_150 );
		try {
			competenceFacade.save(competenceBo_PM_150);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




/** Filling the Software Eng **/

		HashSet<CompetenceLevelBo> competenceLevels_SE_15 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_15.add (new CompetenceLevelBo(" ik begrijp waarvoor de PCLC staat, maar het blijft ver van mijn bed-show. Ik gebruik die niet als gids.", 1));
		competenceLevels_SE_15.add (new CompetenceLevelBo(" ik begrijp waarvoor de PCLC staat, maar gebruik die eerder zelden", 2));
		competenceLevels_SE_15.add (new CompetenceLevelBo(" ik gebruik de PCLC echt als mijn leidraad en pas dus de activiteiten en deliverables toe waar ik die nodig acht in een project", 3));
		competenceLevels_SE_15.add (new CompetenceLevelBo(" ik spreek ook anderen aan over het gebruik van de PCLC binnen het projectteam", 4));


		CompetenceBo competenceBo_SE_15 = new CompetenceBo ("PCLC as a Guide", "Uitleg: De PCLC of Project Content Life Cycle is een soort 'proces', een stappenplan waarin staat wat een team te doen staat, willen ze een solution realizeren. Afhankelijk van het type solution (procesoptimalisatie, IT solution, machine, ...) ga je andere activiteiten uitvoeren.  ", competenceLevels_SE_15 );
		try {
			competenceFacade.save(competenceBo_SE_15);
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
			competenceFacade.save(competenceBo_SE_16);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_17 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_17.add (new CompetenceLevelBo(" ik doe wat ik denk dat nodig is. Ik gebruik daarvoor geen referentiemateriaal of templates.", 1));
		competenceLevels_SE_17.add (new CompetenceLevelBo(" ik gebruik in projecten bijna steeds dezelde templates of deliverables, als die al nodig zijn. Ik weet waar ik die kan vinden, en zoek verder nooit naar iets extra.", 2));
		competenceLevels_SE_17.add (new CompetenceLevelBo(" ik weet wat ik als basis op te leveren heb in een project, maar ik ga toch nu en dan eens zoeken op de PCLC site (of andere site). Ik weet graag of er een update is, of een mogelijk andere techniek die me beter kan helpen", 3));
		competenceLevels_SE_17.add (new CompetenceLevelBo(" ik neem steevast de PCLC-lijst met deliverables erbij, zodat ik ten alle tijde weet welke types deliverables en templates ik kan gebruiken. Want afhankelijk van de solution, kunnen andere templates of methodieken me zeker beter helpen.", 4));


		CompetenceBo competenceBo_SE_17 = new CompetenceBo ("Activities and Deliverables", "Uitleg: Rollen voeren specifieke activiteiten uit. En heel vaak wordt er ook informatie verzameld of aangevuld, en daarvoor is er vaak een template ter beschikking. Alle uitleg over die activiteiten en die deliverables vind je op de PCLC-site.  ", competenceLevels_SE_17 );
		try {
			competenceFacade.save(competenceBo_SE_17);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
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
			competenceFacade.save(competenceBo_SE_18);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_19 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_19.add (new CompetenceLevelBo(" ik heb geen idee waar ik terecht kan als ik vragen heb, tenzij bij mijn chef dan. Ik trek mijn plan op mijn eentje.", 1));
		competenceLevels_SE_19.add (new CompetenceLevelBo(" als ik hulp zou nodig hebben, dan ga ik te rade bij collega's (die dezelfde rol opnemen) die me kunnen helpen", 2));
		competenceLevels_SE_19.add (new CompetenceLevelBo(" ik weet waar ik terecht kan voor hulp, en ik schakel die in of zou die inschakelen wanneer ik dat nodig vind", 3));
		competenceLevels_SE_19.add (new CompetenceLevelBo(" ik ben een referentie voor collega's en stuur hen door naar de site of naar key user(s), of maak er toch reclame voor, als zij met vragen komen. Kwestie dat ook zij de hulpbronnen leren kennen.", 4));


		CompetenceBo competenceBo_SE_19 = new CompetenceBo ("Supporting material and support", "Uitleg: Er is een PCLC site waarop alle info rond de 'Realize a solution'-stappen, rollen, activiteiten, deliverables en templates gecentraliseerd staat. Daarnaast zijn er nog CoE coördinatoren en key users die per discipline ondersteuning en coaching kunnen geven bij het uitoefenen van je rol.  ", competenceLevels_SE_19 );
		try {
			competenceFacade.save(competenceBo_SE_19);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_SE_22 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_22.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_22.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_22.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_22.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_22 = new CompetenceBo ("Deliver Online Application MF CICS/PL1", "I can design, develop, test and deploy a CICS-application (CICS handling + PL1 + ACF2 API) on either an IDMS or DB2 database, using the standard development tooling (ADMI, TSO, TLNK, AbendAid, chainings) in line with the company standards. ", competenceLevels_SE_22 );
		try {
			competenceFacade.save(competenceBo_SE_22);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_23 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_23.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_23.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_23.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_23.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_23 = new CompetenceBo ("Deliver Online Application MF O*", "I can design, develop, test and deploy an online O* application on either an IDMS or O* database, using the standard software development tool(s), ADMI, Debug and testing tools, Database query tools and in line with the company standards (screen layout, design rules,...)", competenceLevels_SE_23 );
		try {
			competenceFacade.save(competenceBo_SE_23);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_24 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_24.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_24.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_24.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_24.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_24 = new CompetenceBo ("Deliver IMSL Service MF", "I can design, develop, test and deploy a CICS-application as an IMSL service provider/requester (CICS handling + PL1 + IMSL procedures) on either an IDMS or DB2 database, using the standard software development tool(s), ADMI, Debug and testing tools, Database query tools.", competenceLevels_SE_24 );
		try {
			competenceFacade.save(competenceBo_SE_24);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_25 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_25.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_25.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_25.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_25.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_25 = new CompetenceBo ("Deliver Webservice SOAP MF", "I can design, develop, test and deploy a CICS-application which is a webservice provider/requester (XML, CICS handling, SOAP API + PL1) on either an IDMS or DB2 database, using the standard software development tool(s), ADMI, Debug and testing tools, Database query tools.", competenceLevels_SE_25 );
		try {
			competenceFacade.save(competenceBo_SE_25);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_26 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_26.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_26.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_26.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_26.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_26 = new CompetenceBo ("Deliver Webservice REST MF", "I can design, develop, test deploy a CICS-application which is a webservice provider/requester (XML, CICS handling, REST API + PL1) on either an IDMS or DB2 database, using the standard software development tool(s), ADMI, Debug and testing tools, Database query tools. ", competenceLevels_SE_26 );
		try {
			competenceFacade.save(competenceBo_SE_26);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_27 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_27.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_27.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_27.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_27.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_27 = new CompetenceBo ("Deliver Batch MF PL1", "I can design, develop, test and deploy a PL1 batch cycle including applications on either an IDMS or DB2 database, using the standard software development tool(s), ADMI, Debug and testing tools, Database query tools, in line with the company standards (EUP, design rules,...) ", competenceLevels_SE_27 );
		try {
			competenceFacade.save(competenceBo_SE_27);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_28 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_28.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_28.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_28.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_28.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_28 = new CompetenceBo ("Deliver Batch MF O*", "I can design, develop, test and deploy a MF batch cycle including O* applications on an O* database, using the standard software development tool(s), ADMI, Debug and testing tools, Database query tools and in line with the company standards (design rules, EUP,...) ", competenceLevels_SE_28 );
		try {
			competenceFacade.save(competenceBo_SE_28);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_29 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_29.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_29.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_29.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_29.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_29 = new CompetenceBo ("Deliver Webapplication Java Colruyt Stack", "I can design, develop, test and deploy a fullstack webapplication in Colruyt Java stack (baseframe, webframe, webtags) on either a Oracle or DB2 database, using the standard development tooling (RAD, IntelliJ/Eclipse, Git) ", competenceLevels_SE_29 );
		try {
			competenceFacade.save(competenceBo_SE_29);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_30 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_30.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_30.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_30.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_30.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_30 = new CompetenceBo ("Deliver Webapplication Fullstack JSF-JEE", "I can design, develop, test and deploy a fullstack webapplication in the JSF-JEE stack (JSF, EJB, JPA) on either a Oracle or DB2 database, using the standard development tooling (IntelliJ/Eclipse, Git, Gradle)", competenceLevels_SE_30 );
		try {
			competenceFacade.save(competenceBo_SE_30);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_31 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_31.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_31.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_31.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_31.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_31 = new CompetenceBo ("Deliver Webapplication Backend JEE", "I can design, develop, test and deploy a backend application exposing REST services in the JEE stack (EJB, JPA/Hibernate), getting data either on an Oracle or DB2 database, using the development tooling (RAD, IntelliJ/Eclipse, RTC, RAM, Git) ", competenceLevels_SE_31 );
		try {
			competenceFacade.save(competenceBo_SE_31);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_32 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_32.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_32.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_32.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_32.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_32 = new CompetenceBo ("Deliver Webapplication Backend Spring", "I can design, develop, test and deploy a backend application (using Java 8) exposing REST services in the Spring stack (SpringBoot, SpringCloud, JPA/Hibernate), getting data either on an Oracle or DB2 database, using the development tooling (IntelliJ/Eclipse, Git) ", competenceLevels_SE_32 );
		try {
			competenceFacade.save(competenceBo_SE_32);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_33 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_33.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_33.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_33.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_33.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_33 = new CompetenceBo ("Deliver Webapplication Frontend Angular", "I can design, develop, test and deploy a frontend application in a Javascript based framework running on Angular, JavaScript, TypeScript and HTML, interacting with (Spring) REST-services, using the standard development tooling (IntelliJ/Eclipse, Visual Code, Git) ", competenceLevels_SE_33 );
		try {
			competenceFacade.save(competenceBo_SE_33);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_34 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_34.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_34.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_34.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_34.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_34 = new CompetenceBo ("Deliver IMSL Service Java ", "I can design, develop, test and deploy a java-application as an IMSL service provider/requester (java + IMSL procedures) on either an Oracle or DB2 database, using the standard software development tool(s) (RAD, Eclipse/IntelliJ,…) ", competenceLevels_SE_34 );
		try {
			competenceFacade.save(competenceBo_SE_34);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_35 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_35.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_35.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_35.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_35.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_35 = new CompetenceBo ("Deliver Webservice SOAP JEE (HTTP & MQ)", "I can design, develop, test and deploy SOAP (JAX-WS) service provider and client application using the standard tooling (IntelliJ/Eclipse, Git, Gradle)", competenceLevels_SE_35 );
		try {
			competenceFacade.save(competenceBo_SE_35);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_36 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_36.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_36.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_36.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_36.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_36 = new CompetenceBo ("Deliver Webservice REST JEE ", "I can design, develop, test and deploy REST (JAX-RS) service provider and client application using the standard tooling (Swagger/OpenAPI, IntelliJ/Eclipse, Git, Gradle) ", competenceLevels_SE_36 );
		try {
			competenceFacade.save(competenceBo_SE_36);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_37 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_37.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_37.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_37.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_37.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_37 = new CompetenceBo ("Deliver Async service JEE", "I can design, develop, test and deploy Async (JMS/EJB) service provider and client application using the standard tooling (AsyncAPI/YAML, IntelliJ/Eclipse, Git, Gradle) ", competenceLevels_SE_37 );
		try {
			competenceFacade.save(competenceBo_SE_37);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_38 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_38.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_38.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_38.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_38.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_38 = new CompetenceBo ("Deliver Batch Load Cycle SQL", "I can design, develop, test and deploy a loadcycle (XPS) based on sql-scripts on an Oracle database, using the standard software development tool(s).", competenceLevels_SE_38 );
		try {
			competenceFacade.save(competenceBo_SE_38);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_39 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_39.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_39.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_39.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_39.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_39 = new CompetenceBo ("Deliver Batch Load Cycle PL/SQL", "I can design, develop, test and deploy a loadcycle (XPS) based on PL/SQL  on an Oracle database, using the standard software development tool(s).", competenceLevels_SE_39 );
		try {
			competenceFacade.save(competenceBo_SE_39);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_40 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_40.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_40.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_40.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_40.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_40 = new CompetenceBo ("Deliver Batch Java Colruyt stack ", "I can design, develop, test and deploy a fullstack webapplication using JSP and servlets, exposing the frontend by a Colruyt specific taglibrary and writing code relaying on the 1.5 Java code standard, getting data either on an Oracle or DB2 database, using the development tooling (WAS, RAM and RTC)  ", competenceLevels_SE_40 );
		try {
			competenceFacade.save(competenceBo_SE_40);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_41 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_41.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_41.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_41.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_41.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_41 = new CompetenceBo ("Deliver Batch JEE  ", "I can design, develop, test and deploy Java batch (XPS) application using the standard tooling (IntelliJ/Eclipse, Git, Gradle) ", competenceLevels_SE_41 );
		try {
			competenceFacade.save(competenceBo_SE_41);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_42 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_42.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_42.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_42.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_42.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_42 = new CompetenceBo ("Deliver Island Application Access", "I can design, develop, test and deploy an Microsoft Access-based Island application, using the standard development tooling, in line with the company standards. ", competenceLevels_SE_42 );
		try {
			competenceFacade.save(competenceBo_SE_42);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_43 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_43.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_43.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_43.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_43.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_43 = new CompetenceBo ("Deliver Island Application Excel", "I can design, develop, test and deploy an Microsoft Excel-based Island application, using the standard development tooling, in line with the company standards.", competenceLevels_SE_43 );
		try {
			competenceFacade.save(competenceBo_SE_43);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_44 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_44.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_44.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_44.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_44.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_44 = new CompetenceBo ("Deliver Webapplication Wavemaker", "I can design, develop, test and deploy a web or mobile application (using Wavemaker), interacting with (Spring) REST-services with a basic knowledge of JavaScript, Angular, HTML and CSS. ", competenceLevels_SE_44 );
		try {
			competenceFacade.save(competenceBo_SE_44);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_45 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_45.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_45.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_45.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_45.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_45 = new CompetenceBo ("Deliver Mobile PDT app Colruyt Stack", "I can design, develop, test and deploy a fullstack PDT Mobile application in Colruyt Java stack (baseframe, PDT-tags) on either a Oracle or DB2 database, using the standard development tooling (Visual Studio, RAD, IntelliJ/Eclipse, Git) ", competenceLevels_SE_45 );
		try {
			competenceFacade.save(competenceBo_SE_45);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_46 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_46.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_46.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_46.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_46.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_46 = new CompetenceBo ("Deliver Mobile Frontend Android Native", "I can design, develop, test and deploy a native mobile app in Android (using Java or Kotlin), interacting with REST-services, using the standard development tooling (Eclipse/Android Studio, Git). ", competenceLevels_SE_46 );
		try {
			competenceFacade.save(competenceBo_SE_46);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_47 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_47.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_47.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_47.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_47.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_47 = new CompetenceBo ("Deliver Mobile Frontend iOS Native", "I can design, develop, test and deploy a native mobile app in iOS (using Swift), interacting with REST-services, using the standard development tooling (Xcode, Git).", competenceLevels_SE_47 );
		try {
			competenceFacade.save(competenceBo_SE_47);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_48 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_48.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_48.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_48.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_48.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_48 = new CompetenceBo ("Deliver Webmethods Service", "I can design, develop, test and deploy an application using the development tooling MS Visio, webMethods Designer, RTC and RAM, SOAPUI and Database query tools.", competenceLevels_SE_48 );
		try {
			competenceFacade.save(competenceBo_SE_48);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_49 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_49.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_49.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_49.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_49.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_49 = new CompetenceBo ("Deliver Trading Networks Service", "I can design, develop, test and deploy an application of Trading Networks service using the development tooling MS Visio, webMethods Designer, My Webmethods Server, RTC and RAM ", competenceLevels_SE_49 );
		try {
			competenceFacade.save(competenceBo_SE_49);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_50 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_50.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_50.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_50.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_50.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_50 = new CompetenceBo ("Deliver BPM Orchestration (ESB)", "I can design, implement, test and promote a Business Process Management Orchestration to manage the cooperation of processing and services in our ESB using webMethods Designer, My Webmethods Server, Universal Messaging, RAM and RTC.", competenceLevels_SE_50 );
		try {
			competenceFacade.save(competenceBo_SE_50);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_51 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_51.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_51.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_51.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_51.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_51 = new CompetenceBo ("Deliver Webservice SOAP ESB", "I can design, develop, test and deploy an application using the development tooling MS Visio, webMethods Designer, RTC and RAM, SOAPUI and Database query tools.", competenceLevels_SE_51 );
		try {
			competenceFacade.save(competenceBo_SE_51);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_52 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_52.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_52.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_52.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_52.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_52 = new CompetenceBo ("Deliver Webservice REST ESB", "I can design, develop, test and deploy an application using the development tooling MS Visio, webMethods Designer, RTC and RAM, SOAPUI, Postman and Database query tools.", competenceLevels_SE_52 );
		try {
			competenceFacade.save(competenceBo_SE_52);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_53 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_53.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_53.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_53.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_53.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_53 = new CompetenceBo ("Deliver Async API (JSON/XML) ESB", "I can design, develop, test and deploy an application using the development tooling MS Visio, webMethods Designer, RTC and RAM, My webMethods Server, MQ and Database query tools.", competenceLevels_SE_53 );
		try {
			competenceFacade.save(competenceBo_SE_53);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_54 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_54.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_54.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_54.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_54.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_54 = new CompetenceBo ("Deliver SOAP/JMS Webservice ESB", "I can design, develop, test and deploy an application using the development tooling MS Visio, webMethods Designer, RTC and RAM, My webMethods Server, MQ and Database query tools.", competenceLevels_SE_54 );
		try {
			competenceFacade.save(competenceBo_SE_54);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_55 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_55.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_55.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_55.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_55.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_55 = new CompetenceBo ("Deliver Virtual Services (SOAP/REST)", "I can create, deploy and test virtual services using Centrasite, Mediator, SoapUI and Postman.", competenceLevels_SE_55 );
		try {
			competenceFacade.save(competenceBo_SE_55);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_56 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_56.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_56.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_56.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_56.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_56 = new CompetenceBo ("Deliver Data Integration Cycle (ETL/PowerCenter) (MaSpo wait for FrBra)", "", competenceLevels_SE_56 );
		try {
			competenceFacade.save(competenceBo_SE_56);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_57 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_57.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_57.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_57.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_57.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_57 = new CompetenceBo ("Deliver Online Application Oracle PSFT ", "I can design, develop, test and deploy an application in the PeopleSoft development platform (using PeopleCode ) on an Oracle DB using the standard PSFT development tooling (Application Designer). ", competenceLevels_SE_57 );
		try {
			competenceFacade.save(competenceBo_SE_57);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_58 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_58.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_58.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_58.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_58.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_58 = new CompetenceBo ("Deliver Batch Oracle PSFT Application Engines", "I can design, develop, test and deploy a XPS-cycle based on Application Engines, developed in the PeopleSoft development platform on an Oracle DB using the standard PSFT development tooling (Application Designer). I can also schedule an Application Engine myself in the PSFT-environment itself.", competenceLevels_SE_58 );
		try {
			competenceFacade.save(competenceBo_SE_58);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_59 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_59.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_59.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_59.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_59.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_59 = new CompetenceBo ("Deliver Batch Oracle PSFT SQR", "I can design, develop, test and deploy a XPS-cycle based on SQR-scripts, developed in the PeopleSoft development platform on an Oracle DB using the standard PSFT development tooling. ", competenceLevels_SE_59 );
		try {
			competenceFacade.save(competenceBo_SE_59);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_60 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_60.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_60.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_60.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_60.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_60 = new CompetenceBo ("Deliver Webservice PSFT Integration Broker", "I can design, develop, test and deploy an Integration Broker webservice, using PeopleTools in PSFT. ", competenceLevels_SE_60 );
		try {
			competenceFacade.save(competenceBo_SE_60);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_61 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_61.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_61.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_61.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_61.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_61 = new CompetenceBo ("Deliver Mobile Frontend Fluid Webapp (PSFT)", "I can design, develop, test and deploy a responsive mobile webapplication in Fluid, interacting with a PSFT-backend, using the development environment of PSFT. ", competenceLevels_SE_61 );
		try {
			competenceFacade.save(competenceBo_SE_61);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_62 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_62.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_62.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_62.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_62.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_62 = new CompetenceBo ("Deliver Microsoft Sharepoint Component", "I can design, develop, test and deploy a Sharepoint component with PowerShell/Javascript using the standard tools (Visual Studio Code, GIT, NPM) ", competenceLevels_SE_62 );
		try {
			competenceFacade.save(competenceBo_SE_62);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_63 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_63.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_63.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_63.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_63.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_63 = new CompetenceBo ("Deliver SAP Native Application", "I can design, develop, test and deploy a native application in the SAP development platform (using ABAP, SAPGUI) on SAP HANA (with CDSViews) using the standard SAP development tooling (ABAP workbench).", competenceLevels_SE_63 );
		try {
			competenceFacade.save(competenceBo_SE_63);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_64 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_64.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_64.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_64.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_64.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_64 = new CompetenceBo ("Deliver SAP Backend Interface", "I can design, develop, test and deploy a backend SAP interface exposing iDoc or a Service, getting data on SAP HANA (CDSViews), using the default development tooling (SAP Workbench) ", competenceLevels_SE_64 );
		try {
			competenceFacade.save(competenceBo_SE_64);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_65 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_65.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_65.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_65.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_65.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_65 = new CompetenceBo ("Deliver SAP Webapp Frontend Fiori", "I can design, develop, test and deploy a frontend web application in Fiori (Javascript, UI5) interacting with SAP backend interfaces.", competenceLevels_SE_65 );
		try {
			competenceFacade.save(competenceBo_SE_65);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_66 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_66.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_66.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_66.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_66.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_66 = new CompetenceBo ("Deliver Batch SAP ABAP", "I can design, develop, test and deploy a XPS batch cycle including ABAP applications on a SAP HANA database, using the standard software development tool(s) (SAP Workbench) ", competenceLevels_SE_66 );
		try {
			competenceFacade.save(competenceBo_SE_66);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_67 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_67.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_67.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_67.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_67.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_67 = new CompetenceBo ("Deliver SAP Business Warehouse Datachain", "I can design, develop, test and deploy a BW datachain in the SAP development platform.", competenceLevels_SE_67 );
		try {
			competenceFacade.save(competenceBo_SE_67);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_68 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_68.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_68.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_68.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_68.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_68 = new CompetenceBo ("Deliver BO Universe", "I can create a universe based on a datamodel in order to create further reports using BO universe design tool, I can analyse the impacts of an universe modification, I can identify the needed universe modification(s) in order to answer to a report modification request, and I know how to bring it in production ", competenceLevels_SE_68 );
		try {
			competenceFacade.save(competenceBo_SE_68);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_69 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_69.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_69.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_69.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_69.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_69 = new CompetenceBo ("Design Report Visualisation Design", " I can make a proposal of visualisation based on high level business needs, I know what the best practices are in order to find the most appropriate way to visualize data / information.", competenceLevels_SE_69 );
		try {
			competenceFacade.save(competenceBo_SE_69);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_70 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_70.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_70.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_70.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_70.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_70 = new CompetenceBo ("Deliver SAP BO Report", "I can use SAP BO webi in order to create a new report and to meet / challenge business expectations, I can do a retro-engineering of an existing report in order to modify it, and I know how to put this in production ", competenceLevels_SE_70 );
		try {
			competenceFacade.save(competenceBo_SE_70);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_71 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_71.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_71.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_71.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_71.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_71 = new CompetenceBo ("Deliver Tableau Dashboard", "I can use tableau in order to create a new dashboard and to meet / challenge business expectations, I can do a retro-engineering of an existing dashboard in order to modify it, and I know how to put this in production ", competenceLevels_SE_71 );
		try {
			competenceFacade.save(competenceBo_SE_71);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_72 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_72.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_72.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_72.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_72.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_72 = new CompetenceBo ("Impact Analysis", "I can, based on the requirements of the assignment I get, make an overview of the impact on our software. I can list out the required design and technical changes for the software components of the technologies I know using the adequate tooling provided", competenceLevels_SE_72 );
		try {
			competenceFacade.save(competenceBo_SE_72);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_73 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_73.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_73.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_73.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_73.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_73 = new CompetenceBo ("Deliver tableau data source", "I can create a data source based on a datamodel in order to create further dashboards using tableau desktop, I can analyse the impacts of a data source modification, I can identify the needed data source modification(s) in order to answer to a dashboard modification request, and I know how to bring it in production", competenceLevels_SE_73 );
		try {
			competenceFacade.save(competenceBo_SE_73);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_74 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_74.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_74.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_74.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_74.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_74 = new CompetenceBo ("Deliver Hana Models", "I can create Hana models, compile them and do performance tuning of these models using advanced SQL skills. ", competenceLevels_SE_74 );
		try {
			competenceFacade.save(competenceBo_SE_74);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_75 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_75.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_75.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_75.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_75.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_75 = new CompetenceBo ("Continuous Integration & Deployment (Java/Mobile)", "I can initiate continuous integration and deployment for my (java/mobile) software components. I can write qualitative unit tests and setup a pipeline within Jenkins (in combination with Git, Gradle, Artifactory & SonarQube)", competenceLevels_SE_75 );
		try {
			competenceFacade.save(competenceBo_SE_75);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_76 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_76.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_76.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_76.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_76.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_76 = new CompetenceBo ("Performance Tuning", "I can monitor the performance of my developed software components, analyse the results and take the needed actions to improve it (using tools such as Dyntrace, Visual M, RAD Profiler). ", competenceLevels_SE_76 );
		try {
			competenceFacade.save(competenceBo_SE_76);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_77 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_77.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_77.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_77.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_77.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_77 = new CompetenceBo ("Deliver Technical Documentation & Troubleshooter", "I can create/maintain the needed technical documentation on the software components I work on, for future reference (support & future projects) and share it with the team.  I can create/maintain spot-on troubleshooters on the software I work on, to facilitate future support throughout the complete support line (1st line, 2nd,...) using our standard tooling (Solution) and share it with the support teams involved. ", competenceLevels_SE_77 );
		try {
			competenceFacade.save(competenceBo_SE_77);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_78 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_78.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_78.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_78.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_78.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_78 = new CompetenceBo ("Use Containerization (not yet rolled out - still in POC)", "I can built a Docker Image and run Docker Containers.  I can also work with Docker Compose. ", competenceLevels_SE_78 );
		try {
			competenceFacade.save(competenceBo_SE_78);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_SE_81 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_81.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_81.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_81.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_81.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_81 = new CompetenceBo ("Create a High Level Technical Design ", "I can : - create a High ", competenceLevels_SE_81 );
		try {
			competenceFacade.save(competenceBo_SE_81);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_82 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_82.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_82.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_82.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_82.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_82 = new CompetenceBo ("Create a Development WBS and do the Workforce Allocation ", "I can make the Work Breakdown Structure for (a part of) the solution, and create the planning of the developer according to the WBS.  I also update the PM about the planning and the status. ", competenceLevels_SE_82 );
		try {
			competenceFacade.save(competenceBo_SE_82);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_83 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_83.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_83.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_83.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_83.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_83 = new CompetenceBo ("Development Quality Assurance ", "Author: I can review architectural, functional and technical designs and development source code on it's completeness, the quality and the use of (industry) standards and support my colleagues in correcting them.", competenceLevels_SE_83 );
		try {
			competenceFacade.save(competenceBo_SE_83);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_84 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_84.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_84.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_84.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_84.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_84 = new CompetenceBo ("Development Lifecycle Setup ", "I can do the necessary configurations or actions to ensure that the development, testing and deployment of (my part of) the solution can be done smoothly by the developers. ", competenceLevels_SE_84 );
		try {
			competenceFacade.save(competenceBo_SE_84);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_85 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_85.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_85.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_85.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_85.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_85 = new CompetenceBo ("GoLive Strategy & Followup", "I can create the plan to bring (my part of) the solution into production, without unwanted impact to processes or adjoining systems, and I ensure that followup is done during the deployment, ", competenceLevels_SE_85 );
		try {
			competenceFacade.save(competenceBo_SE_85);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_86 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_86.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_86.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_86.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_86.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_86 = new CompetenceBo ("Performance Monitoring Setup", "I can set up the performance monitoring for (my part of) the solution so that, during development, the performance can be measured.  I can also set up the performance monitoring for (my part of) the solution so that, once in production, the performance can be measured by the asset owner. ", competenceLevels_SE_86 );
		try {
			competenceFacade.save(competenceBo_SE_86);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_SE_89 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_89.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_89.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_89.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_89.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_89 = new CompetenceBo ("Technical Solution Integration Design ", "I can : - create the Technical Solution Integration Design of the total solution (cross platform), that is understandable for the Lead Developer to create the High Low ", competenceLevels_SE_89 );
		try {
			competenceFacade.save(competenceBo_SE_89);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_90 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_90.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_90.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_90.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_90.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_90 = new CompetenceBo ("Integration Development WBS and Workforce Allocation ", "I can make the Work Breakdown Structure for the total solution, and create the high level planning of the developers according to the WBS.  I also update the PM about the planning and the status.  ", competenceLevels_SE_90 );
		try {
			competenceFacade.save(competenceBo_SE_90);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_91 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_91.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_91.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_91.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_91.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_91 = new CompetenceBo ("Integration Development Quality Assurance ", "I can review architectural, functional and high level technical designs on it's completeness, the quality and the use of (industry) standards and support my colleagues in correcting them. ", competenceLevels_SE_91 );
		try {
			competenceFacade.save(competenceBo_SE_91);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_92 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_92.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_92.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_92.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_92.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_92 = new CompetenceBo ("Technical Solution Integration Lifecycle ", "I can do the necessary configurations or actions to ensure that the development, testing and deployment of the total solution can be done smoothly by the developers.", competenceLevels_SE_92 );
		try {
			competenceFacade.save(competenceBo_SE_92);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_93 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_93.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_93.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_93.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_93.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_93 = new CompetenceBo ("Integration GoLive Strategy & Followup ", "I can create the plan to bring the total solution into production, without unwanted impact to processes or adjoining systems, and I ensure that followup is done during the deployment.", competenceLevels_SE_93 );
		try {
			competenceFacade.save(competenceBo_SE_93);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_SE_96 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_96.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_96.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_96.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_96.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_96 = new CompetenceBo ("Incident Handling Ombuds", "I can handle/process any incident for which I become 'owner' during its lifecycle in a correct way, in line with the applicable SLA/SLE and priority, in cooperation with other support lines (1st line, expert teams), using the Incident-tool. If needed I can launch an candidate problem.", competenceLevels_SE_96 );
		try {
			competenceFacade.save(competenceBo_SE_96);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_97 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_97.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_97.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_97.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_97.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_97 = new CompetenceBo ("Incident Handling OnCall", "I can handle/process any incident for which I become 'owner' in an OnCall situation in a correct way, in line with the applicable SLA/SLE and priorities, in cooperation with other support lines (1st line, experts), by making sure there is a temporary fix.", competenceLevels_SE_97 );
		try {
			competenceFacade.save(competenceBo_SE_97);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_98 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_98.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_98.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_98.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_98.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_98 = new CompetenceBo ("Disaster Handling", "I can play my role when involved in a disaster situation in a correct way (process), in line with the applicable SLA/SLE and priority, in cooperation with the disaster coördinator/team and other support lines (1st line, expert teams), using the default disaster tools (73111, AdobeConnect,...) ", competenceLevels_SE_98 );
		try {
			competenceFacade.save(competenceBo_SE_98);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_99 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_99.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_99.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_99.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_99.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_99 = new CompetenceBo ("Emergency Fixes", "I can define, validate and implement a workaround or quick (temporary)  solution (data manipulation, source code adaptation,…) directly in production for an incident that needs a solution, in order to make sure that our PartnerS's processes can run further, using the extra means provided (super userids, emergency paths,...). That means I can also assess the impact of my actions/intervention for my PartnerS' processes and systems. ", competenceLevels_SE_99 );
		try {
			competenceFacade.save(competenceBo_SE_99);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_100 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_100.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_100.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_100.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_100.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_100 = new CompetenceBo ("Knowledge Management", "I can use the supporting documentation available in different sources (Solution, Archives,…) and I can strengthen them and keep them up-to-date. ", competenceLevels_SE_100 );
		try {
			competenceFacade.save(competenceBo_SE_100);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_SE_103 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_103.add (new CompetenceLevelBo("no experience", 1));
		competenceLevels_SE_103.add (new CompetenceLevelBo("little experience", 2));
		competenceLevels_SE_103.add (new CompetenceLevelBo("enough experience, I can work autonomously", 3));
		competenceLevels_SE_103.add (new CompetenceLevelBo("broad expertise, considered expert across teams/organisation", 4));


		CompetenceBo competenceBo_SE_103 = new CompetenceBo ("Test Specialist", "", competenceLevels_SE_103 );
		try {
			competenceFacade.save(competenceBo_SE_103);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}











		HashSet<CompetenceLevelBo> competenceLevels_SE_115 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_115.add (new CompetenceLevelBo(".Knows the values and mission ", 1));
		competenceLevels_SE_115.add (new CompetenceLevelBo(".Works in conformity with the values and mission", 2));
		competenceLevels_SE_115.add (new CompetenceLevelBo(".Follows up on behaviour of other people that does not correspond with the values and mission", 3));
		competenceLevels_SE_115.add (new CompetenceLevelBo(".Guards and illustrates the application of the values and mission ", 4));
		competenceLevels_SE_115.add (new CompetenceLevelBo(".Links the company values and mission to each message and decision. ", 5));


		CompetenceBo competenceBo_SE_115 = new CompetenceBo ("Company Involvement", " To show yourself connected with the mission and values of the company, to create a connection with other people and to make sure that all behaviour corresponds with this.   ", competenceLevels_SE_115 );
		try {
			competenceFacade.save(competenceBo_SE_115);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_116 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_116.add (new CompetenceLevelBo(".Processes a limited amount of simple data", 1));
		competenceLevels_SE_116.add (new CompetenceLevelBo(".Distinguishes different sub-aspects in an amount of data  ", 2));
		competenceLevels_SE_116.add (new CompetenceLevelBo(".Finds simple connections between different data", 3));
		competenceLevels_SE_116.add (new CompetenceLevelBo(".Analyses the connections between the different elements of a complex given ", 4));
		competenceLevels_SE_116.add (new CompetenceLevelBo(".Comes from a complex given to clear criteria to make a synthesis", 5));


		CompetenceBo competenceBo_SE_116 = new CompetenceBo ("Analytical Capability", " The capacity to split up (complex) problems, processes, projects into the composing parts, to analyse the underlying relations systematically and to develop clear criteria to form an overall picture .  ", competenceLevels_SE_116 );
		try {
			competenceFacade.save(competenceBo_SE_116);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_117 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_117.add (new CompetenceLevelBo(".Reacts to questions of customers according to existing services ", 1));
		competenceLevels_SE_117.add (new CompetenceLevelBo(".Listens to customer needs and deals with them", 2));
		competenceLevels_SE_117.add (new CompetenceLevelBo(".Consults and checks with the customer about the services/products desired", 3));
		competenceLevels_SE_117.add (new CompetenceLevelBo(".Actively looks for the optimisation of services and products", 4));
		competenceLevels_SE_117.add (new CompetenceLevelBo(".Pro-actively responds to needs and expectations and builds a sustainable customer relationship ", 5));


		CompetenceBo competenceBo_SE_117 = new CompetenceBo ("Customer Orientation", " The capacity to actively look for and respond to services and products that have an added value for others (internal and external customers, colleagues, partners, etc.).    ", competenceLevels_SE_117 );
		try {
			competenceFacade.save(competenceBo_SE_117);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_118 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_118.add (new CompetenceLevelBo(".Brings simple messages in a structured way", 1));
		competenceLevels_SE_118.add (new CompetenceLevelBo(".Listens to his/her audience and answers questions", 2));
		competenceLevels_SE_118.add (new CompetenceLevelBo(".Renders a complex message in a direct, appropriate way to the target group", 3));
		competenceLevels_SE_118.add (new CompetenceLevelBo(".Actively checks whether the message was understood by everybody and reformulates", 4));
		competenceLevels_SE_118.add (new CompetenceLevelBo(".Substantiates his/her message, has thorough command of the different opinions and traces them to the essence", 5));


		CompetenceBo competenceBo_SE_118 = new CompetenceBo ("Communicative Capability", " The capacity to pass on a message in a direct , straightforward  and interactive way.   ", competenceLevels_SE_118 );
		try {
			competenceFacade.save(competenceBo_SE_118);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_119 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_119.add (new CompetenceLevelBo(".Is open to feedback", 1));
		competenceLevels_SE_119.add (new CompetenceLevelBo(".Thinks about his own behaviour and functioning", 2));
		competenceLevels_SE_119.add (new CompetenceLevelBo(".Takes steps to further develop knowledge and skills", 3));
		competenceLevels_SE_119.add (new CompetenceLevelBo(".Goes actively in search of possibilities to further develop the own convictions, patterns and personality ", 4));
		competenceLevels_SE_119.add (new CompetenceLevelBo(".Integrates the matter learned and the expertise acquired  with his/her whole functioning", 5));


		CompetenceBo competenceBo_SE_119 = new CompetenceBo ("Self-fulfilment", " To gain an insight in oneself and, based on this insight, to consciously take steps to develop further.    ", competenceLevels_SE_119 );
		try {
			competenceFacade.save(competenceBo_SE_119);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_120 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_120.add (new CompetenceLevelBo(".Makes non-controversial decisions", 1));
		competenceLevels_SE_120.add (new CompetenceLevelBo(".Dares to make decisions that include a restricted risk on a simple matter ", 2));
		competenceLevels_SE_120.add (new CompetenceLevelBo(".Makes decisions that have an impact on other people", 3));
		competenceLevels_SE_120.add (new CompetenceLevelBo(".Makes decisions on complex matters", 4));
		competenceLevels_SE_120.add (new CompetenceLevelBo(".Makes decisions on complex matters with broad impact", 5));


		CompetenceBo competenceBo_SE_120 = new CompetenceBo ("Decision-making", " The capacity and readiness to dare 'take the plunge' by expressing a specific point of view or decision despite incomplete knowledge of the given or the risks.   ", competenceLevels_SE_120 );
		try {
			competenceFacade.save(competenceBo_SE_120);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_121 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_121.add (new CompetenceLevelBo(".Manages own daily activities ", 1));
		competenceLevels_SE_121.add (new CompetenceLevelBo(".Marks out the own activities in a realistic schedule ", 2));
		competenceLevels_SE_121.add (new CompetenceLevelBo(".Makes a realistic and concrete planning for his/her direct collaborators/decision maker", 3));
		competenceLevels_SE_121.add (new CompetenceLevelBo(".Checks the feasibility of the planning, follows up on it and adjusts according to unforeseen circumstances. ", 4));
		competenceLevels_SE_121.add (new CompetenceLevelBo(".Marks out the activities for a broad target group, considering the priorities and the objectives to be reached", 5));


		CompetenceBo competenceBo_SE_121 = new CompetenceBo ("Operational Planning", " The capacity to mark out a concrete planning for him/her and/or possible collaborators so that the objectives are reached within the term proposed.   ", competenceLevels_SE_121 );
		try {
			competenceFacade.save(competenceBo_SE_121);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_122 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_122.add (new CompetenceLevelBo(".Works in changing, unforeseen circumstances in the same way and shows an emotional reaction ", 1));
		competenceLevels_SE_122.add (new CompetenceLevelBo(".Adapts the behaviour ad hoc in changing unforeseen circumstances", 2));
		competenceLevels_SE_122.add (new CompetenceLevelBo(".Remains level-headed in changing, unforeseen circumstances and adjusts his/her approach in a goal-oriented way", 3));
		competenceLevels_SE_122.add (new CompetenceLevelBo(".In a complex situation, adjusts the initial approach in a goal-oriented way to the changing circumstances", 4));
		competenceLevels_SE_122.add (new CompetenceLevelBo(".In changing, unforeseen circumstances, will choose the most efficient approach", 5));


		CompetenceBo competenceBo_SE_122 = new CompetenceBo ("Adaptability", " The capacity to adjust and change the method and approach in an efficient way in order to reach a specific objective.   ", competenceLevels_SE_122 );
		try {
			competenceFacade.save(competenceBo_SE_122);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_123 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_123.add (new CompetenceLevelBo(".Provided that he/she has input from other people, he/she is capable of finding a solution ", 1));
		competenceLevels_SE_123.add (new CompetenceLevelBo(".Rapidly thinks in terms of solution and applies experiences acquired. ", 2));
		competenceLevels_SE_123.add (new CompetenceLevelBo(".Formulates several alternative solutions to a problem", 3));
		competenceLevels_SE_123.add (new CompetenceLevelBo(".Offers creative, original solutions to a complex problem ", 4));
		competenceLevels_SE_123.add (new CompetenceLevelBo(".Comes to an effective and rapid problem approach in a complex situation ", 5));


		CompetenceBo competenceBo_SE_123 = new CompetenceBo ("Problem-Solving", " The ability to solve situations and problems quickly and effectively.   ", competenceLevels_SE_123 );
		try {
			competenceFacade.save(competenceBo_SE_123);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_124 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_124.add (new CompetenceLevelBo(".Does what he/she is asked to do", 1));
		competenceLevels_SE_124.add (new CompetenceLevelBo(".Perseveres and steps in when not everything is satisfactory", 2));
		competenceLevels_SE_124.add (new CompetenceLevelBo(".Defines own performance levels and reorients other people ", 3));
		competenceLevels_SE_124.add (new CompetenceLevelBo(".Formulates clear criteria within which the work must be done to other people", 4));
		competenceLevels_SE_124.add (new CompetenceLevelBo(".Defines challenging objectives", 5));


		CompetenceBo competenceBo_SE_124 = new CompetenceBo ("Goal Orientation", " The perseverance to deliver good work and to reach the objectives.   ", competenceLevels_SE_124 );
		try {
			competenceFacade.save(competenceBo_SE_124);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_125 = new HashSet<CompetenceLevelBo>();
		competenceLevels_SE_125.add (new CompetenceLevelBo(".Actively looks for information and knowledge to gain more in-depth expertise", 1));
		competenceLevels_SE_125.add (new CompetenceLevelBo(".Shares own competences with other people on request", 2));
		competenceLevels_SE_125.add (new CompetenceLevelBo(".Will actively exchange competences within his/her field of activity", 3));
		competenceLevels_SE_125.add (new CompetenceLevelBo(".Stimulates professional expertise in other people by passing on the own professional expertise in a comprehensible way", 4));
		competenceLevels_SE_125.add (new CompetenceLevelBo(".Creates professional expertise in the whole company", 5));


		CompetenceBo competenceBo_SE_125 = new CompetenceBo ("Exchange Expertise", " Actively and resolutely exchange skills , attitudes  and knowledge  with other people.  ", competenceLevels_SE_125 );
		try {
			competenceFacade.save(competenceBo_SE_125);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_SE_128 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_128 = new CompetenceBo ("Strategy & Change: Strategy Definition & Governance", "", competenceLevels_SE_128 );
		try {
			competenceFacade.save(competenceBo_SE_128);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_129 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_129 = new CompetenceBo ("Strategy & Change: Business Change Mgmt", "", competenceLevels_SE_129 );
		try {
			competenceFacade.save(competenceBo_SE_129);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_130 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_130 = new CompetenceBo ("Resource Planning: Strategic Resource Planning", "", competenceLevels_SE_130 );
		try {
			competenceFacade.save(competenceBo_SE_130);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_131 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_131 = new CompetenceBo ("Risk & Compliance: Risk & Compliance Mgmt", "", competenceLevels_SE_131 );
		try {
			competenceFacade.save(competenceBo_SE_131);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_132 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_132 = new CompetenceBo ("Market Watch", "", competenceLevels_SE_132 );
		try {
			competenceFacade.save(competenceBo_SE_132);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_133 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_133 = new CompetenceBo ("Performance Watch", "", competenceLevels_SE_133 );
		try {
			competenceFacade.save(competenceBo_SE_133);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_134 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_134 = new CompetenceBo ("Sustainability Mgmt", "", competenceLevels_SE_134 );
		try {
			competenceFacade.save(competenceBo_SE_134);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_135 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_135 = new CompetenceBo ("Innovation: R&D & Innovation", "", competenceLevels_SE_135 );
		try {
			competenceFacade.save(competenceBo_SE_135);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_136 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_136 = new CompetenceBo ("Stakeholder Relations & Reputation: Stakeholder Relations & Reputation Mgmt", "", competenceLevels_SE_136 );
		try {
			competenceFacade.save(competenceBo_SE_136);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_137 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_137 = new CompetenceBo ("Stakeholder Relations & Reputation: Public Relations Mgmt", "", competenceLevels_SE_137 );
		try {
			competenceFacade.save(competenceBo_SE_137);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_138 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_138 = new CompetenceBo ("Stakeholder Relations & Reputation: Party Mgmt", "", competenceLevels_SE_138 );
		try {
			competenceFacade.save(competenceBo_SE_138);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_139 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_139 = new CompetenceBo ("Communication & Collaboration: Commication & Collaboration", "", competenceLevels_SE_139 );
		try {
			competenceFacade.save(competenceBo_SE_139);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_140 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_140 = new CompetenceBo ("Communication & Collaboration: Workplace Mgmt", "", competenceLevels_SE_140 );
		try {
			competenceFacade.save(competenceBo_SE_140);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_141 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_141 = new CompetenceBo ("Digital: Digitalisation Mgmt", "", competenceLevels_SE_141 );
		try {
			competenceFacade.save(competenceBo_SE_141);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_142 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_142 = new CompetenceBo ("Service, Process & Organisation: Organisation Mgmt", "", competenceLevels_SE_142 );
		try {
			competenceFacade.save(competenceBo_SE_142);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_143 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_143 = new CompetenceBo ("Service, Process & Organisation: Process & Service Design", "", competenceLevels_SE_143 );
		try {
			competenceFacade.save(competenceBo_SE_143);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_144 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_144 = new CompetenceBo ("Service, Process & Organisation: Enterprise Service Mgmt", "", competenceLevels_SE_144 );
		try {
			competenceFacade.save(competenceBo_SE_144);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_145 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_145 = new CompetenceBo ("Information: Information Mgmt", "", competenceLevels_SE_145 );
		try {
			competenceFacade.save(competenceBo_SE_145);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_146 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_146 = new CompetenceBo ("Information: Content & Document Mgmt", "", competenceLevels_SE_146 );
		try {
			competenceFacade.save(competenceBo_SE_146);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_147 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_147 = new CompetenceBo ("Coworker: Co-worker Mgmt", "", competenceLevels_SE_147 );
		try {
			competenceFacade.save(competenceBo_SE_147);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_148 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_148 = new CompetenceBo ("Coworker: Training Mgmt", "", competenceLevels_SE_148 );
		try {
			competenceFacade.save(competenceBo_SE_148);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_149 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_149 = new CompetenceBo ("Infrastructure: Real Estate Mgmt", "", competenceLevels_SE_149 );
		try {
			competenceFacade.save(competenceBo_SE_149);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_150 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_150 = new CompetenceBo ("Infrastructure: Tanglible Asset Lifecycle Mgmt", "", competenceLevels_SE_150 );
		try {
			competenceFacade.save(competenceBo_SE_150);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_151 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_151 = new CompetenceBo ("Infrastructure: Facility & Field Service Mgmt", "", competenceLevels_SE_151 );
		try {
			competenceFacade.save(competenceBo_SE_151);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_152 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_152 = new CompetenceBo ("IT Infrasturcture & Solutions: ICT Mgmt", "", competenceLevels_SE_152 );
		try {
			competenceFacade.save(competenceBo_SE_152);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_153 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_153 = new CompetenceBo ("Brand, Customer, Marketingpromotion: (B2C) Marketing Promotion (BE)", "", competenceLevels_SE_153 );
		try {
			competenceFacade.save(competenceBo_SE_153);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_154 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_154 = new CompetenceBo ("Brand, Customer, Marketingpromotion: Brand Mgmt", "", competenceLevels_SE_154 );
		try {
			competenceFacade.save(competenceBo_SE_154);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_155 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_155 = new CompetenceBo ("Brand, Customer, Marketingpromotion: Customer Mgmt", "", competenceLevels_SE_155 );
		try {
			competenceFacade.save(competenceBo_SE_155);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_156 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_156 = new CompetenceBo ("Product: Product Mgmt", "", competenceLevels_SE_156 );
		try {
			competenceFacade.save(competenceBo_SE_156);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_157 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_157 = new CompetenceBo ("Procuct: Product Group Mgmt", "", competenceLevels_SE_157 );
		try {
			competenceFacade.save(competenceBo_SE_157);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_158 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_158 = new CompetenceBo ("Procuct: Product Information Mgmt", "", competenceLevels_SE_158 );
		try {
			competenceFacade.save(competenceBo_SE_158);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_159 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_159 = new CompetenceBo ("Purchasing Direct Goods: Direct Purchase Mgmt", "", competenceLevels_SE_159 );
		try {
			competenceFacade.save(competenceBo_SE_159);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_160 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_160 = new CompetenceBo ("Purchasing Direct Goods: Retail Product Costing", "", competenceLevels_SE_160 );
		try {
			competenceFacade.save(competenceBo_SE_160);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_161 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_161 = new CompetenceBo ("Purchasing Direct Goods: Purchase Operations Food", "", competenceLevels_SE_161 );
		try {
			competenceFacade.save(competenceBo_SE_161);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_162 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_162 = new CompetenceBo ("Purchasing Indirect Goods & Services: Indirect Purchasing", "", competenceLevels_SE_162 );
		try {
			competenceFacade.save(competenceBo_SE_162);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_163 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_163 = new CompetenceBo ("Purchasing Indirect Goods & Services: Indirect Product Information Mgmt", "", competenceLevels_SE_163 );
		try {
			competenceFacade.save(competenceBo_SE_163);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_164 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_164 = new CompetenceBo ("Purchasing Indirect Goods & Services: Internal Wholesale of Indirect Goods", "", competenceLevels_SE_164 );
		try {
			competenceFacade.save(competenceBo_SE_164);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_165 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_165 = new CompetenceBo ("Supplier: Supplier Mgmt", "", competenceLevels_SE_165 );
		try {
			competenceFacade.save(competenceBo_SE_165);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_166 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_166 = new CompetenceBo ("Supply Chain Food: Supply Chain Food", "", competenceLevels_SE_166 );
		try {
			competenceFacade.save(competenceBo_SE_166);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_167 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_167 = new CompetenceBo ("Supply Chain Food: Logistic Workforce Mgmt", "", competenceLevels_SE_167 );
		try {
			competenceFacade.save(competenceBo_SE_167);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_168 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_168 = new CompetenceBo ("Supply Chain Food: Sales Forecasting Food", "", competenceLevels_SE_168 );
		try {
			competenceFacade.save(competenceBo_SE_168);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_169 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_169 = new CompetenceBo ("E-Commerce Food: E-commerce B2C Food", "", competenceLevels_SE_169 );
		try {
			competenceFacade.save(competenceBo_SE_169);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_170 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_170 = new CompetenceBo ("E-Commerce Food: nonFood", "", competenceLevels_SE_170 );
		try {
			competenceFacade.save(competenceBo_SE_170);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_171 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_171 = new CompetenceBo ("Store Sales: Food Retail Store Sales", "", competenceLevels_SE_171 );
		try {
			competenceFacade.save(competenceBo_SE_171);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_172 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_172 = new CompetenceBo ("Store Sales: Store Workforce Mgmt", "", competenceLevels_SE_172 );
		try {
			competenceFacade.save(competenceBo_SE_172);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_173 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_173 = new CompetenceBo ("Price: B2C Price Mgmt", "", competenceLevels_SE_173 );
		try {
			competenceFacade.save(competenceBo_SE_173);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HashSet<CompetenceLevelBo> competenceLevels_SE_176 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_176 = new CompetenceBo ("Colruyt Laagste Prijs", "", competenceLevels_SE_176 );
		try {
			competenceFacade.save(competenceBo_SE_176);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_177 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_177 = new CompetenceBo ("OKay", "", competenceLevels_SE_177 );
		try {
			competenceFacade.save(competenceBo_SE_177);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_178 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_178 = new CompetenceBo ("Bio-Planet", "", competenceLevels_SE_178 );
		try {
			competenceFacade.save(competenceBo_SE_178);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_179 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_179 = new CompetenceBo ("CRU", "", competenceLevels_SE_179 );
		try {
			competenceFacade.save(competenceBo_SE_179);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_180 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_180 = new CompetenceBo ("Dreamland", "", competenceLevels_SE_180 );
		try {
			competenceFacade.save(competenceBo_SE_180);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_181 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_181 = new CompetenceBo ("Dreambaby", "", competenceLevels_SE_181 );
		try {
			competenceFacade.save(competenceBo_SE_181);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_182 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_182 = new CompetenceBo ("Collishop", "", competenceLevels_SE_182 );
		try {
			competenceFacade.save(competenceBo_SE_182);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_183 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_183 = new CompetenceBo ("Retail Partners Colruyt Group", "", competenceLevels_SE_183 );
		try {
			competenceFacade.save(competenceBo_SE_183);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_184 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_184 = new CompetenceBo ("Solucious", "", competenceLevels_SE_184 );
		try {
			competenceFacade.save(competenceBo_SE_184);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_185 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_185 = new CompetenceBo ("Colex", "", competenceLevels_SE_185 );
		try {
			competenceFacade.save(competenceBo_SE_185);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_186 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_186 = new CompetenceBo ("Dats 24", "", competenceLevels_SE_186 );
		try {
			competenceFacade.save(competenceBo_SE_186);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_187 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_187 = new CompetenceBo ("Collect & Go", "", competenceLevels_SE_187 );
		try {
			competenceFacade.save(competenceBo_SE_187);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_188 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_188 = new CompetenceBo ("Transport", "", competenceLevels_SE_188 );
		try {
			competenceFacade.save(competenceBo_SE_188);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_189 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_189 = new CompetenceBo ("Retail Service Center", "", competenceLevels_SE_189 );
		try {
			competenceFacade.save(competenceBo_SE_189);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_190 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_190 = new CompetenceBo ("Fine Food", "", competenceLevels_SE_190 );
		try {
			competenceFacade.save(competenceBo_SE_190);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_191 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_191 = new CompetenceBo ("In Cont@ct", "", competenceLevels_SE_191 );
		try {
			competenceFacade.save(competenceBo_SE_191);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_192 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_192 = new CompetenceBo ("BP&S", "", competenceLevels_SE_192 );
		try {
			competenceFacade.save(competenceBo_SE_192);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_193 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_193 = new CompetenceBo ("Finance", "", competenceLevels_SE_193 );
		try {
			competenceFacade.save(competenceBo_SE_193);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_194 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_194 = new CompetenceBo ("M&O", "", competenceLevels_SE_194 );
		try {
			competenceFacade.save(competenceBo_SE_194);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_195 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_195 = new CompetenceBo ("T&I", "", competenceLevels_SE_195 );
		try {
			competenceFacade.save(competenceBo_SE_195);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_196 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_196 = new CompetenceBo ("Colruyt Group Energy", "", competenceLevels_SE_196 );
		try {
			competenceFacade.save(competenceBo_SE_196);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashSet<CompetenceLevelBo> competenceLevels_SE_197 = new HashSet<CompetenceLevelBo>();


		CompetenceBo competenceBo_SE_197 = new CompetenceBo ("CCX & Corporate Marketing", "° Symeta ° Premedia ° Corporate marketing", competenceLevels_SE_197 );
		try {
			competenceFacade.save(competenceBo_SE_197);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	}

	public void fillDb() {
		Set<CompetenceLevelBo> cLevels = new HashSet<>();
		cLevels.add(new CompetenceLevelBo("testLevel1", 1));
		cLevels.add(new CompetenceLevelBo("testLevel2", 2));
		try {
			competenceFacade.save(new CompetenceBo("test", "", cLevels));


		//SurveyDefinitionBo sDevBo = new SurveyDefinitionBo("SE BPS BE", new ArrayList<>());
		//sDevBo = surveyDefinitionFacade.save(sDevBo);

		surveySectionStrategyFacade
				.save(new SurveySectionStrategyBo(5, false, false, "Behavioral", false, true, false));
		surveySectionStrategyFacade.save(new SurveySectionStrategyBo(4, true, true, "", true, true, false));

		surveySectionTitleFacade.save(new SurveySectionTitleBo("developer" ));
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
