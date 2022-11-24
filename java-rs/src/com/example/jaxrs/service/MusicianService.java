package com.example.jaxrs.service;


import com.example.jaxrs.model.MusicalActivityPo;


public interface MusicianService {

     int addMusicalActivity(int id,String longhair,String event);


     boolean deleteMusicalActivity(int id);


     MusicalActivityPo getMusicalActivity(int id);


     MusicalActivityPo[] getAllMusicalActivitys();


     int initMusicalActivity(MusicalActivityPo  musicalActivityPo);
}
