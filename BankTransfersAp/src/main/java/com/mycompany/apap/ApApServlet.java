package com.mycompany.apap;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "Hello", urlPatterns = {"/api/*"})
public class ApApServlet extends HttpServlet
{
    private static final String NAME_PARAM = "name";
    private static final String BANK_PARAM = "bank";
    private final Logger logger = LoggerFactory.getLogger(ApApServlet.class);
    
    private ApApService service;
    
    /*
    * Servlet container needs it.
    */
    @SuppressWarnings("unused")
    public ApApServlet()
    {
        this(new ApApService());
    }
    
    ApApServlet(ApApService service)
    {
        this.service = service;
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        logger.info("Got request woth parameters: " + req.getParameterMap());
        String name = req.getParameter(NAME_PARAM);
        String bank = req.getParameter(BANK_PARAM);
        resp.getWriter().write(service.prepareGreeting(name, bank)); 
    }
    
}
