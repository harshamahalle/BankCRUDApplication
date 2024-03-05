package com.bank.demoApplication.RequestModel;

public class AddAmountModel {
    public long amount;

    public int id;

    public AddAmountModel(int id,long amount) {
        this.id=id;
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
