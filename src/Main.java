import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter your option: Query or Reports? ");
		String line = scanner.nextLine().toLowerCase();
					
		if(line.equals("query")){
			System.out.print("Please enter the country name/code: ");
			String searchTerms = scanner.nextLine().toLowerCase();
			Query query = new Query(searchTerms);
		}else if(line.equals("reports")){
			Reports rp = new Reports();
			
		}else{
			System.out.print("This option does not exist, please enter : Query or Report");
		}
		
		scanner.close();
	}

}
