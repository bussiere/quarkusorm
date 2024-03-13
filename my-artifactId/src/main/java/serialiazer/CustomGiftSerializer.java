package serialiazer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import EntityObject.Gift;


public class CustomGiftSerializer extends StdSerializer<Gift> {

    protected CustomGiftSerializer(Class<Gift> t) {
        super(t);
    }

    public CustomGiftSerializer() {
        this(null);
    }


    @Override
    public void serialize(
            Gift gift, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", gift.getName());
        jsonGenerator.writeStringField("id", gift.getId().toString());
        jsonGenerator.writeEndObject();
    }
}