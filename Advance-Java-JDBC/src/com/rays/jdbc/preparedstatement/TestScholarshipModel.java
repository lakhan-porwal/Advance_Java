package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;

public class TestScholarshipModel {
	
       public static void main(String[] args) throws Exception {
    	   
    	   testUpdate ();
    	   
		
	}

	private static void testUpdate() throws Exception {
		
		ScholarshipModel model = new ScholarshipModel ();
		
		ScholarshipBean bean = new ScholarshipBean ();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		bean.setScholarshipId(2003);
		bean.setScholarshipName("AICTE Pragati Scholarship for Girls");
		bean.setAmount(50000);
		bean.setEligibility("Girl students in 1st year");
		bean.setLastdate(sdf.parse("2025-10-31"));
		
		model.Update(bean);
		
	}
	
}
