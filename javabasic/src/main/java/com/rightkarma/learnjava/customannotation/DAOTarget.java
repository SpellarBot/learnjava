package com.rightkarma.learnjava.customannotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

import static com.rightkarma.learnjava.customannotation.DaoTargetType.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DAOTarget {
    DaoTargetType getDaoTarget() default DaoTargetType.ES;
}







