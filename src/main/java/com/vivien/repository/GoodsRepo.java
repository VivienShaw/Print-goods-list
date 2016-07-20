package com.vivien.repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vivien.bean.Goods;
import com.vivien.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class GoodsRepo {

    public static final int NO = 0;
    public static final int BUY_TWO_GET_ONE_FREE = 1;
    public static final int FIVE_PERCENT_OFF = 2;
    public static final int BOTH = 3;

    public static Map<String,Goods> allGoods = new HashMap<String, Goods>();
    public static Map<String,Integer> discountGoods = new HashMap<String, Integer>();
    String allGoodsPath = GoodsRepo.class.getClassLoader().getResource("allGoods").getPath();
    String saleGoodsPath = GoodsRepo.class.getClassLoader().getResource("discountInfo").getPath();

    public GoodsRepo() {
        loadAllGoods(allGoodsPath);
        loadDiscountInfo(saleGoodsPath);
    }

    //the single mode
    public static final GoodsRepo goodsRepo = new GoodsRepo();

    public static GoodsRepo getInstance() {
        return goodsRepo;
    }

    private void loadAllGoods(String productsPath) {
        JSONArray productsJson = JSONArray.parseArray(Utils.readFile(productsPath));
        for (int n = 0; n < productsJson.size(); n++) {
            JSONObject jOGoods = productsJson.getJSONObject(n);
            Goods goods = getGoodsFromJsonobject(jOGoods);
            allGoods.put(jOGoods.getString("barcode"), goods);
        }
    }

    private Goods getGoodsFromJsonobject(JSONObject obj) {
        Goods goods = new Goods();
        goods.setBarcode(obj.getString("barcode"));
        goods.setName(obj.getString("name"));
        goods.setUnit(obj.getString("unit"));
        goods.setPrice(obj.getDouble("price"));
        goods.setCategory(obj.getString("category"));
        return goods;
    }

    public void loadDiscountInfo(String path) {
        JSONArray discountsJson = JSONArray.parseArray(Utils.readFile(path));
        for (int n = 0; n < discountsJson.size(); n++) {
            JSONObject jOGoods = discountsJson.getJSONObject(n);
            String type = jOGoods.getString("type");
            String barcode = jOGoods.getString("barcodes");
            String[] barcodes = barcode.split(",");
            for (String s : barcodes) {
                getDiscountGoods(type,s);
            }
        }
    }

    public void getDiscountGoods(String type,String code) {
        if (discountGoods.containsKey(code)) {
            discountGoods.put(code,3);
            return;
        }

        if(type.equals("BUY_TWO_GET_ONE_FREE")) {
            discountGoods.put(code,1);
            return;
        }
        if(type.equals("FIVE_PERCENT_OFF")) {
            discountGoods.put(code,2);
            return;
        }
    }

    public int getDiscountType(String code) {
        if(!discountGoods.containsKey(code)) {
            return 0;
        }
       return  discountGoods.get(code);
    }

}
