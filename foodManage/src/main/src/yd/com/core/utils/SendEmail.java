/*
信息:
*/
package yd.com.core.utils;

import com.sun.mail.util.MailSSLSocketFactory;
import u.com.entity.User;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class SendEmail {
    //QQ邮箱的SMTP 服务器地址为:smtp.qq.com
    private static String myEmailSMTPHost="smtp.qq.com";
    //发件人邮箱
    private static String myEmailAccount="951009487@qq.com";
    //发件人邮箱密码(授权码)
    private static String myEmailPassword="tfyfxjmftujibdhc";
    //资源设置
    private static Properties properties=new Properties();
    //SSL协议设置
    private static MailSSLSocketFactory mailSSLSocketFactory;
    static{
        try {
            mailSSLSocketFactory = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        //开启debug调试
        properties.setProperty("mail.debug", "true");
        //发送服务器需要的身份验证
        properties.setProperty("mail.smtp.auth", "true");
        //端口号
        properties.put("mail.smtp.port", 465);
        //设置邮件服务器主机名
        properties.setProperty("mail.smtp.host", myEmailSMTPHost);
        //发送邮箱协议名称
        properties.setProperty("mail.transport.protocol", "smtp");
        //设置是否使用ssl安全连接
        //**SSL认证,腾讯邮箱是基于SSL加密的，所以需要开启才可以使用
        mailSSLSocketFactory.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.ssl.socketFactory",true);
    }

    public static void sendEmail(User user){
        try {
            //创建mail的会话Session对象
            Session session=Session.getInstance(properties);
            //创建邮件对象整体
            Message message=new MimeMessage(session);
            //设置邮件标题
            message.setSubject("密码找回");
            //设置邮件内容(将内容放到builder中) StringBuilder的加载速度比String快并且线程安全性也好
            StringBuilder builder=new StringBuilder();
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");

            builder.append("尊敬的用户"+user.getUserName()+"你好，你的邮箱号为"+user.getEmail()+",在"+format.format(new Date())+"你通过邮箱找回的密码为:"+user.getPassWord());

            //定义输出日期字符串的格式
            //设置显示发送邮件的时间
            message.setSentDate(new Date());
            //设置邮箱内容
            message.setText(builder.toString());
            //设置发件人邮箱
            //InternetAddress的三个参数分别为:发件人邮箱，显示的昵称，昵称的字符集编码
            message.setFrom(new InternetAddress(myEmailAccount,"密码君","UTF-8"));
            //设置收件人的邮箱
            //  message.setRecipient(Message.RecipientType.TO,new InternetAddress("1011613995@qq.com"));
            //发送
            Transport transport=session.getTransport();
            //连接自己的邮箱账户
            //密码不是自己的qq邮箱密码,而是开启SMTP时获取的授权码


            //connect(host,user,password)
            //多个重载函数都可以用
            transport.connect(myEmailSMTPHost,myEmailAccount,myEmailPassword);
            // transport.connect(myEmailAccount,myEmailPassword);


            //发送邮件
            transport.sendMessage(message,new Address[]{new InternetAddress(user.getEmail())});
            //transport.sendMessage(message,message.getAllRecipients());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
