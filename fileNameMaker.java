package Files;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class fileNameMaker {

	public String fileNameMakerForLogin(String u, String p) {
		// TODO Auto-generated method stub

		
		String filename;
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Before Formatting:" +now);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
		filename = u+ "_" + p + "_" + now.format(format) +".jpg";
		System.out.println("After Formatting: " + filename);
		return filename;
	}

}
