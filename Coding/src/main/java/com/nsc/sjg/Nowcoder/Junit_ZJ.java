package com.nsc.sjg;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

public class Junit_ZJ {

	private Scanner scan = new Scanner(System.in);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	//@Test
	public void test01() {
		//fail("Not yet implemented");
		//String line1 = scan.nextLine();
		//String[] nums = line1.split(" ");
		while(scan.hasNext()){
			String date = scan.nextLine();
			String[] dates = date.split(" ");
			int year = Integer.valueOf(dates[0]);
			int month = Integer.valueOf(dates[1]);
			int weekend = Integer.valueOf(dates[2]);
			int day = Integer.valueOf(dates[3]);
			if(weekend > 4){
				System.out.println(0);
			}
			
		}
		
	}
	private static int[] getDayRangeOfMonth(int year, int month){
		//该月开始默认星期1，结束星期日
		int[] res = new int[]{1,7};
		//是否是闰年闰月
		if(year%400 == 0 || (year%4 == 0&&year%100!=0)){
			//闰年
			
		}
		return res;
	} 

	public void test02(){
		List<Person> lists = new ArrayList<>();
		int curId = 0;
		while(scan.hasNext()){
			String datas = scan.nextLine();
			String[] nameAnDatas = datas.split(":");
			Person person = new Person();
			person.name = nameAnDatas[0];
			//文件顺序
			person.id = curId;
			int sums = 0;
			int tmpDay = 0;
			
			for(int i = 1; i < nameAnDatas.length; i++){
				int curStep = Integer.valueOf(nameAnDatas[i]);
				sums += curStep;
				if(curStep > 0){
					tmpDay++;
				}
				//评价约束
				
				
			}
			//步数
			person.steps = sums;
			//天数
			person.days = tmpDay;
			lists.add(person);
			Collections.sort(lists, new Comparator<Person>() {

				@Override
				public int compare(Person o1, Person o2) {
					// TODO Auto-generated method stub
					//从大到小排序
					//优先级：约束-步数-文件顺序
					if(o1.lev == o2.lev){
						if(o1.steps == o2.steps){
							return o1.id - o2.id;
						}else{
							return o2.steps - o1.steps;							
						}
					}else{
						return o2.lev - o1.lev;
					}
					
				}
			});
			curId++;
		}
	}
	public static int getLev(Person per){
		int res = 0;
//		switch(per.days){
//		case 4:
//			if(){}
//			break;
//		case 15:break;
//		case 18:break;
//		}
		return res;
	}
}
class Person{
	public int id = 0;
	public String name = "";
	public int days = 0;
	public int steps = 0;
	public int lev = 5;
	public Person(){
		
	}
	public Person(int id, String name, int days, int steps, int lev) {
		super();
		this.id = id;
		this.name = name;
		this.days = days;
		this.steps = steps;
		this.lev = lev;
	}
	
}
