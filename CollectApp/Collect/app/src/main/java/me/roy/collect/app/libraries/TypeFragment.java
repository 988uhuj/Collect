package me.roy.collect.app.libraries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import me.roy.collect.app.R;
import me.roy.collect.app.libraries.adapter.TypeAdapter;
import me.roy.collect.app.libraries.service.TypeService;
import me.roy.collect.common.base.BaseFragment;

/**
 * Created by chenupt@gmail.com on 2014/7/7.
 * Description : TODO
 */
public class TypeFragment extends BaseFragment {

    private ListView listView;
    private TypeAdapter typeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.libraries_fragment_type, null);
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
        typeAdapter.addList(TypeService.getInstance().addTest());
    }

    private void initView(){
        listView.setAdapter(typeAdapter);
    }

    private void action(){

    }
}
