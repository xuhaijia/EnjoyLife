package com.lanou.xuhaijia.enjoylife.music.typesearch;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.music.hotmusiciandetails.HotMusicianActivity;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;

import java.util.ArrayList;

/**
 * Created by 徐海佳 on 16/9/13.
 */
public class TypeSearchFragment extends BaseFragment implements View.OnClickListener {

    private ListView lv;
    private EditText searchEt;
    private ImageView searchIv;
    private ArrayList<String> arrayList;
    private ArrayList<String> gId;
    private ListView lvSearch;

    @Override
    protected int setLayout() {
        return R.layout.fragment_typesearch;
    }

    @Override
    protected void initView() {
        lv = bindView(R.id.fragment_typesearch_lv);
        lvSearch = bindView(R.id.fragment_typesearch_lv_search);
        lvSearch.setVisibility(View.INVISIBLE);
        searchEt = bindView(R.id.fragment_typesearch_et);
        searchIv = bindView(R.id.fragment_typesearch_search);
        searchIv.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        mNetTool.getData(UrlValues.MUSIC_TYPE_SEARCH, TypeSearchBean.class, new NetTool.NetInterface<TypeSearchBean>() {

            @Override
            public void onSuccess(TypeSearchBean typeSearchBean) {
                arrayList = new ArrayList<>();
                gId = new ArrayList<>();
                for (int i = 0; i < typeSearchBean.getGenrelist().size(); i++) {
                    gId.add(typeSearchBean.getGenrelist().get(i).get(0));
                    arrayList.add(typeSearchBean.getGenrelist().get(i).get(1));
                }
                lv.setAdapter(new CommonAdapter<String>(arrayList, mContext ,R.layout.item_typesearch) {
                    @Override
                    public void setData(String s, CommonViewHolder viewHolder, int position) {
                        viewHolder.setText(R.id.item_typesearch_tv , s);
                    }

                });
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        lv.setVisibility(View.INVISIBLE);
                        lvSearch.setVisibility(View.VISIBLE);
                        mNetTool.getData(UrlValues.MUSIC_SEARCH_BYID_START + gId.get(i) + UrlValues.MUSIC_SEARCH_BYID_END
                                , TypeSearchBean.class, new NetTool.NetInterface<TypeSearchBean>() {
                                    @Override
                                    public void onSuccess(final TypeSearchBean typeSearchBean) {
                                        lvSearch.setAdapter(new CommonAdapter<TypeSearchBean.ArtistsBean>(typeSearchBean.getArtists()
                                                ,mContext ,R.layout.item_hotmusician) {
                                            @Override
                                            public void setData(TypeSearchBean.ArtistsBean artistsBean,
                                                                CommonViewHolder viewHolder, int position) {
                                                viewHolder.setText(R.id.item_hotmusician_name , artistsBean.getName());
                                                viewHolder.setText(R.id.item_hotmusician_style , artistsBean.getStyle());
                                                viewHolder.setText(R.id.item_hotmusician_care , artistsBean.getFollower() + "人关注");
                                                viewHolder.setImage(R.id.item_hotmusician_icon ,artistsBean.getPicture() , mContext );
                                            }
                                        });
                                        lvSearchItemClick(typeSearchBean);

                                    }

                                    @Override
                                    public void onError(String errorMsg) {

                                    }
                                });
                    }
                });
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_typesearch_search:
                String search = searchEt.getText().toString();
                if (search.length() != 0) {
                    lv.setVisibility(View.INVISIBLE);
                    lvSearch.setVisibility(View.VISIBLE);
                    mNetTool.getData(UrlValues.MUSIC_SEARCH_START + search + UrlValues.MUSIC_SEARCH_END
                            , TypeSearchBean.class, new NetTool.NetInterface<TypeSearchBean>() {
                                @Override
                                public void onSuccess(final TypeSearchBean typeSearchBean) {
                                    lvSearch.setAdapter(new CommonAdapter<TypeSearchBean.ArtistsBean>(typeSearchBean.getArtists() ,mContext ,R.layout.item_hotmusician) {
                                        @Override
                                        public void setData(TypeSearchBean.ArtistsBean artistsBean
                                                , CommonViewHolder viewHolder, int position) {
                                            if (typeSearchBean.getArtists() != null ) {
                                                viewHolder.setText(R.id.item_hotmusician_name, artistsBean.getName());
                                                viewHolder.setText(R.id.item_hotmusician_style, artistsBean.getStyle());
                                                viewHolder.setText(R.id.item_hotmusician_care, artistsBean.getFollower() + "人关注");
                                                viewHolder.setImage(R.id.item_hotmusician_icon, artistsBean.getPicture(), mContext);
                                            } else {
                                                Toast.makeText(mContext, "暂无该类搜索", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                    lvSearchItemClick(typeSearchBean);
                                }

                                @Override
                                public void onError(String errorMsg) {

                                }
                            });
                }
                break;
        }
    }



    private void lvSearchItemClick(final TypeSearchBean typeSearchBean) {
        lvSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext() , HotMusicianActivity.class);
                intent.putExtra("id" , typeSearchBean.getArtists().get(i).getId());
                startActivity(intent);
            }
        });
    }

}
