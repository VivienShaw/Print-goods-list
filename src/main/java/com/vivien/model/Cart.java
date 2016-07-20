package com.vivien.model;

import com.vivien.bean.Goods;

import java.util.ArrayList;
import java.util.List;
import com.vivien.utils.Utils;

public class Cart {

    private List<CartItem> cart;
    private boolean isSale;
    private boolean isSale_BTFO;



    public Cart () {
        cart = new ArrayList<CartItem>();
        isSale = false;
        isSale_BTFO = false;
    }

    public void addItem(CartItem item) {
        cart.add(item);

    }

    public void judgeSale(CartItem item) {
        if (!isSale) {
            setSale(item);
        }

        if (!isSale_BTFO) {
            setSale_BTFO(item);
        }
    }

    public CartItem getItemByGoods(Goods goods) {
        for (CartItem item : cart) {
            if (item.getGoods().equals(goods)) {
                return item;
            }
        }
        return null;
    }

    public void setSale(CartItem item) {
        if (item.getGoods().getDiscountType() == 2 || item.getGoods().getDiscountType() == 3) {
            isSale =  true;
            return;
        }

        if (item.getGoods().getDiscountType() == 1 && item.getNumber() >2 ) {
            isSale =  true;
            return;
        }
    }

    public void setSale_BTFO(CartItem item) {
        if ((item.getGoods().getDiscountType() == 1 || item.getGoods().getDiscountType() == 3)
                && item.getNumber() >2 ) {
            isSale_BTFO = true;
        }
    }

    public boolean isContainGoods(Goods goods) {
        for (CartItem cartItem : cart) {
            if (cartItem.getGoods() != null && cartItem.getGoods().equals(goods))
                return true;
        }
        return false;
    }

    public String getTotalPrice() {

        String str = isSale ? "节省: " + getSavedMoney() + "(元)\n" : "" ;

        return "总计: " + getAllCost() + "(元)\n" + str + "**********************";
//        return Utils.numberFormat(totalPrice);
    }

    public String getBuyTwoFreeOneList() {
        StringBuilder stringBuilder = new StringBuilder();
        if (isSale_BTFO) {
            stringBuilder.append("买二赠一商品：\n");
            for (CartItem cartItem : cart) {
                stringBuilder.append(cartItem.printDiscountItem());
            }
            stringBuilder.append("----------------------\n");
        }
        return stringBuilder.toString();
    }

    public List<CartItem> getCart() {
        return cart;
    }


    public String getAllCost() {
        double totalPrice = 0;
        for (CartItem cartItem : cart) {
            totalPrice += cartItem.getItemPrice();
        }

        return Utils.numberFormat(totalPrice);
    }

    public String getCartItemString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (CartItem item : cart) {
            stringBuilder.append(item.printItemList());
        }

        return stringBuilder.toString();
    }


    public String getSavedMoney() {
        double savedMoney = 0;
        for (CartItem item : cart) {
            savedMoney += item.getItemSaved();
        }

        return Utils.numberFormat(savedMoney);
    }

}
