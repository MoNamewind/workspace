package com.bj58.api.services.imp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.bj58.api.services.IQrcodeService;
import com.swetake.util.Qrcode;

@Service
public class QrcodeServiceImp implements IQrcodeService{

	@Override
	public byte[] encode(String content) throws Exception {
	   Qrcode qrcode=new Qrcode();
	   qrcode.setQrcodeEncodeMode('M');
	   qrcode.setQrcodeErrorCorrect('8');
	   qrcode.setQrcodeVersion(15);
	   
	   
	   int width=255;
	   int height=255;
	   BufferedImage image =new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	   Graphics2D g = image.createGraphics();
	   g.setBackground(Color.WHITE);
	   
	   
	   g.clearRect(0, 0, width, height);
	   g.setColor(Color.BLACK);
	   boolean[][] imgcode = qrcode.calQrcode(content.getBytes("utf-8"));
	   for (int i = 0; i < imgcode.length; i++) {
		   for (int j = 0; j < imgcode.length; j++) {
				if (imgcode[j][i]) {
					g.fillRect(j*3+2, i*3+2, 3, 3);
				}
		   }
			
		}
	    g.dispose();
		image.flush();
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", out);
		File file=new File("aa.jpg");
		ImageIO.write(image, "jpg", file);
		return out.toByteArray();
	}

	@Override
	public String decode(String path) {

		return null;
	}

}
