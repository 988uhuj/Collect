package me.roy.common.module.about;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.fb.FeedbackAgent;
import com.umeng.update.UmengUpdateAgent;
import com.umeng.update.UmengUpdateListener;
import com.umeng.update.UpdateResponse;
import com.umeng.update.UpdateStatus;

import me.roy.common.R;
import me.roy.common.base.BaseFragment;


/**
 * Created by chenupt@gmail.com on 2014/7/7.
 * Description : Some information about the app.
 */
public class AboutFragment extends BaseFragment {

    private ImageView iconImageView;
    private TextView appNameTextView;
    private TextView appVersionView;
    private TextView appDescription;
    private Button feedBackBtn;
    private Button updateBtn;
    private AboutEntity aboutEntity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.common_fragment_about, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        findViewById();
        initData();
        initView();

        action();
    }

    private void findViewById(){
        appNameTextView = (TextView) getView().findViewById(R.id.app_name);
        appVersionView = (TextView) getView().findViewById(R.id.app_version);
        appDescription = (TextView) getView().findViewById(R.id.app_description);
        iconImageView = (ImageView) getView().findViewById(R.id.icon_image_view);
        feedBackBtn = (Button) getView().findViewById(R.id.feed_btn);
        updateBtn = (Button) getView().findViewById(R.id.update_btn);
    }

    private void initData(){
        aboutEntity = new AboutEntity();
        TypedArray typedArray = getActivity().getTheme().obtainStyledAttributes(null, R.styleable.CommonAboutStyle, R.style.CommonAbout, 0);
        aboutEntity.setAppName(typedArray.getString(R.attr.commonAppName));
        aboutEntity.setIconRes(typedArray.getResourceId(R.attr.commonAppIcon, 0));
        aboutEntity.setAppVersion(typedArray.getString(R.attr.commonAppVersion));
        aboutEntity.setAppDescription(typedArray.getString(R.attr.commonAppDescription));
        typedArray.recycle();
    }

    private void initView(){
        feedBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FeedbackAgent agent = new FeedbackAgent(getActivity());
                agent.startFeedbackActivity();
            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UmengUpdateAgent.forceUpdate(getActivity());
                UmengUpdateAgent.setUpdateListener(new UmengUpdateListener() {
                    @Override
                    public void onUpdateReturned(int i, UpdateResponse updateResponse) {
                        if(i == UpdateStatus.No){
                            Toast.makeText(getActivity(), getActivity().getText(R.string.new_one), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        appNameTextView.setText(aboutEntity.getAppName());
        appVersionView.setText(aboutEntity.getAppVersion());
        appDescription.setText(aboutEntity.getAppDescription());
        iconImageView.setImageResource(aboutEntity.getIconRes());
    }

    private void action(){
    }




}
