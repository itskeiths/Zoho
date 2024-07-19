import java.util.*;
public class HospitalManagement{
	static List<Patient> record = new ArrayList<>();
	Patient curPatient;
	static int mp1=0,mp2=0,doc=0,pharmacy=0;
	public HospitalManagement(Patient p){
		this.curPatient = p;
		for(int i=0;i<record.size();i++){
			if(record.get(i).id==curPatient.id) record.remove(i);
		}
		record.add(curPatient);
	}

	void visitHospital(){	
		Random rand = new Random();
		int doc_time = rand.nextInt(2,20);
		curPatient.doc_time=doc_time;
		int in_time = convertMin(curPatient.in_time);
		if(mp1>in_time){
			curPatient.wait_time+=mp1-in_time;
			in_time=mp1;
		}
		mp1=in_time+5;
		if(mp2>mp1){
			curPatient.wait_time+=mp2-in_time;
			in_time = mp2;
			mp2=in_time+5;
		}
		else mp2=mp1+5;
		if( doc>mp2){
			curPatient.wait_time+=doc-in_time;
			in_time=doc;
			doc =doc_time+in_time;
		}
		else doc = doc_time+mp2;
		if(pharmacy>doc){
			curPatient.wait_time+=pharmacy-in_time;
			in_time=pharmacy;
			pharmacy=in_time+5;
		}
		else pharmacy=doc+5;
		if(curPatient.wait_time>10) curPatient.wait_time-=10;
		curPatient.out_time=convertTime(pharmacy);
	}

	String convertTime(int time){
		String t ="";
		String period ="AM";
		if(time>720){
			period="PM";
			time -=720;
		}
		t+=(time/60);
		t+='.';
		t+=(time%60);
		t+=" "+period;
		return t;
	}
	
	int convertMin(String time){
		int min=0;
		if(time.charAt(time.length()-2)=='P') min+=720;
		int hrs = 0;
		int i=0;
		while(time.charAt(i)!='.'){
			hrs+=time.charAt(i)-'0';
			i++;
			hrs=hrs*10;
		}
		hrs/=10;
		min += hrs*60;
		i++;
		while(time.charAt(i)>='0' && time.charAt(i)<='9'){
			min+=time.charAt(i)-'0';
			i++;
		}
		return min;
	}
	
	static void displayRecords(){
		System.out.println("Patient ID:\tTime taken by doctor to visit\tOuttime\t\tTotal waiting time");
		for(Patient p: record){
			System.out.println(p.id+"\t\t\t"+p.doc_time+"\t\t\t"+p.out_time+"\t\t"+p.wait_time);
		}
	}
}