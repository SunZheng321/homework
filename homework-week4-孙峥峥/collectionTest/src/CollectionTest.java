/*实例2-week4-集合中的相关知识与File类-孙峥峥
程序要点：
1、理解和使用Collection接口中的List和Set集合的相关方法；（add、remove、isEmpty、iiterator、size）
2、理解和使用Map的相关方法；（put()、containskey()、containsValue()、get()、KeySet());
3、理解和使用File的相关方法；(这部分在homework创建一个读写类中)；
需要注意的地方：1、map、list、set三种都是集合用来存储对象类型的数据，其中list和set属于是属于单列集合，map属于双列集合，
list集合的特点是元素有序且可重复，set是元素无序不能重复，map集合以Key值对来存储元素，例如每个人有身份证，那么存储在集合中map
，其中id表示身份证，peason对象表示人。当你需要元素唯一时，使用set，否则使用list，当需要具备键值对特性时，使用map。
 */

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {


        //list中常见方法；add、remove、isEmpty、iiterator、size
        Collection<String> list = new ArrayList<>();
        //使用add将对象添加到合集中；
        System.out.println("首先是List集合实例训练！");
        list.add("刘备");
        list.add("关羽");
        list.add("张飞");
        list.add("赵云");
        list.add("黄忠");
        //创建迭代器；
        Iterator<String> it = list.iterator();
        System.out.println("List中五虎上将包括：");
        while (it.hasNext()) {     //判断是否有下一个元素；
            String str = it.next();  //获取集合中元素；
            System.out.println(str);
        }
        System.out.println("利用Get()方法得到五虎上将第三位为：" + ((ArrayList<String>) list).get(2));


        //Set相关方法：
        System.out.println("\n接下来是Set集合实例训练！");
        Set<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(23);
        set.add(0);
        set.add(-12);
        set.add(-24);
        Iterator<Integer> it2 = set.iterator();//创建Iterator对象；
        System.out.println("Set中元素从小到达排序如下:");
        while (it2.hasNext()){
            System.out.println(it2.next()+"；");
        }


        //Map相关代码训练；
        System.out.println("\n接下来是Map集合实例训练！");
        Map<String,String> map =new HashMap<>();
        map.put("1","刘备");
        map.put("2","关羽");
        map.put("3","张飞");
        map.put("4","赵云");
        map.put("5","黄忠");
        Set<String> set2=map.keySet();//创建Map集合中所有key的set集合；
        Iterator<String> it3=set2.iterator();
        System.out.println("Key值为：");
        while (it3.hasNext()){
            System.out.println(it3.next());
        }
        Collection<String> coll =map.values();
        it3=coll.iterator();
        System.out.println("value值为：");
        while (it3.hasNext()){
            System.out.println(it3.next());//遍历输出Map集合中的value值
        }
    }

}
