package ktp.processing;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Praprocessing {
	public void praprocess(String filename) throws IOException{
		
		// Increase image brightness
		float brightenFactor = 2.2f;
		BufferedImage image = ImageIO.read(new File("ektp-raw//" + filename));
		RescaleOp op = new RescaleOp(brightenFactor, 0, null);
		image = op.filter(image, image);
		
		// Image binarization
		BufferedImage imagebw = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_BYTE_BINARY);
		Graphics2D graphics = imagebw.createGraphics();
		graphics.drawImage(image, 0, 0, null);

		ImageIO.write(imagebw, "png", new File("ektp-processed//"+ filename +".png"));
	}
}
