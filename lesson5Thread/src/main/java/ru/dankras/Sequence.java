package ru.dankras;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Sequence {
    private static final Logger logger = LoggerFactory.getLogger(Sequence.class);
    private int nextThreadId = 0;
    private final int maxNumberOfThreads;
    private char[] symbols;
    private int count = 1;

    private void start() {
        for (int id = 0; id < maxNumberOfThreads; id++) {
            int curentId = id;
            new Thread(() -> action(curentId, 2)).start();
        }

    }

    public synchronized void action(int currentId, int maxCount) {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                while (nextThreadId != currentId) {
                    this.wait();
                }
                if (count > maxCount) {
                    logger.info("Before interrupt");
                    Thread.currentThread().interrupt();
                } else {
                    logger.info(String.valueOf(symbols[currentId]));
                }
                setNextThreadId();
                notifyAll();
                sleep();
                logger.info("after notify");


            } catch (InterruptedException ex) {
                logger.info("thread interrupt");
                setNextThreadId();
                notifyAll();

            }
        }
    }

    private void setNextThreadId() {
        if (nextThreadId >= 0) {
            nextThreadId++;
        }
        if (nextThreadId == maxNumberOfThreads) {
            nextThreadId = 0;
            count++;
        }
    }


    public Sequence(int maxNumberOfThreads) {
        char startSymbol = 'a';
        int ascii = (int) startSymbol;
        symbols = new char[maxNumberOfThreads];
        for (int i = 0; i < maxNumberOfThreads; i++) {
            symbols[i] = (char) ascii;
            ascii++;
        }
        this.maxNumberOfThreads = maxNumberOfThreads;
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(3);
        sequence.start();
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
