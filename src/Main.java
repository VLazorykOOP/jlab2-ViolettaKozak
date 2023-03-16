public class Main {

    public static void main(String[] args) {
        System.out.println("Java Lab 2 ");
        Time t1 = new Time();
        Time t2 = new Time((short) 34, (short) 15);
        Time t3 = new Time("16:34:25");

        t1.Print();
        t1.Plus((short) 568);
        t1.Print();

        t2.Print();
        t2.Minus((short) 1452);
        t2.Print();

        System.out.println("Різниця часу між t3 i t2 = "+t3.Difference(t2));

        Time t = new Time(t3.hour, t3.minute, t3.second);
        System.out.println("Чи рівні t3 i t : "+t.Equals(t3));

        System.out.println("t1 в секундах = "+t1.InSeconds());
        System.out.println("t2 в хвилинах = "+t2.InMinute());
    }
}
