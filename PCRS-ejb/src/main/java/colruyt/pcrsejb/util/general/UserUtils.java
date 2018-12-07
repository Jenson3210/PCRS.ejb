package colruyt.pcrsejb.util.general;

public class UserUtils {
	
	public static String getShortName(String firstName, String lastName) throws Exception{
		StringBuilder shortName = new StringBuilder();
		
		firstName = removeAllNonCharacters(firstName);
		
        if (null != firstName) {
        	if (firstName.length() > 2) {
        		shortName.append(firstName.substring(0,2).toUpperCase());
        	} else {
        		shortName.append(firstName);
        	}
        } else {
        	throw new Exception();
        }
        
        lastName = removeAllNonCharacters(lastName);
        
        String filteredLastName = null;
        
        if (null != lastName) {
        	filteredLastName = filterLastName(lastName);
        }
        
        if (null != filteredLastName) {
        	if(filteredLastName.length() > 2) {
        		shortName.append(filteredLastName.substring(0,3));
        	} else {
        		shortName.append(filteredLastName);
        	}
        } else {
        	throw new Exception();
        }
        return shortName.toString();
    }
	
	
	private static String removeAllNonCharacters(String name) {
		return name.replaceAll("[^\\S]","").toUpperCase();
	}

    private static String filterLastName(String name){
        if (name.matches("^VANDER[A-z]*$")) {
            name = name.replace("VANDER", "");
        } else if (name.matches("^VANDEN[A-z]*$")) {
            name = name.replace("VANDEN","" );
        } else if (name.matches("^VANDE[A-z]*$")) {
            name = name.replace("VANDE","" );
        } else if (name.matches("^VAN[A-z]*$")) {
            name = name.replace("VAN", "");
        } else if (name.matches("^DE[A-z]*$")) {
            name = name.replace("DE", "");
        } else {
        	return name;
        }
        return filterLastName(name);
    }

}
