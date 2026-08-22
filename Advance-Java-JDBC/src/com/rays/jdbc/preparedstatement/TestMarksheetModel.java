package com.rays.jdbc.preparedstatement;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

		testAdd();

	}

	private static void testAdd() throws Exception {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = new MarksheetBean();

		bean.setId(2);
		bean.setRollNo(1202);
		bean.setName("Vivek Carpenter");
		bean.setEnglish(50);
		bean.setHindi(60);
		bean.setPhysics(45);
		bean.setChemistry(40);
		bean.setMaths(55);

		model.add(bean);
	}

}
