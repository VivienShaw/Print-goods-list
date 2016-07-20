package com.vivien;

import com.vivien.bean.Goods;

import java.text.DecimalFormat;

public class Sales {

    Goods goods;
    public Sales(String barcode) {
        this.goods = getGoodsByCode(barcode);
    }

    public String printReceipt() {
        StringBuilder productsReceipt = new StringBuilder();
        productsReceipt.append("***<没钱赚商店>购物清单***\n");
        productsReceipt.append("名称："+goods.getName()
                +"，数量：1"+goods.getUnit()+
                "，单价："+ numberFormat(goods.getPrice())
                +"(元)，小计："+numberFormat(goods.getPrice() * 1)+"(元)\n");
        productsReceipt.append("----------------------\n");
        productsReceipt.append("总计: "+numberFormat(goods.getPrice() * 1)+"(元)\n");
        productsReceipt.append("**********************");
        return productsReceipt.toString();
    }

    public Goods getGoodsByCode (String barcode) {
        if (barcode.equals("ITEM000001")) {
            return defaultGoods();

        } else if (barcode.equals("ITEM000000")) {
            Goods goods = defaultGoods();
            goods.setName("雪碧");
            int discountType = 1;
            return goods;
        }
        return null;
    }

    static String numberFormat (double num) {
        DecimalFormat df = new DecimalFormat( "0.00");
        return df.format(num);
    }

    private Goods defaultGoods() {
        Goods goods = new Goods();
        goods.setName("可乐");
        goods.setUnit("瓶");
        goods.setPrice(3);
        return goods;
    }
}
