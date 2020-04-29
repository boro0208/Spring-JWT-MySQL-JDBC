package com.test.test.service;

import com.test.test.dao.JdbcInvoiceDao;
import com.test.test.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService implements com.test.test.service.InvoiceServiceInterface {
    @Autowired
    private JdbcInvoiceDao invoiceDAO;

    @Override
    public Invoice getInvoiceById(int id) {
        Invoice invoice = invoiceDAO.findById(id);
        return invoice;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = invoiceDAO.findAll();
        return invoices;
    }

    @Override
    public Invoice addNewInvoice(Invoice inv) {
        invoiceDAO.addInvoice(inv);
        return inv;
    }

    @Override
    public void deleteInvoiceById(int id) {
        invoiceDAO.deleteById(id);
    }

    @Override
    public void updateInvoice(Invoice inv) {
        invoiceDAO.editInvoice(inv);
    }
}
