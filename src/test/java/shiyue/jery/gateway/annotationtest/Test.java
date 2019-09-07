package shiyue.jery.gateway.annotationtest;

/**
 * @author Jery
 * @date 2019/9/6
 */
public class Test {

    public static void main(String[] args) {
        Class clazz = AnnotationTest.class;
        if (clazz.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation myAnnotation = (MyAnnotation) clazz.getAnnotation(MyAnnotation.class);
            System.out.println(myAnnotation.name());
        }
    }
}
