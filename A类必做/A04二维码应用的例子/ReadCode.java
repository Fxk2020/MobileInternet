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

import jp.sourceforge.qrcode.QRCodeDecoder;

public class ReadCode {
	
	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/26292/Desktop/qrcodebd.png");
		BufferedImage bufferedImage = ImageIO.read(file);
		QRCodeDecoder codeDecoder = new QRCodeDecoder();
		String result = new String(codeDecoder.decode(new MyQRCodeImage(bufferedImage)),"gb2312");
		System.out.println(result);
		int a = Integer.parseInt(result);
		//a++;
		//result = ""+a;
		
		Qrcode qrcode = new Qrcode();
		qrcode.setQrcodeErrorCorrect('M');//纠错等级（分为L、M、H三个等级）
		qrcode.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z，B代表其它字符
		qrcode.setQrcodeVersion(10);//版本
		//设置自己想要加上的值
		Scanner scanner = new Scanner(System.in);
		String value = scanner.nextLine();
		scanner.close();
		a+=Integer.parseInt(value);
		result = ""+a;
		
		//设置一下二维码的像素
		int width = 67+12*(10-1);
		int height = 67+12*(10-1);
		BufferedImage bufferedImage1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//绘图
		Graphics2D gs = bufferedImage1.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.setColor(Color.BLACK);
		gs.clearRect(0, 0, width, height);//清除下画板内容
		//设置下偏移量,如果不加偏移量，有时会导致出错。
		int pixoff = 2;
		byte[] d = null;
		try {
			d = result.getBytes("gb2312");
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
		bufferedImage1.flush();
		//设置要存储的目录（这里存储在本地）
		try {
			ImageIO.write(bufferedImage1, "png", new File("C:/Users/26292/Desktop/qrcodebd.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

