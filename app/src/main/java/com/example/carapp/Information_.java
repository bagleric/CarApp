package com.example.carapp;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;


public class Information_ extends AppCompatActivity{

    public static final String PREFS_NAME = "MyPrefsFile";

     String make;
     String model;
     String year;

     String Odometer;
     String licensePlateNumber;

     String vinNumber;
     String InsuranceName;

     String PhoneNumber;
     String PolicyNumber;

     String policyStartDate;
     String policyEndDate;

    String CompanyName;
    String RoadSidePhone;
    String RoadEndDate;
    String RoadPolicyNum;
    List<EditText> editTextArray = new ArrayList<EditText>();
    List<String> StrArray = new ArrayList<String>();
    List<Object> StringArray = new ArrayList<Object>(StrArray);

    private static final String TAG = Information_.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInsuranceState) {
        super.onCreate(savedInsuranceState);
        setContentView(R.layout.activity_information_);
        //this opens shared preferences, and sets all the information values for the user
        SharedPreferences  preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            make = preferences.getString("makeOfCar", "");
            model = preferences.getString("modelOfCar", "");
            year = preferences.getString("yearOfCar", "");
            Odometer = preferences.getString("CarOdometer", GetOdometer()); //Getting string
            licensePlateNumber = preferences.getString("CarlicensePlateNumber", ""); //Getting string
            vinNumber = preferences.getString("CarVinNumber", ""); //Getting string
            InsuranceName = preferences.getString("CarInsuranceName", ""); //Getting string
            PhoneNumber = preferences.getString("PhoneNumber", ""); //Getting string
            PolicyNumber = preferences.getString("CarPolicyNumber", ""); //Getting string
            policyStartDate = preferences.getString("CarpolicyStartDate", ""); //Getting string
            policyEndDate = preferences.getString("CarpolicyEndDate", ""); //Getting string
            CompanyName = preferences.getString("RoadSideCompanyName", "");
            RoadSidePhone = preferences.getString("RoadSidePhoneNum", "");
            RoadEndDate = preferences.getString("RoadSideEndDate", "");
            RoadPolicyNum = preferences.getString("RoadSidePolicyNum", "");
        Log.d("Making sure array =====", make);//tests
        Log.d(TAG, "set Content View " + make);

       EditText MK = (EditText) findViewById(R.id.Make);//this sets an array for ease of use later
        editTextArray.add(MK);
        EditText MDL = (EditText) findViewById(R.id.Model);
        editTextArray.add(MDL);
        EditText YR = (EditText) findViewById(R.id.Year);
        editTextArray.add(YR);
        EditText ODOM = (EditText) findViewById(R.id.Odometer);
        editTextArray.add(ODOM);
        EditText LPN = (EditText) findViewById(R.id.License);
        editTextArray.add(LPN);
        EditText VN = (EditText) findViewById(R.id.vinNum);
        editTextArray.add(VN);
        EditText INM = (EditText) findViewById(R.id.IName);
        editTextArray.add(INM);
        EditText PHN = (EditText) findViewById(R.id.Phone);
        editTextArray.add(PHN);
        EditText P = (EditText) findViewById(R.id.Policy);
        editTextArray.add(P);
        EditText EFD = (EditText) findViewById(R.id.effectiveDate);
        editTextArray.add(EFD);
        EditText END = (EditText) findViewById(R.id.EndDate);
        editTextArray.add(END);
        EditText CN = (EditText) findViewById(R.id.CompanyName);
        editTextArray.add(CN);
        EditText RSP = (EditText) findViewById(R.id.RoadSidePhone);
        editTextArray.add(RSP);
        EditText RED = (EditText) findViewById(R.id.RoadEndDate);
        editTextArray.add(RED);
        EditText PN = (EditText) findViewById(R.id.PolicyNum);
        editTextArray.add(PN);
        StringArray.add(make);//same here for ease of use later
        StringArray.add(model);
        StringArray.add(year);
        StringArray.add(Odometer);
        StringArray.add(licensePlateNumber);
        StringArray.add(vinNumber);
        StringArray.add(InsuranceName);
        StringArray.add(PhoneNumber);
        StringArray.add(PolicyNumber);
        StringArray.add(policyStartDate);
        StringArray.add(policyEndDate);
        StringArray.add(CompanyName);
        StringArray.add(RoadSidePhone);
        StringArray.add(RoadEndDate);
        StringArray.add(RoadPolicyNum);

        //this changes the value of each editText field so the user can see what is alread there
        for (int i = 0; i < editTextArray.size(); i++) {
            if (StringArray.get(i) != null) {
                Log.d(TAG, "StringArray1[]===== " + StringArray.get(i).toString());
                Log.d(TAG, "editTextArray1.get()=======================" + editTextArray.get(i).getText().toString());
                if (!StringArray.get(i).equals("")) {
                    editTextArray.get(i).setHint(StringArray.get(i).toString());
                }
            }
        }
        //button object, and listener
        Button buttonTire = (Button) findViewById(R.id.submitButton);
        buttonTire.setOnClickListener(submitListener);
    }
     ///listens for a button click
    private View.OnClickListener submitListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //sets all nonblank data fields into the array
            for (int i = 0; i < editTextArray.size(); i++) {
                if (editTextArray.get(i) != null) {
                    if (!editTextArray.get(i).getText().toString().equals(""))
                        StringArray.set(i, valueOf(editTextArray.get(i).getText().toString()));
                }
            }

            //editor object for shared preferences
            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
            //set the array for saving in shared preferences
            editor.putString("makeOfCar", StringArray.get(0).toString()); //Storing string
            editor.putString("yearOfCar", StringArray.get(1).toString()); //Storing string
            editor.putString("modelOfCar", StringArray.get(2).toString()); //Storing string
            if(StringArray.get(3) != null)
            editor.putString("CarOdometer", StringArray.get(3).toString()); //Storing string
            editor.putString("CarVinNumber", StringArray.get(4).toString()); //Storing string
            editor.putString("CarlicensePlateNumber", StringArray.get(5).toString()); //Storing string
            editor.putString("CarInsuranceName",StringArray.get(6).toString()); //Storing string
            editor.putString("PhoneNumber", StringArray.get(7).toString()); //Storing string
            editor.putString("CarPolicyNumber", StringArray.get(8).toString()); //Storing string
            editor.putString("CarpolicyStartDate", StringArray.get(9).toString()); //Storing string
            editor.putString("CarpolicyEndDate", StringArray.get(10).toString()); //Storing string
            editor.putString("RoadSideCompanyName", StringArray.get(11).toString());
            editor.putString("RoadSidePhoneNum", StringArray.get(12).toString());
            editor.putString("RoadSideEndDate", StringArray.get(13).toString());
            editor.putString("RoadSidePolicyNum", StringArray.get(14).toString());
            //commit the saves
            editor.commit();
            //end this activity
            finish();
         }
    };

        //getters if needed
        public String GetMake() {
        return make;
    }

        public String GetModel() {
        return model;
    }

        public String GetYear() {
        return year;
    }

        public String GetOdometer() {
        return Odometer;
    }

        public String GetNumInsurance() {
        return licensePlateNumber;
    }

        public String GetVinNumber() {
        return vinNumber;
    }

        public String GetInsuranceName() {
        return InsuranceName;
    }

        public String GetInsurancePhoneNumber() {
        return PhoneNumber;
    }

        public String GetPolicyNumber() {
        return PolicyNumber;
    }

        public String GetPolicyStartDate() {return policyStartDate;}

        public String GetPolicyEndDate() {return policyEndDate;}

        public String GetCompanyName() {
        return CompanyName;
    }

        public String GetRoadSidePhone() {
        return RoadSidePhone;
    }

        public String GetRoadEndDate() {return RoadEndDate;}

        public String GetRoadPolicyNum() {return RoadPolicyNum;}
    //setters if needed

    public String setMake(String mka) {return this.make = mka; }

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

    public String setCompanyName(String CN) { return this.CompanyName = CN;}

    public String setRoadSidePhone(String RSP) { return this.RoadSidePhone = RSP;}

    public String setRoadEndDate(String RED) { return this.RoadEndDate = RED;}

    public String setRoadPolicyNum(String RPN) { return this.RoadPolicyNum = RPN;}
}
