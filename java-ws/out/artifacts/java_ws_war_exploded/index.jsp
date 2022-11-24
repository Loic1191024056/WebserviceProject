
<%@ page language="java" contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*,java.sql.Timestamp" %>
<%@page import="net.sf.json.xml.XMLSerializer"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="org.apache.axis.client.Call"%>
<%@page import="org.apache.axis.client.Service"%>
<%@ page import="javax.rmi.CORBA.Util" %>
<%@ page import="javax.xml.namespace.QName" %>
<%--<jsp:useBean id="DepartmentComInfo" class="weaver.hrm.company.DepartmentComInfo" scope="page"/>--%>
<%--<jsp:useBean id="RecordSet" class="weaver.conn.RecordSet" scope="page" />--%>
<%
//  BaseBean bean=new BaseBean();
  String feildvalue = Util.null2String(request.getParameter("feildvalue"));//归属项目名称浏览按钮值
//请求方法
  String webservicename="http://192.168.8.74:9999/ws/QueryProjectData?wsdl";
  String namespace="https://www.hytera.com/cn/GET_CUSTOMER_CREDIT/";
  String webservicenmathod="getProjectInfoNew";
//bean.writeLog("==============feildvalue:"+feildvalue);
  JSONObject resultjson = null;
  if (!"".equals(webservicename) && !"".equals(webservicenmathod) && !"".equals(feildvalue)) {
    try {
      String endpoint = webservicename;
      if(endpoint.indexOf("?wsdl")>-1)
      {
        endpoint = endpoint.substring(0,endpoint.indexOf("?wsdl"));
      }
      Service service = new Service();
      Call call=service.createCall();
      call.setTargetEndpointAddress(endpoint);
      call.setOperationName(webservicenmathod);
      call.addParameter("",org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
      call.addParameter("",org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
      call.setOperationName(new QName(namespace, webservicenmathod));
      call.setReturnType(org.apache.axis.encoding.XMLType.SOAP_STRING);//设置返回类型 ，如String
      call.setReturnQName(new javax.xml.namespace.QName("", "result"));
      call.setReturnClass(java.lang.String.class); //返回字符串数组类型
      String result = (String) call.invoke(new java.lang.Object[] {"10029370","81"});
//bean.writeLog("==============result:"+result);
//xml转json
      XMLSerializer xmlSerializer = new XMLSerializer();
      String resultStr = xmlSerializer.read(result).toString();
      resultjson = JSONObject.fromObject(resultStr);
//resultjson输出值为{"headerid":"508163","customerName":"Platinum Enterprise","customerNo":"1568","customercurrency":"USD","credit":"0","creditus":"0","creditdw":"USD","arrears":"25171.05","needprepay":"0","customerPayment":"立即","salesAmount":[],"cumulativeRefundAmount":[],"salesAmountOne":[],"refundAmount":[],"receivables":"2428.95","accountPeriod":"0","overdue30":"0","overdue90":"0","overdue180":"0","overdue181":"25171.05","invoiceid":"4106","status":"S","err_msg":[]}
    }catch(Exception e){

    }
  }

//bean.writeLog("==============result:"+resultjson.toString());
%>
<%=resultjson.toString() %>
