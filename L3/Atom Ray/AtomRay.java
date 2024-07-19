import java.util.*;
class AtomRay{
	static char matrix[][];
	static int row,col;
	static char hit = 'H';
	static char atomx = 'X';
	static String[] Rlrays;
	static String[] Curays;
	static String[] Rrrays;
	static String[] Cbrays;
	AtomRay(int row , int col){
		this.row = row;
		this.col = col;
		matrix = new char[row][col];
		Rlrays = new String[row];
		Curays = new String[col];
		Rrrays = new String[row];
		Cbrays = new String[col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				matrix[i][j]='-';
			}
		}
	}
	
	public void insertAtoms(int[][] pos){
		for(int i=0;i<pos.length;i++){
			int x = row-pos[i][0];
			int y = pos[i][1]-1;
			if(x>=0 && x<row && y>=0 && y<col) matrix[x][y]=atomx;
		}
	}
	
	public void insertRays(String[] rays){
		for(int i=0;i<rays.length;i++){
			if(rays[i]!=null){
			int n = rays[i].charAt(1)-'0';
			char type = rays[i].charAt(0);
			if(type=='R'){
				int pos = row-n;
				Rlrays[pos]=rays[i];
				Rrrays[pos]=rays[i];
			}
			if(type=='C'){
				int pos = n-1;
				Curays[pos] = rays[i];
				Cbrays[pos] = rays[i];
			}
			}
		}
	}
	
	public void checkHit(){
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(matrix[i][j]=='X'){
					if(Rlrays[i]!=null) {
						Rlrays[i]="H ";
						Rrrays[i]=null;
					}
					if(Cbrays[j]!=null) {
						Cbrays[j]="H ";
						Curays[j]=null;
					}
				}
			}
		}
	}
	
	public void checkReflection(){
		int i=0,j=0;
		boolean isreflect=false;
		while(i<row){
			int reflect=0;
			j=0;
			isreflect=false;
			while(j<col){
				if(isreflect) reflect++;
				if(matrix[i][j]=='X'){
					reflect+=1;
					if(!isreflect) reflect+=1;
					else reflect = 0;
					isreflect=!isreflect;
				}
				if(isreflect && reflect>1){
					if(Cbrays[j]!=null) Cbrays[j]="R ";	
					Curays[j]=null;
				}
				j++;
			}
			i++;
		}
		i=row-1;j=0;
		isreflect = false;
		while(j<col){
			int reflect = 0;
			i=row-1;
			isreflect = false;
			while(i>=0){
				if(isreflect) reflect++;
				if(matrix[i][j]=='X'){
					if(!isreflect) reflect+=1;
					else reflect = 0;
					isreflect=!isreflect;
				}	
				if(isreflect && reflect>1){
					if(Rlrays[i]!=null) Rlrays[i]="R ";
					Rrrays[i]=null;
				}
				i--;
			}
			j++;
		}
	}
	
	public void checkRefract(){
		for(int i=0;i<row;i++){
			for(int j=0;j<col-1;j++){
				if((i!=0 &&matrix[i-1][j+1]=='X' ) && Rlrays[i]!=null && Rlrays[i].charAt(0)=='R' && Rlrays[i].charAt(1)!=' ') 						{
					Cbrays[j]=Rlrays[i];
					Rrrays[i]=null;
					Curays[j]=null;
				}
				if((i!=row-1 &&matrix[i+1][j+1]=='X' ) && Rlrays[i]!=null && Rlrays[i].charAt(0)=='R' && Rlrays[i].charAt(1)!=' ') 						{
					Curays[j]=Rlrays[i];
					Rrrays[i]=null;
				}
			}
		}
		for(int j=0;j<col;j++){
			for(int i=row-1;i>0;i--){
				if( (j!=0 && matrix[i-1][j-1]=='X') && Cbrays[j]!=null && Cbrays[j].charAt(0)=='C' && Cbrays[j].charAt(1)!=' '){								Rrrays[i]= Cbrays[j];
						Curays[j]=null;
				}
				if( (j!=col-1 && matrix[i-1][j+1]=='X') && Cbrays[j]!=null && Cbrays[j].charAt(0)=='C' && Cbrays[j].charAt(1)!=' '){								Rlrays[i]= Cbrays[j];
						Curays[j]=null;
						Rrrays[i]=null;
				}		
			}
			
		}
	}
	
	public void display(){
		System.out.println();
		System.out.print("      ");
		for(int i=0;i<col;i++){
			if(Curays[i]!=null) System.out.print(Curays[i]+" ");
			else System.out.print("   ");
		}
		System.out.println();
		for(int i=0;i<row;i++){
			System.out.println();
			if(Rlrays[i]!=null) System.out.print(Rlrays[i]+" ");
			else System.out.print("   ");
			System.out.print("|  ");
			for(int j=0;j<col;j++){
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.print("|  ");
			if(Rrrays[i]!=null) System.out.print(Rrrays[i]+" ");
			else System.out.print("   ");
			System.out.println();
		}
		System.out.println();
		System.out.print("      ");
		for(int i=0;i<col;i++){
			if(Cbrays[i]!=null) System.out.print(Cbrays[i]+" ");
			else System.out.print("   ");
		}
	}

	public static void main(String[] args){
		Scanner in =  new Scanner(System.in);
		System.out.println("Enter rows and columns:");
		int row = in.nextInt();
		int col = in.nextInt();
		AtomRay a = new AtomRay(row,col);
		System.out.println("Enter Number of Atoms:");
		int atoms = in.nextInt();
		int[][]  pos = new int[atoms][2];
		System.out.println("Enter position of atoms:");
		for(int i=0;i<atoms;i++){
			System.out.println("Enter position of atom "+(i+1)+" ");
			pos[i][0]=in.nextInt();
			pos[i][1]=in.nextInt(); 
		}
		a.insertAtoms(pos);
		System.out.println("Enter no of rays:");
		int no_rays = in.nextInt();
		String[]  rays = new String[no_rays];
		for(int i=0;i<no_rays;i++){
			System.out.println("Enter ray "+(i+1)+" ");
			rays[i]=in.next();
			a.insertRays(rays);
			a.checkHit();
			a.checkRefract();
			//a.checkReflection();
		}	
		a.display();	
	}
}