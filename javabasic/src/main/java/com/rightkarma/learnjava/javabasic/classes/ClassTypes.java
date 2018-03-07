package com.rightkarma.learnjava.javabasic.classes;

/**
 * LearningNote
 * Refer - https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
 */
public class ClassTypes {

    /**
     * LearningNote
     *
     * following method would use MemberClass and AnnonymousClass
     */
    public void someMethod() {
        // member class
        class MemberClass {

        }
        // LearningNote instantiate MemberClass
        MemberClass memberClass = new MemberClass();
        // LearningNote anonymous class
        InterfaceForAnnonymousclass annonymousclass = new InterfaceForAnnonymousclass() {
            // LearningNote class definition
        };
    }


    /**
     * Terminology: Nested classes are divided into two categories: static and non-static.
     * Nested classes that are declared static are called static nested classes.
     * Non-static nested classes are called inner classes.
     *
     * example of inner class i.e. Non-static nested class
     */
    public class innerClass {
        // class body
        public innerClass() {
            System.out.println("innerClass const.");
        }
    }

    /**
     * example of static inner class i.e. static nested class
     */
    public static class StaticNestedClass {
        public StaticNestedClass() {
            System.out.println("StaticNestedClass const.");
        }

        public String sayHi() {
            return "Hi";
        }
    }


}

/**
 * example of package protected
 */
class PackageProtected {

}

interface InterfaceForAnnonymousclass {

}


class ClassToCallOtherClasses{
    private void callStaticClasses(){
        // LearningNote - local inner class needs outer class object. then you call object.new innerClass()
        ClassTypes.innerClass innerClass = new ClassTypes().new innerClass();
        // LearningNote - Static classes can be accessed like anything static i.e className.staticName
        // LearningNote - Static classes are seldom used as they can't access non-static members
        ClassTypes.StaticNestedClass staticNestedClass = new ClassTypes.StaticNestedClass();
    }

}