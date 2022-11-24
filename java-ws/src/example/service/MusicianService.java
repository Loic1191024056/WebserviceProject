package example.service;

import example.model.MusicalActivityPo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "MusicianService", targetNamespace = "http://example.service/")
public interface MusicianService {


    /**
     * 创建艺术家事件
     * @param id
     * @param longhair
     * @param event
     * @return
     */
    @WebMethod(operationName = "addMusicalActivity", action = "urn:AddMusicalActivity")
    @WebResult(name = "id")
    int addMusicalActivity(@WebParam(name = "id") int id,
                                  @WebParam(name = "longhair") String longhair,
                                  @WebParam(name = "event")String event);

    /**
     * 删除艺术家事件
     * @param id
     * @return
     */
    @WebMethod(operationName = "deleteMusicalActivity", action = "urn:DeleteMusicalActivity")
    @WebResult(name = "result")
    boolean deleteMusicalActivity(@WebParam(name = "id") int id);

    /**
     * 获取艺术家事件
     * @param id
     * @return
     */
    @WebMethod(operationName = "getMusicalActivity", action = "urn:GetMusicalActivity")
    @WebResult(name = "MusicalActivity")
    MusicalActivityPo getMusicalActivity(@WebParam(name = "id") int id);

    /**
     * 获取艺术家事件列表
     * @return
     */
    @WebMethod(operationName = "getAllMusicalActivitys", action = "urn:getAllMusicalActivitys")
    @WebResult(name = "MusicalActivitys")
    MusicalActivityPo[] getAllMusicalActivitys();

    /**
     *初始化
     * @param musicalActivityPo
     * @return
     */
    int initMusicalActivity(MusicalActivityPo  musicalActivityPo);
}
