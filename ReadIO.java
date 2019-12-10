import java.io.*;
import java.util.Scanner;

public class ReadIO {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);		
		boolean continueInput = true;
		String ogFile = "";
		String newFilename = "";





		while (continueInput){

			try {		
				System.out.println("Enter old file name.");	
				ogFile = keyboard.next();
				File file = new File(ogFile); // must read through the file to find that there is an error
				System.out.println("Enter new file name.");
				newFilename = keyboard.next();
				BufferedReader br = new BufferedReader(new FileReader(ogFile));


				try {

					BufferedReader br2 = new BufferedReader(new FileReader(newFilename));
					System.out.println("This file already exists.");
					System.out.println("Would you wish to overwrite the existing file or change the file name? ");
					System.out.println("Type y to change name.");
					String a1 = keyboard.next();

					if(a1.equals("y")){
						System.out.println("What would you like to name the file?");
						newFilename = keyboard.next();



						PrintWriter pw = new PrintWriter(new FileWriter(newFilename));
						String line;
						while ((line = br.readLine()) != null) {
							pw.println(line);

						}
						br.close();
						pw.close();
						System.out.println("Files are now created.");



					}
					//					BufferedReader br2 = new BufferedReader(new FileReader(file2));
					//					
					System.out.println("Name entered correctly.");
					continueInput = false;

				}
				catch (IOException e) {

					PrintWriter pw = new PrintWriter(new FileWriter(newFilename));
					String line;
					while ((line = br.readLine()) != null) {
						pw.println(line);

					}
					br.close();
					pw.close();
					System.out.println("Files are now created.");







				}
			}
			catch (IOException e) {
				String abort = "y";
				System.out.println("This is a incorrect file.");
				System.out.println("Enter new file or Press y to abort the program.");
				ogFile = keyboard.next();
				if(ogFile.equals(abort)) {
					continueInput = false;
					System.out.println("The Program has been Aborted");
					System.exit(0);

				}

			}


		}
		//			}

	}
}


// TODO Auto-generated method stub

