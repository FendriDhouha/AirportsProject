import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter your option: Query or Reports? ");
		String line = scanner.nextLine().toLowerCase();
		
		// Option has been selected
		System.out.println("Option selected: " + line.toUpperCase());
		if(!line.equals("query") && !line.equals("reports")){
			return ;
		}
		
		if(line.equals("query")){
			System.out.print("Please enter the country name/code: ");
			String searchTerms = scanner.nextLine().toLowerCase();
			//Query query = new Query(searchTerms);
			new Query(searchTerms);
		}else if(line.equals("reports")){
			Reports rp = new Reports();
			
		}
        
		
		/*try {
			BufferedReader in = new BufferedReader(new FileReader(new File(
					System.getProperty("user.dir") + "/resources/airports.csv")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		
		
		scanner.close();
	}

}
