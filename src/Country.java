import java.util.ArrayList;
import java.util.List;


public class Country {
	private int id;
	private String code;
	private String name;
	private String continent;
	private String wikipedia_link;
	private String keywords;
	//private List<Airport> airports;
	
	public Country(){
	}
	
	public Country(String construct){
		construct = construct.trim();
		String[] columns = construct.split(",");

		try {
			id = Integer.valueOf(columns[0]);
		}catch(Exception e) {}
		try {
			code = columns[1].replace("\"", "");
		}catch(Exception e) {}
		try {
			name = columns[2].replace("\"", "");
		}catch(Exception e) {}
		try {
			continent = columns[3].replace("\"", "");
		}catch(Exception e) {}
		try {
			wikipedia_link = columns[4].replace("\"", "");
		}catch(Exception e) {}
		try {
			keywords = columns[5].replace("\"", "");
		}catch(Exception e) {}
		
		
//		List<String> airports_strings = Finder.search_all("airports.csv", 8, code);
//		airports = new ArrayList<Airport>();
//		for(String s : airports_strings) {
//			airports.add(new Airport(s));
//		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getWikipedia_link() {
		return wikipedia_link;
	}

	public void setWikipedia_link(String wikipedia_link) {
		this.wikipedia_link = wikipedia_link;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/*public List<Airport> getAirports() {
		return airports;
	}

	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}*/

}
