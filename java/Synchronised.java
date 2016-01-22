class SOP {
    public static void print(String s)
    {
        System.out.println(s+"\n");
    }
}

class TestThread extends Thread
{
    String name;
    Synchronised synchronised;
    public TestThread(String name,Synchronised synchronised)
    {
        this.synchronised = synchronised;
        this.name = name;
        start();
    }

    @Override
    public void run()
    {
        synchronised.test(name);
    }
}

public class Synchronised {
    public synchronized void test(String name)
    {
        for(int i=0;i<10;i++)
        {
            SOP.print(name + " :: "+i);
            try{
                Thread.sleep(500);
            }
            catch (Exception e)
            {
                SOP.print(e.getMessage());
            }
        }
    }

    public static void main(String[] args)
    {
        Synchronised synchronised = new Synchronised();
        new TestThread("THREAD 1",synchronised);
        new TestThread("THREAD 2",synchronised);
        new TestThread("THREAD 3",synchronised);
    }
}