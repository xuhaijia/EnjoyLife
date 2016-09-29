package com.lanou.xuhaijia.enjoylife.tools;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.lanou.xuhaijia.enjoylife.base.MyApp;
import com.lanou.xuhaijia.enjoylife.music.hotmusiciandetails.DaoMaster;
import com.lanou.xuhaijia.enjoylife.music.hotmusiciandetails.DaoSession;
import com.lanou.xuhaijia.enjoylife.music.hotmusiciandetails.MusicianDao;
import com.lanou.xuhaijia.enjoylife.picture.details.PictureCollectBeanDao;
import com.lanou.xuhaijia.enjoylife.travel.collection.CollectionAttractBean;
import com.lanou.xuhaijia.enjoylife.travel.collection.CollectionAttractBeanDao;


import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 徐海佳 on 16/9/20.
 */
public class DBTool {
    private static DBTool ourInstance;
    private final static String dbName = "enjoy_db";
    private final DaoMaster.DevOpenHelper helper;
    private final DaoSession daoSession;
    private Handler mHandler;
    ExecutorService threadPool
            = Executors.newFixedThreadPool(MyApp.getNumberOfCPUCores() + 1);


    private DBTool() {
        mHandler = new Handler(Looper.getMainLooper());
        helper = new DaoMaster.DevOpenHelper(MyApp.getContext(), dbName);
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(sqLiteDatabase);
        daoSession = daoMaster.newSession();
    }

    public static DBTool getInstance() {
        if (ourInstance == null) {
            synchronized (DBTool.class) {
                if (ourInstance == null) {
                    ourInstance = new DBTool();
                }
            }
        }
        return ourInstance;
    }

    /**
     * //插入数据
     * t 表示加入的数据
     */
    public <T> void insertData(final T t) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                AbstractDao<T, Long> dao = (AbstractDao<T, Long>) daoSession.getDao(t.getClass());
                dao.insert(t);
            }
        });
    }


    public <T> void insertListData(final List<T> tList) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                if (tList.size() == 0) {
                    return;
                }
                T t = tList.get(0);
                AbstractDao<T, Long> dao = (AbstractDao<T, Long>) daoSession.getDao(t.getClass());
                dao.insertInTx(tList);
            }
        });
    }
    // 删除数据

    public <T> void deleteData(final T t) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                AbstractDao<T, Long> dao = (AbstractDao<T, Long>) daoSession.getDao(t.getClass());
                dao.delete(t);
            }
        });
    }


    // 删除所有t表的数据
    public <T> void deleteAllData(final T t) {
        daoSession.getDao(t.getClass()).deleteAll();
    }


    // 更新数据
    public <T> void updateData(final T t) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                AbstractDao<T, Long> dao = (AbstractDao<T, Long>) daoSession.getDao(t.getClass());
                dao.update(t);
            }
        });
    }

    // 根据单一条件查询数据  举例
    // "where name = ?" , "张三"

    /**
     * @param obj           查询哪个表 person.getClass()
     * @param condition
     * @param result
     * @param queryComplete
     * @param <T>
     */
    public <T> void queryData(final Class obj, final String condition, final String result, final QueryComplete<T> queryComplete) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                final List data = daoSession.getDao(obj).queryRaw(condition, new String[]{result});
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        queryComplete.onCompleted((T) data);
                    }
                });
            }
        });
    }

    // 查询Person根据条件
    // 必须知道表名 唯一需要单独根据自己表写
    // 为了多条件查询用

    public <T> void queryMusicianBy(
            final Class obj, final String userName, final String musicianId, final QueryComplete<T> queryComplete) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                QueryBuilder queryBuilder = daoSession.getDao(obj).queryBuilder();
                // 多条件查询
                queryBuilder.where(queryBuilder.and(MusicianDao.Properties.UserName.eq(userName),
                        MusicianDao.Properties.MusicianId.eq(musicianId)));
                final List personList = queryBuilder.list();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        queryComplete.onCompleted((T) personList);
                    }
                });
            }
        });

    }


    public <T> void queryPictureBy(final Class obj, final String userName, final String id,
                                   final QueryComplete<T> queryComplete) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                QueryBuilder queryBuilder = daoSession.getDao(obj).queryBuilder();
                queryBuilder.where(queryBuilder.and(PictureCollectBeanDao.Properties.ThreadId.eq(id),
                        PictureCollectBeanDao.Properties.Name.eq(userName)));
                final List personList = queryBuilder.list();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        queryComplete.onCompleted((T) personList);
                    }
                });
            }
        });
        //小青景点的查询
    }
    
    public <T> void queryAttration(final Class obj, final String conditionFir, final String conditionSec, final QueryComplete<T> queryComplete) {


        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                final QueryBuilder queryBuilder = daoSession.getDao(obj).queryBuilder();
                //多条件查询
                queryBuilder.where(queryBuilder.and(CollectionAttractBeanDao.Properties.NameUser.eq(conditionFir), CollectionAttractBeanDao.Properties.UrlAtt.eq(conditionSec)));

                final List attraction = queryBuilder.list();

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        queryComplete.onCompleted((T) attraction);

                    }
                });


            }
        });


    }



    // 查询所有数据
    public <T> void queryAllData(final Class obj, final QueryComplete<T> queryComplete) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                QueryBuilder<T> queryBuilder = daoSession.getDao(obj).queryBuilder();
                final List list = queryBuilder.list();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        queryComplete.onCompleted((T) list);
                    }
                });
            }
        });


    }

    // 数据查询结束回调的接口
    public interface QueryComplete<T> {
        void onCompleted(T t);
    }
}