
public class Trajectory {



private double lambda;

private double A;

private double B;

private double A0;

private double B0;

private double A1;

private double B1;


private double R;

private int time;

private double weight;




public Trajectory(double A, double B, double A0, double B0, double A1, double B1,  double R, int time,  double weight){
this.A = A;
this.B = B;
this.A0 = A0;
this.B0 = B0;
this.A1 = A1;
this.B1 = B1;
this.R = R;
this.time=time;
this.lambda = (B+(2*A0))-(A+(2*B0));
this.weight = weight; 

}



public double getA(){
return this.A;
}

public double getB(){

return this.B;
}




public double getA1(){
return this.A1;
}

public double getB1(){

return this.B1;
}




public double getA0(){
return this.A0;
}

public double getB0(){

return this.B0;
}





public double getR(){
return this.R;
}




public int getTime(){
return this.time;
}



public double getWeight(){

return this.weight;

}  


public void setA(double A){
this.A = A;
}

public void setB(double B){
this.B = B;
}


public void setA0(double A0){
this.A0 = A0;
}

public void setB0(double B0){
this.B0 = B0;
}

public void setA1(double A1){
this.A1 = A1;
}

public void setB1(double B1){
this.B1 = B1;
}



public void setR(double R){
this.R = R;
}

public void setLambda(){

this.lambda = (B+(2*A0))-(A+(2*B0)); 

}

public double getLambda(){
return this.lambda;
}

public void setWeight(double weight){

this.weight = weight; 

}

public void incrementTime(int time){
this.time+=time;

}




}
