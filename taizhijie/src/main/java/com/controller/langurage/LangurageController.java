package com.controller.langurage;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;

@Controller
@RequestMapping("/country")
public class LangurageController {

	@Autowired
	private LocaleResolver localeResolver;

	/**
	 * 切换系统语言
	 * 
	 * @param location
	 *            语言字符(如zh_Cn,en_US等)
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/locale", method = RequestMethod.POST)
	public Map<String, String> setLocale(String locale, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Locale l = new Locale(locale);
		localeResolver.setLocale(request, response, l);
		Map<String, String> rs = new HashMap<String, String>();
		rs.put("msg", "success");
		return rs;
	}
}
