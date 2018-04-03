package com.example.user.stocktrader;

import java.util.Date;

/**
 * Created by user on 3/15/17.
 */
public class Equity
{
    private String symbol;
    private int qty;
    private double marketvalue;
    private double bookvalue;
    private double yield;
    private Date acquired;




public Equity(String symbol, int qty, double bookvalue,  Date acquired, double marketvalue, double yield)
{
    this.qty = qty;
    this.bookvalue = bookvalue;
   this.marketvalue = marketvalue;
    this.acquired = acquired;
    this.symbol = symbol;
    this.bookvalue = bookvalue;
    this.yield = yield;
    
}


    public String getSymbol()
    {
        return this.symbol;
    }

    public int getQty() { return this.qty; }

    public double getBookvalue()
    {
        return this.bookvalue;
    }

    public Date getAcquired()
    {
        return this.acquired;
    }



    public double getMarketvalue()
    {
       return this.marketvalue;
    }

    public double getYield()
    {
     return this.yield*100;
    }

   // @Override
    public java.lang.String toString()
    {
        return "Equity(" + "symbol='" + this.symbol + '\'' + ", qty=" + this.qty + ", bookValue" +this.bookvalue + ", acquired=" + this.acquired + '}';



    }


    public static void main(String[] args)
    {
        Date date = new Date();
        Equity test = new Equity(".QC",78,12.32,date,24.50,0.0346389);
        System.out.println(test.getSymbol());
        System.out.println(test.getQty());
        System.out.println(test.getBookvalue());
        System.out.println(test.getAcquired());
        System.out.println(test.getMarketvalue());
        System.out.println(test.getYield());
        System.out.println(test.toString());

    }
}





