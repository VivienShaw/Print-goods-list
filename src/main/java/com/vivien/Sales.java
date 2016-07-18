package com.vivien;

public class Sales {

    public static String printList() {
        StringBuilder goodsList = new StringBuilder();
        goodsList.append("***<没钱赚商店>购物清单***\n");
        goodsList.append("名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n");
        goodsList.append("----------------------\n");
        goodsList.append("总计: 3.00(元)\n");
        goodsList.append("节省：0.00(元)\n");
        goodsList.append("**********************");
        return goodsList.toString();
    }
}
