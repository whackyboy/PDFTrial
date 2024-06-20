package org.pdftrial;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class PdfGenerator {
    public void generateStatement(List<org.pdftrial.TransactionDTO> transactions, String filePath) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            document.add(new Paragraph("Account Statement"));
            document.add(new Paragraph(" "));

            for (org.pdftrial.TransactionDTO transaction : transactions) {
                Paragraph p = new Paragraph(
                        transaction.getDate() + " - " +
                                transaction.getDescription() + " - " +
                                transaction.getAmount()
                );
                document.add(p);
            }

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
