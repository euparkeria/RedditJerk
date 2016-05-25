package ga.dryco.redditjerk.datamodels.deserializers;

import com.google.gson.*;
import ga.dryco.redditjerk.datamodels.PostReturn;
import ga.dryco.redditjerk.datamodels.T1;
import ga.dryco.redditjerk.datamodels.T3;
import ga.dryco.redditjerk.exceptions.RedditJerkException;

import java.lang.reflect.Type;



public class PostReturnDeserializer implements JsonDeserializer<PostReturn> {
    public PostReturn deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context){
        PostReturn returnObject = new PostReturn();

        if(json.getAsJsonObject().get("json").getAsJsonObject().get("errors").getAsJsonArray().size() != 0){
            //TODO:improve this

            throw new RedditJerkException("Rate Limit Error, try later");
        } else {
            JsonArray thinglist = json.getAsJsonObject().get("json").getAsJsonObject().get("data").getAsJsonObject().getAsJsonArray("things");
            JsonObject thingObj = thinglist.get(0).getAsJsonObject();
            JsonPrimitive kindtext = thingObj.get("kind").getAsJsonPrimitive();
            if(kindtext.getAsString().equals("t1")){
                T1 comm = context.deserialize(thingObj, T1.class);
                returnObject.setComment(comm);
                returnObject.setKind("reply");
            }
            else if(kindtext.getAsString().equals("t3")){
                T3 subm = context.deserialize(thingObj, T3.class);
                returnObject.setLink(subm);
                returnObject.setKind("link");
            }
            return returnObject;
        }

    }
}
