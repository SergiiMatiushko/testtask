package com.coingaming.service;

public class Results <K, V> {

    private final K results;
    private final V count;

    public Results (K results,V count){
        this.results=results;
        this.count=count;
    }

    public K getResults() {
        return results;
    }

    public V getCount() {
        return count;
    }
}
