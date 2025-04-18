package itma;

import itma.trigon.Cos;
import itma.trigon.Sin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println((-Math.PI*2+Math.PI/3)% Math.PI);
        Cos cos = new Cos();
        Sin sin = new Sin(cos);
        System.out.println(cos.cos(-2*Math.PI+Math.PI/3));
        System.out.println(sin.sin(Math.PI*2+Math.PI/3));
        System.out.println( "Hello World!" );
    }
}
