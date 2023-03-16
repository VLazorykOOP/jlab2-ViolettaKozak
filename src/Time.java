import org.jetbrains.annotations.NotNull;

public class Time {
    short hour;
    short minute;
    short second;

    public Time() {
        this((short) 0, (short) 1, (short) 25);
    }
    public Time(short h){
        this(h, (short) 1, (short) 25);
    }

    public Time(short h, short m){
        this(h, m, (short) 25);
    }

    public Time(short h, short m, short s){
        char ho = 'y', mi = 'y', se = 'y';
        if (h>23 || h <0){
            ho = 'n';
        }
        if (m>59 || m <0){
            mi = 'n';
        }
        if (s>59 || s <0){
            se = 'n';
        }
        switch (ho){
            case 'y': this.hour = h;
            case 'n': this.hour = 0;
        }
        switch (mi){
            case 'y': this.minute = m;
            case 'n': this.minute = 0;
        }
        switch (se){
            case 'y': this.second = s;
            case 'n': this.second = 0;
        }
    }
    public Time(@NotNull String str){
        String[] value = str.split(":");
        if (value.length >= 2) {
            this.hour = Short.parseShort(value[0]);
            this.minute = Short.parseShort(value[1]);
            if (value.length == 3) {
                this.second = Short.parseShort(value[2]);
            }
        } else {
            System.out.println("Неповні дані");
            this.hour = 0;
            this.minute = 0;
            this.second = 0;
        }
    }
}
