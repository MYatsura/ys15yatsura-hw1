package ua.yandex.shad.tempseries;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {    

    private static final double MIN_TEMPERATURE = -273;
        
    private static final double EPS = 0.00001;

        private int actualLength;
        
    private double[] temperatureSeries;
       
        
    public TemperatureSeriesAnalysis() {
        temperatureSeries = new double[]{};
                actualLength = 0;
    }
    
    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
                this.temperatureSeries = temperatureSeries; 
                actualLength = temperatureSeries.length;
        }
    
    public double average() {   
                if (actualLength == 0) {
                throw new IllegalArgumentException();
                }
                
                double temperatureSum = 0.0;
                
                for (int i = 0; i < actualLength; i++) {
                        temperatureSum += temperatureSeries[i];
                }
                
                double result = temperatureSum / temperatureSeries.length;

        return result;
    }    
    
    public double deviation() {
        if (actualLength  == 0) {
            throw new IllegalArgumentException();
        }
                
        double expTempSeries = average();
                double sumOfSquares = 0;
        double temp = 0;
                
        for (int i = 0; i < actualLength; i++) {
            temp = temperatureSeries[i];
            sumOfSquares += (temp-expTempSeries)*(temp-expTempSeries);
        }
                
        double result = Math.sqrt(sumOfSquares / temperatureSeries.length);

                
        return result;
    }
    
    public double min() {
                if (actualLength == 0) {
                throw new IllegalArgumentException();
                }
        
                double minTemperature = temperatureSeries[0];
                
                for (int i = 0; i < actualLength; i++) {
                        if (temperatureSeries[i] < minTemperature) {
                                minTemperature = temperatureSeries[i];
                        }
                }
        
        return minTemperature;
    }
     
    public double max() {
                if (actualLength == 0) {
                throw new IllegalArgumentException();
                }
        
                double maxTemperature = temperatureSeries[0];
                
                for (int i = 0; i < actualLength; i++) {
                        if (temperatureSeries[i] > maxTemperature) {
                                maxTemperature = temperatureSeries[i];
                        }
                }
        
        return maxTemperature;
    }
    
    public double findTempClosestToZero() {
                return findTempClosestToValue(0.0);
    }
    
    public double findTempClosestToValue(double tempValue) {
                
                if (actualLength == 0)  {
                throw new IllegalArgumentException();
                }
                
                double closestToValue = temperatureSeries[0];
                double minAbsDist = Math.abs(temperatureSeries[0]-tempValue);
                double absDist = 0.0;
                
                for (int i = 0; i < actualLength; i++) {
                        absDist = Math.abs(temperatureSeries[i]-tempValue);
                        if (absDist < minAbsDist  
                            || (Math.abs(absDist - minAbsDist) < EPS 
                            && closestToValue < temperatureSeries[i])) {
                                closestToValue = temperatureSeries[i];
                                minAbsDist = absDist;
                        }                        
                }
                        
        return closestToValue;
        }
    
    public double[] findTempsLessThen(double tempValue) {
                if (actualLength == 0) {
                throw new IllegalArgumentException();
                }
                
                int tempCount = 0;
                for (int i = 0; i < actualLength; i++) {
                        if (temperatureSeries[i] < tempValue) {
                                tempCount++;
                        }
                }
                
                double[] result = new double[tempCount];
                
                tempCount = 0;
                for (int i = 0; i < actualLength; i++) {
                        if (temperatureSeries[i] < tempValue) { 
                                result[tempCount++] = temperatureSeries[i];
                        }
                }
    
                return result;
        }
    
    public double[] findTempsGreaterThen(double tempValue) {
            if (actualLength == 0) {
                throw new IllegalArgumentException();
            }
                
            int tempCount = 0;
            for (int i = 0; i < actualLength; i++) {
                if (temperatureSeries[i] >= tempValue) {
                    tempCount++;
                }
            }
                
            double[] result = new double[tempCount];
                
            tempCount = 0;
            for (int i = 0; i < actualLength; i++) {
                if (temperatureSeries[i] >= tempValue) {        
                result[tempCount++] = temperatureSeries[i];
            }
        }
        
        return result;
    }
    
    public TempSummaryStatistics summaryStatistics() {
                
                if (actualLength == 0) {
            throw new IllegalArgumentException();
        }
                
                double avgTemp = average();
                double devTemp = deviation();
                double minTemp = min();
                double maxTemp = max();
        return new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
    }
    
    public int addTemps(double ... temps) {
                
                for (double temperature: temps) {
                        if (temperature < MIN_TEMPERATURE) {
                                throw new InputMismatchException();
                        }
                }
        
                int additionalLength = temps.length;        
                int newActualLength = actualLength + additionalLength;
                int arrLength = temperatureSeries.length;
                
                
                while (newActualLength > arrLength) {
                                if (arrLength == 0) {
                                        arrLength = 1;
                                }
                                arrLength *= 2;
                }
                
                if (arrLength > temperatureSeries.length) {
                        double[] newTemperatureSeries = new double[arrLength];
                        for (int i = 0; i < actualLength; i++) {
                                newTemperatureSeries[i] = temperatureSeries[i];
                        }
                        temperatureSeries = newTemperatureSeries;
                }
                
                for (int i = 0; i < temps.length; i++) {
                        temperatureSeries[actualLength + i] = temps[i];
                }
                
                actualLength = newActualLength;
                
        return actualLength;
    }
}
