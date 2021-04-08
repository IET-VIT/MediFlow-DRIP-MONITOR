package com.undamped.khyaal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.undamped.khyaal.database.MedDao;
import com.undamped.khyaal.database.MedDatabase;
import com.undamped.khyaal.entity.Medicine;

import butterknife.BindView;
import butterknife.ButterKnife;

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

        scanFloatingBtn.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_frame, new ScanFragment()).commit();
        });

        bottomNavigation.setSelectedItemId(R.id.action_medicines);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_frame, new MedicineFragment()).commit();

        bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_profile:
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_frame, new ProfileFragment()).commit();
                    return true;

                case R.id.action_medicines:
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_frame, new MedicineFragment()).commit();
                    return true;
            }
            return false;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() == null) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        } else {
            MedDao medDao = MedDatabase.getInstance(MainActivity.this).medDao();
            changesMed = false;

            DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("Users");
            mRef.child(mAuth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    NAME = snapshot.child("Name").getValue().toString();
                    for(DataSnapshot snap : snapshot.child("Medicines").getChildren()){
                        if(snap.exists()) {
                            changesMed = true;
                            char[] dose = snap.child("dose").getValue().toString().toCharArray();
                            Medicine med = new Medicine();
                            med.setName(snap.child("name").getValue().toString());
                            med.setDays(Integer.parseInt(snap.child("days").getValue().toString().replaceAll("[^0-9]", "")));
                            if(dose[0] == '1')
                                med.setMorning(true);
                            if(dose[2] == '1')
                                med.setAfternoon(true);
                            if(dose[4] == '1')
                                med.setEvening(true);

                            medDao.insertMed(med);
                        }
                    }
                    removeTheNewMeds();
                    if(changesMed)
                        Toast.makeText(MainActivity.this, "New Medicines added", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getApplicationContext(), "Error in retrieving data", Toast.LENGTH_LONG).show();
                    Log.e("Error: MainActivity", error.getMessage());
                }
            });
        }
    }

    private void removeTheNewMeds() {
        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("Users");
        mRef.child(mAuth.getCurrentUser().getUid()).child("Medicines").removeValue();
    }
}