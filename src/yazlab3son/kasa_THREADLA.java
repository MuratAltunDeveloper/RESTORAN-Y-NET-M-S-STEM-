package yazlab3son;

import java.util.ArrayList;

public class kasa_THREADLA {


    public static ArrayList<Thread> kasa_Threads = new ArrayList<>();
    public static ArrayList<kasaRunnable> kasaRunnables = new ArrayList<>();


    public static void kasa_threaduret() {

        kasaRunnable ara = new kasaRunnable();
        kasaRunnables.add(ara);

        Thread t2 = new Thread(ara);
        t2.start();
        kasa_Threads.add(t2);

    }


    public static void main(String[] args) {

        System.out.println("KASA THREADLA main");
        kasa_threaduret();
        System.out.println(kasa_Threads);

    }

}
