
<%@ page import="java.net.URL" %>
<%@ page import="javax.xml.namespace.QName" %>
<%@ page import="javax.xml.ws.Service" %>
<%@ page import="com.servlet.MusicianService" %>
<%@ page import="com.servlet.MusicalActivityPo" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>页面</title>
  </head>
  <body>
  <form action="testservlet" method="post">
    id: &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; <input name="id"><br>
    <br>
    longhair:  <input name="longhair"><br>
    <br>
    event:  &nbsp; &nbsp;&nbsp;<input name="event"><br>
    <br>
    <input type="submit" value="提交">
  </form>

  </body>

  <%

    URL url = new URL("http://127.0.0.1:8086/MusicianService?wsdl");
    QName qname = new QName("http://example.service/", "MusicianServiceImplService");
    Service service = Service.create(url, qname);
    MusicianService iWeather = service.getPort(MusicianService.class);
    MusicalActivityPo[]   musicalActivityPos = iWeather.getAllMusicalActivitys();
    for (int i=0;i<musicalActivityPos.length;i++){
      out.println("<br>");
      out.println("数据:  id :"+musicalActivityPos[i].getId()+"area :"+musicalActivityPos[i].getArea()+
              "longhair :"+musicalActivityPos[i].getLonghair()+"event :"+musicalActivityPos[i].getEvent());

    }

  %>
  <%%>
<%--  <%=resultjson.toString() %>--%>
</html>
