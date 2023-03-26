package com.keep.pcc;

import com.keep.pcc.controller.AppUserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PccApplicationTests {

	@Autowired
    AppUserController reqCtrlr;

	@Test
	void contextLoads() {
	}

	@Test
	void healthyTest() {
		System.out.println(reqCtrlr.healthCheck());
	}

}
