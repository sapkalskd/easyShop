package com.es.util;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

import com.es.model.User;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;

public class CaptchaUtil {

	//For Captcha setup
	public static void setupCaptcha(User u) {
		Captcha captcha = CaptchaUtil.createCaptcha(200,50);
		u.setHidden(captcha.getAnswer());
		u.setCaptcha("");
		u.setImage(CaptchaUtil.encodeBase64(captcha));
		System.out.println(captcha.getAnswer());
	}

	//Captcha class object
	private static Captcha createCaptcha(int width, int height) {

		return new Captcha.Builder(width,height)
				.addBackground(new GradiatedBackgroundProducer())
				.addText()
				.addNoise()
				.build();
	}

	//Convert into image
	private static String encodeBase64(Captcha captcha) {
		String imageData = null;

		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(captcha.getImage(), "jpg", os);

			byte[] arr = Base64.getEncoder().encode(os.toByteArray());
			imageData =	new String(arr);

		} catch (Exception e ) {
			e.printStackTrace();
		}

		return imageData;
	}
}
