package ru.dankras.model;

import ru.dankras.CustomerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Store {
    private int currentStep;

    private final int stepTime;
    private final List<Cash> cashes;

    public List<Cash> getCashes() {
        return cashes;
    }

    public Store(int numberOfCashes, int maxCashSpeed, int maxNumberCustomer, int stepTime) {
        this.cashes=new ArrayList<>();
        this.stepTime = stepTime;
        inizialize(numberOfCashes, maxCashSpeed, maxNumberCustomer);
    }

    public int getSumCashSteps() {
        int sum = 0;
        for (Cash cash : cashes) {
            sum += cash.getCurrentStep();
        }
        return sum;
    }

    public int getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(int currentStep) {
        this.currentStep = currentStep;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Cash cash : cashes) {
            stringBuilder.append("\n Cash ");
            stringBuilder.append(cash.getId());
            stringBuilder.append(" speed: ");
            stringBuilder.append(cash.getSpeed());
            stringBuilder.append(" size: ");
            stringBuilder.append(cash.getBlockingQueue().size());
            stringBuilder.append(" number product: ");
            stringBuilder.append(cash.getNumberProduct());
            for (Customer customer : cash.getBlockingQueue()) {
                stringBuilder.append("\n    " + customer.getCustomerType());
                stringBuilder.append("_" + customer.getId());
                stringBuilder.append(" " + customer.getPurscheCount());
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private void inizialize(int numberOfCashes, int maxCashSpeed, int maxNumberCustomer) {
        Random random = new Random();
        for (int i = 0; i < numberOfCashes; i++) {
            cashes.add(new Cash(random.nextInt(maxCashSpeed) + 1, new ArrayBlockingQueue<Customer>(100), i));
        }
        int numberCustomer = random.nextInt(maxNumberCustomer) + 1;
        for (int i = 0; i < numberCustomer; i++) {
            addCustomer(true);
        }
    }

    public Customer addCustomer(boolean startInizialize) {
        Customer customer = CustomerFactory.getCustomer();
        var cash = customer.getCash(cashes);
        cash.addCustomer(customer);
        if (!startInizialize) {
            System.out.println("____________________________");
            System.out.println("\nstep " + currentStep);
            System.out.println("add Customer " + customer.getCustomerType() + " PursheCount:" + customer.getPurscheCount() + " to Cash " + cash.getId());
        }
        return customer;
    }

    public void getProductFromCash(Store store, Cash cash) {
        int speed = cash.getSpeed();
        try {
            while (cash.getCurrentStep() <= store.getCurrentStep() || cash.getNumberProduct() != 0) {
                int numberProduct = speed;
                while (numberProduct > 0 && !cash.getBlockingQueue().isEmpty()) {
                    Customer customer = cash.getBlockingQueue().element();
                    int purcheCount = customer.getPurscheCount();
                    int takeProduct = Math.min(numberProduct, purcheCount);
                    customer.setPurscheCount(purcheCount - takeProduct);
                    cash.setNumberProduct(cash.getNumberProduct() - takeProduct);
                    if (customer.getPurscheCount() == 0) {
                        cash.getBlockingQueue().take();
                    }
                    System.out.println(cash.parceToString(takeProduct, customer));
                    numberProduct = numberProduct - takeProduct;
                }
                cash.setCurrentStep(cash.getCurrentStep() + 1);
                sleep(stepTime);
            }

        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
