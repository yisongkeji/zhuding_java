package com.foreseers.tj.http;


public class LocationUtils {
	private static double EARTH_RADIUS = 6378.137;
 
	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}
 
	/**
	 * 通过经纬度获取距离(单位：米)
	 * 
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return 距离
	 */
	public static int getDistance(double lat1, double lng1, double lat2,
			double lng2) {
		int sd = 1;
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000d) / 10000d;
		//s = s * 1000;
		if(s<1) {
			sd =1;
		}else {
			sd = new Double(s).intValue();
		}		
		return sd;
	}

	public static void main(String[] args) {
		double distance = getDistance(39.0565173629,117.0912144470,
				39.0551843571,117.0481681824);
		System.out.println("距离" + distance + "公里");
	}
	
}