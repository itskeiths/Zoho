import java.util.*;

class Lift{
	String name;
	int floor;
	List<Integer> stops;
	int capacity;
	int[] restrictions;
	static List<Lift> lifts = new ArrayList<>();
	
	public Lift(String name, int res_src, int res_des){
		this.name = name;
		this.floor=0;
		this.stops = new ArrayList<>();
		this.capacity = 10;
		this.restrictions = new int[]{res_src,res_des};
		lifts.add(this);
	}

	public static List<Lift> getNearestLifts(int src, int dest,int num){
		List<Lift> available = new ArrayList<>();
		List<Lift> nearestLifts = new ArrayList<>();
		for(Lift l : lifts){
			int[] restrict = l.restrictions;
			if(restrict[0]==src && restrict[1]==dest) continue;
			if(l.capacity-num<0) continue;
			if(l.floor==-1) continue;
			available.add(l);
		}
		int min = Integer.MAX_VALUE;
		for(Lift avail : available){
			if(Math.abs(src-avail.floor)<min) min = Math.abs(src-avail.floor);
		}
		for(Lift avail : available){
			if(Math.abs(src-avail.floor) == min) nearestLifts.add(avail);
		}
		return nearestLifts;
		
	}
	
	public static  Lift assign(int src, int dest, List<Lift> nearestLifts,int num){
		Lift assignedLift=null;
		int min = Integer.MAX_VALUE;
		for(Lift l:nearestLifts){
			if(l.stops.size()<min){
				min = l.stops.size();
				assignedLift = l;
			}
			//break;
		}
		assignedLift.floor = dest;
		assignedLift.capacity = assignedLift.capacity-num;
		int greater = src>dest?src:dest;
		int smaller = src<dest?src:dest;
		for(int i=smaller;i<=greater;i++) assignedLift.stops.add(i);
		return assignedLift;
	}
	
	public static void display(){
		for(Lift l:lifts){
			System.out.println(l.name+"->"+l.floor);
		}
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Lift l1 = new Lift("L1",0,5);
		Lift l2 = new Lift("L2",0,5);
		Lift l3 = new Lift("L3",6,10);
		Lift l4 = new Lift("L4",6,10);
		Lift l5 = new Lift("L5",0,10);
		while(true){
			System.out.println("1.Display lift positions\n2.Travel in lift\n3.Assign Maintanance\n4.Complete Maintanance");
			int choice = in.nextInt();
			switch(choice){
				case 1:
					display();
					break;
				case 2:
					System.out.println("Enter the floor you are in:");
					int src = in.nextInt();
					System.out.println("Enter the floor you want to go:");
					int des = in.nextInt();
					System.out.println("Enter the number of persons to enter:");
					int num = in.nextInt();
					if(src==des){
						System.out.println("Your source and destination must not be same");
						break;
					}
					List<Lift> nearestLifts = getNearestLifts(src,des,num);
					System.out.println("Assigned lift to you: "+ assign(src,des,nearestLifts,num).name);
					break;
				case 3:
					System.out.println("Enter the maintanance lift:");
					String lift = in.next();	
					Lift maintanance=null;
					for(Lift l:lifts){
						 if(l.name.equals(lift)){
							maintanance = l;
						}
					}
					if(maintanance.floor==-1){
						System.out.println("The lift is already under maintanance");
						break;
					}
					maintanance.floor=-1;
					break;
				case 4:
					System.out.println("Enter the maintanance lift:");
					lift = in.next();	
					maintanance=null;
					for(Lift l:lifts){
						 if(l.name.equals(lift)){
							maintanance = l;
						}
					}
					if(maintanance.floor!=-1){
						System.out.println("The lift is not under maintanance");
						break;
					}
					maintanance.floor=0;
					break;
				default:
					return;
			}
		}
	}
}