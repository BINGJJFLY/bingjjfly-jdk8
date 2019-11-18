package com.wjz.jdk.annoextension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 注解扩展
 */
public class AnnoExtension {

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
    public @interface NotEmpty {

    }

    public static class Holder<@NotEmpty T> extends @NotEmpty Object {
        public void hold() throws @NotEmpty Exception {
            @NotEmpty int i = 1;
        }
    }

    public static void main(String[] args) {
        final Holder<String> holder = new @NotEmpty Holder<>();
        @NotEmpty Collection<@NotEmpty String> list = new ArrayList<>();
    }
}
