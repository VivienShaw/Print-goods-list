package com.vivien.repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vivien.bean.Goods;
import com.vivien.utils.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vivie on 2016/7/20.
 */
public class GoodsRepo {
    Map<String,Goods> allGoods = new HashMap<String, Goods>();
    String allGoodsPath = GoodsRepo.class.getClassLoader().getResource("allGoods").getPath();

    public GoodsRepo() {
        this.allGoods = loadAllGoods(allGoodsPath);
    }

    private Map<String,Goods> loadAllGoods(String productsPath) {
        Map<String,Goods> products = new HashMap<String, Goods>();
        JSONArray productsJson = JSONArray.parseArray(Utils.readFile(productsPath));
        for (int n = 0; n < productsJson.size(); n++) {
            JSONObject jOGoods = productsJson.getJSONObject(n);
            Goods goods = getGoodsFromJsonobject(jOGoods);
            products.put(jOGoods.getString("barcode"), goods);
        }
        return products;
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

    public Map<String, Goods> getAllGoods() {
        return allGoods;
    }

    public void setAllGoods(Map<String, Goods> allGoods) {
        this.allGoods = allGoods;
    }
}
