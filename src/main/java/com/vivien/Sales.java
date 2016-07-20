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

    Cart cart;
    GoodsRepo repo = GoodsRepo.getInstance();
    Goods goods;


    public Sales(String... codes) {
        cart = new Cart();

        putGoodsToCart(parseBarcode(codes));
    }

    public String printReceipt() {
        StringBuilder productsReceipt = new StringBuilder();
        productsReceipt.append("***<没钱赚商店>购物清单***\n");
        productsReceipt.append(cart.getCartItemString());
        productsReceipt.append("----------------------\n");
        productsReceipt.append(cart.getBuyTwoFreeOneList());
        productsReceipt.append(cart.getTotalPrice());
        return productsReceipt.toString();
    }


    public void putGoodsToCart(String... codes) {
        for (String barcode : codes) {
            goods = repo.getGoodsByCode(barcode);
            if (cart.isContainGoods(goods)) {
                cart.getItemByGoods(goods).increaseNumber();
                cart.judgeSale(cart.getItemByGoods(goods));
                continue;
            }

            CartItem item = new CartItem();
            item.setGoods(goods);
            item.setNumber(1);
            cart.addItem(item);
            cart.judgeSale(item);
        }
    }

    public String[] parseBarcode(String... barcodes) {
        StringBuilder str = new StringBuilder();
        for (String barcode : barcodes) {
            if (barcode.contains("-")) {
                int k = Integer.parseInt(barcode.split("-")[1]);
                for (int i = 0;i<k;i++) {
                    str.append(barcode.split("-")[0]+" ");
                }
                continue;
            }

            str.append(barcode+" ");
        }
        return str.toString().trim().split(" ");
    }
}
