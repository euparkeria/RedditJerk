package ga.dryco.redditjerk.api;

import ga.dryco.redditjerk.api.enums.FlairPosition;

/**
 * Functions regarding the reddit Flair feature
 *
 */
public interface FlairApi {
    void deleteFlair(String subreddit, String username);
    void clearFlairTemplates(String subreddit, String flairtype);
    void deleteFlairTemplate(String subreddit, String flairTemplateId);
    void linkFlair(String subreddit, String link_fullName, String text, String css_class);
    void userFlair(String subreddit, String name, String text, String css_class);
    void flairConfig(String flair_enabled, FlairPosition flair_position, Boolean flair_self_assign_enabled, FlairPosition link_flair_position, Boolean link_flair_self_assign_enabled);
}
