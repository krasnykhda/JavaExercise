package ru.dankras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Calculator {
    private int countThread;
    public Calculator(ExecutorService executorService,int countThread) {
        this.executorService = executorService;
        this.countThread=countThread;
    }
    private long task(int[] elements,int first,int last){
        long sum=0l;
        for(int i=first;i<=last;i++){
            sum+=elements[i];
        }
        return sum;

    }
    public long getSumElemens(int[] elements) throws ExecutionException, InterruptedException {
        int interval=elements.length/countThread;
        int firstIndex=0;
        int lastindex=0;
        List<Future<Long>> futureList=new ArrayList<>();
        while (firstIndex<elements.length){
            if(firstIndex+interval<elements.length){
                lastindex=firstIndex+interval;
            }else {
                lastindex=elements.length-1;
            }
            int finalFirstIndex = firstIndex;
            int finalLastIndex = lastindex;
            futureList.add(executorService.submit(()->task(elements, finalFirstIndex, finalLastIndex)));
            firstIndex=firstIndex+interval+1;
        }
        long sum=0;
        executorService.shutdown();
        for(Future<Long> future:futureList){
            sum+=future.get();
        }

        return sum;
    }

    private ExecutorService executorService;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random random=new Random();
        int countThread=2;
        Calculator calculator=new Calculator(Executors.newFixedThreadPool(countThread),countThread);

        int size=10000000;
        int[] elements=new int[size];
        for(int i=0;i<size;i++){
            elements[i]=random.nextInt(100);
        }
        var t1=System.currentTimeMillis();
        System.out.println(calculator.getSumElemens(elements));
        var t2=System.currentTimeMillis();
        System.out.println(t2-t1);


         countThread=1;
         calculator=new Calculator(Executors.newFixedThreadPool(countThread),countThread);
        t1=System.currentTimeMillis();

        System.out.println(calculator.getSumElemens(elements));
        t2=System.currentTimeMillis();
        System.out.println(t2-t1);
    }
}
