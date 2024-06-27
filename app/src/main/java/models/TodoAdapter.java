package models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lab1_android22.R;

import java.util.List;

public class TodoAdapter extends ArrayAdapter<Todo> {

    public TodoAdapter(Context context, List<Todo> models) {
        super(context, 0, models);
    }

    // Tạo view và gán dữ liệu
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_listview, parent, false);
        }

        Todo todo = getItem(position);

        TextView title = view.findViewById(R.id.txt_title);
        TextView description = view.findViewById(R.id.txt_des);

        title.setText(todo.getTitle());
        description.setText(todo.getDes());

        return view;
    }
}
