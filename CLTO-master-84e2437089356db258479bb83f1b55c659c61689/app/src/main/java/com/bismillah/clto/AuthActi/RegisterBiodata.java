package com.bismillah.clto.AuthActi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bismillah.clto.MainActivity;
import com.bismillah.clto.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterBiodata extends AppCompatActivity {

    @BindView(R.id.pgBar)
    ProgressBar pgBar;
    @BindView(R.id.edtTim)
    EditText edtTim;
    @BindView(R.id.edtKapten)
    EditText edtKapten;
    @BindView(R.id.edtKota)
    EditText edtKota;
    @BindView(R.id.edtBasecamp)
    EditText edtBasecamp;
    @BindView(R.id.edtNoTel)
    EditText edtNoTel;
    @BindView(R.id.btnDaftar)
    Button btnDaftar;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
DataRegis data;
    private FirebaseAuth.AuthStateListener authListener;
    FirebaseUser user;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_biodata);
        ButterKnife.bind(this);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

    }

    @OnClick(R.id.btnDaftar)
    public void onViewClicked() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("dataTim");
        String namaTim = edtTim.getText().toString();
        String namaKapten = edtKapten.getText().toString();
        String Kota = edtKota.getText().toString();
        String baseCamp = edtBasecamp.getText().toString();
        String nomorTelpon = edtNoTel.getText().toString();
        if (TextUtils.isEmpty(namaTim)) {
            edtTim.setError("namaTim tidak boleh kosong");
        }else if (TextUtils.isEmpty(namaKapten)) {
            edtKapten.setError("namaKapten tidak boleh kosong");
        }else if (TextUtils.isEmpty(Kota)) {
            edtKota.setError("Kota tidak boleh kosong");
        }else if (TextUtils.isEmpty(baseCamp)) {
            edtBasecamp.setError("baseCamp tidak boleh kosong");
        }else if (TextUtils.isEmpty(nomorTelpon)) {
            edtNoTel.setError("nomorTelpon tidak boleh kosong");
        }else {
            try {
                data = new DataRegis(user.getUid().toString(), namaTim, namaKapten,baseCamp,Kota,nomorTelpon);
                databaseReference.child(data.getKeyUid()).setValue(data);
                Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterBiodata.this,MainActivity.class));
            } catch (Exception e) {
                Toast.makeText(RegisterBiodata.this, "gagal nih", Toast.LENGTH_SHORT).show();
            }
        }

        }
}
