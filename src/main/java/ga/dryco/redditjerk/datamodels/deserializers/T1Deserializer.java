package ga.dryco.redditjerk.datamodels.deserializers;

import com.google.gson.*;
import ga.dryco.redditjerk.wrappers.Comment;
import ga.dryco.redditjerk.datamodels.T1;

import java.lang.reflect.Type;

/**
 * t1 deserializer:
 * if "replies" is a string, remove it
 */
public class T1Deserializer implements JsonDeserializer<T1> {
    public T1 deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context){
        JsonObject jsonData = json.getAsJsonObject().get("data").getAsJsonObject();
        JsonElement replies = jsonData.get("replies");
        if (replies != null && replies.isJsonPrimitive()){
            JsonPrimitive primitiv = replies.getAsJsonPrimitive();
            if (primitiv.isString()) {
                jsonData.remove("replies");
            }
        }
        T1 t1 = new T1();
        Comment t1Data = context.deserialize(jsonData, Comment.class);
        t1.setData(t1Data);

        return t1;

    }

}
