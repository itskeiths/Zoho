import java.util.*;

class Lift{
	static HashMap<Integer,Integer> floor = new HashMap<>();
	static HashMap<Integer,List<Integer>> stops = new HashMap<>();
	static HashMap<Integer,Integer> capacity = new HashMap<>();
	static List<int[]> restrictions = new ArrayList<>();
	
	public Lift(){
		for(int i=1;i<=5;i++){	
			floor.put(i,0);
			stops.put(i, new ArrayList<>());
			capacity.put(i,10);
		}
		restrictions.add(new int[]{0,5});
		restrictions.add(new int[]{0,5});
		restrictions.add(new int[]{6,10});
		restrictions.add(new int[]{6,10});
		restrictions.add(new int[]{0,10});
	}
	
	public List<Integer> getNearestLifts(int src, int dest,int num){
		List<Integer> available = new ArrayList<>();
		List<Integer> nearest = new ArrayList<>();
		for(int i=0;i<5;i++){
			int restrict[] = restrictions.get(i);
			if(restrict[0]==src && restrict[1]==dest) continue;
			if(capacity.get(i+1)-num<0) continue;
			if(floor.get(i+1) == -1) continue;
			available.add(i+1);
		}
	
		int min = Integer.MAX_VALUE;
		for(int avail : available){
			if(Math.abs(src-floor.get(avail))<min) min = Math.abs(src-floor.get(avail));
		}
		for(int avail : available){
			if(Math.abs(src-floor.get(avail)) == min) nearest.add(avail);
		}
		return nearest;
	}
		
	public int assign(int src, int dest, List<Integer> nearestLifts,int num){
		int assignedLift=0;
		int min = Integer.MAX_VALUE;
		for(int i:nearestLifts){
			if(stops.get(i).size()<min){
				min = stops.get(i).size();
				assignedLift = i;
			}
			break;
		}
		floor.put(assignedLift,dest);
		int cur_cap= capacity.get(assignedLift);
		capacity.put(assignedLift,cur_cap-num);
		int greater = src>dest?src:dest;
		int smaller = src<dest?src:dest;
		for(int i=smaller;i<=greater;i++) stops.get(assignedLift).add(i);
		return assignedLift;
	}
	
	public void display(){
		for(int i=1;i<=floor.size();i++){
			System.out.println("L"+i+" -> "+floor.get(i));
		}
	}
	
	
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Lift l = new Lift();
		while(true){
			System.out.println("1.Display lift positions\n2.Travel in lift\n3.Assign Maintanance\n4.Complete Maintanance");
			int choice = in.nextInt();
			switch(choice){
				case 1:
					l.display();
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
					List<Integer> nearestLifts = l.getNearestLifts(src,des,num);
					System.out.println("Assigned lift to you: "+ l.assign(src,des,nearestLifts,num));
					break;
				case 3:
					System.out.println("Enter the maintanance lift:");
					int lift = in.nextInt();	
					if(floor.get(lift)==-1){
						System.out.println("The lift is already under maintanance");
						break;
					}
					floor.put(lift,-1);
					break;
				case 4:
					System.out.println("Enter the lift to revoke maintanance:");
					lift = in.nextInt();
					if(floor.get(lift)!=-1){
						System.out.println("The lift is not under maintanance");
						break;
					}
					floor.put(lift,0);
					break;
				default:
					return;
			}
		}
	}
}