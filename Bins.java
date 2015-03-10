import java.util.*; 
import java.io.*;

public class Bins{

	private TreeCounter treecounter;
	private HashMap<keys,values> bins;
//	private HashMap<List<Integer>,List<Double>> ABbins;
	private int tmax;
	private int increment;
public Bins(TreeCounter treecounter){

	this.bins = new HashMap<keys,values>();// double[0] - H
							// double[1] - j
//        this.ABbins = new HashMap<List<Integer>,List<Double>>();

	this.increment =2;
	this.tmax = 502;


	for (int l = -200; l < 201; l+=1){
 		for (int t = 0; t<tmax; t+=increment){
	

		bins.put(new keys(l,t),new values(0.0,0.0));


	 }
	}

		this.treecounter = treecounter; 
	}



public double getJli(int l, int t){

	return bins.get(new keys(l,t)).getJ();

}

public synchronized void updateProbabilities(){

	double sum;
	double hli;

	for (int t = 0; t<tmax; t+=increment){
		sum = 0.0;
		
	for (int l = -200; l < 201; l+=1){
		hli = getHli(l,t);
		sum += hli;


	 }
	for (int la = -200; la<201; la+=1){
		hli = getHli(la,t);
		updateP(la,t,hli/sum);
		}
	}

}






public double getHli(int l, int t){

	return bins.get(new keys(l,t)).getH();

}

public synchronized double updateHJ(int l, int t, double w){

bins.get(new keys(l,t)).updateHJ(w,treecounter.getTreeCounter());

return bins.get(new keys(l,t)).getJ();

}

public synchronized void updateH(int l, int t,double w){

        bins.get(new keys(l,t)).updateH(w);

}


public void updateP(int l, int t, double p){

        bins.get(new keys(l,t)).updateP(p);

}

public double calculateChildNumber(int l, int t, double Jli, double weight){

	return weight / Jli;

}



public synchronized void printBins(String file) throws IOException{

FileWriter fstream;
BufferedWriter out;
fstream = new FileWriter(file);
out = new BufferedWriter(fstream);

int count = 0;

Iterator<Map.Entry<keys,values>> it = bins.entrySet().iterator();

while (it.hasNext()){
Map.Entry<keys,values> pairs = it.next();

out.write(pairs.getKey().x + "\t");
out.write(pairs.getKey().y + "\t");


out.write(pairs.getValue().getH() + "\t");
out.write(pairs.getValue().getP() + "\t");
//for (Double b : pairs.getValue()){
//out.write(""+String.format("%.5f" + "\t",pairs.getValue().getH() ));
//out.write(""+String.format("%.5f" + "\t",pairs.getValue().getJ() ));
//out.write(""+String.format("%.5f" + "\t",pairs.getValue().getP() ));
//}
out.write("\n");
count++;
}
out.close();
}




	}
