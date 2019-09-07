package shiyue.jery.gateway.annotationtest;

/**
 * @author Jery
 * @date 2019/9/6
 */
@MyAnnotation
public class AnnotationTest {
    private String id;

    public AnnotationTest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
