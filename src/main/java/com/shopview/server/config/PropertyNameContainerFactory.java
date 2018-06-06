package com.shopview.server.config;

import com.jfinal.plugin.activerecord.IContainerFactory;

import java.util.*;

/**
 * @author duhongg
 * @since 2018-06-07
 */
public class PropertyNameContainerFactory implements IContainerFactory {

    public Object convert(Object key) {
        if (key instanceof String) {
            String property = ((String) key);
            String[] split = property.split("_");
            String reKey = "";
            for (int i = 0; i < split.length; i++) {
                String item = split[i];
                if (i != 0) reKey = reKey + item.substring(0, 1).toUpperCase() + item.substring(1);
                else reKey = reKey + item;
            }
            key = reKey;
        }
        return key;
    }

    private static boolean toUpperCase = true;

    public PropertyNameContainerFactory() {
    }

    public PropertyNameContainerFactory(boolean toUpperCase) {
        PropertyNameContainerFactory.toUpperCase = toUpperCase;
    }

    public Map<String, Object> getAttrsMap() {
        return new PropertyNameMap();
    }

    public Map<String, Object> getColumnsMap() {
        return new PropertyNameMap();
    }

    public Set<String> getModifyFlagSet() {
        return new PropertyNameSet();
    }

    public class PropertyNameSet extends HashSet {
        private static final long serialVersionUID = 2337255096474815584L;

        public boolean add(Object e) {
            return super.add(convert(e));
        }

        public boolean remove(Object e) {
            return super.remove(convert(e));
        }

        public boolean contains(Object e) {
            return super.contains(convert(e));
        }

        public boolean addAll(Collection c) {
            boolean modified = false;
            for (Object o : c)
                if (super.add(convert(o)))
                    modified = true;
            return modified;
        }
    }

    public class PropertyNameMap extends HashMap {
        private static final long serialVersionUID = -4107018318847768335L;
        public Object get(Object key) {
            return super.get(convert(key));
        }
        public boolean containsKey(Object key) {
            return super.containsKey(convert(key));
        }
        public Object put(Object key, Object value) {
            return super.put(convert(key), value);
        }
        public void putAll(Map m) {
            for (Map.Entry e : (Set<Map.Entry>) (m.entrySet()))
                super.put(convert(e.getKey()), e.getValue());
        }
        public Object remove(Object key) {
            return super.remove(convert(key));
        }
    }
}