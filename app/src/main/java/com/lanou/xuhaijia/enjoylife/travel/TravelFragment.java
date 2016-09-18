package com.lanou.xuhaijia.enjoylife.travel;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.travel.attractions.AttractionsAty;
import com.lanou.xuhaijia.enjoylife.travel.search.TravelSearchAty;
import com.lanou.xuhaijia.enjoylife.travel.selectcity.CitySelectAty;
import com.wevey.selector.dialog.DialogOnClickListener;
import com.wevey.selector.dialog.NormalAlertDialog;


/**
 * Created by 徐海佳 on 16/9/13.
 */
public class TravelFragment extends BaseFragment implements View.OnClickListener {

    private NormalAlertDialog dialog;
    private ImageView ivBackGround;
    private TextView tvCH;
    private TextView tvEnglish;

    @Override
    protected int setLayout() {
        return R.layout.fragment_travel;
    }

    @Override
    protected void initView() {

        ivBackGround = bindView(R.id.travel_fragment_imager_background);

        //城市中文
        tvCH = bindView(R.id.travel_fragment_textview_ch_city);
        //城市英文
        tvEnglish = bindView(R.id.travel_fragment_textview_english_city);


        //搜索框
        RelativeLayout rlatSearch = bindView(R.id.travel_fragment_relative_search);
        //搜索框的点击事件
        rlatSearch.setOnClickListener(this);

        ImageView ivPosition = bindView(R.id.travel_fragment_imager_position);
        ivPosition.setOnClickListener(this);

        ImageView ivAttractions = bindView(R.id.travel_fragment_imager_attractions);
        ivAttractions.setOnClickListener(this);


    }

    @Override
    protected void initData() {

        mNetTool.getData(UrlValues.TRAVEL_IMGER_INITALIZE, TravelFragmentBean.class, new NetTool.NetInterface<TravelFragmentBean>() {
            @Override
            public void onSuccess(TravelFragmentBean travelFragmentBean) {
                Glide.with(getActivity()).load(travelFragmentBean.getPlace().getCover()).into(ivBackGround);
                tvCH.setText(travelFragmentBean.getPlace().getName_cn());
                tvEnglish.setText(travelFragmentBean.getPlace().getName());



            }

            @Override
            public void onError(String errorMsg) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.travel_fragment_relative_search:
                Intent intentSearch = new Intent(getActivity(), TravelSearchAty.class);

                startActivity(intentSearch);

                break;
            case R.id.travel_fragment_imager_position:


                Toast.makeText(mContext, "我点击了", Toast.LENGTH_SHORT).show();
                dialog = new NormalAlertDialog.Builder(mContext)
                        .setHeight(0.35f)
                        .setWidth(0.8f)
                        .setTitleVisible(true)
                        .setTitleText("口碑旅行是你超聪明的出境有助手")
                        .setTitleTextColor(R.color.black_light)
                        .setContentText("请选择一个您最想去的境外城市!")
                        .setContentTextColor(R.color.black_light)
                        .setLeftButtonText("暂不切换")
                        .setLeftButtonTextColor(R.color.gray)
                        .setRightButtonText("马上穿越")
                        .setRightButtonTextColor(R.color.black_light)
                        .setOnclickListener(new DialogOnClickListener() {
                            @Override
                            public void clickLeftButton(View view) {
                                dialog.dismiss();
                            }

                            @Override
                            public void clickRightButton(View view) {


                                Toast.makeText(mContext, "跳转地图", Toast.LENGTH_SHORT).show();

                                Intent intentSelectAty = new Intent(getContext(), CitySelectAty.class);

                                startActivity(intentSelectAty);
                                dialog.dismiss();

                            }
                        })
                        .build();


                dialog.show();


                break;

            case R.id.travel_fragment_imager_attractions:

                Intent intentAttractions = new Intent(getActivity(), AttractionsAty.class);

                startActivity(intentAttractions);


                break;


        }
    }
}
