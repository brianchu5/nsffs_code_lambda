import java.io.*;

public class simrunner{

private parNSFFS nsffs;


public simrunner(parNSFFS nsffs){

this.nsffs = nsffs; 

}



public static void main(String args[]){


long tStart = System.currentTimeMillis();
TrajectoryThreadPool ttp = new TrajectoryThreadPool();

simrunner sr = new simrunner(ttp.getNSFFS());



for (int i = 0; i<200; i++){
System.out.println(" new run starting **************  " + i );
try{
ttp.execute();
sr.nsffs.getBins().updateProbabilities();
sr.nsffs.getBins2().updateProbabilities();
        sr.nsffs.getBins().printBins("smap.txt");
	sr.nsffs.getBins2().printBins("map.txt");




}catch(Exception e){
/**/
}
System.out.println("  run ending --------------  " + i );

}

long tEnd = System.currentTimeMillis();
long tDelta = tEnd - tStart;
double elapsedMinutes = tDelta / 60000.0;
System.out.println(elapsedMinutes);
}
}
