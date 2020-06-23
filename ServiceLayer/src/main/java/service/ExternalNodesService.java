package service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import java.util.concurrent.ThreadLocalRandom;

@Path("/external")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExternalNodesService {

    @GET
    @Path("/provider")
    public Map getProviderInfo(@QueryParam("name") String name, @QueryParam("city") String city, @QueryParam("town") String town, @QueryParam("hours") String hours) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("name", name != null ? name : "Farmashop");
        result.put("state", city != null ? city : "Montevideo");
        result.put("city", town != null ? town : "Pocitos");
        result.put("hours", hours != null ? hours : "De 08:00hs a 19:00hs");
        return result;
    }

    @GET
    @Path("/healthprovider/{name}")
    public Response getDoctor(@PathParam("name") String name) {

        //lista de medicos que se pueden loguear en el frontoffice
        List<String> doctorEmails = new ArrayList<String>();
        doctorEmails.add("zkqluyynwi_1591319494@tfbnw.net");
        doctorEmails.add("ciikzhexfl_1591319490@tfbnw.net");
        doctorEmails.add("txmlmtkcnt_1591319492@tfbnw.net");
        doctorEmails.add("omygmzqzbs_1591319495@tfbnw.net");
        doctorEmails.add("ikrdkjpinl_1591319434@tfbnw.net");
        doctorEmails.add("nusrtyuwvu_1591319437@tfbnw.net");
        doctorEmails.add("hamsxpaicw_1591319432@tfbnw.net");
        doctorEmails.add("vhrstgbbyv_1591319436@tfbnw.net");

        Integer max = doctorEmails.size();

        Map<String, String> result = new HashMap<String, String>();
        Response response;
        int randomNum = ThreadLocalRandom.current().nextInt(0, max+1);
        if (randomNum == max) {
            //simula que el proveedor no tiene medico disponible
            response = Response.status(Status.NOT_FOUND).build();
        } else {
            result.put("email", doctorEmails.get(randomNum));
            response = Response.ok(result).build();
        }

        return response;
    }

    @POST
    @Path("/examprovider/{name}")
    public Response examRequest(@PathParam("name") String name, Map body) {
        System.out.println("[PROVDER: " + name + "] New exam request for " + body.get("ci") + " due " + body.get("disease"));

        Map<String, Object> result = new HashMap<>();
        result.put("id", System.currentTimeMillis()); // return dummy internal exam id

        return Response.ok(result).build();
    }

}
