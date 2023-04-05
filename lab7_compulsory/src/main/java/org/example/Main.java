package org.example;
public class Main{
    public static void main(String[] args) {

        Exploration exploration = new Exploration(10, 5);
        exploration.startExploration();


        try {
           
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        exploration.stopExploration();
    }

}