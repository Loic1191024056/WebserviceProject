package com.servlet;



import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.IOException;
import java.net.URL;



public class Testservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        doGet(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String id = req.getParameter("id");
        String longhair = req.getParameter("longhair");
        String event = req.getParameter("event");

        /**
         * 调用客户端请求
         */
        URL url = new URL("http://127.0.0.1:8086/MusicianService?wsdl");
        QName qname = new QName("http://example.service/", "MusicianServiceImplService");
        Service service = Service.create(url, qname);
        MusicianService iWeather = service.getPort(MusicianService.class);
        iWeather.addMusicalActivity(id,longhair,event);
        String index = "index.jsp";
        resp.sendRedirect(index);
        return;

    }
}