package com.Tortilla.Service;

import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Row;

import java.io.Serializable;

/**
 * Created by Mohini on 2/9/2016.
 */
public class JobClassFunction implements Function<Row, JobClass>, Serializable {


        public JobClass call(Row row) throws Exception {
            JobClass jobClass = new JobClass();
            jobClass.setSkills_Count(row.getLong(0));
            jobClass.setSkills(row.getString(1));
            return jobClass;
        }
}
