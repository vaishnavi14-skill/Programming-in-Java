import java.util.Scanner;
abstract class Shape
{
int l=10;
int b=20;
int ra=10;
abstract void printArea();
}
class rectangle extends Shape
{
void printArea()
{
int r=l*b;
System.out.println("Area of the rectangle:"+r);
}
}
class triangle extends Shape
{
void printArea()
{
float t=(l*b)/2;
System.out.println("Area of the triangle:"+t);
}
}
class circle extends Shape
{
void printArea()
{
float c=3.14f*ra*ra;
System.out.println("Area of the circle:"+c);
}
}
class Area
{
public static void main(String[] args)
{
rectangle rec=new rectangle();
triangle tri=new triangle();
circle cir=new circle();
rec.printArea();
tri.printArea();
cir.printArea();
}
}





