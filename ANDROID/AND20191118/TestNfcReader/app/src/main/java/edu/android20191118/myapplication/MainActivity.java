package edu.android20191118.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView infoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoTv = findViewById(R.id.infoTv);
        Intent recI = getIntent();
        String action = recI.getAction();
//        infoTv.setText("ACTION : " + action);
        if(action.equals(NfcAdapter.ACTION_NDEF_DISCOVERED)){
            processIntent(recI);
        }
    }

    private void processIntent(Intent i){
        Parcelable[] rawData = i.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);

        NdefMessage ndefM = (NdefMessage)rawData[0];
        NdefRecord[] recArr = ndefM.getRecords();
        NdefRecord textR = recArr[0];
        byte[] recT = textR.getType();

        String strT = new String(recT);
        Log.i("INFO", "TYPE : " + strT);
        for(int ii=0; ii<recArr.length; ii++){
                Log.i("INFO", "DATA : " + recArr[ii].getPayload().toString());
        }

        byte[] bData;
        String sData;
        switch(strT){
            case "T":
                bData = textR.getPayload();
                sData = new String(bData, 3, bData.length -3);
                infoTv.setText("DATA1 : " + sData + "\n");
//                infoTv.append("DATA2 : " + bData.toString());
                break;
            case "U":
                Uri recUri = textR.toUri();
                infoTv.setText("DATA1 : " + recUri.toString() + "\n");
//                infoTv.append("DATA2 : " + new String(recUri.toString()) + "\n");
//                infoTv.append("DATA3 : " + new String(textR.getPayload()) + "\n");
//                infoTv.append("DATA4 : " + textR.getPayload().toString());
                Intent i2 = new Intent(Intent.ACTION_VIEW, recUri);
                startActivity(i2);
                break;
        }
    }
}
