package es.source.code.es.source.code.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import es.source.code.activity.R;
import es.source.code.model.Food;

/**
 * Created by huang on 2016/6/17.
 */
public class TabUnOrderAdapter extends BaseAdapter{
    private List<Food> list;
    private LayoutInflater inflater;

    public TabUnOrderAdapter(Context context,List<Food> listFood){
        inflater = LayoutInflater.from(context);
        this.list = listFood;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {
        // TODO Auto-generated method stub
        Food food = (Food)this.getItem(pos);
        ViewHolder viewHolder;
        if(view == null)
        {
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.food_order_head_info, null);
            viewHolder.foodName = (TextView)view.findViewById(R.id.food_name);
            viewHolder.foodPrice = (TextView)view.findViewById(R.id.food_price);
            viewHolder.foodAmount = (TextView)view.findViewById(R.id.food_amount);
            viewHolder.foodNote = (TextView)view.findViewById(R.id.food_note);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.foodName.setText(food.getName());
        viewHolder.foodPrice.setText(food.getPrice());
        viewHolder.foodAmount.setText(food.getAmount());
        viewHolder.foodNote.setText(food.getNote());



        return view;
    }
    public static class ViewHolder{
        public TextView foodName;
        public TextView foodPrice;
        public TextView foodAmount;
        public TextView foodNote;
    }
}
