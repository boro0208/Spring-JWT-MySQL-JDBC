package com.test.test.dao;

import com.test.test.model.Invoice;

import java.util.List;

public interface InvoiceDao {

    List<Invoice> findAll();
    Invoice findById(int id);
    void addInvoice(Invoice invoice);
    void deleteById(int id);
    void editInvoice(Invoice invoice);

}
