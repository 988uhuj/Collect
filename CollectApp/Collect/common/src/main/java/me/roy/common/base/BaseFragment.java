package me.roy.common.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import me.roy.common.event.BusHelper;


public class BaseFragment extends Fragment{

	
	protected boolean isActive;

	@Override
	public void onResume() {
		isActive = true;
        BusHelper.create().commonRegister(this);
		super.onResume();
	}

	@Override
	public void onPause() {
		isActive = false;
        BusHelper.create().commonUnregister(this);
		super.onPause();
	}


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BusHelper.create().commonRegister(this);
    }

    @Override
	public void onDestroy() {
		super.onDetach();
	}


    public void onEvent(Integer integer){
        // TODO
    }


}
