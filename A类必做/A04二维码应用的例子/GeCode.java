package com.fxk.qrcode;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class GeCode {
	
	public static void main(String[] args) {
		Qrcode qrcode = new Qrcode();
		qrcode.setQrcodeErrorCorrect('M');//纠错等级（分为L、M、H三个等级）
		qrcode.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z，B代表其它字符
		qrcode.setQrcodeVersion(10);//版本
		//生成二维码中要存储的信息
		Scanner scanner = new Scanner(System.in);
		String qrData = scanner.nextLine();
		scanner.close();
		//设置一下二维码的像素
		int width = 67+12*(10-1);
		int height = 67+12*(10-1);
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//绘图
		Graphics2D gs = bufferedImage.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.setColor(Color.BLACK);
		gs.clearRect(0, 0, width, height);//清除下画板内容
		//设置下偏移量,如果不加偏移量，有时会导致出错。
		int pixoff = 2;
		byte[] d = null;
		try {
			d = qrData.getBytes("gb2312");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(d.length > 0 && d.length <120){
			boolean[][] s = qrcode.calQrcode(d);
			for(int i=0;i<s.length;i++){
				for(int j=0;j<s.length;j++){
					if(s[j][i]){
						gs.fillRect(j*3+pixoff, i*3+pixoff, 3, 3);
					}
				}
			}
		}
		gs.dispose();
		bufferedImage.flush();
		//设置要存储的目录（这里存储在本地）
		try {
			ImageIO.write(bufferedImage, "png", new File("C:/Users/26292/Desktop/qrcodebd.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
