package ru.dankras.ProducerConcumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.dankras.Sequence;

public class Consumer {
    private Box momitor;
    private static final Logger logger = LoggerFactory.getLogger(Sequence.class);

    public Consumer(Box momitor) {
        this.momitor = momitor;
    }

    public void consume() {
        synchronized (momitor) {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    while (momitor.isFree()) {
                        momitor.wait();
                    }
                    logger.info(String.valueOf(momitor.getValueAndFree()));
                    momitor.notifyAll();
                    if (momitor.getValue() == 20) {
                        Thread.currentThread().interrupt();
                    }
                    Thread.sleep(500);
                } catch (InterruptedException exception) {
                    logger.info("thread interrupt");
                    Thread.currentThread().interrupt();
                }


            }
        }
    }
}
