package ru.dankras.ProducerConcumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.dankras.Sequence;

public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Sequence.class);
    private Box momitor;

    public Producer(Box momitor) {
        this.momitor = momitor;
    }

    public void produce() {
        synchronized (momitor) {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    while (!momitor.isFree()) {

                        momitor.wait();

                    }
                    momitor.setValue(momitor.getValue() + 1);
                    logger.info(String.valueOf(momitor.getValue()));
                    momitor.notifyAll();
                    if (momitor.getValue() == 20) {
                        throw new InterruptedException();
                    }
                    //Thread.sleep(1000);

                } catch (InterruptedException exception) {
                    logger.info("thread interrupt");
                    Thread.currentThread().interrupt();
                }

            }


        }

    }
}
