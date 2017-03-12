package com.example.administrator.tinkerdemo;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionDenied;
import com.zhy.m.permission.PermissionGrant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
//                Log.e("asdfasdf", "view.getid");
                MPermissions.requestPermissions(this,1,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE});

                break;
        }
    }

    @PermissionGrant(value = 1)
    public void requesetPermissionSuccess(){
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();

    }


    @PermissionDenied(value = 1)
    public void requesetPermissionFailed(){
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }
}

