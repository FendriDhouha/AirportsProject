import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("###################################\n###################################\n");
			System.out.print("Please enter your option (Query[q] or Reports[r]): ");
			String line = scanner.nextLine().toLowerCase();
						
			if(line.equals("query") || line.equals("q")){
				System.out.print("\n###################################\nYou have selected: QUERY\n###################################\n\n");
				System.out.print("Please enter the country name/code: ");
				String searchTerms = scanner.nextLine().toLowerCase();
				Query query = new Query(searchTerms);
			}else if(line.equals("reports") || line.equals("r")){
				System.out.print("\n###################################\nYou have selected: REPORTS\n###################################\n\n");
				Reports rp = new Reports();
				
			}else if(line.equals("quit")){
				System.out.println("Quitting...");
				break;
			
			}else {
				System.out.print("This option does not exist, please enter : Query[q] or Reports[r]");
			}
		}

		System.out.println("Farewell.");
		scanner.close();
	}

}
