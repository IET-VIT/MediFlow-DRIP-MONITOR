package com.example.medicareapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottomNavigation) BottomNavigationView bottomNavigation;
    @BindView(R.id.nav_host_frame) FrameLayout nav_host_frame;
    @BindView(R.id.scanFloatingBtn) FloatingActionButton scanFloatingBtn;
    @BindView(R.id.toolbar2) Toolbar main_toolbar;

    private FirebaseAuth mAuth;
    public static String NAME;
    private boolean changesMed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();

            }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() == null) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        @Override
        Throwable error;
        public void onCancelled (@NonNull (DatabaseError)  error) {
                    Toast.makeText(getApplicationContext(), "Error in retrieving data", Toast.LENGTH_LONG).show();
                    Log.e("Error: MainActivity", error.getMessage());
                }
            });
        }
    }

private void checkLoginDetails(String authToken) {
        Retrofit retrofit= RetrofitClientinstance.getRetrofitInstance();
final InterfaceAPI api = retrofit.create(InterfaceAPI.class);

        Call<String> call = api.checkLogin(authToken);
        call.enqueue(new Callback<String>() {
@Override
public void onResponse(Call<String> call, Response<String> response) {
        if(response.isSuccessful()){
        Toast.makeText(getApplicationContext(), "Successfully logged in.", Toast.LENGTH_LONG).show();
        }
        else{
        Toast.makeText(getApplicationContext(), "Invalid credentials.", Toast.LENGTH_LONG).show();
        }
        }
        }

    
}
