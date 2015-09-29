package ua.yandex.shad.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {
    
	public static final double EPS = 0.00001;
    
	@Test(expected = IllegalArgumentException.class)
	public void testAverage_FailOnEmptyList() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.average();
    }
	
	@Test
    public void testAverage_WithZeroAnswer() {
        double[] temperatureSeries = {1.0, -5.0, -1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;
        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, EPS);
    }
	
	@Test
    public void testAverage_WithOneArgument() {
        double[] temperatureSeries = {10.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 10.5;
        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, EPS);
    }
	
	@Test
    public void testAverage_WithPositiveArguments() {
        double[] temperatureSeries = {6.85, 14.94, 12.3, 8.45};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 10.635;
        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, EPS);
    }
		
    @Test
    public void testAverage_WithFiveArguments() {
        double[] temperatureSeries = {6.8, -15.9, 18.4, 22.8, 12.1};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 8.84;
        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, EPS);
    }	
	
    @Test
    public void testAverage_WithTenArguments() {
        double[] temperatureSeries = {14.5, -48.94, -50.2, 0.5, 11.8, 179.4, 350.6, 320.0, 221.21, 98.6};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 109.747;
        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test(expected = IllegalArgumentException.class)
	public void testDeviation_FailOnEmptyList() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.deviation();
    }
	
	@Test
	public void testDeviation_WithSingleArgument() {
        double[] temperatureSeries = {10.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;
		double actualResult = seriesAnalysis.deviation();
		assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test
	public void testDeviation_WithEqualArguments() {
        double[] temperatureSeries = {-5, -5, -5, -5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;
		double actualResult = seriesAnalysis.deviation();
		assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test
	public void testDeviation_WithNaturalArguments() {
        double[] temperatureSeries = {1, 4, 8, 2, 5, 9, 8, 4, 8, 2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 2.80891438103;
		double actualResult = seriesAnalysis.deviation();
		assertEquals(expResult, actualResult, EPS);
    }
	
	@Test
	public void testDeviation_WithOppositeArguments() {
        double[] temperatureSeries = {-10, 0, 10};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 8.16496580927746;
		double actualResult = seriesAnalysis.deviation();
		assertEquals(expResult, actualResult, EPS);
    }
	
	@Test
	public void testDeviation_WithFloatArguments() {
        double[] temperatureSeries = {1.45, 2.85, 4.15, 3.18, 1.45};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0435631269837;
		double actualResult = seriesAnalysis.deviation();
		assertEquals(expResult, actualResult, EPS);
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void testMin_FailOnEmptyList() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.min();
    }
	
    @Test
    public void testMin_WithSingleArgument() {
        double[] temperatureSeries = {120.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 120.0;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void testMin_WithSixArguments() {
        double[] temperatureSeries = {68.9, 50.0, 14.8, -2.6, 1.8, -2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -2.6;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void testMin_WithTenArguments() {
        double[] temperatureSeries = {-150.6, -78.5, -36.0, -55.4, -20.8, -11.9, -18.6, -220.4, -180.6, -199.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -220.4;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test(expected = IllegalArgumentException.class)
	public void testMax_FailOnEmptyList() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.max();
    }
	
	@Test
    public void testMax_WithSixArguments() {
        double[] temperatureSeries = {49.9, 68.4, 22.5, 12.8, 14.5, 16.9};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 68.4;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void testMax_WithTenArguments() {
        double[] temperatureSeries = {127.4, 19.9, -50.6, 0.0, 12.4, 34.5, 179.0, 17.9, 1.6, 69.9};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 179.0;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test(expected = IllegalArgumentException.class)
    public void findTempClosestToZero_FailOnEmptyList() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToZero();
    }	
	
	@Test
    public void findTempClosestToZero_WithOneArgument() {
        double[] temperatureSeries = {6.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 6.5;
        double actualResult = seriesAnalysis.findTempClosestToZero();
		assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void findTempClosestToZero_EqualDist() {
        double[] temperatureSeries = {-5, 5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 5;
        double actualResult = seriesAnalysis.findTempClosestToZero();
		assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void findTempClosestToZero_EqualDistLargerFirst() {
        double[] temperatureSeries = {18, 20, -18, -25, -40};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 18;
        double actualResult = seriesAnalysis.findTempClosestToZero();
		assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void findTempClosestToZero_EqualDistLargerSecond() {
        double[] temperatureSeries = {4.88, -1.15, 6.95, 1.15, 12.80};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 1.15;
        double actualResult = seriesAnalysis.findTempClosestToZero();
		assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void findTempClosestToZero_WithPositiveArguments() {
        double[] temperatureSeries = {160.5, 170, 148, 133, 192.5, 109};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 109;
        double actualResult = seriesAnalysis.findTempClosestToZero();
		assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void findTempClosestToZero_WithNegativeArgumentsAndMultipleAnswer() {
        double[] temperatureSeries = {-15.8, -7.9, -43.5, -7.9, -10};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = -7.9;
        double actualResult = seriesAnalysis.findTempClosestToZero();
		assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test(expected = IllegalArgumentException.class)
    public void findTempClosestToValue_FailOnEmptyList() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToValue(36.6);
    }	
	
	@Test
    public void findTempClosestToValue_WithArgumentsLargerThanValue() {
        double[] temperatureSeries = {115.8, 111.9, 150.687, 145.88};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 111.9;
        double actualResult = seriesAnalysis.findTempClosestToValue(50.0);
		assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void findTempClosestToValue_WithArgumentsLessThanValue() {
        double[] temperatureSeries = {-98.65, -12.88, -4.5, 1.8};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 1.8;
        double actualResult = seriesAnalysis.findTempClosestToValue(16.7);
		assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void findTempClosestToValue_EqualDistLargerFirst() {
        double[] temperatureSeries = {-15.8, 16.4, 19.0, 18.9, 16.9};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 18.9;
        double actualResult = seriesAnalysis.findTempClosestToValue(17.9);
		assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void findTempClosestToValue_EqualDistLowerFirst() {
        double[] temperatureSeries = {-0.399, 0.887, 0.442, 1.182, 0.941};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 0.941;
        double actualResult = seriesAnalysis.findTempClosestToValue(0.914);
		assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void findTempClosestToValue_WithPositiveArguments() {
        double[] temperatureSeries = {12.6, 14.8, 15.2, 11.9, 16.4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 15.2;
        double actualResult = seriesAnalysis.findTempClosestToValue(15.0);
		assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void findTempClosestToValue_WithNegativeArguments() {
        double[] temperatureSeries = {-14.95, -7.16, -0.83, -2.22};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = -2.22;
        double actualResult = seriesAnalysis.findTempClosestToValue(-3.52);
		assertEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void findTempClosestToValue_WithMultipleAnswers() {
        double[] temperatureSeries = {-6.5, -3.5, -6.5, -6.5, -3.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = -3.5;
        double actualResult = seriesAnalysis.findTempClosestToValue(-5.0);
		assertEquals(expResult, actualResult, EPS);
    }		
	
	@Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThen_FailOnEmptyList() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsLessThen(50.0);
    }
	
	@Test
    public void testFindTempsLessThen_WithSixArguments() {
        double[] temperatureSeries = {49.9, 68.4, 22.5, 112.8, 14.5, 16.9};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {49.9, 22.5, 14.5, 16.9};
        double[] actualResult = seriesAnalysis.findTempsLessThen(50.0);
        assertArrayEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void testFindTempsLessThen_WithEmptyResult() {
        double[] temperatureSeries = {50, 48, 442, 276, 321, -20};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};
        double[] actualResult = seriesAnalysis.findTempsLessThen(-100);
        assertArrayEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void testFindTempsLessThen_WithResultEqualToInput() {
        double[] temperatureSeries = {10, 9.5, 8.8, -4.1};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {10, 9.5, 8.8, -4.1};
        double[] actualResult = seriesAnalysis.findTempsLessThen(10.5);
        assertArrayEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void testFindTempsLessThen_WithEqualToValue() {
        double[] temperatureSeries = {9.8};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};
        double[] actualResult = seriesAnalysis.findTempsLessThen(9.8);
        assertArrayEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void testFindTempsLessThen_WithTenArguments() {
        double[] temperatureSeries = {49.9, 72.8, 22.5, 22.9, 50.0, 112.8, -50.6, 14.5, 16.9, 37.4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {49.9, 22.5, 22.9, -50.6, 14.5, 16.9, 37.4};
        double[] actualResult = seriesAnalysis.findTempsLessThen(50.0);
        assertArrayEquals(expResult, actualResult, EPS);
    }	
	
	@Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThen_FailOnEmptyList() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(50.0);
    }
	
	@Test
    public void testFindTempsGreaterThen_WithSixArguments() {
        double[] temperatureSeries = {49.9, 68.4, 22.5, 112.8, 14.5, 16.9};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {68.4, 112.8};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(50.0);
        assertArrayEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void testFindTempsGreaterThen_WithResultEqualToInput() {
        double[] temperatureSeries = {8.5, 9.4, 2.5, -4.1, -2.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {8.5, 9.4, 2.5, -4.1, -2.2};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(-12);
        assertArrayEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void testFindTempsGreaterThen_WithEqualToValue() {
        double[] temperatureSeries = {150.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {150.5};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(150.5);
        assertArrayEquals(expResult, actualResult, EPS);
    }	
	
	@Test
    public void testFindTempsGreaterThen_WithTenArguments() {
        double[] temperatureSeries = {49.9, 72.8, 22.5, 22.9, 50.0, 112.8, -50.6, 14.5, 16.9, 37.4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {72.8, 50.0, 112.8};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(50.0);
        assertArrayEquals(expResult, actualResult, EPS);
    }	
	
	@Test(expected = IllegalArgumentException.class)
    public void testSummaryStatistics_FailOnEmptyList() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
    }
	
	@Test
    public void testSummaryStatistics_WithSingleArgument() {
        double[] temperatureSeries = {6.8};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics expResult = new TempSummaryStatistics(6.8, 0.0, 6.8, 6.8);
		TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
		assertEquals(expResult, actualResult);
	}
	
	@Test
    public void testSummaryStatistics_WithTwoArguments() {
        double[] temperatureSeries = {17.5, -10};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics expResult = new TempSummaryStatistics(3.75, 13.75, -10, 17.5);
		TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
		assertEquals(expResult, actualResult);
	}
	
	@Test
    public void testSummaryStatistics_WithPositiveArguments() {
        double[] temperatureSeries = {5.4, 7.3, 9.2, 2.1};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics expResult = new TempSummaryStatistics(6, 2.6220221204, 2.1, 9.2);
		TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
		assertEquals(expResult, actualResult);
	}
	
	@Test
    public void testSummaryStatistics_WithNegativeArguments() {
        double[] temperatureSeries = {-20, -16, -24};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics expResult = new TempSummaryStatistics(-20, 3.2659863237, -24, -16);
		TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
		assertEquals(expResult, actualResult);
	}
	
	@Test
    public void testAddTemps_EmptyList() {
        double[] temperatureSeries = {5, 8, 9, 13};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double[] additionTemps = {};
		int expResult = 4;
        int actualResult = seriesAnalysis.addTemps(additionTemps);
		assertEquals(expResult, actualResult, EPS);
    }
	
	@Test
    public void testAddTemps_OneElement() {
        double[] temperatureSeries = {3, -2, 6.5, 4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double[] additionTemps = {2.5};
		int expResult = 5;
        int actualResult = seriesAnalysis.addTemps(additionTemps);
		assertEquals(expResult, actualResult, EPS);
    }
	
	@Test
    public void testAddTemps_FiveElementsOneIncreasing() {
        double[] temperatureSeries = {8, 12.5, 4, 6, 2, 7};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double[] additionTemps = {13, 17, 12.5, 6, 3};
		int expResult = 11;
        int actualResult = seriesAnalysis.addTemps(additionTemps);
		assertEquals(expResult, actualResult, EPS);
    }
	
	@Test
    public void testAddTemps_IncreaseTwice() {
        double[] temperatureSeries = {6, 2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double[] additionTemps = {19, 14, 5, 18, 4, 6};
		int expResult = 8;
        int actualResult = seriesAnalysis.addTemps(additionTemps);
		assertEquals(expResult, actualResult, EPS);
    }
	
	@Test
    public void testAddTemps_IncreaseThrice() {
        double[] temperatureSeries = {1};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double[] additionTemps = {2, 8, 4, 7, 11.5, 9, 14};
		int expResult = 8;
        int actualResult = seriesAnalysis.addTemps(additionTemps);
		assertEquals(expResult, actualResult, EPS);
    }
	
	@Test
    public void testAddTemps_AddTwice() {
        double[] temperatureSeries = {7, 9, 11, 4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double[] additionTemps = {8, 9, 4, 1.5};
        int actualResult = seriesAnalysis.addTemps(additionTemps);
		double[] additionTemps1 = {4, 2.3, 4.8, 5, 7};
		actualResult = seriesAnalysis.addTemps(additionTemps1);
		int expResult = 13;
		assertEquals(expResult, actualResult, EPS);
    }
	
	@Test(expected = InputMismatchException.class)
    public void testAddTemps_LessThanMinTemp() {
        double[] temperatureSeries = {10, 20};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] additionTemps = {-200, -100, -300, -150};
		int actualResult = seriesAnalysis.addTemps(additionTemps);
    }
	
	@Test
    public void testAddTemps_AddToEmptyList() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] additionTemps = {-200, 300};
		int actualResult = seriesAnalysis.addTemps(additionTemps);
		int expResult = 2;
		assertEquals(expResult, actualResult, EPS);
    }
	
	@Test
    public void testAddTemps_WithLastAppropriateValue() {
        double[] temperatureSeries = {-250, -270, -250};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] additionTemps = {-273, -200};
		int actualResult = seriesAnalysis.addTemps(additionTemps);
		int expResult = 5;
		assertEquals(expResult, actualResult, EPS);
    }
	
	@Test(expected = InputMismatchException.class)
    public void testAddTemps_FirstIntegerInappropriateValue() {
        double[] temperatureSeries = {-100, 150};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] additionTemps = {-274};
		int actualResult = seriesAnalysis.addTemps(additionTemps);
    }
	
	@Test
    public void testAddTemps_VeryCloseToTheEdgeButAppropriate() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] additionTemps = {-272.88, -271.13, -272.99, -272.999, -272.9999};
		int actualResult = seriesAnalysis.addTemps(additionTemps);
		int expResult = 5;
		assertEquals(expResult, actualResult, EPS);
    }
	
	@Test(expected = InputMismatchException.class)
    public void testAddTemps_VeryCloseToTheEdgeInappropriate() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] additionTemps = {-272.63, -272.99, -273, -273.001};
		int actualResult = seriesAnalysis.addTemps(additionTemps);
    }
	
}
