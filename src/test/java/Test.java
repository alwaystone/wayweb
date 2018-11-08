import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.sun.mail.util.MailSSLSocketFactory;
import com.ways.utils.MailPropertiesUtil;

public class Test {
	public static void main(String[] args) throws GeneralSecurityException{
		
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();    
        senderImpl.setHost("smtp.qq.com");    
        senderImpl.setUsername("986423521@qq.com");  
        senderImpl.setPassword("cvuhvsbmipifbfaf");  
        Properties prop = new Properties();    
        MailSSLSocketFactory sf = new MailSSLSocketFactory();  
        sf.setTrustAllHosts(true);  
        prop.put("mail.smtp.ssl.enable", "true");  
        prop.put("mail.smtp.ssl.socketFactory", sf);  
        prop.put("mail.smtp.auth", "true");  
        prop.put("mail.smtp.timeout", "20000");  
        senderImpl.setJavaMailProperties(prop);  
        SimpleMailMessage mail = new SimpleMailMessage();    
        mail.setFrom("986423521@qq.com");
        mail.setTo("949767548@qq.com");
        mail.setSubject("测试标题");
        mail.setText("测试");
        senderImpl.send(mail);
        System.out.println("SIMPLEMAIL SENDED");
	}
	public static void sendMimeMail() throws GeneralSecurityException, MessagingException{  
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();  
        senderImpl.setHost("smtp.qq.com");   
        senderImpl.setUsername("986423521@qq.com");   
        senderImpl.setPassword("cvuhvsbmipifbfaf");  
        Properties prop = new Properties();  
        MailSSLSocketFactory sf = new MailSSLSocketFactory();  
        sf.setTrustAllHosts(true);  
        prop.put("mail.smtp.ssl.enable", "true");  
        prop.put("mail.smtp.ssl.socketFactory", sf);  
        prop.put("mail.smtp.auth", "true");  
        prop.put("mail.smtp.timeout", "20000");   
        senderImpl.setJavaMailProperties(prop);  
        MimeMessage mail = senderImpl.createMimeMessage();  
        MimeMessageHelper helper = new MimeMessageHelper(mail,true);  
        helper.setFrom("986423521@qq.com");  
        helper.setTo("986423521@qq.com");  
        helper.setSubject("测试标题MIME");  
        helper.setText("测试MIME");  
        FileSystemResource mailImage = new FileSystemResource("src/main/webapp/files/images/mail.png");  
        helper.addAttachment("mail.png", mailImage);  
        senderImpl.send(mail);  
        System.out.println("MIMEMAIL SENDED");  
    }  
    public static void sendHTMLMail() throws GeneralSecurityException, MessagingException{  
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();  
        senderImpl.setHost("smtp.qq.com");   
        senderImpl.setUsername("986423521@qq.com");   
        senderImpl.setPassword("cvuhvsbmipifbfaf");  
        senderImpl.setDefaultEncoding("UTF-8");  
        Properties prop = new Properties();  
        MailSSLSocketFactory sf = new MailSSLSocketFactory();  
        sf.setTrustAllHosts(true);  
        prop.put("mail.smtp.ssl.enable", "true");  
        prop.put("mail.smtp.ssl.socketFactory", sf);  
        prop.put("mail.smtp.auth", "true");  
        prop.put("mail.smtp.timeout", "20000");   
        senderImpl.setJavaMailProperties(prop);  
        MimeMessage mail = senderImpl.createMimeMessage();  
        MimeMessageHelper helper = new MimeMessageHelper(mail,true);  
        helper.setFrom("986423521@qq.com");  
        helper.setTo("986423521@qq.com");  
        helper.setSubject("测试标题HTML");  
        StringBuilder html = new StringBuilder();  
        html.append("<html>")  
            .append("<body>")  
            .append("<h2>Goser,你好</h2>")  
            .append("<p>这是一个测试。</p>")  
            .append("<img src='cid:mailImage'/>")  
            .append("<p>THANKS</p>")  
            .append("</body>")  
            .append("</html>");  
        helper.setText(html.toString(),true);  
        FileSystemResource mailImage = new FileSystemResource("src/main/webapp/files/images/mail.png");  
        helper.addInline("mailImage", mailImage);  
        senderImpl.send(mail);  
        System.out.println("HTMLMAIL SENDED");  
        String a = "saaaa" ;
    }  
}
