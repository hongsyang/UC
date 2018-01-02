package com.xzt.uc;


import android.app.Activity;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.xzt.uc.Favorite;
import com.xzt.uc.R;

import org.litepal.crud.DataSupport;
import java.util.ArrayList;
import java.util.List;


public class favoriteFragment extends Fragment {
    private List<Favorite> favoriteList=new ArrayList<>();
    public List<Boolean> list=new ArrayList<>();
    boolean isShow=false;
    public Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.favorite_layout,container,false);
        Favorite ipad_fav=new Favorite();
        ipad_fav.setUrl(null);
        ipad_fav.setTitle("云收藏(iPad)");
        ipad_fav.setImageId(R.drawable.ipad_img);
        favoriteList.add(ipad_fav);
        list.add(false);
        Favorite computer_fav=new Favorite();
        computer_fav.setUrl(null);
        computer_fav.setTitle("云收藏(电脑)");
        computer_fav.setImageId(R.drawable.computer_img);
        favoriteList.add(computer_fav);
        list.add(false);
        initfavorite();
        RecyclerView favoriteRecyclerView=(RecyclerView)view.findViewById(R.id.favorite_recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        favoriteRecyclerView.setLayoutManager(layoutManager);
        final FavoriteAdapter adapter=new FavoriteAdapter(favoriteList,getActivity(),list);
        favoriteRecyclerView.setAdapter(adapter);
        final Button delete=(Button) view.findViewById(R.id.delete_fav);
        final Button edit=(Button)view.findViewById(R.id.edit_fav);
        final Button selectall=(Button) view.findViewById(R.id.allselect_fav);
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
                    for(int i=2;i<list.size();i++){
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
                        DataSupport.delete(Favorite.class,adapter.mFavoriteList.get(i).getId());
                        adapter.mList.remove(i);
                        adapter.mFavoriteList.remove(i);
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
    public void initfavorite(){
        List<Favorite>favorites=DataSupport.findAll(Favorite.class);
        for(int i=DataSupport.count(Favorite.class)-1;i>=1;i--) {
            Favorite favorite = new Favorite();
            Favorite favorite1=favorites.get(i);
            favorite.setTitle(favorite1.getTitle());
            favorite.setUrl(favorite1.getUrl());
            favorite.setId(favorite1.getId());
            favorite.setImageId(R.drawable.web);
            list.add(false);
            favoriteList.add(favorite);
        }
    }
    class FavoriteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<Favorite> mFavoriteList;
        public List<Boolean> mList;
        public int count=0;
        private Context mcontext;
        private String returnUrl;
        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView favoriteImage;
            TextView favoritetile;
            CheckBox checkBox;
            View favoriteView;
            public ViewHolder(View view) {
                super(view);
                favoriteView=view;
                favoriteImage = (ImageView) view.findViewById(R.id.favorite_img);
                favoritetile = (TextView) view.findViewById(R.id.favorite_title);
                checkBox=(CheckBox)view.findViewById(R.id.check_box_fav);
            }
        }
        public FavoriteAdapter(List<Favorite> FavoriteList, Context context, List<Boolean> List){
            mFavoriteList=FavoriteList;
            mcontext=context;
            mList=List;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final LayoutInflater mInflater = LayoutInflater.from (mcontext);
            ViewGroup vUrl=(ViewGroup)mInflater.inflate(R.layout.favorite_item,parent,false);
            final ViewHolder holder=new ViewHolder(vUrl);
            holder.favoriteView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=holder.getAdapterPosition();
                    if(!isShow){
                        Favorite favorite=mFavoriteList.get(position);
                        returnUrl=favorite.getUrl();
                        Intent intent=new Intent();
                        intent.putExtra("data_return",returnUrl);
                        getActivity().setResult(Activity.RESULT_OK,intent);
                        getActivity().finish();
                    }
                    else{
                        if(holder.checkBox.isChecked()){
                            holder.checkBox.setChecked(false);
                            mList.set(position,false);
                            count-=1;
                        }
                        else{
                            holder.checkBox.setChecked(true);
                            mList.set(position,true);
                            count+=1;
                        }
                        countdelete(count);
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Favorite favorite=mFavoriteList.get(position);
            ViewHolder holder1=(ViewHolder) holder;
            holder1.favoriteImage.setImageResource(favorite.getImageId());
            holder1.favoritetile.setText(favorite.getTitle());
            holder1.checkBox.setChecked(mList.get(position));
            if(isShow&&position>1){
                holder1.checkBox.setVisibility(View.VISIBLE);
            }
            else{
                holder1.checkBox.setVisibility(View.GONE);
            }
        }

        @Override
        public int getItemCount() {
            return mFavoriteList.size();
        }
        public void setCount(int x){
            this.count=x;
        }
    }
}
