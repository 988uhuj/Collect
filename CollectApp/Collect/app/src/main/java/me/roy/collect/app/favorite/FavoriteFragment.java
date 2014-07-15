package me.roy.collect.app.favorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.roy.collect.R;
import me.roy.collect.app.entity.LibInfo;
import me.roy.collect.app.libs.manage.adapter.TypeAdapter;
import me.roy.collect.common.base.BaseFragment;
import me.roy.collect.util.Constants;

/**
 * Created by chenupt@gmail.com on 2014/7/7.
 * Description : TODO
 */
public class FavoriteFragment extends BaseFragment {

    private ListView listView;
    private TypeAdapter typeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.app_libraries_fragment_sub_type, null);
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
        List<LibInfo> list = LibInfo.find(LibInfo.class, "is_collect = ?", String.valueOf(1));

        for(LibInfo libInfo : list){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("type", Constants.DEF_LIBS_LIST_TYPE.SUB_TYPE_SIMPLE);
            map.put("value", libInfo);
            typeAdapter.addItem(map);
        }

        typeAdapter.notifyDataSetChanged();
    }

}