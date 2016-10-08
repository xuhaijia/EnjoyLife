package com.lanou.xuhaijia.enjoylife.myself.musiccollection;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.music.hotmusiciandetails.HotMusicianActivity;
import com.lanou.xuhaijia.enjoylife.music.hotmusiciandetails.Musician;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;
import com.lanou.xuhaijia.enjoylife.tools.DBTool;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by 徐海佳 on 16/9/28.
 */
public class MusicianCollectionFragment extends BaseFragment {

    private ListView musicianLv;
    private BmobUser bmobUser;
    private TextView noCollectionTv;
    private BmobQuery<Musician> query;

    @Override
    protected int setLayout() {
        return R.layout.fragment_collect_musican;
    }

    @Override
    protected void initView() {
        noCollectionTv = bindView(R.id.fragment_collection_musician_tv);
        musicianLv = bindView(R.id.fragment_collection_musician_lv);
        bmobUser = BmobUser.getCurrentUser();

    }

    @Override
    protected void initData() {
        query = new BmobQuery<>();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (bmobUser != null) {
            DBTool.getInstance().queryData(Musician.class, "where USER_NAME = ?", bmobUser.getUsername(), new DBTool.QueryComplete<List<Musician>>() {
                @Override
                public void onCompleted(final List<Musician> musicians) {
                    if (musicians.size() != 0) {
                        Collections.sort(musicians , new CollectionOrder());
                        noCollectionTv.setVisibility(View.GONE);
                        setData(musicians);
                    } else {
                        query.addWhereEqualTo("userName" , bmobUser.getUsername());
                        query.setLimit(50);
                        query.findObjects(new FindListener<Musician>() {
                            @Override
                            public void done(List<Musician> list, BmobException e) {
                                if (list.size() == 0) {
                                    noCollectionTv.setVisibility(View.VISIBLE);
                                } else {
                                    if (e == null) {
                                        DBTool.getInstance().insertListData(list);
                                        Collections.sort(list , new CollectionOrder());
                                        setData(list);
                                    }
                                }

                            }
                        });
                    }
                }
            });
        }
    }

    private class CollectionOrder implements Comparator<Musician> {
        @Override
        public int compare(Musician musician, Musician t1) {
            Musician p1 = musician;
            Musician p2 = t1;
            return new Integer(p2.getTime().compareTo(p1.getTime()));
        }
    }
    private void setData(List<Musician> musicians) {
        musicianLv.setAdapter(new CommonAdapter<Musician>(musicians, mContext, R.layout.item_hotmusician) {
            @Override
            public void setData(final Musician musician, CommonViewHolder viewHolder, int position) {
                viewHolder.setText(R.id.item_hotmusician_name, musician.getName());
                viewHolder.setText(R.id.item_hotmusician_style, musician.getStyle());
                viewHolder.setText(R.id.item_hotmusician_care, musician.getCareCount() + "人关注");
                viewHolder.setImage(R.id.item_hotmusician_icon, musician.getIcon(), mContext);
                musicianLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(getContext(), HotMusicianActivity.class);
                        intent.putExtra("id", musician.getMusicianId());
                        startActivity(intent);
                    }
                });

            }
        });
    }

}
