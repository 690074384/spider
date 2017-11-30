package com.lph.datacollect;
/**
 * lph
 */

import com.lph.model.User;
import com.lph.sipder.GetUserlist;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;


public class htmlParser{

	static ArrayList<User> list;
	private static Document doc;
	private static Elements users;
	public static ArrayList<User> parseUserlist(User user) throws Exception{
		String userlist= GetUserlist.getUserList(user.getUserid());
		list=null;
		if(userlist!=null){
			list=new ArrayList<User>();
			doc=Jsoup.parse(userlist);
			users=doc.select("a[usercard]");
			
			for(Element nodeuser:users){
				//System.out.println(nodeuser.toString());
				User u=new User();
				u.setUserid(nodeuser.attr("usercard").substring(3,13));
				u.setUsername(nodeuser.text());
				u.setRootuserid(user.getUserid());
				list.add(u);
				//System.out.println(u.getUserid()+" "+u.getUsername());
			}
		}else {
			System.out.println(user.getUsername()+"没有关注任何人");
		}
		
		//System.out.println(users.toString());
		//System.out.println(list.get(1).getUsername());
		return list;
	}
	
	public static void main(String[] args) throws Exception{
		String userid="5887581312";
		//parseUserlist(userid);
	}
	
}
