package com.test.test.model;

public class Invoice {

    private int InvoiceNumber;
    private String Description;
    private int Amount;
    private String Status;
    private String DateOfInvoice;

    public Invoice(int invoiceNumber, String description, int amount, String status, String dateOfInvoice) {
        InvoiceNumber = invoiceNumber;
        Description = description;
        Amount = amount;
        Status = status;
        DateOfInvoice = dateOfInvoice;
    }

    public Invoice() {

    }


    public int getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        InvoiceNumber = invoiceNumber;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDateOfInvoice() {
        return DateOfInvoice;
    }

    public void setDateOfInvoice(String dateOfInvoice) {
        DateOfInvoice = dateOfInvoice;
    }
}
