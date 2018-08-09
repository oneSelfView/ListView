package temp.bienei.listviewmulti.list_view;

/**
 * Created by Lenovo on 2018/7/19.
 */

public class ListViewBean {
    private int type;
    private String name;

    public ListViewBean() {
    }

    public ListViewBean(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
