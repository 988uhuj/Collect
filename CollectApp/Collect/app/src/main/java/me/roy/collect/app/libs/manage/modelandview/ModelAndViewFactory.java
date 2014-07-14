package me.roy.collect.app.libs.manage.modelandview;

import android.content.Context;

import me.roy.collect.common.base.BaseModelAndView;
import me.roy.collect.util.Constants;


/**
 * Created by chenupt@gmail.com on 2014/5/24.
 * Description : 视图工厂类，创建不同视图
 */
public class ModelAndViewFactory {

    public BaseModelAndView create(Context context, int type){
        BaseModelAndView modelAndView = null;
        // TODO 根据类型返回不同视图
        switch (type){
            case Constants.DEF_LIBS_LIST_TYPE.SIMPLE:
                modelAndView = new SimpleModelAndView(context);
                break;
            case Constants.DEF_LIBS_LIST_TYPE.SUB_TYPE_SIMPLE:
                modelAndView = new SubTypeModelAndView(context);
                break;
            case Constants.DEF_LIBS_LIST_TYPE.SUB_TYPE_DETAIL:
                modelAndView = new DetailModelAndView(context);
                break;
            default:
                break;
        }
        return modelAndView;
    }
    
    
    public int getViewCount(){
    	return 1;
    }
    
	public int getViewType(int type) {
		switch (type) {
		case Constants.DEF_LIBS_LIST_TYPE.SIMPLE:
			return 0;
		default:
			return 0;
		}
	}
	
	public boolean checkPinned(int viewType) {
//		if(viewType == 2){
//			return true;
//		}
		return false;
	}
	

    private static volatile ModelAndViewFactory instance = null;

    private ModelAndViewFactory(){
    }

    public static ModelAndViewFactory getInstance() {
        if (instance == null) {
            synchronized (ModelAndViewFactory.class) {
                if (instance == null) {
                    instance = new ModelAndViewFactory();
                }
            }
        }
        return instance;
    }
    
    

}
