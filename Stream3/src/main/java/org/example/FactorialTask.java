package org.example;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {

    private long number;

    public FactorialTask(long number) {
        this.number = number;
    }

    @Override
    protected Long compute() {
        if (number <= 1) {
            return 1L;
        }
        else {
            FactorialTask factorialTask = new FactorialTask(number - 1);
            factorialTask.fork();
            return number * factorialTask.join();
        }
    }
}
