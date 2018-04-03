package com.example.user.stocktrader;

import android.content.Intent;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    PortfolioAnalyzer pf;
    TableLayout table;
    TableRow header,row;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        table = (TableLayout) findViewById(R.id.table);


    }


public void SearchActivity(View v)
{
    //accessing the portfolio
    String x = ((EditText)findViewById(R.id.portfolioName)).getText().toString();
    //transfer control to 2nd activity
    if (x.equals("?"))
    {
        Intent intent = new Intent(this, ListActivity.class);
        this.startActivity(intent);
    }
    else
    {
        //accessing the portfolio
        Resources res = getResources();
        String[] data = res.getStringArray(res.getIdentifier(x, "array", this.getPackageName()));
        pf = new PortfolioAnalyzer(x,data);
        double pm = pf.getPortfolioMarketValue();
        double pd= pf.getPortfolioYield() *100;

        //output portfolio analysis
        String myPortfolio = String.format("%,.2f",pm);
        String otPortolio = String.format(".2f", pd);
        String description = "the " + x + " This portolio has this" + pf.getPortfolioMarketValue() + " equalities. has the market value of $"+
                myPortfolio + " and a yield of " + otPortolio +"%(annually)";

        ((TextView)findViewById(R.id.summary)).setText(description);
//Row header
        table.removeAllViews();

        header = new TableRow(this);

        TextView label1 = new TextView(this);
        label1.setText("Symbol");
        TextView label2 = new TextView(this);
        label2.setText("Quantity");
        TextView label3 = new TextView(this);
        label3.setText("bookValue");
        TextView label4 = new TextView(this);
        label4.setText("Acquired");
        TextView label5 = new TextView(this);
        label5.setText("MarketValue");
        TextView label6 = new TextView(this);
        label6.setText("Yield");

        header.addView(label1);
        header.addView(label2);
        header.addView(label3);
        header.addView(label4);
        header.addView(label5);
        header.addView(label6);

        table.addView(header);
        //output portfolio into table
        for (Equity equity :pf.getPortfolio())
        {

            TextView a1 = new TextView(this);
            a1.setText(String.valueOf(equity.getSymbol()));

            TextView a2 = new TextView(this);
            String qty = String.format("%,d",equity.getQty());
            a2.setText(qty);

            TextView a3 = new TextView(this);
            String b = String.format("%d",equity.getBookvalue());
            a3.setText(b);

            TextView a4 = new TextView(this);
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String acquired = format.format(equity.getAcquired());
            a4.setText(acquired);

            TextView a5 = new TextView(this);
            String md = String.format("%,.2f",equity.getMarketvalue());
            a5.setText(md);

            TextView a6 = new TextView(this);
            String yield = String.format("%,.2f",equity.getYield());
            a6.setText(yield);


            row = new TableRow(this);
            row.addView(a1);
            row.addView(a2);
            row.addView(a3);
            row.addView(a4);
            row.addView(a5);
            row.addView(a6);

            table.addView(row);


        }



    }

}

    public void clearOnClick(View v)
    {
        ((EditText) findViewById(R.id.portfolioName)).setText("");
    }


}
