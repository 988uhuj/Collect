package me.roy.collect.app.libs.manage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import me.roy.collect.R;
import me.roy.collect.app.entity.LibInfo;
import me.roy.collect.app.libs.manage.adapter.TypeAdapter;
import me.roy.collect.common.base.BaseConstants;
import me.roy.collect.common.base.BaseFragment;
import me.roy.collect.util.Constants;

/**
 * Created by chenupt@gmail.com on 2014/7/7.
 * Description : TODO
 */
public class DetailFragment extends BaseFragment {
    private ListView listView;
    private TypeAdapter typeAdapter;

    private long id;
    private LibInfo libInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.app_libraries_fragment_detail, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        findViewById();
        initData();
        initView();

        action();
    }

    private void findViewById(){
        listView = (ListView) getView().findViewById(R.id.list_view);
    }

    private void initData(){
        typeAdapter = new TypeAdapter(getActivity());
    }

    private void initView(){
        listView.setAdapter(typeAdapter);
    }

    private void action(){
        getData();
    }

    private void getData(){
        libInfo = LibInfo.findById(LibInfo.class, id);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("type", Constants.DEF_LIBS_LIST_TYPE.SUB_TYPE_DETAIL);
            map.put("value", libInfo);
            typeAdapter.addItem(map);

        map = new HashMap<String, Object>();
        map.put("type", Constants.DEF_LIBS_LIST_TYPE.DEMO);
        map.put("value", libInfo);
        typeAdapter.addItem(map);

        typeAdapter.notifyDataSetChanged();
    }


    public void setId(long id){
        this.id = id;
    }

    private void collect(){
        libInfo.setCollect(true);
        libInfo.save();
        Toast.makeText(getActivity(), "已保存", Toast.LENGTH_SHORT).show();
    }

    private void unCollect(){
        libInfo.setCollect(false);
        libInfo.save();
        Toast.makeText(getActivity(), "已取消保存", Toast.LENGTH_SHORT).show();
    }

    private void onCollectBtnClick(MenuItem item){
        if(libInfo.isCollect()){
            unCollect();
            item.setIcon(R.drawable.ic_action_not_important);
        }else{
            collect();
            item.setIcon(R.drawable.ic_action_important);
        }
        typeAdapter.notifyDataSetChanged();
        Intent i = new Intent();
        i.setAction(BaseConstants.CHANGE_DATA＿ACTION);
        getActivity().sendBroadcast(i);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.detail, menu);
        if(libInfo.isCollect()){
            menu.findItem(R.id.action_collect).setIcon(R.drawable.ic_action_important);
        }else{
            menu.findItem(R.id.action_collect).setIcon(R.drawable.ic_action_not_important);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_collect) {
            onCollectBtnClick(item);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
