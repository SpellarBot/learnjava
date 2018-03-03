/*
 * run this program with different run configurations.
 * -XX:+UseConcMarkSweepGC ( put in VM options ie. these options are for JVM to consider, not your pgm )
 * */
package com.rightkarma.learnjava.jvm.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class SeeGCDetails {

	public static void main(String[] args) {
		List<GarbageCollectorMXBean> beans = ManagementFactory.getGarbageCollectorMXBeans();
		for(GarbageCollectorMXBean bean: beans){
			System.out.println("Name: "+bean.getName());
			System.out.println("Number of Collections: "+bean.getCollectionCount());
			System.out.println("Collection time: "+bean.getCollectionTime()+"ms");
			System.out.println("Pool names: ");
			for(String name : bean.getMemoryPoolNames()){
				System.out.println("\tpool name: "+name);
			}
		}
	}
}
