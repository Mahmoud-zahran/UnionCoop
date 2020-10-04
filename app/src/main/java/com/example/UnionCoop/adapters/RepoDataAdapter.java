package com.example.UnionCoop.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import com.example.UnionCoop.databinding.ListItemBinding;
import com.example.UnionCoop.model.RepositoryResponse;


import java.util.ArrayList;

/**
 * Created by Mahmoud Zahran on 2,Oct,2020
 */
public class RepoDataAdapter extends RecyclerView.Adapter<RepoDataAdapter.RepoDataViewHolder> {
    private Context mContext;
    private ArrayList<RepositoryResponse> mList;
    private ListItemBinding binding;

    public RepoDataAdapter(Context mContext, ArrayList<RepositoryResponse> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public RepoDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        binding = ListItemBinding.inflate(inflater,parent,false);
        return new RepoDataViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoDataViewHolder holder, int position) {
        holder.itemBinding.repoAuther.setText(mList.get(position).getAuthor());
        holder.itemBinding.repoName.setText(mList.get(position).getName());
        holder.itemBinding.langs.setText(mList.get(position).getLanguage());
        holder.itemBinding.forks.setText((mList.get(position).getForks())+"");
        holder.itemBinding.stars.setText(mList.get(position).getStars()+"");
        holder.itemBinding.discription.setText(mList.get(position).getDescription()+"  "+mList.get(position).getUrl());

        holder.itemBinding.mainRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RepoAdapter", "onClick: ");
                mList.get(position).setExpanded(!mList.get(position).isExpanded());
                notifyItemChanged(position);
            }
        });
        boolean isExpanded= mList.get(position).isExpanded();
        holder.itemBinding.expandableLayout.setVisibility(isExpanded? View.VISIBLE : View.GONE);

        Glide.with(mContext).load(mList.get(position).getAvatar())
                .into(holder.itemBinding.repoImage);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class RepoDataViewHolder extends RecyclerView.ViewHolder{
        private ListItemBinding itemBinding;

        public RepoDataViewHolder(ListItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }

    public  void updateList(ArrayList<RepositoryResponse> updatedList){
        mList = updatedList;
        notifyDataSetChanged();
    }

    public RepositoryResponse getRepoAt(int position){
        return mList.get(position);
    }
}
