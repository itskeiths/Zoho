import java.util.*;
class TaxiBooking {	
		static int booking_id = 0;
		static List<Taxi> taxis = new ArrayList<>();
		static List<Character> points = new ArrayList<>(Arrays.asList('A','B','C','D','E','F'));
		TaxiBooking(){
			Taxi t1 = new Taxi("Taxi-1");
			Taxi t2 = new Taxi("Taxi-2");
			Taxi t3 = new Taxi("Taxi-3");
			Taxi t4 = new Taxi("Taxi-4");
			taxis.add(t1);
			taxis.add(t2);
			taxis.add(t3);
			taxis.add(t4);
		}
	
		public static List<Taxi> getFreeTaxis(int pickup_time,char pickup){
			List<Taxi> freeTaxis = new ArrayList<>();
			for(Taxi t : taxis){
				if(t.freetime+Math.abs(pickup-t.cur_point)<pickup_time)  freeTaxis.add(t);
			}
			return freeTaxis;
		}

		public static void addDetails(int cus_id,Taxi taxi,char pickup, char drop, int pickuptime){
			taxi.cur_point = drop;
			int droptime = Math.abs(pickup-drop)+pickuptime;
			taxi.freetime =droptime;
			int amount =100+(Math.abs(pickup-drop)*15-5)*10;
			taxi.earnings +=amount;
			String details = booking_id+"\t\t "+cus_id+" \t"+"\t "+pickup+"\t "+drop+"\t"+pickuptime+"\t\t"+droptime+"\t\t"+amount;
			taxi.tripDetails.add(details);
		}
	
		public static void displayDetails(){
			System.out.println("-------------Taxi Details-------------");
			for(Taxi t:taxis){
				if(t.tripDetails.size()>0){
				System.out.println(t.name+" Total Earnings: "+t.earnings);
				System.out.println("Booking Id\tCustomerId\tFrom\tTo\tPickupTime\tDropTime\tAmount");
				for(String detail: t.tripDetails){
					System.out.println(detail);
				}
				System.out.println();
				}
			}
			System.out.println("----------------------------------------");
		}
		
		public static Taxi bookTaxi(int cus_id, char pickup, char drop , int pickup_time){
			booking_id++;
			List<Taxi> freeTaxis = getFreeTaxis(pickup_time,pickup);
			if(freeTaxis==null) return null;
			Taxi allocateTaxi= allocateTaxi(freeTaxis,pickup);
			if(allocateTaxi==null) return null;
			addDetails(cus_id,allocateTaxi,pickup,drop,pickup_time);
			return allocateTaxi;
		}
	
		public static Taxi allocateTaxi (List<Taxi> freeTaxis,char pickup){
			List<Taxi> nearby = new ArrayList<>();
			int min =Integer.MAX_VALUE;
			for(Taxi t:freeTaxis){
				if(min>Math.abs(t.cur_point-pickup)) min = Math.abs(t.cur_point-pickup);
			}
			for(Taxi t:freeTaxis){
				if(Math.abs(t.cur_point-pickup)==min) nearby.add(t);
			}
			min= Integer.MAX_VALUE;
			Taxi allocateTaxi = null;
			for(Taxi t:nearby){
				if(t.earnings<min){
					min=t.earnings;
					allocateTaxi = t;
				}
			}
			return allocateTaxi;
		}
}