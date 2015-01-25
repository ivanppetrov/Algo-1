package problems;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.nitido.utils.toaster.Toaster;

public class RestNotification {
	
	public static void main(String[] args) throws InterruptedException {
		Toaster toasterManager = new Toaster();
		
		Image img = null;
		try {
			img = ImageIO.read(new File("attachments/background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		toasterManager.setBackgroundImage(img);
		toasterManager.setToasterHeight(350);
		toasterManager.setToasterWidth(500);
		toasterManager.setDisplayTime(3000);
		toasterManager.setStep(3);
		toasterManager.setStepTime(10);
		Thread.sleep(5000);
		toasterManager.showToaster("Take some rest or you will die soon");
		
	}

}
