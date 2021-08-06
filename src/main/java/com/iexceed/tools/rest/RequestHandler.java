package com.iexceed.tools.rest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iexceed.tools.dto.OCRRequest;
import com.iexceed.tools.dto.OCRResponse;
import com.iexceed.tools.dto.Request;
import com.iexceed.tools.dto.Response;
import com.opencsv.CSVWriter;

@Component
public class RequestHandler {

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger logger = LogManager.getLogger(Controller.class);
	
	private ObjectMapper mapper = new ObjectMapper();


	public Response handleRequest(Request request) throws IOException {

		logger.debug("Handle request started");

		String inputDir = request.getInputDir();
		String outputDir = request.getOutputDir();
		
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		//inputDir = "C:\\Users\\HITARTH KOTHARI\\Pictures\\Camera Roll";
		//outputDir = "C:\\";


		File[] files = new File(inputDir).listFiles();
		
		outputDir = outputDir + "/test.csv";
		
		File file = new File(outputDir);

		FileWriter outputfile = new FileWriter(file);

		CSVWriter writer = new CSVWriter(outputfile);

		for (File filename : files) {

			// if a sub directory is found,
			// print the name of the sub
			// directory

			String fileName = inputDir + "/" + filename.getName();
			
			if (filename.isDirectory()) {
				logger.warn("Directory: " + fileName);
				continue;
			}
			else {
				logger.debug("File: " ,fileName);

				byte[] fileContent = FileUtils.readFileToByteArray(new File(fileName));
				String encodedString = Base64.getEncoder().encodeToString(fileContent);

				OCRRequest oCRRequest = buildOCRRequest(request, encodedString);
				//OCRResponse ocrResponse = restTemplate.postForObject("url of azure service", oCRRequest,OCRResponse.class);
				OCRResponse ocrResponse = mockData(oCRRequest);

				logger.debug("response received in, ", ocrResponse);
				
				Object extractedEntities = ocrResponse.getExtractedEntities();
				String json = mapper.writeValueAsString(extractedEntities);
				
				logger.debug("Extraction entity in Json format: ",json);
				
				JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
				
				Set<String> keys = jsonObject.keySet();
				
				// adding header to csv, will be added for each file to the csv
		        String[] header = convert(keys);
		        writer.writeNext(header);

				String[] array = new String[keys.size()];
				int i = 0;
				for (String key : keys) {
					JsonElement jsonElement = jsonObject.get(key);
					array[i] = jsonElement.getAsString();
					i++;
				}
				writer.writeNext(array);

			}
		}
		writer.close();

		Response response = new Response();
		response.setStatus(true);

		return response;
	}

	private OCRRequest buildOCRRequest(Request request, String encodedString) {

		logger.debug("Start building ocr request");

		OCRRequest ocrRequest = new OCRRequest();

		ocrRequest.setDocumentId(request.getDocumentId());
		ocrRequest.setDataBase64(encodedString);
		ocrRequest.setDataCord("1");
		ocrRequest.setDocumentType(request.getDocumentType());
		ocrRequest.setDataSource("2");
		ocrRequest.setDeviceType("3");
		ocrRequest.setDataFormat("4");
		ocrRequest.setTxnId("5");
		ocrRequest.setUserId(request.getUserId());
		ocrRequest.setDataPreprocessed(false);
		ocrRequest.setPreprocessedType("6");
		ocrRequest.setDataText("7");
		// ocrRequest.setAddtionalParam();
		// ocrRequest.setAdditionalProperty();

		return ocrRequest;
	}
	
	private OCRResponse mockData(OCRRequest request) {
		

		OCRResponse ocrResponse = new OCRResponse();
		ocrResponse.setStatus(true);
		String extractedEntities = "{/\"extracted_entities/\":{/\"sex/\":[/\"M/\"],/\"date_of_birth/\":[/\"07/03/1993/\"],/\"expiry_date/\":[/\"08/06/2021/\"],/\"iso_code/\":[/\"ILARE0949839613784199390398248/\",/\"9303070M2106087IND<<<<<<<<<<<8/\",/\"PAWAR<<OMKARCDILIP<<<<<<<<<<<</\"],/\"card_number/\":[/\"094983961/\"]}}";
		ocrResponse.setExtractedEntities(extractedEntities);

		return ocrResponse;
	}
	
	// Function to convert Set<String> to String[]
    public static String[] convert(Set<String> setOfString)
    {
  
        // Create String[] of size of setOfString
        String[] arrayOfString = new String[setOfString.size()];
  
        // Copy elements from set to string array
        // using advanced for loop
        int index = 0;
        for (String str : setOfString)
            arrayOfString[index++] = str;
  
        // return the formed String[]
        return arrayOfString;
    }
}
