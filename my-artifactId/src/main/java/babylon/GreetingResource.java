package babylon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import serialiazer.CustomMsgSerializer;
import EntityObject.Gift;
import serialiazer.CustomGiftSerializer;
import EntityManager.SantaClausService;


@Path("/hello")
public class GreetingResource {

    public class Msg {
        public String msg;
    }
    static ObjectMapper objectMapperMsg = new ObjectMapper();
    static SimpleModule moduleMsg =
            new SimpleModule("CustomMsgSerializer", new Version(1, 0, 0, null, null, null));

    static ObjectMapper objectMapperGift = new ObjectMapper();
    static SimpleModule moduleGift =
            new SimpleModule("CustomGiftSerializer", new Version(1, 0, 0, null, null, null));

    static SantaClausService santaClausService = new SantaClausService();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/hello")
    public String hello() throws JsonProcessingException {
        moduleMsg.addSerializer(Msg.class, new CustomMsgSerializer());
        objectMapperMsg.registerModule(moduleMsg);


        // as json now return "Hello from RESTEasy Reactive";
        Msg msg = new Msg();
        msg.msg = "bonjour";
        return objectMapperMsg.writeValueAsString(msg);
    }

    // get gift by id
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/gift/{id}/")
    public String getGiftById(@PathParam("id")String id) throws JsonProcessingException {
        Gift gift = santaClausService.getGiftById(id);


        return "{}";

    }
}
