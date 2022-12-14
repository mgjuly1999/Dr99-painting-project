package com.coder.config;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class HTTPSFilter implements Filter {
 
public void doFilter(ServletRequest request, ServletResponse response,
FilterChain chain) throws java.io.IOException, ServletException {
 
HttpServletRequest req = (HttpServletRequest) request;
HttpServletResponse res = (HttpServletResponse) response;
 
String uri = req.getRequestURI();
String getProtocol = req.getScheme();
String getDomain = req.getServerName();
String getPort = Integer.toString(req.getServerPort());
 
if (getProtocol.toLowerCase().equals("http")) {
 
// Set response content type
response.setContentType("text/html");
 
// New location to be redirected
String httpsPath = "https" + "://" + getDomain + ":" + getPort
+ uri;
 
String site = new String(httpsPath);
res.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
res.setHeader("Location", site);
}
 
// Pass request back down the filter chain
chain.doFilter(req, res);
 
}
 
@Override
public void init(FilterConfig arg0) throws ServletException {
// TODO Auto-generated method stub
 
}
 
@Override
public void destroy() {
// TODO Auto-generated method stub
 
}
 
}