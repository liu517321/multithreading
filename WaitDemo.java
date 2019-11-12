import java.util.Scanner;

public class WaitDemo {
    private static Object object = new Object();

    public static class A extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
            // 等待 B 线程启动，并完成某个条件
            synchronized (object) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 100; i < 110; i++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Thread a = new A();
        a.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("我不输入，A 线程就绝对不会动");
        scanner.nextLine();
        synchronized (object) {
            object.notify();
        }
    }
}

