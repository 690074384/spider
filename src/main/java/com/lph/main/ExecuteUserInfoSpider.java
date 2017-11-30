package com.lph.main;

/**
 * lph
 */

import com.lph.DbUtil.DbUtil;
import com.lph.datacollect.UserInfoDataGather;

import java.sql.Connection;

public class ExecuteUserInfoSpider {

	public static void main(String[] args) throws Exception {
		 Connection conn=DbUtil.getConn();
		 int start=0,count=1,j=6;
		 for(int i=0;i<j;i++){
			 UserInfoDataGather.SpiderUserInfo(conn,start,count);
		 }
		 DbUtil.closeConn(conn);
		 System.out.println("已插入"+count*j+"条用户数据");
		 
		 
	}

}
