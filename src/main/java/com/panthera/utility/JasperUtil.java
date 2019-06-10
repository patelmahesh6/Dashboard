/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.utility;

import com.panthera.beans.JasperBean;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author dpimac
 */
@Slf4j
public class JasperUtil {

    public static byte[] generatePDFReport(String inputFileName, Map<String, Object> params) throws IOException {
        return generatePDFReport(inputFileName, params, getProperties());
    }

    public static byte[] generatePDFReport(String inputFileName, Map<String, Object> params,
            JRDataSource dataSource) {
        byte[] bytes = null;
        JasperReport jasperReport = null;

        try (ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {
             ClassPathResource file = new ClassPathResource("/reports/"+inputFileName + ".jasper");

            if (file.exists()) {
                jasperReport = (JasperReport) JRLoader.loadObject(file.getFile());
            } else {
                File jrxmlFile = new ClassPathResource("/reports/"+inputFileName+ ".jrxml").getFile();
                jasperReport = JasperCompileManager.compileReport(jrxmlFile.getPath());
                JRSaver.saveObject(jasperReport, new File(file.getPath()));
            }
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
            bytes = JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (JRException | IOException e) {
            log.error(e.toString());
        }
        return bytes;
    }

    public static JRDataSource getProperties() throws IOException {
        JRDataSource beanDataSource = null;
        
        JasperBean jasperBean = new JasperBean();
        ArrayList<JasperBean> jasperList = new ArrayList<>();
        jasperList.add(jasperBean.getDefaultProperties());
       

        if (jasperList.isEmpty()) {
            beanDataSource = new JREmptyDataSource();
        } else {
            beanDataSource = new JRBeanCollectionDataSource(jasperList);
        }
        return beanDataSource;
    }

}
