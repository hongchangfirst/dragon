package com.zhclab.dragon.dao;

import java.util.List;

import com.zhclab.dragon.entity.Stock;

public interface StockDao {
    public void add(Stock stock);
    public void delete(Stock stock) ;
    public void edit(Stock stock);
    public Stock getStock(Stock stock);
    public List<Stock> getList(Stock stock);
}
