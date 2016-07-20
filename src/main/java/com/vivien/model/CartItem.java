package com.vivien.model;

import com.sun.org.apache.xml.internal.utils.StringBufferPool;
import com.vivien.bean.Goods;
import com.vivien.utils.Utils;

/**
 * Created by vivie on 2016/7/20.
 */
public class CartItem {

    private Goods goods;
    private int number;

    public void addNumber(){
        number++;
    }

    public String printItemList(){
        StringBuffer itemList = new StringBuffer();
        itemList.append("名称："+goods.getName()
                +"，数量："+ number +goods.getUnit()+
                "，单价："+ Utils.numberFormat(goods.getPrice())
                +"(元)");
        itemList.append("，小计：" + Utils.numberFormat(getItemPrice()) + "(元)");
        if (goods.getDiscountType() == 2) {
            itemList.append("，节省："+Utils.numberFormat(goods.getPrice() * number * 0.05)
                    +"(元)");
        }
        itemList.append("\n");
        return itemList.toString();
    }

    public double getItemPrice() {
        if (goods.getDiscountType() == 1) {
            return goods.getPrice() * (number - 1);
        }
        if (goods.getDiscountType() == 3 && number > 2) {
            return goods.getPrice() * (number - 1);
        }
        if (goods.getDiscountType() == 2) {
            return goods.getPrice() * number * 0.95;
        }
        return goods.getPrice() * number;
    }


    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
