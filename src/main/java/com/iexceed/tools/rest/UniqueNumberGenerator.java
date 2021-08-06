/**
 * 
 */
package com.iexceed.tools.rest;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author balachandra.r
 *
 */
@Component
public class UniqueNumberGenerator {
	
	private static Logger logger = LogManager.getLogger(UniqueNumberGenerator.class);
	
	private static final String ALPHABET_NUMBER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private final Random rng = new SecureRandom(); 
	
	
	public String randomUUID(int length, int spacing, char spacerChar){
	    StringBuilder sb = new StringBuilder();
	    int spacer = 0;
	    while(length > 0){
	        if(spacer == spacing){
	            sb.append(spacerChar);
	            spacer = 0;
	        }
	        length--;
	        spacer++;
	        sb.append(ALPHABET_NUMBER.charAt(rng.nextInt(ALPHABET_NUMBER.length())));
	    }
	    return sb.toString();
	}
	
	public String uniqueNumber() {
		
		String ts = new SimpleDateFormat("yyyMMddHHmmssSSSSSSS").format(new Date());
	    String rand = randomUUID(16, 0, '0');
	    String uniqueNumber = ts + "-" + rand;
	    
	    logger.debug("Unique number generated is: "+uniqueNumber);
	    
		return uniqueNumber;
		
	}
}
