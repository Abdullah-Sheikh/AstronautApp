package pk.nu.edu.astronautapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText nameEdittext, passwordEdittext;


    SharedPreferences sharedPreferences ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);


        // binding with xml
        nameEdittext = (EditText) findViewById(R.id.name_edittext);
        passwordEdittext = (EditText) findViewById(R.id.password_edittext);





    }

    private void LoginUser(String email , String password)
    {


        Task<AuthResult> resultTask =  FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password);

        // FirebaseAuth.getInstance().createUserWithEmailAndPassword("test1234@gmail.com","123456");
        resultTask.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

            }
        });
        resultTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, "Login failure Error:"+e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        resultTask.addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                sharedPreferences = getSharedPreferences("LoginCred", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email",email);
                editor.putString("password",password);
                editor.commit();
                Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });



    }




    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences1 =getSharedPreferences("LogiCred",0);
        String email = sharedPreferences1.getString("email","");
        String password=sharedPreferences1.getString("password","");


        if(email!=""&&password!="") {
            Task<AuthResult> resultTask = FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password);

            // FirebaseAuth.getInstance().createUserWithEmailAndPassword("test1234@gmail.com","123456");
            resultTask.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                }
            });
            resultTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
            resultTask.addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {

                    Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }

        }






    public void gotoMain(View view) {

        // check whether user fill the edittext or not
        if (nameEdittext.getText().toString().trim().equalsIgnoreCase("")) {
            nameEdittext.setError("This field can not be blank");
            nameEdittext.requestFocus();
        }
        else if (passwordEdittext.getText().toString().trim().equalsIgnoreCase("")) {
            passwordEdittext.setError("This field can not be blank");
            passwordEdittext.requestFocus();
        } else {
            String emailtext = nameEdittext.getText().toString();
            String passwordtext = passwordEdittext.getText().toString();
            LoginUser(emailtext,passwordtext);
        }
    }
}

