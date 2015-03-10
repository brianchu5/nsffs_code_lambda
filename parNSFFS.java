import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.*;
import java.util.ArrayDeque;
import java.util.Deque;


public class parNSFFS{


  private Bins bins2; 

  private Deque<Trajectory> stack;

  private Bins bins;

  private TreeCounter treecounter;

  private double wmin;

  private double wmax;


  private int timeinterval;


  private int stopTime;


  private double startingR;

  private int RTime;





   


public parNSFFS(int timeinterval, int stopTime, double startingR, int RTime){

   this.stack = new ArrayDeque<Trajectory>();
   this.treecounter = new TreeCounter();
   this.wmax = 1.0;
   this.wmin = 0.0;
   this.timeinterval = timeinterval;
   this.stopTime = stopTime;
   this.bins = new Bins(treecounter);
   this.bins2 = new Bins(treecounter);
   this.startingR = startingR;
   this.RTime = RTime;
}



public Deque getstack(){
return this.stack;
}

public synchronized void stackpush(Trajectory t){

this.stack.add(t);

}


public synchronized Trajectory stackpop(){

return this.stack.remove();

}


public double getStopTime(){
return this.stopTime;
}



public double  updateProperties(double lambda, int time, double incomingweight )
{


	this.bins2.updateH((int)lambda,time,incomingweight);



	return this.bins.updateHJ(lambinning((int)lambda),time,incomingweight);





}


public void initialTreeCreation(Trajectory root) {
   treecounter.incrementTreeCounter();
   double lambda = root.getLambda();
   double incomingweight = root.getWeight();
   double A = root.getA();
   double B = root.getB();
   double A0 = root.getA0();
   double B0 = root.getB0();
   double A1 = root.getA1();
   double B1 = root.getB1();
   double R = root.getR();
   int time =root.getTime();
   this.updateProperties(lambda,time,incomingweight);
   stackpush(root);
}



public int lambinning(int l){


if (l<=-120){

return -120;



}

else if (l>=120){

return 120;

}


else {


return l;

}


}


/*public int lambinning(int l){
    if (l<=-60){

        return -70;

    }

	else if (l>-60 && l<-50)
	{
	
		return -60;
	}


	else if (l>-50 && l<-40)
        {

                return -50;
        }


	else if (l >=-40 && l<-35 ){


        return -40;

        }


	else if (l >=-35 && l<-30 ){


        return -30;

        }


	else if (l >=-30 && l<-25 ){


        return -30;

        }


	else if (l >=-25 && l<-20 ){


        return -25;

        }


	else if (l >=-20 && l<-15 ){


        return -5;

        }


	else if (l >=-15 && l<-15 ){


        return -5;

        }



	else if (l >=-5 && l<5 ){


        return 0;

        }


	else if (l >=5 && l<10 ){


        return 10;

        }


	else if (l >=10 && l<20 ){


        return 20;

        }


	else if (l >=20 && l<30 ){


        return 20;

        }


	else if (l >=30 && l<40 ){


        return 30;

        }


	else if (l >=40 && l<50 ){


        return 40;

        }

	else if (l >=50 && l<60 ){


        return 50;

        }

	
	

        else{


        return 70;

        }
	





}*/


public boolean WeightIsWithinRange(Trajectory tr){

   if (tr.getWeight() >= wmin && tr.getWeight() <= wmax) {
      return true;
      } else{
               return false;

      }
   }

public double calculateMaxChild(double n){

double floorF = Math.floor(n);
double ceilingC = Math.ceil(n);
double probC = 1.0;
if (Math.floor(n) == n)
{
return n;

}else
{
probC = n - Math.floor(n);
}


if (Math.random() < probC)
{

return ceilingC;


}else{


return floorF;

}




}






public void Branching(Trajectory tr) {
    if(tr.getTime()< stopTime){
if(tr.getTime() == RTime){
        tr.setR(startingR);
    }
   

simulateForward(tr);

	
    double A = tr.getA();     // perform updates 
    double B = tr.getB();   
    double R = tr.getR();    
    double A0 = tr.getA0();
    double B0 = tr.getB0();
    double A1 = tr.getA1();
    double B1 = tr.getB1(); 
    int time = tr.getTime();
    double lambda = tr.getLambda();
    double incomingweight = tr.getWeight();
    double n;
    double jli = this.updateProperties(lambda,time,incomingweight);

    if (WeightIsWithinRange(tr)){   // create children
	n = bins.calculateChildNumber(lambinning((int)lambda),time,jli,incomingweight);
        int nchildren = (int) calculateMaxChild(n);
        for (int i=0; i<nchildren; i++){
            
            Trajectory t = new Trajectory(A,B,A0,B0,A1,B1,R,time,jli);
	    this.stackpush(t);
    }
}
 else {
        Trajectory t = new Trajectory(A, B,A0,B0,A1,B1,R,time,incomingweight);
	this.stackpush(t);
    } 

  }

}


public void simulateForward(Trajectory tr) {

    double A = tr.getA();
    double B = tr.getB();
    double A0 = tr.getA0();
    double B0 = tr.getB0();
    double R = tr.getR();
    double A1 = tr.getA1();
    double B1 = tr.getB1();
    int time = tr.getTime();
    SimulationManager sm = new SimulationManager();
    double[] data = sm.simulateModel(A,A0,A1,B,B0,B1,R,timeinterval);
    double lambda;

    tr.incrementTime(timeinterval);
    tr.setA(data[0]);
    tr.setA0(data[1]);
    tr.setA1(data[2]);
    tr.setB(data[3]);
    tr.setB0(data[4]);
    tr.setB1(data[5]);
    tr.setR(data[6]);
    tr.setLambda();
  //  tr.setHistory();

}

public Bins getBins(){
return this.bins;
}

public Bins getBins2(){
return this.bins2;
}

}

