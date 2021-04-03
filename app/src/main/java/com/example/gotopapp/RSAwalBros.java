package com.example.gotopapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSAwalBros extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] listAct = new String[] {"Call Center", "SMS Center", "Driving Direction","Website", " Info di Google", "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listAct));
    }

    protected void onListItemClick (ListView l, View V, int position, long id){
        super.onListItemClick(l, V, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }

    private void tampilkanpilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Call Center")) {
            String nomortel ="";
            String nomorTel ="tel:0761-12345678";
            a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomorTel));


            }else if (pilihan.equals("SMS Center"))
            {
                String smsText="Amelia Irsyada/P";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:0831576488"));
                a.putExtra("sms_body",smsText);

            }else if (pilihan.equals("Driving Direction"))
            {
                String lokasirs = "google.navigation:RUMAH SAKIT AWAL BROS PANAM, Jl. HR. Soebrantas Panam No.88, Sialangmunggu, Kec. Tampan, Kota Pekanbaru, Riau 28293";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasirs));

            }else if (pilihan.equals("Website"))
            {
                String website ="http://awalbros.com/branch/pekanbaru/";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));
            }else if (pilihan.equals("Info di google"))
            {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"https://www.google.com/search?q=rumah+sakit+awal+bros&oq=rumah+sakit+awal&aqs=chrome.1.0l3j69i57.5301j0j7&client=ms-android-vivo&sourceid=chrome-mobile&ie=UTF-8");
            }

                startActivity(a);

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
