/**
 * @(#)Sets.java
 * Copyright (C) 2003-2010 iocn.org All rights reserved
 */
package tmp;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


/**
 * @author <b>Oxidy</b>, Copyright &#169; 2010
 * @version 0.1,2010-8-19
 */
public class Sets {

    /** 求并集 */
    @SuppressWarnings("unchecked")
    public static <T> Set<T> union(Set<T> setA, Set<T> setB) {
        Set<T> setUnion;
        if (setA instanceof TreeSet){
            setUnion = new TreeSet<T>();
        }else{
            setUnion = new HashSet<T>();
        }
        Iterator<T> iterA = setA.iterator();
        while (iterA.hasNext()){
            setUnion.add(iterA.next());
        }
        Iterator<T> iterB = setB.iterator();
        while (iterB.hasNext()){
            setUnion.add(iterB.next());
        }
        return setUnion;
    }
    
    /** 求交集 */
    @SuppressWarnings("unchecked")
    public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
        Set<T> setIntersection;
        T item;
        if (setA instanceof TreeSet) {
            setIntersection = new TreeSet<T>();
        } else {
            setIntersection = new HashSet<T>();
        }
        Iterator<T> iterA = setA.iterator();
        while (iterA.hasNext()) {
            item = iterA.next();
            if (setB.contains(item)) {
                setIntersection.add(item);
            }
        }
        return setIntersection;
    }  
    
    /** 求差集 */
    @SuppressWarnings("unchecked")
    public static <T> Set<T> difference(Set<T> setA, Set<T> setB) {
        Set<T> setDifference;
        T item;
        if (setA instanceof TreeSet) {
            setDifference = new TreeSet<T>();
        } else {
            setDifference = new HashSet<T>();
        }
        Iterator<T> iterA = setA.iterator();
        while (iterA.hasNext()) {
            item = iterA.next();
            if (!setB.contains(item)) {
                setDifference.add(item);
            }
        }
        return setDifference;
    } 
    
    /**  
     * 判断子集操作 判断setA中的每个元素是否也存在于setB中  
     */  
    public static <T> boolean subset(Set<T> setA, Set<T> setB) {   
        return intersection(setA, setB).size() == setA.size();   
    } 
}
