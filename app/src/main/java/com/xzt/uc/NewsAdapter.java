package com.xzt.uc;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import java.util.List;


import static com.xzt.uc.UCActivity.ucActivity;


/**
 * Created by 谢作通 on 2017/12/20.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>
{

    private static final String TAG = "NewsAdapter";
    private List<News> mNewsList;

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageButton newsButton;

        public ViewHolder(View view)
        {
            super(view);
            newsButton = (ImageButton) view.findViewById(R.id.news_button);
        }
    }

    public NewsAdapter(List<News> newsList)
    {
        mNewsList = newsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        Log.d(TAG, "123");
        holder.newsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int positon = holder.getAdapterPosition();
                News news = mNewsList.get(positon);
                Log.d(TAG, news.getName());
                switch(news.getName())
                {
                    case "news1":
                        String news1 = new String("http://m.sp2.uczzd.cn/webview/news?app=uc-iflow&aid=2942712240658413310&cid=51830095&zzd_from=uc-iflow&uc_param_str=dndsfrvesvntnwpfgibicpkt&recoid=17994724184429025667&rd_type=reco&sp_gz=4&pagetype=share");
                        Intent intent=new Intent(ucActivity, SearchActivity.class);
                        intent.putExtra("news1",news1);
                        ucActivity.startActivity(intent);
                        Log.d(TAG, "innerNews1");
                        break;
                    case "news2":
                        String news2 = new String("http://m2.people.cn/r/MV8wXzEwMjgyMTM3XzIyXzE1MTM3MTg4NTE=?__from=uc_zaozhidao&zzd_from=uc-iflow&sm_article_id=1473845360083326181&dl_type=3&uc_biz_str=S%3Acustom%7CC%3Aiflow_site&rd_type=reco&recoid=6434255944767358506&sp_gz=4&cid=51830095&app=uc-iflow");
                        intent=new Intent(ucActivity, SearchActivity.class);
                        intent.putExtra("news2",news2);
                        ucActivity.startActivity(intent);
                        break;
                    case "news3":
                        String news3 = new String("http://m.sp2.uczzd.cn/webview/news?app=uc-iflow&aid=1346743774735617546&cid=26325229&zzd_from=uc-iflow&uc_param_str=dndsfrvesvntnwpfgibicpkt&recoid=15546624912135674671&rd_type=reco&sp_gz=4&pagetype=share");
                        intent=new Intent(ucActivity, SearchActivity.class);
                        intent.putExtra("news3",news3);
                        ucActivity.startActivity(intent);
                        break;
                    case "news4":
                        String news4 = new String("http://m.sp2.uczzd.cn/webview/news?app=uc-iflow&aid=4360627883333708117&cid=51830095&zzd_from=uc-iflow&uc_param_str=dndsfrvesvntnwpfgibicpkt&recoid=6210570814435046935&rd_type=reco&sp_gz=4");
                        intent=new Intent(ucActivity, SearchActivity.class);
                        intent.putExtra("news4",news4);
                        ucActivity.startActivity(intent);
                        break;
                    case "news5":
                        String news5 = new String("http://m.sp2.uczzd.cn/webview/news?app=uc-iflow&aid=752557898757987657&cid=1192652582&zzd_from=uc-iflow&uc_param_str=dndsfrvesvntnwpfgibicpkt&recoid=16585291460344134012&rd_type=reco&sp_gz=4");
                        intent=new Intent(ucActivity, SearchActivity.class);
                        intent.putExtra("news5",news5);
                        ucActivity.startActivity(intent);
                        break;
                    case "news6":
                        String news6 = new String("http://m.sp2.uczzd.cn/webview/news?app=uc-iflow&aid=17355762080529491970&cid=51830095&zzd_from=uc-iflow&uc_param_str=dndsfrvesvntnwpfgibicpkt&recoid=4543554357423349823&rd_type=reco&sp_gz=4&pagetype=share");
                        intent=new Intent(ucActivity, SearchActivity.class);
                        intent.putExtra("news6",news6);
                        ucActivity.startActivity(intent);
                        break;
                    case "news7":
                        String news7 = new String("http://m.haiwainet.cn/uc/3541093/2017/1219/content_31211707_1.html?admincptm=1513683507121&zzd_from=uc-iflow&sm_article_id=10811062301607535126&dl_type=3&uc_biz_str=S%3Acustom%7CC%3Aiflow_site&rd_type=reco&recoid=18384596393034525194&sp_gz=4&cid=1105405272&app=uc-iflow");
                        intent=new Intent(ucActivity, SearchActivity.class);
                        intent.putExtra("news7",news7);
                        ucActivity.startActivity(intent);
                        break;
                    case "news8":
                        String news8 = new String("http://ag.mp.uc.cn/article.html?uc_param_str=frdnsnpfvecpntnwprdssskt&zzd_from=uc-iflow&dl_type=2&app=uc-iflow#!wm_aid=35dc10220f07447d8ed19314ccb6ccf6!!wm_id=8bd83db420224806849ec2dcde62f980");
                        intent=new Intent(ucActivity, SearchActivity.class);
                        intent.putExtra("news8",news8);
                        ucActivity.startActivity(intent);
                        break;
                    case "news9":
                        String news9 = new String("http://m.sp2.uczzd.cn/webview/news?app=uc-iflow&aid=14710865103011383743&cid=51830095&zzd_from=uc-iflow&uc_param_str=dndsfrvesvntnwpfgibicpkt&recoid=10651072925957925916&rd_type=reco&sp_gz=4&pagetype=share");
                        intent=new Intent(ucActivity, SearchActivity.class);
                        intent.putExtra("news9",news9);
                        ucActivity.startActivity(intent);
                        break;
                    case "news10":
                        String news10 = new String("http://tech.sina.cn/j_uc.d.html?docid=fypwzxq4396343&wm=3229&zzd_from=uc-iflow&sm_article_id=15261093437032235305&dl_type=3&uc_biz_str=S%3Acustom%7CC%3Aiflow_site&rd_type=reco&recoid=10651072925957925916&sp_gz=4&cid=51830095&app=uc-iflow");
                        intent=new Intent(ucActivity, SearchActivity.class);
                        intent.putExtra("news10",news10);
                        ucActivity.startActivity(intent);
                        break;


                }
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        News news = mNewsList.get(position);
        holder.newsButton.setBackgroundResource(news.getImageId());
    }

    @Override
    public int getItemCount()
    {
        return mNewsList.size();
    }
}
