package tabl.xhf.asus.mytablayout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import tabl.xhf.asus.mytablayout.R;
import tabl.xhf.asus.mytablayout.bean.DataB;

/**
 * Created by asus on 2016/10/25.
 */
public class MyFr1Adapter extends BaseAdapter {
    Context context;
    List<DataB.DataBean.ForumListBean.GroupBean> glist;

    public MyFr1Adapter(Context context, List<DataB.DataBean.ForumListBean.GroupBean> glist) {
        this.context = context;
        this.glist = glist;
    }

    @Override
    public int getCount() {
        return glist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.fr1_item,null);
            holder.name = (TextView)convertView.findViewById(R.id.item1_name);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(glist.get(position).getName());
        return convertView;
    }

    class ViewHolder{
        TextView name;
    }

}
