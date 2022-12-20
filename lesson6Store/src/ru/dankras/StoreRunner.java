package ru.dankras;

import ru.dankras.model.Cash;
import ru.dankras.model.Customer;
import ru.dankras.model.Store;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StoreRunner {
    private final Random random = new Random();
    private final int stepNumber;
    private final int stepTime;

    public StoreRunner(int stepNumber, int stepTime) {
        this.stepNumber = stepNumber;
        this.stepTime = stepTime;
    }

    public void start(Store store) {
        ExecutorService executorService = Executors.newFixedThreadPool(store.getCashes().size() + 1);
        executorService.submit(() -> {
            addCustomer(store);
        });
        sleep(500);
        for (Cash cash : store.getCashes()) {
            executorService.submit(() -> {
                getProduct(store, cash);
            });
            sleep(200);
        }
        executorService.shutdown();
    }

    public void addCustomer(Store store) {
        Customer customer = null;
        for (int i = 0; i < stepNumber; i++) {
            if (customer != null) {
                customer.setJustComeIn(false);
            }
            store.setCurrentStep(i);
            customer = store.addCustomer(random, false);
            System.out.println(store);
            sleep(stepTime);
        }
    }

    public void getProduct(Store store, Cash cash) {
        store.getProductFromCash(store, cash);
    }

    public static void main(String[] args) {
        Store store = new Store(4, 5, 10, new ArrayList<Cash>(), 2000);
        StoreRunner storeRunner = new StoreRunner(20, 2000);
        storeRunner.start(store);

    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
