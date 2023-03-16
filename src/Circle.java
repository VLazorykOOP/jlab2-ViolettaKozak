public class Circle {
    private double radius;
    private double centerX;
    private double centerY;

    public Circle(){
        this(15.8, 6.4, 1.9);
    }
    public Circle(double radius, double centerX, double centerY) {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public double getCircumference() {
        return Math.round((2 * Math.PI * radius)*100.0)/100.0;
    }

    public double getArea() {
        return Math.round((Math.PI * Math.pow(radius, 2))*100.0)/100.0;
    }

    public boolean containsPoint(double x, double y) {
        return Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2) <= Math.pow(radius, 2);
    }

    public int getIntersectionPoints(Circle otherCircle) {
        double distanceBetweenCenters = Math.sqrt(Math.pow(centerX - otherCircle.centerX, 2) + Math.pow(centerY - otherCircle.centerY, 2));
        double sumOfRadii = radius + otherCircle.radius;
        double differenceOfRadii = Math.abs(radius - otherCircle.radius);

        if (distanceBetweenCenters > sumOfRadii) {
            System.out.println("Кола не перетинаються");
            return 0;
        } else if (distanceBetweenCenters < differenceOfRadii) {
            System.out.println("Одне коло знаходиться в середині іншого");
            return 0;
        } else if (distanceBetweenCenters == 0 && radius == otherCircle.radius) {
            System.out.println("Кола однакові і накладені один на одне");
            return -1;
        } else {
            System.out.println("Кола перетинаються у 2 точках");
            return 2;
        }
    }
}
