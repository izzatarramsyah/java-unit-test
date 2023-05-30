package com.example.demo.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class UtilTest {

    @Test
	public final void EncryptTest() {
        String result = Util.encrypt( "testing" );
        assertEquals(result, "ov8I2qwjhBhQ6O3ivvjRHw==");
    }
    
    @Test
	public final void DecryptTest() {
        String result = Util.decrypt( "ov8I2qwjhBhQ6O3ivvjRHw==" );
        assertEquals(result, "testing");
    }
    
}
