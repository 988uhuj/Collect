package me.roy.common.multiplemodel;

import java.util.HashMap;

/**
 * Created by chenupt@gmail.com on 2014/8/7.
 * Description TODO
 */
public class ModelFactory {

    public final static String TYPE = "type";
    public final static String CONTENT = "content";
    public final static String CONTENT_LIST = "content_list";
    public final static String VIEW_POSITION = "view_position";

    private HashMap<String, BaseModel> viewMap;
    private HashMap<String, Integer> indexMap;
    private HashMap<Integer, Boolean> pinnedMap;

    public BaseModel createModel(String modelType){
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





    public ModelFactory addModel(String modelType, BaseModel view, boolean isPenned){
        return addToMap(modelType, view, isPenned);
    }
    public ModelFactory addModel(String modelType, BaseModel view){
        return addToMap(modelType, view, false);
    }

    private ModelFactory addToMap(String modelType, BaseModel view, boolean isPenned){
        viewMap.put(modelType, view);
        int viewType = viewMap.size() - 1;
        indexMap.put(modelType, viewType);
        pinnedMap.put(viewType , isPenned);
        return this;
    }
}
