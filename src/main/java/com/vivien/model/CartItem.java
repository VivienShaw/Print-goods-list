package com.vivien.model;

import com.vivien.bean.Goods;
import com.vivien.utils.Utils;

public class CartItem {

    private Goods goods;
    private int number;

    public void increaseNumber(){
        number++;
    }

    public String printItemList(){
        StringBuffer itemList = new StringBuffer();
        itemList.append("名称："+goods.getName()
                +"，数量："+ number +goods.getUnit()+
                "，单价："+ Utils.numberFormat(goods.getPrice())
                +"(元)");
        itemList.append("，小计：" + Utils.numberFormat(getItemPrice()) + "(元)");
        if (goods.getDiscountType() == 2 || (goods.getDiscountType() == 3 && number <= 2)) {
            itemList.append("，节省："+Utils.numberFormat(goods.getPrice() * number * 0.05)
                    +"(元)");
        }
        itemList.append("\n");
        return itemList.toString();
    }

    public double getItemSaved() {
        if ((goods.getDiscountType() == 1 || goods.getDiscountType() == 3) && number > 2 ) {
            return goods.getPrice()*(number/3);
        }

        if (goods.getDiscountType() == 2 || (goods.getDiscountType() == 3 && number <= 2)) {
            return goods.getPrice()*number*0.05;
        }

        return 0.0;
    }

    public double getItemPrice() {
        if ((goods.getDiscountType() == 1 || goods.getDiscountType() == 3) && number > 2 ) {
            return goods.getPrice()*(number-number/3);
        }

        if (goods.getDiscountType() == 2 || (goods.getDiscountType() == 3 && number <= 2)) {
            return goods.getPrice() * number * 0.95;
        }

        return goods.getPrice() * number;
    }

    public String printDiscountItem() {
        StringBuilder itemList = new StringBuilder();
        if ((goods.getDiscountType() == 1 || goods.getDiscountType() == 3) && number > 2) {
            itemList.append("名称："+goods.getName()+"，数量："+number/3+goods.getUnit()+" \n");
        }
        return itemList.toString();
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
