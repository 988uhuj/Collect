package me.roy.common.multiplemodel;

import java.util.HashMap;

import me.roy.common.base.BaseItemModel;

/**
 * Created by chenupt@gmail.com on 2014/8/7.
 * Description : A factory create multiple item views
 */
public class ModelFactory {

    public final static String TYPE = "type";
    public final static String CONTENT = "content";
    public final static String CONTENT_LIST = "content_list";
    public final static String VIEW_POSITION = "view_position";

    private HashMap<String, BaseItemModel> viewMap;
    private HashMap<String, Integer> indexMap;
    private HashMap<Integer, Boolean> pinnedMap;

    public BaseItemModel createModel(String modelType){
        return viewMap.get(modelType);
    }

    public int getViewType(String modelType){
         return indexMap.get(modelType);
    }

    public int getViewTypeCount(){
        return viewMap.size();
    }

    public boolean isItemViewTypePinned(int type){
        return pinnedMap.get(type);
    }


    public ModelFactory addModel(String modelType, BaseItemModel view, boolean isPenned){
        return addToMap(modelType, view, isPenned);
    }
    public ModelFactory addModel(String modelType, BaseItemModel view){
        return addToMap(modelType, view, false);
    }

    private ModelFactory addToMap(String modelType, BaseItemModel view, boolean isPenned){
        viewMap.put(modelType, view);
        int viewType = viewMap.size() - 1;
        indexMap.put(modelType, viewType);
        pinnedMap.put(viewType , isPenned);
        return this;
    }
}
