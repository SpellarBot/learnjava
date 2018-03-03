
/*
 * static binding is a compile time operation while dynamic binding is a runtime. 
 * one uses Type and other uses Object to bind. 
 * static, private and final methods and variables are resolved using static binding 
 * which makes there execution fast because no time is wasted to find correct method during runtime.
 * */

package com.rightkarma.javabasic.binding;

public class DynBinding {

    public static void main(String args[]) {
         Vehicle vehicle = new Car(); //here Type is vehicle but object will be Car
        vehicle.start();       //Car's start called because start() is overridden method
    }
}
 
class Vehicle {
 
    public void start(){
        System.out.println("Inside start method of Vehicle");
    }
 }

class Car extends Vehicle {
 
    @Override
    public void start(){
        System.out.println("Inside start method of Car");
     }
}
 
