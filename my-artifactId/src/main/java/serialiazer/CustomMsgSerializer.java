package serialiazer;


import babylon.GreetingResource.Msg;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;


public class CustomMsgSerializer extends StdSerializer<Msg> {

    public CustomMsgSerializer() {
        this(null);
    }

    public CustomMsgSerializer(Class<Msg> t) {
        super(t);
    }

    @Override
    public void serialize(
            Msg msg, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("msg", msg.msg);
        jsonGenerator.writeEndObject();
    }
}