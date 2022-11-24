package com.example.jaxrs.service.impl;


import com.example.jaxrs.model.MusicalActivityPo;
import com.example.jaxrs.service.MusicianService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MusicianServiceImpl implements MusicianService {

    private static Map<Integer, MusicalActivityPo> musicalActivitys = new HashMap<Integer, MusicalActivityPo>();
    private static int id = 0;

    @Override
    public int addMusicalActivity(int id, String longhair, String event) {
        MusicalActivityPo  musicalActivityPo = new MusicalActivityPo();
        musicalActivityPo.setEvent(event);
        musicalActivityPo.setId(id);
        musicalActivityPo.setLonghair(longhair);
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
