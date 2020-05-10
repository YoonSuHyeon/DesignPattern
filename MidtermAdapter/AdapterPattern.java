package MidtermAdapter;

class Rect    {
    public double l;
    public double w;
}
class Triangle {
    public double b;
    public double h;
    public Triangle(int b, int h)    {
        this.b = b;
        this.h = h;
    }
}class  Calculator{
    Rect rectangle;
    public double getArea(Rect r){
        rectangle=r;
        return rectangle.l * rectangle.w;
    }
}
class CalculatorAdapter{
    Calculator calculator;
    Triangle triangle;
    public double getArea(Triangle t){
        calculator = new Calculator();
        triangle=t;
        Rect r = new Rect();

        r.l = triangle.b;
        r.w = 0.5 * triangle.h;
        return calculator.getArea(r);
    }
}


public class AdapterPattern {
    public static void main(String[] args){
        System.out.println("***Adapter Pattern Demo***");
        CalculatorAdapter cal=new CalculatorAdapter();
        Triangle t = new Triangle(20,10);
        System.out.println("\nAdapter Pattern Example\n");
        System.out.println("Area of Triangle is :" + cal.getArea(t));
    }
}
