import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Interview class 
 *
 */
public class Interview {

	private final static Logger LOGGER = Logger.getLogger(Interview.class.getName()); 

	/**
	 * 
	 * @return List of strings hard coded before the interview
	 */
	private List<String> loadNames(){
		List<String> interviewCandidates = new ArrayList<String>();
		interviewCandidates.add("MARY");
		interviewCandidates.add("JOE");
		interviewCandidates.add("SIENNA");
		interviewCandidates.add("PETER");
		return interviewCandidates;
	}
	
	/**
	 * 
	 * @param candidateNames: list of names to be converted
	 * @return candidate names in mixed case
	 * for example: PETER is returned as Peter
	 */
	
	/*
	 * non javadoc: I contemplated using StringBuilder to simplify logic but in loadNames method above, I did not see any reason to use 
	 * StringBuilder. But Strings are immutable. Therefore I felt converting each entry in the list from String to StringBuilder will cause 
	 * just as much overhead as using strings to implement conversion. Atleast, the code is straight forward and easy to understand. 
	 */
	private List<String> convertCase(List<String> candidateNames){
		if(candidateNames == null){
			LOGGER.warning("Candidate names list is empty");
			return null;
		}
		List<String> modifiedCandidateNames = new ArrayList<String>();
		for(String candidateName:candidateNames){
			char firstCharacter  = candidateName.charAt(0);
			String lowerCandidateName = candidateName.toLowerCase();
			modifiedCandidateNames.add( firstCharacter + lowerCandidateName.substring(1, candidateName.length()) );
		}
		return modifiedCandidateNames;
	}
	
	/**
	 * 
	 * @param candidateNames creates a map between name of the candidate and the person's calculated birthdate
	 * @return map of names and birthdates
	 */
	
	/*
	 * Calendar or DateTime is a better option to use while calculating dates since most of the methods are deprecated with java.util.Date
	 * but since the requirements doc specified java.util.Date, I decided to go forward with the methods below. 
	 */
	@SuppressWarnings("deprecation")
	private Map<String, Date> createBirthDate(List<String> candidateNames){
		if(candidateNames == null){
			LOGGER.warning("Candidate names list is empty");
			return null;
		}
		Map<String, Date> candidateBirthdates = new HashMap<String, Date>();
		for(String candidateName: candidateNames){
			Date birthDate = new Date();
			birthDate.setDate(6);
			birthDate.setMonth(3);
			birthDate.setYear(90 - candidateName.length());
			candidateBirthdates.put(candidateName, birthDate);
		}
		return candidateBirthdates;
	}
	
	/**
	 * Method to print the display format string for each name
	 * </br><b><i> <name>__ was born on <year>__ and is <age>__ years old</i><b>
	 * @param candidateBirthDates map between name and birthdate
	 */
	@SuppressWarnings("deprecation")
	private void display(Map<String, Date> candidateBirthDates){
		if(candidateBirthDates == null){
			LOGGER.warning("Candidate names map is empty");
		}
		else{
			for(Map.Entry<String, Date> entry : candidateBirthDates.entrySet()){
				//a quick reference here to StackOverflow on how to loop a map effectively!
				StringBuilder displayString = new StringBuilder(entry.getKey() + " was born in ");
				Date birthDate = entry.getValue();
				int birthYear = birthDate.getYear();
				displayString.append( (1900 + birthYear) + " and is " + (new Date().getYear() - birthYear) + " years old.");
				System.out.println(displayString);
			}
		}
	}
	
	public static void main(String args[]){
		Interview currentInterview = new Interview();
		List<String> candidateNames = currentInterview.loadNames();
		candidateNames = currentInterview.convertCase(null);
		currentInterview.display(currentInterview.createBirthDate(candidateNames));
	}
}
