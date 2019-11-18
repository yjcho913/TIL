package edu.android20191118.testforenfcreader;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    NfcAdapter nfcAdapter;
    PendingIntent pIntent;
    IntentFilter[] filters;
    TextView infoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoTv = findViewById(R.id.infoTv);
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if(nfcAdapter == null){
            Toast.makeText(this, "NFC 지원 X", Toast.LENGTH_SHORT).show();
            finish();
        }

        // 1. 프레임워크에서 전달된 인텐트를 처리할 액티비티를 호출할 인텐트 생성
        Intent i = new Intent(this, this.getClass());
        i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        // 2. 인텐트를 처리할 펜딩인텐트 생성
        pIntent = PendingIntent.getActivity(this, 0, i, 0);

        // 3. 인텐트 필터 생성
        IntentFilter ndefFilter1 = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
        IntentFilter ndefFilter2 = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
        IntentFilter ndefFilter3 = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);

        try {
            ndefFilter1.addDataType("text/plain");
            ndefFilter2.addDataScheme("http");
            ndefFilter3.addDataScheme("https");
            filters = new IntentFilter[]{ndefFilter1, ndefFilter2, ndefFilter3};
        } catch (IntentFilter.MalformedMimeTypeException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        nfcAdapter.enableForegroundDispatch(this, pIntent, filters, null);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("INFO", "onNewIntent CALL...");
//        String action = intent.getAction() + "\n";
//        infoTv.append(action);
        processIntent(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        nfcAdapter.disableForegroundDispatch(this);
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
                break;
            case "U":
                Uri recUri = textR.toUri();
                infoTv.setText("DATA1 : " + recUri.toString() + "\n");
//                Intent i2 = new Intent(Intent.ACTION_VIEW, recUri);
//                startActivity(i2);
                break;
        }
    }
}
