package com.qa.testData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.testBase.TestBase;

public class TestData extends TestBase {

	public void testData() {

		String path = "B:\\Velocitytraining\\Setup\\Eclipse_IDE_2021_12\\Eclipse_Workspace_2021_12\\DemoBlaze\\TestData\\PracticeExcelSheet.xlsx";

		try {
			FileInputStream file = new FileInputStream(path);
			value = WorkbookFactory.create(file).getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();

			System.out.println("Value is  = " + value);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
