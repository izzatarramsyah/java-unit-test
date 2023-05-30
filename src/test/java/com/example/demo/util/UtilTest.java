package com.example.demo.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class UtilTest {

    @Test
	public final void AddTest() {
        int result = Util.add( 1 , 1 );
        assertEquals(result, 2);
    }
    
    @Test
	public final void MinTest() {
        int result = Util.min( 1 , 1 );
        assertEquals(result, 0);
    }
    
}
