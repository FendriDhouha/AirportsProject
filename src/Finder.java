import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class Finder {
	/**
	 * 
	 * @param file : the file we're using
	 * @param columnIndex 
	 * @param value
	 * @return a String containing a line which represents a Class Instance 
	 */
	public static String search(String file, int columnIndex, String value){
		String output = null;
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(
					System.getProperty("user.dir") + "/resources/" + file)));
			
			String ligne;
			boolean found = false;
			while ((ligne=in.readLine())!=null && !found){
				String [] columns = ligne.split(",");
				if(columns[columnIndex].toUpperCase().equals("\"" + value + "\"")){
					found = true;
					output = ligne;
					break;
				}
			}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		 
		
		return output;
	}
	
	public static String searchPartial(String file, int columnIndex, String value){
		String output = null;
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(
					System.getProperty("user.dir") + "/resources/" + file)));
			
			String ligne;
			boolean found = false;
			while ((ligne=in.readLine())!=null && !found){
				String [] columns = ligne.split(",");
				if(columns[columnIndex].toUpperCase().startsWith("\"" + value)){
					found = true;
					output = ligne;
					break;
				}
			}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		 
		
		return output;
	}
	/**
	 * 
	 * @param file
	 * @param columnIndex
	 * @param value
	 * @return
	 */
	
	public static List<String> search_all(String file, int columnIndex, String value){
		List<String> output = new ArrayList<String>();
		//String[] output2 = {};
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(
					System.getProperty("user.dir") + "/resources/" + file)));
			
			String ligne;
			while ((ligne=in.readLine())!=null){
				String [] columns = ligne.split(",");
				if(columns[columnIndex].equals("\"" + value + "\"")){
					output.add(ligne);
					//break;
				}
			}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}
	/**
	 * 
	 * @return the list of countries found on the file countries.csv
	 */
	public static List<Country> search_countries(){
		List<Country> output = new ArrayList<Country>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(
					System.getProperty("user.dir") + "/resources/countries.csv")));
			
			String ligne;
			while ((ligne=in.readLine())!=null){
				output.add(new Country(ligne));
			}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}
	/**
	 * 
	 * @param country
	 * @return airports found by country
	 */
	public static List<Airport> airportsFound(Country country){
		
		List<String> airports_strings = Finder.search_all("airports.csv", 8, country.getCode());
		List<Airport> airportList = new ArrayList<Airport>();
		for(String s : airports_strings) {
			airportList.add(new Airport(s));
		}
		return airportList;
	}
	/**
	 * 
	 * @param airport
	 * @return runways found by airport
	 */
	public static List<Runway> runwaysFound(Airport airport){
	
		List<String> runways_strings = Finder.search_all("runways.csv", 2, airport.getIdent());

		List<Runway> runwaysList = new ArrayList<Runway>();
		for(String s : runways_strings) {
			runwaysList.add(new Runway(s));
		}
		
		if(runwaysList.size()>0){
			System.out.print("\n");
			System.out.println("Number of Runways found on the Airport "+ airport.getName() + " is: "+runwaysList.size());
			System.out.print("Runways found on the Airport "+ airport.getName() + " are: ");
			String toPrint = "";
			for(int i=0;i<runwaysList.size();i++){
				toPrint += runwaysList.get(i).getId() + ", ";
			}
			System.out.println(toPrint.subSequence(0, toPrint.length()-2));
		}else{
			System.out.print("\nThere are no Runways on the Airport "+ airport.getName()+"\n");
		}
		return runwaysList;
	}
	
	/**
	 * 
	 * @param airport
	 * @return types of runways on each airport
	 */
	public static Set<String> runwaysTypes(Airport airport){
		
		//List<Runway> runwaytList = airport.getRunways();
		List<String> runways_strings = Finder.search_all("runways.csv", 2, airport.getIdent());

		List<Runway> runwaysList = new ArrayList<Runway>();
		for(String s : runways_strings) {
			runwaysList.add(new Runway(s));
		}
		List<String> runwaysTypes = new ArrayList<String>();
		Set<String> runwaysTypes_set = new LinkedHashSet<>(runwaysTypes);
		if(runwaysList.size()>0){
			for(Runway run :runwaysList){
				runwaysTypes_set.add(run.getSurface());
			}
		}
		return runwaysTypes_set;
	}
	
	public static HashMap<String, Integer> reports_process() {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(
					System.getProperty("user.dir") + "/resources/airports.csv")));
			
			String ligne;
			boolean first_line = true;
			while ((ligne=in.readLine())!=null){
				if(first_line) {
					first_line = false;
					continue;
				}
				String country_code = ligne.split(",")[8].replace("\"", "");
				if(country_code.equals("656"))
					country_code = ligne.split(",")[10].replace("\"", "");
				if(!result.containsKey(country_code))
					result.put(country_code, 0);
				result.put(country_code, result.get(country_code) + 1);
			}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public static HashMap<String, Integer> getMostCommonIdentification() {
		HashMap<String, Integer> output = new HashMap<String, Integer>();
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(
					System.getProperty("user.dir") + "/resources/runways.csv")));
			
			String ligne;
			boolean first_line = true;
			while ((ligne=in.readLine())!=null){
				if(first_line) {
					first_line = false;
					continue;
				}
				String identification = null;
				try {
					identification = ligne.split(",")[8].replace("\"", "");
					if(identification.equals("")) continue;
				}catch(Exception e) {
					continue;
				}
				
//				if(country_code.equals("656"))
//					country_code = ligne.split(",")[10].replace("\"", "");
				if(!output.containsKey(identification))
					output.put(identification, 0);
				output.put(identification, output.get(identification) + 1);
			}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return output;
	}
	
	public static HashMap<String, HashSet<String>> associateAirportsToRunways() {
		HashMap<String, HashSet<String>> output = new HashMap<String, HashSet<String>>();
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(
					System.getProperty("user.dir") + "/resources/runways.csv")));
			
			String ligne;
			boolean first_line = true;
			while ((ligne=in.readLine())!=null){
				if(first_line) {
					first_line = false;
					continue;
				}
				
				String airportId;
				String runwaySurface;
				
				try {
					String[] lineSplit = ligne.split(",");
					airportId = lineSplit[2].replace("\"", "");
					runwaySurface = lineSplit[5].replace("\"", "");
					if(airportId.equals("") || runwaySurface.equals(""))
						continue;
				}
				catch(Exception e) {
					e.printStackTrace();
					continue;
				}
				
				if(!output.containsKey(airportId)) {
					output.put(airportId, new HashSet<String>());
				}
				output.get(airportId).add(runwaySurface);
				
			}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return output;
	}

	public static HashMap<String, HashSet<String>> associateCountriesToRunways(HashMap<String, HashSet<String>> airportsRunways) {
		HashMap<String, HashSet<String>> output = new HashMap<String, HashSet<String>>();
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(
					System.getProperty("user.dir") + "/resources/airports.csv")));
			
			String ligne;
			boolean first_line = true;
			while ((ligne=in.readLine())!=null){
				if(first_line) {
					first_line = false;
					continue;
				}
				
				String airportId, country;
				
				try {
					String[] lineSplit = ligne.split(",");
					airportId = lineSplit[1].replace("\"", "");
					if(airportId.equals("") || !airportsRunways.containsKey(airportId))
						continue;
					country = lineSplit[8].replace("\"", "");
				}
				catch(Exception e) {
					e.printStackTrace();
					continue;
				}
				
				if(!output.containsKey(country)) {
					output.put(country, new HashSet<String>());
				}
				output.get(country).addAll(airportsRunways.get(airportId));
				
			}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return output;
	}

}
