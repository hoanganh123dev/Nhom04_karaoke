package com.example.nhom04_karaoke;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Song> karaokeSongs;
    SongAdapter karaokeSongAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerVIew);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        karaokeSongAdapter = new SongAdapter();
        karaokeSongs = getInitSongs();
        recyclerView.setAdapter(karaokeSongAdapter);
        karaokeSongAdapter.setList(karaokeSongs);
        ItemTouchHelper itemTouchHelper = new
                ItemTouchHelper(new SwipeToDeleteCallback(karaokeSongAdapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
    public ArrayList<Song> getInitSongs(){
        ArrayList<Song> karaokeSongs = new ArrayList<Song>();
        karaokeSongs.add(new Song("111111","Vầng trăng khóc","Đã không còn người yêu hỡi, ngày xưa ấy đôi ta bên nhau không rời\n" +
                "Ngồi trên cát nhìn biển đêm, hát vu vơ mấy câu tình ca...\n" +
                "Trái tim buồn vì thương nhớ, vì đau xót sao đôi ta mau chia lìa","Nhật Tinh Anh, Khánh Ngọc"));
        karaokeSongs.add(new Song("222222","Anh khác hay em khác","Có phải em hết yêu anh rồi\n" +
                "Em hãy nói đi người ơi\n" +
                "Anh vô tâm hay là anh đã sai","Khắc Việt"));
        karaokeSongs.add(new Song("333333","Xe đạp","Dường như nắng đã làm má em thêm hồng\n" +
                "Làm mây bay đã yêu tóc em\n" +
                "Trộm nhìn anh khẽ cười khiến em thẹn thùng","Thùy Chi"));
        karaokeSongs.add(new Song("444444","Anh nhớ em người yêu cũ","Ngày hôm nay cô đơn anh lại nhớ đến em vô cùng\n" +
                "Giờ đây em ra sao không biết em sống như thế nào\n" +
                "Từ khi ta chia tay, em theo người về nơi phương ấy","Minh Vương"));
        return karaokeSongs;
    }
    public void addItem(View view){
        karaokeSongAdapter.addNewItemByLastItem();
    }
    public class SwipeToDeleteCallback extends ItemTouchHelper.SimpleCallback {

        private SongAdapter mAdapter;

        private Drawable icon;
        private final ColorDrawable background;

        public SwipeToDeleteCallback(SongAdapter adapter) {
            super(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
            mAdapter = adapter;
            icon = getDrawable(R.drawable.images);
            background = new ColorDrawable(Color.WHITE);
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            // used for up and down movements
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();
            mAdapter.deletePosition(position);
        }

        @Override
        public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

            View itemView = viewHolder.itemView;
            int backgroundCornerOffset = 20; //so background is behind the rounded corners of itemView

            int iconMargin = (itemView.getHeight() - icon.getIntrinsicHeight()) / 2;
            int iconTop = itemView.getTop() + (itemView.getHeight() - icon.getIntrinsicHeight()) / 2;
            int iconBottom = iconTop + icon.getIntrinsicHeight();

            if (dX > 0) { // Swiping to the right
                int iconLeft = itemView.getLeft() + iconMargin;
                int iconRight = itemView.getLeft() + iconMargin  + icon.getIntrinsicWidth();
                icon.setBounds(iconLeft, iconTop, iconRight, iconBottom);

                background.setBounds(itemView.getLeft(), itemView.getTop(),
                        itemView.getLeft() + ((int) dX) + backgroundCornerOffset, itemView.getBottom());
            } else if (dX < 0) { // Swiping to the left
                int iconLeft = itemView.getRight() - iconMargin - icon.getIntrinsicWidth();
                int iconRight = itemView.getRight() - iconMargin;
                icon.setBounds(iconLeft, iconTop, iconRight, iconBottom);

                background.setBounds(itemView.getRight() + ((int) dX) - backgroundCornerOffset,
                        itemView.getTop(), itemView.getRight(), itemView.getBottom());
            } else { // view is unSwiped
                background.setBounds(0, 0, 0, 0);
            }

            background.draw(c);
            icon.draw(c);
        }
    }
}