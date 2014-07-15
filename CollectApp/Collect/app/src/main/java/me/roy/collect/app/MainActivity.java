package me.roy.collect.app;

import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.roy.collect.R;
import me.roy.collect.app.entity.MenuEntity;
import me.roy.collect.app.favorite.FavoriteFragment;
import me.roy.collect.app.libs.manage.TypeFragment;
import me.roy.collect.app.menu.adapter.MenuAdapter;
import me.roy.collect.common.module.about.AboutFragment;
import me.roy.collect.util.Constants;


public class MainActivity extends ActionBarActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ListView leftDrawer;

    private MenuAdapter menuAdapter;
    private TypeFragment typeFragment;
    private FavoriteFragment favoriteFragment;
    private AboutFragment aboutFragment;

    private String[] menuArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();
        initData();
        initDrawerLayout();
        initView();
        action();

    }

    private void findViewById(){
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        leftDrawer = (ListView) findViewById(R.id.left_drawer);
        menuArray = getResources().getStringArray(R.array.menu_array);
    }

    private void initData(){
        typeFragment = new TypeFragment();
        aboutFragment = new AboutFragment();
        favoriteFragment = new FavoriteFragment();
        menuAdapter = new MenuAdapter(this);

    }

    private void initDrawerLayout(){
        drawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                drawerLayout,           /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
//                getActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
//                getActionBar().setTitle(mDrawerTitle);
            }
        };
        // Set the drawer toggle as the DrawerListener
        drawerLayout.setDrawerListener(drawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void initView(){
        leftDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                drawerLayout.closeDrawers();
                if(i == 1){
                    replaceContentFragment();
                }else if(i == 2){
                    changeColor(0XFF565656);
                    replaceFragment(favoriteFragment);
                }else if(i == 5){
                    changeColor(0XFF343434);
                    replaceFragment(aboutFragment);
                }
            }
        });
    }

    private void action(){
        replaceContentFragment();

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", Constants.DEF_LIBS_LIST_TYPE.MENU_HEAD);
        list.add(map);

        for(int i = 0; i < menuArray.length; i ++){
            MenuEntity menuEntity = new MenuEntity();
            menuEntity.setMenuStr(menuArray[i]);
            menuEntity.setId(i);

            map = new HashMap<String, Object>();
            map.put("type", Constants.DEF_LIBS_LIST_TYPE.MENU_SIMPLE);
            map.put("value", menuEntity);
            list.add(map);
        }
        menuAdapter.addList(list);
        leftDrawer.setAdapter(menuAdapter);
        leftDrawer.setSelection(1);
    }


    private void replaceContentFragment(){
        changeColor(0XFF484848);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, typeFragment)
                .commit();
    }

    private void replaceFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return false;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private Drawable oldBackground = null;

    private void changeColor(int newColor) {

        Drawable colorDrawable = new ColorDrawable(newColor);
        Drawable bottomDrawable = getResources().getDrawable(R.drawable.actionbar_bottom);
        LayerDrawable ld = new LayerDrawable(new Drawable[]{colorDrawable, bottomDrawable});

        if (oldBackground == null) {
            getSupportActionBar().setBackgroundDrawable(ld);
        } else {
            TransitionDrawable td = new TransitionDrawable(new Drawable[]{oldBackground, ld});
            getSupportActionBar().setBackgroundDrawable(td);
            td.startTransition(200);
        }

        oldBackground = ld;

        // http://stackoverflow.com/questions/11002691/actionbar-setbackgrounddrawable-nulling-background-from-thread-handler
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }



}
