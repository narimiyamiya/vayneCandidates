package com.example.hunter.bean;

public class PagingBean {
    private int someLimit;
    private int offsetLimit;

    public int getSomeLimit() {
        return someLimit;
    }

    public void setSomeLimit(int someLimit) {
        this.someLimit = someLimit;
    }

    public int getOffsetLimit() {
        return offsetLimit;
    }

    public void setOffsetLimit(int offsetLimit) {
        this.offsetLimit = offsetLimit;
    }

    @Override
    public String toString() {
        return "PagingBean{" +
                "someLimit=" + someLimit +
                ", offsetLimit=" + offsetLimit +
                '}';
    }
}
