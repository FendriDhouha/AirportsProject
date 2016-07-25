
public class Runway {

	private int id;
	private int airport_ref;
	private String airport_ident;
	private int length_ft;
	private int width_ft;
	private String surface;
	private Boolean lighted;
	private Boolean closed;
	private String le_ident;
	private String le_latitude_deg;
	private String le_longitude_deg;
	private String le_elevation_ft;
	private String le_heading_degT;
	private String le_displaced_threshold_ft;
	private String he_ident;
	private String he_latitude_deg;
	private String he_longitude_deg;
	private String he_elevation_ft;
	private String he_heading_degT;
	private String he_displaced_threshold_ft;
	
	public Runway() {
		
	}
	
	public Runway(String construct) {
		construct = construct.trim();
		String[] columns = construct.split(",");

		try {
			id = Integer.valueOf(columns[0]);
		}catch(Exception e) {}
		try {
			airport_ref = Integer.valueOf(columns[1]);
		}catch(Exception e) {}
		try {
			airport_ident = columns[2].replace("\"", "");
		}catch(Exception e) {}
		try {
			length_ft = Integer.valueOf(columns[3]);
		}catch(Exception e) {}
		try {
			width_ft = Integer.valueOf(columns[4]);
		}catch(Exception e) {}
		try {
			surface = columns[5].replace("\"", "");
		}catch(Exception e) {}
		try {
			int lightedValue =  Integer.valueOf(columns[6]);
			if(lightedValue==1){
				lighted=true;
			}else{
				lighted=false;
			}			
		}catch(Exception e) {}
		try {
			int closedValue =  Integer.valueOf(columns[7]);
			if(closedValue==1){
				closed=true;
			}else{
				closed=false;
			}		
		}catch(Exception e) {}		
		try {
			le_ident = columns[8].replace("\"", "");
		}catch(Exception e) {}
		try {
			le_latitude_deg = columns[9].replace("\"", "");
		}catch(Exception e) {}
		try {
			le_longitude_deg = columns[10].replace("\"", "");
		}catch(Exception e) {}
		try {
			le_elevation_ft = columns[11].replace("\"", "");
		}catch(Exception e) {}
		try {
			le_heading_degT = columns[12].replace("\"", "");
		}catch(Exception e) {}
		try {
			le_displaced_threshold_ft = columns[13].replace("\"", "");
		}catch(Exception e) {}
		try {
			he_ident = columns[14].replace("\"", "");
		}catch(Exception e) {}
		try {
			he_latitude_deg = columns[15].replace("\"", "");
		}catch(Exception e) {}
		try {
			he_longitude_deg = columns[16].replace("\"", "");
		}catch(Exception e) {}
		try {
			he_elevation_ft = columns[17].replace("\"", "");
		}catch(Exception e) {}
		try {
			he_elevation_ft = columns[18].replace("\"", "");
		}catch(Exception e) {}	
		
		try {
			he_heading_degT = columns[19].replace("\"", "");
		}catch(Exception e) {}
		try {
			he_displaced_threshold_ft = columns[20].replace("\"", "");
		}catch(Exception e) {}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAirport_ref() {
		return airport_ref;
	}

	public void setAirport_ref(int airport_ref) {
		this.airport_ref = airport_ref;
	}

	public String getAirport_ident() {
		return airport_ident;
	}

	public void setAirport_ident(String airport_ident) {
		this.airport_ident = airport_ident;
	}

	public int getLength_ft() {
		return length_ft;
	}

	public void setLength_ft(int length_ft) {
		this.length_ft = length_ft;
	}

	public int getWidth_ft() {
		return width_ft;
	}

	public void setWidth_ft(int width_ft) {
		this.width_ft = width_ft;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public Boolean getLighted() {
		return lighted;
	}

	public void setLighted(Boolean lighted) {
		this.lighted = lighted;
	}

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public String getLe_ident() {
		return le_ident;
	}

	public void setLe_ident(String le_ident) {
		this.le_ident = le_ident;
	}

	public String getLe_latitude_deg() {
		return le_latitude_deg;
	}

	public void setLe_latitude_deg(String le_latitude_deg) {
		this.le_latitude_deg = le_latitude_deg;
	}

	public String getLe_longitude_deg() {
		return le_longitude_deg;
	}

	public void setLe_longitude_deg(String le_longitude_deg) {
		this.le_longitude_deg = le_longitude_deg;
	}

	public String getLe_elevation_ft() {
		return le_elevation_ft;
	}

	public void setLe_elevation_ft(String le_elevation_ft) {
		this.le_elevation_ft = le_elevation_ft;
	}

	public String getLe_heading_degT() {
		return le_heading_degT;
	}

	public void setLe_heading_degT(String le_heading_degT) {
		this.le_heading_degT = le_heading_degT;
	}

	public String getLe_displaced_threshold_ft() {
		return le_displaced_threshold_ft;
	}

	public void setLe_displaced_threshold_ft(String le_displaced_threshold_ft) {
		this.le_displaced_threshold_ft = le_displaced_threshold_ft;
	}

	public String getHe_ident() {
		return he_ident;
	}

	public void setHe_ident(String he_ident) {
		this.he_ident = he_ident;
	}

	public String getHe_latitude_deg() {
		return he_latitude_deg;
	}

	public void setHe_latitude_deg(String he_latitude_deg) {
		this.he_latitude_deg = he_latitude_deg;
	}

	public String getHe_longitude_deg() {
		return he_longitude_deg;
	}

	public void setHe_longitude_deg(String he_longitude_deg) {
		this.he_longitude_deg = he_longitude_deg;
	}

	public String getHe_elevation_ft() {
		return he_elevation_ft;
	}

	public void setHe_elevation_ft(String he_elevation_ft) {
		this.he_elevation_ft = he_elevation_ft;
	}

	public String getHe_heading_degT() {
		return he_heading_degT;
	}

	public void setHe_heading_degT(String he_heading_degT) {
		this.he_heading_degT = he_heading_degT;
	}

	public String getHe_displaced_threshold_ft() {
		return he_displaced_threshold_ft;
	}

	public void setHe_displaced_threshold_ft(String he_displaced_threshold_ft) {
		this.he_displaced_threshold_ft = he_displaced_threshold_ft;
	}
}
