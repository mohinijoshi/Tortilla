package com.Tortilla.Service;

import com.tortilla.db.SparkCassandraConnector;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.cassandra.CassandraSQLContext;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Mohini on 2/1/2016.
 */
@Path("/jobs")
public class JobService {

    @GET
    @Path("/skill")
    @Produces(MediaType.APPLICATION_JSON)
    public List<JobClass> GetJobsBySkills(){

        SparkCassandraConnector connector = new SparkCassandraConnector("52.36.13.56");
        CassandraSQLContext sqlcontext = connector.GetCassandraSQLContext();
        sqlcontext.setKeyspace("jobsmarket");
        DataFrame jobsdata = sqlcontext.sql("select count(job_id), skills from jobsmarket.jobs group by skills");
        jobsdata.registerTempTable("jobsdata");
        List<JobClass> jobs = jobsdata.javaRDD().map(new com.Tortilla.Service.JobClassFunction()).collect();
        return jobs;
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<JobClass> GetJobs() {
        SparkCassandraConnector connector = new SparkCassandraConnector();
        CassandraSQLContext sqlcontext = connector.GetCassandraSQLContext();
        sqlcontext.setKeyspace("jobsmarket");
        DataFrame jobsdata = sqlcontext.sql("select * from jobsmarket.jobs");
        jobsdata.registerTempTable("jobsdata");

        List<JobClass> jobs = jobsdata.javaRDD().map(new com.Tortilla.Service.JobClassFunction()).collect();
        return jobs;
    }
}
