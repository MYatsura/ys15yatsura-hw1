package ua.yandex.shad.tempseries;

public class TempSummaryStatistics {
        
        private static final double EPS = 0.00001;
        
        private final double avgTemp;
        private final double devTemp;
        private final double minTemp;
        private final double maxTemp;

        TempSummaryStatistics() {
            avgTemp = 0;
            devTemp = 0;
            minTemp = 0;
            maxTemp = 0;
        }
        
        TempSummaryStatistics(double avgTemp, double devTemp, 
                              double minTemp, double maxTemp) {
            this.avgTemp = avgTemp;
            this.devTemp = devTemp;
            this.minTemp = minTemp;
            this.maxTemp = maxTemp;
        }
        
        @Override
        public boolean equals(Object obj) {
                TempSummaryStatistics other = (TempSummaryStatistics) obj;
                if (Math.abs(this.avgTemp - other.avgTemp) > EPS) {
                        return false;
                }
                if (Math.abs(this.devTemp - other.devTemp) > EPS) {
                        return false;
                }
                if (Math.abs(this.minTemp - other.minTemp) > EPS) {
                        return false;
                }
                if (Math.abs(this.maxTemp - other.maxTemp) > EPS) {
                        return false;
                }
                return true;
        }
        
        @Override
        public int hashCode() {
            assert false : "hashCode not designed";
            return 42;
        }
         
}
