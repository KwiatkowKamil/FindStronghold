public class EnderEyeThrow{
    private double x;
    private double y;
    private double y_angle;
    private double tan;

    public EnderEyeThrow(double[] data){
        this.x = data[0];
        this.y = data[1];
        this.y_angle = data[2];
        this.tan = getTan();
    }

    public double [] getIntersectionWith(EnderEyeThrow other){
        if (isParallelTo(other))
            return getIncorrectResult();
        return getCalculatableIntersection(other);
    }

    private double getTan() {
        return Math.tan(y_angle * Math.PI / 180);
    }

    private boolean isParallelTo(EnderEyeThrow other) {
        return ((y_angle - other.y_angle) % 180) == 0;
    }

    private boolean isVertical() {
        return y_angle%180 == 90;
    }

    private double [] getIncorrectResult() {
        return new double[0];
    }

    private double [] getCalculatableIntersection(EnderEyeThrow other) {
        if (isVertical())
            return other.getIntersectionWithVerticalThrow(this);
        if (other.isVertical())
            return getIntersectionWithVerticalThrow(other);
        return getIntersectionWithComplexThrow(other);
    }

    private double [] getIntersectionWithVerticalThrow(EnderEyeThrow other) {
        double resultX = other.tan * (x - other.x) + y;
        double resultY = other.y;
        return new double[] { resultX, resultY };
    }

    private double [] getIntersectionWithComplexThrow(EnderEyeThrow other) {
        double resultY = (tan*y - other.tan * other.y - x + other.x) / (tan - other.tan);
        double resultX = (resultY - y)*tan + x;
        return new double [] {resultX, resultY};
    }
}