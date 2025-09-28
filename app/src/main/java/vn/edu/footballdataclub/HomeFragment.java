package vn.edu.footballdataclub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private ViewPager2 viewPager2;
    private Handler handler;
    private int currentPage = 0;
    private int[] imgs = {R.drawable.img1, R.drawable.img2, R.drawable.img3};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager2 = view.findViewById(R.id.slideShowContainer);
        SlideShowAdapter slideShowAdapter = new SlideShowAdapter(imgs);
        viewPager2.setAdapter(slideShowAdapter);
        handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (currentPage == imgs.length) {
                    currentPage = 0;
                }
                viewPager2.setCurrentItem(currentPage++, true);
                handler.postDelayed(this, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);

        RecyclerView recyclerView = view.findViewById(R.id.viewClubs);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Club> clubs = new ArrayList<>();
        clubs.add(new Club(1, "Real Madrid", "Spain", 480, R.drawable.ic_real_madrid, R.drawable.ic_spain));
        clubs.add(new Club(2, "Inter Milan", "Italy", 469, R.drawable.ic_real_madrid, R.drawable.ic_spain));
        clubs.add(new Club(3, "Paris Saint-Germain", "France", 462, R.drawable.ic_real_madrid, R.drawable.ic_spain));
        clubs.add(new Club(4, "Barcelona", "Spain", 434 , R.drawable.ic_real_madrid, R.drawable.ic_spain));
        clubs.add(new Club(5, "Bayern Munich", "Germany", 411, R.drawable.ic_real_madrid, R.drawable.ic_spain));
        clubs.add(new Club(6, "Chelsea", "England", 386, R.drawable.ic_real_madrid, R.drawable.ic_spain));
        clubs.add(new Club(7, "Arsenal", "England", 362, R.drawable.ic_real_madrid, R.drawable.ic_spain));
        clubs.add(new Club(8, "Atlético Madrid", "Spain", 361, R.drawable.ic_real_madrid, R.drawable.ic_spain));
        clubs.add(new Club(9, "Borussia Dortmund", "Germany", 349, R.drawable.ic_real_madrid, R.drawable.ic_spain));
        clubs.add(new Club(10, "Liverpool", "England", 337, R.drawable.ic_real_madrid, R.drawable.ic_spain));
        HomeRankingAdapter homeRankingAdapter = new HomeRankingAdapter(clubs);
        recyclerView.setAdapter(homeRankingAdapter);
        return view;
    }
}