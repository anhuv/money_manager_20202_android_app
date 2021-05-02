package vn.poly.quanlychitieu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import vn.poly.quanlychitieu.R;

import vn.poly.quanlychitieu.adapter.LoaiThuAdapter;
import vn.poly.quanlychitieu.dao.LoaiThuDAO;
import vn.poly.quanlychitieu.model.LoaiThu;

import java.util.List;

public class ListLoaiThuActivity extends AppCompatActivity {
    LoaiThuAdapter adapter;
    LoaiThuDAO loaiThuDAO;
    ListView lvLoaiThu;
    List<LoaiThu> loaiThuList;
    ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_loai_thu);
        setupToolbar();
        lvLoaiThu = findViewById(R.id.lvLoaiThu);
        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        loaiThuDAO = new LoaiThuDAO(this);
        loaiThuList = loaiThuDAO.getAllLoaiThu();
        adapter = new LoaiThuAdapter(this,loaiThuList);
        lvLoaiThu.setAdapter(adapter);

    }
    public void setupToolbar(){
        setTitle("");
        Toolbar toolbar = findViewById(R.id.toolbarListLoaiThu);
        setSupportActionBar(toolbar);
        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Loại thu nhập");
    }

    public void them(View view) {
        startActivity(new Intent(getApplicationContext(),ThemLoaiThuActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        loaiThuList.clear();
        loaiThuList = loaiThuDAO.getAllLoaiThu();
        adapter.setDataChange(loaiThuList);
    }
}