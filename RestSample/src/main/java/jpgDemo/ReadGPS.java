package jpgDemo;

import java.io.File;
import java.util.*;

import com.drew.imaging.jpeg.*;
import com.drew.metadata.*;
import com.drew.metadata.exif.*;

public class ReadGPS {

	public static void main(String[] args) {

		try {
			File jpegFile = new File("c:/temp/222.jpg");

			Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);
			
			
			for (Directory directory : metadata.getDirectories()) {
				for (Tag tag : directory.getTags()) {
					System.out.println(tag);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
