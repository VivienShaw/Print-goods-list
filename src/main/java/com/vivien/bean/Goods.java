package com.vivien.bean;

public class Goods {
    private String barcode;
    private String name;
    private String unit;
    private double price;
    private String category;
    private int discountType = 0;


    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Goods) {
            if (((Goods) obj).barcode.equals(this.barcode)
                    && ((Goods) obj).name.equals(this.name)
                    && ((Goods) obj).category.equals(this.category)
                    && ((Goods) obj).price == this.price
                    && ((Goods) obj).unit.equals(this.unit)) {
                return true;
            }
        }
        return false;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDiscountType() {
        return discountType;
    }

    public void setDiscountType(int discountType) {
        this.discountType = discountType;
    }
}
