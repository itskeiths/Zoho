import java.util.Scanner;
class Patient{
	int id,wait_time, doc_time;
	String name,in_time, out_time ;
	public Patient(int id, String name, String in_time){
		this.id = id;
		this.name = name;
		this.in_time = in_time;
		this.wait_time = 0;
		new HospitalManagement(this).visitHospital();
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("1.Visit Hospital\n2.Display Patient Records");
			int choice = in.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter Patient ID:");
					int id = in.nextInt();
					System.out.println("Enter Patient Name:");
					String name = in.next();
					System.out.println("Enter In time:");
					String time = in.next();
					new Patient(id,name,time);
					break;
				case 2:
					HospitalManagement.displayRecords();
					break;
				default:
					return;
			}
		}
		
	}
}