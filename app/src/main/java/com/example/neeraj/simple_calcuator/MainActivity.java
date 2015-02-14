package com.example.neeraj.simple_calcuator;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private static final String INPUT_STRING = "INPUT_STRING";
    private static final String TOTAL_SUM = "TOTAL_SUM";

    // Variables used for functions.
    private int result;
    private String inputString;
    private String input = "";
    private String op = "";
    private int num1 = 0, num2 = 0, opCount = 0;

    TextView inputText;
    Button btnADD, btnSUB, btnEQL, btnCLEAR;
    Button btnZERO, btnONE, btnTWO, btnTHREE, btnFOUR, btnFIVE, btnSIX, btnSEVEN, btnEIGHT, btnNINE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            result = 0;
            inputString = "";
        } else {
            result = savedInstanceState.getInt(TOTAL_SUM);
            inputString = savedInstanceState.getString(INPUT_STRING);
        }

        inputText = (TextView) findViewById(R.id.inputEditText);
        btnZERO = (Button) findViewById(R.id.calc_btn0);
        btnONE = (Button) findViewById(R.id.calc_btn1);
        btnTWO = (Button) findViewById(R.id.calc_btn2);
        btnTHREE = (Button) findViewById(R.id.calc_btn3);
        btnFOUR = (Button) findViewById(R.id.calc_btn4);
        btnFIVE = (Button) findViewById(R.id.calc_btn5);
        btnSIX = (Button) findViewById(R.id.calc_btn6);
        btnSEVEN = (Button) findViewById(R.id.calc_btn7);
        btnEIGHT = (Button) findViewById(R.id.calc_btn8);
        btnNINE = (Button) findViewById(R.id.calc_btn9);
        btnADD = (Button) findViewById(R.id.calc_btnAdd);
        btnSUB = (Button) findViewById(R.id.calc_btnSub);
        btnCLEAR = (Button) findViewById(R.id.calc_btnBack);
        btnEQL = (Button) findViewById(R.id.calc_btnEql);

        btnZERO.setOnClickListener((View.OnClickListener) this);
        btnONE.setOnClickListener((View.OnClickListener) this);
        btnTWO.setOnClickListener((View.OnClickListener) this);
        btnTHREE.setOnClickListener((View.OnClickListener) this);
        btnFOUR.setOnClickListener((View.OnClickListener) this);
        btnFIVE.setOnClickListener((View.OnClickListener) this);
        btnSIX.setOnClickListener((View.OnClickListener) this);
        btnSEVEN.setOnClickListener((View.OnClickListener) this);
        btnEIGHT.setOnClickListener((View.OnClickListener) this);
        btnNINE.setOnClickListener((View.OnClickListener) this);
        btnADD.setOnClickListener((View.OnClickListener) this);
        btnSUB.setOnClickListener((View.OnClickListener) this);
        btnCLEAR.setOnClickListener((View.OnClickListener) this);
        btnEQL.setOnClickListener((View.OnClickListener) this);

    }

    // Event Listener for Button Clicks
    public void onClick(View view){
        switch (view.getId()){
            case R.id.calc_btn0 :
                input += btnZERO.getText().toString();
                inputText.setText(input);
                if(opCount >= 2) opCount = 1;
                break;

            case R.id.calc_btn1 :
                input += btnONE.getText().toString();
                inputText.setText(input);
                if(opCount >= 2) opCount = 1;
                break;

            case R.id.calc_btn2 :
                input += btnTWO.getText().toString();
                inputText.setText(input);
                if(opCount >= 2) opCount = 1;
                break;

            case R.id.calc_btn3 :
                input += btnTHREE.getText().toString();
                inputText.setText(input);
                if(opCount >= 2) opCount = 1;
                break;

            case R.id.calc_btn4 :
                input += btnFOUR.getText().toString();
                inputText.setText(input);
                if(opCount >= 2) opCount = 1;
                break;

            case R.id.calc_btn5 :
                input += btnFIVE.getText().toString();
                inputText.setText(input);
                if(opCount >= 2) opCount = 1;
                break;

            case R.id.calc_btn6 :
                input += btnSIX.getText().toString();
                inputText.setText(input);
                if(opCount >= 2) opCount = 1;
                break;

            case R.id.calc_btn7 :
                input += btnSEVEN.getText().toString();
                inputText.setText(input);
                if(opCount >= 2) opCount = 1;
                break;

            case R.id.calc_btn8 :
                input += btnEIGHT.getText().toString();
                inputText.setText(input);
                if(opCount >= 2) opCount = 1;
                break;

            case R.id.calc_btn9 :
                input += btnNINE.getText().toString();
                inputText.setText(input);
                if(opCount >= 2) opCount = 1;
                break;

            case R.id.calc_btnAdd :
                input = input.replaceFirst("^0+(?!$)", "");
                System.out.println("Op Pressed");
                opCount++;
                if(opCount == 1){
                    if(input == "")
                        num1 = 0;
                    else
                        num1 = Integer.parseInt(input);
                    input = "";
                    inputText.setText(""+num1);
                } else {
                    if(op != "" && opCount == 2) {
                        if(input == ""){
                            // nothing
                            opCount = 1;
                        } else {
                            num2 = Integer.parseInt(input);
                            input = "";
                            num1 = performOperation();
                            inputText.setText("" + num1);
                        }
                    } else {
                        opCount = 3;
                        System.out.println("Op + pressed Twice");
                    }
                }
                op = "Add";
                break;

            case R.id.calc_btnSub :
                input = input.replaceFirst("^0+(?!$)", "");
                opCount++;
                System.out.println("Op Pressed");
                if(opCount == 1){
                    if(input == "")
                        num1 = 0;
                    else
                        num1 = Integer.parseInt(input);
                    input = "";
                    inputText.setText(""+num1);
                } else {
                    if(op != "" && opCount == 2) {
                        if(input != "") {
                            num2 = Integer.parseInt(input);
                            input = "";
                            num1 = performOperation();
                            inputText.setText("" + num1);
                        } else {
                            num1 = 0;
                            opCount = 1;
                        }
                    } else {
                        opCount = 3;
                        System.out.println("Op - pressed Twice");
                    }
                }
                op = "Sub";
                break;

            case R.id.calc_btnEql :
                if(num2 == 0 || input == ""){
                    Toast.makeText(this, "PLease Enter Second Operand..", Toast.LENGTH_LONG).show();
                } else {
                    input = input.replaceFirst("^0+(?!$)", "");
                    num2 = Integer.parseInt(input);
                    num1 = performOperation();
                    inputText.setText(Integer.toString(num1));
                    op = "";
                    opCount = 1;
                    input = "";
                    num2 = 0;
                }
                break;

            case R.id.calc_btnBack :    // To reset calculator Values
                input = "";
                op = "";
                num1 = 0;
                num2 = 0;
                opCount = 0;
                inputText.setText(input);
                break;

            default:
                inputText.setText("");
        }
    }

    // Method calls for Mathematical Operations.
    public int performOperation(){
        switch(op){
            case "Add":
                result = num1 + num2;
                return result;

            case "Sub" :
                result = num1 - num2;
                return result;

            default:
                return 0;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
