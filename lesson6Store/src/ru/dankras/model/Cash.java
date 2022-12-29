package ru.dankras.model;

import java.util.concurrent.BlockingQueue;

public class Cash {
    private final int speed;
    private final int id;
    private int numberProduct;
    private int currentStep;
    private final BlockingQueue<Customer> blockingQueue;

    public int getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(int currentStep) {
        this.currentStep = currentStep;
    }


    public int getSpeed() {
        return speed;
    }

    public void setNumberProduct(int numberProduct) {
        this.numberProduct = numberProduct;
    }

    public int getId() {
        return id;
    }

    public void addCustomer(Customer customer) {
        blockingQueue.add(customer);
        setNumberProduct(getNumberProduct() + customer.getPurscheCount());
    }

    public int getNumberProduct() {
        return numberProduct;
    }

    public BlockingQueue<Customer> getBlockingQueue() {
        return blockingQueue;
    }

    public Cash(int speed, BlockingQueue blockingQueue, int id) {
        this.id = id;
        this.speed = speed;
        this.blockingQueue = blockingQueue;
    }


    public String parceToString(int takeProduct, Customer customer) {
        return Thread.currentThread().getName() + ";Step:" + getCurrentStep() +
                ";Queue size:" + getBlockingQueue().size()
                + ";Processing  " + customer.getCustomerType() + "_" + customer.getId() +
                ";Get " + takeProduct +
                " products from cash " + getId();
    }

}
