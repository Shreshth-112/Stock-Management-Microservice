package com.payment.Bill.Service;



import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.payment.Bill.Order.Order;

import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfService {
    public byte[] generateBillPdf(Order order) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(byteArrayOutputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("********** Bill **********"));
        document.add(new Paragraph("Order ID: " + order.getOrderId()));
        document.add(new Paragraph("Customer ID: " + order.getCustomerId()));
        document.add(new Paragraph("Product ID: " + order.getProductId()));
        document.add(new Paragraph("Product Quantity: " + order.getProductQuantity()));
        document.add(new Paragraph("Total Cost: $" + order.getTotalCost()));
        document.add(new Paragraph("*************************"));

        document.close();
        return byteArrayOutputStream.toByteArray();
    }
}
