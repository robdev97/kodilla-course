package com.kodilla.hibernate.invoice;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ITEMS")
public class Item {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    private BigDecimal price;
    private int quantity;
    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "INVOICE_ID", nullable = false)
    private Invoice invoice; // 🛠️ KLUCZOWE - relacja do faktury

    public Item() {}

    public Item(Product product, BigDecimal price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.value = price.multiply(BigDecimal.valueOf(quantity));
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public int getId() { return id; }

    public Product getProduct() {
        return product; }

    public BigDecimal getPrice() {
        return price; }

    public int getQuantity() {
        return quantity; }

    public BigDecimal getValue() {
        return value; }
}