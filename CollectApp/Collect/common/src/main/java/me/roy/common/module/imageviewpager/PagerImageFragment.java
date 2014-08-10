package me.roy.common.module.imageviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.alexvasilkov.gestures.State;
import com.alexvasilkov.gestures.widgets.GestureImageView;

import me.roy.common.R;
import me.roy.common.base.BaseProgressFragment;

/**
 * Created by chenupt@gmail.com on 2014/8/9.
 * Description TODO
 */
public class PagerImageFragment extends BaseProgressFragment {

    private GestureImageView imageView;
    private ViewPager viewPager;

    private ImageEntity imageEntity;

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.common_fragment_pager_image, container, false);
//    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setContentView(R.layout.common_fragment_pager_image);
        setEmptyText("dd");

        findViewById();
        initData();
        initView();
        action();
    }

    private void findViewById(){
        imageView = (GestureImageView) getView().findViewById(R.id.image_view);
    }

    private void initData(){

    }

    private void initView(){
        imageView.fixViewPagerScroll(viewPager);

        imageView.getController().getSettings()
                .setMaxZoom(15.0f)
                .setOverscrollDistance(getActivity(), 30, 30)
                .setRotationEnabled(true);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    handleRotate(imageView.getController().getState().getRotation());
                }
                return false;
            }
        });
//        imageView.getController().
        Log.d("rotate", "delta");

    }

    private void action(){
        imageView.setImageResource(R.drawable.the_bodmer_oak);
        setContentShown(true);
    }

    private void handleRotate(float rotation){
        float x = imageView.getWidth() / 2;
        float y = imageView.getHeight() / 2;
        State state = imageView.getController().getState();
        if(rotation > -45 && rotation < 45){
            state.rotateTo(0, x, y);
        }else if(rotation > 45 && rotation < 135){
            state.rotateTo(90, x, y);
        }else if(rotation > 135 || rotation < -135){
            state.rotateTo(180, x, y);
        }else if(rotation > -135 && rotation < -45){
            state.rotateTo(-90, x, y);
        }
        imageView.getController().animateStateTo(state);
        Log.d("rotate", "delta zoom : " + imageView.getController().getState().getZoom());
    }

    // Must call before initView
    public void setViewPager(ViewPager viewPager){
        this.viewPager = viewPager;
    }

}
