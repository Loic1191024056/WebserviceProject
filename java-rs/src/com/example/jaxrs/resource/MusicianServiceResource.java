package com.example.jaxrs.resource;


import com.example.jaxrs.model.MusicalActivityPo;
import com.example.jaxrs.service.MusicianService;
import com.example.jaxrs.service.impl.MusicianServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @since Created at 2022-11-23 15:29
 */

@Path("Musician")
public class MusicianServiceResource {

    private MusicianService musicianService = new MusicianServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMusicalActivitys() {

        MusicalActivityPo[] musicalActivityPos = musicianService.getAllMusicalActivitys();

        if (musicalActivityPos.length>0) {
            return Response.ok(musicalActivityPos).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
