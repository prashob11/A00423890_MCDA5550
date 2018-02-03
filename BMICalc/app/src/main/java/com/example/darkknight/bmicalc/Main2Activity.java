package com.example.darkknight.bmicalc;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onCLickBmi (View view){
        //gets the height
        EditText height=(EditText) findViewById(R.id.textHeight);
        String heightValue = height.getText().toString();
        Double heightAsInt = Double.parseDouble(heightValue);
        //System.out.println("here is the height"+heightAsInt);

        EditText weight=(EditText) findViewById(R.id.textWeight);
        String weightValue = weight.getText().toString();
        Double weightVal = Double.parseDouble(weightValue);

        //Repeat for weight

        Double calc = (weightVal/(heightAsInt*heightAsInt));
        TextView result = (TextView) findViewById(R.id.textViewBMI);


        //use DecimalFormat("0.##") to limit to 2 decimal places
        DecimalFormat df = new DecimalFormat("#.00");
        result.setText(df.format(calc).toString());
    }
    public void onClickNamePopulate(View view){
        InClassDatabaseHelper helper = new InClassDatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        //run a query
        Cursor cursor = db.query(InClassDatabaseHelper.TABLE_NAME,new String[]
                {"NAME","PASSWORD","DATE"},
                null,null,null,null,null); //

        if (cursor.moveToFirst()){
            String name = cursor.getString(0);

            TextView results = (TextView) findViewById(R.id.textViewBMI);
            results.setText(name);
        }
        cursor.close(); //cleanup
        db.close(); //cleanup
    }

}


