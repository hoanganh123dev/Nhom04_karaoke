package com.example.nhom04_karaoke;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class MainActivity extends AppCompatActivity {
    private List<Song> lstSong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvMonHoc = (RecyclerView) findViewById(R.id.rcvSong);
        SongAdapter adapter = new SongAdapter(Song.LayDSSong());
        rvMonHoc.setAdapter(adapter);
        rvMonHoc.setHasFixedSize(true);
        rvMonHoc.scrollToPosition(2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        layoutManager.scrollToPosition(1);
        rvMonHoc.setLayoutManager(layoutManager);
        rvMonHoc.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        rvMonHoc.addItemDecoration(itemDecoration);
        rvMonHoc.setItemAnimator(new SlideInUpAnimator());
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lstSong.add(0, new Song("didong", "ZZZ", "XXX","YYY"));
                adapter.notifyItemInserted(0);
            }
        });
        adapter.setOnItemClickListener(new SongAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Song song = adapter.getItemAtPosition(position);
                // Hiển thị thông tin chi tiết môn học trong AlertDialog
                showMonHocDetailDialog(song);
            }
        });
        rvMonHoc.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return false;
            }
            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }
    private void showMonHocDetailDialog(Song song) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin môn học");

        // Tạo nội dung cho AlertDialog từ thông tin của môn học
        String monHocDetail = "Title: " + song.getTitle() + "\n"
                + "Nội Dung: " + song.getNoiDung() + "\n"
                + "Tên Ca Sĩ: " + song.getTenCaSi() + "\n";

        builder.setMessage(monHocDetail);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}