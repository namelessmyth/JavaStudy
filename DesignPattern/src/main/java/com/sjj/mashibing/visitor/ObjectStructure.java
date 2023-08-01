package com.sjj.mashibing.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 元素生产者，一般容纳在多个不同类、不同接口的容器，如List、Set、Map等，在项目中一般很少抽象出这个角色。
 */
public class ObjectStructure {
    private List<Element> list = new ArrayList<Element>();

    public void accept(Visitor visitor) {
        Iterator<Element> i = list.iterator();
        while (i.hasNext()) {
            ((Element) i.next()).accept(visitor);
        }
    }

    public void add(Element element) {
        list.add(element);
    }

    public void remove(Element element) {
        list.remove(element);
    }
}
