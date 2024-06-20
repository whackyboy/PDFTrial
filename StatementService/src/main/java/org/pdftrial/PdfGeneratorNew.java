package org.pdftrial;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PdfGeneratorNew {
    public void generateStatement(List<org.pdftrial.TransactionDTO> transactions, String filePath) {
        Document document = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            String bankName = "MyBank";
            String accountHolder = "Vikas";
            String accountNumber = "1234567890";


            Paragraph bankDetails = new Paragraph(bankName, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
            bankDetails.setAlignment(Element.ALIGN_CENTER);
            document.add(bankDetails);


            Paragraph accountInfo = new Paragraph("Account Holder: " + accountHolder + " - Account Number: " + accountNumber, FontFactory.getFont(FontFactory.HELVETICA, 10));
            document.add(accountInfo);


            PdfPTable transactionTable = new PdfPTable(5); // 5 columns
            transactionTable.addCell(new Phrase("Date", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
            transactionTable.addCell(new Phrase("Description", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
            transactionTable.addCell(new Phrase("Debit (AED)", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
            transactionTable.addCell(new Phrase("Credit (AED)", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
            transactionTable.addCell(new Phrase("Balance (AED)", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));


            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            transactionTable.addCell(new Phrase(dateFormat.format(new Date()), FontFactory.getFont(FontFactory.HELVETICA, 10)));
            transactionTable.addCell(new Phrase("Salary Deposit", FontFactory.getFont(FontFactory.HELVETICA, 10)));
            transactionTable.addCell(new Phrase("5000.00", FontFactory.getFont(FontFactory.HELVETICA, 10)));
            transactionTable.addCell(new Phrase("-", FontFactory.getFont(FontFactory.HELVETICA, 10)));
            transactionTable.addCell(new Phrase("5000.00", FontFactory.getFont(FontFactory.HELVETICA, 10)));

            transactionTable.addCell(new Phrase(dateFormat.format(new Date()), FontFactory.getFont(FontFactory.HELVETICA, 10)));
            transactionTable.addCell(new Phrase("Grocery Store Purchase", FontFactory.getFont(FontFactory.HELVETICA, 10)));
            transactionTable.addCell(new Phrase("-", FontFactory.getFont(FontFactory.HELVETICA, 10)));
            transactionTable.addCell(new Phrase("200.00", FontFactory.getFont(FontFactory.HELVETICA, 10)));
            transactionTable.addCell(new Phrase("4800.00", FontFactory.getFont(FontFactory.HELVETICA, 10)));


            document.add(transactionTable);

            document.close();
        }
        catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}