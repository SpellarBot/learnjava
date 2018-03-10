/*
 * run this program with different run configurations.
 * -XX:+UseConcMarkSweepGC ( put in VM options ie. these options are for JVM to consider, not your pgm )
 * */
package com.rightkarma.learnjava.jvm.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

// LearningNote - Run this class to see details of the GC

public class SeeGCDetails {

    public static void main(String[] args) {
        List<GarbageCollectorMXBean> beans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean bean : beans) {
            System.out.println("Name: " + bean.getName());
            System.out.println("Number of Collections: " + bean.getCollectionCount());
            System.out.println("Collection time: " + bean.getCollectionTime() + "ms");
            System.out.println("Pool names: ");
            for (String name : bean.getMemoryPoolNames()) {
                System.out.println("\tpool name: " + name);
            }
        }
    }
}
/*

OUTPUT
		Name: PS Scavenge
		Number of Collections: 0
		Collection time: 0ms
		Pool names:
			pool name: PS Eden Space
			pool name: PS Survivor Space
		Name: PS MarkSweep
		Number of Collections: 0
		Collection time: 0ms
		Pool names:
			pool name: PS Eden Space
			pool name: PS Survivor Space
			pool name: PS Old Gen

		Process finished with exit code 0
*/
