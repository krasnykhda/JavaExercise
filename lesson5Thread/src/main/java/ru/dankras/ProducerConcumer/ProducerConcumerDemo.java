package ru.dankras.ProducerConcumer;

public class ProducerConcumerDemo {
    public static void main(String[] args) throws InterruptedException {
        Box box=new Box();
        Producer producer=new Producer(box);
        Consumer consumer=new Consumer(box);
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                producer.produce();
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                consumer.consume();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("The end");

    }
}
