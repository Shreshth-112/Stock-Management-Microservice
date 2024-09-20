package com.payment.Bill.Order;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class PrintUtil {
    public static void printPdf(byte[] pdfBytes) throws PrintException {
        InputStream inputStream = new ByteArrayInputStream(pdfBytes);
        Doc pdfDoc = new SimpleDoc(inputStream, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
        PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob printJob = printService.createPrintJob();
        printJob.print(pdfDoc, new HashPrintRequestAttributeSet());
    }
}
