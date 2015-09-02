package com.tortilla.Service;

import com.google.gson.Gson;
import com.tortilla.db.SparkCassandraConnector;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.cassandra.CassandraSQLContext;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: uttam
 * Date: 8/31/15
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/json/metallica")
public class JSONService {
    /*
    @GET
     @Path("/get")
     @Produces(MediaType.APPLICATION_JSON)
     public Track getTrackInJSON() {

        Track track = new Track();
        track.setTitle("Enter Sandman");
        track.setSinger("Metallica");
        return track;
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Track track) {

        String result = "Track saved : " + track;
        return Response.status(201).entity(result).build();

    }        */

   /* @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public CallReport getCallReportInJSON() {
        CallReport callReport = new CallReport();
        callReport.setFirst_name("Mohini");
        callReport.setLast_name("Joshi");
        return callReport;
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCallReportInJSON(CallReport callReport) {

        String result = "CallReport saved : " + callReport;
        return Response.status(201).entity(result).build();

    } */

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public CallReport getCallReportInJSON() {
        SparkCassandraConnector connector = new SparkCassandraConnector();
        CassandraSQLContext sqlcontext = connector.GetCassandraSQLContext();
        sqlcontext.setKeyspace("crm");
        DataFrame callreportsdata = sqlcontext.sql("select * from callreports where call_report_type = 'prospects'");
        callreportsdata.registerTempTable("callreportsdata");
        java.util.List<Row> tableRows = callreportsdata.collectAsList();
        List<CallReport> lst = new ArrayList<CallReport>();
        Gson gson = new Gson();

        List<CallReport> callReports = callreportsdata.javaRDD().map(new Function<Row, CallReport>() {
            public CallReport call(Row row) {
                CallReport callReport = new CallReport();
                callReport.setId(row.getInt(0));
                callReport.setCall_report_type(row.getString(1));
                callReport.setCall_reports(row.getString(2));
                callReport.setCity(row.getString(3));
                callReport.setCountry(row.getString(4));
                callReport.setEmail(row.getString(5));
                callReport.setFirst_name(row.getString(6));
                callReport.setLast_name(row.getString(7));
                return callReport;
            }
        }).collect();
        return callReports.get(0);
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCallReportInJSON(CallReport callReport) {
        String result = "CallReport saved : " + callReport;
        return Response.status(201).entity(result).build();
    }
}
