package org.pdftrial;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<TransactionDTO> transactions = List.of(
                new TransactionDTO("2021-01-01", "Salary", 1000),
                new TransactionDTO("2021-01-02", "Rent", -500),
                new TransactionDTO("2021-01-03", "Groceries", -100),
                new TransactionDTO("2021-01-04", "Dinner", -50)
        );
        PdfGenerator pdfGenerator = new PdfGenerator();
        pdfGenerator.generateStatement(transactions, "C:\\Users\\ADCB\\GitRepo\\StatementService\\output\\account-statement.pdf");


        PdfGeneratorNew pdfGeneratorNew = new PdfGeneratorNew();
        pdfGeneratorNew.generateStatement(transactions, "C:\\Users\\ADCB\\GitRepo\\StatementService\\output\\account-statementnew.pdf");
        }
}



