package me.roy.collect.app.libs.manage.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.Map;

import me.roy.collect.app.libs.manage.modelandview.ModelAndViewFactory;
import me.roy.collect.common.base.BaseListAdapter;
import me.roy.collect.common.base.BaseModelAndView;

/**
 * Created by chenupt@gmail.com on 2014/7/9.
 * Description : TODO
 */
public class TypeAdapter extends BaseListAdapter<Map<String, Object>> {


    public TypeAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int type  = (Integer) getItem(i).get("type");
        if(view == null){
            BaseModelAndView modelAndView = ModelAndViewFactory.getInstance().create(getContext(), type);
            view = modelAndView;
        }
        ((BaseModelAndView)view).setModel(getItem(i));
        return view;
    }
}
