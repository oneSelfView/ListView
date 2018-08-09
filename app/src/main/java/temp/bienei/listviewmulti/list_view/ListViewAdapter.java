package temp.bienei.listviewmulti.list_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import temp.bienei.listviewmulti.R;

/**
 * Created by Lenovo on 2018/7/19.
 */

public class ListViewAdapter extends BaseAdapter {

    private List<ListViewBean> list;
    private Context context;
    private LayoutInflater layoutInflater;

    private int TYPE_0 = 0;
    private int TYPE_1 = 1;
    private int TYPE_2 = 2;
    private int TYPE_3 = 3;

    public ListViewAdapter(List<ListViewBean> list, Context context) {
        this.list = list;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemViewType(int position) {
        int type = list.get(position).getType();
        switch (type) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                return 3;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        ListViewBean listViewBean = list.get(i);
        ViewHolderFinish viewHolderFinish = null;
        ViewHolderUnfinish viewHolderUnfinish = null;
        switch (itemViewType) {
            case 0:
                if (view == null) {
                    view = layoutInflater.inflate(R.layout.list_view_unfinish, null);
                }
                break;
            case 1:
                if (view == null) {
                    view = layoutInflater.inflate(R.layout.list_view_item, null);
                    viewHolderUnfinish = new ViewHolderUnfinish();
                    viewHolderUnfinish.unfinish = view.findViewById(R.id.list_view_item_tv);
                    view.setTag(viewHolderUnfinish);
                } else {
                    viewHolderUnfinish = (ViewHolderUnfinish) view.getTag();
                }
                break;
            case 2:
                if (view == null) {
                    view = layoutInflater.inflate(R.layout.list_view_finish, null);
                }
                break;
            case 3:
                if (view == null) {
                    view = layoutInflater.inflate(R.layout.list_view_finish, null);
                    viewHolderFinish = new ViewHolderFinish();
                    viewHolderFinish.finish = view.findViewById(R.id.list_view_item_tv);
                    view.setTag(viewHolderFinish);
                } else {
                    viewHolderFinish = (ViewHolderFinish) view.getTag();
                }
                break;
        }
        switch (itemViewType) {
            case 1:
                viewHolderUnfinish.unfinish.setText(listViewBean.getType() + listViewBean.getName());
                break;
            case 3:
                viewHolderFinish.finish.setText(listViewBean.getType() + listViewBean.getName());
                break;
        }
        return view;
    }

    class ViewHolderUnfinish {
        TextView unfinish;
    }

    class ViewHolderFinish {
        TextView finish;
    }
}
