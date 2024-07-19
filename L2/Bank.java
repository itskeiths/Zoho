import java.util.*;
import java.io.*;
class Bank{
	public static void main(String[] args) throws IOException{
		File file = new File("bank_db.txt");
		Scanner data = new Scanner(file);
		data = data.nextLine();
		while(data.hasNextLine()){
			System.out.println(d.nextLine());
		}
	}
}