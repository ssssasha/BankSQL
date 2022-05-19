package com.solvd.hospital;

import com.solvd.hospital.receptions.Schedule;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;


public class ExtraClass {
    private final static Logger LOGGER = LogManager.getLogger(Hospital.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("The name of class is " +
                Schedule.class.getName());
        Constructor[] constructors = Schedule.class.getConstructors();
        LOGGER.info("The names of constructors are : ");
        for (Constructor con : constructors) {
            LOGGER.info(con);
        }
        Schedule schedule = (Schedule) constructors[0].newInstance();
        Field[] fields = schedule.getClass().getDeclaredFields();
        LOGGER.info("The fields of class are : ");
        for (Field field : fields)
            LOGGER.info(Modifier.toString(field.getModifiers()) + " " + field.getType() + " " + field.getName());
        //Field fieldFirst = schedule.getClass().getDeclaredField(fields[0].getName());
        //System.out.println(fieldFirst);
        Method[] methods = schedule.getClass().getDeclaredMethods();
        LOGGER.info("The methods of class are : ");
        for (Method method : methods)
            LOGGER.info(Modifier.toString(method.getModifiers()) + " " + method.getReturnType() + " " + method.getName());
        String value = "Monday";
        Method m2 = Schedule.class.getDeclaredMethod("get" + StringUtils.capitalize(fields[0].getName()));
        LOGGER.info(m2.invoke(schedule));
        invokeSetter(schedule, fields[0].getName(), "monday");
        LOGGER.info(m2.invoke(schedule));
//
    }

    private static void invokeSetter(Object schedule, String fieldName, Object value) {
        try {
            Method method = schedule.getClass().getMethod("set"
                    + StringUtils.capitalize(fieldName), value.getClass());
            method.invoke(schedule, value);

        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
