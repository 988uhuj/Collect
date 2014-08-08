package me.roy.common.multiplemodel;

import android.content.Context;

import me.roy.common.view.PinnedSectionListView;


/**
 * Created by chenupt@gmail.com on 2014/8/8.
 * Description TODO
 */
public class PinnedModelAdapter extends SimpleModelAdapter implements PinnedSectionListView.PinnedSectionListAdapter {

    public PinnedModelAdapter(Context context, ModelFactory modelFactory) {
        super(context, modelFactory);
    }

    @Override
    public boolean isItemViewTypePinned(int viewType) {
        return modelFactory.isItemViewTypePinned(viewType);
    }

}
