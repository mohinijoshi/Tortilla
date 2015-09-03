package com.tortilla.Service;

import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Row;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: uttam
 * Date: 9/2/15
 * Time: 11:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class CallReportFunction implements Function<Row, CallReport>, Serializable {

    @Override
    public CallReport call(Row row) throws Exception {
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
}
