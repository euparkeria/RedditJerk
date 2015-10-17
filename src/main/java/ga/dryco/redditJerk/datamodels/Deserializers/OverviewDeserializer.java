package ga.dryco.redditJerk.datamodels.Deserializers;

import com.google.gson.*;
import ga.dryco.redditJerk.controllers.Overview;
import ga.dryco.redditJerk.datamodels.OverviewData;
import ga.dryco.redditJerk.datamodels.T1;
import ga.dryco.redditJerk.datamodels.T3;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Redditor's overview page contains a list of both t1 and t3 objects
 */
public class OverviewDeserializer implements JsonDeserializer<OverviewData> {
    public OverviewData deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context){
        List<T1> comments = new ArrayList<>();
        List<T3> submissions = new ArrayList<>();
        JsonArray overarray = json.getAsJsonObject().get("data").getAsJsonObject().getAsJsonArray("children");
        for(JsonElement jel:overarray){
            JsonObject thingObj = jel.getAsJsonObject();
            JsonPrimitive kindtext = thingObj.get("kind").getAsJsonPrimitive();
            if(kindtext.getAsString().equals("t1")){
                T1 comm = context.deserialize(thingObj, T1.class);
                comments.add(comm);
            } else if (kindtext.getAsString().equals("t3")){
                T3 subm = context.deserialize(jel.getAsJsonObject(), T3.class);
                submissions.add(subm);
            }
        }
        Overview returnoverview = new Overview();


        if(!json.getAsJsonObject().get("data").getAsJsonObject().get("after").isJsonNull()) {
            returnoverview.setAfter(json.getAsJsonObject().get("data").getAsJsonObject().get("after").getAsJsonPrimitive().getAsString());
        }
        if(!json.getAsJsonObject().get("data").getAsJsonObject().get("before").isJsonNull()) {
            returnoverview.setAfter(json.getAsJsonObject().get("data").getAsJsonObject().get("before").getAsJsonPrimitive().getAsString());
        }
        returnoverview.setComments(comments);
        returnoverview.setSubmissions(submissions);
        return returnoverview;
    }
}
