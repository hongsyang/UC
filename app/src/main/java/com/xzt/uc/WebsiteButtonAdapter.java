package com.xzt.uc;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import java.util.List;

import static com.xzt.uc.WebsiteNavigationActivity.websitenavigationActivity;


public class WebsiteButtonAdapter extends RecyclerView.Adapter<WebsiteButtonAdapter.ViewHolder>
{
    private List<WebsiteButton> m_websitebuttonList;

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageButton websitebuttonImage;

        public ViewHolder(View view)
        //该view是RecyclerView子项最外层的布局
        {
            super(view);
            websitebuttonImage = (ImageButton) view.findViewById(R.id.website_image);
        }
    }

    public WebsiteButtonAdapter(List<WebsiteButton> websitebuttonList)
    {
        m_websitebuttonList = websitebuttonList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    //创建ViewHolder实例
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.website_item, parent, false);
        //将website_item布局加载进来
        final ViewHolder holder = new ViewHolder(view);
        holder.websitebuttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int positon = holder.getAdapterPosition();
                WebsiteButton websiteButton = m_websitebuttonList.get(positon);
                switch(websiteButton.getName())
                {
                    case "btn_website_navigation":
                        String website_navigation1 = new String("http://hao.uc.cn/?uc_param_str=dnfrpfbivecpbtntla&ch=webapp");
                        Intent intent=new Intent(websitenavigationActivity, SearchActivity.class);
                        intent.putExtra("website_navigation",website_navigation1);
                        websitenavigationActivity.startActivity(intent);
                        break;
                    case "btn_xinlangweibo":
                        String xinlangweibo1 = new String("https://m.weibo.cn/p/102803?featurecode=H5tuiguang0623&need_head_cards=1&wm=5399_0011");
                        intent=new Intent(websitenavigationActivity, SearchActivity.class);
                        intent.putExtra("xinlangweibo",xinlangweibo1);
                        websitenavigationActivity.startActivity(intent);
                        break;
                    case "btn_information_center":
                        break;
                    case "btn_aitaobao":
                        String aitaobao1 = new String("http://ai.m.taobao.com/index.html?pid=mm_32464889_3262733_48300803");
                        intent=new Intent(websitenavigationActivity, SearchActivity.class);
                        intent.putExtra("aitaobao",aitaobao1);
                        websitenavigationActivity.startActivity(intent);
                        break;
                    case "btn_tmall":
                        String tmall1 = new String("https://www.tmall.com/?ali_trackid=2:mm_32464889_8264856_54386013,ucgw1:1513784742_262_2125215735&e=2HrxR_uO40RJwp_zBTm2UDyBo7qX42Iiq-GMDEMw_rS0csgM1u99By_IAR7ok-np8sviUM61dt18MMwMNd7pGLXDZbA6IGnGHicocViyfsHsjT_0LHUgPsDB6xI5I80f7tVZTiFNFJhqE55nENphhga01w-sQ_QCKG5ExxxvJ-je6nIhCgwFJY6yjZfJ8wHPh_WaoNwutL4O4Hi3kiJ34g&type=2&tk_cps_param=32464889&tkFlag=1#/main");
                        intent=new Intent(websitenavigationActivity, SearchActivity.class);
                        intent.putExtra("tmall",tmall1);
                        websitenavigationActivity.startActivity(intent);
                        break;
                    case "btn_qunar":
                        String qunar1 = new String("http://touch.qunar.com/?bd_source=ucllqegg");
                        intent=new Intent(websitenavigationActivity, SearchActivity.class);
                        intent.putExtra("qunar",qunar1);
                        websitenavigationActivity.startActivity(intent);
                        break;
                    case "btn_a_collection_of_video":
                        break;
                    case "btn_a_collection_of_novel":
                        break;
                    case "btn_comics2":
                        break;
                    case "btn_shenma_search":
                        String shenma_search1 = new String("https://so.m.sm.cn/?uc_param_str=dnntnwvepffrgibijbprsv&from=ucjgg");
                        intent=new Intent(websitenavigationActivity, SearchActivity.class);
                        intent.putExtra("shenma_search",shenma_search1);
                        websitenavigationActivity.startActivity(intent);
                        break;
                    case "btn_ticket_taobao":
                        String ticket_taobao1 = new String("https://h5.m.taopiaopiao.com/app/moviemain/pages/index/index.html?from=outer");
                        intent=new Intent(websitenavigationActivity, SearchActivity.class);
                        intent.putExtra("ticket_taobao",ticket_taobao1);
                        websitenavigationActivity.startActivity(intent);
                        break;
                    case "btn_lifestyle":
                        String lifestyle1 = new String("http://go.uc.cn/page/life/life?uc_param_str=dnfrpfbivecpbtntla&source=webapp#!/meituan");
                        intent=new Intent(websitenavigationActivity, SearchActivity.class);
                        intent.putExtra("lifestyle",lifestyle1);
                        websitenavigationActivity.startActivity(intent);
                        break;
                    case "btn_autohome":
                        String autohome1 = new String("https://m.autohome.com.cn/?pvareaid=103175&origin=browser.uc.com");
                        intent=new Intent(websitenavigationActivity, SearchActivity.class);
                        intent.putExtra("autohome",autohome1);
                        websitenavigationActivity.startActivity(intent);
                        break;
                    case "btn_boutique":
                        break;
                    case "btn_interesting_encyclopedia":
                        String interesting_encyclopedia1 = new String("http://qiqu.uc.cn/?uc_biz_str=S:custom%7CC:web_default%7CK:false%7CN:true&uc_param_str=frpfvedncpssntnw&ch=wyyy_ip#!/index/index");
                        intent=new Intent(websitenavigationActivity, SearchActivity.class);
                        intent.putExtra("interesting_encyclopedia",interesting_encyclopedia1);
                        websitenavigationActivity.startActivity(intent);
                        break;
                    case "btn_youku_video":
                        String youku_video1 = new String("http://www.youku.com/?tpa=dW5pb25faWQ9MTAzMjU1XzEwMDAwMl8wMV8wMg");
                        intent=new Intent(websitenavigationActivity, SearchActivity.class);
                        intent.putExtra("youku_video",youku_video1);
                        websitenavigationActivity.startActivity(intent);
                        break;
                    case "btn_lottery":
                        String lottery1 = new String("https://activity.uc.cn/uclottery2017/index?entry=cp1ios&adChannel=gongyp@caipiao01IOS&uc_param_str=dsdnfrpfbivesscpgimibtbmnijblauputogpintnw&UC_ACT#!pg1&pagetype=share");
                        intent=new Intent(websitenavigationActivity, SearchActivity.class);
                        intent.putExtra("lottery",lottery1);
                        websitenavigationActivity.startActivity(intent);
                        break;
                    case "btn_add":
                        break;

                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    //用于对RecyclerView子项的数据进行赋值，在每个子项滚动到屏幕前时执行，
    // 通过position参数得到当前WebsiteButton实例，再将数据设置到ViewHolder的ImageButton中
    {
        WebsiteButton websitebutton = m_websitebuttonList.get(position);
        holder.websitebuttonImage.setBackgroundResource(websitebutton.getImageId());
    }

    @Override
    public int getItemCount()
    //告诉RecyclerView一共有多少子项
    {
        return m_websitebuttonList.size();
    }
}
