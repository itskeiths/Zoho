import java.util.*;
public class Taxi{
	public String name;
	char cur_point;
	int earnings;
	int freetime;
	List<String> tripDetails;
	public Taxi(String name){
		this.name = name;
		this.cur_point = 'A';
		this.earnings = 0;
		this.freetime=0;
		this.tripDetails = new ArrayList<>();
	}
	
}

