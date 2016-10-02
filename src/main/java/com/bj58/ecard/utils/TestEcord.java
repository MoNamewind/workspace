package com.bj58.ecard.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.UUID;

import javax.imageio.ImageIO;


import org.junit.Test;

import com.swetake.util.Qrcode;

/**
 * 需要的jar包，Qrcode_swetake.jar：
 * 生成二维码图片：
 * @author 58
 *
 */
public class TestEcord {
	
	@Test
	public void main() throws Exception {
		
		String content="xiayiciba";
		Qrcode qrcode=new Qrcode();
		
		qrcode.setQrcodeEncodeMode('M');
		qrcode.setQrcodeErrorCorrect('8');
		qrcode.setQrcodeVersion(15);
		System.out.println("nihao");
		
		byte[] cocntentbytes = content.getBytes("utf-8");
		
		int width=255;
		int height=255;
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		g.setBackground(Color.WHITE);
		
		g.clearRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		
		
		boolean[][] codeout = qrcode.calQrcode(cocntentbytes);
		for (int i = 0; i < codeout.length; i++) {
			for (int j = 0; j < codeout.length; j++) {
				if (codeout[j][i]) {
					g.fillRect(j*3+2, i*3+2, 3, 3);
				}
			}
			
		}
		g.dispose();
		image.flush();
		String filename=UUID.randomUUID()+".png";
		File file=new File(filename);
		ImageIO.write(image, "png", file);
		
	}
	

}
