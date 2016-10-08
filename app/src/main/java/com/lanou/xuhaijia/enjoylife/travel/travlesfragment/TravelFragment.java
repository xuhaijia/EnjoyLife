package com.lanou.xuhaijia.enjoylife.travel.travlesfragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.tools.Blur;
import com.lanou.xuhaijia.enjoylife.tools.Rotate3dAnimation;
import com.lanou.xuhaijia.enjoylife.travel.airmap.AirPlanBus;
import com.lanou.xuhaijia.enjoylife.travel.airmap.AriPlanAty;
import com.lanou.xuhaijia.enjoylife.travel.attractions.AttractionsAty;
import com.lanou.xuhaijia.enjoylife.travel.food.FoodAty;
import com.lanou.xuhaijia.enjoylife.travel.hotel.HotelAty;
import com.lanou.xuhaijia.enjoylife.lib.CoolAnimView;
import com.lanou.xuhaijia.enjoylife.travel.search.TravelSearchAty;
import com.lanou.xuhaijia.enjoylife.travel.selectcity.CountrySelectAty;

import com.wevey.selector.dialog.DialogOnClickListener;
import com.wevey.selector.dialog.NormalAlertDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by 徐海佳 on 16/9/13.
 */
public class TravelFragment extends BaseFragment implements View.OnClickListener {

    private NormalAlertDialog dialog;
    private ImageView ivBackGround;
    private TextView tvCH;
    private TextView tvEnglish;
    private String urlId;

    private String urlImager;
    private SharedPreferences shared;
    private LinearLayout lltCityName;
    private float mCenterX;
    private float mCenterY;
    private Rotate3dAnimation outAnimation;
    private Rotate3dAnimation inAnimation;
    private AlertDialog dialogLoading;


    public TravelFragment() {
        EventBus.getDefault().register(this
        );
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_travel;
    }

    @Override
    protected void initView() {


        lltCityName = bindView(R.id.travel_ftagment_linelayout_textview_city_name_and_english);
        ImageView ivFood = bindView(R.id.travel_fragment_imager_food);
        ivFood.setOnClickListener(this);
        ImageView ivHotel = bindView(R.id.travel_fragment_imager_hotel);
        ivHotel.setOnClickListener(this);

        ImageView ivAriPlan = bindView(R.id.travel_fragment_imager_airplane);
        ivAriPlan.setOnClickListener(this);

        //数据持久化
        String name = "com.lanou.xuhaijia.enjoylife.SETTING";
        shared = mContext.getSharedPreferences(name, Context.MODE_PRIVATE);


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

        //设置地名的动画
        mCenterX = getActivity().getWindowManager().getDefaultDisplay().getWidth() / 2;
        mCenterY = getActivity().getWindowManager().getDefaultDisplay().getHeight() / 2;


    }

    @Override
    protected void initData() {

        outAnimation = new Rotate3dAnimation(0, 90, mCenterX, mCenterY);
        outAnimation.setDuration(500);
        outAnimation.setFillAfter(true);


        inAnimation = new Rotate3dAnimation(270, 360, mCenterX, mCenterY);
        inAnimation.setDuration(500);
        inAnimation.setFillAfter(true);


        CoolAnimView coolAnimView = new CoolAnimView(mContext);
        RelativeLayout layout = new RelativeLayout(mContext);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        layout.addView(coolAnimView, params);

        dialogLoading = new AlertDialog.Builder(mContext, R.style.Translucent_NoTitle)
                .setView(layout)
                .create();

        dialogLoading.show();

        //数据持久化取数据
        urlId = shared.getString("id", "32556");

        if (urlId == null) {
            urlImager = UrlValues.TRAVEL_IMGER_INITALIZE;

        } else {
            urlImager = UrlValues.TRAVEL_IMGER_HEAD + urlId;
            Log.d("TravelFragment", urlImager);
        }

        mNetTool.getData(urlImager, TravelFragmentBean.class, new NetTool.NetInterface<TravelFragmentBean>() {
            @Override
            public void onSuccess(TravelFragmentBean travelFragmentBean) {


                if (travelFragmentBean != null) {
                    dialogLoading.dismiss();


                } else {
                    dialogLoading.show();
                }


//                Glide.with(mContext).load(travelFragmentBean.getPlace().getCover()).into(ivBackGround);
                MyAsyncTask myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute(travelFragmentBean.getPlace().getCover());
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

            case R.id.travel_fragment_imager_hotel:

                Intent intentHotel = new Intent(getActivity(), HotelAty.class);

                intentHotel.putExtra("hotel", urlId);

                startActivity(intentHotel);


                break;


            case R.id.travel_fragment_imager_food:
                Intent intentFood = new Intent(getActivity(), FoodAty.class);
                intentFood.putExtra("foodId", urlId);
                startActivity(intentFood);

                break;


            case R.id.travel_fragment_imager_airplane:
                Toast.makeText(mContext, "点击", Toast.LENGTH_SHORT).show();
                Intent intentAir = new Intent(getActivity(), AriPlanAty.class);

                startActivity(intentAir);


                break;


            case R.id.travel_fragment_relative_search:

                final Intent intentSearch = new Intent(getActivity(), TravelSearchAty.class);

                startActivity(intentSearch);

                break;
            case R.id.travel_fragment_imager_position:

                dialog = new NormalAlertDialog.Builder(mContext)
                        .setHeight(0.35f)
                        .setWidth(0.8f)
                        .setTitleVisible(true)
                        .setTitleText("小青旅行是你处境旅行最有用的助手")
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


                                Intent intentSelectAty = new Intent(getContext(), CountrySelectAty.class);


                                startActivity(intentSelectAty);
                                dialog.dismiss();

                            }
                        })
                        .build();


                dialog.show();


                break;

            case R.id.travel_fragment_imager_attractions:

                Intent intentAttractions = new Intent(getActivity(), AttractionsAty.class);

                intentAttractions.putExtra("urlId", urlId);

                startActivity(intentAttractions);


                break;


        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(getActivity());
    }


    //地图传下来的网址
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getMapData(AirPlanBus airPlanBus) {

        double lat = airPlanBus.getLan();
        double lon = airPlanBus.getLon();

        urlImager = UrlValues.TRAVEL_MAP_LOCATION_HEAD + lat + "&lng=" + lon;


        mNetTool.getData(urlImager, TravelFragmentBean.class, new NetTool.NetInterface<TravelFragmentBean>() {
            @Override
            public void onSuccess(TravelFragmentBean travelFragmentBean) {
                //   Glide.with(mContext).load(travelFragmentBean.getPlace().getCover()).into(ivBackGround);

                if (travelFragmentBean.getPlace() != null) {


                    MyAsyncTask myAsyncTask = new MyAsyncTask();
                    myAsyncTask.execute(travelFragmentBean.getPlace().getCover());
                    tvCH.setText(travelFragmentBean.getPlace().getName_cn());
                    tvEnglish.setText(travelFragmentBean.getPlace().getName());
                    urlId = travelFragmentBean.getPlace().getId();

                    lltCityName.startAnimation(outAnimation);
                    lltCityName.startAnimation(inAnimation);


                    //通过数据持久化储存id
                    SharedPreferences.Editor editor = shared.edit();
                    editor.putString("id", urlId);
                    editor.apply();
                } else {
                    Toast.makeText(mContext, "暂无数据", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });


    }


    //选择城市传下来的id拼接网址EvenBus
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getData(final TravelEventBus travelEventBus) {
        urlId = travelEventBus.getUrlId();


        //通过数据持久化储存id
        SharedPreferences.Editor editor = shared.edit();
        editor.putString("id", urlId);
        editor.apply();

        urlImager = UrlValues.TRAVEL_IMGER_HEAD + urlId;

        mNetTool.getData(urlImager, TravelFragmentBean.class, new NetTool.NetInterface<TravelFragmentBean>() {
            @Override
            public void onSuccess(TravelFragmentBean travelFragmentBean) {
                //   Glide.with(mContext).load(travelFragmentBean.getPlace().getCover()).into(ivBackGround);
                if (travelFragmentBean.getPlace().getCover().equals("")) {

                    return;

                } else {
                    MyAsyncTask myAsyncTask = new MyAsyncTask();
                    myAsyncTask.execute(travelFragmentBean.getPlace().getCover());

                    tvCH.setText(travelFragmentBean.getPlace().getName_cn());
                    tvEnglish.setText(travelFragmentBean.getPlace().getName());
                }


                lltCityName.startAnimation(outAnimation);
                lltCityName.startAnimation(inAnimation);


            }

            @Override
            public void onError(String errorMsg) {

            }
        });


    }


    private class MyAsyncTask extends AsyncTask<String, Integer, Bitmap> {

        private InputStream is;
        private HttpURLConnection connection;
        private Bitmap bitmap;

        @Override
        protected Bitmap doInBackground(String... strings) {
            String picUrl = strings[0];

            try {
                URL urlPic = new URL(picUrl);
                connection = (HttpURLConnection) urlPic.openConnection();
                is = connection.getInputStream();

                bitmap = BitmapFactory.decodeStream(is);


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                try {
                    is.close();
                    connection.disconnect();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            Bitmap bitmapOut = Blur.apply(mContext, bitmap, 3);
            return bitmapOut;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

            ivBackGround.setImageBitmap(bitmap);

        }
    }
}


