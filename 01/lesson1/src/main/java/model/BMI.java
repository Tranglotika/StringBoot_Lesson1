package model;

public class BMI {
    public int weight;
    public double height;
    /**
     * @param weight
     * @param height
     */
    public BMI(int weight, double height) {
          this.weight = weight;
          this.height = height;
    }
    /**
     * @return the weight
     */
    public int getWeight() {
          return weight;
    }
    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
          this.weight = weight;
    }
    /**
     * @return the height
     */
    public double getHeight() {
          return height;
    }
    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
          this.height = height;
    }
}
