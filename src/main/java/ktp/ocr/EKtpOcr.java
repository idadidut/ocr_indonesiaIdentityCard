package ktp.ocr;

import static org.bytedeco.javacpp.lept.*;
import static org.junit.Assert.*;

import java.io.IOException;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;
import ktp.extractor.Extractor;
import ktp.processing.*;

public class EKtpOcr {
	private BytePointer outText = null;
    private Praprocessing p = new Praprocessing();
    private Postprocessing pp = new Postprocessing();
    private Extractor e = new Extractor();
    private TessBaseAPI api = new TessBaseAPI();
    
	public String ocr(String filename) {
		// Initialize tesseract-ocr with English, without specifying tessdata path
        if (api.Init(".", "ktp") != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }
        
        // Praprocessing Image
        try {
			p.praprocess(filename);
		} catch (IOException e1) {
			System.out.println("Image not found");
			e1.printStackTrace();
		}
        
        // OCR
        PIX image = pixRead("ektp-processed//" + filename + ".png");
        api.SetImage(image);
        
        // Get OCR result
        outText = api.GetUTF8Text();
        String string = outText.getString();
        assertTrue(!string.isEmpty());
        
        // Auto-correction and extraction
        string = pp.postprocess(string);
        string = e.extract(string);
        
        // Destroy used object and release memory
        api.End();
        outText.deallocate();
        pixDestroy(image);
		return string;
	}
}
