package com.rightkarma.javabasic.generics.rawtypes;

import java.util.List;

public class Erasure <T, B extends Comparable<B>> {

	public void unbounded (T param) {
		
	}
	public void lists(List<String> param, List<List<T>> param2) {
		String s = param.get(0);
	}
	public void bounded ( B param) {
		
	}
}

/*

note how generic info is erased in compiled code.
checkcast - to ensure that correct object is returned at runtime.

$ javap -s -c -classpath . in.purihim.javabasic.generics..rawtypes.Erasure
Compiled from "Erasure.java"
public class in.purihim.javabasic.generics..rawtypes.Erasure<T, B extends java.lang.Comparable<B>> {
  public in.purihim.javabasic.generics..rawtypes.Erasure();
    descriptor: ()V
    Code:
       0: aload_0
       1: invokespecial #8                  // Method java/lang/Object."<init>":()V
       4: return

  public void unbounded(T);
    descriptor: (Ljava/lang/Object;)V
    Code:
       0: return

  public void lists(java.util.List<java.lang.String>, java.util.List<java.util.List<T>>);
    descriptor: (Ljava/util/List;Ljava/util/List;)V
    Code:
       0: aload_1
       1: iconst_0
       2: invokeinterface #26,  2           // InterfaceMethod java/util/List.get:(I)Ljava/lang/Obje                  ct;
       7: checkcast     #32                 // class java/lang/String
      10: astore_3
      11: return

  public void bounded(B);
    descriptor: (Ljava/lang/Comparable;)V
    Code:
       0: return
}


$ javap -s -classpath . in.purihim.javabasic.generics..rawtypes.Erasure
Compiled from "Erasure.java"
public class in.purihim.javabasic.generics..rawtypes.Erasure<T, B extends java.lang.Comparable<B>> {
  public in.purihim.javabasic.generics..rawtypes.Erasure();
    descriptor: ()V

  public void unbounded(T);
    descriptor: (Ljava/lang/Object;)V

  public void lists(java.util.List<java.lang.String>, java.util.List<java.util.List<T>>);
    descriptor: (Ljava/util/List;Ljava/util/List;)V

  public void bounded(B);
    descriptor: (Ljava/lang/Comparable;)V
}




 */