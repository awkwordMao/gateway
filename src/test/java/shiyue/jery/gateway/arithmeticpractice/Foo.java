package shiyue.jery.gateway.arithmeticpractice;

/**
 * @author Jery
 * @date 2019/7/15
 */
public class Foo {

    private String id;

    @Override
    public String toString() {
        return "Foo{" +
                "id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (this) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

abstract class Uiio {

}