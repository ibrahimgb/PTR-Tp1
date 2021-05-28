package com.PTR;

import java.util.ArrayList;
import java.util.LinkedList;

public class Consumer {

    public Consumer() {
    }

    // Function called by consumer thread
    public void consume(LinkedList<Integer> list) throws InterruptedException
    {

        while (true) {
            System.out.println("Function called by consumer thread");
            System.out.println("c:"+list);
            synchronized (list)
            {
                // consumer thread waits while list
                // is empty
                while (list.size() == 0)
                    System.out.println(list.size());
                    list.wait();


                // to retrive the ifrst job in the list
                int val = list.removeFirst();

                System.out.println("Consumer consumed-"
                        + val);

                // Wake up producer thread
                list.notify();

                // and sleep
                Thread.sleep(1000);
            }
        }
    }

    /*public Resource consume(ArrayList<Resource> resources){

        Resource r = resources.get(resources.size());
        resources.remove(resources.size());
        System.out.println("the resource :"+r+"have benne consumed");
        return r;
    }*/
}
