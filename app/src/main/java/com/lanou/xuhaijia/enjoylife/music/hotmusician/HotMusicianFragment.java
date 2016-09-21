package com.lanou.xuhaijia.enjoylife.music.hotmusician;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.music.hotmusiciandetails.HotMusicianActivity;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;
import com.lanou.xuhaijia.enjoylife.tools.MyListView;

/**
 * Created by 徐海佳 on 16/9/13.
 */
public class HotMusicianFragment extends BaseFragment{

    private MyListView lv;

    @Override
    protected int setLayout() {
        return R.layout.fragment_hotmusician;
    }

    @Override
    protected void initView() {
        lv = bindView(R.id.fragment_hotmusician_lv);
    }

    @Override
    protected void initData() {
        mNetTool.getData(UrlValues.MUSIC_HOT_MUSICIAN, HotMusicianBean.class, new NetTool.NetInterface<HotMusicianBean>() {
            @Override
            public void onSuccess(final HotMusicianBean hotMusicianBean) {

                lv.setAdapter(new CommonAdapter<HotMusicianBean.ArtistsBean>(hotMusicianBean.getArtists()
                        , mContext , R.layout.item_hotmusician) {
                    @Override
                    public void setData(HotMusicianBean.ArtistsBean artistsBean, CommonViewHolder viewHolder , int position) {
                        viewHolder.setText(R.id.item_hotmusician_name , artistsBean.getName());
                        viewHolder.setText(R.id.item_hotmusician_style , artistsBean.getStyle());
                        viewHolder.setText(R.id.item_hotmusician_care , artistsBean.getFollower() + "人关注");
                        viewHolder.setImage(R.id.item_hotmusician_icon ,artistsBean.getPicture() , mContext );
                    }
                });
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(getContext() , HotMusicianActivity.class);
                        intent.putExtra("id" , hotMusicianBean.getArtists().get(i).getId());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
