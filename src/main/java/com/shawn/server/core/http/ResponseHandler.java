package com.shawn.server.core.http;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ResponseHandler {

	private final static Logger LOGGER = Logger.getLogger(ResponseHandler.class);

	public static void outputJson(HttpServletResponse response, String content) {
		try {
			LOGGER.info(content);
			response.setContentType(ContentType.JSON);
			response.getWriter().write(content);
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void output(HttpServletResponse response, String content) {
		try {
			LOGGER.info(content);
			response.setContentType(ContentType.JSON);
			response.getWriter().write(content);
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void outputImage(HttpServletResponse response, BufferedImage image, boolean noCache) {
		try {
			if (noCache) {
				response.setHeader("Pragma", "No-cache");
				response.setHeader("Cache-Control", "no-cache");
				response.setDateHeader("Expires", 0);
			}
			ImageIO.write(image, "JPEG", response.getOutputStream());
			response.getOutputStream().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
