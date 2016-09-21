package com.lanou.xuhaijia.enjoylife.music.hotmusiciandetails;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.music.photoin.PhotoInActivity;
import com.lanou.xuhaijia.enjoylife.music.songsin.SongsInActivity;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;

/**
 * Created by 徐海佳 on 16/9/18.
 */
public class LvFragment extends BaseFragment {

    private ListView lv;
    private TextView tv;

    @Override
    protected int setLayout() {
        return R.layout.fragment_lv;
    }

    @Override
    protected void initView() {
        lv = bindView(R.id.fragment_lv_lv);
        tv = bindView(R.id.fragment_lv_tv);
        tv.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        String id = bundle.getString("id");
        String type = bundle.getString("type");

        if ("songs".equals(type)) {
            mNetTool.getData(UrlValues.MUSIC_CARE_SONGS_START + id + UrlValues.MUSIC_CARE_SONGS_END,
                    SongsBean.class, new NetTool.NetInterface<SongsBean>() {
                        @Override
                        public void onSuccess(final SongsBean songsBean) {
                            if (songsBean.getPlaylist().size() == 0) {
                                tv.setVisibility(View.VISIBLE);
                            } else {
                                lv.setAdapter(new CommonAdapter<SongsBean.PlaylistBean>(songsBean.getPlaylist(),
                                        mContext, R.layout.item_typesearch) {
                                    @Override
                                    public void setData(SongsBean.PlaylistBean playlistBean
                                            , CommonViewHolder viewHolder, int position) {
                                        viewHolder.setText(R.id.item_typesearch_tv, playlistBean.getTitle());
                                    }
                                });
                                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        Intent intent = new Intent(getContext(), SongsInActivity.class);
                                        intent.putExtra("id", songsBean.getPlaylist().get(i).getId());
                                        startActivity(intent);
                                    }
                                });
                            }
                        }

                        @Override
                        public void onError(String errorMsg) {

                        }
                    });


        } else if ("activity".equals(type)){
            mNetTool.getData(UrlValues.MUSIC_CARE_ACTIVITY_START + id + UrlValues.MUSIC_CARE_ACTIVITY_END
                    , SongsBean.class, new NetTool.NetInterface<SongsBean>() {
                        @Override
                        public void onSuccess(SongsBean songsBean) {
                            if (songsBean.getEvents().size() == 0) {
                                tv.setVisibility(View.VISIBLE);
                            } else {
                                lv.setAdapter(new CommonAdapter<SongsBean.EventsBean>(songsBean.getEvents(),
                                        mContext, R.layout.item_event) {
                                    @Override
                                    public void setData(SongsBean.EventsBean eventsBean,
                                                        CommonViewHolder viewHolder, int position) {
                                        viewHolder.setText(R.id.item_event_month, eventsBean.getMonth() + "月");
                                        viewHolder.setText(R.id.item_event_day, eventsBean.getDay() + "");
                                        viewHolder.setText(R.id.item_event_title, eventsBean.getTitle());
                                        viewHolder.setText(R.id.item_event_time, eventsBean.getAbstractX());
                                        viewHolder.setImage(R.id.item_event_icon, eventsBean.getIcon(), mContext);
                                    }
                                });
                            }
                        }
                        @Override
                        public void onError(String errorMsg) {

                        }

                    });

        } else if ("photo".equals(type)) {
            mNetTool.getData(UrlValues.MUSIC_CARE_PHOTO_START + id + UrlValues.MUSIC_CARE_PHOTO_END,
                    SongsBean.class, new NetTool.NetInterface<SongsBean>() {
                        @Override
                        public void onSuccess(final SongsBean songsBean) {
                            if (songsBean.getAlbums().size() == 0) {
                                tv.setVisibility(View.VISIBLE);
                            } else {
                                lv.setAdapter(new CommonAdapter<SongsBean.AlbumsBean>(songsBean.getAlbums()
                                        , mContext, R.layout.item_photo) {
                                    @Override
                                    public void setData(SongsBean.AlbumsBean albumsBean,
                                                        CommonViewHolder viewHolder, int position) {
                                        viewHolder.setText(R.id.item_photo_name, albumsBean.getTitle());
                                        viewHolder.setImage(R.id.item_photo_icon, albumsBean.getCover(), mContext);
                                    }
                                });
                                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        Intent intent = new Intent(getContext(), PhotoInActivity.class);
                                        intent.putExtra("id", songsBean.getAlbums().get(i).getId());
                                        startActivity(intent);
                                    }
                                });
                            }
                        }
                        @Override
                        public void onError(String errorMsg) {

                        }
                    });

        } else if ("message".equals(type)) {
            mNetTool.getData(UrlValues.MUSIC_CARE_MESSAGE_START + id + UrlValues.MUSIC_CARE_MESSAGE_END,
                    SongsBean.class, new NetTool.NetInterface<SongsBean>() {
                        @Override
                        public void onSuccess(SongsBean songsBean) {
                            if (songsBean.getMessages().size() == 0) {
                                tv.setVisibility(View.VISIBLE);
                            } else {
                                lv.setAdapter(new CommonAdapter<SongsBean.MessagesBean>(songsBean.getMessages()
                                        , mContext, R.layout.item_message) {
                                    @Override
                                    public void setData(SongsBean.MessagesBean messagesBean,
                                                        CommonViewHolder viewHolder, int position) {
                                        viewHolder.setImage(R.id.item_message_icon, messagesBean.getIcon(), mContext);
                                        viewHolder.setText(R.id.item_message_content, messagesBean.getAuthor() + ":   " +
                                                messagesBean.getContent());

                                    }
                                });
                            }
                        }
                        @Override
                        public void onError(String errorMsg) {

                        }
                    });
        }

    }
}
