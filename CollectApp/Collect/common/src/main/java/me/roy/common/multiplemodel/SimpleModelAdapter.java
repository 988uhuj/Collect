package me.roy.common.multiplemodel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.Map;

import me.roy.common.base.BaseListAdapter;


/**
 * Created by chenupt@gmail.com on 2014/8/8.
 * Description : Simple base adapter for getting multiple item views
 */
public class SimpleModelAdapter extends BaseListAdapter<Map<String, Object>> {

    protected ModelFactory modelFactory;

    public SimpleModelAdapter(Context context, ModelFactory modelFactory) {
        super(context);
        this.modelFactory = modelFactory;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        String type = (String) getItem(i).get(ModelFactory.TYPE);
        if(view == null){
            view = modelFactory.createModel(type);
        }
        ((BaseItemModel)view).setModel(getItem(i), getList());
        ((BaseItemModel)view).setViewPosition(i);
        return view;
    }


    @Override
    public int getItemViewType(int position) {
        String type = (String) getItem(position).get(ModelFactory.TYPE);
        return modelFactory.getViewType(type);
    }

    @Override
    public int getViewTypeCount() {
        return modelFactory.getViewTypeCount();
    }
}
