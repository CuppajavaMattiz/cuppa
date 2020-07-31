package com.mattiz.rest.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import com.mattiz.rest.service.MattizService;

@Controller
@RequestMapping(value = "/restservices")
public class RestServiceController {
	@Autowired
	private MattizService mattizService;
	private static final String DATA_FIELD = "data";
	private static final String ERROR_FIELD = "error";
	@RequestMapping(value = "/mattiz", method = RequestMethod.GET)
	public ModelAndView getWelcomeString(HttpServletRequest request) {
		String msg = null;
		try {
			msg = mattizService.getWelcomeString();
		} catch (Exception e) {
			return createErrorResponse(String.format(
					"Error getting message. [%1$s]", e.toString()));
		}
		return new ModelAndView(new MappingJacksonJsonView(), DATA_FIELD, msg);
	}
	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(new MappingJacksonJsonView(), ERROR_FIELD,
				sMessage);
	}
}