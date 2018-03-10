```java
public class HelloWorld {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHi();
    }

    private void sayHi() {
        String str;
        str="Hi !!";
        System.out.println(str);
    }
}
```

**Compile**

    javac HelloWorld.java

**Run**

    java HelloWorld

**Decompile using -c**

    javap -c HelloWorld.class

**Decompile to  Show all classes and members using -p**

    javap -c -p HelloWorld.class

**With security policy**
add this to jvm parameters:

        -Djava.security.manager 
This will enforce policy based upon policy.  
If nothing is given, it will run with default policy.  
For example, running a program with above option will not let it write to files.

