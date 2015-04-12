package com.zhclab.dragon.service;

import java.util.Date;
import java.util.List;

import com.zhclab.dragon.entity.Stock;

public interface StockService {
	public void saveOrUpdate(String stockCode, Date priceDate, double startPrice);
	public Stock get(String stockCode, Date priceDate);
	public List<Stock> getList(String stockCode);
}
