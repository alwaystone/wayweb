package com.ways.interceptor;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.sf.json.JSONObject;


public class WebLoginInterceptor extends HandlerInterceptorAdapter {
	//Logger loggor = (Logger) LoggerFactory.getLogger(WebLoginInterceptor.class) ;
	private static Log logger = LogFactory.getLog(WebLoginInterceptor.class);

    /** 30分钟 */
    protected static final long THIRTY_MINU_MSEC = 30 * 60 * 1000;// 半个小时
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,  
            Object handler) throws Exception {
		/*HttpSession session = request.getSession() ;
		Map<String, String[]> parameterMap = request.getParameterMap();
		JSONObject jo =  new JSONObject() ;
		jo.put("safasdf", "aaaaaaaaaaaaaaaaaaaaa") ;
		System.out.println(jo.toString());
		
		System.out.println(new Date());
		response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(jo.toString());
        writer.close();
        response.flushBuffer(); */
		/*Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> param = new HashMap<String, Object>();
        buildParamMap(parameterMap, param);

        String timestampStr = (String) param.get("timestamp");
        String sign = (String) param.get("sign");
        
        long timestamp = Long.valueOf(timestampStr);
        long currTimestamp = new Date().getTime();
        if (currTimestamp - timestamp > THIRTY_MINU_MSEC) {
            if (logger.isDebugEnabled()) {
                logger.debug(String.format("接口调用超时[%s,%s]",
                        DateFormatUtils.format(new Date(currTimestamp), "yyyy-MM-dd HH:mm:ss"),
                        DateFormatUtils.format(new Date(timestamp), "yyyy-MM-dd HH:mm:ss")));
            }
            //SendMsgUtil.sendJsonMessage(response, CardResult.instance().build(ResultStatus.SIGN_OVERTIME));
            return false;
        }
		return true; */
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx");
	    response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
	    /*response.setHeader("Access-Control-Allow-Origin", "*");*/
	    response.setHeader("Access-Control-Allow-Credentials", "true");
	    response.setHeader("Access-Control-Allow-Origin", "<a href=\"http://127.0.0.1:8080\" rel=\"external nofollow\">http://127.0.0.1:8080</a>");
	    
	    
	    
		HttpSession session = request.getSession() ;
		System.out.println("拦截器中的session的id是===="
				+ session.getId());
		//System.out.println(session.isNew());
		if(session.isNew()){
			//response.setHeader("Set-Cookie","JSESSIONID="+request.getSession().getId());
			response.setContentType("text/html; charset=utf-8");
	        PrintWriter writer = response.getWriter();
	        JSONObject jo =  new JSONObject() ;
	        if (logger.isDebugEnabled()) {
                logger.debug(String.format("登录超时请重新登录[%s,%s]",
                        DateFormatUtils.format(session.getLastAccessedTime(), "yyyy-MM-dd HH:mm:ss"),
                        DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss")));
            }
			jo.put("success", false) ;
			jo.put("message", "登录超时请重新登录！") ;
			jo.put("state", "timeOut") ;
	        writer.print(jo.toString());
	        writer.close();
	        response.flushBuffer(); 
	        //String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
	        //response.sendRedirect(basePath + "/waysan/NewFile.html");
			return false; 
		}else{
			return true; 
		}
	}
	
	private void buildParamMap(Map<String, String[]> parameterMap, Map<String, Object> param) {
        for (Entry<String, String[]> entry : parameterMap.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            if (!ArrayUtils.isEmpty(value)) {
                if (StringUtils.isNotBlank(value[0])) {
                    param.put(key, value[0]);
                }
            } else {
                continue;
            }
        }
    }
}
