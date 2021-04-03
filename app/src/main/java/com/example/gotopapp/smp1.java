package com.example.gotopapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class smp1 extends ListActivity {
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
                String nomortel ="tel:0761-212121";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomortel));


            }else if (pilihan.equals("SMS Center"))
            {
                String smsText="Amelia Irsyada/P";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:082285383526"));
                a.putExtra("sms_body",smsText);
            }else if (pilihan.equals("Driving Direction"))
            {
                String lokasisp ="https://www.google.com/maps/place/SMPN+1+BUNGARAYA/@0.9627494,102.0788609,15z/data=!4m5!3m4!1s0x0:0x8d340582663dfd94!8m2!3d0.9627494!4d102.0788609";
                a= new Intent(Intent.ACTION_VIEW,Uri.parse(lokasisp));

            }else if (pilihan.equals("Website"))
            {
                String website ="https://dapo.kemdikbud.go.id/sekolah/1B047C3E1B318B977CB6";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));
            }else if (pilihan.equals("Info di Google"))
            {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"SMP 1 Bungaraya");
            }


            startActivity(a);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
