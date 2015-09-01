package com.tortilla.Service;

import com.tortilla.Service.Track;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: uttam
 * Date: 8/31/15
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/json/metallica")
public class JSONService {
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Track getTrackInJSON() {

        Track track = new Track();
        track.setTitle("Enter Sandman");
        track.setSinger("Metallica");

        return track;

    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Track track) {

        String result = "Track saved : " + track;
        return Response.status(201).entity(result).build();

    }
}
