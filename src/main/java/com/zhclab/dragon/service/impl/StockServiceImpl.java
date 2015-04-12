package com.zhclab.dragon.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhclab.dragon.dao.StockDao;
import com.zhclab.dragon.entity.Stock;
import com.zhclab.dragon.service.StockService;

@Service("stockService")
@Transactional(propagation = Propagation.REQUIRED)
public class StockServiceImpl implements StockService{
	
	@Resource(name = "stockDao")
    private StockDao stockDao;
	
	public void saveOrUpdate(String stockCode, Date priceDate, double startPrice) {
		Stock stock = new Stock();
		stock.setStockCode(stockCode);
		stock.setPriceDate(priceDate);
		stock.setStartPrice(startPrice);
		stockDao.add(stock);
	}
	
	public Stock get(String stockCode, Date priceDate) {
		Stock stock = new Stock(stockCode, priceDate);
		return stockDao.getStock(stock);
	}

}
