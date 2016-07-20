package com.vivien;

public class Main {
    public static void main(String[] args) {
        String[] barcodes = new String[]{"ITEM000001","ITEM000001","ITEM000001","ITEM000001",
                "ITEM000003-3","ITEM000005","ITEM000005","ITEM000005"};
        Sales sales = new Sales(barcodes);
        System.out.print(sales.printReceipt());
    }
}
