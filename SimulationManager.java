import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import fern.network.fernml.FernMLNetwork;
import fern.network.Network;
import fern.simulation.Simulator;
import fern.simulation.algorithm.GibsonBruckSimulator;
import fern.simulation.observer.IntervalObserver;
import fern.simulation.observer.AmountIntervalObserver;
import fern.simulation.observer.AmountAtMomentObserver;
import java.util.*;
import fern.network.*;
import fern.simulation.algorithm.GillespieEnhanced;
import fern.simulation.algorithm.HybridMaximalTimeStep;



public class SimulationManager {


Network net;

Simulator sim;


public SimulationManager(){
try{
this.net = new FernMLNetwork(new File("gs.xml"));
} catch(Exception e){
e.printStackTrace();
}
this.sim = new GillespieEnhanced(net);

}


public double[] simulateModel(double a, double a0 ,double a1, double b, double b0, double b1,  double r,int time){


IntervalObserver obs = (IntervalObserver) this.sim.addObserver(new AmountIntervalObserver(this.sim,time,"A","A0","A1","B","B0","B1","R"));
this.sim.getNet().setInitialAmount(0,(int) a);
this.sim.getNet().setInitialAmount(1,(int) a0);
this.sim.getNet().setInitialAmount(2, (int) a1);
this.sim.getNet().setInitialAmount(3,(int) b);
this.sim.getNet().setInitialAmount(4, (int) b0);
this.sim.getNet().setInitialAmount(5, (int) b1);
this.sim.getNet().setInitialAmount(6, (int) r);
this.sim.start(time);

double[] finalvalues ={obs.getFinalValue(0),obs.getFinalValue(1),obs.getFinalValue(2),obs.getFinalValue(3),obs.getFinalValue(4),obs.getFinalValue(5), obs.getFinalValue(6)};

return finalvalues;

}








public static void main(String args[]) {
double[] data;
long startTime = System.currentTimeMillis();
SimulationManager sm = new SimulationManager();
data = sm.simulateModel(100.0,0.0,1.0,0.0,1.0,0.0,0.0,2);

for (double d : data){


System.out.println(d);



}






long endTime = System.currentTimeMillis();
System.out.println("That took " + (endTime - startTime) + " milliseconds");

long startTime1 = System.currentTimeMillis();
SimulationManager sm2 = new SimulationManager();
data = sm2.simulateModel(5.0,1.0,0.0,0.0,1.0,0.0,0.0,2);


for (double d : data){


System.out.println(d);



}




long endTime1 = System.currentTimeMillis();



System.out.println("That took " + (endTime1 - startTime1) + " milliseconds");
for (int i = 0; i<1000; i++){

long startTime2 = System.currentTimeMillis();
SimulationManager sm1 = new SimulationManager();
data = sm1.simulateModel(5.0,1.0,0.0,0.0,1.0,0.0,0.0,2);






long endTime2 = System.currentTimeMillis();



System.out.println("That took " + (endTime2 - startTime2) + " milliseconds");

}

















}
}
