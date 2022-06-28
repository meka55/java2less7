package com.example.java2less7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isNew = true;
    TextView nol_tv;
    String operator = "";
    String oldNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nol_tv = findViewById(R.id.nol_tv);
    }

    public void clickNumber(View view) {
        if (isNew)
            nol_tv.setText("");
        isNew = false;
        String number = nol_tv.getText().toString();
        switch (view.getId()){

            case R.id.oneeBtn:
                if (zeroIsFirst(number) && number.length()==1){
                    number= number.substring(1);
                }
                number = number+"1";
                break;

            case R.id.twoBtn:
                if (zeroIsFirst(number) && number.length()==1){
                    number= number.substring(1);
                }
                number = number+"2";
                break;

            case R.id.threeBtn:
                if (zeroIsFirst(number) && number.length()==1){
                    number= number.substring(1);
                }
                number = number+"3";
                break;

            case R.id.fourBtn:
                if (zeroIsFirst(number) && number.length()==1){
                    number= number.substring(1);
                }
                number = number+"4";
                break;

            case R.id.fiveBtn:
                if (zeroIsFirst(number) && number.length()==1){
                    number= number.substring(1);
                }
                number = number+"5";
                break;

            case R.id.sixBtn:
                if (zeroIsFirst(number) && number.length()==1){
                    number= number.substring(1);
                }
                number = number+"6";
                break;

            case R.id.sevenBtn:
                if (zeroIsFirst(number) && number.length()==1){
                    number= number.substring(1);
                }
                number = number+"7";
                break;

            case R.id.eightBtn:
                if (zeroIsFirst(number) && number.length()==1){
                    number= number.substring(1);
                }
                number = number+"8";
                break;

            case R.id.nineBtn:
                if (zeroIsFirst(number) && number.length()==1){
                    number= number.substring(1);
                }
                number = number+"9";
                break;


            case R.id.zeroBtn:
                if(zeroIsFirst(number) && number.length()==1) {
                    number = "0";

                } else {
                    number = number + "0";
                }
                break;


            case R.id.dotBtn:
                if (dotIsPresent(number)){
                }else {

                number = number+".";
                }
                break;

            case R.id.plusMinusBtn:
                   if (numberIsZero(number)){
                       number = "0";
                   }else {
                       if (minusIsPresent(number)) {
                           number = number.substring(1);
                       } else {
                           number = "-" + number;
                       }
                   }
                break;

        }
        nol_tv.setText(number);
    }
    private boolean zeroIsFirst(String number){
        if (number.equals("")){
            return true;
        }
        if (number.charAt(0)=='0'){
            return  true;
        }else {
                return false;
        }
    }

    private boolean numberIsZero(String number) {
        if (number.equals("0")|| number.equals("")){
            return true;
        }else {
            return false;
        }
    }

    public boolean minusIsPresent(String number) {
        if (number.charAt(0) == '-'){
            return true;
        }else {
            return false;
        }
    }

    public void operation(View view) {
        isNew = true;
        oldNumber = nol_tv.getText().toString();
        switch (view.getId()){
            case R.id.minusBtn: operator = "-";
            break;
            case R.id.plusBtn:operator = "+";
            break;
            case R.id.delenieBtn:operator = "/";
            break;
            case R.id.umnojenieBtn:operator = "*";
            break;
        }
    }

    public void clickEquals(View view) {
        String newNumber = nol_tv.getText().toString();
        Double result = 0.0;
        if (newNumber.equals("0") && operator=="/"
                || newNumber.equals("0.0 ") && operator=="/"
                || newNumber.equals("")&& operator=="/"){
            Toast.makeText(MainActivity.this, R.string.toast_massage, Toast.LENGTH_SHORT).show();
        }else {
            switch (operator) {
                case "-":
                    result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                    break;
                case "+":
                    result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                    break;
                case "/":
                    result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                    break;
                case "*":
                    result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                    break;
            }
            nol_tv.setText(result + "");
        }
    }

    public void acClick(View view) {
        nol_tv.setText("0");
        isNew=true;
    }

    public  boolean dotIsPresent (String number){
        if (number.indexOf(".") ==-1  ){
            return false;
        }else {
            return true;
        }
    }

    public void clickProsent(View view) {
        if (operator == ""){
            String number = nol_tv.getText().toString();
            double temp = Double.parseDouble(number)/100;
            number = temp+"";
            nol_tv.setText(number);
        }else {
            Double result = 0.0;
            String newNumber = nol_tv.getText().toString();
            switch (operator) {
                case "+":
                    result = Double.parseDouble(oldNumber) + Double.parseDouble(oldNumber) * Double.parseDouble(newNumber)/100;
                    break;
                case "-":
                    result = Double.parseDouble(oldNumber) - Double.parseDouble(oldNumber) * Double.parseDouble(newNumber)/100;
                    break;
                case "*":
                    result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber)/100;
                    break;
                case "/":
                    result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber)*100;
                    break;
                }
                nol_tv.setText(result+"");
                operator ="";
        }
    }




}
