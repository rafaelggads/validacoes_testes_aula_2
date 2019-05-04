package com.tutorialspoint.mock;

import com.tutotialspoint.mock.Portfolio;
import com.tutotialspoint.mock.Stock;
import com.tutotialspoint.mock.StockService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by gilmario on 14/02/17.
 */
public class PortifolioTester {

    Portfolio portfolio;
    StockService stockService;

    public static void main(String args[]){
        PortifolioTester tester = new PortifolioTester();
        tester.setUp();
        System.out.println(tester.testMarketValue() ? "pass" : "fail");
    }

    public void setUp(){
        //create a portfolio object which is to be tested
        portfolio = new Portfolio();

        //create the mock objetct of stock service
        stockService = mock(StockService.class);

        //set the stockservice to the portifolio
        portfolio.setStockService(stockService);
    }

    public boolean testMarketValue(){
        //creates a list of stocks to be added to the portfolio
        List<Stock> stocks = new ArrayList();
        Stock googleStock = new Stock("1", "Google",10);
        Stock microsoftStock = new Stock("2", "Microsoft",100);

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        portfolio.setStocks(stocks);

        //mock the behavior of stock service to return the value of various stocks
        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);

        double marketValue = portfolio.getMarketValue();

        return marketValue == 100500.00;
    }
}
