package com.zufe.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ValidateCodeAction")
public class ValidateCodeAction{

	private static final long serialVersionUID = 1L;
	private static int WIDTH = 80;
	private static int HEIGHT = 50;
	private static int NUM = 4;
	private ByteArrayInputStream inputStream;   
	private static char[] seq = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z' };

	@RequestMapping(value="validate.do") 
	private void validate(HttpServletRequest request,HttpServletResponse response){

		HttpSession session= request.getSession();

		Random r = new Random();
		// 图片的内存对象,用于封装位图的点阵信息
		// 图片的内存映像
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(new Color(0, 0, 0));
		// 用于存储随机生成的验证码
		StringBuffer number = new StringBuffer();

		// 绘制验证码
		for (int i = 0; i < NUM; i++) {
			g.setColor(this.randomColor(r));
			int h = ((HEIGHT * 60 / 100)  + (HEIGHT * 30 / 100));
			g.setFont(new Font(null, Font.BOLD | Font.ITALIC, 30));
			String ch = String.valueOf(seq[r.nextInt(seq.length)]);
			number.append(ch);
			g.drawString(ch, i * WIDTH / NUM * 90 / 100, h);
		}
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "JPEG", bos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] buf = bos.toByteArray();
		input = new ByteArrayInputStream(buf);
		session.setAttribute("validateCode", number.toString());
		
		 // 禁止图像缓存。  
		response.setHeader("Pragma", "no-cache"); 
		response.setHeader("Cache-Control", "no-cache"); 
		response.setDateHeader("Expires", 0); 
 
		response.setContentType("image/jpeg"); 
 
        // 将图像输出到Servlet输出流中。  
        ServletOutputStream sos;
		try {
			sos = response.getOutputStream();
	        ImageIO.write(image, "jpeg", sos); 
	        sos.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	private Color randomColor(Random r) {
		return new Color(r.nextInt(254), r.nextInt(254), r.nextInt(254));

	}
	   public void setInputStream(ByteArrayInputStream inputStream) {   
		           this.inputStream = inputStream;   
		       }

	public ByteArrayInputStream getInputStream() {
		return this.inputStream;
	} 
}
