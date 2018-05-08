package startandroid.ru.mypagertest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Romjke on 17.04.2018.
 */

public class PageFragment extends Fragment {

    public final static String ARG_PAGE = "arg_page";


    private int mPage;
    private DayOfWeek day;

    public static PageFragment newInstance(int page, DayOfWeek day) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        args.putString("ololo", day.toString());
        PageFragment pageFragment = new PageFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        if (getArguments() != null) {
            mPage = getArguments().getInt(ARG_PAGE);
            day = DayOfWeek.valueOf(getArguments().getString("ololo"));
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.my_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        List<Element> elements = new ArrayList<>();
        if (day == DayOfWeek.Mon) {
            elements.add(new Element("Моделирование", "Лекция", "666", "Родионов Алексей Сергеевич"));
            elements.add(new Element("saod", "practice", "666", "machine"));
            elements.add(new Element("saod", "practice", "666", "machine"));


        } else if (day == DayOfWeek.Tue) {
            elements.add(new Element("zzzz", "7", "7", "7"));
            elements.add(new Element("hzz", "2", "2", "3"));

        } else if (day == DayOfWeek.Wen) {
            elements.add(new Element("3", "4", "5", "6"));
            elements.add(new Element("999", "999", "999", "999"));
        }

//        ImageView ivImg = view.findViewById(R.id.ivImg);
//        ivImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (v.getId()) {
//                    case R.id.ivImg:
////                        Toast.makeText(PageFragment.this, "Я сделяль", Toast.LENGTH_LONG).show();
////                        Toast.makeText(view.getContext(), "Я сделяль", Toast.LENGTH_LONG).show();
//                        break;
//                }
//            }
//        });

        // specify an adapter (see also next example)
        MyAdapter adapter = new MyAdapter(elements);
        recyclerView.setAdapter(adapter);

//        TextView ItemTitle = view.findViewById(R.id.tvItemTitle);
//        ItemTitle.setText(day.toString());
//        TextView TypeOfItem = view.findViewById(R.id.tvTypeOfItem);
//        TypeOfItem.setText("Practice");
//        TextView LectureHall = view.findViewById(R.id.tvLectureHall);
//        LectureHall.setText("322");
//        TextView TeacherName = view.findViewById(R.id.tvTeacherName);
//        TeacherName.setText("Povetkin R.S.");

        return view;
    }
}
