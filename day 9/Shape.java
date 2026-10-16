public class Shape {
    public void area(){
        System.out.println("I am a shape");
    }
}

class Circle extends Shape{
    int r;
    public Circle(int r){
        this.r=r;
    }
    public void area(){
        System.out.println("Area of circle: "+3.14*r*r);
    }
}

class Rectangle extends Shape{
    int l;
    int b=0;
    public Rectangle(int l,int b){
        this.l=l;
        this.b=b;
    }
    public void area(){
        System.out.println("Area of rectangle: "+l*b);
    }
}

class Triangle extends Shape{
    int h;
    int b;
    public Triangle(int h,int b){
        this.h=h;
        this.b=b;
    }
    public void area(){
        System.out.println("Triangle area: "+0.5*h*b);
    }
}

class Main{
    public static void main(String[] args) {
        Shape obj=new Circle(4);
        obj.area();
    }
}