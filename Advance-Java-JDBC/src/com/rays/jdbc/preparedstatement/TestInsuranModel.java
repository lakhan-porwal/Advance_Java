package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;

import in.co.rays.jdbc.TestUpdate;
import in.co.rays.util.JDBCDataSource;

public class TestInsuranModel {
	
	public static void main(String[] args) throws Exception {
		
		testUpdate();
	}
	
	

	public static void testUpdate() throws Exception {
		
          InsuranceModel model = new InsuranceModel ();
          
          InsuranceBean bean = new InsuranceBean ();
          
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          
          bean.setPolicyId(12345);
          bean.setPolicyHolderName("jethalal");
          bean.setPolicyType("General Insurance");
          bean.setPremiumAmount("50,000 per year");
          bean.setExpiryDate(sdf.parse("2025-10-10"));
		
          model.add(bean);
		
	}

}
