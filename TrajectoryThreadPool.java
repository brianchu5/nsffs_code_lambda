import java.util.*;
import java.util.concurrent.*;
import java.io.*;



public class TrajectoryThreadPool {

private Trajectory root;


private parNSFFS nsffs;

private    double RStart;
private    int RBegin;
private    int  timeinterval;
private    int stoptime;


public TrajectoryThreadPool(){
this.RStart = 2000.0;
this.RBegin = 100;
this.timeinterval = 2;
this.stoptime = 500 ;
this.nsffs = new parNSFFS(timeinterval,stoptime,RStart,RBegin);



}

public parNSFFS getNSFFS(){
return this.nsffs;
}
public void execute() throws InterruptedException {





double A =60.0;
double A0= 0.0;
double A1 = 1.0;
double B = 0.0;
double B0 = 1.0;
double B1 = 0.0;
double R = 0.0;
int time = 0;
double weight =1.0;
Trajectory root = new Trajectory(A,B,A0,B0,A1,B1,R,time,weight);
        nsffs.initialTreeCreation(root);
while (!nsffs.getstack().isEmpty()){


Trajectory t1 = nsffs.stackpop();
Runnable tr1 = new TrajectoryThread(this.nsffs,t1);
Thread thread1 = new Thread(tr1);
thread1.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t2 = nsffs.stackpop();
Runnable tr2 = new TrajectoryThread(this.nsffs,t2);
Thread thread2 = new Thread(tr2);
thread2.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t3 = nsffs.stackpop();
Runnable tr3 = new TrajectoryThread(this.nsffs,t3);
Thread thread3 = new Thread(tr3);
thread3.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t4 = nsffs.stackpop();
Runnable tr4 = new TrajectoryThread(this.nsffs,t4);
Thread thread4 = new Thread(tr4);
thread4.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t5 = nsffs.stackpop();
Runnable tr5 = new TrajectoryThread(this.nsffs,t5);
Thread thread5 = new Thread(tr5);
thread5.start();



if (!nsffs.getstack().isEmpty()){
Trajectory t6 = nsffs.stackpop();
Runnable tr6 = new TrajectoryThread(this.nsffs,t6);
Thread thread6 = new Thread(tr6);
thread6.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t7 = nsffs.stackpop();
Runnable tr7 = new TrajectoryThread(this.nsffs,t7);
Thread thread7 = new Thread(tr7);
thread7.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t8 = nsffs.stackpop();
Runnable tr8 = new TrajectoryThread(this.nsffs,t8);
Thread thread8 = new Thread(tr8);
thread8.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t9 = nsffs.stackpop();
Runnable tr9 = new TrajectoryThread(this.nsffs,t9);
Thread thread9 = new Thread(tr9);
thread9.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t10 = nsffs.stackpop();
Runnable tr10 = new TrajectoryThread(this.nsffs,t10);
Thread thread10 = new Thread(tr10);
thread10.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t11 = nsffs.stackpop();
Runnable tr11 = new TrajectoryThread(this.nsffs,t11);
Thread thread11 = new Thread(tr11);
thread11.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t12 = nsffs.stackpop();
Runnable tr12 = new TrajectoryThread(this.nsffs,t12);
Thread thread12 = new Thread(tr12);
thread12.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t13 = nsffs.stackpop();
Runnable tr13 = new TrajectoryThread(this.nsffs,t13);
Thread thread13 = new Thread(tr13);
thread13.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t14 = nsffs.stackpop();
Runnable tr14 = new TrajectoryThread(this.nsffs,t14);
Thread thread14 = new Thread(tr14);
thread14.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t15 = nsffs.stackpop();
Runnable tr15 = new TrajectoryThread(this.nsffs,t15);
Thread thread15 = new Thread(tr15);
thread15.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t16 = nsffs.stackpop();
Runnable tr16 = new TrajectoryThread(this.nsffs,t16);
Thread thread16 = new Thread(tr16);
thread16.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t17 = nsffs.stackpop();
Runnable tr17 = new TrajectoryThread(this.nsffs,t17);
Thread thread17 = new Thread(tr17);
thread17.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t18 = nsffs.stackpop();
Runnable tr18 = new TrajectoryThread(this.nsffs,t18);
Thread thread18 = new Thread(tr18);
thread18.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t19 = nsffs.stackpop();
Runnable tr19 = new TrajectoryThread(this.nsffs,t19);
Thread thread19 = new Thread(tr19);
thread19.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t20 = nsffs.stackpop();
Runnable tr20 = new TrajectoryThread(this.nsffs,t20);
Thread thread20 = new Thread(tr20);
thread20.start();



if (!nsffs.getstack().isEmpty()){
Trajectory t21 = nsffs.stackpop();
Runnable tr21 = new TrajectoryThread(this.nsffs,t21);
Thread thread21 = new Thread(tr21);
thread21.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t22 = nsffs.stackpop();
Runnable tr22 = new TrajectoryThread(this.nsffs,t22);
Thread thread22 = new Thread(tr22);
thread22.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t23 = nsffs.stackpop();
Runnable tr23 = new TrajectoryThread(this.nsffs,t23);
Thread thread23 = new Thread(tr23);
thread23.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t24 = nsffs.stackpop();
Runnable tr24 = new TrajectoryThread(this.nsffs,t24);
Thread thread24 = new Thread(tr24);
thread24.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t25 = nsffs.stackpop();
Runnable tr25 = new TrajectoryThread(this.nsffs,t25);
Thread thread25 = new Thread(tr25);
thread25.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t26 = nsffs.stackpop();
Runnable tr26 = new TrajectoryThread(this.nsffs,t26);
Thread thread26 = new Thread(tr26);
thread26.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t27 = nsffs.stackpop();
Runnable tr27 = new TrajectoryThread(this.nsffs,t27);
Thread thread27 = new Thread(tr27);
thread27.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t28 = nsffs.stackpop();
Runnable tr28 = new TrajectoryThread(this.nsffs,t28);
Thread thread28 = new Thread(tr28);
thread28.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t29 = nsffs.stackpop();
Runnable tr29 = new TrajectoryThread(this.nsffs,t29);
Thread thread29 = new Thread(tr29);
thread29.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t30 = nsffs.stackpop();
Runnable tr30 = new TrajectoryThread(this.nsffs,t30);
Thread thread30 = new Thread(tr30);
thread30.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t31 = nsffs.stackpop();
Runnable tr31 = new TrajectoryThread(this.nsffs,t31);
Thread thread31 = new Thread(tr31);
thread31.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t32 = nsffs.stackpop();
Runnable tr32 = new TrajectoryThread(this.nsffs,t32);
Thread thread32 = new Thread(tr32);
thread32.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t33 = nsffs.stackpop();
Runnable tr33 = new TrajectoryThread(this.nsffs,t33);
Thread thread33 = new Thread(tr33);
thread33.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t34 = nsffs.stackpop();
Runnable tr34 = new TrajectoryThread(this.nsffs,t34);
Thread thread34 = new Thread(tr34);
thread34.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t35 = nsffs.stackpop();
Runnable tr35 = new TrajectoryThread(this.nsffs,t35);
Thread thread35 = new Thread(tr35);
thread35.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t36 = nsffs.stackpop();
Runnable tr36 = new TrajectoryThread(this.nsffs,t36);
Thread thread36 = new Thread(tr36);
thread36.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t37 = nsffs.stackpop();
Runnable tr37 = new TrajectoryThread(this.nsffs,t37);
Thread thread37 = new Thread(tr37);
thread37.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t38 = nsffs.stackpop();
Runnable tr38 = new TrajectoryThread(this.nsffs,t38);
Thread thread38 = new Thread(tr38);
thread38.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t39 = nsffs.stackpop();
Runnable tr39 = new TrajectoryThread(this.nsffs,t39);
Thread thread39 = new Thread(tr39);
thread39.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t40 = nsffs.stackpop();
Runnable tr40 = new TrajectoryThread(this.nsffs,t40);
Thread thread40 = new Thread(tr40);
thread40.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t41 = nsffs.stackpop();
Runnable tr41 = new TrajectoryThread(this.nsffs,t41);
Thread thread41 = new Thread(tr41);
thread41.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t42 = nsffs.stackpop();
Runnable tr42 = new TrajectoryThread(this.nsffs,t42);
Thread thread42 = new Thread(tr42);
thread42.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t43 = nsffs.stackpop();
Runnable tr43 = new TrajectoryThread(this.nsffs,t43);
Thread thread43 = new Thread(tr43);
thread43.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t44 = nsffs.stackpop();
Runnable tr44 = new TrajectoryThread(this.nsffs,t44);
Thread thread44 = new Thread(tr44);
thread44.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t45 = nsffs.stackpop();
Runnable tr45 = new TrajectoryThread(this.nsffs,t45);
Thread thread45 = new Thread(tr45);
thread45.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t46 = nsffs.stackpop();
Runnable tr46 = new TrajectoryThread(this.nsffs,t46);
Thread thread46 = new Thread(tr46);
thread46.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t47 = nsffs.stackpop();
Runnable tr47 = new TrajectoryThread(this.nsffs,t47);
Thread thread47 = new Thread(tr47);
thread47.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t48 = nsffs.stackpop();
Runnable tr48 = new TrajectoryThread(this.nsffs,t48);
Thread thread48 = new Thread(tr48);
thread48.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t49 = nsffs.stackpop();
Runnable tr49 = new TrajectoryThread(this.nsffs,t49);
Thread thread49 = new Thread(tr49);
thread49.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t50 = nsffs.stackpop();
Runnable tr50 = new TrajectoryThread(this.nsffs,t50);
Thread thread50 = new Thread(tr50);
thread50.start();
/*
if (!nsffs.getstack().isEmpty()){
Trajectory t51 = nsffs.stackpop();
Runnable tr51 = new TrajectoryThread(this.nsffs,t51);
Thread thread51 = new Thread(tr51);
thread51.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t52 = nsffs.stackpop();
Runnable tr52 = new TrajectoryThread(this.nsffs,t52);
Thread thread52 = new Thread(tr52);
thread52.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t53= nsffs.stackpop();
Runnable tr53 = new TrajectoryThread(this.nsffs,t53);
Thread thread53 = new Thread(tr53);
thread53.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t54 = nsffs.stackpop();
Runnable tr54 = new TrajectoryThread(this.nsffs,t54);
Thread thread54 = new Thread(tr54);
thread54.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t55 = nsffs.stackpop();
Runnable tr55 = new TrajectoryThread(this.nsffs,t55);
Thread thread55 = new Thread(tr55);
thread55.start();


if (!nsffs.getstack().isEmpty()){
Trajectory t56 = nsffs.stackpop();
Runnable tr56 = new TrajectoryThread(this.nsffs,t56);
Thread thread56 = new Thread(tr56);
thread56.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t57 = nsffs.stackpop();
Runnable tr57 = new TrajectoryThread(this.nsffs,t57);
Thread thread57 = new Thread(tr57);
thread57.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t58 = nsffs.stackpop();
Runnable tr58 = new TrajectoryThread(this.nsffs,t58);
Thread thread58 = new Thread(tr58);
thread58.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t59 = nsffs.stackpop();
Runnable tr59 = new TrajectoryThread(this.nsffs,t59);
Thread thread59 = new Thread(tr59);
thread59.start();

if (!nsffs.getstack().isEmpty()){
Trajectory t60= nsffs.stackpop();
Runnable tr60 = new TrajectoryThread(this.nsffs,t60);
Thread thread60 = new Thread(tr60);
thread60.start();








thread60.join();
}
thread59.join();
}
thread58.join();
}
thread57.join();
}
thread56.join();
}
thread55.join();
}
thread54.join();
}
thread53.join();
}
thread52.join();
}
thread51.join();
}*/
thread50.join();
}
thread49.join();
}
thread48.join();
}
thread47.join();
}
thread46.join();
}
thread45.join();
}
thread44.join();
}
thread43.join();
}
thread42.join();
}
thread41.join();
}
thread40.join();
}
thread39.join();
}
thread38.join();
}
thread37.join();
}
thread36.join();
}
thread35.join();
}
thread34.join();
}
thread33.join();
}
thread32.join();
}
thread31.join();
}
thread30.join();
}
thread29.join();
}
thread28.join();
}
thread27.join();
}
thread26.join();
}
thread25.join();
}
thread24.join();
}
thread23.join();
}
thread22.join();
}
thread21.join();
}
thread20.join();
}
thread19.join();
}
thread18.join();
}
thread17.join();
}
thread16.join();
}
thread15.join();
}
thread14.join();
}
thread13.join();
}
thread12.join();
}
thread11.join();
}
thread10.join();
}
thread9.join();
}
thread8.join();
}
thread7.join();
}
thread6.join();
}
thread5.join();
}
thread4.join();
}
thread3.join();
}

thread2.join();
}

thread1.join();
}

}



public static void main (String args[]){
TrajectoryThreadPool ttp = new TrajectoryThreadPool();
try{
ttp.execute();
} catch(Exception e){
e.printStackTrace();
}

}


}




