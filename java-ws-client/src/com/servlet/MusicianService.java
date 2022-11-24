package com.servlet;



import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "MusicianService", targetNamespace = "http://example.service/")
public interface MusicianService {

    @WebMethod(operationName = "addMusicalActivity", action = "urn:AddMusicalActivity")
    @WebResult(name = "id")
    public int addMusicalActivity(@WebParam(name = "id") String id,
                                  @WebParam(name = "longhair") String longhair,
                                  @WebParam(name = "event")String event);

    @WebMethod(operationName = "deleteMusicalActivity", action = "urn:DeleteMusicalActivity")
    @WebResult(name = "result")
    public boolean deleteMusicalActivity(@WebParam(name = "id") int id);

    @WebMethod(operationName = "getMusicalActivity", action = "urn:GetMusicalActivity")
    @WebResult(name = "MusicalActivity")
    public MusicalActivityPo getMusicalActivity(@WebParam(name = "id") int id);

    @WebMethod(operationName = "getAllMusicalActivitys", action = "urn:getAllMusicalActivitys")
    @WebResult(name = "MusicalActivitys")
    public MusicalActivityPo[] getAllMusicalActivitys();


    public int initMusicalActivity(MusicalActivityPo  musicalActivityPo);
}
