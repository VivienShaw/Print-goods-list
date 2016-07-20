package com.vivien.model;

import com.vivien.bean.Goods;

import java.util.ArrayList;
import java.util.List;
import com.vivien.utils.Utils;
/**
 * Created by vivie on 2016/7/20.
 */
public class Cart {

    private List<CartItem> cart = new ArrayList<CartItem>();
    int totalPrice = 0;
    private int haveDiscount = 0;

    public void addItem(CartItem item) {
        cart.add(item);
    }

    public CartItem getItemByGoods(Goods goods) {
        for (CartItem item : cart) {
            if (item.getGoods().equals(goods)) {
                return item;
            }
        }
        return null;
    }

    public boolean isContainGoods(Goods goods) {
        for (CartItem cartItem : cart) {
            if (cartItem.getGoods() != null && cartItem.getGoods().equals(goods))
                return true;
        }
        return false;
    }

    public String getTotalPrice() {
        for (CartItem cartItem : cart) {
            totalPrice += cartItem.getItemPrice();
        }

        return Utils.numberFormat(totalPrice);
    }

    public List<CartItem> getCart() {
        return cart;
    }

    public void setCart(List<CartItem> cart) {
        this.cart = cart;
    }

    public int getHaveDiscount() {
        return haveDiscount;
    }

    public void setHaveDiscount() {
        for (CartItem item : cart) {
            if (this.haveDiscount != 0) return;
            if (item.getGoods().getDiscountType() == 1 && item.getNumber() > 2) {
                this.haveDiscount = 1;
                return;
            }
            if (item.getGoods().getDiscountType() == 3 && item.getNumber() > 2) {
                this.haveDiscount = 1;
                return;
            }
            if (item.getGoods().getDiscountType() == 2) {
                this.haveDiscount = 2;
                return;
            }
            if (item.getGoods().getDiscountType() == 3 && item.getNumber() <= 2) {
                this.haveDiscount = 2;
                return;
            }
        }
    }

}
