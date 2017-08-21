package com.nestedmango.digitalschool;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText eCategory,eSchoolCode,eEmail,eAdress,eSchoolName,eContact,ePassword,otp;
    Spinner sSpinnnerSchoolType;
    Button btnRgister,btnRefresh;
 static String str=null;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eCategory=(EditText)findViewById(R.id.editTextCategory);
        eAdress=(EditText)findViewById(R.id.editTextAddress);
        eEmail=(EditText)findViewById(R.id.editTextEmail);
        eContact=(EditText)findViewById(R.id.editTextContact);
        ePassword=(EditText)findViewById(R.id.regPassword);
        eSchoolName=(EditText)findViewById(R.id.editTextSchoolName);
        eSchoolName=(EditText)findViewById(R.id.editTextSchoolName);



        sSpinnnerSchoolType=(Spinner)findViewById(R.id.spinnerSchoolType);

        btnRgister=(Button)findViewById(R.id.buttonRegister);
        btnRefresh=(Button)findViewById(R.id.buttonRefresh);

    btnRgister.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //When you click the button, Alert dialog will be showed

       /* Alert Dialog Code Start*/

                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle("Alert Dialog For OTP"); //Set Alert dialog title here
                alert.setMessage("Enter Your OTP"); //Message here

                // Set an EditText view to get user input
                final EditText input = new EditText(context);
                alert.setView(input);

                alert.setPositiveButton("ACTIVATE", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //You will get as string input data in this variable.
                        // here we convert the input to a string and show in a toast.
                        String srt = input.getEditableText().toString();
                        if(srt.equals("123")){
                            Intent i=new Intent(getApplication(),SchoolProfile.class);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(context, "Please Enter Right OTP!!", Toast.LENGTH_LONG).show();

                        }

                    } // End of onClick(DialogInterface dialog, int whichButton)
                }); //End of alert.setPositiveButton
                alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Canceled.
                        dialog.cancel();
                    }
                }); //End of alert.setNegativeButton
                AlertDialog alertDialog = alert.create();
                alertDialog.show();
       /* Alert Dialog Code End*/
            }

    });







    }
}
