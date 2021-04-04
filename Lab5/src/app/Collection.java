package app;

import data.Vehicle;
import data.VehicleComparator;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.PriorityQueue;

public class Collection {
    private PriorityQueue <Vehicle> vehiclePriorityQueue= new PriorityQueue<>();
    private Date creationDate;
    Collection (){
        this.vehiclePriorityQueue = new PriorityQueue();
        this.creationDate = new Date();
    }

    public PriorityQueue <Vehicle> getPriorityQueue() {
        return this.vehiclePriorityQueue;
    }


    public void printAscending(){

        Vehicle vehicle;
        ArrayList <Vehicle> tmpList = new ArrayList<>();
        tmpList.addAll(vehiclePriorityQueue);
        VehicleComparator comparator = new VehicleComparator();
        Collection.sort(tmpList,comparator);
        System.out.println(tmpList);
        System.out.println("я тута");
    }

    private static void sort(ArrayList<Vehicle> tmpList, VehicleComparator comparator) {
    }


    // XML Parser
        // Vehicle -> .xml
        // Then save BANANA_LAB5 using java.io.OutputStreamWriter

    public void Clear() {
    }
}
