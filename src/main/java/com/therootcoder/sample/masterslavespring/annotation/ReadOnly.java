package com.therootcoder.sample.masterslavespring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * It is used to declare the repository for read-only( data fetch queries only) operations.
 * One must not declare/use DML methods in repository annotated with @ReadOnly
 *
 * @author Harpreet Sandhu
 * @since 22-Mar-2019
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ReadOnly {
}