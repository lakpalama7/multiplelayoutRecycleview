package com.liveinbits.multiplelayoutrecyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.liveinbits.multiplelayoutrecyclerview.ModelClass.ADD_LAY;
import static com.liveinbits.multiplelayoutrecyclerview.ModelClass.IMAGE_LAY;
import static com.liveinbits.multiplelayoutrecyclerview.ModelClass.USER_DETAIL_LAY;

public class CustomAdapter extends RecyclerView.Adapter {
    private List<ModelClass> listmodel;
    public CustomAdapter(List<ModelClass> list){
        listmodel=list;
    }

    @Override
    public int getItemViewType(int position) {
        switch (listmodel.get(position).getViewType()){
            case 0:
                return USER_DETAIL_LAY;
            case 1:
                return IMAGE_LAY;
            case 2:
                return ADD_LAY;
                default:
                    return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case USER_DETAIL_LAY:
                View userdetail=LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_layout,parent,false);
                return new UserDetailViewHolder(userdetail);
            case IMAGE_LAY:
                View userimage=LayoutInflater.from(parent.getContext()).inflate(R.layout.image_layout,parent,false);
                return new UserImageViewHolder(userimage);
            case ADD_LAY:
                View useradd=LayoutInflater.from(parent.getContext()).inflate(R.layout.add_layout,parent,false);
                return new UserAddViewHolder(useradd);
                default:
                    return null;

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (listmodel.get(position).getViewType()){
            case USER_DETAIL_LAY:
                String title=listmodel.get(position).getName();
               // Log.i("title ",title);
                String address=listmodel.get(position).getAddress();
                int image=listmodel.get(position).getImage();
                ((UserDetailViewHolder)holder).bindUserDetail(image,title,address);
                break;
            case IMAGE_LAY:

                int image1=listmodel.get(position).getResource();
                ((UserImageViewHolder)holder).bindUserImage(image1);
                break;
            case ADD_LAY:
                String title1=listmodel.get(position).getTitle();
                ((UserAddViewHolder)holder).bindUserAdd(title1);
                break;
                default:
                    break;
        }
    }

    @Override
    public int getItemCount() {
        return listmodel.size();
    }

    private class  UserDetailViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView titletxt;
        TextView addresstxt;
        public UserDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            titletxt=itemView.findViewById(R.id.title1);
            addresstxt=itemView.findViewById(R.id.address);
        }
        public void bindUserDetail(int image,String title,String address){
            imageView.setImageResource(image);
            titletxt.setText(title);
            addresstxt.setText(address);
        }
    }
    private class  UserImageViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public UserImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.titleimage);
        }
        public void bindUserImage(int image){
            imageView.setImageResource(image);
        }
    }
    private class  UserAddViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public UserAddViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.add);
        }
        public void bindUserAdd(String add){
            textView.setText(add);
        }
    }
}
