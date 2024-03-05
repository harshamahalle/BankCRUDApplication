package com.bank.demoApplication.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="account")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="amount")
    private long amount;

    public Account() {

    }
    public Account(String name, long amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
