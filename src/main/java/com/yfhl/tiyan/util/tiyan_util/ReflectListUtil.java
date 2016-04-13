package com.yfhl.tiyan.util.tiyan_util;

import java.lang.reflect.Field;
import java.util.List;

/***
 * 通过反射遍历List(现主要用于测试时查看遍历的数据）
 *@author ygq 
 *@data 2016-4-12 time 下午3:50:05
 *
 */
public class ReflectListUtil {
	/***
	 * 调用公共方法
	  *@author  ygq data 2016-4-12 time 上午11:45:03
	 * @param p
	 */
	public static void reflectMethods(Object p,int num){
		try{
			
	        Class c = p.getClass();   
	        Field[] declaredFields = c.getDeclaredFields();
	        System.out.print("第" + num + "个::");
	        //获得所有成员变量   
	        for(int i = 0; i < declaredFields.length; i++) {   
	            //遍历所有成员变量   
	            Field field = declaredFields[i]; 
	            field.setAccessible(true);//访问私有必须调用
	            //获取成员变量的名字   
	            System.out.print("名称：" + field.getName()+"\t" + "值为\t"+field.get(p) + "  ");   
	        }
	        System.out.println();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/***
	 * 遍历list
	  *@author  ygq data 2016-3-3 time 上午9:17:47
	 * @param list
	 */
	public static void ergodicList(List list){
		if(null == list){
			System.out.println("ergodicList  list is null");
		}else{
			System.out.println("list.size()::::::" + list.size());
			for(int i=0;i<list.size();i++){
				reflectMethods(list.get(i),i);
			}
		}
	}
	/***
	 * 遍历page
	 * 传list和count
	  *@author  ygq data 2016-4-12 time 下午2:29:28
	 * @param page
	 */
	public static void ergodicPage(List list,int count){
		if(null == list){
			System.out.println("ergodicList  list is null");
		}else{
			System.out.println("totalCount:::::" + count + "\tlist.size()::::::" + list.size());
			for(int i=0;i<list.size();i++){
				reflectMethods(list.get(i),i);
			}
		}
	}
}
