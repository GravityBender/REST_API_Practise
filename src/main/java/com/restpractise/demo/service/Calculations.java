package com.restpractise.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

public class Calculations {

    private final Set<Integer> set;
    private static final Logger log = LoggerFactory.getLogger(Calculations.class);
    public Calculations(){
        set = new HashSet<>();
    }

    public Calculations(Set<Integer> set){
        this.set = set;
    }

    public int calculate(int oldValue) {
        int n = oldValue;
        set.add(n);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        int sum = 0;
        while (oldValue > 0 || sum > 9) {
            if(oldValue == 0) {
                oldValue = sum;
                sum = 0;
            }
            sum += oldValue % 10;
            oldValue /= 10;
        }
        if(set.contains(n)){
            n += 10 - sum;
            while(set.contains(n))
                n += 9;
        }
        set.add(n);

        log.info("Current Storage: {}", set);
        return n;
    }

}
