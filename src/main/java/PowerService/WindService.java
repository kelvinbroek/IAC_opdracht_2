/**
 * Created by Kelvin on 16-3-2017.
 */
package PowerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import Calculate.Calculate;
import org.json.JSONObject;

@Path("/bereken")
public class WindService {

    @GET
    @Path("/{speed}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPower(@PathParam("speed") int speed) throws Exception {
        // < 11km geen stroom, >= 75km stopgezet

        JSONObject resp = new JSONObject();

        try {
            if(speed < 0) {
                throw new Exception();
            }

            if (speed <= 11) {
                resp.put("Message", "Het waait te zacht, er wordt nu geen stroom opgewekt");
                return Response.status(200).entity(resp.toString()).build();
            } else if (speed >= 75) {
                resp.put("Message", "Het waait te hard, uit voorzorgsmaatregelen zijn de windmolens stilgelegd");
                return Response.status(200).entity(resp.toString()).build();
            }

            resp.put("Message", "De stroomopbrengst bedraagt");
            resp.put("Kwh", Calculate.CalculatePower(speed));

            return Response.status(200).entity(resp.toString()).build();

        }
        catch (Exception e) {
            resp.put("errorMessage : ", "Foutieve invoer");
            return Response.status(200).entity(resp.toString()).build();
        }
    }
}