package com.bismillah.clto.AuthActi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bismillah.clto.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.edtPass)
    EditText edtPass;
    @BindView(R.id.edtConfPass)
    EditText edtConfPass;
    FirebaseAuth signAuth;
    @BindView(R.id.pgBar)
    ProgressBar pgBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        signAuth = FirebaseAuth.getInstance();

    }
    public void btnDaftar(View view){
        String email = edtEmail.getText().toString();
        String password = edtPass.getText().toString();
        String passwordConfirm = edtConfPass.getText().toString();
       if (TextUtils.isEmpty(email)){
            edtEmail.setError("Email tidak boleh kosong");
        }else if (TextUtils.isEmpty(password)){
           edtPass.setError("Password tidak boleh kosong");
       }else if (TextUtils.isEmpty(passwordConfirm)){
           edtConfPass.setError("Confirm password tidak boleh kosong");
       }else if ((!password.equals(passwordConfirm))){
            edtConfPass.setError("Confirm password harus sama");
        }else {
           pgBar.setVisibility(View.VISIBLE);
           signAuth.createUserWithEmailAndPassword(email, password)
                   .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
//                                Toast.makeText(SignUpActi.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                           pgBar.setVisibility(View.GONE);
                           // If sign in fails, display a message to the user. If sign in succeeds
                           // the auth state listener will be notified and logic to handle the
                           // signed in user can be handled in the listener.
                           String error;

                           if (!task.isSuccessful()) {
                               if(task.getException().equals("com.google.firebase.auth.FirebaseAuthUserCollisionException: The email address is already in use by another account.")){
                                   error = "email sudah terpakai";
                               }else {
                                   error = "error tidak di ketahui";
                               }
                               Toast.makeText(RegisterActivity.this, error,
                                       Toast.LENGTH_SHORT).show();
                           } else {
                               startActivity(new Intent(RegisterActivity.this, RegisterBiodata.class));
                               finish();
                           }
                       }
                   });

       }
    }

}
