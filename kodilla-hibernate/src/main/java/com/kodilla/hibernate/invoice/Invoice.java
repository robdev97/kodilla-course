package com.kodilla.hibernate.invoice;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INVOICES")
public class Invoice {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true, nullable = false)
    private String number;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> items = new ArrayList<>();

    public Invoice() {}

    public Invoice(String number) {
        this.number = number;
    }

    public void addItem(Item item) {
        items.add(item);
        item.setInvoice(this);
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public List<Item> getItems() {
        return items;
    }
}