package com.gem.springboot.mashibing;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/10/10
 */
public class MyDeferredImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("MyDeferredImportSelector.selectImports()方法执行...");
        return new String[0];
    }

    @Override
    public Class<? extends Group> getImportGroup() {
        System.out.println("MyDeferredImportSelector.getImportGroup()方法执行...");
        return MyDeferredImportSelectorGroup.class;
    }

    public static class MyDeferredImportSelectorGroup implements Group{
        private final List<Entry> imports = new ArrayList<>();
        @Override
        public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
            System.out.println("MyDeferredImportSelectorGroup.process()");
        }

        @Override
        public Iterable<Entry> selectImports() {
            System.out.println("MyDeferredImportSelectorGroup.selectImports()");
            return imports;
        }
    }
}