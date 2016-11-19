package com.nju.util;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<Integer>{
	Map<String,Integer> map ;
	public ValueComparator(Map<String,Integer> map){
		this.map = map ;
	}
	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if(map.get(o1) >= map.get(o2)){
			return 1 ;
		}else{
			return -1 ;
			}
	}
	public Map<String, Integer> getMap() {
		return map;
	}
	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}
	
}
