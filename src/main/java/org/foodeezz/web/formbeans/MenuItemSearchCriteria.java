package org.foodeezz.web.formbeans;

/**
 * Created by galib on 5/5/2015.
 */
public class MenuItemSearchCriteria {

    private String item;

    private Double minPrice = 0.0;

    private Double maxPrice = 10000.0;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getMinPrice() {
        return minPrice == null ? 0 : minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice == null ? 10000: maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }
}
