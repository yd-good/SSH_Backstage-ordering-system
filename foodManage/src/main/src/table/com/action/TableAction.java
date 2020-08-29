/*
信息:
*/
package table.com.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import table.com.entity.Table;
import table.com.service.TableService;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

public class TableAction extends ActionSupport {
    @Resource
   private TableService tableService;
   private List<Table> tables;
   private Table table;

    public TableService getTableService() {
        return tableService;
    }

    public String list(){
       tables= tableService.findAll();
        return "list";
    }
    public String add(){
        if (table!=null&& StringUtils.isNotBlank(table.getTableName())){
            if (table.getTableStatus()==1){
                if (table.getDate()==null){
                    table.setDate(new Date());
                }
            }else {
                table.setDate(null);
            }
            tableService.save(table);
        }
        return list();
    }
   public String retreat(){

       Table sreachTable=tableService.findById(table.getId());
       if (sreachTable.getTableStatus()==1) {
           tableService.retreatById(table.getId());
       }
        return list();
   }
    public String order(){
        Table sreachTable=tableService.findById(table.getId());
        if (sreachTable.getTableStatus()==0) {
            tableService.orderById(table.getId(),new Date());
        }
        return list();
    }
    public String delete(){
        tableService.deleteById(table.getId());
        return list();
    }
//    唯一名字校验
    public void uniqueName() {
        if (table != null && StringUtils.isNotBlank(table.getTableName())) {
            tables = tableService.findByName(table.getTableName());
            String result="true";
            HttpServletResponse response= ServletActionContext.getResponse();
            response.setContentType("text/html");
            try {
                ServletOutputStream outputStream=response.getOutputStream();
                if (tables!=null&&tables.size()>0){
                    result="false";
                }else {
                    result="true";
                }
                outputStream.write(result.getBytes());
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setTableService(TableService tableService) {
        this.tableService = tableService;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
