package com.test.test.controller;

import com.test.test.model.Invoice;
import com.test.test.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;


    @GetMapping("/user/all")
    public List<Invoice> findAll() {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        return invoices;
    }

    @GetMapping("/user/byId/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable("id") Integer id) {
        Invoice invoice = invoiceService.getInvoiceById(id);
        return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
    }

    @PostMapping(path="/user/add")
    public  ResponseEntity<Invoice> addNewInvoice(@RequestBody Invoice inv) {
        Invoice invoice = invoiceService.addNewInvoice(inv);
        return new ResponseEntity<Invoice>( invoice,HttpStatus.OK);
    }

    @PutMapping(path = "/user/update")
    public ResponseEntity<Invoice> updateInvoice(@RequestBody Invoice invoice){
        invoiceService.updateInvoice(invoice);
        return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
    }

    @DeleteMapping(path="/admin/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        invoiceService.deleteInvoiceById(id);
        return new ResponseEntity<Void>( HttpStatus.NO_CONTENT);
    }

}
