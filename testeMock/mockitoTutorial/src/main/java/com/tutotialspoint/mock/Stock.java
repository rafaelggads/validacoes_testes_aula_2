package com.tutotialspoint.mock;

/**
 * Created by gilmario on 14/02/17.
 */
public class Stock {
    private String stockId;
    private String name;
    private int quantity;

    public Stock(String stockId, String name, int quantity) {
        this.stockId = stockId;
        this.name = name;
        this.quantity = quantity;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getTicker() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

}
