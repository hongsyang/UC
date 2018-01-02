package com.xzt.uc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.litepal.crud.DataSupport;
import java.util.ArrayList;
import java.util.List;
import static com.xzt.uc.SearchActivity.webView;
import static com.xzt.uc.UCActivity.ucActivity;
import static com.xzt.uc.SearchActivity.searchActivity;
public class HistoryFragment extends Fragment {
    public List<History> historyList=new ArrayList<>();
    public List<Boolean> list=new ArrayList<>();
    public Button button;
    boolean isShow=false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.history_layout,container,false);
        initHistories();
        RecyclerView mRecyclerView=(RecyclerView)view.findViewById(R.id.historylist);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        final HistoryAdapter adapter=new HistoryAdapter(historyList,getActivity(),list);
        mRecyclerView.setAdapter(adapter);
        final Button edit=(Button)view.findViewById(R.id.edit_his);
        final Button selectall=(Button) view.findViewById(R.id.allselect);
        final Button delete=(Button) view.findViewById(R.id.delete);
        this.button=delete;
        delete.setVisibility(View.GONE);
        selectall.setVisibility(View.GONE);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isShow==false){
                    edit.setText("完成");
                    delete.setVisibility(View.VISIBLE);
                    delete.setEnabled(false);
                    selectall.setVisibility(View.VISIBLE);
                    isShow=true;
                    adapter.notifyDataSetChanged();
                }
                else{
                    edit.setText("编辑");
                    isShow=false;
                    delete.setVisibility(View.GONE);
                    selectall.setVisibility(View.GONE);
                    adapter.count=0;
                    for (int i=0;i<adapter.mList.size();i++)
                        adapter.mList.set(i,false);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        selectall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectall.getText()=="取消全选"){
                    selectall.setText("全选");
                    adapter.setCount(0);
                    for(int i=0;i<list.size();i++){
                        adapter.mList.set(i,false);
                    }
                    adapter.notifyDataSetChanged();
                }
                else{
                    selectall.setText("取消全选");
                    adapter.setCount(adapter.mList.size()-3);
                    for(int i=0;i<list.size();i++){
                        if(!historyList.get(i).gettag())
                            adapter.mList.set(i,true);
                    }
                    adapter.notifyDataSetChanged();
                }
                countdelete(adapter.count);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<adapter.mList.size();i++){
                    if(adapter.mList.get(i)){
                        DataSupport.delete(HistoryDatabase.class,adapter.mHistory.get(i).getId());
                        adapter.mList.remove(i);
                        adapter.mHistory.remove(i);
                        adapter.count-=1;
                        i-=1;
                    }
                }
                edit.setText("编辑");
                isShow=false;
                delete.setVisibility(View.GONE);
                selectall.setVisibility(View.GONE);
                adapter.notifyDataSetChanged();
                countdelete(0);
            }
        });
        return view;
    }
    public void countdelete(int count){
        if(count!=0){
            button.setText("删除("+count+")");
            button.setEnabled(true);
        }
        else{
            button.setText("删除");
            button.setEnabled(false);
        }
    }

    public void initHistories(){
        History hhistory=new History();
        hhistory.setTitle("今天");
        hhistory.setUrl(null);
        hhistory.setTag(true);
        list.add(false);
        historyList.add(hhistory);
        List<HistoryDatabase>historyDatabases=DataSupport.findAll(HistoryDatabase.class);
        for(int i=DataSupport.count(HistoryDatabase.class)-1;i>=1;i--) {
            History history = new History();
            HistoryDatabase historyDatabase=historyDatabases.get(i);
            if(historyDatabase.getTitle()!=null){
                history.setTag(false);
                history.setTitle(historyDatabase.getTitle());
                history.setUrl(historyDatabase.getUrl());
                history.setId(historyDatabase.getId());
                list.add(false);
                historyList.add(history);}
        }
        History Yhistory=new History();
        Yhistory.setTitle("昨天");
        Yhistory.setUrl(null);
        Yhistory.setTag(true);
        historyList.add(Yhistory);
        list.add(false);
        History Lhistory=new History();
        Lhistory.setTitle("更早以前");
        Lhistory.setUrl(null);
        Lhistory.setTag(true);
        historyList.add(Lhistory);
        list.add(false);
    }
    class HistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<History> mHistory;
        public List<Boolean> mList;
        public int count=0;
        private static final int TYPE_TITLE=1;
        private static final int TYPE_URL=0;
        private Context mcontext;
        private String returnUrl;
        public HistoryAdapter(List<History> historyList,Context context,List<Boolean> List) {
            mHistory=historyList;
            mcontext=context;
            mList=List;
        }
        public class UrlViewHolder extends RecyclerView.ViewHolder{
            TextView historytitle;
            TextView historyUrl;
            View historyview;
            CheckBox checkBox;
            public UrlViewHolder(View view)
            {
                super(view);
                historyview=view;
                historytitle=(TextView)view.findViewById(R.id.historytitle);
                historyUrl=(TextView)view.findViewById(R.id.historyUrl);
                checkBox=(CheckBox)view.findViewById(R.id.check_box);
            }
        }
        public class TitleViewHolder extends RecyclerView.ViewHolder{
            TextView history_group_title;
            public TitleViewHolder(View view){
                super(view);
                history_group_title=(TextView)view.findViewById(R.id.group_title);
            }
        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
            final LayoutInflater mInflater = LayoutInflater.from (mcontext);
            switch (viewType){
                case TYPE_URL:
                    ViewGroup vUrl=(ViewGroup)mInflater.inflate(R.layout.history_item,parent,false);
                    final UrlViewHolder vhUrl=new UrlViewHolder(vUrl);
                    vhUrl.historyview.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int position=vhUrl.getAdapterPosition();
                            if(!isShow){
                                History history=mHistory.get(position);
                                returnUrl=history.getUrl();
                                if(ucActivity!=null) {
                                    if (searchActivity != null) {
                                        webView.loadUrl(returnUrl);
                                        ucActivity.finish();
                                    } else {
                                        ucActivity.finish();
                                        Intent intent = new Intent(getActivity(), SearchActivity.class);
                                        intent.putExtra("str",returnUrl);
                                        startActivity(intent);
                                    }
                                }
                                getActivity().finish();
                            }
                            else{
                                if(vhUrl.checkBox.isChecked()){
                                    vhUrl.checkBox.setChecked(false);
                                    mList.set(position,false);
                                    count-=1;
                                }
                                else{
                                    vhUrl.checkBox.setChecked(true);
                                    mList.set(position,true);
                                    count+=1;
                                }
                                countdelete(count);
                            }
                        }
                    });
                    return vhUrl;
                case TYPE_TITLE:
                    ViewGroup vTitle=(ViewGroup)mInflater.inflate(R.layout.history_item_tag,parent,false);
                    TitleViewHolder vhTitle=new TitleViewHolder(vTitle);
                    return vhTitle;
            }
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            History history=mHistory.get(position);
            switch ( holder.getItemViewType () ) {
                case TYPE_URL:
                    final UrlViewHolder urlViewHolder=(UrlViewHolder)holder;
                    urlViewHolder.historytitle.setText(history.getTitle());
                    urlViewHolder.historyUrl.setText(history.getUrl());
                    urlViewHolder.checkBox.setChecked(mList.get(position));
                    if(isShow){
                        urlViewHolder.checkBox.setVisibility(View.VISIBLE);
                    }
                    else{
                        urlViewHolder.checkBox.setVisibility(View.GONE);
                    }
                    break;
                case TYPE_TITLE:
                    TitleViewHolder titleViewHolder=(TitleViewHolder)holder;
                    titleViewHolder.history_group_title.setText(history.getTitle());
                    break;
            }
        }
        private boolean isTitle(int pos){
            if(mHistory.get(pos).gettag()==true)
                return true;
            else
                return false;
        }

        @Override
        public int getItemCount(){
            return mHistory.size();
        }
        public int getItemViewType(int position){
            int viewtype;
            if (!isTitle(position) ) {
                viewtype = TYPE_URL;
            } else {
                viewtype = TYPE_TITLE;
            }
            return viewtype;
        }
        public void setCount(int x){
            this.count=x;
        }
    }
}
