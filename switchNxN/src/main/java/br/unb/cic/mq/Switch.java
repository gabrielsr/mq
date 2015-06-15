package br.unb.cic.mq;


public class Switch {

	public int inputPorts[];
	
	public int outputPorts[];
	
	int n;
	
	int m;
	
	public Switch (int n, int m){
		this.n = n;
		this.m = m;
		inputPorts = new int[n];
		outputPorts = new int[m];
	}
	
	
	public void route(int inputPort){
		inputPorts[inputPort] = inputPorts[inputPort] + 1;
		int outputPort = RamdomUtil.randInt(0,m-1);
		outputPorts[outputPort] = outputPorts[outputPort] + 1;
	}
	
	
}
