package com.bos.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;


import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bos.domain.Region;
import com.bos.domain.Subarea;
import com.bos.service.SubareaService;
import com.bos.utils.FileUtils;
import com.bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea> {
	@Autowired
	private SubareaService subareaService;
	
	private String decidedzoneId;
	
	public void setDecidedzoneId(String decidedzoneId) {
		this.decidedzoneId = decidedzoneId;
	}
	
	public String add() {
		subareaService.add(model);
		return "list";
	}
	public String pageQuery() throws Exception{
		DetachedCriteria criteria = pageBean.getDetachedCriteria();
		String addresskey = model.getAddresskey();
		if (StringUtils.isNotBlank(addresskey)) {
			criteria.add(Restrictions.like("addresskey", "%" + addresskey + "%"));
		}
		Region region = model.getRegion();
		if (region != null) {
			String province = region.getProvince();
			String city = region.getCity();
			String district = region.getDistrict();
			criteria.createAlias("region", "r");
			if (StringUtils.isNotBlank(province)) {
				criteria.add(Restrictions.like("r.province", "%"+province+"%"));
			}
			if (StringUtils.isNotBlank(city)) {
				criteria.add(Restrictions.like("r.city", "%"+city+"%"));
			}
			if (StringUtils.isNotBlank(district)) {
				criteria.add(Restrictions.like("r.district", "%"+district+"%"));
			}
		}
		subareaService.pageQuery(pageBean);
		objectToJson(pageBean, new String[]{"currentPage", "detachedCriteria", "pageSize", "decidedzone", "subarea"});
		return NONE;
	}
	
	public String exportExcel() throws IOException {
		List<Subarea> list = subareaService.findAll();
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("分区数据");
		HSSFRow headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue("分区编号");
		headRow.createCell(1).setCellValue("开始编号");
		headRow.createCell(2).setCellValue("结束编号");
		headRow.createCell(3).setCellValue("位置信息");
		headRow.createCell(4).setCellValue("省市区");
		
		for (Subarea subarea : list) {
			HSSFRow row = sheet.createRow(sheet.getLastRowNum()+1);
			row.createCell(0).setCellValue(subarea.getId());
			row.createCell(1).setCellValue(subarea.getStartnum());
			row.createCell(2).setCellValue(subarea.getEndnum());
			row.createCell(3).setCellValue(subarea.getPosition());
			row.createCell(4).setCellValue(subarea.getRegion().getName());
		}
		
		String fileName = "分区数据.xls";
		String type = ServletActionContext.getServletContext().getMimeType(fileName);
		ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream();
		ServletActionContext.getResponse().setContentType(type);
		
		String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		fileName = FileUtils.encodeDownloadFilename(fileName, agent);
		ServletActionContext.getResponse().setHeader("content-disposition", "attachment;filename="+fileName);
		workbook.write(outputStream);
		return NONE;
	}
	
	public String ajaxList() throws IOException {
		List<Subarea> list = subareaService.findNotAssociation();
		objectToJson(list, new String[]{"decidedzone", "region"});
		return NONE;
	}
	
	public String findListByDecidedzoneId() throws IOException {
		List<Subarea> list = subareaService.findListByDecidedzoneId(decidedzoneId);
		objectToJson(list, new String[]{});
		return NONE;
	}
}
