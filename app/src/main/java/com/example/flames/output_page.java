package com.example.flames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class output_page extends AppCompatActivity {
    TextView relationship;
    TextView TagLine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_page);
        relationship=findViewById(R.id.textView3);
        TagLine=findViewById(R.id.textView2);
        setTagLine(input_page.String_Relation);
        relationship.setText(input_page.String_Relation);
        relationship.setTextSize(50);
        relationship.setTextColor(this.getResources().getColor(R.color.white));

    }

    //change
    public void onClickOfTryAgainButton(View v){
        Intent i=new Intent(this,input_page.class);
        startActivity(i);
    }

    public void setTagLine(String Str){
      String str1="";
      int size=0;
      if (Str.contains("FRIENDS")){
          str1="        You Both Are ";
          size=40;
      }else if (Str.contains("LOVERS")){
          str1="        You Both Are ";
          size=40;
      }else if (Str.contains("AFFECTION")){
           str1="             It's Just";
           size=40;
      }else if (Str.contains("MARRIAGE")){
          str1="        Soon is Your ";
          size=40;
      }else if (Str.contains("ENEMIES")){
           str1="        You Both Are ";
           size=40;
      }else if (Str.contains("SISTER")){
           str1="      Your Relation Is \n            Brother \n                  &";
          size=40;
      }else if (Str.contains("CAN'T FIND")){
           str1="              Sorry...";
          size=40;
      }
        TagLine.setText(str1);
        TagLine.setTextSize(size);
    }
}