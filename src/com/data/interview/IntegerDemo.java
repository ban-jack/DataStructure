package com.data.interview;

/*
Integer、new Integer、int 的区别
参考链接：https://www.cnblogs.com/java-stack/p/11952049.html
 */
public class IntegerDemo {
    public static void main(String[] args) {

        Integer a = 100;
        Integer b = 100;
        System.out.println("a == b:"+(a == b)); //true

        Integer c = new Integer(100);
        Integer d = new Integer(100);

        System.out.println("c == d:"+(c == d)); //false 内存地址不同

        // 两个Integer 变量比较，如果两个变量的值在区间-128到127 之间，则比较结果为true，如果两个变量的值不在此区间，则比较结果为 false
        // java对于-128到127之间的数，会进行缓存。所以 Integer i = 127 时，会将127进行缓存，下次再写Integer j = 127时，就会直接从缓存中取，就不会new了。

        Integer e = 1000;
        Integer f = 1000;

        System.out.println("e == f:"+(e == f));//false

        Integer g = 128;
        Integer h = 128;

        System.out.println("e == h:"+(e == h));//false

        System.out.println("a == c:"+(a == c));// false new了一个地址

        //自动拆箱为 int a/c = 100; 此时，相当于两个int的比较
        int i = 100;
        System.out.println("a == i:"+(a == i));//true
        System.out.println("c == i:"+(c == i));//true

        /*
        i01 == i02 。i01.intValue()i02 两个值的比较5959 -->true;

        i01 == i03 。由于 59在-128到127之间，所以，i01和i03的赋值操作返回的是同一个对象。都是从chche中返回的同一个对象，对象地址相同 true;

        i03 == i04。i03是来自缓存值，i04是新new的对象 ，二者不是同一个对象，所以false。

        i02 == i04。和第一个类似，true。
         */
        Integer i01 = 59;
        int i02 = 59;
        Integer i03 =Integer.valueOf(59);
        Integer i04 = new Integer(59);
        System.out.println("i01 == i02:"+(i01 == i02));
        System.out.println("i01 == i03:"+(i01 == i03));
        System.out.println("i03 == i04:"+(i03 == i04));
        System.out.println("i02 == i04:"+(i02 == i04));
    }

}
