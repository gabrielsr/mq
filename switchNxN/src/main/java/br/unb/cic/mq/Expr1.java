package br.unb.cic.mq;

public class Expr1 {

	final static int N = 20;
	
	static int occurrences[];
	
	static int routed = 0;
	
	public static void main(String args[]){
		
		occurrences = new int[N];
		
		float problOfCome = 0.6f;
		
		//1000 timeslots
		for(int i = 0; i < 10000000; i++) {
			Switch swch = new Switch(N, N);
			simulateTimeSlot(swch, problOfCome, N);
			countnOutputTimesOccurrences(swch);
		}
		
		for(int j = 0; j< N; j++){
			System.out.print("routed in port" + j + ":");
			System.out.print(occurrences[j] );
			System.out.print(" probl:");
			System.out.println(  (float)occurrences[j]/(N*100000) );
		}
	}
	
	public static void simulateTimeSlot(Switch swch, float probl, int n){
		for(int i=0; i<n; i++){
			if(Math.random()< probl){
				swch.route(i);
			}
		}
	}
	
	public static void countnOutputTimesOccurrences(Switch swch){
		port:for(int i = 0; i < N; i++){
			for(int j=0; j<  N; j++){
				if(swch.outputPorts[i] == j){
					occurrences[j] = occurrences[j] + 1;
					continue port;
				}
			}
		}
	}
}
