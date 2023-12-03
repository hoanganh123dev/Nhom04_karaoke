package com.example.nhom04_karaoke;

import java.util.ArrayList;
import java.util.List;

public class Song {
    public String TenHinh;
    public String Title;
    public String NoiDung;
    public String TenCaSi;

    public Song(String tenHinh, String title, String noiDung, String tenCaSi) {
        TenHinh = tenHinh;
        Title = title;
        NoiDung = noiDung;
        TenCaSi = tenCaSi;
    }
    public static List<Song> LayDSSong(){
        List<Song> lstMonHoc = new ArrayList<>();
        lstMonHoc.add(new Song("didong","Hit Me Up","Phone cho anh những lúc em một mình, sau đó làm gì thì gặp rồi sẽ biết\n" +
                "Không ai mang cho em feeling nhiều vậy, anh biết anh sẽ là người làm em điên\n" +
                "Trời dù mưa", "Binz"));
        lstMonHoc.add(new Song("java","Lạc Trôi","Ah ah\n" +
                "Người theo hương hoa mây mù giăng lối\n" +
                "Làn sương khói phôi phai đưa bước ai xa rồi\n" +
                "Đơn côi mình ta vấn vương", "Sơn Tùng"));
        lstMonHoc.add(new Song("window","Tam Giác","Haiz\n" +
                "Woah, woah, woah\n" +
                "Huh-huh huh-huh\n" +
                "Zui zẻ nhở?", "Anh Phan"));
        return lstMonHoc;
    }
    public String getTenHinh() {
        return TenHinh;
    }

    public void setTenHinh(String tenHinh) {
        TenHinh = tenHinh;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getTenCaSi() {
        return TenCaSi;
    }

    public void setTenCaSi(String tenCaSi) {
        TenCaSi = tenCaSi;
    }



}
