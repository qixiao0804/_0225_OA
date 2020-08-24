package com.qx.controller;

import com.qx.model.Job;
import com.qx.model.Poi;
import com.qx.service.JobService;
import com.qx.service.PoiService;
import org.apache.ibatis.ognl.JJTOgnlParserState;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@RestController
@RequestMapping("/poi")
public class PoiController {

    @Autowired
    private PoiService poiService;
    //导出
    @RequestMapping("/exportexcel.do")
    public void exportexcel(HttpServletResponse response, Poi poi) {


        System.out.println(poi.getName());
        OutputStream oStream = null;
        try {
//       创建工作簿
            HSSFWorkbook wb = new HSSFWorkbook();
//       创建sheet
            HSSFSheet sheet = wb.createSheet("列表");
//       创建表头
            HSSFRow row = sheet.createRow(0);
            //创建单元格
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("序号");
            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue("职位名");
            HSSFCell cell2 = row.createCell(2);
            cell2.setCellValue("备注");
//            HSSFCell cell3 = row.createCell(3);
//            cell3.setCellValue("手机号");

            List<Poi> list = poiService.selectAll(poi);
            System.out.println(list);
            for (int i = 0; i < list.size(); i++) {
                Poi us = list.get(i);
                //创建表头
                HSSFRow lrow = sheet.createRow(i + 1);
                //创建单元格
                HSSFCell lcell = lrow.createCell(0);
                lcell.setCellValue(us.getId());
                HSSFCell lcell1 = lrow.createCell(1);
                lcell1.setCellValue(us.getName());
                HSSFCell lcell2 = lrow.createCell(2);
                lcell2.setCellValue(us.getRemark());
//                HSSFCell lcell3 = lrow.createCell(3);
//                lcell3.setCellValue(us.getPhone());
            }
            //根据response获取输出流
            response.setContentType("application/force-download"); // 设置下载类型
            response.setHeader("Content-Disposition", "attachment;filename=job.xls"); // 设置文件的名称
            oStream = response.getOutputStream(); // 输出流
            //把工作薄写入到输出流
            wb.write(oStream);

        } catch (Exception e) {
            // TODO: handle exception
            try {
                oStream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }


}



