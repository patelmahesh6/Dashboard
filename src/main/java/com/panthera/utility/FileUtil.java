/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;


/**
 *
 * @author dpimac
 */
@Slf4j
public class FileUtil {
    private static byte[] readToByteArray(String url){
        File file = new File(url);
        try(FileInputStream fis = new FileInputStream(file)) {
           return FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            log.error(e.toString());
        }        
        return null;
        
    }
}
