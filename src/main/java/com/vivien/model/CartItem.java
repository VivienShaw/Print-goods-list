package com.vivien.model;

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
        return "名称："+goods.getName()
                +"，数量："+ number +goods.getUnit()+
                "，单价："+ Utils.numberFormat(goods.getPrice())
                +"(元)，小计："+Utils.numberFormat(goods.getPrice() * number)+"(元)\n";
    }

    public double getItemPrice() {
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
