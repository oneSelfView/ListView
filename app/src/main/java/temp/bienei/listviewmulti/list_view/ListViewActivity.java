package temp.bienei.listviewmulti.list_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import temp.bienei.listviewmulti.R;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private List<ListViewBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = findViewById(R.id.list_view);
        initDate();
        listView.setAdapter(new ListViewAdapter(list, this));
    }

    private void initDate() {
        list.add(new ListViewBean(0, "未完成"));
        for (int i = 0; i < 10; i++) {
            list.add(new ListViewBean(1, "未完成订单"));
        }
        list.add(new ListViewBean(2, "已完成"));
        for (int i = 0; i < 10; i++) {
            list.add(new ListViewBean(1, "已完成订单"));
        }
    }
}
