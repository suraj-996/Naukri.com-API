package com.job.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.job.model.Job;



public class JobHelper {
	//check that file is of excel type or not
		public static boolean checkExcelFormat(MultipartFile file) {
			String contentType=file.getContentType();
			if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
				return true;
			}else {
				return false;
			}
		}
		
		//convert excel to list of products
		
		public static List<Job> convertExcelToListProduct(InputStream is){
			List<Job> list=new ArrayList<>();
			
			try {
				XSSFWorkbook workbook= new XSSFWorkbook(is);
				XSSFSheet sheet= workbook.getSheet("naukri");
				int r=0;
				Iterator<Row> iterator= sheet.iterator();
				while(iterator.hasNext()) {
					Row row=iterator.next();
					if(r==0) {
						r++;
						continue;
					}
					Iterator<Cell> cells= row.iterator();
					int cid=0;
					Job p=new Job();
					while(cells.hasNext()) {
						Cell cell=cells.next();
						switch(cid) {
							case 0:
								p.setUniq_id(cell.getStringCellValue());
								break;
							case 1:
								p.setTimestamp(cell.getStringCellValue());
								break;
							case 2:
								p.setJob_title(cell.getStringCellValue());
								break;
							case 3:
								p.setJob_salary(cell.getStringCellValue());;
								break;
							case 4:
								p.setJob_experience_required(cell.getStringCellValue());;
								break;
							case 5:
								p.setKey_skills(cell.getStringCellValue());
								break;
							case 6:
								p.setRole_category(cell.getStringCellValue());
								break;
							case 7:
								p.setLocation(cell.getStringCellValue());
								break;
							case 8:
								p.setFunctional_area(cell.getStringCellValue());
								break;
							case 9:
								p.setRole(cell.getStringCellValue());;
								break;
							case 10:
								p.setRole(cell.getStringCellValue());
								break;
							default:
								break;	
						}
						cid++;
					}
					list.add(p);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
}
