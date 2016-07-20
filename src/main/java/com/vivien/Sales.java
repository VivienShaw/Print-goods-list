package com.vivien;

import com.vivien.bean.Goods;
import com.vivien.model.Cart;
import com.vivien.model.CartItem;
import com.vivien.utils.Utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Sales {

    Cart cart = new Cart();
//    Goods goods;
    public Sales(String... barcodes) {
        for (String barcode : barcodes) {
            Goods goods = getGoodsByCode(barcode);
            if (!cart.isContainGoods(goods)) {
                CartItem item = new CartItem();
                item.setGoods(goods);
                item.setNumber(1);
                cart.addItem(item);
            }else {
                cart.getItemByGoods(goods).addNumber();
            }
        }

    }

    public String printReceipt() {
        StringBuilder productsReceipt = new StringBuilder();
        productsReceipt.append("***<没钱赚商店>购物清单***\n");
        for (CartItem item : cart.getCart()) {
            productsReceipt.append(item.printItemList());
        }
        productsReceipt.append("----------------------\n");
        productsReceipt.append("总计: "+ cart.getTotalPrice()+"(元)\n");
        productsReceipt.append("**********************");
        return productsReceipt.toString();
    }

    public Goods getGoodsByCode (String barcode) {
        if (barcode.equals("ITEM000001")) {
            return defaultGoods();
        } else if (barcode.equals("ITEM000000")) {
            Goods goods = defaultGoods();
            goods.setBarcode("ITEM000000");
            goods.setName("雪碧");
            return goods;
        }else if (barcode.equals("ITEM000002")) {
            Goods goods = defaultGoods();
            goods.setBarcode("ITEM000002");
            goods.setName("橙汁");
            goods.setPrice(4);
            return goods;
        }
        return null;
    }

    private Goods defaultGoods() {
        Goods goods = new Goods();
        goods.setBarcode("ITEM000001");
        goods.setName("可乐");
        goods.setUnit("瓶");
        goods.setPrice(3);
        goods.setCategory("饮料");
        return goods;
    }
}
