package com.dof.orderingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton radioButton, radioButtonFlavor, radioButtonTopping;
    EditText message;
    Button btn_proceed, btn_reset;
    RadioGroup radioShapeGroup, radioFlavorGroup, radioToppingsGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioShapeGroup = findViewById(R.id.radio);
        radioFlavorGroup = findViewById(R.id.radio2);
        radioToppingsGroup = findViewById(R.id.radio3);
        message = findViewById(R.id.message);
        btn_proceed = findViewById(R.id.btn_proceed);
        btn_reset = findViewById(R.id.btn_reset);

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());

            }
        });


        btn_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedID = radioShapeGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectedID);
                int selectedIDFlavor = radioFlavorGroup.getCheckedRadioButtonId();
                radioButtonFlavor = findViewById(selectedIDFlavor);
                int selectedIDToppings = radioToppingsGroup.getCheckedRadioButtonId();
                radioButtonTopping = findViewById(selectedIDToppings);

                String dialogMessage = "Congratulations, You created your Cake! \n\nYour ordered shape is: " + radioButton.getText() +"\n"+
                "Your Flavor: " + radioButtonFlavor.getText() +"\n"+ "Your Toppings: " + radioButtonTopping.getText()+ "\n" +
                        "Your Message is: " + message.getText();

                AlertDialog.Builder messageDialog = new AlertDialog.Builder(MainActivity.this);
                messageDialog.setMessage(dialogMessage);
                messageDialog.setPositiveButton("Got it", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       finish();
                       startActivity(getIntent());
                    }
                });
                AlertDialog dialog = messageDialog.create();
                dialog.show();
            }
        });


    }
    }
