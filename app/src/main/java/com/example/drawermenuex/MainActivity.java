package com.example.drawermenuex;

import static com.example.util.Constant.USER;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.util.Constant;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbarmain;
    DrawerLayout drawerLayoutmain;
    NavigationView navigationbarmain;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkViews();
        actionBar();

        String user = getIntent().getStringExtra(USER);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        replaceFragment(new HomeFragment());
                        bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                        navigationbarmain.getMenu().findItem(R.id.txtHome).setChecked(true);
                        break;
                    case R.id.search:
                        replaceFragment(new SearchFragment());
                        bottomNavigationView.getMenu().findItem(R.id.search).setChecked(true);
                        int size = navigationbarmain.getMenu().size();
                        for (int i = 0; i < size; i++) {
                            navigationbarmain.getMenu().getItem(i).setChecked(false);
                        }
                        break;
                    case R.id.cart:
                        replaceFragment(new CartFragment());
                        bottomNavigationView.getMenu().findItem(R.id.cart).setChecked(true);
                        int size1 = navigationbarmain.getMenu().size();
                        for (int i = 0; i < size1; i++) {
                            navigationbarmain.getMenu().getItem(i).setChecked(false);
                        }
                        break;
                    case R.id.account:
                        String key = getIntent().getStringExtra(USER);
                        Bundle bundle = new Bundle();
                        AppCompatActivity activity =  MainActivity.this;
                        AccountFragment fragment = new AccountFragment();
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).addToBackStack(null).commit();
                        bundle.putSerializable(USER, key);
                        fragment.setArguments(bundle);

                        bottomNavigationView.getMenu().findItem(R.id.account).setChecked(true);
                        int size2 = navigationbarmain.getMenu().size();
                        for (int i = 0; i < size2; i++) {
                            navigationbarmain.getMenu().getItem(i).setChecked(false);
                        }

                        break;

                }
                return false;
            }
        });
        navigationbarmain.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.txtHome) {
                    replaceFragment(new HomeFragment());
                    bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);

                } else if (id == R.id.txtCases) {
                    replaceFragment(new CasesFragment());
                    bottomNavigationView.getMenu().findItem(R.id.menu_none).setChecked(true);
                } else if (id == R.id.txtCollection) {
                    replaceFragment(new CollectionFragment());
                    bottomNavigationView.getMenu().findItem(R.id.menu_none).setChecked(true);
                } else if (id == R.id.txtAccesories) {
                    replaceFragment(new AccessoriesFragment());
                    bottomNavigationView.getMenu().findItem(R.id.menu_none).setChecked(true);

                } else if (id == R.id.txtAboutus) {
                    replaceFragment(new AbouUsFragment());
                    bottomNavigationView.getMenu().findItem(R.id.menu_none).setChecked(true);

                }
                drawerLayoutmain.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        replaceFragment(new HomeFragment());
        navigationbarmain.setCheckedItem(R.id.txtHome);

    }

    private void linkViews() {
        toolbarmain = findViewById(R.id.toolbar);
        drawerLayoutmain = findViewById(R.id.drawerlayoutmain);
        navigationbarmain = findViewById(R.id.navigationbarmain);
        bottomNavigationView = findViewById(R.id.bottom_navigation_bar);

    }

    private void actionBar() {
        setSupportActionBar(toolbarmain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        toolbarmain.setNavigationIcon(R.drawable.ic_menu);
        toolbarmain.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayoutmain.openDrawer(GravityCompat.START);
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();

    }

}