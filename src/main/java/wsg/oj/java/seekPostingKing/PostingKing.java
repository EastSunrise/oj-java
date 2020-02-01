package wsg.oj.java.seekPostingKing;

import java.util.List;

/**
 * @author Kingen
 */
public class PostingKing {

    private List<String> ids;

    public PostingKing(List<String> ids) {
        this.ids = ids;
    }

    public String seek() {
        int postCount = 0;
        String candidate = "";
        for (String id : ids) {
            if (postCount == 0) {
                candidate = id;
                postCount++;
            } else {
                if (candidate.equals(id)) {
                    postCount++;
                } else {
                    postCount--;
                }
            }
        }
        return candidate;
    }
}
