import java.util.List;


public class Query {
	private Country country = null;
	//private List<Airport> Airports;

	public Query() {
		
	}
	
	public Query(String searchTerms){
		List<Airport> airports = null;
		List<Runway> runways = null;
		// airports search by code / name
		if(searchTerms.length() == 2){
			String code = searchTerms.toUpperCase();
			String searchResults = Finder.search("countries.csv", 1, code);
			if(searchResults == "") {
				System.out.println("Country code not found.");
			}else{
				Country country = new Country(searchResults);			
				airports = Finder.airportsFound(country);
				if(airports.size()>0){
					System.out.println("\nAirports found "+ country.getName().toUpperCase() + " are: ");
					for(int i=0;i<airports.size();i++){
						System.out.print("* " + airports.get(i).getName());
						runways = Finder.runwaysFound(airports.get(i));
						System.out.println("\n");
					}
				}else{
				System.out.print("There are no Airports on the Country "+ country.getName());
				}
			}		
			
		}else if(searchTerms.length() > 2){
			String name = searchTerms.toUpperCase();
			String searchResults = Finder.search("countries.csv", 2, name);
			if(searchResults == null){
				searchResults = Finder.searchPartial("countries.csv", 2, name);
			}						
			if(searchResults == null) {
				System.out.println("Country name not found.");
			}else{
				Country country = new Country(searchResults);			
				airports = Finder.airportsFound(country);
				if(airports.size()>0){
					System.out.println("\nAirports found in " + country.getName().toUpperCase() + " are:\n");
					for(int i=0;i<airports.size();i++){
						System.out.print("* " + airports.get(i).getName());
						runways = Finder.runwaysFound(airports.get(i));
					}
				}else{
				System.out.print("There are no Airports on the Country "+ country.getName());
				}
			}						
		}			
		
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
}
