package me.roy.collect.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.umeng.socialize.controller.RequestType;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.update.UmengUpdateAgent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.roy.collect.R;
import me.roy.collect.app.entity.MenuEntity;
import me.roy.collect.app.favorite.FavoriteFragment;
import me.roy.collect.app.libs.manage.TypeFragment;
import me.roy.collect.app.menu.adapter.MenuAdapter;
import me.roy.collect.common.base.BaseActivity;
import me.roy.collect.common.module.about.AboutFragment;
import me.roy.collect.util.Constants;


public class MainActivity extends BaseActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ListView leftDrawer;

    private MenuAdapter menuAdapter;
    private TypeFragment typeFragment;
    private FavoriteFragment favoriteFragment;
    private AboutFragment aboutFragment;

    private String[] menuArray;
    private int[] iconArray = {R.drawable.ic_action_labels
                    , R.drawable.ic_action_important_light
                    , R.drawable.ic_action_email
                    , R.drawable.ic_action_view_as_grid
                    , R.drawable.ic_action_about_light};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();
        initData();
        initDrawerLayout();
        initView();
        action();

        // 友盟更新
        UmengUpdateAgent.update(this);
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
                    getSupportActionBar().setTitle(R.string.collection);
                    changeColor(getResources().getColor(R.color.tab_color_4));
                    replaceFragment(favoriteFragment);
                }else if(i == 5){
                    getSupportActionBar().setTitle(R.string.about);
                    changeColor(getResources().getColor(R.color.tab_color_3));
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
            menuEntity.setIcon(iconArray[i]);

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
        getSupportActionBar().setTitle(R.string.app_name);
        changeColor(getResources().getColor(R.color.tab_color_1));
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        if (item.getItemId() == R.id.action_talk){
            UMSocialService controller = UMServiceFactory.getUMSocialService(getPackageName(), RequestType.SOCIAL);
            controller.openComment(this, false);
            return true;
        }
        return false;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        showExitDialog();
    }

    public void showExitDialog() {
        new AlertDialog.Builder(this)
                .setMessage(getResources().getString(R.string.exit_message))
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).create().show();
    }


}
