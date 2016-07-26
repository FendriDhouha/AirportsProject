import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Reports {

	private List<Map.Entry<String,Integer>> countries_high;
	private List<Map.Entry<String,Integer>> countries_low;
	
	public Reports(){
		HashMap<String, Integer> all_countries = Finder.reports_process();
		List<Map.Entry<String,Integer>> sorted_countries = new ArrayList<Map.Entry<String,Integer>>(all_countries.entrySet());
	    Collections.sort(
	    	sorted_countries,
	    	new Comparator<Map.Entry<String,Integer>>() {
	    		public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b) {
	    			return Integer.compare(b.getValue(), a.getValue());
	    		}
	    	}
	    );
	    // list of 10 countries with Highest nb of runways
	    listCountriesHigh(sorted_countries);
	    
	    System.out.println("\n\n###################################\n\n");
	    
	    // list of 10 countries with Highest nb of runways
	    listCountriesLow(sorted_countries);
	    
	    System.out.println("\n\n###################################\n\n");
	    
	    //runways Types
	    HashMap<String, HashSet<String>> airportsRunways = Finder.associateAirportsToRunways();
	    HashMap<String, HashSet<String>> countriesRunways = Finder.associateCountriesToRunways(airportsRunways);
	    List<Country> countriesList = Finder.search_countries();
	    System.out.println("Types of Runways per country:");
	    for(Country c : countriesList){
	    	if(countriesRunways.containsKey(c.getCode())) {
	    		System.out.println("* " + c.getName() + "(" + c.getCode() + "): " + countriesRunways.get(c.getCode()).toString());
	    	}
	    }
	    System.out.println("\n\n###################################\n\n");
	    
	    
	    
	    HashMap<String, Integer> identifications = Finder.getMostCommonIdentification();
	    List<Map.Entry<String,Integer>> sortedIdentifications = new ArrayList<Map.Entry<String,Integer>>(identifications.entrySet());
	    Collections.sort(
	    	sortedIdentifications,
	    	new Comparator<Map.Entry<String,Integer>>() {
	    		public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b) {
	    			return Integer.compare(b.getValue(), a.getValue());
	    		}
	    	}
	    );
	    listCommonRunways(sortedIdentifications);
	}

	public void listCountriesHigh(List<Map.Entry<String,Integer>> sorted_countries){
		countries_high = sorted_countries.subList(0, 10);
		System.out.println("10 countries with HIGHEST number of airports:");
	    for (int i = 0; i < countries_high.size(); i++) {
	    	String country_name = Finder.search("countries.csv", 1, countries_high.get(i).getKey()).split(",")[2].replace("\"", "");
			System.out.println((i+1) + ") " + country_name + " (" + countries_high.get(i).getKey() + "): " + countries_high.get(i).getValue());
		}
	}
	
	public void listCountriesLow(List<Map.Entry<String,Integer>> sorted_countries ){
	    countries_low = sorted_countries.subList(sorted_countries.size() - 10, sorted_countries.size());
		System.out.println("10 countries with LOWEST number of airports:");
	    for (int i = 0; i < countries_low.size(); i++) {
	    	String country_name = Finder.search("countries.csv", 1, countries_low.get(i).getKey()).split(",")[2].replace("\"", "");
//			System.out.println((sorted_countries.size() - 9 + i) + ") " + country_name + " (" + countries_low.get(i).getKey() + "): " + countries_low.get(i).getValue());
	    	System.out.println((i+1) + ") " + country_name + " (" + countries_low.get(i).getKey() + "): " + countries_low.get(i).getValue());
		}
	}
	
	public void listCommonRunways(List<Map.Entry<String,Integer>> sortedIdentifications){
		List<Map.Entry<String,Integer>> firstIdentifications = sortedIdentifications.subList(0, 10);
		System.out.println("10 most common runways in the world:");
	    for (int i = 0; i < firstIdentifications.size(); i++) {
	    	System.out.println((i+1) + ") " + firstIdentifications.get(i).getKey() + ": " + firstIdentifications.get(i).getValue());
		}
	}
	
	public List<String> runwaysType(Country country){
		
		return null;
	}
	
	public List<Map.Entry<String, Integer>> getCountries_high() {
		return countries_high;
	}

	public void setCountries_high(List<Map.Entry<String, Integer>> countries_high) {
		this.countries_high = countries_high;
	}

	public List<Map.Entry<String, Integer>> getCountries_low() {
		return countries_low;
	}

	public void setCountries_low(List<Map.Entry<String, Integer>> countries_low) {
		this.countries_low = countries_low;
	}
}
