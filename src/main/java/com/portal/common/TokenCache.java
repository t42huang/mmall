package com.portal.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.internal.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * @Author: tina.huanght
 * @Date: 13/01/25 14:38
 */
public class TokenCache {
    private static final String TOKEN_PREFIX = "token_";
    private static Logger logger = LoggerFactory.getLogger(TokenCache.class);

//    private static LoadingCache<String, TokenCache> localCache = CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).expireAfterAccess(12, TimeUnit.HOURS).build();

}
