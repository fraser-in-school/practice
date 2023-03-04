import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h1 = in.nextInt();
        int m1 = in.nextInt();

        int h2 = in.nextInt();
        int m2 = in.nextInt();

        int n = in.nextInt();
        List<Check> checkList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Check check = new Check();
            check.id = in.nextInt();
            check.length = in.nextInt();
            check.num = in.nextInt();

            check.init(h1, m1);
            check.check(h2, m2);
            if (check.flag) {
                checkList.add(check);
            }

        }
        checkList.sort((a, b) -> {
            if (a.check.minus != b.check.minus) {
                return a.check.minus -= b.check.minus;
            } else {
                if (a.price != b.price) {
                    return a.price -= b.price;
                } else {
                    return a.id -= b.id;
                }
            }
        });
        System.out.println(checkList.size());
        for (Check check : checkList) {
            System.out.println(check.id + " " + check.minus + " " + check.price);
        }
    }

    static class Check {
        int id;
        int length;
        int num;
        Time arrive;
        Time check;
        int minus;
        int price;

        boolean flag;

        Check() {
            this.flag = false;
        };

        void init(int h, int m) {
            int needMinus = this.length * 10;
            int temp = needMinus;


            this.arrive = new Time(h, m);
            while (temp > 0) {
                this.num = this.num >= 10 ? this.num - 10 : 0;

                if (this.arrive.h >= 8 && this.arrive.h < 10) {
                    this.num += 30;
                } else if (this.arrive.h >= 10 && this.arrive.h < 12) {
                    this.num += 2;
                } else if (this.arrive.h >= 12 && this.arrive.h < 14) {
                    this.num += 100;
                } else if (this.arrive.h >= 14 && this.arrive.h < 18) {
                    this.num += 2;
                } else if (this.arrive.h >= 18 && this.arrive.h < 20) {
                    this.num += 200;
                }
                temp -= 10;
                this.arrive.addMinus(10);


            }


            this.check = new Time(this.arrive.minus += this.num);
            this.minus = needMinus + this.num;
            this.price = needMinus;

        }

        void check(int h, int m) {
            Time end = new Time(h, m);
            if (this.check.minus <= end.minus) {
                this.flag = true;
            }
        }

    }

    static class Time {
        int h;
        int m;
        int minus;
        Time(int h, int m) {
            this.h = h;
            this.m = m;
            this.minus = this.h * 60 + this.m;
        }

        Time(int minus) {
            this.minus = minus;
            this.h = this.minus / 60;
            this.m = this.minus % 60;
        }

        void addMinus(int minus) {
            this.minus += minus;
            this.h = this.minus / 60;
            this.m = this.minus % 60;
        }
    }
}

/**
 * 10 30
 * 14 50
 * 3
 * 1 10 19
 * 2 8 20
 * 3 21 3
 */
