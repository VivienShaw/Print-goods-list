package com.vivien;

import com.vivien.bean.Goods;
import com.vivien.model.Cart;
import com.vivien.model.CartItem;
import com.vivien.repository.GoodsRepo;
import com.vivien.utils.Utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Sales {

    Cart cart = new Cart();
    GoodsRepo repo = new GoodsRepo();

    Goods goods;
    public Sales(String... barcodes) {
        for (String barcode : barcodes) {
            goods = getGoodsByCode(barcode);
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
        if (goods.getDiscountType() == 1) {
            productsReceipt.append("买二赠一商品：\n");
            productsReceipt.append("名称："+goods.getName()+"，数量："+1+"袋 \n");
            productsReceipt.append("----------------------\n");
        }
        productsReceipt.append("总计: "+ cart.getTotalPrice()+"(元)\n");
        productsReceipt.append("**********************");
        return productsReceipt.toString();
    }

    public Goods getGoodsByCode (String barcode) {
        for (Map.Entry<String,Goods> goodsEntry : repo.getAllGoods().entrySet()) {
            if (goodsEntry.getKey().equals(barcode)) {
                if (barcode.equals("ITEM000003")) {
                    goodsEntry.getValue().setDiscountType(1);
                }
                return goodsEntry.getValue();
            }
        }
        return null;
    }
}
