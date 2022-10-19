package com.coder.imageController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.util.FileUpload;
import com.coder.util.ServerPath;


@Controller
@Transactional
@RequestMapping("/niponpain")
public class TypeImageUploadController{

	@RequestMapping("/typeImageUploadPath")
	public void imageUploadDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		String id=req.getParameter("id");
		
		String frmType=req.getParameter("frmType");
	
		
		String serverPath=FileUpload.getImageUrl(id+"","productType");
		
        Path file = Paths.get(serverPath);
       
      
        
        if (Files.exists(file)) 
        { try
        {
            Files.copy(file, resp.getOutputStream());
            resp.setContentType(MediaType.IMAGE_JPEG_VALUE);
            resp.getOutputStream().flush();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
        }else{
        	serverPath=FileUpload.getImageUrl("default","productType");
        file = Paths.get(serverPath);
    	try {
			Files.copy(file, resp.getOutputStream());
		    resp.setContentType(MediaType.IMAGE_JPEG_VALUE);
	        resp.getOutputStream().flush();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
        
        if(frmType.equals("1")){
            if (Files.exists(file)) 
            {
            	   resp.setContentType(MediaType.IMAGE_JPEG_VALUE);
               	resp.addHeader("Content-Disposition", "attachment; filename="+id);
            	  
            }
            
            }
	}
	
	
	
}
