package com.vivien;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class SalesTest {
    @Test
    public void should_return_goodsList_when_input_ITEM000001() throws Exception {
        String barcode = "ITEM000001";
        Sales sales = new Sales();
        assertThat(sales.printList(), is("***<没钱赚商店>购物清单***\n" +
                "名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n" +
                "----------------------\n" +
                "总计: 3.00(元)\n" +
                "节省：0.00(元)\n" +
                "**********************"));
    }

}