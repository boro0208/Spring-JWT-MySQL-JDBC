package com.test.test.service;

import com.test.test.model.Invoice;

import java.util.List;

public interface InvoiceServiceInterface {

    Invoice getInvoiceById(int id);
    List<Invoice> getAllInvoices();
    Invoice addNewInvoice(Invoice invoice);
    void deleteInvoiceById(int id);
    void updateInvoice(Invoice inv);
}
