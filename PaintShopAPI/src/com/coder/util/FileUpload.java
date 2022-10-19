package com.coder.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import net.coobird.thumbnailator.Thumbnails;
public class FileUpload {

	public static void uploadFile(MultipartFile multipartFile,String fileName,String floderName) {
		
		String serverPath=ServerPath.getPath();
		  
		String adminPath=ServerPath.createFloder(serverPath+File.separator+floderName);
		
		String url=adminPath+File.separator+fileName+".jpg";
		
		 File file = new File(url);
         try
         {
             multipartFile.transferTo(file);
           
             
         } catch (IOException e) 
         {
             e.printStackTrace();
         }
		
	}
	
	public static String getImageUrl(String fileName,String floderName)
	{
		String serverPath=ServerPath.getPath();
		  
		String adminPath=ServerPath.createFloder(serverPath+File.separator+floderName);
		
		String url=adminPath+File.separator+fileName+".jpg";
		
		
		
		return url;
	}


	

}
