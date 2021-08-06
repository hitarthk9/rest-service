package com.iexceed.tools.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iexceed.tools.dto.Request;
import com.iexceed.tools.dto.Response;

@RestController
@RequestMapping(path = "tool")
public class Controller {

	@Autowired
	private RequestHandler requestHandler;

	private static final Logger logger = LogManager.getLogger(Controller.class);
	
	
	@GetMapping("/")
	public @ResponseBody String index() {

		return "Up and Running!";
	}

	@RequestMapping(value = "/bulktest", method = RequestMethod.POST)
	public Response Test(@RequestBody Request request) {
		logger.info("Request received for bulk testing: ");
		try {
			Response response = requestHandler.handleRequest(request);

			return response;

		} catch (Exception e) {

			logger.error("Error in bulk testing ", e);

			com.iexceed.tools.dto.Error error = new com.iexceed.tools.dto.Error(e.getMessage(), "30001");
			Response response = new Response(false, error);

			return response;

		}
	}

}
