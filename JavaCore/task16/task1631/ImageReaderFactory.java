package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
	public static ImageReader getImageReader(ImageTypes imageTypes) {
		if (imageTypes == null){
			System.out.println("Неизвестный тип картинки");
			throw new IllegalArgumentException();
		}

		if (imageTypes.equals(ImageTypes.BMP)) {
			return new BmpReader();
		} else if (imageTypes.equals(ImageTypes.JPG)) {
			return new JpgReader();
		} else if (imageTypes.equals(ImageTypes.PNG)) {
			return new PngReader();
		}

		return null;
	}
}
