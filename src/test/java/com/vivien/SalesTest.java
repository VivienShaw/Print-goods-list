package com.vivien;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class SalesTest {
    @Test
    public void should_return_goodsList_when_input_ITEM000001_without_discount() throws Exception {
        String barcode = "ITEM000001";
        Sales sales = new Sales(barcode);
        assertThat(sales.printReceipt(), is("***<没钱赚商店>购物清单***\n" +
                "名称：可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n" +
                "----------------------\n" +
                "总计: 3.00(元)\n" +
                "**********************"));
    }

    @Test
    public void should_return_goodList_when_input_ITEM000000_with_buy_two_get_one_free_discount() throws Exception {
        String barcode = "ITEM000000";
        Sales sales = new Sales(barcode);
        assertThat(sales.printReceipt(), is("***<没钱赚商店>购物清单***\n" +
                "名称：雪碧，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n" +
                "----------------------\n" +
                "总计: 3.00(元)\n" +
                "**********************"));
    }

    @Test
    public void should_return_goodList_with_discount_when_input_3_ITEM000000_without_discount() throws Exception {
        String[] barcode = new String[]{"ITEM000000","ITEM000000","ITEM000000"};
        Sales sales = new Sales(barcode);
        assertThat(sales.printReceipt(), is("***<没钱赚商店>购物清单***\n" +
                "名称：雪碧，数量：3瓶，单价：3.00(元)，小计：9.00(元)\n" +
                "----------------------\n" +
                "总计: 9.00(元)\n" +
                "**********************"));
    }
}