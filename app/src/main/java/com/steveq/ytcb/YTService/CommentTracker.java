package com.steveq.ytcb.YTService;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.CommentThread;
import com.google.api.services.youtube.model.CommentThreadListResponse;

import java.io.IOException;
import java.util.List;

/**
 * Created by Adam on 2017-04-27.
 */

public class CommentTracker {

    private YouTube mYoutube;
    private String mVideoId;

    public CommentTracker(String videoId) {
        this.mVideoId = videoId;
    }

    public List<CommentThread> getAllVideoComments(){
        CommentThreadListResponse commentResponse = null;
        try {
            commentResponse = mYoutube.commentThreads()
                                        .list("snippet")
                                        .setVideoId(mVideoId)
                                        .setTextFormat("plainText")
                                        .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(commentResponse != null){
            List<CommentThread> videoComments = commentResponse.getItems();
            for(CommentThread ct : videoComments){
            }
        } else {
            throw new NullPointerException("...Comment Response is NULL...");
        }

        return null;
    }

}
