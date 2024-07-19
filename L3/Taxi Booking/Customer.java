import java.util.*;
class Customer {
	public static void main(String[] args){
		TaxiBooking t = new TaxiBooking();
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("1.Book Taxi\n2.Display Details");
			int choice = in.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter customer id:");
					int cus_id = in.nextInt();
					System.out.println("Enter Pickup Point:");
					char pickup = in.next().charAt(0);
					System.out.println("Enter Drop Point:");
					char drop = in.next().charAt(0);
					if(!t.points.contains(pickup) || !t.points.contains(drop)){
						System.out.println("Invalid Pickup or drop Point");
						break;
					}
					System.out.println("Enter Pickup Time:");
					int pickup_time = in.nextInt();
					Taxi taxi = t.bookTaxi(cus_id,pickup,drop,pickup_time);
					if(taxi!=null) System.out.println("Taxi Allocated: "+taxi.name);
					else System.out.println("No taxis free at this time");
					break;
				case 2:
					t.displayDetails();
					break;
				default:
					return;
			}
		}
	}
}