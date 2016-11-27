package com.example.carapp;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.carapp.R.id.activity_main;

public class Information_ extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPrefsFile";

     String make;
     String model;
     String year;

     String Odometer;
     String vinNumber;

     String licensePlateNumber;
     String InsuranceName;

     String PhoneNumber;
     String PolicyNumber;

     String policyStartDate;
     String policyEndDate;
    private static final String TAG = Information_.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInsuranceState) {
        super.onCreate(savedInsuranceState);
        setContentView(R.layout.activity_information_);

        SharedPreferences  preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        make = preferences.getString("makeOfCar", "");
        year = preferences.getString("yearOfCar", "");
        model = preferences.getString("modelOfCar", "");
        Odometer = preferences.getString("CarOdometer", ""); //Storing string
        vinNumber = preferences.getString("CarVinNumber", ""); //Storing string
        licensePlateNumber = preferences.getString("CarlicensePlateNumber",""); //Storing string
        InsuranceName = preferences.getString("CarInsuranceName",""); //Storing string
        PhoneNumber = preferences.getString("PhoneNumber", ""); //Storing string
        PolicyNumber = preferences.getString("CarPolicyNumber", ""); //Storing string
        policyStartDate = preferences.getString("CarpolicyStartDate", ""); //Storing string
        policyEndDate = preferences.getString("CarpolicyEndDate", ""); //Storing string

        Log.d(TAG, "set Content View " + make);
        EditText MK = (EditText) findViewById(R.id.Make);
        EditText YR = (EditText) findViewById(R.id.Year);
        EditText MDL = (EditText) findViewById(R.id.Model);
        EditText ODOM = (EditText) findViewById(R.id.Odometer);
        EditText LPN = (EditText) findViewById(R.id.License);
        EditText INM = (EditText) findViewById(R.id.IName);
        EditText PHN = (EditText) findViewById(R.id.Phone);
        EditText END = (EditText) findViewById(R.id.EndDate);
        EditText EFD = (EditText) findViewById(R.id.effectiveDate);
        EditText P = (EditText) findViewById(R.id.Policy);
        EditText VN = (EditText) findViewById(R.id.vinNum);

        MK.setHint(make);
        YR.setHint(year);
        MDL.setHint(model);
        ODOM.setHint(Odometer);
        LPN.setHint(licensePlateNumber);
        INM.setHint(InsuranceName);
        PHN.setHint(PhoneNumber);
        END.setHint(policyEndDate);
        EFD.setHint(policyStartDate);
        P.setHint(PolicyNumber);
        VN.setHint(vinNumber);

//        if (savedInsuranceState != null) {
////            SharedPreferences  preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
////            make = preferences.getString(PREFS_NAME, make); // getting string
////            Log.d(TAG, "=====" + make);
////            EditText MK = (EditText) findViewById(R.id.Make);
////            StringBuilder sb = new StringBuilder();
////            sb.append(MK);
////            String strI = sb.toString();
////            MK.setHint(strI);
//
//        } else {
//            Log.d(TAG, "onCreate() No saved state available");
//        }
//
        Button buttonTire = (Button) findViewById(R.id.submitButton);
        buttonTire.setOnClickListener(submitListener);
    }

    private View.OnClickListener submitListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            EditText MK = (EditText) findViewById(R.id.Make);
            EditText YR = (EditText) findViewById(R.id.Year);
            EditText MDL = (EditText) findViewById(R.id.Model);
            EditText ODOM = (EditText) findViewById(R.id.Odometer);
            EditText LPN = (EditText) findViewById(R.id.License);
            EditText INM = (EditText) findViewById(R.id.IName);
            EditText PHN = (EditText) findViewById(R.id.Phone);
            EditText END = (EditText) findViewById(R.id.EndDate);
            EditText EFD = (EditText) findViewById(R.id.effectiveDate);
            EditText P = (EditText) findViewById(R.id.Policy);
            EditText VN = (EditText) findViewById(R.id.vinNum);

            Log.d(TAG, "MK.getHint().toString()===== " + MK.getHint().toString());

            Log.d(TAG, "MK.getText().toString()===== " + MK.getText().toString());

            if(!MK.getText().toString().equals(""))
                    make = MK.getText().toString();
            if(!YR.getText().toString().equals(""))
                year = YR.getText().toString();
            if(!MDL.getText().toString().equals(""))
                model = MDL.getText().toString();
            if(!ODOM.getText().toString().equals(""))
                Odometer = ODOM.getText().toString();
            if(!VN.getText().toString().equals(""))
                vinNumber = VN.getText().toString();
            if(!LPN.getText().toString().equals(""))
                licensePlateNumber = LPN.getText().toString();
            if(!INM.getText().toString().equals(""))
                InsuranceName = INM.getText().toString();
            if(!PHN.getText().toString().equals(""))
                PhoneNumber = PHN.getText().toString();
            if(!P.getText().toString().equals(""))
                PolicyNumber = P.getText().toString();
            if(!EFD.getText().toString().equals(""))
                policyStartDate = EFD.getText().toString();
            if(!END.getText().toString().equals(""))
                policyEndDate = END.getText().toString();

            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
            editor.putString("makeOfCar", make); //Storing string
            editor.putString("yearOfCar", year); //Storing string
            editor.putString("modelOfCar", model); //Storing string
            editor.putString("CarOdometer", Odometer); //Storing string
            editor.putString("CarVinNumber", vinNumber); //Storing string
            editor.putString("CarlicensePlateNumber",licensePlateNumber); //Storing string
            editor.putString("CarInsuranceName",InsuranceName); //Storing string
            editor.putString("PhoneNumber", PhoneNumber); //Storing string
            editor.putString("CarPolicyNumber", PolicyNumber); //Storing string
            editor.putString("CarpolicyStartDate", policyStartDate); //Storing string
            editor.putString("CarpolicyEndDate", policyEndDate); //Storing string
            editor.commit();

            finish();
         }
    };

        public String getMake() {
        return make;
    }

        public String getModel() {
        return model;
    }

        public String getYear() {
        return year;
    }

        public String getOdometer() {
        return Odometer;
    }

        public String getNumInsurance() {
        return licensePlateNumber;
    }

        public String GetVinNumber() {
        return vinNumber;
    }

        public String getInsuranceName() {
        return InsuranceName;
    }

        public String getInsurancePhoneNumber() {
        return PhoneNumber;
    }

        public String getPolicyNumber() {
        return PolicyNumber;
    }

        public String GetPolicyStartDate() {return policyStartDate;}

        public String GetPolicyEndDate() {return policyEndDate;}
    /////////////////////////////////////////////////////////////////////////////
    public String setMake(String mka) {
        Log.d(TAG, "=====setMake===" + mka);
        return this.make = mka; }

    public String setModel(String mdl) { return this.model = mdl; }

    public String setYear(String yr) {
        return this.year = yr;
    }

    public String setOdometer(String od) {
        return this.Odometer = od;
    }

    public String setNumInsurance(String LPN) { return this.licensePlateNumber = LPN; }

    public String setVinNumber(String VN) {
        return this.vinNumber = VN;
    }

    public String setInsuranceName(String INM) { return this.InsuranceName = INM; }

    public String setInsurancePhoneNumber(String PN) {
        return this.PhoneNumber = PN;
    }

    public String setPolicyNumber(String PLCYNMB) { return this.PolicyNumber = PLCYNMB; }

    public String setPolicyStartDate(String PSD) {return this.policyStartDate = PSD;}

    public String setPolicyEndDate(String PED) {return this.policyEndDate = PED;}

}


//            Log.d(TAG, "onCreate() Restoring previous state");
//            TextView MK = (TextView) findViewById(R.id.Make);
//            TextView YR = (TextView) findViewById(R.id.Year);
//            TextView ODOM = (TextView) findViewById(R.id.Odometer);
//            TextView LPN = (TextView) findViewById(R.id.License);
//            TextView INM = (TextView) findViewById(R.id.IName);
//            TextView PHN = (TextView) findViewById(R.id.Phone);
//            TextView MDL = (TextView) findViewById(R.id.Model);
//            TextView END = (TextView) findViewById(R.id.EndDate);
//            TextView EFD = (TextView) findViewById(R.id.effectiveDate);
//            TextView P = (TextView) findViewById(R.id.Policy);
//            TextView VN = (TextView) findViewById(R.id.vinNum);
//
//            MK.setHint(make);
//            YR.setHint(year);
//            ODOM.setHint(Odometer);
//            LPN.setHint(licensePlateNumber);
//            INM.setHint(InsuranceName);
//            PHN.setHint(PhoneNumber);
//            MDL.setHint(model);
//            END.setHint(policyEndDate);
//            EFD.setHint(policyStartDate);
//            P.setHint(PolicyNumber);
//            VN.setHint(vinNumber);
////////////////////////////////////////////////////////////////////
    //  Button button = (Button)findViewById(R.id.button);
    /////EditText mEdit1;
    //we need this just commented out for testing
//            ArrayList<EditText> message = new ArrayList<EditText>();
//            RelativeLayout activity_information_ = (RelativeLayout) findViewById( R.id.activity_information_);

//            for( int i = 0; i < activity_information_.getChildCount(); i++ )
//                if(activity_information_.getChildAt(i) instanceof EditText)
//                    message.add((EditText) activity_information_.getChildAt(i));
    /////TextView MK = (TextView) findViewById(R.id.Make);
    //here the program is grabbing the children textViews, but I need to correlate them with the setters
    ///// mEdit1 = (EditText) MK;
    // message.add(mEdit1);

    // setMake(mEdit1.toString());
//    EditText MK = (EditText) findViewById(R.id.Make);
//    setMake(MK.getText().toString());
//        StringBuilder sb = new StringBuilder();
//        sb.append(make);
//
//        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
//        editor.putString(PREFS_NAME, make); //Storing string
//        editor.commit();