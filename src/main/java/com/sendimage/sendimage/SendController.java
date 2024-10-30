package com.sendimage.sendimage;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {

    @GetMapping("/sawa")
    String hello(){

        //System.out.println(just);

        String encodedString = null;

        //Converting image to base 64 encoding
        byte[] fileContent;
        try {
            fileContent = FileUtils.readFileToByteArray(new File("C:\\Users\\HP\\Desktop\\recent\\IMG-20220128-WA0001.jpg"));
            encodedString = Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Writing back the decoded string to a file or recreate the image
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        try {
            FileUtils.writeByteArrayToFile(new File("C:\\Users\\HP\\Desktop\\recent\\INTERNET SPEED\\sir.jpg"), decodedBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return encodedString;
    }

}
