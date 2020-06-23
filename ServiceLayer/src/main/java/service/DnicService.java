package service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Path("/dnic")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DnicService {
    
    @GET
    @Path("/{email}")
    public Response getCitizenData(@PathParam("email") String email) {
        List<String> emails = new ArrayList<String>();
        emails.add("izghxhmswa_1591475193@tfbnw.net");
        emails.add("qfboqhakau_1591475190@tfbnw.net");
        emails.add("ruhhovnkmn_1591475194@tfbnw.net");
        emails.add("wqbeamehgh_1591475188@tfbnw.net");
        emails.add("lwrybtqkhm_1591489073@tfbnw.net");

        emails.add("zkqluyynwi_1591319494@tfbnw.net");
        emails.add("ciikzhexfl_1591319490@tfbnw.net");
        emails.add("txmlmtkcnt_1591319492@tfbnw.net");
        emails.add("omygmzqzbs_1591319495@tfbnw.net");
        emails.add("ikrdkjpinl_1591319434@tfbnw.net");
        emails.add("nusrtyuwvu_1591319437@tfbnw.net");
        emails.add("hamsxpaicw_1591319432@tfbnw.net");
        emails.add("vhrstgbbyv_1591319436@tfbnw.net");
                     

        List<String> names = new ArrayList<String>();
        names.add("Nicolas");
        names.add("Santiago");
        names.add("Ignacio");
        names.add("Franco");
        names.add("Lucas");

        names.add("Juan");
        names.add("Pedro");
        names.add("Rodrigo");
        names.add("Agustin");
        names.add("Juan Pablo");
        names.add("Luis");
        names.add("Mario");
        names.add("Federico");

        List<String> surnames = new ArrayList<String>();
        surnames.add("Briozzo");
        surnames.add("Fernandez");
        surnames.add("Alonso");
        surnames.add("Cuevas");
        surnames.add("Barenchi");

        surnames.add("Briozzo1");
        surnames.add("Briozzo2");
        surnames.add("Barenchi1");
        surnames.add("Barenchi2");
        surnames.add("Alonso1");
        surnames.add("Alonso2");
        surnames.add("Cuevas1");
        surnames.add("Cuevas2");

        List<String> cis = new ArrayList<String>();
        cis.add("11111111");
        cis.add("22222222");
        cis.add("33333333");
        cis.add("44444444");
        cis.add("55555555");
        
        cis.add("10101010");
        cis.add("12121212");
        cis.add("13131313");
        cis.add("14141414");
        cis.add("15151515");
        cis.add("16161616");
        cis.add("18181818");
        cis.add("19191919");

        Map<String, String> result = new HashMap<String, String>();
        Response response;
        Integer index = emails.indexOf(email);
        if (index != -1) {
            String name = names.get(index);
            String surname = surnames.get(index);
            String ci = cis.get(index);

            result.put("name", name);
            result.put("surname", surname);
            result.put("ci", ci);
            
            response = Response.ok(result).build();
        } else {
            response = Response.status(Status.NOT_FOUND).build();
        }

        return response;

    }
}