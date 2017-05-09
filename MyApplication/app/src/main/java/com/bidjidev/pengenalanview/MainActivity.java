package com.bidjidev.pengenalanview;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.CheckBox;
        import android.widget.CompoundButton;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox ck,ck2,ck3;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ck = (CheckBox)findViewById(R.id.cktest);
        ck2 = (CheckBox)findViewById(R.id.cktest2);
        ck3 = (CheckBox)findViewById(R.id.cktest1);
        txt = (TextView) findViewById(R.id.txtubah);
        ubah();
        ck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ck.isChecked() && ck2.isChecked()){
                    ck3.setEnabled(false);
                }
            }
        });
    }
    public void ubah(){
        if (ck.isChecked()){
        }
    }
}
