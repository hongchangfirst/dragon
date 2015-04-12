package com.zhclab.dragon.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_tbl")
public class Stock implements Serializable{
	@Id
    @Column(name = "stock_code", nullable=false)
    private String stockCode;
    
	@Id
    @Column(name = "price_date", nullable=false)
    private Date priceDate;
	
    @Column(name="start_price")
    private double startPrice;

    public Stock() {}
    
    public Stock(String stockCode, Date priceDate) {
    	this.stockCode = stockCode;
    	this.priceDate = priceDate;
    }
    
	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public Date getPriceDate() {
		return priceDate;
	}

	public void setPriceDate(Date priceDate) {
		this.priceDate = priceDate;
	}

	public double getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(double startPrice) {
		this.startPrice = startPrice;
	}
    
    public String toString() {
    	return this.stockCode + " " + this.priceDate + " " + this.startPrice;
    }
}
