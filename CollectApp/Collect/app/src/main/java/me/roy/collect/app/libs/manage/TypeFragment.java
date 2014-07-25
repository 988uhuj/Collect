package me.roy.collect.app.libs.manage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etsy.android.grid.StaggeredGridView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.roy.collect.R;
import me.roy.collect.app.entity.LibType;
import me.roy.collect.app.libs.manage.adapter.TypeAdapter;
import me.roy.collect.common.base.BaseFragment;
import me.roy.collect.util.Constants;

/**
 * Created by chenupt@gmail.com on 2014/7/7.
 * Description : TODO
 */
public class TypeFragment extends BaseFragment {

    private StaggeredGridView listView;
    private TypeAdapter typeAdapter;

    private int type;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.app_libraries_fragment_type, null);
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
        listView = (StaggeredGridView) getView().findViewById(R.id.grid_view);
    }

    private void initData(){
        typeAdapter = new TypeAdapter(getActivity());
//        typeAdapter.addList(TypeService.getInstance().addTest());
    }

    private void initView(){
        listView.setAdapter(typeAdapter);
    }

    private void action(){
        List<LibType> list = LibType.listAll(LibType.class);

        for(LibType libType : list){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("type", Constants.DEF_LIBS_LIST_TYPE.SIMPLE);
            map.put("value", libType);
            typeAdapter.addItem(map);
        }

        typeAdapter.notifyDataSetChanged();
    }
}
