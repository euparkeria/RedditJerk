package ga.dryco.redditjerk.datamodels.deserializers;

import com.google.gson.*;
import ga.dryco.redditjerk.datamodels.More;
import ga.dryco.redditjerk.datamodels.T1Listing;
import ga.dryco.redditjerk.datamodels.T1ListingData;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Since the Listing of "replies" returned by reddit contains Things of both types t1 and "more" we
 * are splitting it here.
 */
public class T1ListingDeserializer implements JsonDeserializer<T1Listing> {
    public T1Listing deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context){

        T1Listing t1ListingTemp = new T1Listing();
        t1ListingTemp.setKind("Listing");
        T1ListingData t1Data = context.deserialize(json.getAsJsonObject().get("data"), T1ListingData.class);
        t1ListingTemp.setData(t1Data);

        List<More> moreTemp = new ArrayList<>();

        //getting the Listing's data children

        JsonArray childrenArray = json.getAsJsonObject().get("data").getAsJsonObject().getAsJsonArray("children");

        for(JsonElement child:childrenArray){
            JsonObject childObj = child.getAsJsonObject();
            JsonPrimitive kindtext = childObj.get("kind").getAsJsonPrimitive();
            if(kindtext.getAsString().equals("more")) {
                More moteObj = context.deserialize(child.getAsJsonObject(), More.class);
                moreTemp.add(moteObj);
            }

        }
        t1ListingTemp.setData(t1Data);
        t1ListingTemp.getData().setMoreChildren(moreTemp);

        return t1ListingTemp;

    }
}
