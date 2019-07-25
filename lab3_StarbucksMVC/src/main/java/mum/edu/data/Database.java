package mum.edu.data;

import mum.edu.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Database {
	public static HashMap<String, User> users = new HashMap<String, User>();
	public static HashMap<String, List<String>> advice = new HashMap<String, List<String>>();
	static {
		users.put("Dave", new User("Dave","111"));
		users.put("Steve", new User("Steve","222"));
		users.put("Ralph", new User("Ralph","333"));
		ArrayList<String> darkList = new ArrayList<String>();
		darkList.add("Sumatra");
		darkList.add("Verona");
		darkList.add("French Roast");
		advice.put("dark", darkList);
		ArrayList<String> medList = new ArrayList<String>();
		medList.add("Breakfast Blend");
		medList.add("Colombia");
		medList.add("Yukon");
		medList.add("Pike Place");
		medList.add("House Blend");
		advice.put("medium", medList);
		ArrayList<String> lightList = new ArrayList<String>();
		lightList.add("Willow");
		lightList.add("Aria");
		lightList.add("Bright Sky");
		lightList.add("Veranda");
		advice.put("light", lightList);
	}
	
//	public String getPassword(String name) {
//		return users.get(name);
//	}
//	public List<String> getAdvice(String roast) {
//		return advice.get(roast);
//	}

	public Map<Integer, String> roasts =  new HashMap<Integer, String>() {
		{
			put(1, "dark");
			put(2, "medium");
			put(3, "light");
		}
	};


//	public static void main(String[] args){
//		Database data = new Database();
//		System.out.print(data.getPassword("michelle"));
//	}
}
