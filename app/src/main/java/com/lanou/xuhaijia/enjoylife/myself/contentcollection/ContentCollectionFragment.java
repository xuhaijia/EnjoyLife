package com.lanou.xuhaijia.enjoylife.myself.contentcollection;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.myself.MyBmobUser;
import com.lanou.xuhaijia.enjoylife.picture.details.DetailsActivity;
import com.lanou.xuhaijia.enjoylife.picture.details.PictureCollectBean;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;
import com.lanou.xuhaijia.enjoylife.tools.DBTool;

import java.util.List;

/**
 * Created by 史静雯 on 16/9/28.
 */
public class ContentCollectionFragment extends BaseFragment {

    private ListView mListView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_collect_content;
    }

    @Override
    protected void initView() {
        mListView = bindView(R.id.fragment_content_list_view);
    }

    @Override
    protected void initData() {
        MyBmobUser myBmobUser = MyBmobUser.getCurrentUser(MyBmobUser.class);
        DBTool.getInstance().queryData(PictureCollectBean.class, "where name = ?", myBmobUser.getUsername(),
                new DBTool.QueryComplete<List<PictureCollectBean>>(){
                    @Override
                    public void onCompleted(List<PictureCollectBean> pictureCollectBeen) {
                        mListView.setAdapter(new CommonAdapter<PictureCollectBean>((List<PictureCollectBean>) pictureCollectBeen,
                                mContext, R.layout.fragment_content_item) {
                            @Override
                            public void setData(final PictureCollectBean pictureCollectBean, CommonViewHolder viewHolder, int position) {
                                viewHolder.setText(R.id.fragment_content_content, pictureCollectBean.getContent());
                                viewHolder.setImage(R.id.fragment_content_icon, pictureCollectBean.getIconUrl(), mContext);
                                viewHolder.setText(R.id.fragment_content_title, pictureCollectBean.getTitle());
                                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        Intent intent = new Intent(getActivity(),DetailsActivity.class);
                                        intent.putExtra("ID",pictureCollectBean.getThreadId());
                                        startActivity(intent);
                                    }
                                });
                            }
                        });
                    }
                }
        );
    }
}
