package com.example.gotopapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PolsekBungaraya extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super.onCreate(icicle);
        String[] listAct = new String[] {"Call Center","SMS Center","Driving Direction",
                "Website","Info di Google"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listAct));
    }

    protected void onListItemClick (ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }

    private void tampilkanpilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Call Center")) {
                String nomortel ="tel:0761-101010";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomortel));


            }else if (pilihan.equals("SMS Center"))
            {
                String smsText="Amelia Irsyada/P";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:081274772222"));
                a.putExtra("sms_body",smsText);
            }else if (pilihan.equals("Driving Direction"))
            {
                String lokasikp ="https://www.google.com/maps/place/POLSEK+BUNGARAYA/@0.9622492,102.0751323,16z/data=!4m12!1m6!3m5!1s0x0:0x331d2b7eec0207d6!2sPOLSEK+BUNGARAYA!8m2!3d0.961863!4d102.0750894!3m4!1s0x0:0x331d2b7eec0207d6!8m2!3d0.961863!4d102.0750894";
                a= new Intent(Intent.ACTION_VIEW,Uri.parse(lokasikp));

            }else if (pilihan.equals("Website"))
            {
                String website ="http://polsekbungaraya.com";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));
            }else if (pilihan.equals("Info di Google"))
            {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Polsek Bungaraya");
            }


            startActivity(a);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
