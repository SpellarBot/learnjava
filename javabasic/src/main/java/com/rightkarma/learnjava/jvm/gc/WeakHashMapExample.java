package com.rightkarma.learnjava.jvm.gc;

import java.util.Date;
import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * LearningNote
 * Experiment. put a key-value in a WeakHashMap and a HashMap.
 * Now point key to null.
 * See if the value is removed from the map ?
 */
public class WeakHashMapExample {
    public static void main(String[] args) {
        HashMap<Long, Animal> hashMap = new HashMap<>();
        WeakHashMap<Long, Animal> weakHashMap = new WeakHashMap<>();

        Animal animal1 = new Animal(); // strong reference
        Animal animal2 = new Animal(); // strong reference
        hashMap.put(animal1.getId(),animal1 );
        weakHashMap.put(animal2.getId(), animal2);


        System.out.println("--------nullify the keys---------");
        animal1.setId(null);
        animal2.setId(null);
        System.out.println("--------check the maps---------");
        System.out.println("hashMap:"+hashMap.containsValue(animal1));
        System.out.println("weakHashMap:"+weakHashMap.containsValue(animal2));
        System.out.println("--------sun sysmte.gc and check the maps---------");
        System.gc();// sleep to ensure that GC has run
        try { Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
        System.out.println("hashMap:"+hashMap.containsValue(animal1));
        System.out.println("weakHashMap:"+weakHashMap.containsValue(animal2));
        System.out.println("--------print the objects---------");
        System.out.println(animal1);
        System.out.println(animal2);
    }
}

final class Animal {
    Long id = Long.valueOf(new Date().hashCode());
    Date date = new Date();
    public long getId() { return id;}
    public void setId(Long id) {  this.id = id; }
    public String toString() {return "Animal{" +"id=" + id +", date=" + date +'}';
    }
}
/*
LearningNote - A WeakHashMap removes the entry if key is nullified.

OUTPUT

--------nullify the keys---------
--------check the maps---------
hashMap:true
weakHashMap:true
--------sun sysmte.gc and check the maps---------
hashMap:true
weakHashMap:false
--------print the objects---------
Animal{id=null, date=Sat Mar 10 17:56:46 IST 2018}
Animal{id=null, date=Sat Mar 10 17:56:46 IST 2018}

*/
