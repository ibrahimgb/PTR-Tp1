package com.PTR;

import java.util.ArrayList;
import java.util.LinkedList;

public class Producer {
    public Producer() {

    }


    public Producer(LinkedList<Integer> list) {
        this.list = list;
    }

    // Create a list shared by producer and consumer
    // Size of list is 2.
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 5;

    // Function called by producer thread
    public void produce() throws InterruptedException
    {
        int value = 0;
        while (true) {
            synchronized (list)
            {
                // producer thread waits while list
                // is full
                while (list.size() == capacity)
                    list.wait();

                System.out.println("Producer produced-"
                        + value);

                // to insert the jobs in the list
                list.add(value++);

                // notifies the consumer thread that
                // now it can start consuming
                System.out.println("p:"+list);
                list.notify();

                // makes the working of program easier
                // to understand
                //Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException
    {
        while (true) {
            synchronized (list)
            {
                // consumer thread waits while list
                // is empty
                while (list.size() == 0)
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

}
