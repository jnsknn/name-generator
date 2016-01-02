package generator;

import java.util.Random;

public class GenerateName {
	
	// Arrays containing vowels and consonants
	private final static char[] vowels = {'a','e','i','o','u','y','ä','ö','å'};
    private final static char[] consonants = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};
    
    // Newly created name will go to this variable
    String newname = "";
    
    // Constructor for creating a new name
    public GenerateName(String name){
    	
    	String oldname = name.toLowerCase(); // Convert all characters in string to lower case for comparing purposes
    	
    	// Boolean variables for checking
    	boolean foundvowel = false;
    	boolean foundconsonant = false;
    	
    	Random r = new Random();
    	int randomwovel = 0;
    	int randomconsonant = 0;
    	
    	// Counters
    	int i = 0;
    	int j = 0;
    	int k = 0;
    	
    	// Loop for exploring every character in given name string and replacing them with random ones
    	for(i=0;i<oldname.length();i++){
    		
    		// If name string has two exactly same characters next to each other
            if(i<oldname.length()-1 && (oldname.charAt(i) == oldname.charAt(i+1))){
                
                // If vowels found then replace those two with newly generated vowels
                for(j=0;j<vowels.length;j++){
                    if(oldname.charAt(i) == vowels[j]){
                    	randomwovel = r.nextInt(vowels.length);
                        newname += String.valueOf(vowels[randomwovel]);
                        newname += String.valueOf(vowels[randomwovel]);
                        foundvowel = true;
                    }
                }
                
                // Same thing with consonants as vowels
                if(foundvowel == false){
                    for(k=0;k<consonants.length;k++){
                        if(oldname.charAt(i) == consonants[k]){
                        	randomconsonant = r.nextInt(consonants.length);
                            newname += String.valueOf(consonants[randomconsonant]);
                            newname += String.valueOf(consonants[randomconsonant]);
                            foundconsonant = true;
                        }
                    }
                }
                
                i++; // Generated two characters in one round so need to skip one round
                
            }else {
            for(j=0;j<vowels.length;j++){
                if(oldname.charAt(i) == vowels[j]){
                	randomwovel = r.nextInt(vowels.length);
                    newname += String.valueOf(vowels[randomwovel]);
                    foundvowel = true;
                }
            }
            if(foundvowel == false){
                for(k=0;k<consonants.length;k++){
                    if(oldname.charAt(i) == consonants[k]){
                    	randomconsonant = r.nextInt(consonants.length);
                        newname += String.valueOf(consonants[randomconsonant]);
                        foundconsonant = true;
                    }
                }
            }
            }
            
            // If character is something else than recognized character
            if(foundvowel == false && foundconsonant == false){
            	newname += oldname.substring(i, i+1);
            }
            
            // Resetting checkers
            foundvowel = false;
            foundconsonant = false;
    	}
    	
    	// Convert first character of a new name to upper case character
        String[] names = newname.split(" ");
        
        String tempname = "";
        
        for(i=0;i<names.length;i++){
        	tempname += names[i].substring(0, 1).toUpperCase() + names[i].substring(1) + " ";
        }
        
        newname = tempname;
    }
    
    // This method tries to fix "ugly" character combinations or currently unsupported characters. For future development!
    public String fixName(){
    	String fixedname = newname;
    	
    	fixedname = newname.replace("kc", "ck");
    	fixedname = newname.replace("å", "o");
    	fixedname = newname.replace("ä", "a");
    	fixedname = newname.replace("ö", "o");
    	
    	return fixedname;
    }
    
    // This method returns newly generated name
    public String returnName(){
    	
    	return newname;
    }
    
}
