package me.roy.common.multiplemodel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.Map;

import me.roy.common.base.BaseListAdapter;


/**
 * Created by chenupt@gmail.com on 2014/8/8.
 * Description TODO
 */
public class SimpleModelAdapter extends BaseListAdapter<Map<String, Object>> {

    private ModelFactory factory;

    public SimpleModelAdapter(Context context, ModelFactory modelFactory) {
        super(context);
        this.factory = modelFactory;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        String type = (String) getItem(i).get(ModelFactory.TYPE);
        if(view == null){
            view = factory.createModel(type);
        }
        ((BaseModel)view).setModel(getItem(i), getList());
        ((BaseModel)view).setViewPosition(i);
        return view;
    }


    @Override
    public int getItemViewType(int position) {
        String type = (String) getItem(position).get(ModelFactory.TYPE);
        return factory.getViewType(type);
    }

    @Override
    public int getViewTypeCount() {
        return factory.getViewTypeCount();
    }
}
