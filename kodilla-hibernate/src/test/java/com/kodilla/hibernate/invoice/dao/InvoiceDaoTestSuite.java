package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ItemDao itemDao;

    @Test
    void testInvoiceDaoSave() {
        // Given
        Product product1 = new Product("Laptop");
        Product product2 = new Product("Smartphone");

        productDao.save(product1);
        productDao.save(product2);

        Item item1 = new Item(product1, new BigDecimal("3000.00"), 1);
        Item item2 = new Item(product2, new BigDecimal("2000.00"), 2);

        Invoice invoice = new Invoice("FV-2025/001");

        invoice.addItem(item1);
        invoice.addItem(item2);

        // When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        // Then
        assertNotEquals(0, id);

        // CleanUp
        invoiceDao.deleteById(id);
    }
}