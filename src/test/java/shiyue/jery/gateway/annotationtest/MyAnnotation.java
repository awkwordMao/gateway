package shiyue.jery.gateway.annotationtest;

import java.lang.annotation.*;

/**
 * @author Jery
 * @date 2019/9/6
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String name() default "myAnnotation";
}
