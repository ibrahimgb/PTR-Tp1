package com.PTR;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

   /* public static void main(String[] args) {
	// write your code here
        ArrayList<Resource> resources = new ArrayList<Resource>();

        Thread thread = new Thread();
        thread.start();

    }*/


    //import java.util.LinkedList;
        static  LinkedList<Integer> list = new LinkedList<>();
        public static void main(String[] args)
                throws InterruptedException {

            // Object of a class that has both produce()
            // and consume() methods
           // LinkedList<Integer> list = new LinkedList<>();
            final Producer producer = new Producer(list);
            final Consumer consumer = new Consumer();


            // Create producer thread
            Thread firstThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        producer.produce();
                        System.out.println(list.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("Thread  interrupted.");
                    }
                }
            });

            // Create consumer thread
            Thread secendThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        consumer.consume(producer.list);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("Thread  interrupted.");
                    }
                }
            });

            // Start both threads
            System.out.println("starting the threds \n first thred:");

            firstThread.start();

            System.out.println("seqend thread: cunsumer");

            secendThread.start();

            System.out.println("-----");

            // t1 finishes before t2
          //  firstThread.join();
          //  secendThread.join();
        }
    }