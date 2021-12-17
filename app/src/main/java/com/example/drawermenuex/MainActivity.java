package com.example.drawermenuex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    int FRAGMENT_HOME=1;
    int FRAGMENT_CASES=2;
    int FRAGMENT_COLLECTION=3;
    int FRAGMENT_ACCESSORIES=4;
    int FRAGMENT_SEARCH=5;
    int FRAGMENT_CART=6;
    int FRAGMENT_ACCOUNT=7;
    int CurrentFragment=FRAGMENT_HOME;
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
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        if(FRAGMENT_HOME!=CurrentFragment)
                        {
                            replaceFragment(new HomeFragment());
                            CurrentFragment=FRAGMENT_HOME;
                            bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                            navigationbarmain.getMenu().findItem(R.id.txtHome).setChecked(true);
                        }
                        break;
                    case R.id.search:
                        if(FRAGMENT_SEARCH!=CurrentFragment)
                        {
                            replaceFragment(new SearchFragment());
                            CurrentFragment=FRAGMENT_SEARCH;
                            bottomNavigationView.getMenu().findItem(R.id.search).setChecked(true);
                            int size = navigationbarmain.getMenu().size();
                            for (int i = 0; i < size; i++) {
                                navigationbarmain.getMenu().getItem(i).setChecked(false);
                            }
                        }
                        break;
                    case R.id.cart:
                        if(FRAGMENT_CART!=CurrentFragment)
                        {
                            replaceFragment(new ShoppingCartFragment());
                            CurrentFragment=FRAGMENT_CART;
                            bottomNavigationView.getMenu().findItem(R.id.cart).setChecked(true);
                            int size = navigationbarmain.getMenu().size();
                            for (int i = 0; i < size; i++) {
                                navigationbarmain.getMenu().getItem(i).setChecked(false);
                            }
                        }
                        break;
                    case R.id.account:
                        if(FRAGMENT_ACCOUNT!=CurrentFragment)
                        {
                            replaceFragment(new AccountFragment());
                            CurrentFragment=FRAGMENT_ACCOUNT;
                            bottomNavigationView.getMenu().findItem(R.id.account).setChecked(true);
                            int size = navigationbarmain.getMenu().size();
                            for (int i = 0; i < size; i++) {
                                navigationbarmain.getMenu().getItem(i).setChecked(false);
                            }
                        }
                        break;
                }
                return false;
            }
        });
        navigationbarmain.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id =item.getItemId();
                if(id==R.id.txtHome)
                {
                    if(FRAGMENT_HOME!=CurrentFragment)
                    {
                        replaceFragment(new HomeFragment());
                        CurrentFragment=FRAGMENT_HOME;
                        bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);

                    }
                } else if(id==R.id.txtCases)
                {
                    if(FRAGMENT_CASES!=CurrentFragment)
                    {
                        replaceFragment(new CasesFragment());
                        CurrentFragment=FRAGMENT_CASES;
                        bottomNavigationView.getMenu().findItem(R.id.menu_none).setChecked(true);
                    }
                } else if(id==R.id.txtCollection)
                {
                    if(FRAGMENT_COLLECTION!=CurrentFragment)
                    {
                        replaceFragment(new CollectionFragment());
                        CurrentFragment=FRAGMENT_COLLECTION;
                        bottomNavigationView.getMenu().findItem(R.id.menu_none).setChecked(true);
                    }
                } else if(id==R.id.txtAccesories)
                {
                    if(FRAGMENT_ACCESSORIES!=CurrentFragment)
                    {
                        replaceFragment(new AccessoriesFragment());
                        CurrentFragment=FRAGMENT_ACCESSORIES;
                        bottomNavigationView.getMenu().findItem(R.id.menu_none).setChecked(true);
                    }
                }
                drawerLayoutmain.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        replaceFragment(new HomeFragment());
        navigationbarmain.setCheckedItem(R.id.txtHome);

    }

    private void linkViews() {
        toolbarmain=findViewById(R.id.toolbar);
        drawerLayoutmain=findViewById(R.id.drawerlayoutmain);
        navigationbarmain=findViewById(R.id.navigationbarmain);
        bottomNavigationView=findViewById(R.id.bottom_navigation_bar);

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
    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();

    }

}