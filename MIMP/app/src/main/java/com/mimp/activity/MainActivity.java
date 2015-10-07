package com.mimp.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mimp.fragment.*;
import com.mimp.fragment.institucion.InscripccionSlide;

public class MainActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public boolean drawerCar=true;
    public boolean drawerInstitucion=true;
    public NavigationView navigationView;
    private String drawerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar(); // Setear Toolbar como action bar

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
         navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        if (savedInstanceState == null) {
            selectItem(R.id.nav_home);
        }

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Marcar item presionado
                        menuItem.setChecked(true);
                        // Crear nuevo fragmento

                        selectItem(menuItem.getItemId());
                        return true;
                    }
                }
        );
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }
*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void selectItem(int id) {
        Bundle arguments = new Bundle();
       switch (id)
        {
            case R.id.nav_home:

                //setFragment(  new DinamicoFragment());
                setFragment(  new InicioFragment());
                setTitle(getString(R.string.home_item));
                break;
            case R.id.nav_actualizar:

                setFragment(new CarFragment());
                //navigationView.getMenu().getItem(0).setChecked(true);
                break;


            case R.id.nav_ayuda:
                setFragment(new InstitucionFragment());
                //navigationView.getMenu().getItem(0).setChecked(true);
                break;

            case R.id.nav_cerrar:
                setFragment(new DinamicoFragment());
                break;

        }

        drawerLayout.closeDrawers();

    }


    public void setFragment( Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction() .replace(R.id.main_content, fragment).commit();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            AlertDialog.Builder alert;
            Fragment currentFrag =  getSupportFragmentManager().findFragmentById(R.id.main_content);
            if (currentFrag!=null) {
                switch (currentFrag.getClass().getSimpleName())
                {
                    case "InscripccionSlide":
                        setFragment(new InstitucionFragment());
                        break;
                /*    case "FragmentMapa":
                    case "CarFragment":
                        this.finish();
                        break;
                    case "FragmentTab1":
                    case "FragmentTab2":
                    case "FragmentTab3":
                    case "FragmentTab4":

                        break;
                    case "FragmentLogin":

                        break;
                    case "FragmentReserva":
                        alert = new AlertDialog.Builder(this);
                        alert.setTitle(getString(R.string.alert_retroceder));
                        alert.setPositiveButton(getString(R.string.btn_aceptar), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                               // setFragment(new FragmentTab3());
                            }
                        });
                        alert.setNegativeButton(getString(R.string.btn_cancelar), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }
                        });
                        alert.show();

                        break;
                    case "FragmentRegistro":


                        break;*/
                    default:
                        break;
                }
            }
            // this.finish();
            return false;
        }

        return super.onKeyDown(keyCode, event);
    }
}
