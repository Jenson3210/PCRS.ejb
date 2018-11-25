package colruyt.pcrs.utillibs;

import java.util.ArrayList;
import java.util.Arrays;
import javax.inject.Named;

@Named
public class AppContext {
	private String promotionLevel = "test";
	private ArrayList<String> supportedLanguages = new ArrayList<String>(Arrays.asList("NL", "FR", "EN"));
	private String currentLanguage = "NL";
 
	public String getPromotionLevel() {
		return promotionLevel;
	}

	public void setPromotionLevel(String promotionLevel) {
		this.promotionLevel = promotionLevel;
	}

	public ArrayList<String> getSupportedLanguages() {
		return supportedLanguages;
	}

	public void setSupportedLanguages(ArrayList<String> supportedLanguages) {
		this.supportedLanguages = supportedLanguages;
	}

	public String getCurrentLanguage() {
		return currentLanguage;
	}

	public void setCurrentLanguage(String currentLanguage) {
		this.currentLanguage = currentLanguage;
	}
}
