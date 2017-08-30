package com.antlrengine.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author qplc
 */
public class TypeHandler {

    public void executeMethod(String metadata) {
        String[] data = metadata.split("\\(");
        String classname = data[0].substring(0, data[0].lastIndexOf("."));
        String methodname = data[0].substring(data[0].lastIndexOf(".") + 1, data[0].length());
        String params[] = data[1].replaceAll("\\)", "").split("\\)");

        System.out.println("metadata: " + classname + " ** " + methodname + " ** " + data[1].replaceAll("\\)", ""));
        executeMethod(classname, methodname, params);
    }

    private void executeMethod(String classname, String methodname, String[] params) {
        try {
            Class<?> cls = Class.forName(classname);
            Object obj = cls.newInstance();

            Class classtypes[] = getClassTypes(params);
            Object arglist[] = getArguments(params);

            Method method = cls.getDeclaredMethod(methodname, classtypes);
            Object retobj = method.invoke(obj, arglist);

            System.out.println(methodname + "() output: " + retobj);
            System.out.println();
        } catch (SecurityException | NoSuchMethodException | IllegalArgumentException
                | IllegalAccessException | InvocationTargetException | ClassNotFoundException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    private Class[] getClassTypes(String params[]) {
        Class[] types = null;
        for (int i = 0; i < params.length; i++) {
            String data = params[i];
            data = data.replaceAll("\"", "");
            String args[] = data.split(",");
            types = new Class[args.length];
            for (int j = 0; j < args.length; j++) {
                String arg = args[j];
                if (arg.contains(":")) {
                    types[j] = parseClass(arg.split(":")[0]);
                }
            }
        }
        return types;
    }

    private Object[] getArguments(String params[]) {
        Object arglist[] = null;
        for (int i = 0; i < params.length; i++) {
            String data = params[i];
            data = data.replaceAll("\"", "");
            String args[] = data.split(",");
            arglist = new Object[args.length];
            for (int j = 0; j < args.length; j++) {
                String arg = args[j];
                if (arg.contains(":")) {
                    arglist[j] = parseArgument(arg.split(":")[0], arg.split(":")[1]);
                }
            }
        }
        return arglist;
    }

    private Class<? extends Object> parseClass(String name) {
        ClassType type = ClassType.valueOf(name);
        switch (type) {
            case TINT:
                return Integer.TYPE;
            case TSTRING:
                return String.class;
        }
        return null;
    }

    private Object parseArgument(String name, String arg) {
        ClassType type = ClassType.valueOf(name);
        switch (type) {
            case TINT:
                return Integer.parseInt(arg);
            case TSTRING:
                return arg;
        }
        return null;
    }

    public enum ClassType {
        TINT("TINT"), TSTRING("TSTRING");

        private final String type;

        ClassType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
