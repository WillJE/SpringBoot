package com.will.springbootmail;

import com.will.springbootmail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMailApplicationTests {

	@Resource
	MailService mailService;

	@Resource
	TemplateEngine templateEngine;

	@Autowired
	private JavaMailSender javaMailSender;

	@Test
	public void contextLoads() {
	}

	@Test
	public void sendSimpleMailTest(){
		mailService.sendSimpleMail("wenlin7404@163.com","简单邮件主题","简单邮件内容");

		System.out.println("简单邮件发送成功！！");
	}

	/**
	 * 发送静态资源文件（即发送html邮件）
	 * @throws Exception
	 */
	@Test
	public void sendInlineMail() throws Exception {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("1195714156@qq.com");
		helper.setTo("1195714156@qq.com");
		helper.setSubject("主题：嵌入静态资源");
		helper.setText("<html><body><img src=\"cid:avator\" ></body></html>", true);

		FileSystemResource file = new FileSystemResource(new File("avator.jpg"));
		helper.addInline("avator", file);

		javaMailSender.send(mimeMessage);

	}

	/**
	 * 发送带附件的邮件
	 * @throws Exception
	 */
	@Test
	public void sendAttachmentsMail() throws Exception {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("1195714156@qq.com");
		helper.setTo("1195714156@qq.com");
		helper.setSubject("主题：有附件");
		helper.setText("有附件的邮件");

		FileSystemResource file = new FileSystemResource(new File("avator.jpg"));
		helper.addAttachment("附件-1.jpg", file);
		helper.addAttachment("附件-2.jpg", file);

		javaMailSender.send(mimeMessage);

	}


	/**
	 * 模板邮件
	 * @throws Exception
	 */
	@Test
	public void sendTemplateMail() throws Exception {

		Context context = new Context();
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("1195714156@qq.com");
		helper.setTo("1195714156@qq.com");
		helper.setSubject("主题：模板邮件");

		context.setVariable("name","didi");

		String text = templateEngine.process("emailTemplate", context);

		helper.setText(text, true);

		javaMailSender.send(mimeMessage);
	}

}
