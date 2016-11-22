package com.hajalibayram.testappdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button button0;
    Button button1;
    Button button2;
    Button button3;

    ArrayList<ArrayList<Integer>> suallar = new ArrayList<>();
    ArrayList<Integer> heller = new ArrayList<>();

    ArrayList<Integer> heller1 = new ArrayList<>();
    ArrayList<Integer> heller2 = new ArrayList<>();
    ArrayList<Integer> heller3 = new ArrayList<>();
    ArrayList<Integer> heller4 = new ArrayList<>();
    
    Integer[] cavablar = new Integer[4];

    int correctAnsLoc;
    int incorrectAnsLoc;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heller.add(10);
        heller.add(15);
        heller.add(25);
        heller.add(20);
        suallar.add(heller);

        heller1.add(0,1);
        heller1.add(1,2);
        heller1.add(2,3);
        heller1.add(3,4);
        suallar.add(heller1);

        heller2.add(0,12);
        heller2.add(1,22);
        heller2.add(2,32);
        heller2.add(3,42);
        suallar.add(heller2);

        heller3.add(0,19);
        heller3.add(1,29);
        heller3.add(2,39);
        heller3.add(3,49);
        suallar.add(heller3);

        heller4.add(0,146);
        heller4.add(1,246);
        heller4.add(2,346);
        heller4.add(3,446);
        suallar.add(heller4);



        for (int i = 0; i<suallar.size(); i++) {
            for(int j = 0; j<heller.size();j++){
                Log.e("Suallar!!!" ,i+" - "+j+": "+ String.valueOf(suallar.get(i).get(j)));
            }
        }




//        Log.e("Suallar ", Integer.toString((Integer) suallar.get(0).get(0)));
//        Log.e("Suallar", Integer.toString((Integer) suallar.get(1).get(0)));


        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);


        random = new Random();

        generate();
    }

    public void onButtonClick(View view) {

        if (view.getTag().toString().equals(Integer.toString(correctAnsLoc)))
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();

        generate();
    }

    public void generate() {


        ArrayList<Integer> tempList = new ArrayList<>();
        tempList.addAll(suallar.get(random.nextInt(5)));
        int c = 1;
        correctAnsLoc = random.nextInt(4);
//        Log.e("CorrectAnswerLocation", Integer.toString(correctAnsLoc));
        for (int i = 0; i < 4; i++) {
            if (i == correctAnsLoc) {
//                Log.e("CorrectAnswer in for ", Integer.toString(i) + Integer.toString(correctAnsLoc));
                cavablar[i] = tempList.get(0);//test
            } else {
                incorrectAnsLoc = random.nextInt(3)+1;
                while (incorrectAnsLoc == correctAnsLoc)
                    incorrectAnsLoc = random.nextInt(3)+1;
                cavablar[i] = tempList.get(c++);

//                Log.e("IncorrectAnswer in for ", Integer.toString(i) + Integer.toString(incorrectAnsLoc));
            }

        }

        button0.setText(Integer.toString(cavablar[0]));
        button1.setText(Integer.toString(cavablar[1]));
        button2.setText(Integer.toString(cavablar[2]));
        button3.setText(Integer.toString(cavablar[3]));

    }
}
