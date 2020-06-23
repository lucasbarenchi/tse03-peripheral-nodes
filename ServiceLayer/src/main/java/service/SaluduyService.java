package service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.Map;
import java.util.HashMap;

@Path("/saluduy")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SaluduyService {

    @GET
    @Path("/{ci}")
    public Response getHealthProvider(@PathParam("ci") String ci) {
        Map<String, String>  cis = new HashMap<String, String>();
        cis.put("11111111", "Proveedor0");
        cis.put("22222222", "Proveedor1");
        cis.put("33333333", "Proveedor1");
        cis.put("44444444", "Proveedor2");
        cis.put("55555555", "Proveedor0");

        Response response;
        String provider = cis.get(ci);
        if (provider != null) {
            Map<String, String> result = new HashMap<String, String>();
            result.put("name", provider);
            response = Response.ok(result).build();
        } else {
            response = Response.status(Status.NOT_FOUND).build();
        }

        return response;
    }
    
}