import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Image;

public class test {
	public static void main(String[] args) {
		File file = new File("/WebContent/images/E_Duo.png");
		try {
			Image img1 = ImageIO.read(file);
			System.out.println(img1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(file.getAbsolutePath());
//		System.out.println(img1);
	}
}
