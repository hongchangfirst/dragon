package com.zhclab.dragon.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhclab.dragon.entity.Stock;
import com.zhclab.dragon.service.StockService;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	@Resource(name = "stockService")
    private StockService stockService;
	
	/*
	 * http://localhost:8000/dragon/stock/get?stock_code=123&priceDateStr=2016-4-11
	 */
	@RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody
    String getStock(@RequestParam(value = "stock_code") String stockCode, @RequestParam(required = false) String priceDateStr, HttpServletRequest request) {
		Date priceDate = new Date();
		if (priceDateStr != null) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置显示格式
			try {
				priceDate = df.parse(priceDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Stock stock = stockService.get(stockCode, priceDate);
		return stock.toString();
	}
	
	/*
	 * http://localhost:8000/dragon/stock/add?stock_code=123&priceDateStr=2016-4-14&startPrice=2000
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public @ResponseBody
    String addStock(@RequestParam(value = "stock_code") String stockCode, @RequestParam(required = false) String priceDateStr, @RequestParam double startPrice, HttpServletRequest request) {
		Date priceDate = new Date();
		if (priceDateStr != null) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置显示格式
			try {
				priceDate = df.parse(priceDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		System.out.println("start save a stock " + stockCode + " " + priceDate.toString());
		stockService.saveOrUpdate(stockCode, priceDate, startPrice);
		return stockCode + " " + priceDate;
	}
	
	/*
	 * http://localhost:8000/dragon/stock/list?stock_code=123&start_date=2015-4-10
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getStockList(@RequestParam(value = "stock_code") String stockCode, @RequestParam(value = "start_date", required = false) String startDateStr, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("stockList");
		
		Date startDate = new Date();
		if (startDateStr != null) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置显示格式
			try {
				startDate = df.parse(startDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		System.out.println("start get stock");
		List<Stock> stockList = stockService.getList(stockCode, startDate);
		System.out.println("end get stock");

		mav.addObject("stockList", stockList);
		return mav;
	}
}
