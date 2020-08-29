/*
信息:
*/
package yd.com.core.action;

import com.opensymphony.xwork2.ActionSupport;
import dishes.com.entity.Dishes;
import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class CoreAction extends ActionSupport {
    protected File headImg;
    protected String headImgContentType;
    protected String headImgFileName;
    //图片处理
   public void process_pictures(Dishes dishes) {
        String path= ServletActionContext.getServletContext().getRealPath("upload/img");
        String fileName= UUID.randomUUID().toString()+headImgFileName.substring(headImgFileName.lastIndexOf("."));
        try {
            FileUtil.copyFile(headImg,new File(path,fileName));
            dishes.setImg("img/"+fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
