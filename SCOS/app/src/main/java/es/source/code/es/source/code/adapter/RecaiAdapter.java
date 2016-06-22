package es.source.code.es.source.code.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import es.source.code.activity.FoodDetailed;
import es.source.code.activity.R;

/**
 * Created by huang on 2016/6/15.
 */
public class RecaiAdapter extends BaseAdapter{
    private LayoutInflater mInflater;
    List<Map<String, Object>> mData;
    public RecaiAdapter(Context context, List<Map<String, Object>> Data) {
        this.mInflater =  LayoutInflater.from(context);
        this.mData = Data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    //****************************************final方法
//注意原本getView方法中的int position变量是非final的，现在改为final
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder=new ViewHolder();
            //可以理解为从vlist获取view  之后把view返回给ListView
            convertView = mInflater.inflate(R.layout.recai_item, null);
            holder.title = (TextView)convertView.findViewById(R.id.title);
            holder.info = (TextView)convertView.findViewById(R.id.info);
            holder.viewBtn = (Button)convertView.findViewById(R.id.view_btn);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.title.setText((String)mData.get(position).get("title"));
        holder.info.setText((String)mData.get(position).get("info"));
        holder.viewBtn.setTag(position);
        //给Button添加单击事件  添加Button之后ListView将失去焦点  需要的直接把Button的焦点去掉
        holder.viewBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ((Button)v).setText("退 点");
                Toast.makeText(mInflater.getContext(), "点菜成功", Toast.LENGTH_SHORT).show();
            }
        });
        //holder.viewBtn.setOnClickListener(MyListener(position));
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showInfo(position);
                Intent intent = new Intent(mInflater.getContext(), FoodDetailed.class);
                mInflater.getContext().startActivity(intent);
            }
        });
        return convertView;
    }
    public void showInfo(int position){
        ImageView img=new ImageView(mInflater.getContext());
        img.setImageResource(R.drawable.b);
        new AlertDialog.Builder(mInflater.getContext()).setView(img)
                .setTitle("详情"+position)
                .setMessage("菜名：" + mData.get(position).get("title") + "   价格:" + mData.get(position).get("info"))
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();
    }
}
