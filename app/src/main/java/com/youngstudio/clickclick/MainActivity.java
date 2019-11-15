package com.youngstudio.clickclick;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



import java.util.Random;

public class MainActivity extends AppCompatActivity {




    TextView tv;
    ImageView iv;

    Button[] btns= new Button[12];

    int num = 0;

    int number=1;

    int[] arr= new int[12];

    Drawable[] backDrawable= new Drawable[12];
    Drawable[] backDrawable2= new Drawable[12];
    Drawable[] backDrawable3= new Drawable[12];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= findViewById(R.id.tv);
        iv= findViewById(R.id.iv);


        for(int i=0; i<12; i++){
            btns[i]= findViewById(R.id.btn01 + i);

            backDrawable[i] = getResources().getDrawable(R.drawable.cha01+i);

            backDrawable2[i] = getResources().getDrawable(R.drawable.num01+i);

            backDrawable3[i] = getResources().getDrawable(R.drawable.alpa01+i);


        }
    }//onCreate Method..

    public void clickRetry(View v){
        Random rnd= new Random();



        for(int i=0;i<12;i++){
            arr[i] = rnd.nextInt(12);
            for(int k=0;k<i;k++) {
                if (arr[i] == arr[k]) {
                    i--;
                    break;
                }
            }
        }//for

        for(int i=0;i<12;i++){
            try{
                if (num == 0 || num % 3 == 0) {
                    btns[i].setVisibility(View.VISIBLE);
                    btns[i].setText("");
                    btns[i].setTag(arr[i]);
                    btns[i].setTextColor(0xffff00ff);
                    btns[i].setBackground(backDrawable3[arr[i]]);

                }

                if (num == 1 || num % 3 == 1) {
                    btns[i].setVisibility(View.VISIBLE);
                    btns[i].setText("");
                    btns[i].setTag(arr[i]);
                    btns[i].setTextColor(0xffff00ff);
                    btns[i].setBackground(backDrawable2[arr[i]]);
                }

                if (num == 2 || num % 3 == 2) {
                    btns[i].setVisibility(View.VISIBLE);
                    btns[i].setText(arr[i]+"");
                    btns[i].setTag(arr[i]);
                    btns[i].setTextColor(0xffff00ff);
                    btns[i].setBackground(backDrawable[arr[i]]);
                }
            }catch(Exception e){   }
        }
        number=0;
        tv.setText("숫자를 순서대로 누르세요");
        iv.setEnabled(false);
    }

    public void clickBtn(View v){
        Button btn= (Button)v;//다운캐스팅

        String s= btn.getTag().toString();
        int n= Integer.parseInt(s);

        if( n == number ){
            btn.setTextColor(0x00FF0000); //ARGB
            btn.setBackgroundColor(Color.TRANSPARENT);

            number++;

            if(number>11){
                tv.setText("CLEAR!!!");
                num++;
                iv.setEnabled(true);
            }else{
                tv.setText("숫자를 순서대로 누르세요");
            }
        }
    }

    public void btn(View view) {
        Intent intent=new Intent(this,RewardedActivity.class);
        startActivity(intent);

    }
}//MainActivity class..
