/*
信息:
*/
package table.com.entity;

import java.util.Date;

public class Table {
    private String id;
    private String tableName;
    private int tableStatus;
    private Date date;

    @Override
    public String toString() {
        return "Table{" +
                "id='" + id + '\'' +
                ", tableName='" + tableName + '\'' +
                ", tableStatus=" + tableStatus +
                ", date=" + date +
                '}';
    }
    public Table() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(int tableStatus) {
        this.tableStatus = tableStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
