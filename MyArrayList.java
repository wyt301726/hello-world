package com.wyt.main;

import java.util.Iterator;

public class MyArrayList<AnyType> implements Iterable<AnyType> {
	
	private static final int DEFAULT_CAPACITY = 10; //并须以static来修饰
	private int theSize;
	private AnyType[] theItems ;
	
	/**
	 * 默认构造函数
	 */
	public MyArrayList(){
		clear();
	}
	
	/**
	 * 此方法显示表中元素个数,也是表的大小
	 * @return 返回表中有多个元素
	 */
	public int size(){
		return theSize;
	}
	
	/**
	 * 清空表
	 */
	public void clear(){
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	/**
	 * 判断该表是否为空
	 * @return 返回该表是否为空
	 */
	public boolean isEmpty(){
		return size() == 0;
	}
	
	/**
	 * 
	 * @param idx 位置
	 * @return 返回表中该位置的元素
	 */
	public AnyType get(int idx){
		if(idx<0||idx>=size())
			throw new ArrayIndexOutOfBoundsException();
		return theItems[idx];
	}
	
	/**
	 * 修改方法，将表中某位置的数改变
	 * @param idx 位置
	 * @param value 改变值
	 * @return 返回表中被改的值
	 */
	public AnyType set(int idx,AnyType x){
		if(idx<0||idx>=size())
			throw new ArrayIndexOutOfBoundsException();
		AnyType old = theItems[idx];
		theItems[idx] = x;
		return old;
	}
	
	/**
	 * 此方法让表确定最大容量
	 * @param newCapacity 新的容量大小
	 */
	public void ensureCapacity(int newCapacity){
		if(newCapacity < theSize)
			return;
		AnyType[] old = theItems;
		theItems = (AnyType[])new Object[newCapacity];
		for(int i=0;i<size();i++){
			theItems[i] = old[i];
		}
	}
	
	/**
	 * 用于加入表的末端
	 */
	public boolean add(AnyType x){
		add(size(),x);
		return true;
	}
	
	/**
	 * 将数值插入到固定的位置之中
	 * @param idx 位置
	 * @param x 要插入的元素
	 */
	public void add(int idx,AnyType x){
		if(idx<0||idx>=theItems.length)
			throw new ArrayIndexOutOfBoundsException();
		if(theSize == theItems.length){
			ensureCapacity(size()*2+1);    //加1是为了防止扩充为零
		}
		for(int i=theSize;i>idx;i--){
			theItems[i] = theItems[i-1];
		}
		theItems[idx] = x;
		theSize++;
	}
	
	public AnyType remove(int idx){
		AnyType removedItem = theItems[idx];
		for(int i= idx;i<size()-1;i++){
			theItems[i] = theItems[i+1]; 
		}
		theSize--;
		return removedItem;
	}

	public Iterator<AnyType> iterator(){
		return new ArrayListIterator();
	}
	
	public class ArrayListIterator implements java.util.Iterator<AnyType>
	{
		private int current = 0;

		
		public boolean hasNext() {
			
			return false;
		}

		
		public AnyType next() {
			
			return null;
		}
		
		public void remove(){
			
		}
	}
}
