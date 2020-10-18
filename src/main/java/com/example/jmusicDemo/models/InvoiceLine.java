package com.example.jmusicDemo.models;

public class InvoiceLine {

    private int InvoiceItemId;
    private int InvoiceId;
    private int TrackId;
    private double UnitPrice;
    private int Quantity;

    // Constructor

    public InvoiceLine(int invoiceItemId, int invoiceId, int trackId, double unitPrice, int quantity) {
        InvoiceItemId = invoiceItemId;
        InvoiceId = invoiceId;
        TrackId = trackId;
        UnitPrice = unitPrice;
        Quantity = quantity;
    }


    // Getters and setters


    public int getInvoiceItemId() { return InvoiceItemId; }

    public void setInvoiceItemId(int invoiceItemId) { InvoiceItemId = invoiceItemId; }

    public int getInvoiceId() { return InvoiceId; }

    public void setInvoiceId(int invoiceId) { InvoiceId = invoiceId; }

    public int getTrackId() { return TrackId; }

    public void setTrackId(int trackId) { TrackId = trackId; }

    public double getUnitPrice() { return UnitPrice; }

    public void setUnitPrice(double unitPrice) { UnitPrice = unitPrice; }

    public int getQuantity() { return Quantity; }

    public void setQuantity(int quantity) { Quantity = quantity; }
}
