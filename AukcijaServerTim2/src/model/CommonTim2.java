package model;

public class CommonTim2 {
	public static String toCapitalizes(String s){
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}
	
	public static final String persistanceName="AukcijaServerTim2";
	/*
	 * drop tables
	 * 
drop table bojatim2;
drop table komentartim2 ;
drop table materijaltim2 ;
drop table ponudatim2 ;
drop table stavkatim2 ;
drop table tiptim2 ;
drop table usertim2 ;
drop table usertim2_stavkatim2 ;
drop table velicinatim2 ;
	 */
}
