package net.worthington.mavensample;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        myPrint("OriginationDate");
        myPrint("PurchaseDate");
        myPrint("MaturityDate");
        myPrint("QualificationDate");
        myPrint("BusinessStartDate");
        myPrint("VintageMonth");
        myPrint("LastPaymentDate");
        myPrint("LastRemittanceDate");
        myPrint("NextPaymentDate");
        myPrint("NextPaymentDateInterest");
        myPrint("NextPaymentDatePrincipal");
        myPrint("EstimatedETPMaturityDate");
        myPrint("ReportingDate");
        myPrint("ForgivenessApplicationDate");
        myPrint("DateOfForgivenessDecision");
        myPrint("GP_submit_date");
        myPrint("GP_status_date");
        myPrint("Appeal_Date");
        myPrint("Demand_Date");
    }

    private static void myPrint(String string) {
        String s = "      <field>        <in_stream_name>"+string+"</in_stream_name>        <out_stream_name/>        <use_regex>no</use_regex>        <replace_string>1/1/1900</replace_string>        <replace_by_string/>        <set_empty_string>Y</set_empty_string>        <replace_field_by_string/>        <whole_word>no</whole_word>        <case_sensitive>no</case_sensitive>        <is_unicode>no</is_unicode>      </field>      <field>        <in_stream_name>"+string+"</in_stream_name>        <out_stream_name/>        <use_regex>no</use_regex>        <replace_string>1/1/1901</replace_string>        <replace_by_string/>        <set_empty_string>Y</set_empty_string>        <replace_field_by_string/>        <whole_word>no</whole_word>        <case_sensitive>no</case_sensitive>        <is_unicode>no</is_unicode>      </field>";

        System.out.println(s);
    }
}
