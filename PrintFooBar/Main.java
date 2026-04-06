package PrintFooBar;

import java.util.concurrent.locks.Lock;

class FooBar{
    private Object lock=new Object();
    private boolean foo=true;
    void foo()
    {
        for(int i=1;i<=3;i++)
        {
            synchronized (lock)
            {
                while(!foo)
                {
                    try{
                        lock.wait();
                    }
                    catch (InterruptedException e)
                    {
                        return;
                    }
                }
                System.out.println("Foo");
                foo=false;
                lock.notifyAll();

            }
        }
    }

    void bar()
    {
        for(int i=1;i<=3;i++)
        {
            synchronized (lock)
            {
                while(foo)
                {
                    try{
                        lock.wait();
                    }
                    catch (InterruptedException e)
                    {
                        return;
                    }
                }
                System.out.println("Bar");
                foo=true;
                lock.notifyAll();

            }
        }
    }

}
public class Main {
    public static void main(String[] args) {
        FooBar fooBar=new FooBar();
        Thread t1=new Thread(fooBar::foo);
        Thread t2=new Thread(fooBar::bar);
        t1.start();
        t2.start();
    }
}
