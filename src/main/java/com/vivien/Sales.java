package com.vivien;

import com.vivien.bean.Goods;

public class Sales {

    Goods goods;
    public Sales(String barcode) {
        this.goods = getGoodsByCode(barcode);
    }

    public static String printReceipt() {
        StringBuilder productsReceipt = new StringBuilder();
        productsReceipt.append("***<没钱赚商店>购物清单***\n");
        productsReceipt.append("名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n");
        productsReceipt.append("----------------------\n");
        productsReceipt.append("总计: 3.00(元)\n");
        productsReceipt.append("**********************");
        return productsReceipt.toString();
    }

    public Goods getGoodsByCode (String barcode) {
        return goods;
    }
}
