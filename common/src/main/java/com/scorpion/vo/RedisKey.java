package com.scorpion.vo;

/**
 * @author scorpion
 * @date 2022/4/2
 */
public class RedisKey {
    public static final String sessionId="wx_session_id";
    public static final String token="wx_token";
    public static final String SPLIT=":";
    public static final String PREFIX_COLLECT="collect";
    public static final String PREFIX_FOLLOW="follow";
    public static final String PREFIX_FANS="fans";

    /**
     * 用户收藏关键词  “collect:”+userId+":"+type
     * @param userId 用户ID
     * @param type 收藏类型
     * @return
     */
    public static String getCollectKey(int userId,int type) {
        return PREFIX_COLLECT + SPLIT + userId + SPLIT + type;
    }

    /**
     * 用户点击关注关键词  “follow:”+userId
     * @param userId 用户ID
     * @return
     */
    public static String getFollowKey(int userId){
        return PREFIX_FOLLOW+SPLIT+userId;
    }

    /**
     * 被关注人粉丝关键词
     * @param followId 被关注人ID
     * @return
     */
    public static String getFansKey(int followId){
        return PREFIX_FANS+SPLIT+followId;
    }
}
