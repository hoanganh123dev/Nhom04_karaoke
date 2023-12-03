package com.example.nhom04_karaoke;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder>{
    private List<Song> lstSong;
    public SongAdapter(List<Song> lstSongcs){
        lstSong = lstSongcs;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View monhocView = inflater.inflate(R.layout.item_song, parent, false);
        ViewHolder viewHolder = new ViewHolder(monhocView);
        return viewHolder;
    }
    public Song getItemAtPosition(int position) {
        return lstSong.get(position);
    }
    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
    @Override
    public void onBindViewHolder(@NonNull SongAdapter.ViewHolder holder, int position) {
        Song temp = lstSong.get(position);
        holder.txtTitle.setText(temp.Title);
        holder.txtNoiDung.setText(temp.NoiDung);
        holder.txtTenCaSi.setText(temp.TenCaSi);
        Context context = holder.imgView.getContext();
        int imageId = context.getResources().getIdentifier(temp.TenHinh, "drawable", context.getPackageName());
        if(imageId !=0)
            holder.imgView.setImageResource(imageId);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(adapterPosition);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstSong.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView txtTitle;
        TextView txtNoiDung;
        TextView txtTenCaSi;
        public ViewHolder(@NonNull View itemView){
            super(itemView);

            imgView = (ImageView) itemView.findViewById(R.id.imgSong);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtNoiDung = (TextView) itemView.findViewById(R.id.txtNoiDung);
            txtTenCaSi = (TextView) itemView.findViewById(R.id.txtTenCaSi);
        }
    }
}
