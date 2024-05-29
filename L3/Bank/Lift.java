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
		this.capacity = 3;
		this.restrictions = new int[]{res_src,res_des};
		lifts.add(this);
	}

	public static List<Lift> getNearestLifts(int src, int dest){
		List<Lift> available = new ArrayList<>();
		List<Lift> nearestLifts = new ArrayList<>();
		for(Lift l : lifts){
			int[] restrict = l.restrictions;
			if((restrict[0]<=src && restrict[0]<=dest && restrict[1]>=src && restrict[1]>=dest) 
			||(restrict[0]==6 && (src==0 || (src>=6 && dest<=10 && src<=10 && dest>=6)) )){
			if(l.capacity<-1) continue;
			if(l.floor==-1) continue;
			available.add(l);
		}
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
	
	public static  Lift assign(int src, int dest, List<Lift> nearestLifts){
		Lift assignedLift=null;
		int min = Integer.MAX_VALUE;
		for(Lift l:nearestLifts){
			if(l.stops.size()<min){
				min = l.stops.size();
				assignedLift = l;
			}
			break;
		}
		if(assignedLift!=null){
		assignedLift.capacity = assignedLift.capacity-1;
		assignedLift.stops.add(dest);
		}
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
			System.out.println("------------------------------");
			System.out.println("1.Display lift positions\n2.Travel in lift\n3.Assign Maintanance\n4.Complete Maintanance");
			int choice = in.nextInt();
			switch(choice){
				case 1:
					display();
					break;
				case 2:
					System.out.println("Enter the floor you are in:");
					int src = in.nextInt();
					System.out.println("Enter the number of persons to enter:");
					int num = in.nextInt();
					Map<Integer,Integer> up = new HashMap<>();
					Map<Integer,Integer> down = new HashMap<>();
					for(int i=0;i<num;i++){
						System.out.println("Enter the floor person "+(i+1)+ " want to go:");
						int pos = in.nextInt();
						if(pos>src) up.put(i+1,pos);
						else down.put(i+1,pos);
					}	
						
					int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
					List<Lift> assignedLifts = new ArrayList<>();
					Lift assignedLift =null;
					Lift prev_lift = null;
					for(Map.Entry<Integer,Integer> u : up.entrySet()){
						if(src==u.getValue()){
							System.out.println("Person "+u.getKey()+ " source and destination must not be same");
							continue;
						}
						List<Lift> nearestLifts = getNearestLifts(src,u.getValue());
						assignedLift = assign(src,u.getValue(),nearestLifts);
						if(assignedLift ==null){
							System.out.println("Person "+u.getKey()+ " wait for some time to get Lift");
							continue;
						}
						assignedLift.stops.add(u.getValue());
						assignedLift.capacity-=1;
						if(!assignedLifts.contains(assignedLift)){
							if(prev_lift!=null) prev_lift.floor = max;
							assignedLifts.add(assignedLift); 
							max = Integer.MIN_VALUE;
						}
						if(u.getValue()>max) max = u.getValue();
						prev_lift = assignedLift;
						System.out.println("Assigned lift to Person "+u.getKey()+" "+ assignedLift .name);
					}
					if(assignedLifts.size()>0) assignedLifts.get(assignedLifts.size()-1).floor = max;
					assignedLift = null;
					for(Lift l:assignedLifts) l.capacity =3;
					assignedLifts = new ArrayList<>();
					prev_lift = null;
					for(Map.Entry<Integer,Integer> u : down.entrySet()){
						if(src==u.getValue()){
							System.out.println("Person "+u.getKey()+ " source and destination must not be same");
							continue;
						}
						List<Lift> nearestLifts = getNearestLifts(src,u.getValue());
						assignedLift = assign(src,u.getValue(),nearestLifts);
						if(assignedLift ==null){
							System.out.println("Person "+u.getKey()+ " wait for some time to get Lift");
							continue;
						}
						assignedLift.stops.add(u.getValue());
						assignedLift.capacity-=1;
						if(!assignedLifts.contains(assignedLift)){
							if(prev_lift!=null) prev_lift.floor = min;
							assignedLifts.add(assignedLift); 
							min = Integer.MAX_VALUE;
						}
						if(u.getValue()<min) min = u.getValue();
						prev_lift = assignedLift;
						System.out.println("Assigned lift to Person "+u.getKey()+" "+ assignedLift .name);
					}
					if(assignedLifts.size()>0) assignedLifts.get(assignedLifts.size()-1).floor = min;
					for(Lift l:assignedLifts) l.capacity =3;
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