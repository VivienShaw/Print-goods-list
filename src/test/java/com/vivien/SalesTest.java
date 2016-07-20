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
    public void should_return_goodsList_when_input_ITEM000004_with_buy_two_get_one_free_discount() throws Exception {
        String barcode = "ITEM000004";
        Sales sales = new Sales(barcode);
        assertThat(sales.printReceipt(), is("***<没钱赚商店>购物清单***\n" +
                "名称：蓝月亮洗衣液，数量：1瓶，单价：16.00(元)，小计：16.00(元)\n" +
                "----------------------\n" +
                "总计: 16.00(元)\n" +
                "**********************"));
    }

    @Test
    public void should_return_goodsList_when_input_3_ITEM000000_without_discount() throws Exception {
        String[] barcode = new String[]{"ITEM000000","ITEM000000","ITEM000000"};
        Sales sales = new Sales(barcode);
        assertThat(sales.printReceipt(), is("***<没钱赚商店>购物清单***\n" +
                "名称：雪碧，数量：3瓶，单价：3.00(元)，小计：9.00(元)\n" +
                "----------------------\n" +
                "总计: 9.00(元)\n" +
                "**********************"));
    }

    @Test
    public void should_return_goodsList_when_input_2_ITEM000001_1_ITEM000002_without_discount() throws Exception {
        String[] barcode = new String[]{"ITEM000001","ITEM000001","ITEM000002"};
        Sales sales = new Sales(barcode);
        assertThat(sales.printReceipt(), is("***<没钱赚商店>购物清单***\n" +
                "名称：可乐，数量：2瓶，单价：3.00(元)，小计：6.00(元)\n" +
                "名称：橙汁，数量：1瓶，单价：4.00(元)，小计：4.00(元)\n" +
                "----------------------\n" +
                "总计: 10.00(元)\n" +
                "**********************"));
    }

    @Test
    public void should_return_goodsList_with_discount_when_input_3_ITEM000003_with_buy_two_get_one_free_discount() throws Exception {
        String[] barcodes = new String[]{"ITEM000003","ITEM000003","ITEM000003"};
        Sales sales = new Sales(barcodes);
        assertThat(sales.printReceipt(), is(
                "***<没钱赚商店>购物清单***\n" +
                "名称：奥利奥，数量：3袋，单价：5.00(元)，小计：10.00(元)\n" +
                "----------------------\n" +
                "买二赠一商品：\n" +
                "名称：奥利奥，数量：1袋 \n" +
                "----------------------\n" +
                "总计: 10.00(元)\n" +
                "节省: 5.00(元)\n" +
                "**********************"));
    }

    @Test
    public void should_return_goodsList_with_discount_when_input_3_ITEM000005_with_discount_one_and_discount_two() throws Exception {
        String[] barcodes = new String[]{"ITEM000005","ITEM000005","ITEM000005"};
        Sales sales = new Sales(barcodes);
        assertThat(sales.printReceipt(), is(
                "***<没钱赚商店>购物清单***\n" +
                        "名称：卫龙，数量：3袋，单价：2.00(元)，小计：4.00(元)\n" +
                        "----------------------\n" +
                        "买二赠一商品：\n" +
                        "名称：卫龙，数量：1袋 \n" +
                        "----------------------\n" +
                        "总计: 4.00(元)\n" +
                        "节省: 2.00(元)\n" +
                        "**********************"));
    }

    @Test
    public void should_return_goodsList_with_discount_when_input_1_ITEM000006_with_five_percent_off_discount() throws Exception {
        String barcode = "ITEM000006";
        Sales sales = new Sales(barcode);
        assertThat(sales.printReceipt(), is(
                "***<没钱赚商店>购物清单***\n" +
                        "名称：乐高数字火车，数量：1件，单价：100.00(元)，小计：95.00(元)，节省：5.00(元)\n" +
                        "----------------------\n" +
                        "总计: 95.00(元)\n" +
                        "节省: 5.00(元)\n" +
                        "**********************"));
    }

    @Test
    public void should_return_goodsList_with_discount_when_input_1_ITEM000007_with_two_kinds_of_discount() throws Exception {
        String barcode = "ITEM000007";
        Sales sales = new Sales(barcode);
        assertThat(sales.printReceipt(), is(
                "***<没钱赚商店>购物清单***\n" +
                        "名称：足球，数量：1个，单价：35.00(元)，小计：33.25(元)，节省：1.75(元)\n" +
                        "----------------------\n" +
                        "总计: 33.25(元)\n" +
                        "节省: 1.75(元)\n" +
                        "**********************"));
    }

    @Test
    public void should_return_goodsList_when_input_ITEM000009_3_with_no_discount() throws Exception {
        String barcode = "ITEM000009-3";
        Sales sales = new Sales(barcode);
        assertThat(sales.printReceipt(), is(
                "***<没钱赚商店>购物清单***\n" +
                        "名称：哈尔滨啤酒，数量：3瓶，单价：5.50(元)，小计：16.50(元)\n" +
                        "----------------------\n" +
                        "总计: 16.50(元)\n" +
                        "**********************"));
    }

    @Test
    public void should_return_goodsList_when_input_ITEM000008_3_and_ITEM000005_with_discount() throws Exception {
        String[] barcodes = new String[]{"ITEM000008-3","ITEM000005"};
        Sales sales = new Sales(barcodes);
        assertThat(sales.printReceipt(), is(
                "***<没钱赚商店>购物清单***\n" +
                        "名称：尤里克斯儿童网球拍，数量：3个，单价：125.00(元)，小计：250.00(元)\n" +
                        "名称：卫龙，数量：1袋，单价：2.00(元)，小计：1.90(元)，节省：0.10(元)\n" +
                        "----------------------\n" +
                        "买二赠一商品：\n" +
                        "名称：尤里克斯儿童网球拍，数量：1个 \n" +
                        "----------------------\n" +
                        "总计: 251.90(元)\n" +
                        "节省: 125.10(元)\n" +
                        "**********************"));

    }
}