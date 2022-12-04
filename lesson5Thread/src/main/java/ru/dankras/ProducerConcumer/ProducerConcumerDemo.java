package ru.dankras.ProducerConcumer;

public class ProducerConcumerDemo {
    public static void main(String[] args) throws InterruptedException {
        Box box=new Box();
        Producer producer=new Producer(box);
        Consumer consumer=new Consumer(box);
        Thread thread1=new Thread(() -> producer.produce());
        Thread thread2=new Thread(() -> consumer.consume());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("The end");

    }
}
