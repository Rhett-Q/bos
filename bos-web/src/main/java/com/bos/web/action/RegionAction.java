package com.bos.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bos.domain.Region;
import com.bos.service.RegionService;
import com.bos.utils.PinYin4jUtils;
import com.bos.web.action.base.BaseAction;
@Controller
public class RegionAction extends BaseAction<Region> {
	
	private File regionFile;
	@Autowired
	private RegionService regionService;
	
	public void setRegionFile(File regionFile) {
		this.regionFile = regionFile;
	}
	
	public String importExcel() throws Exception {
		InputStream excelStream = new FileInputStream(regionFile);
		POIFSFileSystem fileSystem = new POIFSFileSystem(excelStream);
		HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
		
		HSSFSheet sheet = workbook.getSheetAt(0);
		List<Region> regionList = new ArrayList<Region>();
		for (Row row : sheet) {
			if (row.getRowNum() == 0)	continue;
			String id = row.getCell(0).getStringCellValue();
			String province = row.getCell(1).getStringCellValue();
			String city = row.getCell(2).getStringCellValue();
			String district = row.getCell(3).getStringCellValue();
			String postcode = row.getCell(4).getStringCellValue();
			Region region = new Region(id, province, city, district, postcode, null, null);
			
			
			province = province.substring(0, province.length()-1);
			city = city.substring(0, city.length()-1);
			district = district.substring(0, district.length()-1);
			String info = province + city + district;
			String[] headByString = PinYin4jUtils.getHeadByString(info);
			String shortcode = StringUtils.join(headByString);
			region.setShortcode(shortcode);
			String citycode = PinYin4jUtils.hanziToPinyin(city, "");
			region.setCitycode(citycode);
			regionList.add(region);
		}
		regionService.saveBatch(regionList);
		return NONE;
	}
 	
	public String pageQuery() throws IOException {
		regionService.pageQuery(pageBean);
		objectToJson(pageBean, new String[]{"currentPage", "datachedCriteria", "pageSize"});
		return NONE;
	}
 	
}
