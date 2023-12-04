package com.example.nhom04_karaoke;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolderCustom>{
    private ArrayList<Song> karaokeSongs;

    public void setList(ArrayList<Song> karaokeSongs) {
        this.karaokeSongs = karaokeSongs;
        this.notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolderCustom onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderCustom(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_song, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCustom holder, int position) {
        holder.bindData(karaokeSongs.get(position));
    }

    public void addNewItemByLastItem() {
        if(getItemCount()==0)return;
        karaokeSongs.add(karaokeSongs.get(karaokeSongs.size()-1));
        notifyItemInserted(karaokeSongs.size());
    }
    public void deletePosition(Integer position) {
        this.karaokeSongs.remove(karaokeSongs.get(position));
        this.notifyItemRemoved(position);
        this.notifyItemRangeChanged(position, getItemCount());
        System.out.println("position"+position+"count"+getItemCount());
    }

    @Override
    public int getItemCount() {
        return karaokeSongs != null ? karaokeSongs.size() : 0;
    }

    class ViewHolderCustom extends RecyclerView.ViewHolder {

        private TextView code;
        private TextView title;
        private TextView description;
        private TextView author;

        public ViewHolderCustom(View itemView) {
            super(itemView);
            code = (TextView) itemView.findViewById(R.id.karaokeCode);
            title = (TextView) itemView.findViewById(R.id.karaokeTitle);
            description = (TextView) itemView.findViewById(R.id.karaokeDescription);
            author = (TextView) itemView.findViewById(R.id.karaokeAuthor);
        }

        public void bindData(Song item) {
            code.setText(item.Code);
            title.setText(item.Title);
            description.setText(item.Description);
            author.setText(item.Author);
        }
    }
}
