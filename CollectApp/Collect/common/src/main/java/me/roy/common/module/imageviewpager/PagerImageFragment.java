package me.roy.common.module.imageviewpager;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.alexvasilkov.gestures.GesturesController;
import com.alexvasilkov.gestures.State;
import com.alexvasilkov.gestures.widgets.GestureImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import me.roy.common.R;
import me.roy.common.base.BaseProgressFragment;
import me.roy.common.event.BusHelper;
import me.roy.common.multiplefragment.ModelFactory;

/**
 * Created by chenupt@gmail.com on 2014/8/9.
 * Description TODO
 */
public class PagerImageFragment extends BaseProgressFragment {

    private GestureImageView imageView;
    private ViewPager viewPager;


    private ImageEntity imageEntity;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setContentView(R.layout.common_fragment_pager_image);
        setContentShown(false);

        findViewById();
        initData();
        initView();
        action();
    }

    private void findViewById(){
        imageView = (GestureImageView) getView().findViewById(R.id.image_view);

    }

    private void initData(){
        if(getArguments() != null){
            imageEntity = (ImageEntity) getArguments().get(ModelFactory.DATA);
        }

    }

    private void initView(){

        imageView.fixViewPagerScroll(viewPager);
        imageView.getController().getSettings()
                .setMaxZoom(15.0f)
                .setOverscrollDistance(getActivity(), 30, 0)
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

        imageView.getController().setOnGesturesListener(new GesturesController.OnGestureListener() {
            @Override
            public void onDown(MotionEvent motionEvent) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                Log.d("rotate", "onSingleTapUp");
                BusHelper.create().getCommonBus().post(PagerActivity.TOGGLE_ACTION_BAR);
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public boolean onDoubleTap(MotionEvent motionEvent) {
                return false;
            }
        });

    }

    private void action(){
        ImageLoader.getInstance().displayImage(imageEntity.getImageUrl(), imageView, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                complete();
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                complete();
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                complete();
            }
        });
    }

    private void complete(){
        if(getActivity() != null){
            setContentShown(true);
        }
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
