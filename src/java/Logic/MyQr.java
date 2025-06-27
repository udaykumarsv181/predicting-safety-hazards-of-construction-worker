/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author sumit
 */
// Java code to generate QR code

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyQr {

	// Function to create the QR code
	public static void createQR(String data, String path,
								String charset, Map hashMap,
								int height, int width)
		throws WriterException, IOException
	{

		BitMatrix matrix = new MultiFormatWriter().encode(
			new String(data.getBytes(charset), charset),
			BarcodeFormat.QR_CODE, width, height);

		MatrixToImageWriter.writeToFile(
			matrix,
			path.substring(path.lastIndexOf('.') + 1),
			new File(path));
	}

	// Driver code
	public static void main(String[] args)
		throws WriterException, IOException,
			NotFoundException
	{

		// The data that the QR code will contain
		String data = "";

		// The path where the image will get saved
		String path1 = "D:/qr.png";

		// Encoding charset
		String charset = "UTF-8";

		Map<EncodeHintType, ErrorCorrectionLevel> hashMap
			= new HashMap<EncodeHintType,
						ErrorCorrectionLevel>();

		hashMap.put(EncodeHintType.ERROR_CORRECTION,
					ErrorCorrectionLevel.L);

		// Create the QR code and save
		// in the specified folder
		// as a jpg file
		createQR(data, path1, charset, hashMap, 200, 200);
		System.out.println("QR Code Generated!!! ");
	}
        
        public void gen_qr1(String id,String data){
        
        // The data that the QR code will contain
		//String data = "fffffffffffffffffffff";

		// The path where the image will get saved
		String path1 = info.path+id+".png";

		// Encoding charset
		String charset = "UTF-8";

		Map<EncodeHintType, ErrorCorrectionLevel> hashMap
			= new HashMap<EncodeHintType,
						ErrorCorrectionLevel>();

		hashMap.put(EncodeHintType.ERROR_CORRECTION,
					ErrorCorrectionLevel.L);

            try {
                // Create the QR code and save
                // in the specified folder
                // as a jpg file
                createQR(data, path1, charset, hashMap, 200, 200);
            } catch (WriterException ex) {
                Logger.getLogger(MyQr.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MyQr.class.getName()).log(Level.SEVERE, null, ex);
            }
		System.out.println("QR Code Generated!!! ");
        }
}

