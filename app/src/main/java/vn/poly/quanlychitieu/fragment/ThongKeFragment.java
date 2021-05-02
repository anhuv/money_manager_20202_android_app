package vn.poly.quanlychitieu.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.poly.quanlychitieu.R;
import vn.poly.quanlychitieu.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class ThongKeFragment extends Fragment {
    View view;
    ViewPager vpThongKe;
    TabLayout tlThongKe;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thong_ke, container, false);
        initView();


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addTabs(vpThongKe);
        tlThongKe.setupWithViewPager(vpThongKe);
    }

    public void initView(){
        vpThongKe = view.findViewById(R.id.vpThongke);
        tlThongKe =  view.findViewById(R.id.tlThongke);
    }
    public void addTabs(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new TKHomNayFragment(),"Hôm nay");
        adapter.addFrag(new TKThangFragment(),"Tháng");
        adapter.addFrag(new TKNamFragment(),"Năm");
        viewPager.setAdapter(adapter);
    }
}