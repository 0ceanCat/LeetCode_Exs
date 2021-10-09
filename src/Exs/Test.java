package Exs;

import others.A;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    static AtomicInteger f = new AtomicInteger(0);

    public static void main(String[] args) {
        new Thread(()-> {
            try {
                for (int i = 0; i < 10; i++) {
                    printA();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(()-> {
            try {
                for (int i = 0; i < 10; i++) {
                    printB();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

        new Thread(()-> {
            try {
                for (int i = 0; i < 10; i++) {
                    printC();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
    }

    static void printA() throws InterruptedException {
        while (f.get() != 0);
        System.out.print("A");
        f.set(1);
    }

    static void printB() throws InterruptedException {
        while (f.get() != 1);
        System.out.print("B");
        f.set(2);
    }


    static void printC() throws InterruptedException {
        while (f.get() != 2);
        System.out.print("C");
        f.set(0);
    }
}


