package com.zhclab.dragon.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.zhclab.dragon.dao.StockDao;
import com.zhclab.dragon.entity.Stock;

@Repository("stockDao")
public class StockDaoImpl implements StockDao {
	@Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
	
	public void add(Stock stock) {
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(stock);		
	}

	public void delete(Stock stock) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(stock);
	}

	public void edit(Stock stock) {
		Session session = sessionFactory.getCurrentSession();
		session.update(stock);
	}

	public Stock getStock(Stock stock) {
		Session session = sessionFactory.getCurrentSession();
		Stock ret = (Stock)session.get(Stock.class, stock);
		return ret;
	}

}
