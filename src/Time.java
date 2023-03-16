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
        if (s>59 || s <0){
            while (s > 59){
                s -= 60;
                m += 1;
            }
            while (s<0){
                s += 60;
                m -= 1;
            }
        }
        if (m>59 || m <0){
            while (m > 59){
                m -= 60;
                h += 1;
            }
            while (m<0){
                m += 60;
                h -= 1;
            }
        }
        if (h > 23 || h < 0){
            while (h > 23){
                h -= 24;
            }
            while (h<0){
                h += 24;
            }
        }
        this.second = s;
        this.minute = m;
        this.hour = h;
    }
    public Time(@NotNull String str){
        String[] value = str.split(":");
        short h=0, m=0, s=0;
        if (value.length >= 2) {
            h = Short.parseShort(value[0]);
            m = Short.parseShort(value[1]);
            if (value.length == 3) {
                s = Short.parseShort(value[2]);
            }
        } else {
            System.out.println("Неповні дані");
        }
        if (s>59 || s <0){
            while (s > 59){
                s -= 60;
                m += 1;
            }
            while (s<0){
                s += 60;
                m -= 1;
            }
        }
        if (m>59 || m <0){
            while (m > 59){
                m -= 60;
                h += 1;
            }
            while (m<0){
                m += 60;
                h -= 1;
            }
        }
        if (h > 23 || h < 0){
            while (h > 23){
                h -= 24;
            }
            while (h<0){
                h += 24;
            }
        }
        this.second = s;
        this.minute = m;
        this.hour = h;
    }

    public short Difference(@NotNull Time another){
        short sec;
        sec = (short) ((this.hour - another.hour)*360 + (this.minute-another.minute)*60 + (this.second-another.second));
        return sec;
    }

    public Time Plus(short sec){
        short m=0, h=0;
        while (sec>59){
            sec -= 60;
            m += 1;
        }
        while (m > 59){
            m -= 60;
            h += 1;
        }
        while (h > 23){
            h -= 24;
        }
        this.second += sec;
        this.minute += m;
        this.hour += h;

        return this;
    }

    public Time Minus(short sec){
        short m=0, h=0;
        while (sec>59){
            sec -= 60;
            m += 1;
        }
        while (m > 59){
            m -= 60;
            h += 1;
        }
        while (h > 23){
            h -= 24;
        }
        this.second -= sec;
        while (this.second < 0){
            this.second += 60;
            this.minute -= 1;
        }
        this.minute -= m;
        while (this.minute < 0){
            this.minute += 60;
            this.hour -= 1;
        }
        if (this.hour < h){
            this.second = 0;
            this.minute = 0;
            this.hour = 0;
        }

        return this;
    }

    public boolean Equals(@NotNull Time another){
        if (this.hour != another.hour){
            return false;
        }
        if (this.minute != another.minute){
            return false;
        }
        if (this.second != another.second){
            return false;
        }

        return true;
    }

    public short InSeconds(){
        return (short) (this.hour*360 + this.minute*60 + this.second);
    }

    public short InMinute(){
        return (short) (this.hour*60 + this.minute);
    }

    public void Print(){
        System.out.println(this.hour+":"+this.minute+":"+this.second);
    }
}
