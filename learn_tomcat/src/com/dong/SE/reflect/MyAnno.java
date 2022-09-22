package com.dong.SE.reflect;

import java.lang.annotation.*;

/**
 * @author dfx
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String className();
    String methodName();
}
