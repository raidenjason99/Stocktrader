package com.example.user.stocktrader;

import android.provider.ContactsContract;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jba.roumani.lib.Stock;

/**
 * Created by user on 3/15/17.
 */
public class PortfolioAnalyzer
{
    private String title;
    private List<Equity> portfolio;
    private Equity equity;
    public static  final long MS_PER_DAY = 24 * 3600 *1000;
    public static final int DAY_PER_YEAR = 365;
    public Date acquired;


  public PortfolioAnalyzer(String title, String[] rows)
  {
      this.title = title;
      this.portfolio = new ArrayList<>();


      //for (String row : rows)
      for (int i =0; i < rows.length; i++)
      {



          String[] field = rows[i].split(",");
          String symbol = field[0];
          int qty = Integer.valueOf(field[1]);
          double bookValue = Double.parseDouble(field[2]);
          double marketvalue = this.getInvestmentMarketValue(symbol);
          try
          {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
              acquired = sdf.parse(field[3]);


          } catch (Exception e)

          {
              Date date = new Date();
              equity = new Equity("?", 1, 1, date , 1, 1);



          }
          double yield = getInvestmentYield(bookValue, marketvalue, acquired);
          equity = new Equity(symbol, qty, bookValue, acquired, marketvalue, yield);
          this.portfolio.add(equity);
      }

  }

    // List accessor

      public List<Equity> getPortfolio()
      {
          return this.portfolio;
      }

    // List/portfolio size accessor
    public int getPortfolioSize()

    {

        int count = 0 ;
       for (Equity st : this.portfolio)
        {
            count++;
      }
       return count;

       //return getPortfolio().size();
    }

    public String toString()
    {
       return "the" + this.title +"equalities. \n" + " it has the market value of "+ String.format("$%,.2f",this.getPortfolioMarketValue()) + " and a yield of "+
               String.format("%,.1f%%(annualized).", 100 + this.getPortfolioSize());
    }

    //obtain current market price using abstract stock exchange api
    //current market value accessor

    private double getInvestmentMarketValue(String symbol)
    {
        Stock f = new Stock(symbol);
        double d = f.getPrice();

            return d;

    }
    //compute days elapsed

    public double getInvestmentYield(double bookValue,
                                     double marketValue,
                                     java.util.Date acquired)
    {
        Date date = new Date();
        double yield = ((marketValue-bookValue) /bookValue) *(DAY_PER_YEAR/(double)(date.getTime()/MS_PER_DAY - acquired.getTime()/MS_PER_DAY));

        return yield *100;

    }


    public double getPortfolioMarketValue()
    {
      double a = 0;

        for (Equity abc : this.portfolio)
        {
            a += abc.getQty() * abc.getMarketvalue() * abc.getYield();
            //System.out.println(String.valueOf(abc.getYield()));
        }
        return a;
    }

    public double getPortfolioYield()
    {
        double weightfileSum = 0;
        double weightSum = 0;
        for (Equity equity : this.portfolio)
        {

            weightfileSum+= equity.getQty() * equity.getBookvalue() *equity.getYield();
            weightSum += equity.getQty() * equity.getBookvalue();
        }
        return weightfileSum / weightSum ;
    }


    public static void main(String[] args)
    {

        String title = "SC";
        String[] data = {".QC,78,7.50,20/01/2003",".UR,2679,37.33,14/01/2004"};
         PortfolioAnalyzer pol = new PortfolioAnalyzer(title,data);
        System.out.println(pol.getPortfolioMarketValue());
        System.out.println(pol.getPortfolioYield());
        System.out.println(pol.getPortfolioSize());



        String title1 = "pf";
        String[] data1 = {".QC,78,7.50,20/01/2003",".UR,2679,37.33,14/01/2004",
                "UA,2503,28.06,10/28/07",".CS,4471,149.86,11/9/2010"};
        PortfolioAnalyzer pol1 = new PortfolioAnalyzer(title1,data1);
        System.out.println(pol1.getPortfolioMarketValue());
        System.out.println(pol1.getPortfolioYield());
        System.out.println(pol1.getPortfolioSize());




    }
}