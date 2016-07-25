import java.util.ArrayList;
import java.util.List;


public class Airport {
	private int id;
	private String ident;
	private String type;
	private String name;
	private long latitude_deg;
	private long longitude_deg;
	private long elevation_ft;
	private String continent;
	private String iso_country;
	private String iso_region;
	private String municipality;
	private String scheduled_service;
	private String gps_code;
	private String iata_code;
	private String local_code;
	private String home_link;
	private String wikipedia_link;
	private String keywords;
	//private List<Runway> runways;
	public Airport() {}
	
	public Airport(String construct) {
		construct = construct.trim();
		String[] columns = construct.split(",");

		try {
			id = Integer.valueOf(columns[0]);
		}catch(Exception e) {}
		try {
			ident = columns[1].replace("\"", "");
		}catch(Exception e) {}
		try {
			type = columns[2].replace("\"", "");
		}catch(Exception e) {}
		try {
			name = columns[3].replace("\"", "");
		}catch(Exception e) {}
		try {
			latitude_deg = Long.valueOf(columns[4]);
		}catch(Exception e) {}
		try {
			longitude_deg = Long.valueOf(columns[5]);
		}catch(Exception e) {}
		try {
			elevation_ft = Long.valueOf(columns[6]);
		}catch(Exception e) {}		
		try {
			continent = columns[7].replace("\"", "");
		}catch(Exception e) {}
		try {
			iso_country = columns[8].replace("\"", "");
		}catch(Exception e) {}
		try {
			iso_region = columns[9].replace("\"", "");
		}catch(Exception e) {}
		try {
			municipality = columns[10].replace("\"", "");
		}catch(Exception e) {}
		try {
			scheduled_service = columns[11].replace("\"", "");
		}catch(Exception e) {}
		try {
			gps_code = columns[12].replace("\"", "");
		}catch(Exception e) {}
		try {
			iata_code = columns[13].replace("\"", "");
		}catch(Exception e) {}
		try {
			local_code = columns[14].replace("\"", "");
		}catch(Exception e) {}
		try {
			home_link = columns[15].replace("\"", "");
		}catch(Exception e) {}
		try {
			wikipedia_link = columns[16].replace("\"", "");
		}catch(Exception e) {}
		try {
			keywords = columns[17].replace("\"", "");
		}catch(Exception e) {}	
		
//		List<String> runways_strings = Finder.search_all("runways.csv", 2, ident);
//
//		runways = new ArrayList<Runway>();
//		for(String s : runways_strings) {
//			runways.add(new Runway(s));
//		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getLatitude_deg() {
		return latitude_deg;
	}

	public void setLatitude_deg(long latitude_deg) {
		this.latitude_deg = latitude_deg;
	}

	public long getLongitude_deg() {
		return longitude_deg;
	}

	public void setLongitude_deg(long longitude_deg) {
		this.longitude_deg = longitude_deg;
	}

	public long getElevation_ft() {
		return elevation_ft;
	}

	public void setElevation_ft(long elevation_ft) {
		this.elevation_ft = elevation_ft;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getIso_country() {
		return iso_country;
	}

	public void setIso_country(String iso_country) {
		this.iso_country = iso_country;
	}

	public String getIso_region() {
		return iso_region;
	}

	public void setIso_region(String iso_region) {
		this.iso_region = iso_region;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getScheduled_service() {
		return scheduled_service;
	}

	public void setScheduled_service(String scheduled_service) {
		this.scheduled_service = scheduled_service;
	}

	public String getGps_code() {
		return gps_code;
	}

	public void setGps_code(String gps_code) {
		this.gps_code = gps_code;
	}

	public String getIata_code() {
		return iata_code;
	}

	public void setIata_code(String iata_code) {
		this.iata_code = iata_code;
	}

	public String getLocal_code() {
		return local_code;
	}

	public void setLocal_code(String local_code) {
		this.local_code = local_code;
	}

	public String getHome_link() {
		return home_link;
	}

	public void setHome_link(String home_link) {
		this.home_link = home_link;
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

	/*public List<Runway> getRunways() {
		return runways;
	}

	public void setRunways(List<Runway> runways) {
		this.runways = runways;
	}*/

}
