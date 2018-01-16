package com.patelheggere.airpaytest;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.airpay.airpaysdk_simplifiedotp.AirpayActivity;
import com.airpay.airpaysdk_simplifiedotp.ResponseMessage;
import com.airpay.airpaysdk_simplifiedotp.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Transaction> transactionList = new ArrayList<>();
    private EditText etName, etPhone, etEmail, etAmnt, etOrder;
    private Button btn;
    private ResponseMessage resp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize()
    {
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etAmnt = findViewById(R.id.amnt);
        etOrder = findViewById(R.id.etorder);
        btn = findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callactivity();
            }
        });
    }
    private void callactivity()
    {
        Intent myIntent = new Intent(this, AirpayActivity.class);

        Bundle b = new Bundle();
        
        b.putString("USERNAME", "5049772");
        b.putString("PASSWORD", "ttNWRG2m");
        b.putString("SECRET", "8kgH57mtfKUc9FFm");
        b.putString("MERCHANT_ID", "23198");

        Log.e("", "Email Id Tushar ---->>>>>> " + etEmail.getText().toString().trim());
        b.putString("EMAIL", etEmail.getText().toString().trim());
        b.putString("PHONE", etPhone.getText().toString().trim());
        b.putString("FIRSTNAME", etName.getText().toString().trim());
        b.putString("LASTNAME", etName.getText().toString().trim());
        b.putString("ADDRESS", etName.getText().toString().trim());
        b.putString("CITY", etName.getText().toString().trim());
        b.putString("STATE", etName.getEditableText().toString().trim());
        b.putString("COUNTRY", etName.getEditableText().toString().trim());
        b.putString("PIN_CODE", "560060");
        b.putString("ORDER_ID", etOrder.getText().toString().trim());
        b.putString("AMOUNT", etAmnt.getText().toString().trim());
        b.putString("MODE", "");
        b.putString("CUSTVAR", "Patel");
        b.putString("TXNSUBTYPE", "1");
        b.putString("WALLET", "0");
        b.putString("SUCCESS_URL", "http://www.patelheggere.esy.es");

        b.putParcelable("RESPONSEMESSAGE", (Parcelable) resp);

        myIntent.putExtras(b);
        startActivityForResult(myIntent, 120);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {

        super.onActivityResult(requestCode, resultCode, data); try {

        Bundle bundle = data.getExtras();  transactionList = new ArrayList<Transaction>();

        transactionList = (ArrayList<Transaction>)bundle.getSerializable("DATA"); if(transactionList != null)
        {

            Toast.makeText(this, transactionList.get(0).getSTATUS()+"\n"+transactionList.get(0).getSTATUSMSG(),     Toast.LENGTH_LONG).show();

            System.out.println(""+transactionList.get(0).getSTATUS()); // 200= success
            System.out.println(""+transactionList.get(0).getMERCHANTKEY());
            System.out.println(""+transactionList.get(0).getMERCHANTPOSTTYPE());
            System.out.println(""+transactionList.get(0).getSTATUSMSG()); // success or fail
            System.out.println(""+transactionList.get(0).getTRANSACTIONAMT());
            System.out.println(""+transactionList.get(0).getTXN_MODE());
            System.out.println(""+transactionList.get(0).getMERCHANTTRANSACTIONID()); // order id System.out.println(""+transactionList.get(0).getSECUREHASH());
            System.out.println(""+transactionList.get(0).getCUSTOMVAR());
        } }
    catch (Exception e)
    {  e.printStackTrace(); }
    }
}
