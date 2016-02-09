package test.com.smarttravelcompanion.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.com.smarttravelcompanion.R;
import test.com.smarttravelcompanion.todoProvider;

/**
 * Created by devu on 2/9/2016.
 */
public class ListToDoAdapter extends ArrayAdapter {

    List list = new ArrayList();
    public ListToDoAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler{
        TextView txttitle,txtdes;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        LayoutHandler layoutHandler;
        if (row==null){
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.txttitle=(TextView)row.findViewById(R.id.txt_todo_title);
            layoutHandler.txtdes=(TextView)row.findViewById(R.id.txt_todo_details);
            row.setTag(layoutHandler);
        }else{
            layoutHandler = (LayoutHandler) row.getTag();

        }

        todoProvider todoProv = (todoProvider)this.getItem(position);
        layoutHandler.txttitle.setText(todoProv.getTitle().toString());
        layoutHandler.txtdes.setText(todoProv.getDes().toString());
        return row;
    }
}
