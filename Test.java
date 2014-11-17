public class Test
{

static int a;
int b;

public Test ()
{

int c;
c = a;
a++;
b += c;
System.out.println ("one");

}

public void Test ()
{

int c;
c = a;
a++;
b += c;
System.out.println ("two");

}

public static void main (String args[])
{

Test t = new Test ();

}
}