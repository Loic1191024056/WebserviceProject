package example.service.impl;

import example.model.MusicalActivityPo;
import example.service.MusicianService;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebService(targetNamespace = "http://example.service/",
        endpointInterface = "example.service.MusicianService",
        portName = "MusicianServiceImplPort",
        serviceName = "MusicianServiceImplService")
public class MusicianServiceImpl implements MusicianService {

    private static Map<Integer,MusicalActivityPo>  musicalActivitys = new HashMap<Integer, MusicalActivityPo>();
    private static int id = 0;

    @Override
    public int addMusicalActivity(@WebParam(name = "id") int id,
                                  @WebParam(name = "longhair") String longhair,
                                  @WebParam(name = "event") String event) {
        MusicalActivityPo  musicalActivityPo = new MusicalActivityPo();
        musicalActivityPo.setEvent(event);
        musicalActivityPo.setId(id);
        musicalActivityPo.setLonghair(longhair);
        musicalActivityPo.setArea("unknown");
        System.out.println("addMusicalActivity被调用,参数为  id:"+id+"   longhair:"+longhair+"   event:"+event);
        if(musicalActivityPo.getId() == 0) {
            return -1;
        }
        ++id;
        musicalActivitys.put(id, musicalActivityPo);
        return id;
    }

    @Override
    public boolean deleteMusicalActivity(int id) {
        System.out.println("deleteMusicalActivity被调用,参数为  "+id);
        if(musicalActivitys.get(id) == null) {
            return false;
        }
        musicalActivitys.remove(id);
        return true;
    }

    @Override
    public MusicalActivityPo getMusicalActivity(int id) {
        return musicalActivitys.get(id);
    }

    @Override
    public MusicalActivityPo[] getAllMusicalActivitys() {
        Set<Integer> ids = musicalActivitys.keySet();
        MusicalActivityPo[] s = new MusicalActivityPo[ids.size()];
        int i = 0;
        for(Integer id : ids){
            s[i] = musicalActivitys.get(id);
            i++;
        }
        return s;
    }

    @Override
    public int initMusicalActivity(MusicalActivityPo musicalActivityPo) {
        if(musicalActivityPo.getId() == 0) {
            return -1;
        }
        ++id;
        musicalActivitys.put(id, musicalActivityPo);
        return id;
    }


}
