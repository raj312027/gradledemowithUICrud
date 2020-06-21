package com.demogradle.gradledemo.cache;

import com.hazelcast.core.HazelcastInstance;

public class CacheAccess {

	private CacheAccess(){}
	
	private static HazelcastInstance hazelCastInstance;

	public static void setHazelCastInstance(HazelcastInstance hazelCastInstance) {
		CacheAccess.hazelCastInstance = hazelCastInstance;
	}

	public static <T> T getCacheMap(String key){
		if(hazelCastInstance!=null){
		return	 (T) hazelCastInstance.getMap(key);
		}
		return null;
		
	}
}
