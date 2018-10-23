package com.dam.christian.g24_entrega;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //-------------------Define vars---------------------
    boolean isColor = true;
    Button buttonWhiteRed, buttonTextRed;
    TextView disableEnableText, txtclicklargo, txtcount;
    RelativeLayout layout;
    CheckBox checkShowText;
    RatingBar ratingBar;
    RadioGroup radioGroup;

    //Method onCreate
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-----------Declare vars---------------
        buttonWhiteRed = findViewById(R.id.frojo);

        layout = findViewById(R.id.lysquare);

        buttonTextRed = findViewById(R.id.lnegras);

        checkShowText = findViewById(R.id.ckb);

        disableEnableText = findViewById(R.id.msgOculto);

        txtclicklargo = findViewById(R.id.txtclicklargo);

        ratingBar = findViewById(R.id.rating_bar);

        txtcount = findViewById(R.id.count);

        radioGroup = findViewById(R.id.rdgroup);

        //Method created for Background Color.
        buttonWhiteRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                    if(isColor){
                        buttonWhiteRed.setText(R.string.frojo);
                        layout.setBackgroundColor(Color.RED);
                        isColor = false;
                    }
                    else{
                        buttonWhiteRed.setText(R.string.fblanco);
                        layout.setBackgroundColor(Color.WHITE);
                        isColor = true;
                    }
            }
        });

        //Method created for Text Color.
        buttonTextRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                if(isColor){
                    buttonTextRed.setTextColor(Color.RED);
                    buttonTextRed.setText(R.string.lrojas);
                    isColor = false;
                }
                else{
                    buttonTextRed.setTextColor(Color.BLACK);
                    buttonTextRed.setText(R.string.lnegras);
                    isColor = true;
                }
            }
        });

        //Method created for disable or enable text when check the box.
        checkShowText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                if(checkShowText.isChecked()){
                    disableEnableText.setVisibility(View.VISIBLE);
                }else{
                    disableEnableText.setVisibility(View.INVISIBLE);
                }
            }
        });

        //Method created for show message when long Click.
        txtclicklargo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick (View v) {
                Toast.makeText(getBaseContext(),R.string.msgclicklong, Toast.LENGTH_LONG).show();
                return true;
            }
        });

        //Method created for assess how many starts do you consider
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged (RatingBar ratingBar, float rating, boolean fromUser) {
                int ratingInt = Math.round(rating);
                txtcount.setText("["+String.valueOf(ratingInt)+"/5]");
            }
        });

        //Method resize the long click Text.
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged (RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rd10:
                        txtclicklargo.setTextColor(Color.GREEN);
                        txtclicklargo.setTextSize((float) 10);
                        break;
                    case R.id.rd20:
                        txtclicklargo.setTextColor(Color.CYAN);
                        txtclicklargo.setTextSize((float) 20);
                        break;
                    case R.id.rd30:
                        txtclicklargo.setTextColor(Color.BLUE);
                        txtclicklargo.setTextSize((float) 30);
                        break;
                    case R.id.rd40:
                        txtclicklargo.setTextColor(Color.RED);
                        txtclicklargo.setTextSize((float) 40);
                        break;
                    case R.id.rd50:
                        txtclicklargo.setTextColor(Color.GRAY);
                        txtclicklargo.setTextSize((float) 50);
                        break;
                }
            }
        });
    }
}
