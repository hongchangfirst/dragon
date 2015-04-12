package com.zhclab.dragon.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhclab.dragon.entity.Stock;
import com.zhclab.dragon.service.StockService;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	@Resource(name = "stockService")
    private StockService stockService;
	
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody
    String getStock(@RequestParam String stockCode, @RequestParam(required = false) String priceDateStr, HttpServletRequest request) {
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
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public @ResponseBody
    String addStock(@RequestParam String stockCode, @RequestParam(required = false) String priceDateStr, @RequestParam double startPrice, HttpServletRequest request) {
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
}
