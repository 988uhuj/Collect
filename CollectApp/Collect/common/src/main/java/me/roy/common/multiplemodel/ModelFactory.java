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

    public BaseModel createModel(String modelType){
        return viewMap.get(modelType);
    }

    public int getViewType(String modelType){
         return indexMap.get(modelType);
    }

    public int getViewTypeCount(){
        return viewMap.size();
    }

    public ModelFactory add(String modelType, BaseModel view){
        viewMap.put(modelType, view);
        indexMap.put(modelType, viewMap.size() - 1);
        return this;
    }

}
