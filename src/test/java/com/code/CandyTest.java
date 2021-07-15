package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: wangzongyu
 * @Date: 2020/4/18 18:05
 */
public class CandyTest {

	Candy candy = new Candy();
	@Test
	public void candy() {
		int[] in= {1,0,2};
		int result = this.candy.candy(in);

		Assert.assertEquals(5, result);
	}


	@Test
	public void candy2() {
		int[] in= {1,2,2};
		int result = this.candy.candy(in);

		Assert.assertEquals(4, result);
	}

	@Test
	public void candy3() {
		int[] in= {1};
		int result = this.candy.candy(in);

		Assert.assertEquals(1, result);
	}

	@Test
	public void candy4() {
		int[] in ={};
		int result = this.candy.candy(in);

		Assert.assertEquals(0, result);
	}
	@Test
	public void candy5() {
		int[] in ={1,3,2,2,1};
		int result = this.candy.candy(in);

		Assert.assertEquals(7, result);
	}
	@Test
	public void candy6() {
		int[] in ={1,2};
		int result = this.candy.candy(in);

		Assert.assertEquals(3, result);
	}

}