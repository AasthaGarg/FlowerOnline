package com.ecommerce.flower;


import org.junit.runner.*;
import org.junit.runners.Suite;



@RunWith(Suite.class)
@Suite.SuiteClasses({
	CartTests.class,
	CustomerTests.class,
	ProductTests.class
})
class BackendApplicationTests{


}