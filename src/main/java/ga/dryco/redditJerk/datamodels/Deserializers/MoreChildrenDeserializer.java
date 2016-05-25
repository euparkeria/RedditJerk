package ga.dryco.redditjerk.datamodels.deserializers;

import com.google.gson.*;
import ga.dryco.redditjerk.datamodels.MoreChildren;
import ga.dryco.redditjerk.datamodels.T1Listing;

import java.lang.reflect.Type;

/**
 * Since /api/morechildren returns a weird JSON we convert it here to T1Listing wrapped in MoreChildren object
 *
 *
 */

public class MoreChildrenDeserializer implements JsonDeserializer<MoreChildren> {

    public MoreChildren deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context){
        MoreChildren returnObj = new MoreChildren();


        if(json.getAsJsonObject().getAsJsonObject("json").has("data")){
            JsonArray t1Objects = json.getAsJsonObject().getAsJsonObject("json").getAsJsonObject("data").getAsJsonArray("things");
            //System.out.println(t1Objects.size());

            JsonObject jObj = json.getAsJsonObject();
            jObj.remove("json");


            jObj.add("kind", new JsonPrimitive("Listing"));
            jObj.add("data", new JsonObject());

            jObj.getAsJsonObject("data").add("children", t1Objects);
            T1Listing newListing = context.deserialize(jObj, T1Listing.class);

            returnObj.setMoreChildrenComments(newListing);
        }

        return returnObj;
    }

}
