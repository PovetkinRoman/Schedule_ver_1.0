package startandroid.ru.mypagertest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Romjke on 22.04.2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Element> elements;
    //private final View.OnClickListener mOnClickListener = new MyOnClickListener();

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        private View view;
        private TextView itemTitle;
        private TextView typeOfItem;
        private TextView lectureHall;
        private TextView teacherName;
        private ImageView ivImg;
        ViewHolder(View v, TextView itemTitle, TextView typeOfItem, TextView lectureHall,
                   TextView teacherName, ImageView ivImg) {
            super(v);
            view = v;
            this.itemTitle = itemTitle;
            this.typeOfItem = typeOfItem;
            this.lectureHall = lectureHall;
            this.teacherName = teacherName;
            this.ivImg = ivImg;
            ivImg.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
                Toast.makeText(view.getContext(), "Нажат item " + getAdapterPosition() + " я сделяль",
                        Toast.LENGTH_SHORT).show();
        }

//        public static class MyOnClickListener implements View.OnClickListener {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(view.getContext(), "Я сделяль", Toast.LENGTH_SHORT).show();
//            }
//        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Element> elements) {
        this.elements = elements;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);
        // set the view's size, margins, paddings and layout parameters
        TextView itemTitle = v.findViewById(R.id.tvItemTitle);
        TextView typeOfItem = v.findViewById(R.id.tvTypeOfItem);
        TextView lectureHall = v.findViewById(R.id.tvLectureHall);
        TextView teacherName = v.findViewById(R.id.tvTeacherName);

        ImageView ivImg = v.findViewById(R.id.ivImg);
       // ivImg.setOnClickListener(mOnClickListener);


        ViewHolder vh = new ViewHolder(v, itemTitle, typeOfItem, lectureHall,teacherName, ivImg);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Element element = this.elements.get(position);
        holder.itemTitle.setText(element.getItemTitle());
        holder.typeOfItem.setText(element.getTypeOfItem());
        holder.lectureHall.setText(element.getLectureHall());
        holder.teacherName.setText(element.getTeacherName());
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        holder.mTextView.setText(mDataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
       // return mDataset.length;
        return this.elements.size();
    }
}
